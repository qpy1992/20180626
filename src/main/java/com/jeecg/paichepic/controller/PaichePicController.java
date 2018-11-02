package com.jeecg.paichepic.controller;
import com.jeecg.paichepic.entity.PaichePicEntity;
import com.jeecg.paichepic.service.PaichePicServiceI;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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

import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;

import static sun.net.www.protocol.http.HttpURLConnection.userAgent;

/**
 * @Title: Controller  
 * @Description: 派车单图片
 * @author onlineGenerator
 * @date 2018-08-27 15:55:52
 * @version V1.0   
 *
 */
@Api(value="PaichePic",description="派车单图片",tags="paichePicController")
@Controller
@RequestMapping("/paichePicController")
public class PaichePicController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PaichePicController.class);

	@Autowired
	private PaichePicServiceI paichePicService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;

    private static final CloseableHttpClient httpclient = HttpClients.createDefault();


	/**
	 * 派车单图片列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/paichepic/paichePicList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param paichePic
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(PaichePicEntity paichePic,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PaichePicEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, paichePic, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.paichePicService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除派车单图片
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(PaichePicEntity paichePic, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		paichePic = systemService.getEntity(PaichePicEntity.class, paichePic.getId());
		message = "派车单图片删除成功";
		try{
			paichePicService.delete(paichePic);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "派车单图片删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除派车单图片
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "派车单图片删除成功";
		try{
			for(String id:ids.split(",")){
				PaichePicEntity paichePic = systemService.getEntity(PaichePicEntity.class, 
				id
				);
				paichePicService.delete(paichePic);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "派车单图片删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加派车单图片
	 * 
	 * @param paichePic
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(PaichePicEntity paichePic, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "派车单图片添加成功";
		try{
			paichePicService.save(paichePic);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "派车单图片添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(paichePic);
		return j;
	}
	
	/**
	 * 更新派车单图片
	 * 
	 * @param paichePic
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(PaichePicEntity paichePic, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "派车单图片更新成功";
		PaichePicEntity t = paichePicService.get(PaichePicEntity.class, paichePic.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(paichePic, t);
			paichePicService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "派车单图片更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 派车单图片新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(PaichePicEntity paichePic, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(paichePic.getId())) {
			paichePic = paichePicService.getEntity(PaichePicEntity.class, paichePic.getId());
			req.setAttribute("paichePicPage", paichePic);
		}
		return new ModelAndView("com/jeecg/paichepic/paichePic-add");
	}
	/**
	 * 派车单图片编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(PaichePicEntity paichePic, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(paichePic.getId())) {
			paichePic = paichePicService.getEntity(PaichePicEntity.class, paichePic.getId());
			req.setAttribute("paichePicPage", paichePic);
		}
		return new ModelAndView("com/jeecg/paichepic/paichePic-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","paichePicController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(PaichePicEntity paichePic,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(PaichePicEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, paichePic, request.getParameterMap());
		List<PaichePicEntity> paichePics = this.paichePicService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"派车单图片");
		modelMap.put(NormalExcelConstants.CLASS,PaichePicEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("派车单图片列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,paichePics);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(PaichePicEntity paichePic,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"派车单图片");
    	modelMap.put(NormalExcelConstants.CLASS,PaichePicEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("派车单图片列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<PaichePicEntity> listPaichePicEntitys = ExcelImportUtil.importExcel(file.getInputStream(),PaichePicEntity.class,params);
				for (PaichePicEntity paichePic : listPaichePicEntitys) {
					paichePicService.save(paichePic);
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
	 * 获取文件附件信息
	 * 
	 * @param id paichePic主键id
	 */
	@RequestMapping(params = "getFiles")
	@ResponseBody
	public AjaxJson getFiles(String id){
		List<CgUploadEntity> uploadBeans = cgFormFieldService.findByProperty(CgUploadEntity.class, "cgformId", id);
		List<Map<String,Object>> files = new ArrayList<Map<String,Object>>(0);
		for(CgUploadEntity b:uploadBeans){
			String title = b.getAttachmenttitle();//附件名
			String fileKey = b.getId();//附件主键
			String path = b.getRealpath();//附件路径
			String field = b.getCgformField();//表单中作为附件控件的字段
			Map<String, Object> file = new HashMap<String, Object>();
			file.put("title", title);
			file.put("fileKey", fileKey);
			file.put("path", path);
			file.put("field", field==null?"":field);
			files.add(file);
		}
		AjaxJson j = new AjaxJson();
		j.setObj(files);
		return j;
	}


    public static String sendGet(String url) {
        String result = null;
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("User-Agent", userAgent);
            response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            logger.error("处理失败 {}" + e);
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return result;
    }



    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="派车单图片列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<PaichePicEntity>> list() {
		List<PaichePicEntity> listPaichePics=paichePicService.getList(PaichePicEntity.class);
		return Result.success(listPaichePics);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取派车单图片信息",notes="根据ID获取派车单图片信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		PaichePicEntity task = paichePicService.get(PaichePicEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取派车单图片信息为空");
		}
		return Result.success(task);
	}

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    @ApiOperation(value="上传派车单图片")
    public String upload(@ApiParam(name="派车单图片对象")@RequestBody MultipartFile file, HttpServletRequest request) {
        //调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
        String url = "";
        String realpath = request.getSession().getServletContext().getRealPath("");
        String path = realpath.substring(0, realpath.lastIndexOf("\\")) + "/jeecg/upload/files";
        System.out.println("path=" + path);
        String fileName = new Date().getTime() + ".png";
        File targetFile = new File(path, fileName);
        System.out.println(targetFile);
        if (!targetFile.getParentFile().exists()) {
            targetFile.mkdirs();
        }
            //保存
        try {
            file.transferTo(targetFile);
            url = request.getContextPath() + "/upload/files/" + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "FAIL";
        }
        return url;
    }

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建派车单图片")
	public ResponseMessage<?> create(@ApiParam(name="派车单图片对象")@RequestBody PaichePicEntity paichePic, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<PaichePicEntity>> failures = validator.validate(paichePic);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
		    String fgeo = paichePic.getFlocation();
            String result = sendGet("https://apis.map.qq.com/ws/geocoder/v1/?coord_type=5&get_poi=0&output=json&key=UHMBZ-KONWP-BDNDX-LCIPU-I2NAQ-DYFKN&location="+fgeo);
			logger.info(result);
            JSONObject json = JSONObject.fromObject(result);
            String res = json.getString("result");
            JSONObject j = JSONObject.fromObject(res);
            String ad = j.getString("ad_info");
            String add = j.getString("address_reference");
            JSONObject j1 = JSONObject.fromObject(add);
            String town = j1.getString("town");
            JSONObject json1 = JSONObject.fromObject(ad);
            JSONObject json2 = JSONObject.fromObject(town);
            String nation = json1.getString("nation");
            String province = json1.getString("province");
            String city = json1.getString("city");
            String distirict = json1.getString("district");
            String title = json2.getString("title");
            paichePic.setFlocation(nation+province+city+distirict+title);
            paichePicService.save(paichePic);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("派车单图片信息保存失败");
		}
		return Result.success(paichePic);
	}

    @RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value="批量创建派车单图片")
    public ResponseMessage<?> create1(@ApiParam(name="派车单图片对象")@RequestBody List<PaichePicEntity> paichePicList, UriComponentsBuilder uriBuilder) {
        //调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
        for(PaichePicEntity paichePic:paichePicList) {
            Set<ConstraintViolation<PaichePicEntity>> failures = validator.validate(paichePic);
            if (!failures.isEmpty()) {
                return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
            }
            //保存
            try {
                paichePicService.save(paichePic);
            } catch (Exception e) {
                e.printStackTrace();
                return Result.error("派车单图片信息保存失败");
            }
        }
        return Result.success(paichePicList);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新派车单图片",notes="更新派车单图片")
	public ResponseMessage<?> update(@ApiParam(name="派车单图片对象")@RequestBody PaichePicEntity paichePic) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<PaichePicEntity>> failures = validator.validate(paichePic);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			paichePicService.saveOrUpdate(paichePic);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新派车单图片信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新派车单图片信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除派车单图片")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			paichePicService.deleteEntityById(PaichePicEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("派车单图片删除失败");
		}

		return Result.success();
	}
}
