package com.jeecg.contianer.controller;

import com.jeecg.charge.entity.ChargeEntity;
import com.jeecg.contianer.entity.ContianerEntity;
import com.jeecg.contianer.service.ContianerServiceI;
import com.jeecg.contianer.page.ContianerPage;
import com.jeecg.costcombination.entity.CostCombinationEntity;
import com.jeecg.customentrust.entity.CustomEntrustEntity;
import com.jeecg.detail.entity.DetailEntity;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller
 * @Description: 集装箱
 * @author onlineGenerator
 * @date 2018-08-01 16:47:07
 * @version V1.0   
 *
 */
@Api(value="Contianer",description="集装箱",tags="contianerController")
@Controller
@RequestMapping("/contianerController")
public class ContianerController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ContianerController.class);

	@Autowired
	private ContianerServiceI contianerService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgReportServiceI cgReportService;
	@Autowired
    private JdbcTemplate jdbcTemplate;

	/**
	 * 集装箱列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String cid = request.getParameter("cid");
		logger.info("主表的id："+cid);
		request.setAttribute("cid",cid);
		return new ModelAndView("com/jeecg/contianer/contianerList");
	}

    @RequestMapping(params = "list1")
    public ModelAndView list1(HttpServletRequest request) {
        String cid = request.getParameter("ids");
        logger.info("主表的id："+cid);
        request.setAttribute("cid",cid);
        return new ModelAndView("com/jeecg/contianer/costCombinationList");
    }

	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/contianer/contianerList3");
	}

    @RequestMapping(params = "chargeList")
    public ModelAndView chargeList(HttpServletRequest request) {
        String cid = request.getParameter("cid");
        String conid = request.getParameter("conid");
        String fbillno1 = request.getParameter("fbillno1");
        String fweituo = request.getParameter("fweituo");
        String fblno = request.getParameter("fblno");
        logger.info("委托单的id："+cid);
        logger.info("箱子的id："+conid);
        logger.info("箱编号："+fbillno1);
        logger.info("委托单位："+fweituo);
        logger.info("提单号："+fblno);
        request.setAttribute("cid",cid);
        request.setAttribute("conid",conid);
        request.setAttribute("fbillno1",fbillno1);
        request.setAttribute("fweituo",fweituo);
        request.setAttribute("fblno",fblno);
        return new ModelAndView("com/jeecg/contianer/chargeList");
    }

	@RequestMapping(params = "print")
	public ModelAndView print(ContianerEntity contianer, HttpServletRequest request) {
		String id = contianer.getId();
		ModelAndView ml = new ModelAndView();
		request.setAttribute("dataid", id);
		ml.setViewName("com/jeecg/contianer/report");
		return ml;
	}

	/**
	 * 集装箱选择页面
	 *
	 * @return
	 */
	@RequestMapping(params = "container")
	public ModelAndView container(HttpServletRequest request) {
		logger.info("排班记录的id:"+request.getParameter("qid"));
		request.setAttribute("qid", request.getParameter("qid"));
		return new ModelAndView("com/jeecg/contianer/contianerList2");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param contianer
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ContianerEntity contianer,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ContianerEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, contianer);
		try{
		//自定义追加查询条件
			String cid = request.getParameter("cid");
			if(cid!=null) {
				cq.eq("fid", cid);
			}else{
				cq.isNull("fbillno");
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.contianerService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "datagrid1")
	public void datagrid1(CustomEntrustEntity customEntrust,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String sql =null;
		String fmakeboxtime = request.getParameter("fmakeboxtime");
		Map queryparams =  new LinkedHashMap<String,Object>();
					  //      箱号      箱型      箱类      封号		装船港      中转港      目的港      船名        航次         做箱时间      总件数     总重量      总体积      提箱点     还箱点  装货门点   装货重量   卸货门点  卸货重量   主表主键  暂落          箱编号                        委托单位           提单号   装货时间   装货地址   卸货时间   卸货地址  加热温度  冷藏温度      等级
		sql = "select a.id,a.fboxno,a.fboxtype,a.fmodel,a.ftitle,a.floadport,a.ftransfer,a.ftarget,a.fvoyage,a.fvoyagenum,a.fmakeboxtime,a.ftotals,a.fgrosses,a.fvolumes,a.fextract,a.freturn,a.fzhdp,a.fzhweight,a.fxhdp,a.fxhweight,a.fid,a.fzanluo,b.fbillno+'-'+a.fno fbillno1,b.fentrust_unit fentrust,b.fblno,a.fzhtime,a.fzhdpdz,a.fxhtime,a.fxhdpdz,a.fhot,a.fcolddegree,a.fgrade from z_contianer a left join z_custom_entrust b on b.id=a.fid where 1=1";
		if(StringUtil.isNotEmpty(fmakeboxtime)){
		    sql = sql+" and convert(varchar(10),a.fmakeboxtime,120) = '"+fmakeboxtime+"'";
		}
		sql = sql + " and a.fbillno is null or a.fbillno=''";
		logger.info(sql);
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
    public void datagrid2(ChargeEntity charge, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(ChargeEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, charge);
        try{
            //自定义追加查询条件
            String conid = request.getParameter("conid");
            cq.eq("conid",conid);
            cq.eq("fshoufu","0");
        }catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.contianerService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    @RequestMapping(params = "datagrid3")
    public void datagrid3(CustomEntrustEntity customEntrust,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        String sql =null;
        String cid = request.getParameter("cid");
        Map queryparams =  new LinkedHashMap<String,Object>();
                             //审核        业务类型               委托单付编号                  委托单位	    提单号     提箱点   装货门点 卸货门点  还箱点      箱型      箱类      箱号   加热温度 冷藏温度  等级   主表主键
        sql = "select a.id,a.fcheck,b.fbuss_type fbuss,b.fbillno+'-'+a.fno fbillno1,b.fentrust_unit fweituo,b.fblno,a.fextract,a.fzhdp,a.fxhdp,a.freturn,a.fboxtype,a.fmodel,a.fboxno,a.fhot,a.fcolddegree,a.fgrade,a.fid,a.fxhtime,a.fzhtime from z_contianer a left join z_custom_entrust b on b.id=a.fid where a.fid='"+cid+"'";
        logger.info(sql);
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
	 * 删除集装箱
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ContianerEntity contianer, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		contianer = systemService.getEntity(ContianerEntity.class, contianer.getId());
		String message = "集装箱删除成功";
		try{
		    if(contianer.getFcheck().equals("1")){
		        message = "单据已审核，无法删除！";
            }else {
                contianerService.delMain(contianer);
            }
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "集装箱删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除集装箱
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "集装箱删除成功";
		try{
			for(String id:ids.split(",")){
				ContianerEntity contianer = systemService.getEntity(ContianerEntity.class,
				id
				);
				contianerService.delMain(contianer);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "集装箱删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加集装箱
	 * 
	 * @param contianer
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ContianerEntity contianer,ContianerPage contianerPage, HttpServletRequest request) {
		List<DetailEntity> detailList =  contianerPage.getDetailList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
		    String fsettleid = request.getParameter("fsettleid");
		    String buss = request.getParameter("buss");
			CostCombinationEntity costCombination = systemService.getEntity(CostCombinationEntity.class,contianer.getCid1());
			int fday = costCombination.getFday();
		    if(buss.equals("0")){
		    	contianer.setFmakeboxtime(systemService.getnDay(fday,contianer.getFzhtime()));
			}
			if(buss.equals("1")){
				contianer.setFmakeboxtime(systemService.getnDay(fday,contianer.getFxhtime()));
			}
			if(buss.equals("2")){
				contianer.setFmakeboxtime(systemService.getnDay(fday,contianer.getFzhtime()));
			}
		    contianer.setFzanluo("N");
		    contianer.setFcheck("0");
		    contianer.setFboxno(contianer.getFboxno().toUpperCase());
		    int count = jdbcTemplate.queryForObject("select count(*) from z_contianer where fid=?",Integer.class,contianer.getFid());
			String suffix = "00"+(count+1);
		    contianer.setFno(suffix.substring(suffix.length()-3,suffix.length()));
			contianerService.addMain(contianer, detailList, fsettleid);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "集装箱添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新集装箱
	 * 
	 * @param contianer
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ContianerEntity contianer,ContianerPage contianerPage, HttpServletRequest request) {
		List<DetailEntity> detailList =  contianerPage.getDetailList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			contianerService.updateMain(contianer, detailList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新集装箱失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 集装箱新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ContianerEntity contianer, HttpServletRequest req) {
		String cid = req.getParameter("cid");
		req.setAttribute("cid",cid);
        CustomEntrustEntity customEntrust = systemService.getEntity(CustomEntrustEntity.class,cid);
        req.setAttribute("entrustPage",customEntrust);
		if (StringUtil.isNotEmpty(contianer.getId())) {
			contianer = contianerService.getEntity(ContianerEntity.class, contianer.getId());
			req.setAttribute("contianerPage", contianer);
		}
		if(customEntrust.getFbussType().equals("0")){
			//出口
			return new ModelAndView("com/jeecg/contianer/contianer-add");
		}else if(customEntrust.getFbussType().equals("1")){
			//进口
			return new ModelAndView("com/jeecg/contianer/contianer-add1");
		}else{
			//项目
			return new ModelAndView("com/jeecg/contianer/contianer-add2");
		}
	}
	
	/**
	 * 集装箱编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ContianerEntity contianer, HttpServletRequest req) {
		String cid = req.getParameter("cid");
		req.setAttribute("cid",cid);
		CustomEntrustEntity customEntrust = systemService.getEntity(CustomEntrustEntity.class,cid);
		req.setAttribute("entrustPage",customEntrust);
		if (StringUtil.isNotEmpty(contianer.getId())) {
			contianer = contianerService.getEntity(ContianerEntity.class, contianer.getId());
			req.setAttribute("contianerPage", contianer);
		}
		if(customEntrust.getFbussType().equals("0")) {
			//出口
			return new ModelAndView("com/jeecg/contianer/contianer-update");
		}else if(customEntrust.getFbussType().equals("1")){
			//进口
			return new ModelAndView("com/jeecg/contianer/contianer-update1");
		}else{
			//项目
			return new ModelAndView("com/jeecg/contianer/contianer-update2");
		}
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
                ContianerEntity contianer = systemService.getEntity(ContianerEntity.class, id);
                contianer.setFcheck("1");
                contianer.setFchecker(ResourceUtil.getSessionUser().getUserName());
                contianer.setFcheckdate(new Date());
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
                ContianerEntity contianer = systemService.getEntity(ContianerEntity.class, id);
                contianer.setFcheck("0");
                contianer.setFchecker(ResourceUtil.getSessionUser().getUserName());
                contianer.setFcheckdate(new Date());
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
	 * 加载明细列表[箱货明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "detailList")
	public ModelAndView detailList(ContianerEntity contianer, HttpServletRequest req) {
		//===================================================================================
		//获取参数
		Object id0 = contianer.getId();
		String fblno = req.getParameter("fblno");
		//===================================================================================
		//查询-箱货明细
	    String hql0 = "from DetailEntity where 1 = 1 AND fID = ? ";
	    try{
	    	List<DetailEntity> detailEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("detailList", detailEntityList);
			req.setAttribute("fblno",fblno);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/detail/detailList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(ContianerEntity contianer,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(ContianerEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, contianer);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<ContianerEntity> list=this.contianerService.getListByCriteriaQuery(cq, false);
    	List<ContianerPage> pageList=new ArrayList<ContianerPage>();
        if(list!=null&&list.size()>0){
        	for(ContianerEntity entity:list){
        		try{
        		ContianerPage page=new ContianerPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from DetailEntity where 1 = 1 AND fID = ? ";
        	        List<DetailEntity> detailEntityList = systemService.findHql(hql0,id0);
            		page.setDetailList(detailEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"集装箱");
        map.put(NormalExcelConstants.CLASS,ContianerPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("集装箱列表", "导出人:Jeecg",
            "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,pageList);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

    /**
	 * 通过excel导入数据
	 * @param request
	 * @param
	 * @return
	 */
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
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<ContianerPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), ContianerPage.class, params);
				ContianerEntity entity1=null;
				for (ContianerPage page : list) {
					entity1=new ContianerEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            contianerService.addMain(entity1, page.getDetailList(), "");
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
	* 导出excel 使模板
	*/
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ModelMap map) {
		map.put(NormalExcelConstants.FILE_NAME,"集装箱");
		map.put(NormalExcelConstants.CLASS,ContianerPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("集装箱列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
		"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	* 导入功能跳转
	*
	* @return
	*/
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "contianerController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="集装箱列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ContianerPage>> list() {
		List<ContianerEntity> list= contianerService.getList(ContianerEntity.class);
    	List<ContianerPage> pageList=new ArrayList<ContianerPage>();
        if(list!=null&&list.size()>0){
        	for(ContianerEntity entity:list){
        		try{
        			ContianerPage page=new ContianerPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from DetailEntity where 1 = 1 AND fID = ? ";
	    			List<DetailEntity> detailOldList = this.contianerService.findHql(hql0,id0);
            		page.setDetailList(detailOldList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
		return Result.success(pageList);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取集装箱信息",notes="根据ID获取集装箱信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		List<ContianerEntity> list = contianerService.findByProperty(ContianerEntity.class,"fid",id);
		if (list == null) {
			return Result.error("根据ID获取集装箱信息为空");
		}
		List<ContianerPage> pagelist = new ArrayList<>();
		try {
			for(ContianerEntity task : list) {
				ContianerPage page = new ContianerPage();
				MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				String hql0 = "from DetailEntity where 1 = 1 AND fID = ? ";
				List<DetailEntity> detailOldList = this.contianerService.findHql(hql0, id0);
				page.setDetailList(detailOldList);
				pagelist.add(page);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(pagelist);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建集装箱")
	public ResponseMessage<?> create(@ApiParam(name="集装箱对象")@RequestBody ContianerPage contianerPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ContianerPage>> failures = validator.validate(contianerPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<DetailEntity> detailList =  contianerPage.getDetailList();
		
		ContianerEntity contianer = new ContianerEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(contianerPage,contianer);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存集装箱失败");
        }
		contianerService.addMain(contianer, detailList, "");

		return Result.success(contianer);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新集装箱",notes="更新集装箱")
	public ResponseMessage<?> update(@RequestBody ContianerPage contianerPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ContianerPage>> failures = validator.validate(contianerPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<DetailEntity> detailList =  contianerPage.getDetailList();
		
		ContianerEntity contianer = new ContianerEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(contianerPage,contianer);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("集装箱更新失败");
        }
		contianerService.updateMain(contianer, detailList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除集装箱")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			ContianerEntity contianer = contianerService.get(ContianerEntity.class, id);
			contianerService.delMain(contianer);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("集装箱删除失败");
		}

		return Result.success();
	}
}
