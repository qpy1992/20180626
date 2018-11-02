package com.jeecg.zanluo.controller;
import com.jeecg.container.entity.ContainerEntity;
import com.jeecg.contianer.entity.ContianerEntity;
import com.jeecg.zanluo.entity.ZanluoEntity;
import com.jeecg.zanluo.service.ZanluoServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
import java.util.Map;
import java.util.HashMap;
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
import java.util.Set;
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
 * @Description: 暂落记录
 * @author onlineGenerator
 * @date 2018-08-01 08:53:50
 * @version V1.0   
 *
 */
@Api(value="Zanluo",description="暂落记录",tags="zanluoController")
@Controller
@RequestMapping("/zanluoController")
public class ZanluoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZanluoController.class);

	@Autowired
	private ZanluoServiceI zanluoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 暂落记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/zanluo/zanluoList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param zanluo
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ZanluoEntity zanluo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZanluoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zanluo, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zanluoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除暂落记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZanluoEntity zanluo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		zanluo = systemService.getEntity(ZanluoEntity.class, zanluo.getId());
		message = "暂落记录删除成功";
		try{
			zanluoService.delete(zanluo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "暂落记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除暂落记录
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "暂落记录删除成功";
		try{
			for(String id:ids.split(",")){
				ZanluoEntity zanluo = systemService.getEntity(ZanluoEntity.class, 
				id
				);
				zanluoService.delete(zanluo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "暂落记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加暂落记录
	 * 
	 * @param zanluo
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZanluoEntity zanluo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "暂落记录添加成功";
		try{
			zanluoService.save(zanluo);
			ContianerEntity contianer = systemService.findUniqueByProperty(ContianerEntity.class,"fboxno",zanluo.getFboxno());
			contianer.setFzanluo("Y");
			ContianerEntity con = new ContianerEntity();
			con.setFboxno(contianer.getFboxno());
			con.setFtitle(contianer.getFtitle());
			con.setFboxtype(contianer.getFboxtype());
			con.setFmodel(contianer.getFmodel());
			con.setFmakeboxtime(contianer.getFmakeboxtime());
			con.setFgrade(contianer.getFgrade());
			con.setFdrpagenum(contianer.getFdrpagenum());
			con.setFunnumber(contianer.getFunnumber());
			con.setFlashPoint(contianer.getFlashPoint());
			con.setFcolddegree(contianer.getFcolddegree());
			con.setFtotals(contianer.getFtotals());
			con.setFgrosses(contianer.getFgrosses());
			con.setFvolumes(contianer.getFvolumes());
			con.setFextract(contianer.getFextract());
			con.setFreturn(contianer.getFreturn());
			con.setFoperator(contianer.getFoperator());
			con.setFid(contianer.getFid());
			con.setFzhdp(contianer.getFzhdp());
			con.setFzhdpdz(contianer.getFzhdpdz());
			con.setFzhunit(contianer.getFzhunit());
			con.setFzhcontact(contianer.getFzhcontact());
			con.setFzhmobile(contianer.getFzhmobile());
			con.setFnote(contianer.getFnote());
			con.setFtsyw(contianer.getFtsyw());
			con.setFxhdp(contianer.getFxhdp());
			con.setFxhdpdz(contianer.getFxhdpdz());
			con.setFxhtime(contianer.getFxhtime());
			con.setFxhunit(contianer.getFxhunit());
			con.setFxhcontact(contianer.getFxhcontact());
			con.setFxhmobile(contianer.getFxhmobile());
			con.setFbillno(null);
			con.setFzanluo(contianer.getFzanluo());
			con.setFshuaigua(contianer.getFshuaigua());
			con.setFboxiang(contianer.getFboxiang());
			con.setFyuti(contianer.getFyuti());
			con.setFjixu(contianer.getFjixu());
			con.setFquxiao(contianer.getFquxiao());
			con.setFxiandao(contianer.getFxiandao());
			con.setFup(contianer.getFup());
			con.setFqsdate(contianer.getFqsdate());
			con.setFieport(contianer.getFieport());
			con.setFdaihuo(contianer.getFdaihuo());
			con.setFcheck(contianer.getFcheck());
			con.setFchecker(contianer.getFchecker());
			con.setFcheckdate(contianer.getFcheckdate());
			systemService.save(con);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "暂落记录添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新暂落记录
	 * 
	 * @param zanluo
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZanluoEntity zanluo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "暂落记录更新成功";
		ZanluoEntity t = zanluoService.get(ZanluoEntity.class, zanluo.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(zanluo, t);
			zanluoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "暂落记录更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 暂落记录新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZanluoEntity zanluo, HttpServletRequest req) {
		String fboxno = req.getParameter("fboxno");
		String cid = req.getParameter("cid");
		req.setAttribute("fboxno",fboxno);
		req.setAttribute("cid",cid);
		if (StringUtil.isNotEmpty(zanluo.getId())) {
			zanluo = zanluoService.getEntity(ZanluoEntity.class, zanluo.getId());
			req.setAttribute("zanluoPage", zanluo);
		}
		return new ModelAndView("com/jeecg/zanluo/zanluo-add");
	}
	/**
	 * 暂落记录编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZanluoEntity zanluo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zanluo.getId())) {
			zanluo = zanluoService.getEntity(ZanluoEntity.class, zanluo.getId());
			req.setAttribute("zanluoPage", zanluo);
		}
		return new ModelAndView("com/jeecg/zanluo/zanluo-update");
	}

	@RequestMapping(params = "goUpdate1")
	public ModelAndView goUpdate1(ZanluoEntity zanluo, HttpServletRequest req) {
		String fboxno = req.getParameter("fboxno");
		zanluo = zanluoService.findUniqueByProperty(ZanluoEntity.class,"fboxno",fboxno);
		req.setAttribute("zanluoPage",zanluo);
		return new ModelAndView("com/jeecg/zanluo/zanluo-update");
	}

	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","zanluoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ZanluoEntity zanluo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ZanluoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zanluo, request.getParameterMap());
		List<ZanluoEntity> zanluos = this.zanluoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"暂落记录");
		modelMap.put(NormalExcelConstants.CLASS,ZanluoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("暂落记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,zanluos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ZanluoEntity zanluo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"暂落记录");
    	modelMap.put(NormalExcelConstants.CLASS,ZanluoEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("暂落记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<ZanluoEntity> listZanluoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ZanluoEntity.class,params);
				for (ZanluoEntity zanluo : listZanluoEntitys) {
					zanluoService.save(zanluo);
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
	@ApiOperation(value="暂落记录列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ZanluoEntity>> list() {
		List<ZanluoEntity> listZanluos=zanluoService.getList(ZanluoEntity.class);
		return Result.success(listZanluos);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取暂落记录信息",notes="根据ID获取暂落记录信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ZanluoEntity task = zanluoService.get(ZanluoEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取暂落记录信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建暂落记录")
	public ResponseMessage<?> create(@ApiParam(name="暂落记录对象")@RequestBody ZanluoEntity zanluo, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZanluoEntity>> failures = validator.validate(zanluo);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			zanluoService.save(zanluo);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("暂落记录信息保存失败");
		}
		return Result.success(zanluo);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新暂落记录",notes="更新暂落记录")
	public ResponseMessage<?> update(@ApiParam(name="暂落记录对象")@RequestBody ZanluoEntity zanluo) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZanluoEntity>> failures = validator.validate(zanluo);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			zanluoService.saveOrUpdate(zanluo);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新暂落记录信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新暂落记录信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除暂落记录")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			zanluoService.deleteEntityById(ZanluoEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("暂落记录删除失败");
		}

		return Result.success();
	}
}
