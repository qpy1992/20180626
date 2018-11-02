package com.jeecg.z_exit.controller;
import com.jeecg.z_exit.entity.ZExitEntity;
import com.jeecg.z_exit.service.ZExitServiceI;
import com.jeecg.z_exit.page.ZExitPage;
import com.jeecg.z_exitdetail.entity.ZExitdetailEntity;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Map;

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
import java.util.Set;
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
 * @Description: 出库
 * @author onlineGenerator
 * @date 2018-08-10 12:21:40
 * @version V1.0   
 *
 */
@Api(value="ZExit",description="出库",tags="zExitController")
@Controller
@RequestMapping("/zExitController")
public class ZExitController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZExitController.class);

	@Autowired
	private ZExitServiceI zExitService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 出库列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/z_exit/zExitList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ZExitEntity zExit,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZExitEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zExit);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zExitService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除出库
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZExitEntity zExit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		zExit = systemService.getEntity(ZExitEntity.class, zExit.getId());
		String message = "出库删除成功";
		try{
			zExitService.delMain(zExit);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "出库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除出库
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "出库删除成功";
		try{
			for(String id:ids.split(",")){
				ZExitEntity zExit = systemService.getEntity(ZExitEntity.class,
				id
				);
				zExitService.delMain(zExit);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "出库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加出库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZExitEntity zExit,ZExitPage zExitPage, HttpServletRequest request) {
		List<ZExitdetailEntity> zExitdetailList =  zExitPage.getZExitdetailList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			zExitService.addMain(zExit, zExitdetailList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "出库添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新出库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZExitEntity zExit,ZExitPage zExitPage, HttpServletRequest request) {
		List<ZExitdetailEntity> zExitdetailList =  zExitPage.getZExitdetailList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			zExitService.updateMain(zExit, zExitdetailList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新出库失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 出库新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZExitEntity zExit, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zExit.getId())) {
			zExit = zExitService.getEntity(ZExitEntity.class, zExit.getId());
			req.setAttribute("zExitPage", zExit);
		}
		return new ModelAndView("com/jeecg/z_exit/zExit-add");
	}
	
	/**
	 * 出库编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZExitEntity zExit, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zExit.getId())) {
			zExit = zExitService.getEntity(ZExitEntity.class, zExit.getId());
			req.setAttribute("zExitPage", zExit);
		}
		return new ModelAndView("com/jeecg/z_exit/zExit-update");
	}
	
	
	/**
	 * 加载明细列表[出库明细表]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zExitdetailList")
	public ModelAndView zExitdetailList(ZExitEntity zExit, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = zExit.getId();
		//===================================================================================
		//查询-出库明细表
	    String hql0 = "from ZExitdetailEntity where 1 = 1 AND z_EXIT_ID = ? ";
	    try{
	    	List<ZExitdetailEntity> zExitdetailEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("zExitdetailList", zExitdetailEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/z_exitdetail/zExitdetailList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(ZExitEntity zExit,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(ZExitEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zExit);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<ZExitEntity> list=this.zExitService.getListByCriteriaQuery(cq, false);
    	List<ZExitPage> pageList=new ArrayList<ZExitPage>();
        if(list!=null&&list.size()>0){
        	for(ZExitEntity entity:list){
        		try{
        		ZExitPage page=new ZExitPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from ZExitdetailEntity where 1 = 1 AND z_EXIT_ID = ? ";
        	        List<ZExitdetailEntity> zExitdetailEntityList = systemService.findHql(hql0,id0);
            		page.setZExitdetailList(zExitdetailEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"出库");
        map.put(NormalExcelConstants.CLASS,ZExitPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("出库列表", "导出人:Jeecg",
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
				List<ZExitPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), ZExitPage.class, params);
				ZExitEntity entity1=null;
				for (ZExitPage page : list) {
					entity1=new ZExitEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            zExitService.addMain(entity1, page.getZExitdetailList());
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
		map.put(NormalExcelConstants.FILE_NAME,"出库");
		map.put(NormalExcelConstants.CLASS,ZExitPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("出库列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "zExitController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="出库列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ZExitPage>> list() {
		List<ZExitEntity> list= zExitService.getList(ZExitEntity.class);
    	List<ZExitPage> pageList=new ArrayList<ZExitPage>();
        if(list!=null&&list.size()>0){
        	for(ZExitEntity entity:list){
        		try{
        			ZExitPage page=new ZExitPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from ZExitdetailEntity where 1 = 1 AND z_EXIT_ID = ? ";
	    			List<ZExitdetailEntity> zExitdetailOldList = this.zExitService.findHql(hql0,id0);
            		page.setZExitdetailList(zExitdetailOldList);
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
	@ApiOperation(value="根据ID获取出库信息",notes="根据ID获取出库信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ZExitEntity task = zExitService.get(ZExitEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取出库信息为空");
		}
		ZExitPage page = new ZExitPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from ZExitdetailEntity where 1 = 1 AND z_EXIT_ID = ? ";
			List<ZExitdetailEntity> zExitdetailOldList = this.zExitService.findHql(hql0,id0);
    		page.setZExitdetailList(zExitdetailOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建出库")
	public ResponseMessage<?> create(@ApiParam(name="出库对象")@RequestBody ZExitPage zExitPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZExitPage>> failures = validator.validate(zExitPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ZExitdetailEntity> zExitdetailList =  zExitPage.getZExitdetailList();
		
		ZExitEntity zExit = new ZExitEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(zExitPage,zExit);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存出库失败");
        }
		zExitService.addMain(zExit, zExitdetailList);

		return Result.success(zExit);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新出库",notes="更新出库")
	public ResponseMessage<?> update(@RequestBody ZExitPage zExitPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZExitPage>> failures = validator.validate(zExitPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ZExitdetailEntity> zExitdetailList =  zExitPage.getZExitdetailList();
		
		ZExitEntity zExit = new ZExitEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(zExitPage,zExit);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("出库更新失败");
        }
		zExitService.updateMain(zExit, zExitdetailList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除出库")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			ZExitEntity zExit = zExitService.get(ZExitEntity.class, id);
			zExitService.delMain(zExit);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("出库删除失败");
		}

		return Result.success();
	}
}
