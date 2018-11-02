package com.jeecg.bxcost.controller;
import com.jeecg.bxcost.entity.BxcostEntity;
import com.jeecg.bxcost.service.BxcostServiceI;

import java.io.PrintWriter;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeecg.contianer.entity.ContianerEntity;
import com.jeecg.cost.entity.CostEntity;
import com.jeecg.customentrust.entity.CustomEntrustEntity;
import com.jeecg.paiban.entity.PaibanEntity;
import com.jeecg.paiche.entity.PaicheEntity;
import org.apache.log4j.Logger;
import org.jeecgframework.core.online.util.CgReportQueryParamUtil;
import org.jeecgframework.web.cgreport.service.core.CgReportServiceI;
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
 * @Description: 报销单费用
 * @author onlineGenerator
 * @date 2018-08-10 08:43:12
 * @version V1.0   
 *
 */
@Api(value="Bxcost",description="报销单费用",tags="bxcostController")
@Controller
@RequestMapping("/bxcostController")
public class BxcostController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BxcostController.class);

	@Autowired
	private BxcostServiceI bxcostService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgReportServiceI cgReportService;
	


	/**
	 * 报销单费用列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String ids = request.getParameter("ids");
		logger.info("获取的主表id:"+ids);
		request.setAttribute("ids",ids);
		return new ModelAndView("com/jeecg/bxcost/bxcostList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param bxcost
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(BxcostEntity bxcost,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BxcostEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bxcost, request.getParameterMap());
		try{
		//自定义追加查询条件
			String ids = request.getParameter("ids");
			cq.eq("fid",ids);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.bxcostService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "cost")
	public ModelAndView cost(HttpServletRequest request) {
		String ids = request.getParameter("ids");
		logger.info("获取的主表id:"+ids);
		request.setAttribute("ids",ids);
		return new ModelAndView("com/jeecg/bxcost/costList");
	}

	/**
	 * 费用显示
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagridcost")
	@ResponseBody
	public void datagridcost(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String fweituo = request.getParameter("");
		Map queryparams =  new LinkedHashMap<String,Object>();
		String sql = "Select a.id,a.fcost_type fcost,a.fcostname,a.fsettle_unit fsettle,a.fsettlename," +
				"a.funit,a.fprice,a.fqty,a.famount,a.frated_amount frated,a.factual_amount factual,a.fcheck,b.fload_port fload," +
				"b.ftargetport,b.fnote,b.fblno,b.fshipname,b.fvoyageno,b.fzytime,b.fbillno fweituo," +
				"d.fbillno fpaiche,b.fentrust_unit fentrust,c.fzhdp,c.fzhdpdz from z_cost a left join" +
				" z_custom_entrust b on b.id=a.fid left join z_contianer c on c.fid=b.id left join" +
				" z_paiche d on d.fbillno=c.fbillno where a.fstatus='1'";
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
	 * 加入费用
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "addcost")
	@ResponseBody
	public AjaxJson addcost(HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			String cid = request.getParameter("cid");
			String ids = request.getParameter("ids");
			logger.info("cid的值:"+cid);
			logger.info("ids的值:"+ids);
			CostEntity cost = systemService.getEntity(CostEntity.class,cid);
			CustomEntrustEntity customEntrust = systemService.getEntity(CustomEntrustEntity.class,cost.getFid());
			ContianerEntity contianer = systemService.findUniqueByProperty(ContianerEntity.class,"fid",cost.getFid());
			PaicheEntity paiche = systemService.findUniqueByProperty(PaicheEntity.class,"fbillno",contianer.getFbillno());
			BxcostEntity bxcost = new BxcostEntity();
			bxcost.setFweituo(customEntrust.getFbillno());
			bxcost.setFbrno(customEntrust.getFblno());
			bxcost.setFcost(cost.getFcostType());
			bxcost.setFsettle(cost.getFsettleUnit());
			bxcost.setFsettlename(cost.getFsettlename());
			bxcost.setFpaiche(paiche.getFbillno());
			bxcost.setFboxno(contianer.getFboxno());
			bxcost.setFamount(cost.getFamount());
			bxcost.setFsfamount(cost.getFactualAmount());
			bxcost.setFdaidian(cost.getFcushion());
			bxcost.setFinstruction(customEntrust.getFnote());
			bxcost.setFid(ids);
			cost.setFstatus("2");
			systemService.save(bxcost);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 删除报销单费用
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BxcostEntity bxcost, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		bxcost = systemService.getEntity(BxcostEntity.class, bxcost.getId());
		message = "报销单费用删除成功";
		try{
			bxcostService.delete(bxcost);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "报销单费用删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除报销单费用
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "报销单费用删除成功";
		try{
			for(String id:ids.split(",")){
				BxcostEntity bxcost = systemService.getEntity(BxcostEntity.class, 
				id
				);
				bxcostService.delete(bxcost);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "报销单费用删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加报销单费用
	 * 
	 * @param bxcost
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BxcostEntity bxcost, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "报销单费用添加成功";
		try{
			bxcostService.save(bxcost);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "报销单费用添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新报销单费用
	 * 
	 * @param bxcost
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BxcostEntity bxcost, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "报销单费用更新成功";
		BxcostEntity t = bxcostService.get(BxcostEntity.class, bxcost.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(bxcost, t);
			bxcostService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "报销单费用更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 报销单费用新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BxcostEntity bxcost, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bxcost.getId())) {
			bxcost = bxcostService.getEntity(BxcostEntity.class, bxcost.getId());
			req.setAttribute("bxcostPage", bxcost);
		}
		return new ModelAndView("com/jeecg/bxcost/bxcost-add");
	}
	/**
	 * 报销单费用编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BxcostEntity bxcost, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bxcost.getId())) {
			bxcost = bxcostService.getEntity(BxcostEntity.class, bxcost.getId());
			req.setAttribute("bxcostPage", bxcost);
		}
		return new ModelAndView("com/jeecg/bxcost/bxcost-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","bxcostController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(BxcostEntity bxcost,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(BxcostEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bxcost, request.getParameterMap());
		List<BxcostEntity> bxcosts = this.bxcostService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"报销单费用");
		modelMap.put(NormalExcelConstants.CLASS,BxcostEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("报销单费用列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,bxcosts);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(BxcostEntity bxcost,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"报销单费用");
    	modelMap.put(NormalExcelConstants.CLASS,BxcostEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("报销单费用列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<BxcostEntity> listBxcostEntitys = ExcelImportUtil.importExcel(file.getInputStream(),BxcostEntity.class,params);
				for (BxcostEntity bxcost : listBxcostEntitys) {
					bxcostService.save(bxcost);
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
	@ApiOperation(value="报销单费用列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<BxcostEntity>> list() {
		List<BxcostEntity> listBxcosts=bxcostService.getList(BxcostEntity.class);
		return Result.success(listBxcosts);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取报销单费用信息",notes="根据ID获取报销单费用信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		BxcostEntity task = bxcostService.get(BxcostEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取报销单费用信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建报销单费用")
	public ResponseMessage<?> create(@ApiParam(name="报销单费用对象")@RequestBody BxcostEntity bxcost, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BxcostEntity>> failures = validator.validate(bxcost);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			bxcostService.save(bxcost);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("报销单费用信息保存失败");
		}
		return Result.success(bxcost);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新报销单费用",notes="更新报销单费用")
	public ResponseMessage<?> update(@ApiParam(name="报销单费用对象")@RequestBody BxcostEntity bxcost) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BxcostEntity>> failures = validator.validate(bxcost);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			bxcostService.saveOrUpdate(bxcost);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新报销单费用信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新报销单费用信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除报销单费用")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			bxcostService.deleteEntityById(BxcostEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("报销单费用删除失败");
		}

		return Result.success();
	}
}
