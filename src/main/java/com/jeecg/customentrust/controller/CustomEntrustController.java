package com.jeecg.customentrust.controller;
import com.jeecg.charge.entity.ChargeEntity;
import com.jeecg.cuscontact.entity.CustomContactsEntity;
import com.jeecg.cussales.entity.CustomSalesmanEntity;
import com.jeecg.customentrust.entity.CustomEntrustEntity;
import com.jeecg.customentrust.service.CustomEntrustServiceI;

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
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.online.util.CgReportQueryParamUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.cgreport.service.core.CgReportServiceI;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.PrintWriter;

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
 * @Description: 客户委托
 * @author onlineGenerator
 * @date 2018-08-01 16:13:16
 * @version V1.0   
 *
 */
@Api(value="CustomEntrust",description="客户委托",tags="customEntrustController")
@Controller
@RequestMapping("/customEntrustController")
public class CustomEntrustController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CustomEntrustController.class);

	@Autowired
	private CustomEntrustServiceI customEntrustService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private Validator validator;
	
	@Autowired
	private CgReportServiceI cgReportService;

	/**
	 * 客户委托列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/customentrust/customEntrustList");
	}

	@RequestMapping(params = "entrustdetail")
	public ModelAndView entrustdetail(HttpServletRequest request) {
		String cid = request.getParameter("cid");
		logger.info("主表的id："+cid);
		request.setAttribute("cid",cid);
		return new ModelAndView("com/jeecg/customentrust/entrustDetail");
	}

	@RequestMapping(params = "chargeList")
	public ModelAndView chargeList(HttpServletRequest request) {
		String cid = request.getParameter("cid");
		String fentrustunit = request.getParameter("fentrustunit");
		String fbillno = request.getParameter("fbillno");
		String fblno = request.getParameter("fblno");
		logger.info("主表的id："+cid);
		logger.info("委托单位："+fentrustunit);
		logger.info("委托单号："+fbillno);
		logger.info("提单号："+fblno);
		request.setAttribute("cid",cid);
		request.setAttribute("fentrustunit",fentrustunit);
		request.setAttribute("fbillno",fbillno);
		request.setAttribute("fblno",fblno);
		return new ModelAndView("com/jeecg/customentrust/chargeList");
	}

    @RequestMapping(params = "list1")
    public ModelAndView list1(HttpServletRequest request) {
        System.out.println("传过来的id:"+request.getParameter("ids"));
        request.setAttribute("cid",request.getParameter("ids"));
        return new ModelAndView("com/jeecg/customentrust/customContactsList");
    }

    @RequestMapping(params = "list2")
    public ModelAndView list2(HttpServletRequest request) {
        System.out.println("传过来的id:"+request.getParameter("ids"));
        request.setAttribute("cid",request.getParameter("ids"));
        return new ModelAndView("com/jeecg/customentrust/customSalesmanList");
    }

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param customEntrust
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(CustomEntrustEntity customEntrust,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomEntrustEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customEntrust, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.customEntrustService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "datagrid1")
	public void datagrid1(ChargeEntity charge, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		Map queryparams =  new LinkedHashMap<String,Object>();
		String cid = request.getParameter("cid");
		String sql ="select a.id,a.fcheck,c.fbillno+'-'+b.fno fbillno1,a.fcostname,a.fprice,a.fqty,a.famount,a.fsettlename,a.create_name createName,a.create_date createDate,a.update_name updateName,a.update_date updateDate,a.fchecker,a.fcheckdate from z_charge a left join z_contianer b on b.id=a.conid left join z_custom_entrust c on c.id=a.fid where a.fid='"+cid+"' and a.fshoufu = '0'";
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

    @RequestMapping(params = "datagrid2")
    public void datagrid2(CustomContactsEntity customContacts, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(CustomContactsEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customContacts);
        try{
            //自定义追加查询条件
            cq.eq("fid",request.getParameter("cid"));
        }catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.customEntrustService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    @RequestMapping(params = "datagrid3")
    public void datagrid3(CustomSalesmanEntity customSalesman, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(CustomSalesmanEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customSalesman);
        try{
            //自定义追加查询条件
            cq.eq("fid",request.getParameter("did"));
        }catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.customEntrustService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }
	
	@RequestMapping(params = "datagridadd")
	public void datagridadd(CustomEntrustEntity customEntrust,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String sql =null;
		String aa=request.getParameter("");
		Map queryparams =  new LinkedHashMap<String,Object>();
		sql = "Select a.fcheck,a.id,a.fbillno,a.fentrust_unit fentrustunit,a.FOPERATE_TIME foperatetime,a.fcontact," +
				"a.fphone,a.fmobile,a.fsalesman,a.FBUSS_TYPE fbusstype,a.FLOAD_PORT floadport,a.fcontractno," +
				"a.ftrans_type ftranstype,a.fcus_code fcuscode,a.ftransport,a.fshipname,a.fvoyageno,a.fblno,a.ftargetport," +
				"a.fkinds,b.fboxno,b.ftitle,b.fboxtype,b.fmodel,b.fmakeboxtime,b.fgrade,b.fdrpagenum,b.funnumber,b.flash_point flashpoint,b.fcolddegree,b.ftotals,b.fgrosses,b.fvolumes,b.fextract,b.freturn,b.foperator,b.fid,b.fzhdp,b.fzhdpdz,b.fzhunit,b.fzhcontact,b.fzhmobile,b.fnote,b.ftsyw,b.fxhdp,b.fxhdpdz,b.fxhtime,b.fxhunit,b.fxhcontact,b.fxhmobile,b.fbillno fbillno2,b.fzanluo from z_custom_entrust a left join z_contianer b on a.id=b.fid where 1=1";
		String sql1 = "Select a.fcheck,a.id,a.fbillno,a.fentrust_unit fentrustunit,a.FOPERATE_TIME foperatetime,a.fcontact," +
                "a.fphone,a.fmobile,a.fsalesman,a.FBUSS_TYPE fbusstype,a.FLOAD_PORT floadport,a.fcontractno," +
                "a.ftrans_type ftranstype,a.fcus_code fcuscode,a.ftransport,a.fshipname,a.fvoyageno,a.fblno,a.ftargetport," +
                "a.fkinds,b.fboxno,b.ftitle,b.fboxtype,b.fmodel,b.fmakeboxtime,b.fgrade,b.fdrpagenum,b.funnumber,b.flash_point flashpoint,b.fcolddegree,b.ftotals,b.fgrosses,b.fvolumes,b.fextract,b.freturn,b.foperator,b.fid,b.fzhdp,b.fzhdpdz,b.fzhunit,b.fzhcontact,b.fzhmobile,b.fnote,b.ftsyw,b.fxhdp,b.fxhdpdz,b.fxhtime,b.fxhunit,b.fxhcontact,b.fxhmobile,b.fbillno fbillno2,b.fzanluo from z_custom_entrust a inner join z_contianer b on a.id=b.fid where 1=1";
		  String fcheck = request.getParameter("fcheck");
		  String fbillno = request.getParameter("fbillno");
		  String fcontact=request.getParameter("fcontact");
		  String fsalesman=request.getParameter("fsalesman");
		  String fcontractno=request.getParameter("fcontractno");
		  String fshipname=request.getParameter("fshipname");
		  String fblno=request.getParameter("fblno");
		  String fentrustunit=request.getParameter("fentrustunit");
		  System.out.println("fentrustunit="+fentrustunit);
		  String fvoyageno=request.getParameter("fvoyageno");
		  String fboxno =request.getParameter("fboxno");
		  String fgrade=request.getParameter("fgrade");
		  String ftitle=request.getParameter("ftitle");
		  String foperator=request.getParameter("foperator");
		  if(StringUtil.isNotEmpty(fcheck)){
		      sql = sql1+" and a.fcheck='"+fcheck+"'";
          }
		if(fbillno !=null && fbillno!="")
		{
			sql=sql1+" and a.fbillno like '%"+fbillno+"%'";
		}
		if(fcontact !=null && fcontact!="")
		{
			sql=sql1+" and a.fcontact like '%"+fcontact+"%'";
		}
		if(fsalesman!=null && fsalesman!="")
		{
			sql=sql1+" and a.fsalesman like '%"+fsalesman+"%'";
		}
		if(fcontractno!=null && fcontractno!="")
		{
			sql=sql1+" and a.fcontractno like '%"+fcontractno+"%'";
		}
		if(fshipname!=null && fshipname!="")
		{
			sql=sql1+" and a.fshipname like '%"+fshipname+"%'";
		}
		if(fblno!=null && fblno!="")
		{
			sql=sql1+" and a.fblno like '%"+fblno+"%'";
		}
		if(fentrustunit!=null && fentrustunit!="")
		{
			sql=sql1+" and a.fentrust_unit like '%"+fentrustunit+"%' ";
		}
		if(fvoyageno!=null && fvoyageno!="")
		{
			sql=sql1+" and a.fvoyageno like '%"+fvoyageno+"%'";
		}
		if(fboxno!=null && fboxno!="")
		{
			sql=sql1+" and b.fboxno like '%"+fboxno+"%'";
		}
		if(fgrade!=null && fgrade!="")
		{
			sql=sql1+" and b.fgrade like '%"+fgrade+"%'";
		}
		if(ftitle!=null && ftitle!="")
		{
			sql=sql1+" and b.ftitle like '%"+ftitle+"%'";
		}
		if(foperator!=null && foperator!="")
		{
			sql=sql1+" and b.foperator like '%"+foperator+"%'";
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
	 * 删除客户委托
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CustomEntrustEntity customEntrust, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		customEntrust = systemService.getEntity(CustomEntrustEntity.class, customEntrust.getId());
		message = "客户委托删除成功";
		try{
		    if(customEntrust.getFcheck().equals("1")){
		        message = "单据已审核，无法删除！";
            }else{
                customEntrustService.delete(customEntrust);
            }
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户委托删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除客户委托
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "客户委托删除成功";
		try{
		    for (String id : ids.split(",")) {
		        CustomEntrustEntity customEntrust = systemService.getEntity(CustomEntrustEntity.class, id);
		        customEntrustService.delete(customEntrust);
		        systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		    }
		}catch(Exception e){
			e.printStackTrace();
			message = "客户委托删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加客户委托
	 * 
	 * @param customEntrust
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CustomEntrustEntity customEntrust, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "客户委托添加成功";
		try{
			customEntrust.setFbillno(systemService.getFbillno(36));
			customEntrust.setFcheck("0");
			customEntrustService.save(customEntrust);
			String fcontractno = customEntrust.getFcontractno();
			systemService.executeSql("update z_hetong set fbrno='"+customEntrust.getFbillno()+"' where fbillno='"+fcontractno+"'");
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户委托添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新客户委托
	 * 
	 * @param customEntrust
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CustomEntrustEntity customEntrust, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "客户委托更新成功";
		CustomEntrustEntity t = customEntrustService.get(CustomEntrustEntity.class, customEntrust.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(customEntrust, t);
			customEntrustService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "客户委托更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 客户委托新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CustomEntrustEntity customEntrust, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customEntrust.getId())) {
			customEntrust = customEntrustService.getEntity(CustomEntrustEntity.class, customEntrust.getId());
			req.setAttribute("customEntrustPage", customEntrust);
		}
		return new ModelAndView("com/jeecg/customentrust/customEntrust-add");
	}
	/**
	 * 客户委托编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CustomEntrustEntity customEntrust, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customEntrust.getId())) {
			customEntrust = customEntrustService.getEntity(CustomEntrustEntity.class, customEntrust.getId());
			req.setAttribute("customEntrustPage", customEntrust);
		}
		return new ModelAndView("com/jeecg/customentrust/customEntrust-update");
	}

	/**
	 * 审核
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "check")
	@ResponseBody
	public AjaxJson check(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "费用审核成功";
		try{
			for(String id:ids.split(",")){
				CustomEntrustEntity customEntrust = systemService.getEntity(CustomEntrustEntity.class, id);
				customEntrust.setFcheck("1");
				customEntrust.setFchecker(ResourceUtil.getSessionUser().getUserName());
				customEntrust.setFcheckdate(new Date());
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "费用审核失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 反审核
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "uncheck")
	@ResponseBody
	public AjaxJson uncheck(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "费用反审核成功";
		try{
			for(String id:ids.split(",")){
				CustomEntrustEntity customEntrust = systemService.getEntity(CustomEntrustEntity.class, id);
				customEntrust.setFcheck("0");
				customEntrust.setFchecker(ResourceUtil.getSessionUser().getUserName());
				customEntrust.setFcheckdate(new Date());
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "费用反审核失败";
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
		req.setAttribute("controller_name","customEntrustController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(CustomEntrustEntity customEntrust,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(CustomEntrustEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customEntrust, request.getParameterMap());
		List<CustomEntrustEntity> customEntrusts = this.customEntrustService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"客户委托");
		modelMap.put(NormalExcelConstants.CLASS,CustomEntrustEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("客户委托列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,customEntrusts);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(CustomEntrustEntity customEntrust,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"客户委托");
    	modelMap.put(NormalExcelConstants.CLASS,CustomEntrustEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("客户委托列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<CustomEntrustEntity> listCustomEntrustEntitys = ExcelImportUtil.importExcel(file.getInputStream(),CustomEntrustEntity.class,params);
				for (CustomEntrustEntity customEntrust : listCustomEntrustEntitys) {
					customEntrustService.save(customEntrust);
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
	@ApiOperation(value="客户委托列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CustomEntrustEntity>> list() {
		List<CustomEntrustEntity> listCustomEntrusts=customEntrustService.getList(CustomEntrustEntity.class);
		return Result.success(listCustomEntrusts);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取客户委托信息",notes="根据ID获取客户委托信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CustomEntrustEntity task = customEntrustService.get(CustomEntrustEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取客户委托信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建客户委托")
	public ResponseMessage<?> create(@ApiParam(name="客户委托对象")@RequestBody CustomEntrustEntity customEntrust, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomEntrustEntity>> failures = validator.validate(customEntrust);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}
		//保存
		try{
			customEntrustService.save(customEntrust);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("客户委托信息保存失败");
		}
		return Result.success(customEntrust);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新客户委托",notes="更新客户委托")
	public ResponseMessage<?> update(@ApiParam(name="客户委托对象")@RequestBody CustomEntrustEntity customEntrust) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomEntrustEntity>> failures = validator.validate(customEntrust);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}
		//保存
		try{
			customEntrustService.saveOrUpdate(customEntrust);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新客户委托信息失败");
		}
		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新客户委托信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除客户委托")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			customEntrustService.deleteEntityById(CustomEntrustEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("客户委托删除失败");
		}
		return Result.success();
	}
}
