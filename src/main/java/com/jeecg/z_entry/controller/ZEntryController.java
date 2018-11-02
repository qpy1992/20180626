package com.jeecg.z_entry.controller;
import com.jeecg.z_entry.entity.ZEntryEntity;
import com.jeecg.z_entry.service.ZEntryServiceI;
import com.jeecg.z_entry.page.ZEntryPage;
import com.jeecg.z_entrydetail.entity.ZEntrydetailEntity;
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
 * @Description: 入库
 * @author onlineGenerator
 * @date 2018-08-08 13:44:54
 * @version V1.0   
 *
 */
@Api(value="ZEntry",description="入库",tags="zEntryController")
@Controller
@RequestMapping("/zEntryController")
public class ZEntryController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZEntryController.class);

	@Autowired
	private ZEntryServiceI zEntryService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 入库列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/z_entry/zEntryList");
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
	public void datagrid(ZEntryEntity zEntry,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZEntryEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zEntry);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zEntryService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除入库
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZEntryEntity zEntry, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		zEntry = systemService.getEntity(ZEntryEntity.class, zEntry.getId());
		String message = "入库删除成功";
		try{
			zEntryService.delMain(zEntry);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "入库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除入库
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "入库删除成功";
		try{
			for(String id:ids.split(",")){
				ZEntryEntity zEntry = systemService.getEntity(ZEntryEntity.class,
				id
				);
				zEntryService.delMain(zEntry);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "入库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加入库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZEntryEntity zEntry,ZEntryPage zEntryPage, HttpServletRequest request) {
		List<ZEntrydetailEntity> zEntrydetailList =  zEntryPage.getZEntrydetailList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			zEntryService.addMain(zEntry, zEntrydetailList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "入库添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新入库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZEntryEntity zEntry,ZEntryPage zEntryPage, HttpServletRequest request) {
		List<ZEntrydetailEntity> zEntrydetailList =  zEntryPage.getZEntrydetailList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			zEntryService.updateMain(zEntry, zEntrydetailList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新入库失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 入库新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZEntryEntity zEntry, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zEntry.getId())) {
			zEntry = zEntryService.getEntity(ZEntryEntity.class, zEntry.getId());
			req.setAttribute("zEntryPage", zEntry);
		}
		return new ModelAndView("com/jeecg/z_entry/zEntry-add");
	}
	
	/**
	 * 入库编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZEntryEntity zEntry, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zEntry.getId())) {
			zEntry = zEntryService.getEntity(ZEntryEntity.class, zEntry.getId());
			req.setAttribute("zEntryPage", zEntry);
		}
		return new ModelAndView("com/jeecg/z_entry/zEntry-update");
	}
	
	
	/**
	 * 加载明细列表[入库明细表]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zEntrydetailList")
	public ModelAndView zEntrydetailList(ZEntryEntity zEntry, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = zEntry.getId();
		//===================================================================================
		//查询-入库明细表
	    String hql0 = "from ZEntrydetailEntity where 1 = 1 AND z_ID = ? ";
	    try{
	    	List<ZEntrydetailEntity> zEntrydetailEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("zEntrydetailList", zEntrydetailEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/z_entrydetail/zEntrydetailList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(ZEntryEntity zEntry,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(ZEntryEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zEntry);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<ZEntryEntity> list=this.zEntryService.getListByCriteriaQuery(cq, false);
    	List<ZEntryPage> pageList=new ArrayList<ZEntryPage>();
        if(list!=null&&list.size()>0){
        	for(ZEntryEntity entity:list){
        		try{
        		ZEntryPage page=new ZEntryPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from ZEntrydetailEntity where 1 = 1 AND z_ID = ? ";
        	        List<ZEntrydetailEntity> zEntrydetailEntityList = systemService.findHql(hql0,id0);
            		page.setZEntrydetailList(zEntrydetailEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"入库");
        map.put(NormalExcelConstants.CLASS,ZEntryPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("入库列表", "导出人:Jeecg",
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
				List<ZEntryPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), ZEntryPage.class, params);
				ZEntryEntity entity1=null;
				for (ZEntryPage page : list) {
					entity1=new ZEntryEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            zEntryService.addMain(entity1, page.getZEntrydetailList());
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
		map.put(NormalExcelConstants.FILE_NAME,"入库");
		map.put(NormalExcelConstants.CLASS,ZEntryPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("入库列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "zEntryController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="入库列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ZEntryPage>> list() {
		List<ZEntryEntity> list= zEntryService.getList(ZEntryEntity.class);
    	List<ZEntryPage> pageList=new ArrayList<ZEntryPage>();
        if(list!=null&&list.size()>0){
        	for(ZEntryEntity entity:list){
        		try{
        			ZEntryPage page=new ZEntryPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from ZEntrydetailEntity where 1 = 1 AND z_ID = ? ";
	    			List<ZEntrydetailEntity> zEntrydetailOldList = this.zEntryService.findHql(hql0,id0);
            		page.setZEntrydetailList(zEntrydetailOldList);
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
	@ApiOperation(value="根据ID获取入库信息",notes="根据ID获取入库信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ZEntryEntity task = zEntryService.get(ZEntryEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取入库信息为空");
		}
		ZEntryPage page = new ZEntryPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from ZEntrydetailEntity where 1 = 1 AND z_ID = ? ";
			List<ZEntrydetailEntity> zEntrydetailOldList = this.zEntryService.findHql(hql0,id0);
    		page.setZEntrydetailList(zEntrydetailOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建入库")
	public ResponseMessage<?> create(@ApiParam(name="入库对象")@RequestBody ZEntryPage zEntryPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZEntryPage>> failures = validator.validate(zEntryPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ZEntrydetailEntity> zEntrydetailList =  zEntryPage.getZEntrydetailList();
		
		ZEntryEntity zEntry = new ZEntryEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(zEntryPage,zEntry);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存入库失败");
        }
		zEntryService.addMain(zEntry, zEntrydetailList);

		return Result.success(zEntry);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新入库",notes="更新入库")
	public ResponseMessage<?> update(@RequestBody ZEntryPage zEntryPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ZEntryPage>> failures = validator.validate(zEntryPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ZEntrydetailEntity> zEntrydetailList =  zEntryPage.getZEntrydetailList();
		
		ZEntryEntity zEntry = new ZEntryEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(zEntryPage,zEntry);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("入库更新失败");
        }
		zEntryService.updateMain(zEntry, zEntrydetailList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除入库")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			ZEntryEntity zEntry = zEntryService.get(ZEntryEntity.class, id);
			zEntryService.delMain(zEntry);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("入库删除失败");
		}

		return Result.success();
	}
}
