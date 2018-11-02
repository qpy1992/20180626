package com.jeecg.receive.controller;
import com.jeecg.receive.entity.ReceiveEntity;
import com.jeecg.receive.service.ReceiveServiceI;
import com.jeecg.receive.page.ReceivePage;
import com.jeecg.zhangdan1.entity.Zhangdan1Entity;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
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
 * @Description: 应收账单
 * @author onlineGenerator
 * @date 2018-08-17 13:20:52
 * @version V1.0   
 *
 */
@Api(value="Receive",description="应收账单",tags="receiveController")
@Controller
@RequestMapping("/receiveController")
public class ReceiveController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ReceiveController.class);

	@Autowired
	private ReceiveServiceI receiveService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private CgReportServiceI cgReportService;

	/**
	 * 应收账单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/receive/receiveList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param receive
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ReceiveEntity receive,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ReceiveEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, receive);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.receiveService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除应收账单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ReceiveEntity receive, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		receive = systemService.getEntity(ReceiveEntity.class, receive.getId());
		String message = "应收账单删除成功";
		try{
			receiveService.delMain(receive);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应收账单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除应收账单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "应收账单删除成功";
		try{
			for(String id:ids.split(",")){
				ReceiveEntity receive = systemService.getEntity(ReceiveEntity.class,
				id
				);
				receiveService.delMain(receive);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "应收账单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加应收账单
	 * 
	 * @param receive
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ReceiveEntity receive,ReceivePage receivePage, HttpServletRequest request) {
		List<Zhangdan1Entity> zhangdan1List =  receivePage.getZhangdan1List();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			receive.setFbillno(systemService.getFbillno(67));
			receiveService.addMain(receive, zhangdan1List);
			for(Zhangdan1Entity zhangdan1:zhangdan1List){
				systemService.executeSql("update z_charge set fdz='Y' where id ='"+zhangdan1.getCostid()+"'");
			}
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应收账单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新应收账单
	 * 
	 * @param receive
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ReceiveEntity receive,ReceivePage receivePage, HttpServletRequest request) {
		List<Zhangdan1Entity> zhangdan1List =  receivePage.getZhangdan1List();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			receiveService.updateMain(receive, zhangdan1List);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新应收账单失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 应收账单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ReceiveEntity receive, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(receive.getId())) {
			receive = receiveService.getEntity(ReceiveEntity.class, receive.getId());
			req.setAttribute("receivePage", receive);
		}
		return new ModelAndView("com/jeecg/receive/receive-add");
	}
	
	/**
	 * 应收账单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ReceiveEntity receive, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(receive.getId())) {
			receive = receiveService.getEntity(ReceiveEntity.class, receive.getId());
			req.setAttribute("receivePage", receive);
		}
		return new ModelAndView("com/jeecg/receive/receive-update");
	}
	
	
	/**
	 * 加载明细列表[应收账单明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zhangdan1List")
	public ModelAndView zhangdan1List(ReceiveEntity receive, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = receive.getId();
		//===================================================================================
		//查询-应收账单明细
	    String hql0 = "from Zhangdan1Entity where 1 = 1 AND fID = ? ";
	    try{
	    	List<Zhangdan1Entity> zhangdan1EntityList = systemService.findHql(hql0,id0);
			req.setAttribute("zhangdan1List", zhangdan1EntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/zhangdan1/zhangdan1List");
	}

	@RequestMapping(params = "receive")
	@ResponseBody
	public void receive(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) throws IOException {
		String ids=request.getParameter("ids");     //接收传入的id值
		String[] strArray = null;
		strArray = ids.split(",");
		String idarray = "(";
		for(int i=0;i<strArray.length;i++){
			idarray = idarray+"'"+strArray[i]+"',";
		}
		idarray = idarray.substring(0,idarray.length()-1)+")";
		logger.info(idarray);
		Map queryparams =  new LinkedHashMap<String,Object>();
		String sql ="select a.id,a.fcost,a.fcostname,a.funit,a.fqty,fprice,a.famount,a.fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,a.fcheck,a.fshoufu,a.fsettle,a.fsettlename,a.fdd,a.fbibie,b.fblno,b.fshipname,b.fvoyageno,b.foperate_time operatetime,b.fbillno fweituo,b.fnote,b.fentrust_unit entrust,c.fboxtype,c.fzhdp,c.fzhdpdz,c.fboxno,d.fbillno paiche from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where 1=1 and a.id in "+idarray;
		String sql1 = "select a.id,a.fcost,a.fcostname,a.funit,a.fqty,a.fprice,a.famount,a.fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,a.fcheck,a.fshoufu,a.fsettle,a.fsettlename,a.fdd,a.fbibie,d.fblno,d.fshipname,d.fvoyageno,d.foperate_time operatetime,d.fbillno fweituo,d.fnote,d.fentrust_unit entrust,c.fboxtype,c.fzhdp,c.fzhdpdz,c.fboxno,b.fbillno paiche from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where 1=1 and a.id in"+idarray;
		List<Map<String, Object>> result= cgReportService.queryByCgReportSql(sql, queryparams, dataGrid.getPage(), dataGrid.getRows());
		List<Map<String, Object>> result1= cgReportService.queryByCgReportSql(sql1, queryparams, dataGrid.getPage(), dataGrid.getRows());
		result.addAll(result1);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"charge"});
		net.sf.json.JSONArray jsa = net.sf.json.JSONArray.fromObject(result,jsonConfig);
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
    public String exportXls(ReceiveEntity receive,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(ReceiveEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, receive);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<ReceiveEntity> list=this.receiveService.getListByCriteriaQuery(cq, false);
    	List<ReceivePage> pageList=new ArrayList<ReceivePage>();
        if(list!=null&&list.size()>0){
        	for(ReceiveEntity entity:list){
        		try{
        		ReceivePage page=new ReceivePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from Zhangdan1Entity where 1 = 1 AND fID = ? ";
        	        List<Zhangdan1Entity> zhangdan1EntityList = systemService.findHql(hql0,id0);
            		page.setZhangdan1List(zhangdan1EntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"应收账单");
        map.put(NormalExcelConstants.CLASS,ReceivePage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("应收账单列表", "导出人:Jeecg",
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
				List<ReceivePage> list =  ExcelImportUtil.importExcel(file.getInputStream(), ReceivePage.class, params);
				ReceiveEntity entity1=null;
				for (ReceivePage page : list) {
					entity1=new ReceiveEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            receiveService.addMain(entity1, page.getZhangdan1List());
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
		map.put(NormalExcelConstants.FILE_NAME,"应收账单");
		map.put(NormalExcelConstants.CLASS,ReceivePage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("应收账单列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "receiveController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="应收账单列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ReceivePage>> list() {
		List<ReceiveEntity> list= receiveService.getList(ReceiveEntity.class);
    	List<ReceivePage> pageList=new ArrayList<ReceivePage>();
        if(list!=null&&list.size()>0){
        	for(ReceiveEntity entity:list){
        		try{
        			ReceivePage page=new ReceivePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from Zhangdan1Entity where 1 = 1 AND fID = ? ";
	    			List<Zhangdan1Entity> zhangdan1OldList = this.receiveService.findHql(hql0,id0);
            		page.setZhangdan1List(zhangdan1OldList);
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
	@ApiOperation(value="根据ID获取应收账单信息",notes="根据ID获取应收账单信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ReceiveEntity task = receiveService.get(ReceiveEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取应收账单信息为空");
		}
		ReceivePage page = new ReceivePage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from Zhangdan1Entity where 1 = 1 AND fID = ? ";
			List<Zhangdan1Entity> zhangdan1OldList = this.receiveService.findHql(hql0,id0);
    		page.setZhangdan1List(zhangdan1OldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建应收账单")
	public ResponseMessage<?> create(@ApiParam(name="应收账单对象")@RequestBody ReceivePage receivePage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ReceivePage>> failures = validator.validate(receivePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<Zhangdan1Entity> zhangdan1List =  receivePage.getZhangdan1List();
		
		ReceiveEntity receive = new ReceiveEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(receivePage,receive);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存应收账单失败");
        }
		receiveService.addMain(receive, zhangdan1List);

		return Result.success(receive);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新应收账单",notes="更新应收账单")
	public ResponseMessage<?> update(@RequestBody ReceivePage receivePage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ReceivePage>> failures = validator.validate(receivePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<Zhangdan1Entity> zhangdan1List =  receivePage.getZhangdan1List();
		
		ReceiveEntity receive = new ReceiveEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(receivePage,receive);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("应收账单更新失败");
        }
		receiveService.updateMain(receive, zhangdan1List);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除应收账单")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			ReceiveEntity receive = receiveService.get(ReceiveEntity.class, id);
			receiveService.delMain(receive);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("应收账单删除失败");
		}

		return Result.success();
	}
}
