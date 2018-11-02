package com.jeecg.rece.controller;
import com.jeecg.rece.entity.ReceEntity;
import com.jeecg.rece.service.ReceServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
 * @Description: 应收账单
 * @author onlineGenerator
 * @date 2018-08-08 14:30:28
 * @version V1.0   
 *
 */
@Api(value="Rece",description="应收账单",tags="receController")
@Controller
@RequestMapping("/receController")
public class ReceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ReceController.class);

	@Autowired
	private ReceServiceI receService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private Validator validator;
	


	/**
	 * 应收账单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/rece/receList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param rece
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ReceEntity rece,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ReceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, rece, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.receService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除应收账单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ReceEntity rece, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		rece = systemService.getEntity(ReceEntity.class, rece.getId());
		message = "应收账单删除成功";
		try{
			receService.delete(rece);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应收账单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除应收账单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应收账单删除成功";
		try{
			for(String id:ids.split(",")){
				ReceEntity rece = systemService.getEntity(ReceEntity.class, 
				id
				);
				receService.delete(rece);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "应收账单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加应收账单
	 * 
	 * @param rece
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ReceEntity rece, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应收账单添加成功";
		try{
			rece.setFbillno(getFbillno(67));
			receService.save(rece);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应收账单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	public String getFbillno(int fbilltype){
		String FProjectVal1 = jdbcTemplate.queryForObject("select FProjectVal from t_billCodeRule where FBillType=? and FProjectID=1",String.class,fbilltype);
		String FProjectVal2 = jdbcTemplate.queryForObject("select FProjectVal from t_billCodeRule where FbillType=? and FProjectID=2",String.class,fbilltype);
		String date = new SimpleDateFormat("yy-MM-dd").format(new Date());
		String index = "";
		if(FProjectVal2.equals(date)){
			index = jdbcTemplate.queryForObject("select FProjectVal from t_billCodeRule where FBillType=? and FProjectID=3",String.class,fbilltype);
			index = String.valueOf(Integer.parseInt(index)+1);
			jdbcTemplate.update("update t_billCodeRule set FProjectVal=? where fbilltype= ? and fprojectid=3",new Object[]{index,fbilltype});
		}else{
			jdbcTemplate.update("update t_billCodeRule set FProjectVal=? where fbilltype= ? and fprojectid=2",new Object[]{date,fbilltype});
			jdbcTemplate.update("update t_BillCodeRule set FProjectVal=1 where fbilltype= ? and fprojectid=3",fbilltype);
			index="1";
		}
		String suffix = "000"+index;
		String fbillno = FProjectVal1+date+suffix.substring(suffix.length()-3,suffix.length());
		return fbillno;
	}

	/**
	 * 更新应收账单
	 * 
	 * @param rece
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ReceEntity rece, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应收账单更新成功";
		ReceEntity t = receService.get(ReceEntity.class, rece.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(rece, t);
			receService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "应收账单更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 应收账单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ReceEntity rece, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(rece.getId())) {
			rece = receService.getEntity(ReceEntity.class, rece.getId());
			req.setAttribute("recePage", rece);
		}
		return new ModelAndView("com/jeecg/rece/rece-add");
	}
	/**
	 * 应收账单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ReceEntity rece, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(rece.getId())) {
			rece = receService.getEntity(ReceEntity.class, rece.getId());
			req.setAttribute("recePage", rece);
		}
		return new ModelAndView("com/jeecg/rece/rece-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","receController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ReceEntity rece,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ReceEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, rece, request.getParameterMap());
		List<ReceEntity> reces = this.receService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"应收账单");
		modelMap.put(NormalExcelConstants.CLASS,ReceEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("应收账单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,reces);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ReceEntity rece,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"应收账单");
    	modelMap.put(NormalExcelConstants.CLASS,ReceEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("应收账单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

	/**
	 * 导入Excel
	 * @param request
	 * @param response
	 * @return
	 */
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
				List<ReceEntity> listReceEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ReceEntity.class,params);
				for (ReceEntity rece : listReceEntitys) {
					receService.save(rece);
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
	@ApiOperation(value="应收账单列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ReceEntity>> list() {
		List<ReceEntity> listReces=receService.getList(ReceEntity.class);
		return Result.success(listReces);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取应收账单信息",notes="根据ID获取应收账单信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ReceEntity task = receService.get(ReceEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取应收账单信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建应收账单")
	public ResponseMessage<?> create(@ApiParam(name="应收账单对象")@RequestBody ReceEntity rece, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ReceEntity>> failures = validator.validate(rece);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}
		//保存
		try{
			receService.save(rece);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("应收账单信息保存失败");
		}
		return Result.success(rece);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新应收账单",notes="更新应收账单")
	public ResponseMessage<?> update(@ApiParam(name="应收账单对象")@RequestBody ReceEntity rece) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ReceEntity>> failures = validator.validate(rece);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}
		//保存
		try{
			receService.saveOrUpdate(rece);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新应收账单信息失败");
		}
		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新应收账单信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除应收账单")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			receService.deleteEntityById(ReceEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("应收账单删除失败");
		}
		return Result.success();
	}
}
