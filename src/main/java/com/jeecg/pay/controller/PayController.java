package com.jeecg.pay.controller;
import com.jeecg.pay.entity.PayEntity;
import com.jeecg.pay.service.PayServiceI;
import com.jeecg.pay.page.PayPage;
import com.jeecg.zhangdan.entity.ZhangdanEntity;

import java.util.*;
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
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller
 * @Description: 应付账单
 * @author onlineGenerator
 * @date 2018-08-17 13:19:05
 * @version V1.0   
 *
 */
@Api(value="Pay",description="应付账单",tags="payController")
@Controller
@RequestMapping("/payController")
public class PayController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PayController.class);

	@Autowired
	private PayServiceI payService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private CgReportServiceI cgReportService;

	/**
	 * 应付账单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/pay/paylist");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param pay
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(PayEntity pay,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PayEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, pay);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.payService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除应付账单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(PayEntity pay, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		pay = systemService.getEntity(PayEntity.class, pay.getId());
		String message = "应付账单删除成功";
		try{
			payService.delMain(pay);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应付账单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除应付账单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "应付账单删除成功";
		try{
			for(String id:ids.split(",")){
				PayEntity pay = systemService.getEntity(PayEntity.class,
				id
				);
				payService.delMain(pay);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "应付账单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加应付账单
	 * 
	 * @param pay
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(PayEntity pay,PayPage payPage, HttpServletRequest request) {
		List<ZhangdanEntity> zhangdanList =  payPage.getZhangdanList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			pay.setFbillno(systemService.getFbillno(58));
			payService.addMain(pay, zhangdanList);
			for(ZhangdanEntity zhangdan:zhangdanList){
				systemService.executeSql("update z_charge set fdz='Y' where id ='"+zhangdan.getCostid()+"'");
			}
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应付账单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新应付账单
	 * 
	 * @param pay
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(PayEntity pay,PayPage payPage, HttpServletRequest request) {
		List<ZhangdanEntity> zhangdanList =  payPage.getZhangdanList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			payService.updateMain(pay, zhangdanList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新应付账单失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 应付账单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(PayEntity pay, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(pay.getId())) {
			pay = payService.getEntity(PayEntity.class, pay.getId());
			req.setAttribute("payPage", pay);
		}
		return new ModelAndView("com/jeecg/pay/pay-add");
	}
	
	/**
	 * 应付账单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(PayEntity pay, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(pay.getId())) {
			pay = payService.getEntity(PayEntity.class, pay.getId());
			req.setAttribute("payPage", pay);
		}
		return new ModelAndView("com/jeecg/pay/pay-update");
	}
	
	
	/**
	 * 加载明细列表[应付账单明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zhangdanList")
	public ModelAndView zhangdanList(PayEntity pay, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = pay.getId();
		//===================================================================================
		//查询-应付账单明细
	    String hql0 = "from ZhangdanEntity where 1 = 1 AND fID = ? ";
	    try{
	    	List<ZhangdanEntity> zhangdanEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("zhangdanList", zhangdanEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/zhangdan/zhangdanList");
	}

	@RequestMapping(params = "pay")
	@ResponseBody
	public void pay(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) throws IOException {
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
		String sql ="select a.id,a.fcost,a.fcostname,a.funit,a.fqty,fprice,a.famount,a.fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,(case a.fcheck when 0 then '未审' when 1 then '已审' end) fcheck,a.fshoufu,a.fsettle,a.fsettlename,a.fdd,a.fbibie,b.fblno,b.fshipname,b.fvoyageno,convert(varchar(100),b.foperate_time,120) operatetime,b.fbillno fweituo,b.fnote,b.fentrust_unit entrust,c.fboxtype,c.fzhdp,c.fzhdpdz,c.fboxno,d.fbillno paiche from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where 1=1 and a.id in "+idarray;
		String sql1 = "select a.id,a.fcost,a.fcostname,a.funit,a.fqty,a.fprice,a.famount,a.fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,(case a.fcheck when 0 then '未审' when 1 then '已审' end) fcheck,a.fshoufu,a.fsettle,a.fsettlename,a.fdd,a.fbibie,d.fblno,d.fshipname,d.fvoyageno,convert(varchar(100),d.foperate_time,120) operatetime,d.fbillno fweituo,d.fnote,d.fentrust_unit entrust,c.fboxtype,c.fzhdp,c.fzhdpdz,c.fboxno,b.fbillno paiche from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where 1=1 and a.id in"+idarray;
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
    public String exportXls(PayEntity pay,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(PayEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, pay);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<PayEntity> list=this.payService.getListByCriteriaQuery(cq, false);
    	List<PayPage> pageList=new ArrayList<PayPage>();
        if(list!=null&&list.size()>0){
        	for(PayEntity entity:list){
        		try{
        		PayPage page=new PayPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from ZhangdanEntity where 1 = 1 AND fID = ? ";
        	        List<ZhangdanEntity> zhangdanEntityList = systemService.findHql(hql0,id0);
            		page.setZhangdanList(zhangdanEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"应付账单");
        map.put(NormalExcelConstants.CLASS,PayPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("应付账单列表", "导出人:Jeecg",
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
				List<PayPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), PayPage.class, params);
				PayEntity entity1=null;
				for (PayPage page : list) {
					entity1=new PayEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            payService.addMain(entity1, page.getZhangdanList());
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
		map.put(NormalExcelConstants.FILE_NAME,"应付账单");
		map.put(NormalExcelConstants.CLASS,PayPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("应付账单列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "payController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="应付账单列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<PayPage>> list() {
		List<PayEntity> list= payService.getList(PayEntity.class);
    	List<PayPage> pageList=new ArrayList<PayPage>();
        if(list!=null&&list.size()>0){
        	for(PayEntity entity:list){
        		try{
        			PayPage page=new PayPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from ZhangdanEntity where 1 = 1 AND fID = ? ";
	    			List<ZhangdanEntity> zhangdanOldList = this.payService.findHql(hql0,id0);
            		page.setZhangdanList(zhangdanOldList);
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
	@ApiOperation(value="根据ID获取应付账单信息",notes="根据ID获取应付账单信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		PayEntity task = payService.get(PayEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取应付账单信息为空");
		}
		PayPage page = new PayPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from ZhangdanEntity where 1 = 1 AND fID = ? ";
			List<ZhangdanEntity> zhangdanOldList = this.payService.findHql(hql0,id0);
    		page.setZhangdanList(zhangdanOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建应付账单")
	public ResponseMessage<?> create(@ApiParam(name="应付账单对象")@RequestBody PayPage payPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<PayPage>> failures = validator.validate(payPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ZhangdanEntity> zhangdanList =  payPage.getZhangdanList();
		
		PayEntity pay = new PayEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(payPage,pay);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存应付账单失败");
        }
		payService.addMain(pay, zhangdanList);

		return Result.success(pay);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新应付账单",notes="更新应付账单")
	public ResponseMessage<?> update(@RequestBody PayPage payPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<PayPage>> failures = validator.validate(payPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ZhangdanEntity> zhangdanList =  payPage.getZhangdanList();
		
		PayEntity pay = new PayEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(payPage,pay);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("应付账单更新失败");
        }
		payService.updateMain(pay, zhangdanList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除应付账单")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			PayEntity pay = payService.get(PayEntity.class, id);
			payService.delMain(pay);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("应付账单删除失败");
		}

		return Result.success();
	}
}
