package com.jeecg.pay.controller;
import com.jeecg.pay.entity.ZPcPayEntity;
import com.jeecg.pay.service.ZPcPayServiceI;
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
 * @Description: 派车单应付
 * @author onlineGenerator
 * @date 2018-07-31 16:44:19
 * @version V1.0   
 *
 */
@Api(value="ZPcPay",description="派车单应付",tags="zPcPayController")
@Controller
@RequestMapping("/zPcPayController")
public class ZPcPayController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZPcPayController.class);

	@Autowired
	private ZPcPayServiceI zPcPayService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 派车单应付列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String pid = request.getParameter("pid");
		logger.info("派车单id："+pid);
		request.setAttribute("pid",pid);
		return new ModelAndView("com/jeecg/pay/zPcPayList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param zPcPay
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ZPcPayEntity zPcPay,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZPcPayEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zPcPay, request.getParameterMap());
		try{
		//自定义追加查询条件
			String pid = request.getParameter("pid");
			cq.eq("fid",pid);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zPcPayService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除派车单应付
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZPcPayEntity zPcPay, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		zPcPay = systemService.getEntity(ZPcPayEntity.class, zPcPay.getId());
		message = "派车单应付删除成功";
		try{
			zPcPayService.delete(zPcPay);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "派车单应付删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除派车单应付
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "派车单应付删除成功";
		try{
			for(String id:ids.split(",")){
				ZPcPayEntity zPcPay = systemService.getEntity(ZPcPayEntity.class, 
				id
				);
				zPcPayService.delete(zPcPay);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "派车单应付删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加派车单应付
	 * 
	 * @param zPcPay
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZPcPayEntity zPcPay, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "派车单应付添加成功";
		try{
			zPcPayService.save(zPcPay);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "派车单应付添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新派车单应付
	 * 
	 * @param zPcPay
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZPcPayEntity zPcPay, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "派车单应付更新成功";
		ZPcPayEntity t = zPcPayService.get(ZPcPayEntity.class, zPcPay.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(zPcPay, t);
			zPcPayService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "派车单应付更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 派车单应付新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZPcPayEntity zPcPay, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zPcPay.getId())) {
			zPcPay = zPcPayService.getEntity(ZPcPayEntity.class, zPcPay.getId());
			req.setAttribute("zPcPayPage", zPcPay);
		}
		return new ModelAndView("com/jeecg/pay/zPcPay-add");
	}
	/**
	 * 派车单应付编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZPcPayEntity zPcPay, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zPcPay.getId())) {
			zPcPay = zPcPayService.getEntity(ZPcPayEntity.class, zPcPay.getId());
			req.setAttribute("zPcPayPage", zPcPay);
		}
		return new ModelAndView("com/jeecg/pay/zPcPay-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","zPcPayController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ZPcPayEntity zPcPay,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ZPcPayEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zPcPay, request.getParameterMap());
		List<ZPcPayEntity> zPcPays = this.zPcPayService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"派车单应付");
		modelMap.put(NormalExcelConstants.CLASS,ZPcPayEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("派车单应付列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,zPcPays);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ZPcPayEntity zPcPay,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"派车单应付");
    	modelMap.put(NormalExcelConstants.CLASS,ZPcPayEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("派车单应付列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<ZPcPayEntity> listZPcPayEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ZPcPayEntity.class,params);
				for (ZPcPayEntity zPcPay : listZPcPayEntitys) {
					zPcPayService.save(zPcPay);
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
	@ApiOperation(value="派车单应付列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ZPcPayEntity>> list() {
		List<ZPcPayEntity> listZPcPays=zPcPayService.getList(ZPcPayEntity.class);
		return Result.success(listZPcPays);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取派车单应付信息",notes="根据ID获取派车单应付信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ZPcPayEntity task = zPcPayService.get(ZPcPayEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取派车单应付信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建派车单应付")
	public ResponseMessage<?> create(@ApiParam(name="派车单应付对象")@RequestBody ZPcPayEntity zPcPay, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZPcPayEntity>> failures = validator.validate(zPcPay);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			zPcPayService.save(zPcPay);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("派车单应付信息保存失败");
		}
		return Result.success(zPcPay);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新派车单应付",notes="更新派车单应付")
	public ResponseMessage<?> update(@ApiParam(name="派车单应付对象")@RequestBody ZPcPayEntity zPcPay) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZPcPayEntity>> failures = validator.validate(zPcPay);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			zPcPayService.saveOrUpdate(zPcPay);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新派车单应付信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新派车单应付信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除派车单应付")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			zPcPayService.deleteEntityById(ZPcPayEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("派车单应付删除失败");
		}

		return Result.success();
	}
}
