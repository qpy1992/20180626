package com.jeecg.doorpoint.controller;
import com.jeecg.doorpoint.entity.DoorPointEntity;
import com.jeecg.doorpoint.service.DoorPointServiceI;
import com.jeecg.doorpoint.page.DoorPointPage;
import com.jeecg.dprate.entity.DpRateEntity;
import com.jeecg.dpcontact.entity.DpContactEntity;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.*;
import org.jeecgframework.jwt.util.ChineseInital;
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
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
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
 * @Description: 门点
 * @author onlineGenerator
 * @date 2018-08-30 16:16:28
 * @version V1.0   
 *
 */
@Api(value="DoorPoint",description="门点",tags="doorPointController")
@Controller
@RequestMapping("/doorPointController")
public class DoorPointController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DoorPointController.class);

	@Autowired
	private DoorPointServiceI doorPointService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 门点列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/doorpoint/doorPointList");
	}

    @RequestMapping(params = "goContact")
    public ModelAndView goContact(HttpServletRequest request) {
	    String fid = request.getParameter("fid");
	    request.setAttribute("fid",fid);
        return new ModelAndView("com/jeecg/doorpoint/dpContactList");
    }


    /**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param doorPoint
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(DoorPointEntity doorPoint,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DoorPointEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, doorPoint);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.doorPointService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

    @RequestMapping(params = "datagrid1")
    public void datagrid1(DpContactEntity dpContact,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        String fid = request.getParameter("fid");
	    CriteriaQuery cq = new CriteriaQuery(DpContactEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dpContact);
        try{
            //自定义追加查询条件
            cq.eq("fid",fid);
        }catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.doorPointService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

	/**
	 * 删除门点
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DoorPointEntity doorPoint, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		doorPoint = systemService.getEntity(DoorPointEntity.class, doorPoint.getId());
		String message = "门点删除成功";
		try{
			doorPointService.delMain(doorPoint);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "门点删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除门点
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "门点删除成功";
		try{
			for(String id:ids.split(",")){
				DoorPointEntity doorPoint = systemService.getEntity(DoorPointEntity.class,
				id
				);
				doorPointService.delMain(doorPoint);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "门点删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加门点
	 * 
	 * @param doorPoint
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DoorPointEntity doorPoint,DoorPointPage doorPointPage, HttpServletRequest request) {
		List<DpRateEntity> dpRateList =  doorPointPage.getDpRateList();
		List<DpContactEntity> dpContactList =  doorPointPage.getDpContactList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
		    doorPoint.setFdpCode(PinyinUtil.getPinYinHeadChar(doorPoint.getFdpName()));
		    doorPoint.setFvoid("N");
		    doorPoint.setFaddress(doorPoint.getProvince()+doorPoint.getCity()+doorPoint.getArea()+doorPoint.getDizhi());
			doorPointService.addMain(doorPoint, dpRateList,dpContactList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "门点添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新门点
	 * 
	 * @param doorPoint
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DoorPointEntity doorPoint,DoorPointPage doorPointPage, HttpServletRequest request) {
		List<DpRateEntity> dpRateList =  doorPointPage.getDpRateList();
		List<DpContactEntity> dpContactList =  doorPointPage.getDpContactList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			doorPoint.setFaddress(doorPoint.getProvince()+doorPoint.getCity()+doorPoint.getArea()+doorPoint.getDizhi());
			doorPointService.updateMain(doorPoint, dpRateList,dpContactList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新门点失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 门点新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DoorPointEntity doorPoint, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(doorPoint.getId())) {
			doorPoint = doorPointService.getEntity(DoorPointEntity.class, doorPoint.getId());
			req.setAttribute("doorPointPage", doorPoint);
		}
		return new ModelAndView("com/jeecg/doorpoint/doorPoint-add");
	}
	
	/**
	 * 门点编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DoorPointEntity doorPoint, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(doorPoint.getId())) {
			doorPoint = doorPointService.getEntity(DoorPointEntity.class, doorPoint.getId());
			req.setAttribute("doorPointPage", doorPoint);
		}
		return new ModelAndView("com/jeecg/doorpoint/doorPoint-update");
	}

    /**
     * 删除门点联系人
     *
     * @return
     */
    @RequestMapping(params = "doDel1")
    @ResponseBody
    public AjaxJson doDel1(DpContactEntity dpContact, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        dpContact = systemService.getEntity(DpContactEntity.class, dpContact.getId());
        message = "门点联系人删除成功";
        try{
            systemService.delete(dpContact);
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        }catch(Exception e){
            e.printStackTrace();
            message = "门点联系人删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除门点联系人
     *
     * @return
     */
    @RequestMapping(params = "doBatchDel1")
    @ResponseBody
    public AjaxJson doBatchDel1(String ids,HttpServletRequest request){
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "门点联系人删除成功";
        try{
            for(String id:ids.split(",")){
                DpContactEntity dpContact = systemService.getEntity(DpContactEntity.class,
                        id
                );
                systemService.delete(dpContact);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        }catch(Exception e){
            e.printStackTrace();
            message = "门点联系人删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加门点联系人
     *
     * @param dpContact
     * @return
     */
    @RequestMapping(params = "doAdd1")
    @ResponseBody
    public AjaxJson doAdd1(DpContactEntity dpContact, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "门点联系人添加成功";
        try{
            systemService.save(dpContact);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        }catch(Exception e){
            e.printStackTrace();
            message = "门点联系人添加失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新门点联系人
     *
     * @param dpContact
     * @return
     */
    @RequestMapping(params = "doUpdate1")
    @ResponseBody
    public AjaxJson doUpdate1(DpContactEntity dpContact, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "门点联系人更新成功";
        DpContactEntity t = systemService.get(DpContactEntity.class, dpContact.getId());
        try {
            MyBeanUtils.copyBeanNotNull2Bean(dpContact, t);
            systemService.saveOrUpdate(t);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "门点联系人更新失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 门点联系人新增页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goAdd1")
    public ModelAndView goAdd1(DpContactEntity dpContact, HttpServletRequest req) {
        String fid = req.getParameter("fid");
        req.setAttribute("fid",fid);
        if (StringUtil.isNotEmpty(dpContact.getId())) {
            dpContact = systemService.getEntity(DpContactEntity.class, dpContact.getId());
            req.setAttribute("dpContactPage", dpContact);
        }
        return new ModelAndView("com/jeecg/doorpoint/dpContact-add");
    }
    /**
     * 门点联系人编辑页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goUpdate1")
    public ModelAndView goUpdate1(DpContactEntity dpContact, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(dpContact.getId())) {
            dpContact = systemService.getEntity(DpContactEntity.class, dpContact.getId());
            req.setAttribute("dpContactPage", dpContact);
        }
        return new ModelAndView("com/jeecg/doorpoint/dpContact-update");
    }
	
	/**
	 * 加载明细列表[门点费率]
	 * 
	 * @return
	 */
	@RequestMapping(params = "dpRateList")
	public ModelAndView dpRateList(DoorPointEntity doorPoint, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = doorPoint.getId();
		//===================================================================================
		//查询-门点费率
	    String hql0 = "from DpRateEntity where 1 = 1 AND fID = ? ";
	    try{
	    	List<DpRateEntity> dpRateEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("dpRateList", dpRateEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/dprate/dpRateList");
	}
	/**
	 * 加载明细列表[门点联系人]
	 * 
	 * @return
	 */
	@RequestMapping(params = "dpContactList")
	public ModelAndView dpContactList(DoorPointEntity doorPoint, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = doorPoint.getId();
		//===================================================================================
		//查询-门点联系人
	    String hql1 = "from DpContactEntity where 1 = 1 AND fID = ? ";
	    try{
	    	List<DpContactEntity> dpContactEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("dpContactList", dpContactEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/dpcontact/dpContactList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(DoorPointEntity doorPoint,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(DoorPointEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, doorPoint);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<DoorPointEntity> list=this.doorPointService.getListByCriteriaQuery(cq, false);
    	List<DoorPointPage> pageList=new ArrayList<DoorPointPage>();
        if(list!=null&&list.size()>0){
        	for(DoorPointEntity entity:list){
        		try{
        		DoorPointPage page=new DoorPointPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from DpRateEntity where 1 = 1 AND fID = ? ";
        	        List<DpRateEntity> dpRateEntityList = systemService.findHql(hql0,id0);
            		page.setDpRateList(dpRateEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from DpContactEntity where 1 = 1 AND fID = ? ";
        	        List<DpContactEntity> dpContactEntityList = systemService.findHql(hql1,id1);
            		page.setDpContactList(dpContactEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"门点");
        map.put(NormalExcelConstants.CLASS,DoorPointPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("门点列表", "导出人:Jeecg",
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
				List<DoorPointPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), DoorPointPage.class, params);
				DoorPointEntity entity1=null;
				for (DoorPointPage page : list) {
					entity1=new DoorPointEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            doorPointService.addMain(entity1, page.getDpRateList(),page.getDpContactList());
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
		map.put(NormalExcelConstants.FILE_NAME,"门点");
		map.put(NormalExcelConstants.CLASS,DoorPointPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("门点列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "doorPointController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="门点列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<DoorPointPage>> list() {
		List<DoorPointEntity> list= doorPointService.getList(DoorPointEntity.class);
    	List<DoorPointPage> pageList=new ArrayList<DoorPointPage>();
        if(list!=null&&list.size()>0){
        	for(DoorPointEntity entity:list){
        		try{
        			DoorPointPage page=new DoorPointPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
				     String hql0 = "from DpRateEntity where 1 = 1 AND fID = ? ";
	    			List<DpRateEntity> dpRateOldList = this.doorPointService.findHql(hql0,id0);
            		page.setDpRateList(dpRateOldList);
				     String hql1 = "from DpContactEntity where 1 = 1 AND fID = ? ";
	    			List<DpContactEntity> dpContactOldList = this.doorPointService.findHql(hql1,id1);
            		page.setDpContactList(dpContactOldList);
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
	@ApiOperation(value="根据ID获取门点信息",notes="根据ID获取门点信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		DoorPointEntity task = doorPointService.get(DoorPointEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取门点信息为空");
		}
		DoorPointPage page = new DoorPointPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
		    String hql0 = "from DpRateEntity where 1 = 1 AND fID = ? ";
			List<DpRateEntity> dpRateOldList = this.doorPointService.findHql(hql0,id0);
    		page.setDpRateList(dpRateOldList);
		    String hql1 = "from DpContactEntity where 1 = 1 AND fID = ? ";
			List<DpContactEntity> dpContactOldList = this.doorPointService.findHql(hql1,id1);
    		page.setDpContactList(dpContactOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建门点")
	public ResponseMessage<?> create(@ApiParam(name="门点对象")@RequestBody DoorPointPage doorPointPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DoorPointPage>> failures = validator.validate(doorPointPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<DpRateEntity> dpRateList =  doorPointPage.getDpRateList();
		List<DpContactEntity> dpContactList =  doorPointPage.getDpContactList();
		
		DoorPointEntity doorPoint = new DoorPointEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(doorPointPage,doorPoint);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存门点失败");
        }
		doorPointService.addMain(doorPoint, dpRateList,dpContactList);

		return Result.success(doorPoint);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新门点",notes="更新门点")
	public ResponseMessage<?> update(@RequestBody DoorPointPage doorPointPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DoorPointPage>> failures = validator.validate(doorPointPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<DpRateEntity> dpRateList =  doorPointPage.getDpRateList();
		List<DpContactEntity> dpContactList =  doorPointPage.getDpContactList();
		
		DoorPointEntity doorPoint = new DoorPointEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(doorPointPage,doorPoint);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("门点更新失败");
        }
		doorPointService.updateMain(doorPoint, dpRateList,dpContactList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除门点")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			DoorPointEntity doorPoint = doorPointService.get(DoorPointEntity.class, id);
			doorPointService.delMain(doorPoint);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("门点删除失败");
		}

		return Result.success();
	}
}
