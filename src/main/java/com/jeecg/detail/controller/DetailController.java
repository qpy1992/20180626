package com.jeecg.detail.controller;
import com.jeecg.contianer.entity.ContianerEntity;
import com.jeecg.customentrust.entity.CustomEntrustEntity;
import com.jeecg.detail.entity.DetailEntity;
import com.jeecg.detail.service.DetailServiceI;
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
 * @Description: 箱货明细
 * @author onlineGenerator
 * @date 2018-07-03 09:44:38
 * @version V1.0   
 *
 */
@Api(value="Detail",description="箱货明细",tags="detailController")
@Controller
@RequestMapping("/detailController")
public class DetailController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DetailController.class);

	@Autowired
	private DetailServiceI detailService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 箱货明细列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		request.setAttribute("id",request.getParameter("id"));
		System.out.println(request.getParameter("id"));
		System.out.println("2222222222222222222222");
		System.out.println("2222222222222222222222");
		//return new ModelAndView("com/jeecg/detail/detailList");
		return new ModelAndView("com/jeecg/customentrust/customEntrust-addTest");
	}
	
	
	/**
	 * 加载明细列表[集装箱]
	 * 
	 * @return
	 */
	@RequestMapping(params = "detailList")
	public ModelAndView contianerList(CustomEntrustEntity customEntrust, HttpServletRequest req) {
		return new ModelAndView("com/jeecg/detail/detailListTest");
	}
	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param detail
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(DetailEntity detail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DetailEntity.class, dataGrid);
		//查询条件组装器
		String id = request.getParameter("id");
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, detail, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.eq("fid",id);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.detailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除箱货明细
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DetailEntity detail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		detail = systemService.getEntity(DetailEntity.class, detail.getId());
		message = "箱货明细删除成功";
		try{
			detailService.delete(detail);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "箱货明细删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除箱货明细
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "箱货明细删除成功";
		try{
			for(String id:ids.split(",")){
				DetailEntity detail = systemService.getEntity(DetailEntity.class, 
				id
				);
				detailService.delete(detail);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "箱货明细删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加箱货明细
	 * 
	 * @param detail
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DetailEntity detail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "箱货明细添加成功";
		try{
			detailService.save(detail);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "箱货明细添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新箱货明细
	 * 
	 * @param detail
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DetailEntity detail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "箱货明细更新成功";
		DetailEntity t = detailService.get(DetailEntity.class, detail.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(detail, t);
			detailService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "箱货明细更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 箱货明细新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DetailEntity detail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(detail.getId())) {
			detail = detailService.getEntity(DetailEntity.class, detail.getId());
			req.setAttribute("detailPage", detail);
		}
		return new ModelAndView("com/jeecg/detail/detail-add");
	}
	/**
	 * 箱货明细编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DetailEntity detail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(detail.getId())) {
			detail = detailService.getEntity(DetailEntity.class, detail.getId());
			req.setAttribute("detailPage", detail);
		}
		return new ModelAndView("com/jeecg/detail/detail-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","detailController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DetailEntity detail,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DetailEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, detail, request.getParameterMap());
		List<DetailEntity> details = this.detailService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"箱货明细");
		modelMap.put(NormalExcelConstants.CLASS,DetailEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("箱货明细列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,details);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DetailEntity detail,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"箱货明细");
    	modelMap.put(NormalExcelConstants.CLASS,DetailEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("箱货明细列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<DetailEntity> listDetailEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DetailEntity.class,params);
				for (DetailEntity detail : listDetailEntitys) {
					detailService.save(detail);
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
	@ApiOperation(value="箱货明细列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<DetailEntity>> list() {
		List<DetailEntity> listDetails=detailService.getList(DetailEntity.class);
		return Result.success(listDetails);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取箱货明细信息",notes="根据ID获取箱货明细信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		DetailEntity task = detailService.get(DetailEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取箱货明细信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建箱货明细")
	public ResponseMessage<?> create(@ApiParam(name="箱货明细对象")@RequestBody DetailEntity detail, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DetailEntity>> failures = validator.validate(detail);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			detailService.save(detail);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("箱货明细信息保存失败");
		}
		return Result.success(detail);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新箱货明细",notes="更新箱货明细")
	public ResponseMessage<?> update(@ApiParam(name="箱货明细对象")@RequestBody DetailEntity detail) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DetailEntity>> failures = validator.validate(detail);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			detailService.saveOrUpdate(detail);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新箱货明细信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新箱货明细信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除箱货明细")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			detailService.deleteEntityById(DetailEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("箱货明细删除失败");
		}

		return Result.success();
	}
}
