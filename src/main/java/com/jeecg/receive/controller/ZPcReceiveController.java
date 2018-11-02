package com.jeecg.receive.controller;
import com.jeecg.receive.entity.ZPcReceiveEntity;
import com.jeecg.receive.service.ZPcReceiveServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
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
 * @Description: 派车单应收
 * @author onlineGenerator
 * @date 2018-07-31 16:23:21
 * @version V1.0   
 *
 */
@Api(value="ZPcReceive",description="派车单应收",tags="zPcReceiveController")
@Controller
@RequestMapping("/zPcReceiveController")
public class ZPcReceiveController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZPcReceiveController.class);

	@Autowired
	private ZPcReceiveServiceI zPcReceiveService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 派车单应收列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String pid = request.getParameter("pid");
		logger.info("派车单id："+pid);
		request.setAttribute("pid",pid);
		return new ModelAndView("com/jeecg/receive/zPcReceiveList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param zPcReceive
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ZPcReceiveEntity zPcReceive,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZPcReceiveEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zPcReceive, request.getParameterMap());
		try{
		//自定义追加查询条件
			String pid = request.getParameter("pid");
			cq.eq("fid",pid);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zPcReceiveService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除派车单应收
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZPcReceiveEntity zPcReceive, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		zPcReceive = systemService.getEntity(ZPcReceiveEntity.class, zPcReceive.getId());
		message = "派车单应收删除成功";
		try{
			zPcReceiveService.delete(zPcReceive);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "派车单应收删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除派车单应收
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "派车单应收删除成功";
		try{
			for(String id:ids.split(",")){
				ZPcReceiveEntity zPcReceive = systemService.getEntity(ZPcReceiveEntity.class, 
				id
				);
				zPcReceiveService.delete(zPcReceive);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "派车单应收删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加派车单应收
	 * 
	 * @param zPcReceive
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZPcReceiveEntity zPcReceive, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "派车单应收添加成功";
		try{
			zPcReceiveService.save(zPcReceive);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "派车单应收添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新派车单应收
	 * 
	 * @param zPcReceive
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZPcReceiveEntity zPcReceive, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "派车单应收更新成功";
		ZPcReceiveEntity t = zPcReceiveService.get(ZPcReceiveEntity.class, zPcReceive.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(zPcReceive, t);
			zPcReceiveService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "派车单应收更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 派车单应收新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZPcReceiveEntity zPcReceive, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zPcReceive.getId())) {
			zPcReceive = zPcReceiveService.getEntity(ZPcReceiveEntity.class, zPcReceive.getId());
			req.setAttribute("zPcReceivePage", zPcReceive);
		}
		return new ModelAndView("com/jeecg/receive/zPcReceive-add");
	}
	/**
	 * 派车单应收编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZPcReceiveEntity zPcReceive, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zPcReceive.getId())) {
			zPcReceive = zPcReceiveService.getEntity(ZPcReceiveEntity.class, zPcReceive.getId());
			req.setAttribute("zPcReceivePage", zPcReceive);
		}
		return new ModelAndView("com/jeecg/receive/zPcReceive-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","zPcReceiveController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ZPcReceiveEntity zPcReceive,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ZPcReceiveEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zPcReceive, request.getParameterMap());
		List<ZPcReceiveEntity> zPcReceives = this.zPcReceiveService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"派车单应收");
		modelMap.put(NormalExcelConstants.CLASS,ZPcReceiveEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("派车单应收列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,zPcReceives);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ZPcReceiveEntity zPcReceive,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"派车单应收");
    	modelMap.put(NormalExcelConstants.CLASS,ZPcReceiveEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("派车单应收列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<ZPcReceiveEntity> listZPcReceiveEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ZPcReceiveEntity.class,params);
				for (ZPcReceiveEntity zPcReceive : listZPcReceiveEntitys) {
					zPcReceiveService.save(zPcReceive);
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
	@ApiOperation(value="派车单应收列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ZPcReceiveEntity>> list() {
		List<ZPcReceiveEntity> listZPcReceives=zPcReceiveService.getList(ZPcReceiveEntity.class);
		return Result.success(listZPcReceives);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取派车单应收信息",notes="根据ID获取派车单应收信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ZPcReceiveEntity task = zPcReceiveService.get(ZPcReceiveEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取派车单应收信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建派车单应收")
	public ResponseMessage<?> create(@ApiParam(name="派车单应收对象")@RequestBody ZPcReceiveEntity zPcReceive, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZPcReceiveEntity>> failures = validator.validate(zPcReceive);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			zPcReceiveService.save(zPcReceive);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("派车单应收信息保存失败");
		}
		return Result.success(zPcReceive);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新派车单应收",notes="更新派车单应收")
	public ResponseMessage<?> update(@ApiParam(name="派车单应收对象")@RequestBody ZPcReceiveEntity zPcReceive) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZPcReceiveEntity>> failures = validator.validate(zPcReceive);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			zPcReceiveService.saveOrUpdate(zPcReceive);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新派车单应收信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新派车单应收信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除派车单应收")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			zPcReceiveService.deleteEntityById(ZPcReceiveEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("派车单应收删除失败");
		}

		return Result.success();
	}
}
