package com.jeecg.paiban.controller;

import com.jeecg.contianer.entity.ContianerEntity;
import com.jeecg.customentrust.entity.CustomEntrustEntity;
import com.jeecg.paiban.entity.PaibanEntity;
import com.jeecg.paiban.service.PaibanServiceI;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jeecg.paiche.entity.PaicheEntity;
import com.jeecg.schdaily.entity.SchdailyEntity;
import com.jeecg.vehicle.entity.VehicleEntity;
import com.jeecg.vehicle.entity.VtsEntity;
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
 * @Description: 计划排班
 * @author onlineGenerator
 * @date 2018-07-16 14:54:26
 * @version V1.0   
 *
 */
@Api(value="Paiban",description="计划排班",tags="paibanController")
@Controller
@RequestMapping("/paibanController")
public class PaibanController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PaibanController.class);

	@Autowired
	private PaibanServiceI paibanService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//106.12.83.98:8080/20180626_war
	/**
	 * 计划排班列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/paiban/paibanList");
	}

	@RequestMapping(params = "vehicle")
	public ModelAndView vehicle(HttpServletRequest request) {
		String contianerId = request.getParameter("contianerId");
		String entrustId = request.getParameter("entrustId");
		request.setAttribute("contianerId",contianerId);
		request.setAttribute("entrustId",entrustId);
		return new ModelAndView("com/jeecg/paiban/vehicleList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param paiban
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(PaibanEntity paiban,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PaibanEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, paiban, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.paibanService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除计划排班
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(PaibanEntity paiban, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		paiban = systemService.getEntity(PaibanEntity.class, paiban.getId());
		message = "计划排班删除成功";
		try{
			paibanService.delete(paiban);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "计划排班删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除计划排班
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "计划排班删除成功";
		try{
			for(String id:ids.split(",")){
				PaibanEntity paiban = systemService.getEntity(PaibanEntity.class, 
				id
				);
				paibanService.delete(paiban);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "计划排班删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加计划排班
	 * 
	 * @param paiban
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(PaibanEntity paiban, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "计划排班添加成功";
		try{
			paibanService.save(paiban);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "计划排班添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 车辆排班
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "paiban")
	@ResponseBody
	public AjaxJson paiban(HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "排班成功";
		try{
			//需要用到的id,车辆id,箱货id,委托单id
			String vehId = request.getParameter("vehId");
			String contianerId = request.getParameter("contianerId");
			String entrustId = request.getParameter("entrustId");
			logger.info("车辆id:"+vehId+"箱子id:"+contianerId+"委托单id:"+entrustId);
			CustomEntrustEntity customEntrust = systemService.getEntity(CustomEntrustEntity.class,entrustId);
			ContianerEntity container = systemService.getEntity(ContianerEntity.class,contianerId);
			VehicleEntity vehicle = systemService.getEntity(VehicleEntity.class,vehId);
			VtsEntity vts = systemService.findUniqueByProperty(VtsEntity.class,"vehId",vehId);
			String trailer = jdbcTemplate.queryForObject("select fname from z_trailer where id=?",String.class,vts.getTraId());
			String siji = jdbcTemplate.queryForObject("select fname from z_siji where id=?",String.class,vts.getSijiId());
			String fdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			//车讯车辆今日排班记录已生成
			List<String> paibanId = jdbcTemplate.queryForList("select id from z_paiban where fcarno=? and fdate=?",String.class,new Object[]{vehicle.getFcarno(),fdate});
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//生成派车单号
			String pcbillno	= systemService.getFbillno(82);
			//如果为空，表明未排班，直接排第一班
			if(paibanId.isEmpty()){
				//生成排班记录
				PaibanEntity paiban = new PaibanEntity();
				paiban.setFcarcode(vehicle.getFitemid());
				paiban.setFcarno(vehicle.getFcarno());
				paiban.setFdriver(siji);
				paiban.setFoutercar("否");
				paiban.setFdate(fdate);
				paiban.setFbillno1(pcbillno);
				paiban.setFaddress1(container.getFxhdpdz());
				paiban.setFbackTime1(sdf.parse(request.getParameter("fbacktime")));
				paibanService.save(paiban);
				container.setFbillno(pcbillno);
				container.setFzanluo("N");
				vehicle.setFbacktime(sdf.parse(request.getParameter("fbacktime")));
				//新增派车单
				PaicheEntity paiche = new PaicheEntity();
				paiche.setFbillno(pcbillno);//派车单号
				paiche.setFcarcode(paiban.getFcarcode());//车辆编号
				paiche.setFcarno(paiban.getFcarno());//车牌号
				paiche.setFtranstime(sdf.parse(paiban.getFdate()+" 00:00:00"));//运输时间
				paiche.setCreateDate(new Date());//录入时间
				paiche.setFtype("集卡");
				paiche.setFdriver(siji);//司机
				paiche.setFstatus("新建");
				paiche.setFdoorpoint(container.getFxhdpdz());
				paiche.setFbanci("头班");
				paiche.setFcheck("0");
				paiche.setFboxid(container.getId());
				systemService.save(paiche);
				//保存调度日记
				SchdailyEntity schdaily = new SchdailyEntity();
				schdaily.setFtuoyun(customEntrust.getFentrustUnit());
				schdaily.setFpaicheno(pcbillno);
				schdaily.setFtxyard(container.getFextract());
				schdaily.setFzhtime(container.getFmakeboxtime());
				schdaily.setFzhaddress(container.getFzhdpdz());
				schdaily.setFxhtime(container.getFxhtime());
				schdaily.setFxhaddress(container.getFxhdpdz());
				schdaily.setFhxyard(container.getFreturn());
				schdaily.setFboxamount(container.getFboxtype());
				schdaily.setFboxno(container.getFboxno());
				schdaily.setFcarno(paiche.getFcarno());
				schdaily.setFguano(trailer);
				schdaily.setFdriver(paiche.getFdriver());
				schdaily.setFbudget(0.00);
				schdaily.setFnote(customEntrust.getFnote());
				schdaily.setFdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				systemService.save(schdaily);
				//不为空表明至少已排一班
			}else{
				//判断时候是2班，获取排班记录
				PaibanEntity paiban = systemService.getEntity(PaibanEntity.class, paibanId.get(0));
				if (StringUtil.isEmpty(paiban.getFbillno2())) {
					paiban.setFbillno2(pcbillno);
					paiban.setFaddress2(container.getFxhdpdz());
					paiban.setFbackTime2(sdf.parse(request.getParameter("fbacktime")));
					paibanService.saveOrUpdate(paiban);
					container.setFbillno(pcbillno);
					container.setFzanluo("N");
					vehicle.setFbacktime(sdf.parse(request.getParameter("fbacktime")));
					//新增派车单
					PaicheEntity paiche = new PaicheEntity();
					paiche.setFbillno(pcbillno);//派车单号
					paiche.setFcarcode(paiban.getFcarcode());//车辆编号
					paiche.setFcarno(paiban.getFcarno());//车牌号
					paiche.setFtranstime(sdf.parse(paiban.getFdate() + " 00:00:00"));//运输时间
					paiche.setCreateDate(new Date());//录入时间
					paiche.setFtype("集卡");
					paiche.setFdriver(siji);//司机
					paiche.setFstatus("新建");
					paiche.setFdoorpoint(container.getFxhdpdz());
					paiche.setFbanci("二班");
					paiche.setFcheck("0");
					paiche.setFboxid(container.getId());
					systemService.save(paiche);
					//保存调度日记
					SchdailyEntity schdaily = new SchdailyEntity();
					schdaily.setFtuoyun(customEntrust.getFentrustUnit());
					schdaily.setFpaicheno(pcbillno);
					schdaily.setFtxyard(container.getFextract());
					schdaily.setFzhtime(container.getFmakeboxtime());
					schdaily.setFzhaddress(container.getFzhdpdz());
					schdaily.setFxhtime(container.getFxhtime());
					schdaily.setFxhaddress(container.getFxhdpdz());
					schdaily.setFhxyard(container.getFreturn());
					schdaily.setFboxamount(container.getFboxtype());
					schdaily.setFboxno(container.getFboxno());
					schdaily.setFcarno(paiche.getFcarno());
					schdaily.setFguano(trailer);
					schdaily.setFdriver(paiche.getFdriver());
					schdaily.setFbudget(0.00);
					schdaily.setFnote(customEntrust.getFnote());
					schdaily.setFdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					systemService.save(schdaily);
				} else if (StringUtil.isNotEmpty(paiban.getFbillno2()) && StringUtil.isEmpty(paiban.getFbillno3())) {
					paiban.setFbillno3(pcbillno);
					paiban.setFaddress3(container.getFxhdpdz());
					paiban.setFbackTime3(sdf.parse(request.getParameter("fbacktime")));
					paibanService.saveOrUpdate(paiban);
					container.setFbillno(pcbillno);
					container.setFzanluo("N");
//					vehicle.setFbacktime(sdf.parse(request.getParameter("fbacktime")));
					//新增派车单
					PaicheEntity paiche = new PaicheEntity();
					paiche.setFbillno(pcbillno);//派车单号
					paiche.setFcarcode(paiban.getFcarcode());//车辆编号
					paiche.setFcarno(paiban.getFcarno());//车牌号
					paiche.setFtranstime(sdf.parse(paiban.getFdate() + " 00:00:00"));//运输时间
					paiche.setCreateDate(new Date());//录入时间
					paiche.setFtype("集卡");
					paiche.setFdriver(siji);//司机
					paiche.setFstatus("新建");
					paiche.setFdoorpoint(container.getFxhdpdz());
					paiche.setFbanci("三班");
					paiche.setFcheck("0");
					paiche.setFboxid(container.getId());
					systemService.save(paiche);
					//保存调度日记
					SchdailyEntity schdaily = new SchdailyEntity();
					schdaily.setFtuoyun(customEntrust.getFentrustUnit());
					schdaily.setFpaicheno(pcbillno);
					schdaily.setFtxyard(container.getFextract());
					schdaily.setFzhtime(container.getFmakeboxtime());
					schdaily.setFzhaddress(container.getFzhdpdz());
					schdaily.setFxhtime(container.getFxhtime());
					schdaily.setFxhaddress(container.getFxhdpdz());
					schdaily.setFhxyard(container.getFreturn());
					schdaily.setFboxamount(container.getFboxtype());
					schdaily.setFboxno(container.getFboxno());
					schdaily.setFcarno(paiche.getFcarno());
					schdaily.setFguano(trailer);
					schdaily.setFdriver(paiche.getFdriver());
					schdaily.setFbudget(0.00);
					schdaily.setFnote(customEntrust.getFnote());
					schdaily.setFdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					systemService.save(schdaily);
				} else if (StringUtil.isNotEmpty(paiban.getFbillno3()) && StringUtil.isEmpty(paiban.getFbillno4())) {
					paiban.setFbillno4(pcbillno);
					paiban.setFaddress4(container.getFxhdpdz());
					paiban.setFbackTime4(sdf.parse(request.getParameter("fbacktime")));
					paibanService.saveOrUpdate(paiban);
					container.setFbillno(pcbillno);
					container.setFzanluo("N");
					vehicle.setFbacktime(sdf.parse(request.getParameter("fbacktime")));
					//新增派车单
					PaicheEntity paiche = new PaicheEntity();
					paiche.setFbillno(pcbillno);//派车单号
					paiche.setFcarcode(paiban.getFcarcode());//车辆编号
					paiche.setFcarno(paiban.getFcarno());//车牌号
					paiche.setFtranstime(sdf.parse(paiban.getFdate() + " 00:00:00"));//运输时间
					paiche.setCreateDate(new Date());//录入时间
					paiche.setFtype("集卡");
					paiche.setFdriver(siji);//司机
					paiche.setFstatus("新建");
					paiche.setFdoorpoint(container.getFxhdpdz());
					paiche.setFbanci("四班");
					paiche.setFcheck("0");
					paiche.setFboxid(container.getId());
					systemService.save(paiche);
					//保存调度日记
					SchdailyEntity schdaily = new SchdailyEntity();
					schdaily.setFtuoyun(customEntrust.getFentrustUnit());
					schdaily.setFpaicheno(pcbillno);
					schdaily.setFtxyard(container.getFextract());
					schdaily.setFzhtime(container.getFmakeboxtime());
					schdaily.setFzhaddress(container.getFzhdpdz());
					schdaily.setFxhtime(container.getFxhtime());
					schdaily.setFxhaddress(container.getFxhdpdz());
					schdaily.setFhxyard(container.getFreturn());
					schdaily.setFboxamount(container.getFboxtype());
					schdaily.setFboxno(container.getFboxno());
					schdaily.setFcarno(paiche.getFcarno());
					schdaily.setFguano(trailer);
					schdaily.setFdriver(paiche.getFdriver());
					schdaily.setFbudget(0.00);
					schdaily.setFnote(customEntrust.getFnote());
					schdaily.setFdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					systemService.save(schdaily);
				} else if (StringUtil.isNotEmpty(paiban.getFbillno4()) && StringUtil.isEmpty(paiban.getFbillno5())) {
					paiban.setFbillno5(pcbillno);
					paiban.setFaddress5(container.getFxhdpdz());
					paiban.setFbackTime5(sdf.parse(request.getParameter("fbacktime")));
					paibanService.saveOrUpdate(paiban);
					container.setFbillno(pcbillno);
					container.setFzanluo("N");
					vehicle.setFbacktime(sdf.parse(request.getParameter("fbacktime")));
					//新增派车单
					PaicheEntity paiche = new PaicheEntity();
					paiche.setFbillno(pcbillno);//派车单号
					paiche.setFcarcode(paiban.getFcarcode());//车辆编号
					paiche.setFcarno(paiban.getFcarno());//车牌号
					paiche.setFtranstime(sdf.parse(paiban.getFdate() + " 00:00:00"));//运输时间
					paiche.setCreateDate(new Date());//录入时间
					paiche.setFtype("集卡");
					paiche.setFdriver(siji);//司机
					paiche.setFstatus("新建");
					paiche.setFdoorpoint(container.getFxhdpdz());
					paiche.setFbanci("五班");
					paiche.setFcheck("0");
					paiche.setFboxid(container.getId());
					systemService.save(paiche);
					//保存调度日记
					SchdailyEntity schdaily = new SchdailyEntity();
					schdaily.setFtuoyun(customEntrust.getFentrustUnit());
					schdaily.setFpaicheno(pcbillno);
					schdaily.setFtxyard(container.getFextract());
					schdaily.setFzhtime(container.getFmakeboxtime());
					schdaily.setFzhaddress(container.getFzhdpdz());
					schdaily.setFxhtime(container.getFxhtime());
					schdaily.setFxhaddress(container.getFxhdpdz());
					schdaily.setFhxyard(container.getFreturn());
					schdaily.setFboxamount(container.getFboxtype());
					schdaily.setFboxno(container.getFboxno());
					schdaily.setFcarno(paiche.getFcarno());
					schdaily.setFguano(trailer);
					schdaily.setFdriver(paiche.getFdriver());
					schdaily.setFbudget(0.00);
					schdaily.setFnote(customEntrust.getFnote());
					schdaily.setFdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					systemService.save(schdaily);
				}else{
					message = "当日班次已排满";
				}
			}
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "排班失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	@RequestMapping(params = "paiban1")
	public ModelAndView paiban1( HttpServletRequest req) {
		req.setAttribute("contianerId",req.getParameter("contianerId"));
		req.setAttribute("entrustId",req.getParameter("entrustId"));
		req.setAttribute("vehId",req.getParameter("vehId"));
		return new ModelAndView("com/jeecg/paiban/paiban1");
	}

	/**
	 * 更新计划排班
	 * 
	 * @param paiban
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(PaibanEntity paiban, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "计划排班更新成功";
		PaibanEntity t = paibanService.get(PaibanEntity.class, paiban.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(paiban, t);
			paibanService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "计划排班更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 计划排班新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(PaibanEntity paiban, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(paiban.getId())) {
			paiban = paibanService.getEntity(PaibanEntity.class, paiban.getId());
			req.setAttribute("paibanPage", paiban);
		}
		return new ModelAndView("com/jeecg/paiban/paiban-add");
	}
	/**
	 * 计划排班编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(PaibanEntity paiban, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(paiban.getId())) {
			paiban = paibanService.getEntity(PaibanEntity.class, paiban.getId());
			req.setAttribute("paibanPage", paiban);
		}
		return new ModelAndView("com/jeecg/paiban/paiban-update");
	}

	@RequestMapping(params = "quxiao")
	public ModelAndView quxiao(HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id",id);
		return new ModelAndView("com/jeecg/paiban/quxiao");
	}

	@RequestMapping(params = "doQuxiao")
	@ResponseBody
	public AjaxJson doQuxiao(HttpServletRequest request) {
		String message = null;
		String id = request.getParameter("id");
		String[] bc = request.getParameterValues("times");
		AjaxJson j = new AjaxJson();
		message = "取消排班成功";
		try{
			PaibanEntity paiban = systemService.getEntity(PaibanEntity.class,id);
			String fpaiche = "";
			String fcheck = "";
			for(int i=0;i<bc.length;i++) {
				logger.info(bc[i]);
				switch(Integer.parseInt(bc[i])){
					case 1:
						fpaiche = paiban.getFbillno1();
						fcheck = jdbcTemplate.queryForObject("select fcheck from z_paiche where fbillno=?",String.class,fpaiche);
						if(fcheck.equals("1")){
							message = "派车单已审核，无法取消！";
						}else if(StringUtil.isNotEmpty(fpaiche)){
							paiban.setFbillno1("");
							paiban.setFaddress1("");
							paiban.setFbackTime1(null);
							systemService.executeSql("delete from z_paiche where fbillno='"+fpaiche+"'");
							systemService.executeSql("update z_contianer set fbillno=null where fbillno='"+fpaiche+"'");
						}
						break;
					case 2:
						fpaiche = paiban.getFbillno2();
						fcheck = jdbcTemplate.queryForObject("select fcheck from z_paiche where fbillno=?",String.class,fpaiche);
						if(fcheck.equals("1")){
							message = "派车单已审核，无法取消！";
						}else if(StringUtil.isNotEmpty(fpaiche)){
							paiban.setFbillno2("");
							paiban.setFaddress2("");
							paiban.setFbackTime2(null);
							systemService.executeSql("delete from z_paiche where fbillno='"+fpaiche+"'");
							systemService.executeSql("update z_contianer set fbillno=null where fbillno='"+fpaiche+"'");
						}
						break;
					case 3:
						fpaiche = paiban.getFbillno3();
						fcheck = jdbcTemplate.queryForObject("select fcheck from z_paiche where fbillno=?",String.class,fpaiche);
						if(fcheck.equals("1")){
							message = "派车单已审核，无法取消！";
						}else if(StringUtil.isNotEmpty(fpaiche)){
							paiban.setFbillno3("");
							paiban.setFaddress3("");
							paiban.setFbackTime3(null);
							systemService.executeSql("delete from z_paiche where fbillno='"+fpaiche+"'");
							systemService.executeSql("update z_contianer set fbillno=null where fbillno='"+fpaiche+"'");
						}
						break;
					case 4:
						fpaiche = paiban.getFbillno4();
						fcheck = jdbcTemplate.queryForObject("select fcheck from z_paiche where fbillno=?",String.class,fpaiche);
						if(fcheck.equals("1")){
							message = "派车单已审核，无法取消！";
						}else if(StringUtil.isNotEmpty(fpaiche)){
							paiban.setFbillno4("");
							paiban.setFaddress4("");
							paiban.setFbackTime4(null);
							systemService.executeSql("delete from z_paiche where fbillno='"+fpaiche+"'");
							systemService.executeSql("update z_contianer set fbillno=null where fbillno='"+fpaiche+"'");
						}
						break;
					case 5:
						fpaiche = paiban.getFbillno5();
						fcheck = jdbcTemplate.queryForObject("select fcheck from z_paiche where fbillno=?",String.class,fpaiche);
						if(fcheck.equals("1")){
							message = "派车单已审核，无法取消！";
						}else if(StringUtil.isNotEmpty(fpaiche)){
							paiban.setFbillno5("");
							paiban.setFaddress5("");
							paiban.setFbackTime5(null);
							systemService.executeSql("delete from z_paiche where fbillno='"+fpaiche+"'");
							systemService.executeSql("update z_contianer set fbillno=null where fbillno='"+fpaiche+"'");
						}
						break;
				}
			}
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "取消排班失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","paibanController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(PaibanEntity paiban,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(PaibanEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, paiban, request.getParameterMap());
		List<PaibanEntity> paibans = this.paibanService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"计划排班");
		modelMap.put(NormalExcelConstants.CLASS,PaibanEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("计划排班列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,paibans);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(PaibanEntity paiban,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"计划排班");
    	modelMap.put(NormalExcelConstants.CLASS,PaibanEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("计划排班列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<PaibanEntity> listPaibanEntitys = ExcelImportUtil.importExcel(file.getInputStream(),PaibanEntity.class,params);
				for (PaibanEntity paiban : listPaibanEntitys) {
					paibanService.save(paiban);
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
	 * 待排集装箱信息跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "containerSelect")
	public ModelAndView containerSelect(HttpServletRequest req) {
		return new ModelAndView("com/jeecg/paiban/containerSelect");
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="计划排班列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<PaibanEntity>> list() {
		List<PaibanEntity> listPaibans=paibanService.getList(PaibanEntity.class);
		return Result.success(listPaibans);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取计划排班信息",notes="根据ID获取计划排班信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		PaibanEntity task = paibanService.get(PaibanEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取计划排班信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建计划排班")
	public ResponseMessage<?> create(@ApiParam(name="计划排班对象")@RequestBody PaibanEntity paiban, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<PaibanEntity>> failures = validator.validate(paiban);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			paibanService.save(paiban);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("计划排班信息保存失败");
		}
		return Result.success(paiban);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新计划排班",notes="更新计划排班")
	public ResponseMessage<?> update(@ApiParam(name="计划排班对象")@RequestBody PaibanEntity paiban) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<PaibanEntity>> failures = validator.validate(paiban);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			paibanService.saveOrUpdate(paiban);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新计划排班信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新计划排班信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除计划排班")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			paibanService.deleteEntityById(PaibanEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("计划排班删除失败");
		}

		return Result.success();
	}
}
