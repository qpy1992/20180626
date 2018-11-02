package com.jeecg.hexiao.controller;
import com.jeecg.hexiao.entity.HexiaoEntity;
import com.jeecg.hexiao.service.HexiaoServiceI;

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

/**   
 * @Title: Controller  
 * @Description: 核销
 * @author onlineGenerator
 * @date 2018-08-13 10:56:03
 * @version V1.0   
 *
 */
@Api(value="Hexiao",description="核销",tags="hexiaoController")
@Controller
@RequestMapping("/hexiaoController")
public class HexiaoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HexiaoController.class);

	@Autowired
	private HexiaoServiceI hexiaoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgReportServiceI cgReportService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	/**
	 * 核销列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String type = request.getParameter("type");
		logger.info(type);
		request.setAttribute("type",type);
		return new ModelAndView("com/jeecg/hexiao/hexiaoList");
	}

    @RequestMapping(params = "list1")
    public ModelAndView list1(HttpServletRequest request) {
        return new ModelAndView("com/jeecg/hexiao/hexiaoList1");
    }

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param hexiao
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(HexiaoEntity hexiao,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HexiaoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hexiao, request.getParameterMap());
		try{
		//自定义追加查询条件
			String type = request.getParameter("type");
			cq.eq("ftype",type);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hexiaoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "datagrid1")
	public void datagrid4(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String type = request.getParameter("type");
		String fsettle = request.getParameter("fsettlename");
		String ffapiao = request.getParameter("ffapiao");
		String fwtunit = request.getParameter("entrust");
		String fpaiche = request.getParameter("fpaiche");
		String fdriver = request.getParameter("fdriver");
		String ftidan = request.getParameter("fblno");
		String fboxno = request.getParameter("fboxno");
		Map queryparams =  new LinkedHashMap<String,Object>();
		String sql = "select * from t_s_log where id = '111'";
		String sql1 = "select * from t_s_log where id = '111'";
		if(StringUtil.isNotEmpty(fsettle)) {
			sql = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,b.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,b.fbillno fweituo,b.fentrust_unit entrust,d.fbillno fpaiche,b.fblno,c.fboxno from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where a.fhx='N' and a.fshoufu='"+type+"' and a.fsettlename like '%"+fsettle+"%'";
			sql1 = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,d.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,d.fbillno fweituo,d.fentrust_unit entrust,b.fbillno fpaiche,d.fblno,c.fboxno from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where a.fhx='N' and a.fshoufu='"+type+"' and a.fsettlename like '%"+fsettle+"%'";
		}
		if(StringUtil.isNotEmpty(ffapiao)){
			sql = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,b.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,b.fbillno fweituo,b.fentrust_unit entrust,d.fbillno fpaiche,b.fblno,c.fboxno from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where a.fhx='N' and a.fshoufu='"+type+"' and a.ffapiao like '%"+ffapiao+"%'";
			sql1 = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,d.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,d.fbillno fweituo,d.fentrust_unit entrust,b.fbillno fpaiche,d.fblno,c.fboxno from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where a.fhx='N' and a.fshoufu='"+type+"' and a.ffapiao like '%"+ffapiao+"%'";
		}
		if(StringUtil.isNotEmpty(fwtunit)){
			sql = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,b.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,b.fbillno fweituo,b.fentrust_unit entrust,d.fbillno fpaiche,b.fblno,c.fboxno from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where a.fhx='N' and a.fshoufu='"+type+"' and a.fentrust_unit like '%"+fwtunit+"%'";
			sql1 = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,d.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,d.fbillno fweituo,d.fentrust_unit entrust,b.fbillno fpaiche,d.fblno,c.fboxno from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where a.fhx='N' and a.fshoufu='"+type+"' and a.fentrust_unit like '%"+fwtunit+"%'";
		}
		if(StringUtil.isNotEmpty(fpaiche)){
			sql = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,b.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,b.fbillno fweituo,b.fentrust_unit entrust,d.fbillno fpaiche,b.fblno,c.fboxno from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where a.fhx='N' and a.fshoufu='"+type+"' and d.fbillno like '%"+fpaiche+"%'";
			sql1 = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,d.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,d.fbillno fweituo,d.fentrust_unit entrust,b.fbillno fpaiche,d.fblno,c.fboxno from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where a.fhx='N' and a.fshoufu='"+type+"' and b.fbillno like '%"+fpaiche+"%'";
		}
		if(StringUtil.isNotEmpty(fdriver)){
			sql = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,b.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,b.fbillno fweituo,b.fentrust_unit entrust,d.fbillno fpaiche,b.fblno,c.fboxno from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where a.fhx='N' and a.fshoufu='"+type+"' and d.fdriver like '%"+fdriver+"%'";
			sql1 = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,d.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,d.fbillno fweituo,d.fentrust_unit entrust,b.fbillno fpaiche,d.fblno,c.fboxno from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where a.fhx='N' and a.fshoufu='"+type+"' and b.fdriver like '%"+fdriver+"%'";
		}
		if(StringUtil.isNotEmpty(ftidan)){
			sql = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,b.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,b.fbillno fweituo,b.fentrust_unit entrust,d.fbillno fpaiche,b.fblno,c.fboxno from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where a.fhx='N' and a.fshoufu='"+type+"' and b.fblno like '%"+ftidan+"%'";
			sql1 = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,d.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,d.fbillno fweituo,d.fentrust_unit entrust,b.fbillno fpaiche,d.fblno,c.fboxno from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where a.fhx='N' and a.fshoufu='"+type+"' and d.fblno like '%"+ftidan+"%'";
		}
		if(StringUtil.isNotEmpty(fboxno)){
			sql = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,b.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,b.fbillno fweituo,b.fentrust_unit entrust,d.fbillno fpaiche,b.fblno,c.fboxno from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where a.fhx='N' and a.fshoufu='"+type+"' and b.fboxno like '%"+fboxno+"%'";
			sql1 = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,d.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,d.fbillno fweituo,d.fentrust_unit entrust,b.fbillno fpaiche,d.fblno,c.fboxno from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where a.fhx='N' and a.fshoufu='"+type+"' and d.fboxno like '%"+fboxno+"%'";
		}
		logger.info(sql);
		List<Map<String, Object>> result= cgReportService.queryByCgReportSql(sql, queryparams, dataGrid.getPage(), dataGrid.getRows());
		List<Map<String, Object>> result1= cgReportService.queryByCgReportSql(sql1, queryparams, dataGrid.getPage(), dataGrid.getRows());
		result.addAll(result1);
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

    @RequestMapping(params = "datagrid2")
    public void datagrid2(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        String fsettle = request.getParameter("fsettlename");
        String ffapiao = request.getParameter("ffapiao");
        String fwtunit = request.getParameter("entrust");
        String fpaiche = request.getParameter("fpaiche");
        String fdriver = request.getParameter("fdriver");
        String ftidan = request.getParameter("fblno");
        String fboxno = request.getParameter("fboxno");
        Map queryparams =  new LinkedHashMap<String,Object>();
        String sql = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,b.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,a.fhxamount,a.fshiji factualamount,b.fbillno fweituo,b.fentrust_unit entrust,d.fbillno fpaiche,b.fblno,c.fboxno from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where a.fhx='Y' ";
        String sql1 = "select a.id,a.fhx,a.fsettlename,a.fcostname,a.famount,a.fsfamount,a.fdd,d.fnote,a.ffapiao,a.fcheck,a.fremain fbcamount,a.fhxamount,a.fshiji factualamount,d.fbillno fweituo,d.fentrust_unit entrust,b.fbillno fpaiche,d.fblno,c.fboxno from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where a.fhx='Y' ";
        if(StringUtil.isNotEmpty(fsettle)) {
            sql = sql + "and a.fsettlename like '%"+fsettle+"%'";
            sql1 = sql1 + "and a.fsettlename like '%"+fsettle+"%'";
        }
        if(StringUtil.isNotEmpty(ffapiao)){
            sql = sql + "and a.ffapiao like '%"+ffapiao+"%'";
            sql1 = sql1 + "and a.ffapiao like '%"+ffapiao+"%'";
        }
        if(StringUtil.isNotEmpty(fwtunit)){
            sql = sql + "and a.fentrust_unit like '%"+fwtunit+"%'";
            sql1 = sql1 + "and a.fentrust_unit like '%"+fwtunit+"%'";
        }
        if(StringUtil.isNotEmpty(fpaiche)){
            sql = sql + "and d.fbillno like '%"+fpaiche+"%'";
            sql1 = sql1 + "and b.fbillno like '%"+fpaiche+"%'";
        }
        if(StringUtil.isNotEmpty(fdriver)){
            sql = sql + "and d.fdriver like '%"+fdriver+"%'";
            sql1 = sql1 + "and b.fdriver like '%"+fdriver+"%'";
        }
        if(StringUtil.isNotEmpty(ftidan)){
            sql = sql + "and b.fblno like '%"+ftidan+"%'";
            sql1 = sql1 + "and d.fblno like '%"+ftidan+"%'";
        }
        if(StringUtil.isNotEmpty(fboxno)){
            sql = sql + "and b.fboxno like '%"+fboxno+"%'";
            sql1 = sql1 + "and d.fboxno like '%"+fboxno+"%'";
        }
        logger.info(sql);
        List<Map<String, Object>> result= cgReportService.queryByCgReportSql(sql, queryparams, dataGrid.getPage(), dataGrid.getRows());
        List<Map<String, Object>> result1= cgReportService.queryByCgReportSql(sql1, queryparams, dataGrid.getPage(), dataGrid.getRows());
        result.addAll(result1);
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
	 * 保存新增/更新的行数据
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "saveRows")
	@ResponseBody
	public AjaxJson saveRows(HttpServletRequest request){
		String message = null;
		String uprows = request.getParameter("result");
		logger.info(uprows);
		String[] array = uprows.split("/");
		AjaxJson j = new AjaxJson();
		try {
			message = "核销成功";
			String id = array[0];
			systemService.executeSql("update z_charge set fhx='Y' where id='"+id+"'");
			String last = jdbcTemplate.queryForObject("select fremain from z_charge where id=?",String.class,id);
			String hx = array[1];
			Double ye = Double.parseDouble(hx)-Double.parseDouble(last);
			systemService.executeSql("update z_charge set fhxamount="+hx+",fremain="+ye+",fshiji="+array[3]+" where id='"+id+"'");
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return j;
	}

	/**
	 * 删除核销
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HexiaoEntity hexiao, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hexiao = systemService.getEntity(HexiaoEntity.class, hexiao.getId());
		message = "核销删除成功";
		try{
			hexiaoService.delete(hexiao);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "核销删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除核销
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "核销删除成功";
		try{
			for(String id:ids.split(",")){
				HexiaoEntity hexiao = systemService.getEntity(HexiaoEntity.class, id);
				hexiaoService.delete(hexiao);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "核销删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加核销
	 * 
	 * @param hexiao
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HexiaoEntity hexiao, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "核销添加成功";
		try{
			hexiaoService.save(hexiao);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "核销添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新核销
	 * 
	 * @param hexiao
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HexiaoEntity hexiao, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "核销更新成功";
		HexiaoEntity t = hexiaoService.get(HexiaoEntity.class, hexiao.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hexiao, t);
			hexiaoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "核销更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 核销新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HexiaoEntity hexiao, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hexiao.getId())) {
			hexiao = hexiaoService.getEntity(HexiaoEntity.class, hexiao.getId());
			req.setAttribute("hexiaoPage", hexiao);
		}
		return new ModelAndView("com/jeecg/hexiao/hexiao-add");
	}
	/**
	 * 核销编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HexiaoEntity hexiao, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hexiao.getId())) {
			hexiao = hexiaoService.getEntity(HexiaoEntity.class, hexiao.getId());
			req.setAttribute("hexiaoPage", hexiao);
		}
		return new ModelAndView("com/jeecg/hexiao/hexiao-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hexiaoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HexiaoEntity hexiao,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HexiaoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hexiao, request.getParameterMap());
		List<HexiaoEntity> hexiaos = this.hexiaoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"核销");
		modelMap.put(NormalExcelConstants.CLASS,HexiaoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("核销列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hexiaos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HexiaoEntity hexiao,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"核销");
    	modelMap.put(NormalExcelConstants.CLASS,HexiaoEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("核销列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HexiaoEntity> listHexiaoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HexiaoEntity.class,params);
				for (HexiaoEntity hexiao : listHexiaoEntitys) {
					hexiaoService.save(hexiao);
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
	@ApiOperation(value="核销列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<HexiaoEntity>> list() {
		List<HexiaoEntity> listHexiaos=hexiaoService.getList(HexiaoEntity.class);
		return Result.success(listHexiaos);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取核销信息",notes="根据ID获取核销信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		HexiaoEntity task = hexiaoService.get(HexiaoEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取核销信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建核销")
	public ResponseMessage<?> create(@ApiParam(name="核销对象")@RequestBody HexiaoEntity hexiao, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<HexiaoEntity>> failures = validator.validate(hexiao);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			hexiaoService.save(hexiao);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("核销信息保存失败");
		}
		return Result.success(hexiao);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新核销",notes="更新核销")
	public ResponseMessage<?> update(@ApiParam(name="核销对象")@RequestBody HexiaoEntity hexiao) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<HexiaoEntity>> failures = validator.validate(hexiao);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			hexiaoService.saveOrUpdate(hexiao);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新核销信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新核销信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除核销")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			hexiaoService.deleteEntityById(HexiaoEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("核销删除失败");
		}

		return Result.success();
	}
}
