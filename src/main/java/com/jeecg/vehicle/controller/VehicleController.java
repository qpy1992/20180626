package com.jeecg.vehicle.controller;
import com.jeecg.vehicle.entity.VehicleEntity;
import com.jeecg.vehicle.entity.VtsEntity;
import com.jeecg.vehicle.service.VehicleServiceI;

import java.io.PrintWriter;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller  
 * @Description: 车辆资料
 * @author onlineGenerator
 * @date 2018-10-23 20:43:02
 * @version V1.0   
 *
 */
@Api(value="Vehicle",description="车辆资料",tags="vehicleController")
@Controller
@RequestMapping("/vehicleController")
public class VehicleController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(VehicleController.class);

	@Autowired
	private VehicleServiceI vehicleService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private CgReportServiceI cgReportService;


	/**
	 * 车辆资料列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/vehicle/vehicleList");
	}

	@RequestMapping(params = "list1")
	public ModelAndView list1(HttpServletRequest request) {
		String id = request.getParameter("id");
		logger.info("牵引车id:"+id);
		request.setAttribute("vehId",id);
		VtsEntity vts = systemService.findUniqueByProperty(VtsEntity.class,"vehId",id);
		if(StringUtil.isNotEmpty(vts)){
			request.setAttribute("vtsPage",vts);
			if(StringUtil.isNotEmpty(vts.getTraId())){
				String trailer = jdbcTemplate.queryForObject("select fname from z_trailer where id=?",String.class,vts.getTraId());
				request.setAttribute("trailer",trailer);
			}
			if(StringUtil.isNotEmpty(vts.getSijiId())){
				String siji = jdbcTemplate.queryForObject("select fname from z_siji where id=?",String.class,vts.getSijiId());
				request.setAttribute("siji",siji);
			}
		}
		return new ModelAndView("com/jeecg/vehicle/vehicle");
	}

	@RequestMapping(params = "bind")
	@ResponseBody
	public AjaxJson bind(VtsEntity vts, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "绑定成功";
		try{
			if(StringUtil.isNotEmpty(vts.getId())){
				VtsEntity t = systemService.getEntity(VtsEntity.class,vts.getId());
				MyBeanUtils.copyBeanNotNull2Bean(vts, t);
				systemService.saveOrUpdate(t);
			}else {
				systemService.save(vts);
			}
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "车辆资料添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(vts);
		return j;
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param vehicle
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(VehicleEntity vehicle,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VehicleEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vehicle, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vehicleService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "datagrid1")
	public void datagrid1(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String sql =null;
		String fitemid = request.getParameter("fitemid");
		String fcarno = request.getParameter("fcarno");
		String fdriver = request.getParameter("fdriver");
		String ftrailer = request.getParameter("ftrailer");
		String ftotal1 = request.getParameter("ftotal_begin");
		String ftotal2 = request.getParameter("ftotal_end");
		Map queryparams =  new LinkedHashMap<String,Object>();
		//      	  主键  牵引车代码  车牌号      实际重量		        司机              挂车号          实际重量                             总重量               回程时间
		sql = "select a.id,a.fitemid,a.fcarno,a.ftrueweight fweight,d.fname fdriver,c.fname ftrailer,c.ftrueweight fweight1,a.ftrueweight+c.ftrueweight ftotal,a.fbacktime from z_vehicle a left join z_vts b on b.veh_id=a.id left join z_trailer c on c.id=b.tra_id left join z_siji d on d.id=b.siji_id where 1=1";
		if(StringUtil.isNotEmpty(fitemid)){
			sql = sql + " and a.fitemid = '"+fitemid+"'";
		}
		if(StringUtil.isNotEmpty(fcarno)){
			sql = sql + " and a.fcarno ='"+fcarno+"'";
		}
		if(StringUtil.isNotEmpty(fdriver)){
			sql = sql + " and d.fname like '%"+fdriver+"%'";
		}
		if(StringUtil.isNotEmpty(ftrailer)){
			sql = sql + " and c.fname = '"+ftrailer+"'";
		}
		if(StringUtil.isNotEmpty(ftotal1)&&StringUtil.isEmpty(ftotal2)){
			sql = sql + " and a.ftrueweight+c.ftrueweight > "+ftotal1;
		}
		if(StringUtil.isEmpty(ftotal1)&&StringUtil.isNotEmpty(ftotal2)){
			sql = sql + " and a.ftrueweight+c.ftrueweight < "+ftotal2;
		}
		if(StringUtil.isNotEmpty(ftotal1)&&StringUtil.isNotEmpty(ftotal2)){
			sql = sql + " and a.ftrueweight+c.ftrueweight between "+ftotal1+" and "+ftotal2;
		}
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
	 * 删除车辆资料
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VehicleEntity vehicle, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		vehicle = systemService.getEntity(VehicleEntity.class, vehicle.getId());
		message = "车辆资料删除成功";
		try{
			vehicleService.delete(vehicle);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "车辆资料删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除车辆资料
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "车辆资料删除成功";
		try{
			for(String id:ids.split(",")){
				VehicleEntity vehicle = systemService.getEntity(VehicleEntity.class, 
				id
				);
				vehicleService.delete(vehicle);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "车辆资料删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加车辆资料
	 * 
	 * @param vehicle
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VehicleEntity vehicle, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "车辆资料添加成功";
		try{
			vehicleService.save(vehicle);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "车辆资料添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(vehicle);
		return j;
	}
	
	/**
	 * 更新车辆资料
	 * 
	 * @param vehicle
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VehicleEntity vehicle, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "车辆资料更新成功";
		VehicleEntity t = vehicleService.get(VehicleEntity.class, vehicle.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(vehicle, t);
			vehicleService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "车辆资料更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 车辆资料新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VehicleEntity vehicle, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vehicle.getId())) {
			vehicle = vehicleService.getEntity(VehicleEntity.class, vehicle.getId());
			req.setAttribute("vehiclePage", vehicle);
		}
		return new ModelAndView("com/jeecg/vehicle/vehicle-add");
	}
	/**
	 * 车辆资料编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VehicleEntity vehicle, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vehicle.getId())) {
			vehicle = vehicleService.getEntity(VehicleEntity.class, vehicle.getId());
			req.setAttribute("vehiclePage", vehicle);
		}
		return new ModelAndView("com/jeecg/vehicle/vehicle-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","vehicleController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VehicleEntity vehicle,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(VehicleEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vehicle, request.getParameterMap());
		List<VehicleEntity> vehicles = this.vehicleService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"车辆资料");
		modelMap.put(NormalExcelConstants.CLASS,VehicleEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("车辆资料列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,vehicles);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(VehicleEntity vehicle,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"车辆资料");
    	modelMap.put(NormalExcelConstants.CLASS,VehicleEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("车辆资料列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<VehicleEntity> listVehicleEntitys = ExcelImportUtil.importExcel(file.getInputStream(),VehicleEntity.class,params);
				for (VehicleEntity vehicle : listVehicleEntitys) {
					vehicleService.save(vehicle);
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
	 * 获取文件附件信息
	 * 
	 * @param id vehicle主键id
	 */
	@RequestMapping(params = "getFiles")
	@ResponseBody
	public AjaxJson getFiles(String id){
		List<CgUploadEntity> uploadBeans = cgFormFieldService.findByProperty(CgUploadEntity.class, "cgformId", id);
		List<Map<String,Object>> files = new ArrayList<Map<String,Object>>(0);
		for(CgUploadEntity b:uploadBeans){
			String title = b.getAttachmenttitle();//附件名
			String fileKey = b.getId();//附件主键
			String path = b.getRealpath();//附件路径
			String field = b.getCgformField();//表单中作为附件控件的字段
			Map<String, Object> file = new HashMap<String, Object>();
			file.put("title", title);
			file.put("fileKey", fileKey);
			file.put("path", path);
			file.put("field", field==null?"":field);
			files.add(file);
		}
		AjaxJson j = new AjaxJson();
		j.setObj(files);
		return j;
	}
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="车辆资料列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<VehicleEntity>> list() {
		List<VehicleEntity> listVehicles=vehicleService.getList(VehicleEntity.class);
		return Result.success(listVehicles);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取车辆资料信息",notes="根据ID获取车辆资料信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		VehicleEntity task = vehicleService.get(VehicleEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取车辆资料信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建车辆资料")
	public ResponseMessage<?> create(@ApiParam(name="车辆资料对象")@RequestBody VehicleEntity vehicle, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VehicleEntity>> failures = validator.validate(vehicle);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			vehicleService.save(vehicle);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("车辆资料信息保存失败");
		}
		return Result.success(vehicle);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新车辆资料",notes="更新车辆资料")
	public ResponseMessage<?> update(@ApiParam(name="车辆资料对象")@RequestBody VehicleEntity vehicle) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<VehicleEntity>> failures = validator.validate(vehicle);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			vehicleService.saveOrUpdate(vehicle);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新车辆资料信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新车辆资料信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除车辆资料")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			vehicleService.deleteEntityById(VehicleEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("车辆资料删除失败");
		}

		return Result.success();
	}
}
