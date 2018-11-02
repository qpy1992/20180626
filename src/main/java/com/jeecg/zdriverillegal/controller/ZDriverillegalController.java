package com.jeecg.zdriverillegal.controller;
import com.jeecg.zdriverillegal.entity.ZDriverillegalEntity;
import com.jeecg.zdriverillegal.service.ZDriverillegalServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

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
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 驾驶人违法
 * @author onlineGenerator
 * @date 2018-09-18 15:42:01
 * @version V1.0   
 *
 */
@Api(value="ZDriverillegal",description="驾驶人违法",tags="zDriverillegalController")
@Controller
@RequestMapping("/zDriverillegalController")
public class ZDriverillegalController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZDriverillegalController.class);

	@Autowired
	private ZDriverillegalServiceI zDriverillegalService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	@Resource
	JdbcTemplate jdbcTemplate;

	/**
	 * 驾驶人违法列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/zdriverillegal/zDriverillegalList");
	}
	
	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request) {
		request.setAttribute("pid", request.getParameter("pid"));
		return new ModelAndView("com/jeecg/zdriverillegal/zDriverillegalList2");
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
	public void datagrid(ZDriverillegalEntity zDriverillegal,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZDriverillegalEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zDriverillegal, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zDriverillegalService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params = "datagrid2")
	public void datagrid2(ZDriverillegalEntity zDriverillegal,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZDriverillegalEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zDriverillegal, request.getParameterMap());
		try{
		//自定义追加查询条件
			String driverId=request.getParameter("pid");
			 System.out.println("driverId"+driverId);
			cq.eq("driverId", driverId);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zDriverillegalService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除驾驶人违法
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZDriverillegalEntity zDriverillegal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		zDriverillegal = systemService.getEntity(ZDriverillegalEntity.class, zDriverillegal.getId());
		message = "驾驶人违法删除成功";
		try{
			zDriverillegalService.delete(zDriverillegal);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "驾驶人违法删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除驾驶人违法
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "驾驶人违法删除成功";
		try{
			for(String id:ids.split(",")){
				ZDriverillegalEntity zDriverillegal = systemService.getEntity(ZDriverillegalEntity.class, 
				id
				);
				zDriverillegalService.delete(zDriverillegal);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "驾驶人违法删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加驾驶人违法
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZDriverillegalEntity zDriverillegal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "驾驶人违法添加成功";
		try{
			zDriverillegalService.save(zDriverillegal);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "驾驶人违法添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doAdd2")
	@ResponseBody
	public AjaxJson doAdd2(ZDriverillegalEntity zDriverillegal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "驾驶人违法添加成功";
		try{
			String pid=request.getParameter("pid");
			String fname =  jdbcTemplate.queryForObject("select fname  from z_driverdetail where  id= ?", String.class,pid);
			String licenseNo =  jdbcTemplate.queryForObject("select license_no  from z_driverdetail where  id= ?", String.class,pid);
			zDriverillegal.setDriverId(pid);
			zDriverillegal.setDriverName(fname);
			zDriverillegal.setCardNo(licenseNo);
			zDriverillegalService.save(zDriverillegal);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "驾驶人违法添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新驾驶人违法
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZDriverillegalEntity zDriverillegal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "驾驶人违法更新成功";
		ZDriverillegalEntity t = zDriverillegalService.get(ZDriverillegalEntity.class, zDriverillegal.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(zDriverillegal, t);
			zDriverillegalService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "驾驶人违法更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "doUpdate2")
	@ResponseBody
	public AjaxJson doUpdate2(ZDriverillegalEntity zDriverillegal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "驾驶人违法更新成功";
		ZDriverillegalEntity t = zDriverillegalService.get(ZDriverillegalEntity.class, zDriverillegal.getId());
		try {
			String pid=request.getParameter("pid");
			t.setDriverId(pid);
			String fname =  jdbcTemplate.queryForObject("select fname  from z_driverdetail where  id= ?", String.class,pid);
			String licenseNo =  jdbcTemplate.queryForObject("select license_no  from z_driverdetail where  id= ?", String.class,pid);
			t.setDriverName(fname);
			t.setCardNo(licenseNo);
			MyBeanUtils.copyBeanNotNull2Bean(zDriverillegal, t);
			zDriverillegalService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "驾驶人违法更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 驾驶人违法新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZDriverillegalEntity zDriverillegal, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zDriverillegal.getId())) {
			zDriverillegal = zDriverillegalService.getEntity(ZDriverillegalEntity.class, zDriverillegal.getId());
			req.setAttribute("zDriverillegalPage", zDriverillegal);
		}
		return new ModelAndView("com/jeecg/zdriverillegal/zDriverillegal-add");
	}
	
	
	@RequestMapping(params = "goAdd2")
	public ModelAndView goAdd2(ZDriverillegalEntity zDriverillegal, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zDriverillegal.getId())) {
			zDriverillegal = zDriverillegalService.getEntity(ZDriverillegalEntity.class, zDriverillegal.getId());
			req.setAttribute("zDriverillegalPage", zDriverillegal);
		}
		req.setAttribute("pid", req.getParameter("pid"));
		return new ModelAndView("com/jeecg/zdriverillegal/zDriverillegal-add2");
	}
	/**
	 * 驾驶人违法编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZDriverillegalEntity zDriverillegal, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zDriverillegal.getId())) {
			zDriverillegal = zDriverillegalService.getEntity(ZDriverillegalEntity.class, zDriverillegal.getId());
			req.setAttribute("zDriverillegalPage", zDriverillegal);
		}
		return new ModelAndView("com/jeecg/zdriverillegal/zDriverillegal-update2");
	}
	
	@RequestMapping(params = "goUpdate2")
	public ModelAndView goUpdate2(ZDriverillegalEntity zDriverillegal, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zDriverillegal.getId())) {
			zDriverillegal = zDriverillegalService.getEntity(ZDriverillegalEntity.class, zDriverillegal.getId());
			req.setAttribute("zDriverillegalPage", zDriverillegal);
		}
		req.setAttribute("pid", req.getParameter("pid"));
		return new ModelAndView("com/jeecg/zdriverillegal/zDriverillegal-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","zDriverillegalController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ZDriverillegalEntity zDriverillegal,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ZDriverillegalEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zDriverillegal, request.getParameterMap());
		List<ZDriverillegalEntity> zDriverillegals = this.zDriverillegalService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"驾驶人违法");
		modelMap.put(NormalExcelConstants.CLASS,ZDriverillegalEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("驾驶人违法列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,zDriverillegals);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ZDriverillegalEntity zDriverillegal,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"驾驶人违法");
    	modelMap.put(NormalExcelConstants.CLASS,ZDriverillegalEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("驾驶人违法列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
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
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<ZDriverillegalEntity> listZDriverillegalEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ZDriverillegalEntity.class,params);
				for (ZDriverillegalEntity zDriverillegal : listZDriverillegalEntitys) {
					zDriverillegalService.save(zDriverillegal);
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
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="驾驶人违法列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ZDriverillegalEntity>> list() {
		List<ZDriverillegalEntity> listZDriverillegals=zDriverillegalService.getList(ZDriverillegalEntity.class);
		return Result.success(listZDriverillegals);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取驾驶人违法信息",notes="根据ID获取驾驶人违法信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ZDriverillegalEntity task = zDriverillegalService.get(ZDriverillegalEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取驾驶人违法信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建驾驶人违法")
	public ResponseMessage<?> create(@ApiParam(name="驾驶人违法对象")@RequestBody ZDriverillegalEntity zDriverillegal, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZDriverillegalEntity>> failures = validator.validate(zDriverillegal);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			zDriverillegalService.save(zDriverillegal);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("驾驶人违法信息保存失败");
		}
		return Result.success(zDriverillegal);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新驾驶人违法",notes="更新驾驶人违法")
	public ResponseMessage<?> update(@ApiParam(name="驾驶人违法对象")@RequestBody ZDriverillegalEntity zDriverillegal) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZDriverillegalEntity>> failures = validator.validate(zDriverillegal);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			zDriverillegalService.saveOrUpdate(zDriverillegal);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新驾驶人违法信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新驾驶人违法信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除驾驶人违法")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			zDriverillegalService.deleteEntityById(ZDriverillegalEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("驾驶人违法删除失败");
		}

		return Result.success();
	}
}
