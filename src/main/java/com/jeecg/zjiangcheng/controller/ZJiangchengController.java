package com.jeecg.zjiangcheng.controller;
import com.jeecg.zjiangcheng.entity.ZJiangchengEntity;
import com.jeecg.zjiangcheng.service.ZJiangchengServiceI;
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
 * @Description: 奖惩
 * @author onlineGenerator
 * @date 2018-09-19 10:40:52
 * @version V1.0   
 *
 */
@Api(value="ZJiangcheng",description="奖惩",tags="zJiangchengController")
@Controller
@RequestMapping("/zJiangchengController")
public class ZJiangchengController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZJiangchengController.class);

	@Autowired
	private ZJiangchengServiceI zJiangchengService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 奖惩列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		request.setAttribute("pid", request.getParameter("pid"));
		return new ModelAndView("com/jeecg/zjiangcheng/zJiangchengList");
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
	public void datagrid(ZJiangchengEntity zJiangcheng,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZJiangchengEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zJiangcheng, request.getParameterMap());
		try{
		//自定义追加查询条件
			String pid=request.getParameter("pid");
			 System.out.println("pid==="+pid);
			cq.eq("pid", pid);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zJiangchengService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除奖惩
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZJiangchengEntity zJiangcheng, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		zJiangcheng = systemService.getEntity(ZJiangchengEntity.class, zJiangcheng.getId());
		message = "奖惩删除成功";
		try{
			zJiangchengService.delete(zJiangcheng);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "奖惩删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除奖惩
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "奖惩删除成功";
		try{
			for(String id:ids.split(",")){
				ZJiangchengEntity zJiangcheng = systemService.getEntity(ZJiangchengEntity.class, 
				id
				);
				zJiangchengService.delete(zJiangcheng);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "奖惩删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加奖惩
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZJiangchengEntity zJiangcheng, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "奖惩添加成功";
		try{
			zJiangcheng.setPid(request.getParameter("pid"));
			zJiangchengService.save(zJiangcheng);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "奖惩添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新奖惩
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZJiangchengEntity zJiangcheng, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "奖惩更新成功";
		ZJiangchengEntity t = zJiangchengService.get(ZJiangchengEntity.class, zJiangcheng.getId());
		try {
			t.setPid(request.getParameter("pid"));
			MyBeanUtils.copyBeanNotNull2Bean(zJiangcheng, t);
			zJiangchengService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "奖惩更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 奖惩新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZJiangchengEntity zJiangcheng, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zJiangcheng.getId())) {
			zJiangcheng = zJiangchengService.getEntity(ZJiangchengEntity.class, zJiangcheng.getId());
			req.setAttribute("zJiangchengPage", zJiangcheng);
		}
		req.setAttribute("pid", req.getParameter("pid"));
		return new ModelAndView("com/jeecg/zjiangcheng/zJiangcheng-add");
	}
	/**
	 * 奖惩编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZJiangchengEntity zJiangcheng, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zJiangcheng.getId())) {
			zJiangcheng = zJiangchengService.getEntity(ZJiangchengEntity.class, zJiangcheng.getId());
			req.setAttribute("zJiangchengPage", zJiangcheng);
		}
		req.setAttribute("pid", req.getParameter("pid"));
		return new ModelAndView("com/jeecg/zjiangcheng/zJiangcheng-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","zJiangchengController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ZJiangchengEntity zJiangcheng,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ZJiangchengEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zJiangcheng, request.getParameterMap());
		List<ZJiangchengEntity> zJiangchengs = this.zJiangchengService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"奖惩");
		modelMap.put(NormalExcelConstants.CLASS,ZJiangchengEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("奖惩列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,zJiangchengs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ZJiangchengEntity zJiangcheng,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"奖惩");
    	modelMap.put(NormalExcelConstants.CLASS,ZJiangchengEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("奖惩列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<ZJiangchengEntity> listZJiangchengEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ZJiangchengEntity.class,params);
				for (ZJiangchengEntity zJiangcheng : listZJiangchengEntitys) {
					zJiangchengService.save(zJiangcheng);
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
	@ApiOperation(value="奖惩列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ZJiangchengEntity>> list() {
		List<ZJiangchengEntity> listZJiangchengs=zJiangchengService.getList(ZJiangchengEntity.class);
		return Result.success(listZJiangchengs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取奖惩信息",notes="根据ID获取奖惩信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ZJiangchengEntity task = zJiangchengService.get(ZJiangchengEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取奖惩信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建奖惩")
	public ResponseMessage<?> create(@ApiParam(name="奖惩对象")@RequestBody ZJiangchengEntity zJiangcheng, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZJiangchengEntity>> failures = validator.validate(zJiangcheng);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			zJiangchengService.save(zJiangcheng);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("奖惩信息保存失败");
		}
		return Result.success(zJiangcheng);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新奖惩",notes="更新奖惩")
	public ResponseMessage<?> update(@ApiParam(name="奖惩对象")@RequestBody ZJiangchengEntity zJiangcheng) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZJiangchengEntity>> failures = validator.validate(zJiangcheng);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			zJiangchengService.saveOrUpdate(zJiangcheng);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新奖惩信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新奖惩信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除奖惩")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			zJiangchengService.deleteEntityById(ZJiangchengEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("奖惩删除失败");
		}

		return Result.success();
	}
}
