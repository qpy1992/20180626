package com.jeecg.custom.controller;
import com.jeecg.custom.entity.CustomEntity;
import com.jeecg.custom.service.CustomServiceI;
import com.jeecg.custom.page.CustomPage;
import com.jeecg.cuscontact.entity.CustomContactsEntity;
import com.jeecg.cussales.entity.CustomSalesmanEntity;
import java.io.PrintWriter;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.Consts;
import org.apache.log4j.Logger;
import org.jeecgframework.core.online.util.CgReportQueryParamUtil;
import org.jeecgframework.web.cgreport.service.core.CgReportServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
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

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import org.springframework.http.ResponseEntity;
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
 * @Description: 客户资料维护
 * @author onlineGenerator
 * @date 2018-08-31 16:32:00
 * @version V1.0   
 *
 */
@Api(value="Custom",description="客户资料维护",tags="customController")
@Controller
@RequestMapping("/customController")
public class CustomController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CustomController.class);

	@Autowired
	private CustomServiceI customService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
    private CgReportServiceI cgReportService;

	/**
	 * 客户资料维护列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/custom/customList");
	}

    @RequestMapping(params = "goCombination")
    public ModelAndView goCombination(HttpServletRequest request) {
	    String fid = request.getParameter("fid");
	    request.setAttribute("fid",fid);
        return new ModelAndView("com/jeecg/custom/costCombinationList");
    }


    /**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param custom
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(CustomEntity custom,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, custom);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.customService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}



    @RequestMapping(params = "datagrid2")
    public void datagrid2(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        String fid = request.getParameter("fid");
        String sql = "select a.id,a.fcost,b.fyard_name ftxyard,c.fdp_name fload,c.faddress fzhdpdz,c.fdeliver_unit fzhunit,d.fcontact_name fzhcontact,d.fmobile fzhmobile,e.fdp_name fdischarge,e.faddress fxhdpdz,e.fdeliver_unit fxhunit,f.fcontact_name fxhcontact,f.fmobile fxhmobile,g.fyard_name fhxyard from z_cost_combination a left join z_yard b on b.id=a.ftxid left join z_door_point c on c.id=a.fzhid left join z_dp_contact d on d.fid=c.id and d.fdefault='Y' left join z_door_point e on e.id=a.fxhid left join z_dp_contact f on f.fid=e.id and f.fdefault='Y' left join z_yard g on g.id=a.fhxid where a.fid='"+fid+"'";
        Map queryparams =  new LinkedHashMap<String,Object>();
        List<Map<String, Object>> result= cgReportService.queryByCgReportSql(sql, queryparams, dataGrid.getPage(), dataGrid.getRows());
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
	 * 删除客户资料维护
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CustomEntity custom, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		custom = systemService.getEntity(CustomEntity.class, custom.getId());
		String message = "客户资料维护删除成功";
		try{
			customService.delMain(custom);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户资料维护删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除客户资料维护
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "客户资料维护删除成功";
		try{
			for(String id:ids.split(",")){
				CustomEntity custom = systemService.getEntity(CustomEntity.class,
				id
				);
				customService.delMain(custom);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "客户资料维护删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加客户资料维护
	 * 
	 * @param custom
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CustomEntity custom,CustomPage customPage, HttpServletRequest request) {
		List<CustomContactsEntity> customContactsList =  customPage.getCustomContactsList();
		List<CustomSalesmanEntity> customSalesmanList =  customPage.getCustomSalesmanList();
//		List<CostCombinationEntity> costCombinationList =  customPage.getCostCombinationList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
		    custom.setFcustomCode(systemService.getFcode(97));
		    custom.setFcountry(custom.getProvince()+custom.getCity()+custom.getArea());
			customService.addMain(custom, customContactsList,customSalesmanList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			jdbcTemplate.execute("update t_billCodeRule set FProjectVal=FProjectVal+1 where FbillType=97 and FProjectID=3");
		}catch(Exception e){
			e.printStackTrace();
			message = "客户资料维护添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新客户资料维护
	 * 
	 * @param custom
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CustomEntity custom,CustomPage customPage, HttpServletRequest request) {
		List<CustomContactsEntity> customContactsList =  customPage.getCustomContactsList();
		List<CustomSalesmanEntity> customSalesmanList =  customPage.getCustomSalesmanList();
//		List<CostCombinationEntity> costCombinationList =  customPage.getCostCombinationList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			customService.updateMain(custom, customContactsList,customSalesmanList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新客户资料维护失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 客户资料维护新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CustomEntity custom, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(custom.getId())) {
			custom = customService.getEntity(CustomEntity.class, custom.getId());
			req.setAttribute("customPage", custom);
		}
		return new ModelAndView("com/jeecg/custom/custom-add");
	}
	
	/**
	 * 客户资料维护编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CustomEntity custom, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(custom.getId())) {
			custom = customService.getEntity(CustomEntity.class, custom.getId());
			req.setAttribute("customPage", custom);
		}
		return new ModelAndView("com/jeecg/custom/custom-update");
	}

	/**
	 * 加载明细列表[联系人]
	 * 
	 * @return
	 */
	@RequestMapping(params = "customContactsList")
	public ModelAndView customContactsList(CustomEntity custom, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = custom.getId();
		//===================================================================================
		//查询-联系人
	    String hql0 = "from CustomContactsEntity where 1 = 1 AND fID = ? ";
	    try{
	    	List<CustomContactsEntity> customContactsEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("customContactsList", customContactsEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/cuscontact/customContactsList");
	}
	/**
	 * 加载明细列表[业务员]
	 * 
	 * @return
	 */
	@RequestMapping(params = "customSalesmanList")
	public ModelAndView customSalesmanList(CustomEntity custom, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = custom.getId();
		//===================================================================================
		//查询-业务员
	    String hql1 = "from CustomSalesmanEntity where 1 = 1 AND fID = ? ";
	    try{
	    	List<CustomSalesmanEntity> customSalesmanEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("customSalesmanList", customSalesmanEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/cussales/customSalesmanList");
	}
	/**
	 * 加载明细列表[费用组合]
	 * 
	 * @return
	 */
//	@RequestMapping(params = "costCombinationList")
//	public ModelAndView costCombinationList(CustomEntity custom, HttpServletRequest req) {
//
//		//===================================================================================
//		//获取参数
//		Object id2 = custom.getId();
//		//===================================================================================
//		//查询-费用组合
//	    String hql2 = "from CostCombinationEntity where 1 = 1 AND fID = ? ";
//	    try{
//	    	List<CostCombinationEntity> costCombinationEntityList = systemService.findHql(hql2,id2);
//			req.setAttribute("costCombinationList", costCombinationEntityList);
//		}catch(Exception e){
//			logger.info(e.getMessage());
//		}
//		return new ModelAndView("com/jeecg/costcom/costCombinationList");
//	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(CustomEntity custom,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(CustomEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, custom);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<CustomEntity> list=this.customService.getListByCriteriaQuery(cq, false);
    	List<CustomPage> pageList=new ArrayList<CustomPage>();
        if(list!=null&&list.size()>0){
        	for(CustomEntity entity:list){
        		try{
        		CustomPage page=new CustomPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from CustomContactsEntity where 1 = 1 AND fID = ? ";
        	        List<CustomContactsEntity> customContactsEntityList = systemService.findHql(hql0,id0);
            		page.setCustomContactsList(customContactsEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from CustomSalesmanEntity where 1 = 1 AND fID = ? ";
        	        List<CustomSalesmanEntity> customSalesmanEntityList = systemService.findHql(hql1,id1);
            		page.setCustomSalesmanList(customSalesmanEntityList);
//            	    Object id2 = entity.getId();
//				    String hql2 = "from CostCombinationEntity where 1 = 1 AND fID = ? ";
//        	        List<CostCombinationEntity> costCombinationEntityList = systemService.findHql(hql2,id2);
//            		page.setCostCombinationList(costCombinationEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"客户资料维护");
        map.put(NormalExcelConstants.CLASS,CustomPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("客户资料维护列表", "导出人:Jeecg",
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
				List<CustomPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), CustomPage.class, params);
				CustomEntity entity1=null;
				for (CustomPage page : list) {
					entity1=new CustomEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            customService.addMain(entity1, page.getCustomContactsList(),page.getCustomSalesmanList());
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
		map.put(NormalExcelConstants.FILE_NAME,"客户资料维护");
		map.put(NormalExcelConstants.CLASS,CustomPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("客户资料维护列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "customController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="客户资料维护列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CustomPage>> list() {
		List<CustomEntity> list= customService.getList(CustomEntity.class);
    	List<CustomPage> pageList=new ArrayList<CustomPage>();
        if(list!=null&&list.size()>0){
        	for(CustomEntity entity:list){
        		try{
        			CustomPage page=new CustomPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
					Object id2 = entity.getId();
				     String hql0 = "from CustomContactsEntity where 1 = 1 AND fID = ? ";
	    			List<CustomContactsEntity> customContactsOldList = this.customService.findHql(hql0,id0);
            		page.setCustomContactsList(customContactsOldList);
				     String hql1 = "from CustomSalesmanEntity where 1 = 1 AND fID = ? ";
	    			List<CustomSalesmanEntity> customSalesmanOldList = this.customService.findHql(hql1,id1);
            		page.setCustomSalesmanList(customSalesmanOldList);
//				     String hql2 = "from CostCombinationEntity where 1 = 1 AND fID = ? ";
//	    			List<CostCombinationEntity> costCombinationOldList = this.customService.findHql(hql2,id2);
//            		page.setCostCombinationList(costCombinationOldList);
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
	@ApiOperation(value="根据ID获取客户资料维护信息",notes="根据ID获取客户资料维护信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CustomEntity task = customService.get(CustomEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取客户资料维护信息为空");
		}
		CustomPage page = new CustomPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
				Object id2 = task.getId();
		    String hql0 = "from CustomContactsEntity where 1 = 1 AND fID = ? ";
			List<CustomContactsEntity> customContactsOldList = this.customService.findHql(hql0,id0);
    		page.setCustomContactsList(customContactsOldList);
		    String hql1 = "from CustomSalesmanEntity where 1 = 1 AND fID = ? ";
			List<CustomSalesmanEntity> customSalesmanOldList = this.customService.findHql(hql1,id1);
    		page.setCustomSalesmanList(customSalesmanOldList);
//		    String hql2 = "from CostCombinationEntity where 1 = 1 AND fID = ? ";
//			List<CostCombinationEntity> costCombinationOldList = this.customService.findHql(hql2,id2);
//    		page.setCostCombinationList(costCombinationOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建客户资料维护")
	public ResponseMessage<?> create(@ApiParam(name="客户资料维护对象")@RequestBody CustomPage customPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomPage>> failures = validator.validate(customPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CustomContactsEntity> customContactsList =  customPage.getCustomContactsList();
		List<CustomSalesmanEntity> customSalesmanList =  customPage.getCustomSalesmanList();
//		List<CostCombinationEntity> costCombinationList =  customPage.getCostCombinationList();
		
		CustomEntity custom = new CustomEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customPage,custom);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存客户资料维护失败");
        }
		customService.addMain(custom, customContactsList,customSalesmanList);

		return Result.success(custom);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新客户资料维护",notes="更新客户资料维护")
	public ResponseMessage<?> update(@RequestBody CustomPage customPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomPage>> failures = validator.validate(customPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CustomContactsEntity> customContactsList =  customPage.getCustomContactsList();
		List<CustomSalesmanEntity> customSalesmanList =  customPage.getCustomSalesmanList();
//		List<CostCombinationEntity> costCombinationList =  customPage.getCostCombinationList();
		
		CustomEntity custom = new CustomEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customPage,custom);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("客户资料维护更新失败");
        }
		customService.updateMain(custom, customContactsList,customSalesmanList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除客户资料维护")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			CustomEntity custom = customService.get(CustomEntity.class, id);
			customService.delMain(custom);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("客户资料维护删除失败");
		}

		return Result.success();
	}
}
