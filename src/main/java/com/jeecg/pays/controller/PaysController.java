package com.jeecg.pays.controller;
import com.jeecg.pays.entity.PaysEntity;
import com.jeecg.pays.service.PaysServiceI;

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
 * @Description: 应付账单
 * @author onlineGenerator
 * @date 2018-08-08 15:28:36
 * @version V1.0   
 *
 */
@Api(value="Pays",description="应付账单",tags="paysController")
@Controller
@RequestMapping("/paysController")
public class PaysController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PaysController.class);

	@Autowired
	private PaysServiceI paysService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private Validator validator;
	


	/**
	 * 应付账单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/pays/paysList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param pays
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(PaysEntity pays,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PaysEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, pays, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.paysService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除应付账单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(PaysEntity pays, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		pays = systemService.getEntity(PaysEntity.class, pays.getId());
		message = "应付账单删除成功";
		try{
			paysService.delete(pays);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应付账单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除应付账单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应付账单删除成功";
		try{
			for(String id:ids.split(",")){
				PaysEntity pays = systemService.getEntity(PaysEntity.class, 
				id
				);
				paysService.delete(pays);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "应付账单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加应付账单
	 * 
	 * @param pays
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(PaysEntity pays, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应付账单添加成功";
		try{
			pays.setFbillno(getFbillno(58));
			paysService.save(pays);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应付账单添加失败";
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
	 * 更新应付账单
	 * 
	 * @param pays
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(PaysEntity pays, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应付账单更新成功";
		PaysEntity t = paysService.get(PaysEntity.class, pays.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(pays, t);
			paysService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "应付账单更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 应付账单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(PaysEntity pays, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(pays.getId())) {
			pays = paysService.getEntity(PaysEntity.class, pays.getId());
			req.setAttribute("paysPage", pays);
		}
		return new ModelAndView("com/jeecg/pays/pays-add");
	}
	/**
	 * 应付账单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(PaysEntity pays, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(pays.getId())) {
			pays = paysService.getEntity(PaysEntity.class, pays.getId());
			req.setAttribute("paysPage", pays);
		}
		return new ModelAndView("com/jeecg/pays/pays-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","paysController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(PaysEntity pays,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(PaysEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, pays, request.getParameterMap());
		List<PaysEntity> payss = this.paysService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"应付账单");
		modelMap.put(NormalExcelConstants.CLASS,PaysEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("应付账单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,payss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(PaysEntity pays,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"应付账单");
    	modelMap.put(NormalExcelConstants.CLASS,PaysEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("应付账单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<PaysEntity> listPaysEntitys = ExcelImportUtil.importExcel(file.getInputStream(),PaysEntity.class,params);
				for (PaysEntity pays : listPaysEntitys) {
					paysService.save(pays);
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
	@ApiOperation(value="应付账单列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<PaysEntity>> list() {
		List<PaysEntity> listPayss=paysService.getList(PaysEntity.class);
		return Result.success(listPayss);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取应付账单信息",notes="根据ID获取应付账单信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		PaysEntity task = paysService.get(PaysEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取应付账单信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建应付账单")
	public ResponseMessage<?> create(@ApiParam(name="应付账单对象")@RequestBody PaysEntity pays, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<PaysEntity>> failures = validator.validate(pays);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			paysService.save(pays);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("应付账单信息保存失败");
		}
		return Result.success(pays);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新应付账单",notes="更新应付账单")
	public ResponseMessage<?> update(@ApiParam(name="应付账单对象")@RequestBody PaysEntity pays) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<PaysEntity>> failures = validator.validate(pays);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			paysService.saveOrUpdate(pays);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新应付账单信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新应付账单信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除应付账单")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			paysService.deleteEntityById(PaysEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("应付账单删除失败");
		}

		return Result.success();
	}
}
