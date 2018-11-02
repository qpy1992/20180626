package com.jeecg.fapiao.controller;

import com.jeecg.charge.entity.ChargeEntity;
import com.jeecg.contianer.entity.ContianerEntity;
import com.jeecg.cost.entity.CostEntity;
import com.jeecg.customentrust.entity.CustomEntrustEntity;
import com.jeecg.fapiao.entity.FapiaoEntity;
import com.jeecg.fapiao.service.FapiaoServiceI;
import java.io.PrintWriter;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jeecg.paiche.entity.PaicheEntity;
import org.apache.log4j.Logger;
import org.jeecgframework.core.online.util.CgReportQueryParamUtil;
import org.jeecgframework.web.cgreport.service.core.CgReportServiceI;
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
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.jeecgframework.core.util.ExceptionUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 运输发票
 * @author onlineGenerator
 * @date 2018-08-13 09:38:30
 * @version V1.0   
 *
 */
@Api(value="Fapiao",description="运输发票",tags="fapiaoController")
@Controller
@RequestMapping("/fapiaoController")
public class FapiaoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FapiaoController.class);

	@Autowired
	private FapiaoServiceI fapiaoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgReportServiceI cgReportService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	/**
	 * 运输发票列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/fapiao/fapiaoList");
	}

	@RequestMapping(params = "add")
	public ModelAndView add(HttpServletRequest request) {
		String ids = request.getParameter("ids");
		request.setAttribute("ids",ids);
		return new ModelAndView("com/jeecg/fapiao/costList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param fapiao
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(FapiaoEntity fapiao,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(FapiaoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, fapiao, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.fapiaoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "datagridcost")
	@ResponseBody
	public void datagridcost(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
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
			FapiaoEntity fapiao = new FapiaoEntity();
			fapiao.setFbillno(systemService.getFbillno(64));
			fapiao.setFsettle(cost.getFsettleUnit());
			fapiao.setFbibie(cost.getFbibie());
			fapiao.setFweituo(customEntrust.getFbillno());
			fapiao.setFamount(cost.getFamount());
			fapiao.setFactualamount(cost.getFactualAmount());
			fapiao.setFwtunit(customEntrust.getFentrustUnit());
			fapiao.setFtidan(customEntrust.getFblno());
			systemService.save(fapiao);
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
	 * 作废
	 *
	 * @param fapiao
	 * @return
	 */
	@RequestMapping(params = "doVoid")
	@ResponseBody
	public AjaxJson doVoid(FapiaoEntity fapiao, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = null;
		String ids = request.getParameter("ids");
		String[] entitys = ids.split(",");
		for(int i=0; i<entitys.length; i++){
			message = "作废成功!";
			fapiao = fapiaoService.getEntity(FapiaoEntity.class, entitys[i]);
			try{
				fapiao.setFvoid("Y");
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}catch(Exception e){
				e.printStackTrace();
				message = "作废失败!";
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 审核
	 *
	 * @param fapiao
	 * @return
	 */
	@RequestMapping(params = "check")
	@ResponseBody
	public AjaxJson check(FapiaoEntity fapiao, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = null;
		String ids = request.getParameter("ids");
		String[] entitys = ids.split(",");
		for(int i=0; i<entitys.length; i++){
			message = "审核成功!";
			fapiao = fapiaoService.getEntity(FapiaoEntity.class, entitys[i]);
			try{
				fapiao.setFcheck("1");
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}catch(Exception e){
				e.printStackTrace();
				message = "审核失败!";
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 锁定
	 *
	 * @param fapiao
	 * @return
	 */
	@RequestMapping(params = "lock")
	@ResponseBody
	public AjaxJson lock(FapiaoEntity fapiao, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = null;
		String ids = request.getParameter("ids");
		String[] entitys = ids.split(",");
		for(int i=0; i<entitys.length; i++){
			message = "锁定成功!";
			fapiao = fapiaoService.getEntity(FapiaoEntity.class, entitys[i]);
			try{
				fapiao.setFlock("Y");
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}catch(Exception e){
				e.printStackTrace();
				message = "锁定失败!";
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 删除运输发票
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(FapiaoEntity fapiao, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		fapiao = systemService.getEntity(FapiaoEntity.class, fapiao.getId());
		message = "运输发票删除成功";
		try{
			fapiaoService.delete(fapiao);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "运输发票删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除运输发票
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "运输发票删除成功";
		try{
			for(String id:ids.split(",")){
				FapiaoEntity fapiao = systemService.getEntity(FapiaoEntity.class, 
				id
				);
				fapiaoService.delete(fapiao);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "运输发票删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加运输发票
	 * @param fapiao
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(FapiaoEntity fapiao, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "运输发票添加成功";
		try{
			fapiaoService.save(fapiao);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "运输发票添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加运输发票
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "fapiao")
	@ResponseBody
	public AjaxJson fapiao(HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "运输发票添加成功";
		String rows=request.getParameter("rows");     //接收传入的id值
		logger.info(rows);
		String[] strArray = null;
		strArray = rows.split(",");
		logger.info(strArray);
		try{
			Double jine = 0.00;
			for(int i=0;i<strArray.length;i++){
				String[] object = strArray[i].split("/");
				systemService.executeSql("update z_charge set fkp='Y' where id='"+object[0]+"'");
				String mon = jdbcTemplate.queryForObject("select fsfamount from z_charge where id=?",String.class,object[0]);
				jine = jine + Double.parseDouble(mon);
			}
			String[] ob = strArray[0].split("/");
			String fbillno = ob[1];
			CustomEntrustEntity customEntrust = systemService.findUniqueByProperty(CustomEntrustEntity.class,"fbillno",fbillno);
			FapiaoEntity fapiao = new FapiaoEntity();
			fapiao.setFsettle(customEntrust.getFentrustUnit());
			fapiao.setFtidan(customEntrust.getFblno());
			fapiao.setFwtunit(customEntrust.getFentrustUnit());
			fapiao.setFweituo(customEntrust.getFbillno());
			fapiao.setFbibie("人民币");
			fapiao.setFamount(jine);
			systemService.save(fapiao);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "运输发票添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新运输发票
	 * @param fapiao
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(FapiaoEntity fapiao, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "运输发票更新成功";
		FapiaoEntity t = fapiaoService.get(FapiaoEntity.class, fapiao.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(fapiao, t);
			fapiaoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "运输发票更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 运输发票新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(FapiaoEntity fapiao, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(fapiao.getId())) {
			fapiao = fapiaoService.getEntity(FapiaoEntity.class, fapiao.getId());
			req.setAttribute("fapiaoPage", fapiao);
		}
		return new ModelAndView("com/jeecg/fapiao/fapiao-add");
	}

	/**
	 * 运输发票编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(FapiaoEntity fapiao, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(fapiao.getId())) {
			fapiao = fapiaoService.getEntity(FapiaoEntity.class, fapiao.getId());
			req.setAttribute("fapiaoPage", fapiao);
		}
		return new ModelAndView("com/jeecg/fapiao/fapiao-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","fapiaoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(FapiaoEntity fapiao,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(FapiaoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, fapiao, request.getParameterMap());
		List<FapiaoEntity> fapiaos = this.fapiaoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"运输发票");
		modelMap.put(NormalExcelConstants.CLASS,FapiaoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("运输发票列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,fapiaos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(FapiaoEntity fapiao,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"运输发票");
    	modelMap.put(NormalExcelConstants.CLASS,FapiaoEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("运输发票列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<FapiaoEntity> listFapiaoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),FapiaoEntity.class,params);
				for (FapiaoEntity fapiao : listFapiaoEntitys) {
					fapiaoService.save(fapiao);
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
	@ApiOperation(value="运输发票列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<FapiaoEntity>> list() {
		List<FapiaoEntity> listFapiaos=fapiaoService.getList(FapiaoEntity.class);
		return Result.success(listFapiaos);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取运输发票信息",notes="根据ID获取运输发票信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		FapiaoEntity task = fapiaoService.get(FapiaoEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取运输发票信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建运输发票")
	public ResponseMessage<?> create(@ApiParam(name="运输发票对象")@RequestBody FapiaoEntity fapiao, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<FapiaoEntity>> failures = validator.validate(fapiao);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			fapiaoService.save(fapiao);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("运输发票信息保存失败");
		}
		return Result.success(fapiao);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新运输发票",notes="更新运输发票")
	public ResponseMessage<?> update(@ApiParam(name="运输发票对象")@RequestBody FapiaoEntity fapiao) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<FapiaoEntity>> failures = validator.validate(fapiao);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			fapiaoService.saveOrUpdate(fapiao);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新运输发票信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新运输发票信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除运输发票")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			fapiaoService.deleteEntityById(FapiaoEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("运输发票删除失败");
		}

		return Result.success();
	}
}
