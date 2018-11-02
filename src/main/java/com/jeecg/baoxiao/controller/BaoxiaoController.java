package com.jeecg.baoxiao.controller;

import com.jeecg.baoxiao.entity.BaoxiaoEntity;
import com.jeecg.baoxiao.service.BaoxiaoServiceI;
import com.jeecg.baoxiao.page.BaoxiaoPage;
import com.jeecg.bxcost.entity.BxcostEntity;
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
 * @Description: 报销单管理
 * @author onlineGenerator
 * @date 2018-08-16 10:35:38
 * @version V1.0   
 *
 */
@Api(value="Baoxiao",description="报销单管理",tags="baoxiaoController")
@Controller
@RequestMapping("/baoxiaoController")
public class BaoxiaoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BaoxiaoController.class);

	@Autowired
	private BaoxiaoServiceI baoxiaoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private CgReportServiceI cgReportService;

	/**
	 * 报销单管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/baoxiao/baoxiaoList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param baoxiao
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(BaoxiaoEntity baoxiao,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BaoxiaoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, baoxiao);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.baoxiaoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除报销单管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BaoxiaoEntity baoxiao, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		baoxiao = systemService.getEntity(BaoxiaoEntity.class, baoxiao.getId());
		String message = "报销单管理删除成功";
		try{
			baoxiaoService.delMain(baoxiao);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "报销单管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除报销单管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "报销单管理删除成功";
		try{
			for(String id:ids.split(",")){
				BaoxiaoEntity baoxiao = systemService.getEntity(BaoxiaoEntity.class, id);
				baoxiaoService.delMain(baoxiao);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "报销单管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加报销单管理
	 * 
	 * @param baoxiao
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BaoxiaoEntity baoxiao,BaoxiaoPage baoxiaoPage, HttpServletRequest request) {
		List<BxcostEntity> bxcostList =  baoxiaoPage.getBxcostList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			baoxiao.setFbxno(systemService.getFbillno(83));
			baoxiao.setFcheck("0");
			baoxiao.setFhxamount(0.00);
			baoxiao.setFhxstatus("0");
			baoxiaoService.addMain(baoxiao, bxcostList);
			for(BxcostEntity bxcost:bxcostList){
			    systemService.executeSql("update z_charge set fbx='Y',fsfamount="+bxcost.getFsfamount()+" where id ='"+bxcost.getCostid()+"'");
            }
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "报销单管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新报销单管理
	 * 
	 * @param baoxiao
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BaoxiaoEntity baoxiao,BaoxiaoPage baoxiaoPage, HttpServletRequest request) {
		List<BxcostEntity> bxcostList =  baoxiaoPage.getBxcostList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			baoxiaoService.updateMain(baoxiao, bxcostList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新报销单管理失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
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
				BaoxiaoEntity baoxiao = systemService.getEntity(BaoxiaoEntity.class, id);
				baoxiao.setFcheck("1");
				baoxiao.setFchecker(ResourceUtil.getSessionUser().getUserName());
				baoxiao.setFcheckdate(new Date());
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
				BaoxiaoEntity baoxiao = systemService.getEntity(BaoxiaoEntity.class, id);
				baoxiao.setFcheck("0");
				baoxiao.setFchecker(ResourceUtil.getSessionUser().getUserName());
				baoxiao.setFcheckdate(new Date());
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
	 * 报销单管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BaoxiaoEntity baoxiao, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(baoxiao.getId())) {
			baoxiao = baoxiaoService.getEntity(BaoxiaoEntity.class, baoxiao.getId());
			req.setAttribute("baoxiaoPage", baoxiao);
		}
		return new ModelAndView("com/jeecg/baoxiao/baoxiao-add");
	}
	
	/**
	 * 报销单管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BaoxiaoEntity baoxiao, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(baoxiao.getId())) {
			baoxiao = baoxiaoService.getEntity(BaoxiaoEntity.class, baoxiao.getId());
			req.setAttribute("baoxiaoPage", baoxiao);
		}
		return new ModelAndView("com/jeecg/baoxiao/baoxiao-update");
	}


	@RequestMapping(params = "baoxiao")
	@ResponseBody
	public void baoxiao(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) throws IOException {
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
		String sql ="select a.id,a.fcost,a.fcostname,a.funit,a.fqty,fprice,a.famount,isnull(a.fsfamount,0) fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,a.fcheck,a.fshoufu,a.fsettle,a.fsettlename,(case a.fdd when 'Y' then '是' when 'N' then '否' end) fdd,b.fblno,b.fshipname,b.fvoyageno,b.foperate_time operatetime,b.fbillno fweituo,b.fnote,b.fentrust_unit entrust,c.fzhdp,c.fzhdpdz,c.fboxno,d.fbillno paiche from z_charge a inner join z_custom_entrust b on b.id=a.fid inner join z_contianer c on c.fid=b.id inner join z_paiche d on d.fbillno=c.fbillno where 1=1 and a.id in "+idarray;
		String sql1 = "select a.id,a.fcost,a.fcostname,a.funit,a.fqty,a.fprice,a.famount,isnull(a.fsfamount,0) fsfamount,a.fsfamount-isnull(a.fykamount,0) fkk,a.fcheck,a.fshoufu,a.fsettle,a.fsettlename,(case a.fdd when 'Y' then '是' when 'N' then '否' end) fdd,d.fblno,d.fshipname,d.fvoyageno,d.foperate_time operatetime,d.fbillno fweituo,d.fnote,d.fentrust_unit entrust,c.fzhdp,c.fzhdpdz,c.fboxno,b.fbillno paiche from z_charge a inner join z_paiche b on b.id=a.fid inner join z_contianer c on c.fbillno=b.fbillno inner join z_custom_entrust d on d.id=c.fid where 1=1 and a.id in"+idarray;
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
	 * 加载明细列表[报销费用明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "bxcostList")
	public ModelAndView bxcostList(BaoxiaoEntity baoxiao, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = baoxiao.getId();
		//===================================================================================
		//查询-报销费用明细
	    String hql0 = "from BxcostEntity where 1 = 1 AND fID = ? ";
	    try{
	    	List<BxcostEntity> bxcostEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("bxcostList", bxcostEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/bxcost/bxcostList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(BaoxiaoEntity baoxiao,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(BaoxiaoEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, baoxiao);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<BaoxiaoEntity> list=this.baoxiaoService.getListByCriteriaQuery(cq, false);
    	List<BaoxiaoPage> pageList=new ArrayList<BaoxiaoPage>();
        if(list!=null&&list.size()>0){
        	for(BaoxiaoEntity entity:list){
        		try{
        		BaoxiaoPage page=new BaoxiaoPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from BxcostEntity where 1 = 1 AND fID = ? ";
        	        List<BxcostEntity> bxcostEntityList = systemService.findHql(hql0,id0);
            		page.setBxcostList(bxcostEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"报销单管理");
        map.put(NormalExcelConstants.CLASS,BaoxiaoPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("报销单管理列表", "导出人:Jeecg",
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
				List<BaoxiaoPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), BaoxiaoPage.class, params);
				BaoxiaoEntity entity1=null;
				for (BaoxiaoPage page : list) {
					entity1=new BaoxiaoEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            baoxiaoService.addMain(entity1, page.getBxcostList());
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
		map.put(NormalExcelConstants.FILE_NAME,"报销单管理");
		map.put(NormalExcelConstants.CLASS,BaoxiaoPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("报销单管理列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "baoxiaoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="报销单管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<BaoxiaoPage>> list() {
		List<BaoxiaoEntity> list= baoxiaoService.getList(BaoxiaoEntity.class);
    	List<BaoxiaoPage> pageList=new ArrayList<BaoxiaoPage>();
        if(list!=null&&list.size()>0){
        	for(BaoxiaoEntity entity:list){
        		try{
        			BaoxiaoPage page=new BaoxiaoPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from BxcostEntity where 1 = 1 AND fID = ? ";
	    			List<BxcostEntity> bxcostOldList = this.baoxiaoService.findHql(hql0,id0);
            		page.setBxcostList(bxcostOldList);
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
	@ApiOperation(value="根据ID获取报销单管理信息",notes="根据ID获取报销单管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		BaoxiaoEntity task = baoxiaoService.get(BaoxiaoEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取报销单管理信息为空");
		}
		BaoxiaoPage page = new BaoxiaoPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from BxcostEntity where 1 = 1 AND fID = ? ";
			List<BxcostEntity> bxcostOldList = this.baoxiaoService.findHql(hql0,id0);
    		page.setBxcostList(bxcostOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建报销单管理")
	public ResponseMessage<?> create(@ApiParam(name="报销单管理对象")@RequestBody BaoxiaoPage baoxiaoPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BaoxiaoPage>> failures = validator.validate(baoxiaoPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BxcostEntity> bxcostList =  baoxiaoPage.getBxcostList();
		
		BaoxiaoEntity baoxiao = new BaoxiaoEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(baoxiaoPage,baoxiao);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存报销单管理失败");
        }
		baoxiaoService.addMain(baoxiao, bxcostList);

		return Result.success(baoxiao);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新报销单管理",notes="更新报销单管理")
	public ResponseMessage<?> update(@RequestBody BaoxiaoPage baoxiaoPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BaoxiaoPage>> failures = validator.validate(baoxiaoPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BxcostEntity> bxcostList =  baoxiaoPage.getBxcostList();
		
		BaoxiaoEntity baoxiao = new BaoxiaoEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(baoxiaoPage,baoxiao);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("报销单管理更新失败");
        }
		baoxiaoService.updateMain(baoxiao, bxcostList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除报销单管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			BaoxiaoEntity baoxiao = baoxiaoService.get(BaoxiaoEntity.class, id);
			baoxiaoService.delMain(baoxiao);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("报销单管理删除失败");
		}

		return Result.success();
	}
}
