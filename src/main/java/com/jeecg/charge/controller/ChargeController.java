package com.jeecg.charge.controller;
import com.jeecg.charge.entity.ChargeEntity;
import com.jeecg.charge.service.ChargeServiceI;

import java.io.PrintWriter;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import javax.xml.soap.SAAJResult;
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
 * @Description: 费用
 * @author onlineGenerator
 * @date 2018-08-15 13:38:45
 * @version V1.0   
 *
 */
@Api(value="Charge",description="费用",tags="chargeController")
@Controller
@RequestMapping("/chargeController")
public class ChargeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ChargeController.class);

	@Autowired
	private ChargeServiceI chargeService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgReportServiceI cgReportService;
	


	/**
	 * 费用列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String cid = request.getParameter("cid");
		logger.info("委托单的id："+cid);
		request.setAttribute("cid",cid);
		return new ModelAndView("com/jeecg/charge/chargeList");
	}

	@RequestMapping(params = "list1")
	public ModelAndView list1(HttpServletRequest request) {
		String pid = request.getParameter("pid");
		logger.info("派车单的id："+pid);
		request.setAttribute("pid",pid);
		return new ModelAndView("com/jeecg/charge/chargeList1");
	}

	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request) {
		String pid = request.getParameter("pid");
		logger.info("派车单的id："+pid);
		request.setAttribute("pid",pid);
		return new ModelAndView("com/jeecg/charge/chargeList2");
	}

	@RequestMapping(params = "list3")
	public ModelAndView list3(HttpServletRequest request) {
		String idlist = request.getParameter("idlist");
		logger.info(idlist);
		request.setAttribute("idlist",idlist);
		return new ModelAndView("com/jeecg/charge/chargeList3");
	}

    @RequestMapping(params = "list4")
    public ModelAndView list4(HttpServletRequest request) {
        String idlist = request.getParameter("idlist");
        logger.info(idlist);
        request.setAttribute("idlist",idlist);
        return new ModelAndView("com/jeecg/charge/chargeList4");
    }

    @RequestMapping(params = "list5")
    public ModelAndView list5(HttpServletRequest request) {
        String idlist = request.getParameter("idlist");
        logger.info(idlist);
        request.setAttribute("idlist",idlist);
        return new ModelAndView("com/jeecg/charge/chargeList5");
    }

	@RequestMapping(params = "list6")
	public ModelAndView list6(HttpServletRequest request) {
		String idlist = request.getParameter("idlist");
		logger.info(idlist);
		request.setAttribute("idlist",idlist);
		return new ModelAndView("com/jeecg/charge/chargeList6");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param charge
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ChargeEntity charge,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ChargeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, charge, request.getParameterMap());
		try{
		//自定义追加查询条件
			String cid = request.getParameter("cid");
			cq.eq("fid",cid);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.chargeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "datagrid1")
	public void datagrid1(ChargeEntity charge,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ChargeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, charge, request.getParameterMap());
		try{
			//自定义追加查询条件
			String pid = request.getParameter("pid");
            String sf = request.getParameter("sf");
			cq.eq("fid",pid);
            cq.eq("fshoufu",sf);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.chargeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "datagrid2")
	public void datagrid2(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String idlist = request.getParameter("idlist");
		logger.info(idlist);
		String begin = request.getParameter("operatetime_begin");
		String end = request.getParameter("operatetime_end");
		String fcost = request.getParameter("fcost");
		String famount1 = request.getParameter("famount_begin");
		String famount2 = request.getParameter("famount_end");
		String fcheck = request.getParameter("fcheck");
		String fweituo = request.getParameter("fweituo");
		String paiche= request.getParameter("paiche");
		String fsettle = request.getParameter("fsettle");
		String createName = request.getParameter("createName");
		String ftitle = request.getParameter("ftitle");
		String fdriver = request.getParameter("fdriver");
		String fkp = request.getParameter("fkp");
		String fhx = request.getParameter("fhx");
		String fdz = request.getParameter("fdz");
//		String fbx = request.getParameter("fbx");
		String forigin = request.getParameter("forigin");
		String ftranstime1 = request.getParameter("ftranstime_begin");
		String ftranstime2 = request.getParameter("ftranstime_end");
		String[] strArray=idlist.split(",");
		String idarray = "(";
		for(int i=0;i<strArray.length;i++){
			idarray = idarray+"'"+strArray[i]+"',";
		}
		idarray = idarray.substring(0,idarray.length()-1)+")";
		Map queryparams =  new LinkedHashMap<String,Object>();
		String sql ="select a.id,a.fcost,a.fcostname,a.funit,a.fqty,a.fprice,a.famount,isnull(a.fsfamount,0) fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,a.fcheck,a.fshoufu,a.fsettle,a.fsettlename,b.fblno,b.fshipname,b.fvoyageno,b.foperate_time operatetime,b.fbillno fweituo,b.fnote,b.fentrust_unit entrust,c.fzhdp,c.fzhdpdz,d.fbillno paiche from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where a.fbx='N' and a.fshoufu='1' and a.id not in "+idarray;
		String sql1 = "select a.id,a.fcost,a.fcostname,a.funit,a.fqty,a.fprice,a.famount,isnull(a.fsfamount,0) fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,a.fcheck,a.fshoufu,a.fsettle,a.fsettlename,d.fblno,d.fshipname,d.fvoyageno,d.foperate_time operatetime,d.fbillno fweituo,d.fnote,d.fentrust_unit entrust,c.fzhdp,c.fzhdpdz,b.fbillno paiche from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where a.fbx='N' and a.fshoufu='1' and a.id not in "+idarray;
		//根据委托单查费用
		if(begin!=null&&end!=null&&begin!=""&&end!=""){
			sql = sql+"and CONVERT(varchar(100), b.foperate_time, 23) between '"+begin+"' and '"+end+"' ";
		}
		if(fcost!=null&&fcost!=""){
			sql = sql+"and a.fcost like '%"+fcost+"%' ";
		}
		if(famount1!=null&&famount1!=""&&famount2!=null&&famount2!=""){
			sql = sql+"and a.famount >= "+famount1+" and a.famount <= "+famount2+" ";
		}
		if(fcheck!=null&&fcheck!=""){
			sql = sql+"and a.fcheck = '"+fcheck+"' ";
		}
		if(fweituo!=null&&fweituo!=""){
			sql = sql+"and b.fbillno like '%"+fweituo+"%' ";
		}
		if(paiche!=null&&paiche!=""){
			sql = sql+"and d.fbillno like '%"+paiche+"%' ";
		}
		if(fsettle!=null&&fsettle!=""){
			sql = sql+"and a.fsettle like '%"+fsettle+"%' ";
		}
		if(createName!=null&&createName!=""){
			sql = sql+"and a.create_name like '%"+createName+"%' ";
		}
		if(ftitle!=null&&ftitle!=""){
			sql = sql+"and c.ftitle like '%"+ftitle+"%' ";
		}
		if(fdriver!=null&&fdriver!=""){
			sql = sql+"and d.fdriver like '%"+fdriver+"%' ";
		}
		if(fkp!=null&&fkp!=""){
			sql = sql+"and a.fkp = '"+fkp+"' ";
		}
		if(fhx!=null&&fhx!=""){
			sql = sql+"and a.fhx = '"+fhx+"' ";
		}
		if(fdz!=null&&fdz!=""){
			sql = sql+"and a.fdz = '"+fdz+"' ";
		}
//		if(fbx!=null&&fbx!=""){
//			sql = sql+"and a.fbx = '"+fbx+"' ";
//		}
		if(forigin!=null&&forigin!=""){
			sql = sql+"and a.forigin = "+forigin+" ";
		}
		if(ftranstime1!=null&&ftranstime1!=""&&ftranstime2!=null&&ftranstime2!=""){
			sql = sql+"and d.ftranstime between '"+ftranstime1+"' and '"+ftranstime2+"' ";
		}
		//根据派车单查费用
		if(begin!=null&&end!=null&&begin!=""&&end!=""){
			sql1 = sql1+"and CONVERT(varchar(100), d.foperate_time, 23) between '"+begin+"' and '"+end+"' ";
		}
		if(fcost!=null&&fcost!=""){
			sql1 = sql1+"and a.fcost like '%"+fcost+"%' ";
		}
		if(famount1!=null&&famount1!=""&&famount2!=null&&famount2!=""){
			sql1 = sql1+"and a.famount >= "+famount1+" and a.famount <= "+famount2+" ";
		}
		if(fcheck!=null&&fcheck!=""){
			sql1 = sql1+"and a.fcheck = '"+fcheck+"' ";
		}
		if(fweituo!=null&&fweituo!=""){
			sql1 = sql1+"and d.fbillno like '%"+fweituo+"%' ";
		}
		if(paiche!=null&&paiche!=""){
			sql1 = sql1+"and b.fbillno like '%"+paiche+"%' ";
		}
		if(fsettle!=null&&fsettle!=""){
			sql1 = sql1+"and a.fsettle like '%"+fsettle+"%' ";
		}
		if(createName!=null&&createName!=""){
			sql1 = sql1+"and a.create_name like '%"+createName+"%' ";
		}
		if(ftitle!=null&&ftitle!=""){
			sql1 = sql1+"and c.ftitle like '%"+ftitle+"%' ";
		}
		if(fdriver!=null&&fdriver!=""){
			sql1 = sql1+"and b.fdriver like '%"+fdriver+"%' ";
		}
		if(fkp!=null&&fkp!=""){
			sql1 = sql1+"and a.fkp = '"+fkp+"' ";
		}
		if(fhx!=null&&fhx!=""){
			sql1 = sql1+"and a.fhx = '"+fhx+"' ";
		}
		if(fdz!=null&&fdz!=""){
			sql1 = sql1+"and a.fdz = '"+fdz+"' ";
		}
//		if(fbx!=null&&fbx!=""){
//			sql1 = sql1+"and a.fbx = '"+fbx+"' ";
//		}
		if(forigin!=null&&forigin!=""){
			sql1 = sql1+"and a.forigin = "+forigin+" ";
		}
		if(ftranstime1!=null&&ftranstime1!=""&&ftranstime2!=null&&ftranstime2!=""){
			sql1 = sql1+"and b.ftranstime between '"+ftranstime1+"' and '"+ftranstime2+"' ";
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

    @RequestMapping(params = "datagrid3")
    public void datagrid3(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        String idlist = request.getParameter("idlist");
        logger.info(idlist);
        String begin = request.getParameter("operatetime_begin");
        String end = request.getParameter("operatetime_end");
        String fcost = request.getParameter("fcost");
        String famount1 = request.getParameter("famount_begin");
        String famount2 = request.getParameter("famount_end");
        String fcheck = request.getParameter("fcheck");
        String fweituo = request.getParameter("fweituo");
        String paiche= request.getParameter("paiche");
        String fsettle = request.getParameter("fsettle");
        String createName = request.getParameter("createName");
        String ftitle = request.getParameter("ftitle");
        String fdriver = request.getParameter("fdriver");
        String fkp = request.getParameter("fkp");
        String fhx = request.getParameter("fhx");
//        String fdz = request.getParameter("fdz");
		String fbx = request.getParameter("fbx");
        String forigin = request.getParameter("forigin");
        String ftranstime1 = request.getParameter("ftranstime_begin");
        String ftranstime2 = request.getParameter("ftranstime_end");
        String[] strArray=idlist.split(",");
        String idarray = "(";
        for(int i=0;i<strArray.length;i++){
            idarray = idarray+"'"+strArray[i]+"',";
        }
        idarray = idarray.substring(0,idarray.length()-1)+")";
        Map queryparams =  new LinkedHashMap<String,Object>();
        String sql ="select a.id,a.fcost,a.fcostname,a.funit,a.fqty,a.fprice,a.famount,a.fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,a.fcheck,a.fshoufu,a.fsettle,a.fsettlename,b.fblno,b.fshipname,b.fvoyageno,b.foperate_time operatetime,b.fbillno fweituo,b.fnote,b.fentrust_unit entrust,c.fzhdp,c.fzhdpdz,d.fbillno paiche from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where a.fdz='N' and a.fshoufu='0' and a.id not in "+idarray;
        String sql1 = "select a.id,a.fcost,a.fcostname,a.funit,a.fqty,a.fprice,a.famount,a.fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,a.fcheck,a.fshoufu,a.fsettle,a.fsettlename,d.fblno,d.fshipname,d.fvoyageno,d.foperate_time operatetime,d.fbillno fweituo,d.fnote,d.fentrust_unit entrust,c.fzhdp,c.fzhdpdz,b.fbillno paiche from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where a.fdz='N' and a.fshoufu='0' and a.id not in "+idarray;
        //根据委托单查费用
        if(begin!=null&&end!=null&&begin!=""&&end!=""){
            sql = sql+"and CONVERT(varchar(100), b.foperate_time, 23) between '"+begin+"' and '"+end+"' ";
        }
        if(fcost!=null&&fcost!=""){
            sql = sql+"and a.fcost like '%"+fcost+"%' ";
        }
        if(famount1!=null&&famount1!=""&&famount2!=null&&famount2!=""){
            sql = sql+"and a.famount >= "+famount1+" and a.famount <= "+famount2+" ";
        }
        if(fcheck!=null&&fcheck!=""){
            sql = sql+"and a.fcheck = '"+fcheck+"' ";
        }
        if(fweituo!=null&&fweituo!=""){
            sql = sql+"and b.fbillno like '%"+fweituo+"%' ";
        }
        if(paiche!=null&&paiche!=""){
            sql = sql+"and d.fbillno like '%"+paiche+"%' ";
        }
        if(fsettle!=null&&fsettle!=""){
            sql = sql+"and a.fsettle like '%"+fsettle+"%' ";
        }
        if(createName!=null&&createName!=""){
            sql = sql+"and a.create_name like '%"+createName+"%' ";
        }
        if(ftitle!=null&&ftitle!=""){
            sql = sql+"and c.ftitle like '%"+ftitle+"%' ";
        }
        if(fdriver!=null&&fdriver!=""){
            sql = sql+"and d.fdriver like '%"+fdriver+"%' ";
        }
        if(fkp!=null&&fkp!=""){
            sql = sql+"and a.fkp = '"+fkp+"' ";
        }
        if(fhx!=null&&fhx!=""){
            sql = sql+"and a.fhx = '"+fhx+"' ";
        }
//        if(fdz!=null&&fdz!=""){
//            sql = sql+"and a.fdz = '"+fdz+"' ";
//        }
		if(fbx!=null&&fbx!=""){
			sql = sql+"and a.fbx = '"+fbx+"' ";
		}
        if(forigin!=null&&forigin!=""){
            sql = sql+"and a.forigin = "+forigin+" ";
        }
        if(ftranstime1!=null&&ftranstime1!=""&&ftranstime2!=null&&ftranstime2!=""){
            sql = sql+"and d.ftranstime between '"+ftranstime1+"' and '"+ftranstime2+"' ";
        }
        //根据派车单查费用
        if(begin!=null&&end!=null&&begin!=""&&end!=""){
            sql1 = sql1+"and CONVERT(varchar(100), d.foperate_time, 23) between '"+begin+"' and '"+end+"' ";
        }
        if(fcost!=null&&fcost!=""){
            sql1 = sql1+"and a.fcost like '%"+fcost+"%' ";
        }
        if(famount1!=null&&famount1!=""&&famount2!=null&&famount2!=""){
            sql1 = sql1+"and a.famount >= "+famount1+" and a.famount <= "+famount2+" ";
        }
        if(fcheck!=null&&fcheck!=""){
            sql1 = sql1+"and a.fcheck = '"+fcheck+"' ";
        }
        if(fweituo!=null&&fweituo!=""){
            sql1 = sql1+"and d.fbillno like '%"+fweituo+"%' ";
        }
        if(paiche!=null&&paiche!=""){
            sql1 = sql1+"and b.fbillno like '%"+paiche+"%' ";
        }
        if(fsettle!=null&&fsettle!=""){
            sql1 = sql1+"and a.fsettle like '%"+fsettle+"%' ";
        }
        if(createName!=null&&createName!=""){
            sql1 = sql1+"and a.create_name like '%"+createName+"%' ";
        }
        if(ftitle!=null&&ftitle!=""){
            sql1 = sql1+"and c.ftitle like '%"+ftitle+"%' ";
        }
        if(fdriver!=null&&fdriver!=""){
            sql1 = sql1+"and b.fdriver like '%"+fdriver+"%' ";
        }
        if(fkp!=null&&fkp!=""){
            sql1 = sql1+"and a.fkp = '"+fkp+"' ";
        }
        if(fhx!=null&&fhx!=""){
            sql1 = sql1+"and a.fhx = '"+fhx+"' ";
        }
//        if(fdz!=null&&fdz!=""){
//            sql1 = sql1+"and a.fdz = '"+fdz+"' ";
//        }
		if(fbx!=null&&fbx!=""){
			sql1 = sql1+"and a.fbx = '"+fbx+"' ";
		}
        if(forigin!=null&&forigin!=""){
            sql1 = sql1+"and a.forigin = "+forigin+" ";
        }
        if(ftranstime1!=null&&ftranstime1!=""&&ftranstime2!=null&&ftranstime2!=""){
            sql1 = sql1+"and b.ftranstime between '"+ftranstime1+"' and '"+ftranstime2+"' ";
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

    @RequestMapping(params = "datagrid4")
    public void datagrid4(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        String idlist = request.getParameter("idlist");
        logger.info(idlist);
        String begin = request.getParameter("operatetime_begin");
        String end = request.getParameter("operatetime_end");
        String fcost = request.getParameter("fcost");
        String famount1 = request.getParameter("famount_begin");
        String famount2 = request.getParameter("famount_end");
        String fcheck = request.getParameter("fcheck");
        String fweituo = request.getParameter("fweituo");
        String paiche= request.getParameter("paiche");
        String fsettle = request.getParameter("fsettle");
        String createName = request.getParameter("createName");
        String ftitle = request.getParameter("ftitle");
        String fdriver = request.getParameter("fdriver");
        String fkp = request.getParameter("fkp");
        String fhx = request.getParameter("fhx");
//        String fdz = request.getParameter("fdz");
        String fbx = request.getParameter("fbx");
        String forigin = request.getParameter("forigin");
        String ftranstime1 = request.getParameter("ftranstime_begin");
        String ftranstime2 = request.getParameter("ftranstime_end");
        String[] strArray=idlist.split(",");
        String idarray = "(";
        for(int i=0;i<strArray.length;i++){
            idarray = idarray+"'"+strArray[i]+"',";
        }
        idarray = idarray.substring(0,idarray.length()-1)+")";
        Map queryparams =  new LinkedHashMap<String,Object>();
        String sql ="select a.id,a.fcost,a.fcostname,a.funit,a.fqty,a.fprice,a.famount,a.fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,a.fcheck,a.fshoufu,a.fsettle,a.fsettlename,b.fblno,b.fshipname,b.fvoyageno,b.foperate_time operatetime,b.fbillno fweituo,b.fnote,b.fentrust_unit entrust,c.fzhdp,c.fzhdpdz,d.fbillno paiche from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where a.fdz='N' and a.fshoufu='1' and a.id not in "+idarray;
        String sql1 = "select a.id,a.fcost,a.fcostname,a.funit,a.fqty,a.fprice,a.famount,a.fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,a.fcheck,a.fshoufu,a.fsettle,a.fsettlename,d.fblno,d.fshipname,d.fvoyageno,d.foperate_time operatetime,d.fbillno fweituo,d.fnote,d.fentrust_unit entrust,c.fzhdp,c.fzhdpdz,b.fbillno paiche from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where a.fdz='N' and a.fshoufu='1' and a.id not in "+idarray;
        //根据委托单查费用
        if(begin!=null&&end!=null&&begin!=""&&end!=""){
            sql = sql+"and CONVERT(varchar(100), b.foperate_time, 23) between '"+begin+"' and '"+end+"' ";
        }
        if(fcost!=null&&fcost!=""){
            sql = sql+"and a.fcost like '%"+fcost+"%' ";
        }
        if(famount1!=null&&famount1!=""&&famount2!=null&&famount2!=""){
            sql = sql+"and a.famount >= "+famount1+" and a.famount <= "+famount2+" ";
        }
        if(fcheck!=null&&fcheck!=""){
            sql = sql+"and a.fcheck = '"+fcheck+"' ";
        }
        if(fweituo!=null&&fweituo!=""){
            sql = sql+"and b.fbillno like '%"+fweituo+"%' ";
        }
        if(paiche!=null&&paiche!=""){
            sql = sql+"and d.fbillno like '%"+paiche+"%' ";
        }
        if(fsettle!=null&&fsettle!=""){
            sql = sql+"and a.fsettle like '%"+fsettle+"%' ";
        }
        if(createName!=null&&createName!=""){
            sql = sql+"and a.create_name like '%"+createName+"%' ";
        }
        if(ftitle!=null&&ftitle!=""){
            sql = sql+"and c.ftitle like '%"+ftitle+"%' ";
        }
        if(fdriver!=null&&fdriver!=""){
            sql = sql+"and d.fdriver like '%"+fdriver+"%' ";
        }
        if(fkp!=null&&fkp!=""){
            sql = sql+"and a.fkp = '"+fkp+"' ";
        }
        if(fhx!=null&&fhx!=""){
            sql = sql+"and a.fhx = '"+fhx+"' ";
        }
//        if(fdz!=null&&fdz!=""){
//            sql = sql+"and a.fdz = '"+fdz+"' ";
//        }
        if(fbx!=null&&fbx!=""){
            sql = sql+"and a.fbx = '"+fbx+"' ";
        }
        if(forigin!=null&&forigin!=""){
            sql = sql+"and a.forigin = "+forigin+" ";
        }
        if(ftranstime1!=null&&ftranstime1!=""&&ftranstime2!=null&&ftranstime2!=""){
            sql = sql+"and d.ftranstime between '"+ftranstime1+"' and '"+ftranstime2+"' ";
        }
        //根据派车单查费用
        if(begin!=null&&end!=null&&begin!=""&&end!=""){
            sql1 = sql1+"and CONVERT(varchar(100), d.foperate_time, 23) between '"+begin+"' and '"+end+"' ";
        }
        if(fcost!=null&&fcost!=""){
            sql1 = sql1+"and a.fcost like '%"+fcost+"%' ";
        }
        if(famount1!=null&&famount1!=""&&famount2!=null&&famount2!=""){
            sql1 = sql1+"and a.famount >= "+famount1+" and a.famount <= "+famount2+" ";
        }
        if(fcheck!=null&&fcheck!=""){
            sql1 = sql1+"and a.fcheck = '"+fcheck+"' ";
        }
        if(fweituo!=null&&fweituo!=""){
            sql1 = sql1+"and d.fbillno like '%"+fweituo+"%' ";
        }
        if(paiche!=null&&paiche!=""){
            sql1 = sql1+"and b.fbillno like '%"+paiche+"%' ";
        }
        if(fsettle!=null&&fsettle!=""){
            sql1 = sql1+"and a.fsettle like '%"+fsettle+"%' ";
        }
        if(createName!=null&&createName!=""){
            sql1 = sql1+"and a.create_name like '%"+createName+"%' ";
        }
        if(ftitle!=null&&ftitle!=""){
            sql1 = sql1+"and c.ftitle like '%"+ftitle+"%' ";
        }
        if(fdriver!=null&&fdriver!=""){
            sql1 = sql1+"and b.fdriver like '%"+fdriver+"%' ";
        }
        if(fkp!=null&&fkp!=""){
            sql1 = sql1+"and a.fkp = '"+fkp+"' ";
        }
        if(fhx!=null&&fhx!=""){
            sql1 = sql1+"and a.fhx = '"+fhx+"' ";
        }
//        if(fdz!=null&&fdz!=""){
//            sql1 = sql1+"and a.fdz = '"+fdz+"' ";
//        }
        if(fbx!=null&&fbx!=""){
            sql1 = sql1+"and a.fbx = '"+fbx+"' ";
        }
        if(forigin!=null&&forigin!=""){
            sql1 = sql1+"and a.forigin = "+forigin+" ";
        }
        if(ftranstime1!=null&&ftranstime1!=""&&ftranstime2!=null&&ftranstime2!=""){
            sql1 = sql1+"and b.ftranstime between '"+ftranstime1+"' and '"+ftranstime2+"' ";
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

	@RequestMapping(params = "datagrid5")
	public void datagrid5(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String begin = request.getParameter("operatetime_begin");
		String end = request.getParameter("operatetime_end");
		String fcost = request.getParameter("fcost");
		String famount1 = request.getParameter("famount_begin");
		String famount2 = request.getParameter("famount_end");
		String fcheck = request.getParameter("fcheck");
		String fweituo = request.getParameter("fweituo");
		String paiche= request.getParameter("paiche");
		String fsettle = request.getParameter("fsettle");
		String createName = request.getParameter("createName");
		String ftitle = request.getParameter("ftitle");
		String fdriver = request.getParameter("fdriver");
//		String fkp = request.getParameter("fkp");
//		String fhx = request.getParameter("fhx");
        String fdz = request.getParameter("fdz");
//		String fbx = request.getParameter("fbx");
		String forigin = request.getParameter("forigin");
		String ftranstime1 = request.getParameter("ftranstime_begin");
		String ftranstime2 = request.getParameter("ftranstime_end");
		Map queryparams =  new LinkedHashMap<String,Object>();
		String sql ="select a.id,a.fcost,a.fcostname,a.funit,a.fqty,a.fprice,a.famount,a.fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,a.fcheck,a.fshoufu,a.fsettle,a.fsettlename,b.fblno,b.fshipname,b.fvoyageno,b.foperate_time operatetime,b.fbillno fweituo,b.fnote,b.fentrust_unit entrust,b.fcus_code fcuscode,c.fzhdp,c.fzhdpdz,d.fbillno paiche from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where a.fkp='N' and a.fshoufu='0' ";
		String sql1 = "select a.id,a.fcost,a.fcostname,a.funit,a.fqty,a.fprice,a.famount,a.fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,a.fcheck,a.fshoufu,a.fsettle,a.fsettlename,d.fblno,d.fshipname,d.fvoyageno,d.foperate_time operatetime,d.fbillno fweituo,d.fnote,d.fentrust_unit entrust,d.fcus_code fcuscode,c.fzhdp,c.fzhdpdz,b.fbillno paiche from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where a.fkp='N' and a.fshoufu='0' ";
		//根据委托单查费用
		if(begin!=null&&end!=null&&begin!=""&&end!=""){
			sql = sql+"and CONVERT(varchar(100), b.foperate_time, 23) between '"+begin+"' and '"+end+"' ";
		}
		if(fcost!=null&&fcost!=""){
			sql = sql+"and a.fcost like '%"+fcost+"%' ";
		}
		if(famount1!=null&&famount1!=""&&famount2!=null&&famount2!=""){
			sql = sql+"and a.famount >= "+famount1+" and a.famount <= "+famount2+" ";
		}
		if(fcheck!=null&&fcheck!=""){
			sql = sql+"and a.fcheck = '"+fcheck+"' ";
		}
		if(fweituo!=null&&fweituo!=""){
			sql = sql+"and b.fbillno like '%"+fweituo+"%' ";
		}
		if(paiche!=null&&paiche!=""){
			sql = sql+"and d.fbillno like '%"+paiche+"%' ";
		}
		if(fsettle!=null&&fsettle!=""){
			sql = sql+"and a.fsettle like '%"+fsettle+"%' ";
		}
		if(createName!=null&&createName!=""){
			sql = sql+"and a.create_name like '%"+createName+"%' ";
		}
		if(ftitle!=null&&ftitle!=""){
			sql = sql+"and c.ftitle like '%"+ftitle+"%' ";
		}
		if(fdriver!=null&&fdriver!=""){
			sql = sql+"and d.fdriver like '%"+fdriver+"%' ";
		}
//		if(fkp!=null&&fkp!=""){
//			sql = sql+"and a.fkp = '"+fkp+"' ";
//		}
//		if(fhx!=null&&fhx!=""){
//			sql = sql+"and a.fhx = '"+fhx+"' ";
//		}
        if(fdz!=null&&fdz!=""){
            sql = sql+"and a.fdz = '"+fdz+"' ";
        }
//		if(fbx!=null&&fbx!=""){
//			sql = sql+"and a.fbx = '"+fbx+"' ";
//		}
		if(forigin!=null&&forigin!=""){
			sql = sql+"and a.forigin = "+forigin+" ";
		}
		if(ftranstime1!=null&&ftranstime1!=""&&ftranstime2!=null&&ftranstime2!=""){
			sql = sql+"and d.ftranstime between '"+ftranstime1+"' and '"+ftranstime2+"' ";
		}
		//根据派车单查费用
		if(begin!=null&&end!=null&&begin!=""&&end!=""){
			sql1 = sql1+"and CONVERT(varchar(100), d.foperate_time, 23) between '"+begin+"' and '"+end+"' ";
		}
		if(fcost!=null&&fcost!=""){
			sql1 = sql1+"and a.fcost like '%"+fcost+"%' ";
		}
		if(famount1!=null&&famount1!=""&&famount2!=null&&famount2!=""){
			sql1 = sql1+"and a.famount >= "+famount1+" and a.famount <= "+famount2+" ";
		}
		if(fcheck!=null&&fcheck!=""){
			sql1 = sql1+"and a.fcheck = '"+fcheck+"' ";
		}
		if(fweituo!=null&&fweituo!=""){
			sql1 = sql1+"and d.fbillno like '%"+fweituo+"%' ";
		}
		if(paiche!=null&&paiche!=""){
			sql1 = sql1+"and b.fbillno like '%"+paiche+"%' ";
		}
		if(fsettle!=null&&fsettle!=""){
			sql1 = sql1+"and a.fsettle like '%"+fsettle+"%' ";
		}
		if(createName!=null&&createName!=""){
			sql1 = sql1+"and a.create_name like '%"+createName+"%' ";
		}
		if(ftitle!=null&&ftitle!=""){
			sql1 = sql1+"and c.ftitle like '%"+ftitle+"%' ";
		}
		if(fdriver!=null&&fdriver!=""){
			sql1 = sql1+"and b.fdriver like '%"+fdriver+"%' ";
		}
//		if(fkp!=null&&fkp!=""){
//			sql1 = sql1+"and a.fkp = '"+fkp+"' ";
//		}
//		if(fhx!=null&&fhx!=""){
//			sql1 = sql1+"and a.fhx = '"+fhx+"' ";
//		}
        if(fdz!=null&&fdz!=""){
            sql1 = sql1+"and a.fdz = '"+fdz+"' ";
        }
//		if(fbx!=null&&fbx!=""){
//			sql1 = sql1+"and a.fbx = '"+fbx+"' ";
//		}
		if(forigin!=null&&forigin!=""){
			sql1 = sql1+"and a.forigin = "+forigin+" ";
		}
		if(ftranstime1!=null&&ftranstime1!=""&&ftranstime2!=null&&ftranstime2!=""){
			sql1 = sql1+"and b.ftranstime between '"+ftranstime1+"' and '"+ftranstime2+"' ";
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
	 * 删除费用
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ChargeEntity charge, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		charge = systemService.getEntity(ChargeEntity.class, charge.getId());
		message = "费用删除成功";
		try{
			chargeService.delete(charge);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "费用删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
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
				ChargeEntity charge = systemService.getEntity(ChargeEntity.class, id);
				charge.setFcheck("1");
				charge.setFchecker(ResourceUtil.getSessionUser().getUserName());
				charge.setFcheckdate(new Date());
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
				ChargeEntity charge = systemService.getEntity(ChargeEntity.class, id);
				charge.setFcheck("0");
				charge.setFchecker(ResourceUtil.getSessionUser().getUserName());
				charge.setFcheckdate(new Date());
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
	 * 批量删除费用
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "费用删除成功";
		try{
			for(String id:ids.split(",")){
				ChargeEntity charge = systemService.getEntity(ChargeEntity.class, 
				id
				);
				chargeService.delete(charge);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "费用删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加费用
	 * 
	 * @param charge
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ChargeEntity charge, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "费用添加成功";
		try{
			charge.setFkp("N");
			charge.setFhx("N");
			charge.setFbx("N");
			charge.setFdz("N");
			chargeService.save(charge);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "费用添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新费用
	 * 
	 * @param charge
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ChargeEntity charge, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "费用更新成功";
		ChargeEntity t = chargeService.get(ChargeEntity.class, charge.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(charge, t);
			chargeService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "费用更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 费用新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ChargeEntity charge, HttpServletRequest req) {
		String cid = req.getParameter("cid");
		String ly = req.getParameter("ly");
		String conid = req.getParameter("conid");
		req.setAttribute("cid",cid);
		req.setAttribute("fcheck","0");
		req.setAttribute("forigin",ly);
		req.setAttribute("conid",conid);
		if (StringUtil.isNotEmpty(charge.getId())) {
			charge = chargeService.getEntity(ChargeEntity.class, charge.getId());
			req.setAttribute("chargePage", charge);
		}
		return new ModelAndView("com/jeecg/charge/charge-add");
	}

	@RequestMapping(params = "goAdd1")
	public ModelAndView goAdd1(ChargeEntity charge, HttpServletRequest req) {
		String cid = req.getParameter("cid");
		String ly = req.getParameter("ly");
		String sf = req.getParameter("sf");
		req.setAttribute("cid",cid);
		req.setAttribute("fcheck","0");
		req.setAttribute("forigin",ly);
		req.setAttribute("sf",sf);
		if (StringUtil.isNotEmpty(charge.getId())) {
			charge = chargeService.getEntity(ChargeEntity.class, charge.getId());
			req.setAttribute("chargePage", charge);
		}
		return new ModelAndView("com/jeecg/charge/charge-add1");
	}

	/**
	 * 费用编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ChargeEntity charge, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(charge.getId())) {
			charge = chargeService.getEntity(ChargeEntity.class, charge.getId());
			req.setAttribute("chargePage", charge);
		}
		return new ModelAndView("com/jeecg/charge/charge-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","chargeController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ChargeEntity charge,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ChargeEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, charge, request.getParameterMap());
		List<ChargeEntity> charges = this.chargeService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"费用");
		modelMap.put(NormalExcelConstants.CLASS,ChargeEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("费用列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,charges);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ChargeEntity charge,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"费用");
    	modelMap.put(NormalExcelConstants.CLASS,ChargeEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("费用列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<ChargeEntity> listChargeEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ChargeEntity.class,params);
				for (ChargeEntity charge : listChargeEntitys) {
					chargeService.save(charge);
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
	@ApiOperation(value="费用列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ChargeEntity>> list() {
		List<ChargeEntity> listCharges=chargeService.getList(ChargeEntity.class);
		return Result.success(listCharges);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取费用信息",notes="根据ID获取费用信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ChargeEntity task = chargeService.get(ChargeEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取费用信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建费用")
	public ResponseMessage<?> create(@ApiParam(name="费用对象")@RequestBody ChargeEntity charge, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ChargeEntity>> failures = validator.validate(charge);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			chargeService.save(charge);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("费用信息保存失败");
		}
		return Result.success(charge);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新费用",notes="更新费用")
	public ResponseMessage<?> update(@ApiParam(name="费用对象")@RequestBody ChargeEntity charge) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ChargeEntity>> failures = validator.validate(charge);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			chargeService.saveOrUpdate(charge);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新费用信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新费用信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除费用")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			chargeService.deleteEntityById(ChargeEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("费用删除失败");
		}

		return Result.success();
	}
}
