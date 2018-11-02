package com.jeecg.costcombination.controller;
import com.jeecg.costcombination.entity.CostCombinationEntity;
import com.jeecg.costcombination.service.CostCombinationServiceI;
import com.jeecg.costcombination.page.CostCombinationPage;
import com.jeecg.costdetail.entity.CostdetailEntity;
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
 * @Description: 费用组合
 * @author onlineGenerator
 * @date 2018-10-09 14:33:19
 * @version V1.0   
 *
 */
@Api(value="CostCombination",description="费用组合",tags="costCombinationController")
@Controller
@RequestMapping("/costCombinationController")
public class CostCombinationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CostCombinationController.class);

	@Autowired
	private CostCombinationServiceI costCombinationService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 费用组合列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String fid = request.getParameter("fid");
		request.setAttribute("fid",fid);
		return new ModelAndView("com/jeecg/costcombination/costCombinationList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param costCombination
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(CostCombinationEntity costCombination,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String fid = request.getParameter("fid");
		CriteriaQuery cq = new CriteriaQuery(CostCombinationEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, costCombination);
		try{
		//自定义追加查询条件
			cq.eq("fid",fid);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.costCombinationService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除费用组合
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CostCombinationEntity costCombination, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		costCombination = systemService.getEntity(CostCombinationEntity.class, costCombination.getId());
		String message = "费用组合删除成功";
		try{
			costCombinationService.delMain(costCombination);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "费用组合删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除费用组合
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "费用组合删除成功";
		try{
			for(String id:ids.split(",")){
				CostCombinationEntity costCombination = systemService.getEntity(CostCombinationEntity.class,
				id
				);
				costCombinationService.delMain(costCombination);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "费用组合删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加费用组合
	 * 
	 * @param costCombination
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CostCombinationEntity costCombination,CostCombinationPage costCombinationPage, HttpServletRequest request) {
		List<CostdetailEntity> costdetailList =  costCombinationPage.getCostdetailList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			costCombinationService.addMain(costCombination, costdetailList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "费用组合添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新费用组合
	 * 
	 * @param costCombination
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CostCombinationEntity costCombination,CostCombinationPage costCombinationPage, HttpServletRequest request) {
		List<CostdetailEntity> costdetailList =  costCombinationPage.getCostdetailList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			costCombinationService.updateMain(costCombination, costdetailList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新费用组合失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 费用组合新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CostCombinationEntity costCombination, HttpServletRequest req) {
		String fid = req.getParameter("fid");
		req.setAttribute("fid",fid);
		if (StringUtil.isNotEmpty(costCombination.getId())) {
			costCombination = costCombinationService.getEntity(CostCombinationEntity.class, costCombination.getId());
			req.setAttribute("costCombinationPage", costCombination);
		}
		return new ModelAndView("com/jeecg/costcombination/costCombination-add");
	}
	
	/**
	 * 费用组合编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CostCombinationEntity costCombination, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(costCombination.getId())) {
			costCombination = costCombinationService.getEntity(CostCombinationEntity.class, costCombination.getId());
			req.setAttribute("costCombinationPage", costCombination);
		}
		return new ModelAndView("com/jeecg/costcombination/costCombination-update");
	}
	
	
	/**
	 * 加载明细列表[费用详情]
	 * 
	 * @return
	 */
	@RequestMapping(params = "costdetailList")
	public ModelAndView costdetailList(CostCombinationEntity costCombination, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = costCombination.getId();
		//===================================================================================
		//查询-费用详情
	    String hql0 = "from CostdetailEntity where 1 = 1 AND fID = ? ";
	    try{
	    	List<CostdetailEntity> costdetailEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("costdetailList", costdetailEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/costdetail/costdetailList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(CostCombinationEntity costCombination,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(CostCombinationEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, costCombination);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<CostCombinationEntity> list=this.costCombinationService.getListByCriteriaQuery(cq, false);
    	List<CostCombinationPage> pageList=new ArrayList<CostCombinationPage>();
        if(list!=null&&list.size()>0){
        	for(CostCombinationEntity entity:list){
        		try{
        		CostCombinationPage page=new CostCombinationPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from CostdetailEntity where 1 = 1 AND fID = ? ";
        	        List<CostdetailEntity> costdetailEntityList = systemService.findHql(hql0,id0);
            		page.setCostdetailList(costdetailEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"费用组合");
        map.put(NormalExcelConstants.CLASS,CostCombinationPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("费用组合列表", "导出人:Jeecg",
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
				List<CostCombinationPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), CostCombinationPage.class, params);
				CostCombinationEntity entity1=null;
				for (CostCombinationPage page : list) {
					entity1=new CostCombinationEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            costCombinationService.addMain(entity1, page.getCostdetailList());
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
		map.put(NormalExcelConstants.FILE_NAME,"费用组合");
		map.put(NormalExcelConstants.CLASS,CostCombinationPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("费用组合列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "costCombinationController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="费用组合列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CostCombinationPage>> list() {
		List<CostCombinationEntity> list= costCombinationService.getList(CostCombinationEntity.class);
    	List<CostCombinationPage> pageList=new ArrayList<CostCombinationPage>();
        if(list!=null&&list.size()>0){
        	for(CostCombinationEntity entity:list){
        		try{
        			CostCombinationPage page=new CostCombinationPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from CostdetailEntity where 1 = 1 AND fID = ? ";
	    			List<CostdetailEntity> costdetailOldList = this.costCombinationService.findHql(hql0,id0);
            		page.setCostdetailList(costdetailOldList);
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
	@ApiOperation(value="根据ID获取费用组合信息",notes="根据ID获取费用组合信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CostCombinationEntity task = costCombinationService.get(CostCombinationEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取费用组合信息为空");
		}
		CostCombinationPage page = new CostCombinationPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from CostdetailEntity where 1 = 1 AND fID = ? ";
			List<CostdetailEntity> costdetailOldList = this.costCombinationService.findHql(hql0,id0);
    		page.setCostdetailList(costdetailOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建费用组合")
	public ResponseMessage<?> create(@ApiParam(name="费用组合对象")@RequestBody CostCombinationPage costCombinationPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CostCombinationPage>> failures = validator.validate(costCombinationPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CostdetailEntity> costdetailList =  costCombinationPage.getCostdetailList();
		
		CostCombinationEntity costCombination = new CostCombinationEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(costCombinationPage,costCombination);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存费用组合失败");
        }
		costCombinationService.addMain(costCombination, costdetailList);

		return Result.success(costCombination);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新费用组合",notes="更新费用组合")
	public ResponseMessage<?> update(@RequestBody CostCombinationPage costCombinationPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CostCombinationPage>> failures = validator.validate(costCombinationPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CostdetailEntity> costdetailList =  costCombinationPage.getCostdetailList();
		
		CostCombinationEntity costCombination = new CostCombinationEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(costCombinationPage,costCombination);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("费用组合更新失败");
        }
		costCombinationService.updateMain(costCombination, costdetailList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除费用组合")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			CostCombinationEntity costCombination = costCombinationService.get(CostCombinationEntity.class, id);
			costCombinationService.delMain(costCombination);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("费用组合删除失败");
		}

		return Result.success();
	}
}
