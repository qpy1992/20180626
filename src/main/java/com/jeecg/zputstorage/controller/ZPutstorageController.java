package com.jeecg.zputstorage.controller;
import com.jeecg.demo.dao.JeecgMinidaoDao;
import com.jeecg.zputstorage.entity.ZPutstorageEntity;
import com.jeecg.zputstorage.service.ZPutstorageServiceI;
import com.jeecg.zputstorage.page.ZPutstoragePage;
import com.jeecg.zputstoragedetail.entity.ZPutstorageDetailEntity;
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
 * @Description: 入库
 * @author onlineGenerator
 * @date 2018-08-24 16:01:08
 * @version V1.0   
 *
 */
@Api(value="ZPutstorage",description="入库",tags="zPutstorageController")
@Controller
@RequestMapping("/zPutstorageController")
public class ZPutstorageController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZPutstorageController.class);

	@Autowired
	private ZPutstorageServiceI zPutstorageService;
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
	 * 入库列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/zputstorage/zPutstorageList");
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
	public void datagrid(ZPutstorageEntity zPutstorage,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZPutstorageEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zPutstorage);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zPutstorageService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	
	@RequestMapping(params = "datagrid2")
	@ResponseBody
	public void datagrid2(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
	//	String fweituo = request.getParameter("");
		Map queryparams =  new LinkedHashMap<String,Object>();
		String sql = "select a.id,code,make_date makedate,make_people makepeople,check_people checkpeople,check_date checkdate,wulio_code wuliocode,wulio_name wulioname,specifications,unit,rk_number rknumber,purchase_price purchaseprice,purchase_total purchasetotal,sale_price saleprice,sale_total saleTotal,purchase_date purchasedate,b.note from z_putstorage a inner join z_putstorage_detail b on b.fid=a.id";
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
	 * 删除入库
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZPutstorageEntity zPutstorage, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		zPutstorage = systemService.getEntity(ZPutstorageEntity.class, zPutstorage.getId());
		String message = "入库删除成功";
		try{
			zPutstorageService.delMain(zPutstorage);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "入库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除入库
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "入库删除成功";
		try{
			for(String id:ids.split(",")){
				ZPutstorageEntity zPutstorage = systemService.getEntity(ZPutstorageEntity.class,
				id
				);
				zPutstorageService.delMain(zPutstorage);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "入库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加入库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZPutstorageEntity zPutstorage,ZPutstoragePage zPutstoragePage, HttpServletRequest request) {
		List<ZPutstorageDetailEntity> zPutstorageDetailList =  zPutstoragePage.getZPutstorageDetailList();
		 System.out.println("zPutstorageDetailList=="+zPutstorageDetailList);
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			zPutstorageService.addMain(zPutstorage, zPutstorageDetailList);
			
			  for(int i=0;i<zPutstorageDetailList.size();i++)
			  {
	
			 String wulioName=zPutstorageDetailList.get(i).getWulioName();
			  String specifications=zPutstorageDetailList.get(i).getSpecifications();
			  String unit=zPutstorageDetailList.get(i).getUnit();
			  Double purchasePrice=zPutstorageDetailList.get(i).getPurchasePrice();
			  Integer rkNumber=zPutstorageDetailList.get(i).getRkNumber();
			  Double purchaseTotal=zPutstorageDetailList.get(i).getPurchaseTotal();
			  
			int count=jeecgMinidaoDao.getStore(wulioName);
			
			  System.out.println("count==="+count);
			  if(count==1)
			  {
					int number=jeecgMinidaoDao.getStorenumber(wulioName);
					
					int number2=number+rkNumber;
					
					double money=number2*purchasePrice;
				
				  jdbcTemplate.execute("update z_store set rk_number ="+number2+",purchase_total ="+money+" where fname='"+wulioName+"'");
			  }
			  else
			  {
				  jdbcTemplate.execute("insert into z_store(id,fname,specifications,unit,purchase_price,rk_number,purchase_total) values ('"+UUID.randomUUID()+"','"+wulioName+"','"+specifications+"','"+unit+"','"+purchasePrice+"','"+rkNumber+"','"+purchaseTotal+"')");
			  }
			  }
			
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "入库添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新入库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZPutstorageEntity zPutstorage,ZPutstoragePage zPutstoragePage, HttpServletRequest request) {
		List<ZPutstorageDetailEntity> zPutstorageDetailList =  zPutstoragePage.getZPutstorageDetailList();
		System.out.println("zPutstorageDetailList==&&=="+zPutstorageDetailList);
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			  String fid=zPutstorage.getId();
	  //		int countnumber=jeecgMinidaoDao.getPutstorage(fid);
			  for(int i=0;i<zPutstorageDetailList.size();i++)
			  {
				  String id=zPutstorageDetailList.get(i).getId();
				  String wulioName=zPutstorageDetailList.get(i).getWulioName();
				  int oldnumber=0;
				  try
				  {
					  oldnumber=jeecgMinidaoDao.getPutstorage(fid,wulioName);
				  }catch(Exception e){
						e.printStackTrace();
						
				  }
				
				    System.out.println("oldnumber=="+oldnumber);
				    
				/*    Integer newnumber=0;
				    Double purchasePrice=0.0;*/
				    Integer newnumber=zPutstorageDetailList.get(i).getRkNumber();
				    Double  purchasePrice=zPutstorageDetailList.get(i).getPurchasePrice();
				    String specifications=zPutstorageDetailList.get(i).getSpecifications();
					  String unit=zPutstorageDetailList.get(i).getUnit();
					  Double purchaseTotal=zPutstorageDetailList.get(i).getPurchaseTotal();
					  
				    if(oldnumber !=0)
				    {
				    	/*  newnumber=zPutstorageDetailList.get(i).getRkNumber();
						  purchasePrice=zPutstorageDetailList.get(i).getPurchasePrice();*/
						
					  	int  number=newnumber-oldnumber;
					  	double money=number*purchasePrice;
						  jdbcTemplate.execute("update z_store set rk_number =rk_number+"+number+",purchase_total=purchase_total+"+money+" where fname='"+wulioName+"'");
				    }
				    else
				    {
				    	int count=jeecgMinidaoDao.getStore(wulioName);
						  if(count==1)
						  {
								int number=jeecgMinidaoDao.getStorenumber(wulioName);
								
								int number2=number+newnumber;
								
								double money=number2*purchasePrice;
							
							  jdbcTemplate.execute("update z_store set rk_number ="+number2+",purchase_total ="+money+" where fname='"+wulioName+"'");
						  }
						  else
						  {
							  jdbcTemplate.execute("insert into z_store(id,fname,specifications,unit,purchase_price,rk_number,purchase_total) values ('"+UUID.randomUUID()+"','"+wulioName+"','"+specifications+"','"+unit+"','"+purchasePrice+"','"+newnumber+"','"+purchaseTotal+"')");
						  }	
				    }
			  }
		
			 
			zPutstorageService.updateMain(zPutstorage, zPutstorageDetailList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新入库失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 入库新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZPutstorageEntity zPutstorage, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zPutstorage.getId())) {
			zPutstorage = zPutstorageService.getEntity(ZPutstorageEntity.class, zPutstorage.getId());
			req.setAttribute("zPutstoragePage", zPutstorage);
		}
		return new ModelAndView("com/jeecg/zputstorage/zPutstorage-add");
	}
	
	/**
	 * 入库编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZPutstorageEntity zPutstorage, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zPutstorage.getId())) {
			zPutstorage = zPutstorageService.getEntity(ZPutstorageEntity.class, zPutstorage.getId());
			req.setAttribute("zPutstoragePage", zPutstorage);
		}
		return new ModelAndView("com/jeecg/zputstorage/zPutstorage-update");
	}
	
	
	/**
	 * 加载明细列表[入库明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zPutstorageDetailList")
	public ModelAndView zPutstorageDetailList(ZPutstorageEntity zPutstorage, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = zPutstorage.getId();
		//===================================================================================
		//查询-入库明细
	    String hql0 = "from ZPutstorageDetailEntity where 1 = 1 AND fID = ? ";
	    try{
	    	List<ZPutstorageDetailEntity> zPutstorageDetailEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("zPutstorageDetailList", zPutstorageDetailEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/zputstoragedetail/zPutstorageDetailList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(ZPutstorageEntity zPutstorage,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(ZPutstorageEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zPutstorage);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<ZPutstorageEntity> list=this.zPutstorageService.getListByCriteriaQuery(cq, false);
    	List<ZPutstoragePage> pageList=new ArrayList<ZPutstoragePage>();
        if(list!=null&&list.size()>0){
        	for(ZPutstorageEntity entity:list){
        		try{
        		ZPutstoragePage page=new ZPutstoragePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from ZPutstorageDetailEntity where 1 = 1 AND fID = ? ";
        	        List<ZPutstorageDetailEntity> zPutstorageDetailEntityList = systemService.findHql(hql0,id0);
            		page.setZPutstorageDetailList(zPutstorageDetailEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"入库");
        map.put(NormalExcelConstants.CLASS,ZPutstoragePage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("入库列表", "导出人:Jeecg",
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
				List<ZPutstoragePage> list =  ExcelImportUtil.importExcel(file.getInputStream(), ZPutstoragePage.class, params);
				ZPutstorageEntity entity1=null;
				for (ZPutstoragePage page : list) {
					entity1=new ZPutstorageEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            zPutstorageService.addMain(entity1, page.getZPutstorageDetailList());
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
		map.put(NormalExcelConstants.FILE_NAME,"入库");
		map.put(NormalExcelConstants.CLASS,ZPutstoragePage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("入库列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "zPutstorageController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="入库列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ZPutstoragePage>> list() {
		List<ZPutstorageEntity> list= zPutstorageService.getList(ZPutstorageEntity.class);
    	List<ZPutstoragePage> pageList=new ArrayList<ZPutstoragePage>();
        if(list!=null&&list.size()>0){
        	for(ZPutstorageEntity entity:list){
        		try{
        			ZPutstoragePage page=new ZPutstoragePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from ZPutstorageDetailEntity where 1 = 1 AND fID = ? ";
	    			List<ZPutstorageDetailEntity> zPutstorageDetailOldList = this.zPutstorageService.findHql(hql0,id0);
            		page.setZPutstorageDetailList(zPutstorageDetailOldList);
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
	@ApiOperation(value="根据ID获取入库信息",notes="根据ID获取入库信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ZPutstorageEntity task = zPutstorageService.get(ZPutstorageEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取入库信息为空");
		}
		ZPutstoragePage page = new ZPutstoragePage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from ZPutstorageDetailEntity where 1 = 1 AND fID = ? ";
			List<ZPutstorageDetailEntity> zPutstorageDetailOldList = this.zPutstorageService.findHql(hql0,id0);
    		page.setZPutstorageDetailList(zPutstorageDetailOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建入库")
	public ResponseMessage<?> create(@ApiParam(name="入库对象")@RequestBody ZPutstoragePage zPutstoragePage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZPutstoragePage>> failures = validator.validate(zPutstoragePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ZPutstorageDetailEntity> zPutstorageDetailList =  zPutstoragePage.getZPutstorageDetailList();
		
		ZPutstorageEntity zPutstorage = new ZPutstorageEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(zPutstoragePage,zPutstorage);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存入库失败");
        }
		zPutstorageService.addMain(zPutstorage, zPutstorageDetailList);

		return Result.success(zPutstorage);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新入库",notes="更新入库")
	public ResponseMessage<?> update(@RequestBody ZPutstoragePage zPutstoragePage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZPutstoragePage>> failures = validator.validate(zPutstoragePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ZPutstorageDetailEntity> zPutstorageDetailList =  zPutstoragePage.getZPutstorageDetailList();
		
		ZPutstorageEntity zPutstorage = new ZPutstorageEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(zPutstoragePage,zPutstorage);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("入库更新失败");
        }
		zPutstorageService.updateMain(zPutstorage, zPutstorageDetailList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除入库")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			ZPutstorageEntity zPutstorage = zPutstorageService.get(ZPutstorageEntity.class, id);
			zPutstorageService.delMain(zPutstorage);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("入库删除失败");
		}

		return Result.success();
	}
}
