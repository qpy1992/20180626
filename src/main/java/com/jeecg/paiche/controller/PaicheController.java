package com.jeecg.paiche.controller;
import com.jeecg.paiche.entity.PaicheEntity;
import com.jeecg.paiche.service.PaicheServiceI;

import java.io.PrintWriter;
import java.util.*;
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
 * @Description: 统一派车单管理
 * @author onlineGenerator
 * @date 2018-07-31 15:13:01
 * @version V1.0   
 *
 */
@Api(value="Paiche",description="统一派车单管理",tags="paicheController")
@Controller
@RequestMapping("/paicheController")
public class PaicheController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PaicheController.class);

	@Autowired
	private PaicheServiceI paicheService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgReportServiceI cgReportService;
	@Autowired
	private Validator validator;
	


	/**
	 * 统一派车单管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/paiche/paicheList");
	}

	@RequestMapping(params = "paichedetail")
	public ModelAndView paichedetail(HttpServletRequest request) {
		String pid = request.getParameter("pid");
		String fboxid = request.getParameter("fboxid");
		logger.info("传来的id："+pid+"和箱子id："+fboxid);
		request.setAttribute("pid",pid);
		request.setAttribute("fboxid",fboxid);
		return new ModelAndView("com/jeecg/paiche/paicheDetail");
	}

	@RequestMapping(params = "weituo")
	public ModelAndView weituo(HttpServletRequest request) {
		String fboxid = request.getParameter("fboxid");
		logger.info("箱子id："+fboxid);
		request.setAttribute("fboxid",fboxid);
		return new ModelAndView("com/jeecg/paiche/entrustList");
	}

	@RequestMapping(params = "chuche")
	public ModelAndView chuche(PaicheEntity paiche,HttpServletRequest request) {
		String id = request.getParameter("id");
		paiche = paicheService.getEntity(PaicheEntity.class, id);
		request.setAttribute("paichePage", paiche);
		return new ModelAndView("com/jeecg/paiche/chucheList");
	}


	@RequestMapping(params = "huidan")
	public ModelAndView huidan(PaicheEntity paiche,HttpServletRequest request) {
		String id = request.getParameter("id");
		paiche = paicheService.getEntity(PaicheEntity.class, id);
		request.setAttribute("paichePage", paiche);
		return new ModelAndView("com/jeecg/paiche/huidanList");
	}

	@RequestMapping(params = "fee")
	public ModelAndView fee(HttpServletRequest request) {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		return new ModelAndView("com/jeecg/paiche/feelist");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param paiche
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(PaicheEntity paiche,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PaicheEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, paiche, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.paicheService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

    @RequestMapping(params = "datagrid1")
    public void datagrid1(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        Map queryparams =  new LinkedHashMap<String,Object>();
        String sql = "select a.id,a.fcheck,c.fbillno+'-'+b.fno fbillno1,a.fbillno,a.fcarno,a.fdriver,c.fblno,b.fboxno,b.fextract,b.fzhtime,b.fzhdp,b.fxhtime,b.fxhdp,b.freturn,a.fstatus,a.fboxid from z_paiche a left join z_contianer b on b.id=a.fboxid left join z_custom_entrust c on c.id=b.fid";
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

	@RequestMapping(params = "entrust")
	public void entrust(PaicheEntity paiche,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String fboxid = request.getParameter("fboxid");
		Map queryparams =  new LinkedHashMap<String,Object>();
		String sql = "select a.fboxno,a.ftitle,a.fboxtype,a.fxhunit,a.fzanluo,a.fxhdpdz,a.fxhcontact,a.fxhmobile,a.fquxiao,a.fboxiang,a.fxiandao,a.fup,a.fyuti,a.fqsdate,a.fieport,a.fdaihuo,b.fcontact,b.fbillno fweituo,b.fshipname,b.fvoyageno,b.fblno" +
				",b.ftxyard,b.fhxyard,c.ftranstime,c.id from z_contianer a left join z_custom_entrust b on b.id=a.fid left join" +
				" z_paiche c on c.fboxid=a.id where a.id = '"+fboxid+"'";
		logger.info(sql);
		List<Map<String, Object>> result= cgReportService.queryByCgReportSql(sql, queryparams, dataGrid.getPage(), dataGrid.getRows());
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

    @RequestMapping(params = "print")
    public ModelAndView print(PaicheEntity paiche, HttpServletRequest request) {
        String id = paiche.getId();
        ModelAndView ml = new ModelAndView();
        request.setAttribute("dataid", id);
        ml.setViewName("com/jeecg/paiche/report");
        return ml;
    }

	/**
	 * 删除统一派车单管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(PaicheEntity paiche, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		paiche = systemService.getEntity(PaicheEntity.class, paiche.getId());
		message = "统一派车单管理删除成功";
		try{
		    if(paiche.getFcheck().equals("1")){
		        message = "单据已经审核，无法删除！";
            }else {
                paicheService.delete(paiche);
            }
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "统一派车单管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除统一派车单管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "统一派车单管理删除成功";
		try{
		    for (String id : ids.split(",")) {
		        PaicheEntity paiche = systemService.getEntity(PaicheEntity.class, id);
		        paicheService.delete(paiche);
		        systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
		}catch(Exception e){
			e.printStackTrace();
			message = "统一派车单管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加统一派车单管理
	 * 
	 * @param paiche
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(PaicheEntity paiche, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "统一派车单管理添加成功";
		try{
			paicheService.save(paiche);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "统一派车单管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新统一派车单管理
	 * 
	 * @param paiche
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(PaicheEntity paiche, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "统一派车单管理更新成功";
		PaicheEntity t = paicheService.get(PaicheEntity.class, paiche.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(paiche, t);
			paicheService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "统一派车单管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 统一派车单管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(PaicheEntity paiche, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(paiche.getId())) {
			paiche = paicheService.getEntity(PaicheEntity.class, paiche.getId());
			req.setAttribute("paichePage", paiche);
		}
		return new ModelAndView("com/jeecg/paiche/paiche-add");
	}
	/**
	 * 统一派车单管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(PaicheEntity paiche, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(paiche.getId())) {
			paiche = paicheService.getEntity(PaicheEntity.class, paiche.getId());
			req.setAttribute("paichePage", paiche);
		}
		return new ModelAndView("com/jeecg/paiche/paiche-update");
	}

	@RequestMapping(params = "update")
	@ResponseBody
	public AjaxJson update(PaicheEntity paiche, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			paicheService.saveOrUpdate(paiche);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新失败";
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
		req.setAttribute("controller_name","paicheController");
		return new ModelAndView("common/upload/pub_excel_upload");
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
				PaicheEntity paiche = systemService.getEntity(PaicheEntity.class, id);
				paiche.setFcheck("1");
				paiche.setFchecker(ResourceUtil.getSessionUser().getUserName());
				paiche.setFcheckdate(new Date());
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
				PaicheEntity paiche = systemService.getEntity(PaicheEntity.class, id);
				paiche.setFcheck("0");
				paiche.setFchecker(ResourceUtil.getSessionUser().getUserName());
				paiche.setFcheckdate(new Date());
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
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(PaicheEntity paiche,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(PaicheEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, paiche, request.getParameterMap());
		List<PaicheEntity> paiches = this.paicheService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"统一派车单管理");
		modelMap.put(NormalExcelConstants.CLASS,PaicheEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("统一派车单管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,paiches);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(PaicheEntity paiche,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"统一派车单管理");
    	modelMap.put(NormalExcelConstants.CLASS,PaicheEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("统一派车单管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<PaicheEntity> listPaicheEntitys = ExcelImportUtil.importExcel(file.getInputStream(),PaicheEntity.class,params);
				for (PaicheEntity paiche : listPaicheEntitys) {
					paicheService.save(paiche);
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
	@ApiOperation(value="统一派车单管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<PaicheEntity>> list() {
		List<PaicheEntity> listPaiches=paicheService.getList(PaicheEntity.class);
		return Result.success(listPaiches);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取统一派车单管理信息",notes="根据ID获取统一派车单管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
//		PaicheEntity task = paicheService.get(PaicheEntity.class, id);
        DataGrid dataGrid = new DataGrid();
        Map queryparams =  new LinkedHashMap<String,Object>();
        String sql = "select a.*,c.fbillno weituohao,c.fcontact,c.fshipname,c.fvoyageno,c.fblno,b.ftitle,b.fboxtype,c.ftxyard,c.fhxyard,b.fxhunit,b.fxhdpdz,b.fxhcontact,b.fxhmobile from z_paiche a left join z_contianer b on b.fbillno=a.fbillno left join z_custom_entrust c on c.id=b.fid where a.id='"+id+"'";
        List<Map<String, Object>> task= cgReportService.queryByCgReportSql(sql, queryparams, dataGrid.getPage(), dataGrid.getRows());
		if (task == null) {
			return Result.error("根据ID获取统一派车单管理信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建统一派车单管理")
	public ResponseMessage<?> create(@ApiParam(name="统一派车单管理对象")@RequestBody PaicheEntity paiche, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<PaicheEntity>> failures = validator.validate(paiche);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			paicheService.save(paiche);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("统一派车单管理信息保存失败");
		}
		return Result.success(paiche);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新统一派车单管理",notes="更新统一派车单管理")
	public ResponseMessage<?> update(@ApiParam(name="统一派车单管理对象")@RequestBody PaicheEntity paiche) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<PaicheEntity>> failures = validator.validate(paiche);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			paicheService.saveOrUpdate(paiche);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新统一派车单管理信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新统一派车单管理信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除统一派车单管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			paicheService.deleteEntityById(PaicheEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("统一派车单管理删除失败");
		}

		return Result.success();
	}
}
