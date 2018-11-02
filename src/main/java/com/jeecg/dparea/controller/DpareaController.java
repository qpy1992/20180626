package com.jeecg.dparea.controller;
import com.jeecg.doorpoint.entity.DoorPointEntity;
import com.jeecg.dparea.entity.DpareaEntity;
import com.jeecg.dparea.service.DpareaServiceI;
import com.jeecg.dparea.page.DpareaPage;
import com.jeecg.dp.entity.DpEntity;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
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
 * @Description: 门点区域
 * @author onlineGenerator
 * @date 2018-08-06 09:57:31
 * @version V1.0   
 *
 */
@Api(value="Dparea",description="门点区域",tags="dpareaController")
@Controller
@RequestMapping("/dpareaController")
public class DpareaController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DpareaController.class);

	@Autowired
	private DpareaServiceI dpareaService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private Validator validator;

	/**
	 * 门点区域列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/dparea/dpareaList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param dparea
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(DpareaEntity dparea,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DpareaEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dparea);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dpareaService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除门点区域
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DpareaEntity dparea, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dparea = systemService.getEntity(DpareaEntity.class, dparea.getId());
		String message = "门点区域删除成功";
		try{
			dpareaService.delMain(dparea);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "门点区域删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除门点区域
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "门点区域删除成功";
		try{
			for(String id:ids.split(",")){
				DpareaEntity dparea = systemService.getEntity(DpareaEntity.class,
				id
				);
				dpareaService.delMain(dparea);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "门点区域删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加门点区域
	 * 
	 * @param dparea
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DpareaEntity dparea,DpareaPage dpareaPage, HttpServletRequest request) {
		List<DpEntity> dpList =  dpareaPage.getDpList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			dparea.setFareaCode(getFbillno(77));
			dpareaService.addMain(dparea, dpList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "门点区域添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新门点区域
	 * 
	 * @param dparea
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DpareaEntity dparea,DpareaPage dpareaPage, HttpServletRequest request) {
		List<DpEntity> dpList =  dpareaPage.getDpList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			dpareaService.updateMain(dparea, dpList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新门点区域失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 作废门点区域
	 *
	 * @param dparea
	 * @return
	 */
	@RequestMapping(params = "doVoid")
	@ResponseBody
	public AjaxJson doVoid(DpareaEntity dparea, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = null;
		String ids = request.getParameter("ids");
		String[] entitys = ids.split(",");
		for(int i=0; i<entitys.length; i++){
			message = "作废成功!";
			dparea = dpareaService.getEntity(DpareaEntity.class, entitys[i]);
			try{
				dparea.setFvoid("Y");
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
	 * 门点区域新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DpareaEntity dparea, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dparea.getId())) {
			dparea = dpareaService.getEntity(DpareaEntity.class, dparea.getId());
			req.setAttribute("dpareaPage", dparea);
		}
		return new ModelAndView("com/jeecg/dparea/dparea-add");
	}
	
	/**
	 * 门点区域编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DpareaEntity dparea, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dparea.getId())) {
			dparea = dpareaService.getEntity(DpareaEntity.class, dparea.getId());
			req.setAttribute("dpareaPage", dparea);
		}
		return new ModelAndView("com/jeecg/dparea/dparea-update");
	}

	public String getFbillno(int fbilltype){
		String FProjectVal1 = jdbcTemplate.queryForObject("select FProjectVal from t_billCodeRule where FBillType=? and FProjectID=1",String.class,fbilltype);
		String FProjectVal2 = jdbcTemplate.queryForObject("select FProjectVal from t_billCodeRule where FbillType=? and FProjectID=2",String.class,fbilltype);
		String date = new SimpleDateFormat("yy-MM-dd").format(new Date());
		String index = "";
		if(FProjectVal2.equals(date)){
			index = jdbcTemplate.queryForObject("select FProjectVal from t_billCodeRule where FBillType=? and FProjectID=3",String.class,fbilltype);
			index = String.valueOf(Integer.parseInt(index)+1);
			jdbcTemplate.update("update t_billCodeRule set FProjectVal=? where fbilltype= ? and fprojectid=3",new Object[]{index,fbilltype});
		}else{
			jdbcTemplate.update("update t_billCodeRule set FProjectVal=? where fbilltype= ? and fprojectid=2",new Object[]{date,fbilltype});
			jdbcTemplate.update("update t_BillCodeRule set FProjectVal=1 where fbilltype= ? and fprojectid=3",fbilltype);
			index="1";
		}
		String suffix = "000"+index;
		String fbillno = FProjectVal1+date+suffix.substring(suffix.length()-3,suffix.length());
		return fbillno;
	}

	/**
	 * 加载明细列表[门点堆场]
	 * 
	 * @return
	 */
	@RequestMapping(params = "dpList")
	public ModelAndView dpList(DpareaEntity dparea, HttpServletRequest req) {
		//===================================================================================
		//获取参数
		Object id0 = dparea.getId();
		//===================================================================================
		//查询-门点堆场
	    String hql0 = "from DpEntity where 1 = 1 AND fID = ? ";
	    try{
	    	List<DpEntity> dpEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("dpList", dpEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/dp/dpList");
	}

	/**
	 * 门点选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params="dplist")
	public ModelAndView orderlist(HttpServletRequest request){
		return new ModelAndView("com/jeecg/dparea/doorPointList");
	}

	/**
	 * 堆场选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params="yardlist")
	public ModelAndView yardlist(HttpServletRequest request){
		return new ModelAndView("com/jeecg/dparea/yardList");
	}

	/**
	 * 门点选择数据拼装
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @throws IOException
	 */
	@RequestMapping(params = "dps")
	@ResponseBody
	public void dps(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) throws IOException {
		String ids=request.getParameter("ids");     //接收传入的id值
		String[] strArray = null;
		strArray = ids.split(",");
		List<DoorPointEntity> oue=new ArrayList<>();
		for(int i=0;i<strArray.length;i++){
			DoorPointEntity ou=systemService.getEntity(DoorPointEntity.class,Integer.parseInt(strArray[i]));
			oue.add(ou);
		}
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"doorpoint"});
		net.sf.json.JSONArray jsa = net.sf.json.JSONArray.fromObject(oue,jsonConfig);
		response.getWriter().write(jsa.toString());
		logger.info(jsa.toString());
	}

	/**
	 * 堆场选择数据拼装
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @throws IOException
	 */
	@RequestMapping(params = "yards")
	@ResponseBody
	public void yards(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) throws IOException {
		String ids=request.getParameter("ids");     //接收传入的id值
		String[] strArray = null;
		strArray = ids.split(",");
		List<DoorPointEntity> oue=new ArrayList<>();
		for(int i=0;i<strArray.length;i++){
			DoorPointEntity ou=systemService.getEntity(DoorPointEntity.class,Integer.parseInt(strArray[i]));
			oue.add(ou);
		}
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"yard"});
		net.sf.json.JSONArray jsa = net.sf.json.JSONArray.fromObject(oue,jsonConfig);
		response.getWriter().write(jsa.toString());
		logger.info(jsa.toString());
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(DpareaEntity dparea,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(DpareaEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dparea);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<DpareaEntity> list=this.dpareaService.getListByCriteriaQuery(cq, false);
    	List<DpareaPage> pageList=new ArrayList<DpareaPage>();
        if(list!=null&&list.size()>0){
        	for(DpareaEntity entity:list){
        		try{
        		DpareaPage page=new DpareaPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from DpEntity where 1 = 1 AND fID = ? ";
        	        List<DpEntity> dpEntityList = systemService.findHql(hql0,id0);
            		page.setDpList(dpEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"门点区域");
        map.put(NormalExcelConstants.CLASS,DpareaPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("门点区域列表", "导出人:Jeecg",
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
				List<DpareaPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), DpareaPage.class, params);
				DpareaEntity entity1=null;
				for (DpareaPage page : list) {
					entity1=new DpareaEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            dpareaService.addMain(entity1, page.getDpList());
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
		map.put(NormalExcelConstants.FILE_NAME,"门点区域");
		map.put(NormalExcelConstants.CLASS,DpareaPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("门点区域列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "dpareaController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="门点区域列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<DpareaPage>> list() {
		List<DpareaEntity> list= dpareaService.getList(DpareaEntity.class);
    	List<DpareaPage> pageList=new ArrayList<DpareaPage>();
        if(list!=null&&list.size()>0){
        	for(DpareaEntity entity:list){
        		try{
        			DpareaPage page=new DpareaPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from DpEntity where 1 = 1 AND fID = ? ";
	    			List<DpEntity> dpOldList = this.dpareaService.findHql(hql0,id0);
            		page.setDpList(dpOldList);
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
	@ApiOperation(value="根据ID获取门点区域信息",notes="根据ID获取门点区域信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		DpareaEntity task = dpareaService.get(DpareaEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取门点区域信息为空");
		}
		DpareaPage page = new DpareaPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from DpEntity where 1 = 1 AND fID = ? ";
			List<DpEntity> dpOldList = this.dpareaService.findHql(hql0,id0);
    		page.setDpList(dpOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建门点区域")
	public ResponseMessage<?> create(@ApiParam(name="门点区域对象")@RequestBody DpareaPage dpareaPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DpareaPage>> failures = validator.validate(dpareaPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<DpEntity> dpList =  dpareaPage.getDpList();
		
		DpareaEntity dparea = new DpareaEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(dpareaPage,dparea);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存门点区域失败");
        }
		dpareaService.addMain(dparea, dpList);

		return Result.success(dparea);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新门点区域",notes="更新门点区域")
	public ResponseMessage<?> update(@RequestBody DpareaPage dpareaPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DpareaPage>> failures = validator.validate(dpareaPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<DpEntity> dpList =  dpareaPage.getDpList();
		
		DpareaEntity dparea = new DpareaEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(dpareaPage,dparea);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("门点区域更新失败");
        }
		dpareaService.updateMain(dparea, dpList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除门点区域")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			DpareaEntity dparea = dpareaService.get(DpareaEntity.class, id);
			dpareaService.delMain(dparea);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("门点区域删除失败");
		}

		return Result.success();
	}
}
