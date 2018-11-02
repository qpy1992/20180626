package com.jeecg.hetong.controller;
import com.jeecg.hetong.entity.HetongEntity;
import com.jeecg.hetong.service.HetongServiceI;
import com.jeecg.hetong.page.HetongPage;
import com.jeecg.hetong1.entity.Hetong1Entity;
import com.jeecg.hetong2.entity.Hetong2Entity;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
 * @Description: 合同维护
 * @author onlineGenerator
 * @date 2018-07-09 09:03:41
 * @version V1.0   
 *
 */
@Api(value="Hetong",description="合同维护",tags="hetongController")
@Controller
@RequestMapping("/hetongController")
public class HetongController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HetongController.class);

	@Autowired
	private HetongServiceI hetongService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private Validator validator;

	/**
	 * 合同维护列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/hetong/hetongList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param hetong
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(HetongEntity hetong,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HetongEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hetong);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hetongService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除合同维护
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HetongEntity hetong, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		hetong = systemService.getEntity(HetongEntity.class, hetong.getId());
		String message = "合同维护删除成功";
		try{
			hetongService.delMain(hetong);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "合同维护删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除合同维护
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "合同维护删除成功";
		try{
			for(String id:ids.split(",")){
				HetongEntity hetong = systemService.getEntity(HetongEntity.class,
				id
				);
				hetongService.delMain(hetong);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "合同维护删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加合同维护
	 * 
	 * @param hetong
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HetongEntity hetong,HetongPage hetongPage, HttpServletRequest request) {
		List<Hetong1Entity> hetong1List =  hetongPage.getHetong1List();
		List<Hetong2Entity> hetong2List =  hetongPage.getHetong2List();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
		    hetong.setFbillno(systemService.getFbillno(45));
			hetongService.addMain(hetong, hetong1List,hetong2List);
			if(hetong.getFbrno()!=null) {
				jdbcTemplate.execute("update z_custom_entrust set fcontractno='" + hetong.getFbillno() + "' where fbillno='" + hetong.getFbrno() + "'");
			}
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "合同维护添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新合同维护
	 * 
	 * @param hetong
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HetongEntity hetong,HetongPage hetongPage, HttpServletRequest request) {
		List<Hetong1Entity> hetong1List =  hetongPage.getHetong1List();
		List<Hetong2Entity> hetong2List =  hetongPage.getHetong2List();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			hetongService.updateMain(hetong, hetong1List,hetong2List);
			if(hetong.getFbrno()!=null) {
				jdbcTemplate.execute("update z_custom_entrust set fcontractno='" + hetong.getFbillno() + "' where fbillno='" + hetong.getFbrno() + "'");
			}
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新合同维护失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 合同维护新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HetongEntity hetong, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hetong.getId())) {
			hetong = hetongService.getEntity(HetongEntity.class, hetong.getId());
			req.setAttribute("hetongPage", hetong);
		}
		return new ModelAndView("com/jeecg/hetong/hetong-add");
	}
	
	/**
	 * 合同维护编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HetongEntity hetong, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hetong.getId())) {
			hetong = hetongService.getEntity(HetongEntity.class, hetong.getId());
			req.setAttribute("hetongPage", hetong);
		}
		return new ModelAndView("com/jeecg/hetong/hetong-update");
	}
	
	
	/**
	 * 加载明细列表[门点信息]
	 * 
	 * @return
	 */
	@RequestMapping(params = "hetong1List")
	public ModelAndView hetong1List(HetongEntity hetong, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = hetong.getId();
		//===================================================================================
		//查询-门点信息
	    String hql0 = "from Hetong1Entity where 1 = 1 AND fID = ? ";
	    try{
	    	List<Hetong1Entity> hetong1EntityList = systemService.findHql(hql0,id0);
			req.setAttribute("hetong1List", hetong1EntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/hetong1/hetong1List");
	}
	/**
	 * 加载明细列表[价格要素及费率]
	 * 
	 * @return
	 */
	@RequestMapping(params = "hetong2List")
	public ModelAndView hetong2List(HetongEntity hetong, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = hetong.getId();
		//===================================================================================
		//查询-价格要素及费率
	    String hql1 = "from Hetong2Entity where 1 = 1 AND fID = ? ";
	    try{
	    	List<Hetong2Entity> hetong2EntityList = systemService.findHql(hql1,id1);
			req.setAttribute("hetong2List", hetong2EntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/hetong2/hetong2List");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(HetongEntity hetong,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(HetongEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hetong);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<HetongEntity> list=this.hetongService.getListByCriteriaQuery(cq, false);
    	List<HetongPage> pageList=new ArrayList<HetongPage>();
        if(list!=null&&list.size()>0){
        	for(HetongEntity entity:list){
        		try{
        		HetongPage page=new HetongPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from Hetong1Entity where 1 = 1 AND fID = ? ";
        	        List<Hetong1Entity> hetong1EntityList = systemService.findHql(hql0,id0);
            		page.setHetong1List(hetong1EntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from Hetong2Entity where 1 = 1 AND fID = ? ";
        	        List<Hetong2Entity> hetong2EntityList = systemService.findHql(hql1,id1);
            		page.setHetong2List(hetong2EntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"合同维护");
        map.put(NormalExcelConstants.CLASS,HetongPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("合同维护列表", "导出人:Jeecg",
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
				List<HetongPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), HetongPage.class, params);
				HetongEntity entity1=null;
				for (HetongPage page : list) {
					entity1=new HetongEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            hetongService.addMain(entity1, page.getHetong1List(),page.getHetong2List());
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
		map.put(NormalExcelConstants.FILE_NAME,"合同维护");
		map.put(NormalExcelConstants.CLASS,HetongPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("合同维护列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "hetongController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="合同维护列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<HetongPage>> list() {
		List<HetongEntity> list= hetongService.getList(HetongEntity.class);
    	List<HetongPage> pageList=new ArrayList<HetongPage>();
        if(list!=null&&list.size()>0){
        	for(HetongEntity entity:list){
        		try{
        			HetongPage page=new HetongPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
				     String hql0 = "from Hetong1Entity where 1 = 1 AND fID = ? ";
	    			List<Hetong1Entity> hetong1OldList = this.hetongService.findHql(hql0,id0);
            		page.setHetong1List(hetong1OldList);
				     String hql1 = "from Hetong2Entity where 1 = 1 AND fID = ? ";
	    			List<Hetong2Entity> hetong2OldList = this.hetongService.findHql(hql1,id1);
            		page.setHetong2List(hetong2OldList);
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
	@ApiOperation(value="根据ID获取合同维护信息",notes="根据ID获取合同维护信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		HetongEntity task = hetongService.get(HetongEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取合同维护信息为空");
		}
		HetongPage page = new HetongPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
		    String hql0 = "from Hetong1Entity where 1 = 1 AND fID = ? ";
			List<Hetong1Entity> hetong1OldList = this.hetongService.findHql(hql0,id0);
    		page.setHetong1List(hetong1OldList);
		    String hql1 = "from Hetong2Entity where 1 = 1 AND fID = ? ";
			List<Hetong2Entity> hetong2OldList = this.hetongService.findHql(hql1,id1);
    		page.setHetong2List(hetong2OldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建合同维护")
	public ResponseMessage<?> create(@ApiParam(name="合同维护对象")@RequestBody HetongPage hetongPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<HetongPage>> failures = validator.validate(hetongPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<Hetong1Entity> hetong1List =  hetongPage.getHetong1List();
		List<Hetong2Entity> hetong2List =  hetongPage.getHetong2List();
		
		HetongEntity hetong = new HetongEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(hetongPage,hetong);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存合同维护失败");
        }
		hetongService.addMain(hetong, hetong1List,hetong2List);

		return Result.success(hetong);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新合同维护",notes="更新合同维护")
	public ResponseMessage<?> update(@RequestBody HetongPage hetongPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<HetongPage>> failures = validator.validate(hetongPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<Hetong1Entity> hetong1List =  hetongPage.getHetong1List();
		List<Hetong2Entity> hetong2List =  hetongPage.getHetong2List();
		
		HetongEntity hetong = new HetongEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(hetongPage,hetong);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("合同维护更新失败");
        }
		hetongService.updateMain(hetong, hetong1List,hetong2List);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除合同维护")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			HetongEntity hetong = hetongService.get(HetongEntity.class, id);
			hetongService.delMain(hetong);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("合同维护删除失败");
		}

		return Result.success();
	}
}
