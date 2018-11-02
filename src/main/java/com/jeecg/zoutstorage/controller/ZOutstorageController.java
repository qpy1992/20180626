package com.jeecg.zoutstorage.controller;
import com.jeecg.demo.dao.JeecgMinidaoDao;
import com.jeecg.zoutstorage.entity.ZOutstorageEntity;
import com.jeecg.zoutstorage.service.ZOutstorageServiceI;
import com.jeecg.zoutstorage.page.ZOutstoragePage;
import com.jeecg.zoutstoragedetail.entity.ZOutstoragedetailEntity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.online.util.CgReportQueryParamUtil;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.cgreport.service.core.CgReportServiceI;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller
 * @Description: 领用单
 * @author onlineGenerator
 * @date 2018-08-26 15:43:20
 * @version V1.0   
 *
 */
@Api(value="ZOutstorage",description="领用单",tags="zOutstorageController")
@Controller
@RequestMapping("/zOutstorageController")
public class ZOutstorageController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZOutstorageController.class);

	@Autowired
	private ZOutstorageServiceI zOutstorageService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgReportServiceI cgReportService;
	@Resource
	JdbcTemplate jdbcTemplate;
	@Autowired
	private JeecgMinidaoDao jeecgMinidaoDao;

	/**
	 * 领用单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/zoutstorage/zOutstorageList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ZOutstorageEntity zOutstorage,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZOutstorageEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zOutstorage);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zOutstorageService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "datagrid2")
	@ResponseBody
	public void datagrid2(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
	//	String fweituo = request.getParameter("");
		Map queryparams =  new LinkedHashMap<String,Object>();
		String sql = "select a.id id,b.id bid,code,make_date makedate,make_people makepeople,check_people checkpeople,check_date checkdate,carcode,driver,lyperson,lytotal,wulio_code wuliocode,wulio_name wulioname,specifications,unit,number,ly_number lynumber,purchase_price purchaseprice,purchase_total purchasetotal,sale_price saleprice,sale_total saleTotal,profits,b.note from z_outstorage a inner join z_outstoragedetail b on b.fid=a.id";
		List<Map<String, Object>> result= cgReportService.queryByCgReportSql(sql, queryparams, dataGrid.getPage(), dataGrid.getRows());
		logger.info(result);
		Long size = cgReportService.countQueryByCgReportSql(sql, queryparams);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.println(CgReportQueryParamUtil.getJson(result,size));
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				writer.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		TagUtil.datagrid(response, dataGrid);
	}
	/**
	 * 删除领用单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZOutstorageEntity zOutstorage, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		zOutstorage = systemService.getEntity(ZOutstorageEntity.class, zOutstorage.getId());
		String message = "领用单删除成功";
		try{
			zOutstorageService.delMain(zOutstorage);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "领用单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除领用单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "领用单删除成功";
		try{
			for(String id:ids.split(",")){
				ZOutstorageEntity zOutstorage = systemService.getEntity(ZOutstorageEntity.class,
				id
				);
				zOutstorageService.delMain(zOutstorage);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "领用单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加领用单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZOutstorageEntity zOutstorage,ZOutstoragePage zOutstoragePage, HttpServletRequest request) {
		List<ZOutstoragedetailEntity> zOutstoragedetailList =  zOutstoragePage.getZOutstoragedetailList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			
			  for(int i=0;i<zOutstoragedetailList.size();i++)
			  {
	
			 String wulioName=zOutstoragedetailList.get(i).getWulioName();
			  String specifications=zOutstoragedetailList.get(i).getSpecifications();
			  String unit=zOutstoragedetailList.get(i).getUnit();
			  Double purchasePrice=zOutstoragedetailList.get(i).getPurchasePrice();
			  Integer rkNumber=zOutstoragedetailList.get(i).getLyNumber();
			  Double purchaseTotal=zOutstoragedetailList.get(i).getPurchaseTotal();
			  
			int count=jeecgMinidaoDao.getStore(wulioName);
			
			  System.out.println("count==="+count);
			  if(count==1)
			  {
					int number=jeecgMinidaoDao.getStorenumber(wulioName);
					if(number>=rkNumber)
					{
						int number2=number-rkNumber;
						double money=number2*purchasePrice;
						 jdbcTemplate.execute("update z_store set rk_number ="+number2+",purchase_total="+money+" where fname='"+wulioName+"'");
						 zOutstorageService.addMain(zOutstorage, zOutstoragedetailList);
					
					}
					else
					{
						message = "库存不足";
					} 
			  }
			  else
			  {
					message = "无库存";
			  
			  }
			  }
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "领用单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新领用单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZOutstorageEntity zOutstorage,ZOutstoragePage zOutstoragePage, HttpServletRequest request) {
		List<ZOutstoragedetailEntity> zOutstoragedetailList =  zOutstoragePage.getZOutstoragedetailList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			        String fid=zOutstorage.getId();
					  for(int i=0;i<zOutstoragedetailList.size();i++)
					  {
						  String wulioName=zOutstoragedetailList.get(i).getWulioName();
						  int oldnumber=0;
						  try
						  {
							  oldnumber=jeecgMinidaoDao.getOutstorage(fid,wulioName);
						  }catch(Exception e){
								e.printStackTrace();
						  }
						    Integer newnumber=zOutstoragedetailList.get(i).getLyNumber();
						    Double  purchasePrice=zOutstoragedetailList.get(i).getPurchasePrice();
						    if(oldnumber !=0)
						    {			
							  	int  number=oldnumber-newnumber;
							  	double money=number*purchasePrice;
								  jdbcTemplate.execute("update z_store set rk_number =rk_number+"+number+",purchase_total=purchase_total+"+money+" where fname='"+wulioName+"'");
						    }
						    else
						    {
						    	int count=jeecgMinidaoDao.getStore(wulioName);
						    	  if(count==1)
								  {
										int number=jeecgMinidaoDao.getStorenumber(wulioName);
										if(number>=newnumber)
										{
											int number2=number-newnumber;
											double money=number2*purchasePrice;
											 jdbcTemplate.execute("update z_store set rk_number ="+number2+",purchase_total="+money+" where fname='"+wulioName+"'");
											 zOutstorageService.addMain(zOutstorage, zOutstoragedetailList);
										
										}
										else
										{
											message = "库存不足";
										} 
								  }
								  else
								  {
										message = "无库存";
								  
								  }
						    }
					  }
			
			
			
			
			zOutstorageService.updateMain(zOutstorage, zOutstoragedetailList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新领用单失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 领用单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZOutstorageEntity zOutstorage, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zOutstorage.getId())) {
			zOutstorage = zOutstorageService.getEntity(ZOutstorageEntity.class, zOutstorage.getId());
			req.setAttribute("zOutstoragePage", zOutstorage);
		}
		return new ModelAndView("com/jeecg/zoutstorage/zOutstorage-add");
	}
	
	/**
	 * 领用单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZOutstorageEntity zOutstorage, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zOutstorage.getId())) {
			zOutstorage = zOutstorageService.getEntity(ZOutstorageEntity.class, zOutstorage.getId());
			req.setAttribute("zOutstoragePage", zOutstorage);
		}
		return new ModelAndView("com/jeecg/zoutstorage/zOutstorage-update");
	}
	
	
	/**
	 * 加载明细列表[领用明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zOutstoragedetailList")
	public ModelAndView zOutstoragedetailList(ZOutstorageEntity zOutstorage, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = zOutstorage.getId();
		//===================================================================================
		//查询-领用明细
	    String hql0 = "from ZOutstoragedetailEntity where 1 = 1 AND fID = ? ";
	    try{
	    	List<ZOutstoragedetailEntity> zOutstoragedetailEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("zOutstoragedetailList", zOutstoragedetailEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/zoutstoragedetail/zOutstoragedetailList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(ZOutstorageEntity zOutstorage,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(ZOutstorageEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zOutstorage);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<ZOutstorageEntity> list=this.zOutstorageService.getListByCriteriaQuery(cq, false);
    	List<ZOutstoragePage> pageList=new ArrayList<ZOutstoragePage>();
        if(list!=null&&list.size()>0){
        	for(ZOutstorageEntity entity:list){
        		try{
        		ZOutstoragePage page=new ZOutstoragePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from ZOutstoragedetailEntity where 1 = 1 AND fID = ? ";
        	        List<ZOutstoragedetailEntity> zOutstoragedetailEntityList = systemService.findHql(hql0,id0);
            		page.setZOutstoragedetailList(zOutstoragedetailEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"领用单");
        map.put(NormalExcelConstants.CLASS,ZOutstoragePage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("领用单列表", "导出人:Jeecg",
            "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,pageList);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

    /**
	 * 通过excel导入数据
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<ZOutstoragePage> list =  ExcelImportUtil.importExcel(file.getInputStream(), ZOutstoragePage.class, params);
				ZOutstorageEntity entity1=null;
				for (ZOutstoragePage page : list) {
					entity1=new ZOutstorageEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            zOutstorageService.addMain(entity1, page.getZOutstoragedetailList());
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
			return j;
	}
	/**
	* 导出excel 使模板
	*/
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ModelMap map) {
		map.put(NormalExcelConstants.FILE_NAME,"领用单");
		map.put(NormalExcelConstants.CLASS,ZOutstoragePage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("领用单列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
		"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	* 导入功能跳转
	*
	* @return
	*/
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "zOutstorageController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="领用单列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ZOutstoragePage>> list() {
		List<ZOutstorageEntity> list= zOutstorageService.getList(ZOutstorageEntity.class);
    	List<ZOutstoragePage> pageList=new ArrayList<ZOutstoragePage>();
        if(list!=null&&list.size()>0){
        	for(ZOutstorageEntity entity:list){
        		try{
        			ZOutstoragePage page=new ZOutstoragePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from ZOutstoragedetailEntity where 1 = 1 AND fID = ? ";
	    			List<ZOutstoragedetailEntity> zOutstoragedetailOldList = this.zOutstorageService.findHql(hql0,id0);
            		page.setZOutstoragedetailList(zOutstoragedetailOldList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
		return Result.success(pageList);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取领用单信息",notes="根据ID获取领用单信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ZOutstorageEntity task = zOutstorageService.get(ZOutstorageEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取领用单信息为空");
		}
		ZOutstoragePage page = new ZOutstoragePage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from ZOutstoragedetailEntity where 1 = 1 AND fID = ? ";
			List<ZOutstoragedetailEntity> zOutstoragedetailOldList = this.zOutstorageService.findHql(hql0,id0);
    		page.setZOutstoragedetailList(zOutstoragedetailOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建领用单")
	public ResponseMessage<?> create(@ApiParam(name="领用单对象")@RequestBody ZOutstoragePage zOutstoragePage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZOutstoragePage>> failures = validator.validate(zOutstoragePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ZOutstoragedetailEntity> zOutstoragedetailList =  zOutstoragePage.getZOutstoragedetailList();
		
		ZOutstorageEntity zOutstorage = new ZOutstorageEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(zOutstoragePage,zOutstorage);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存领用单失败");
        }
		zOutstorageService.addMain(zOutstorage, zOutstoragedetailList);

		return Result.success(zOutstorage);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新领用单",notes="更新领用单")
	public ResponseMessage<?> update(@RequestBody ZOutstoragePage zOutstoragePage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZOutstoragePage>> failures = validator.validate(zOutstoragePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ZOutstoragedetailEntity> zOutstoragedetailList =  zOutstoragePage.getZOutstoragedetailList();
		
		ZOutstorageEntity zOutstorage = new ZOutstorageEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(zOutstoragePage,zOutstorage);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("领用单更新失败");
        }
		zOutstorageService.updateMain(zOutstorage, zOutstoragedetailList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除领用单")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			ZOutstorageEntity zOutstorage = zOutstorageService.get(ZOutstorageEntity.class, id);
			zOutstorageService.delMain(zOutstorage);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("领用单删除失败");
		}

		return Result.success();
	}
}
