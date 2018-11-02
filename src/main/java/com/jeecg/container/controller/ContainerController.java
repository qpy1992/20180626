package com.jeecg.container.controller;
import com.jeecg.container.entity.ContainerEntity;
import com.jeecg.container.service.ContainerServiceI;
import com.jeecg.cost.entity.CostEntity;

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
import org.springframework.web.bind.annotation.RequestParam;
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
import net.sf.json.JSON;
import net.sf.json.JSONObject;

/**   
 * @Title: Controller  
 * @Description: 集装箱
 * @author onlineGenerator
 * @date 2018-07-02 10:52:51
 * @version V1.0   
 *
 */
@Api(value="Container",description="集装箱",tags="containerController")
@Controller
@RequestMapping("/containerController")
public class ContainerController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ContainerController.class);

	@Autowired
	private ContainerServiceI containerService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 集装箱列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/container/containerList");
	}
	
	/**
	 * 集装箱列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list1")
	public ModelAndView list1(HttpServletRequest request) {
		request.setAttribute("fid", request.getParameter("fid"));
		return new ModelAndView("com/jeecg/contianer/contianerList1");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param container
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ContainerEntity container,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ContainerEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, container, request.getParameterMap());
		try{
			String fid = request.getParameter("fid");
			if(fid!=null)
			{
				cq.eq("fid",fid);
			}
			//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.containerService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "datagrid1")
	public void datagrid1(ContainerEntity container,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ContainerEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, container, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.eq("fbillno",null);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.containerService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "containerList")
	@ResponseBody
	public JSON orderList(@RequestParam String fid) {
		//Map<String, Object> map = new HashMap<String, Object>();
		JSONObject jsonMessage = new JSONObject();
		//map.put("fid", fid);
		//===================================================================================
		//获取参数
		Object id1 = fid;
		//===================================================================================
		//查询-费用
	    String hql1 = "from ContainerEntity where 1 = 1 AND fID = ? ";
	    try{
	    	List<ContainerEntity> containerEntityList = systemService.findHql(hql1,id1);
			jsonMessage.put("containerEntityList",containerEntityList);
			jsonMessage.put("message","订单成功");
			jsonMessage.put("code",1);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		//根据电话号码进行判断
		return jsonMessage;
	}
	
	
	/**
	 * 删除集装箱
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ContainerEntity container, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		container = systemService.getEntity(ContainerEntity.class, container.getId());
		message = "集装箱删除成功";
		try{
			containerService.delete(container);
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
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "集装箱删除成功";
		try{
			for(String id:ids.split(",")){
				ContainerEntity container = systemService.getEntity(ContainerEntity.class, 
				id
				);
				containerService.delete(container);
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
	 * @param container
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ContainerEntity container, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "集装箱添加成功";
		try{
			containerService.save(container);
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
	 * @param container
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ContainerEntity container, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "集装箱更新成功";
		ContainerEntity t = containerService.get(ContainerEntity.class, container.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(container, t);
			containerService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "集装箱更新失败";
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
	public ModelAndView goAdd(ContainerEntity container, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(container.getId())) {
			container = containerService.getEntity(ContainerEntity.class, container.getId());
			req.setAttribute("containerPage", container);
		}
		return new ModelAndView("com/jeecg/container/container-add");
	}
	/**
	 * 集装箱编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ContainerEntity container, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(container.getId())) {
			container = containerService.getEntity(ContainerEntity.class, container.getId());
			req.setAttribute("containerPage", container);
		}
		return new ModelAndView("com/jeecg/container/container-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","containerController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ContainerEntity container,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ContainerEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, container, request.getParameterMap());
		List<ContainerEntity> containers = this.containerService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"集装箱");
		modelMap.put(NormalExcelConstants.CLASS,ContainerEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("集装箱列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,containers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ContainerEntity container,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"集装箱");
    	modelMap.put(NormalExcelConstants.CLASS,ContainerEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("集装箱列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
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
		return new ModelAndView("com/jeecg/container/containerList");
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
				List<ContainerEntity> listContainerEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ContainerEntity.class,params);
				for (ContainerEntity container : listContainerEntitys) {
					containerService.save(container);
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
	@ApiOperation(value="集装箱列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ContainerEntity>> list() {
		List<ContainerEntity> listContainers=containerService.getList(ContainerEntity.class);
		return Result.success(listContainers);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取集装箱信息",notes="根据ID获取集装箱信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ContainerEntity task = containerService.get(ContainerEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取集装箱信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建集装箱")
	public ResponseMessage<?> create(@ApiParam(name="集装箱对象")@RequestBody ContainerEntity container, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ContainerEntity>> failures = validator.validate(container);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			containerService.save(container);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("集装箱信息保存失败");
		}
		return Result.success(container);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新集装箱",notes="更新集装箱")
	public ResponseMessage<?> update(@ApiParam(name="集装箱对象")@RequestBody ContainerEntity container) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ContainerEntity>> failures = validator.validate(container);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			containerService.saveOrUpdate(container);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新集装箱信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新集装箱信息成功");
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
			containerService.deleteEntityById(ContainerEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("集装箱删除失败");
		}

		return Result.success();
	}
}
