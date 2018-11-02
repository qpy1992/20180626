<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>车辆资料</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
	<script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="vehicleController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${vehiclePage.id }"/>
		<table style="width: 800px;" cellpadding="0" cellspacing="1" class="formtable">
                    <tr>
                        <label class="Validform_label" style="font-size: 20px;font-weight: bold;font-style: italic;color: #70070d">${vehiclePage.fitemid}</label>
                    </tr>
					<tr>
                        <td align="right">
                            <label class="Validform_label">
                                机动车所有人:
                            </label>
                        </td>
                        <td class="value" colspan="3">
                            <input id="fowner" name="fowner" placeholder="点击选择" onclick="popupClick(this,'typename','fowner','owner')" style="width: 500px" type="text" class="inputxt"  ignore="ignore"  value='${vehiclePage.fowner}'/>
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">机动车所有人</label>
                        </td>
					</tr>
					<tr>
                        <td align="right">
                            <label class="Validform_label">
                                车牌号:
                            </label>
                        </td>
                        <td class="value">
                            <input id="fcarno" name="fcarno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vehiclePage.fcarno}'/>
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">车号</label>
                        </td>
						<td align="right">
							<label class="Validform_label">
								登记日期:
							</label>
						</td>
						<td class="value">
									  <input id="fregdate" name="fregdate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${vehiclePage.fregdate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">登记日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								车辆类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fcartype" type="list"  typeGroupCode="cartype"   defaultVal="${vehiclePage.fcartype}" hasLabel="false"  title="车辆类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车辆类型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								车辆品牌:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fbrand" type="list"  typeGroupCode="brand"   defaultVal="${vehiclePage.fbrand}" hasLabel="false"  title="车辆品牌" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车辆品牌</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								车辆型号:
							</label>
						</td>
						<td class="value">
						    <input id="fmodel" name="fmodel" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vehiclePage.fmodel}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车辆型号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								车身颜色:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fcolor" type="list"  typeGroupCode="color"   defaultVal="${vehiclePage.fcolor}" hasLabel="false"  title="车身颜色" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车身颜色</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								车辆识别代号:
							</label>
						</td>
						<td class="value">
						    <input id="fidcode" name="fidcode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vehiclePage.fidcode}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车辆识别代号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								国产/进口:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fimex" type="list"  typeGroupCode="imex"   defaultVal="${vehiclePage.fimex}" hasLabel="false"  title="国产进口" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">国产进口</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								发动机号:
							</label>
						</td>
						<td class="value">
						    <input id="fengin" name="fengin" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vehiclePage.fengin}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发动机号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								发动机型号:
							</label>
						</td>
						<td class="value">
						    <input id="fengintype" name="fengintype" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vehiclePage.fengintype}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发动机型号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								燃料种类:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fuel" type="list"  typeGroupCode="fuel"   defaultVal="${vehiclePage.fuel}" hasLabel="false"  title="燃料种类" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">燃料种类</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								排量:
							</label>
						</td>
						<td class="value">
						    <input id="fdisplace" name="fdisplace" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vehiclePage.fdisplace}'/>
							<span class="Validform_checktip" style="color: #000000">ml</span>
							<label class="Validform_label" style="display: none;">排量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								功率:
							</label>
						</td>
						<td class="value">
						    <input id="fwatt" name="fwatt" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vehiclePage.fwatt}'/>
							<span class="Validform_checktip" style="color: #000000">kw</span>
							<label class="Validform_label" style="display: none;">功率</label>
						</td>
                        <td align="right">
                            <label class="Validform_label">
                                转向形式:
                            </label>
                        </td>
                        <td class="value">
                            <t:dictSelect field="fzhuan" type="list"  typeGroupCode="zhuan"   defaultVal="${vehiclePage.fzhuan}" hasLabel="false"  title="转向形式" ></t:dictSelect>
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">转向形式</label>
                        </td>
					</tr>
					<tr>
                        <td align="right">
                            <label class="Validform_label">
                                制造厂名称:
                            </label>
                        </td>
                        <td class="value" colspan="3">
                            <input id="fmade" name="fmade" placeholder="点击选择" onclick="popupClick(this,'typename','fmade','made')" style="width: 500px" type="text" class="inputxt"  ignore="ignore"  value='${vehiclePage.fmade}'/>
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">制造厂名称</label>
                        </td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								轮距:
							</label>
						</td>
						<td class="value">
                            <input id="flunju1" name="flunju1" type="text" style="width: 75px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vehiclePage.flunju1}'/>
                            <input id="flunju2" name="flunju2" type="text" style="width: 75px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vehiclePage.flunju2}'/>
							<span class="Validform_checktip" style="color: #000000">mm</span>
							<label class="Validform_label" style="display: none;">后轮距</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								轮胎数:
							</label>
						</td>
						<td class="value">
						    <input id="ftyrenum" name="ftyrenum" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${vehiclePage.ftyrenum}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">轮胎数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								轮胎规格:
							</label>
						</td>
						<td class="value">
						    <input id="ftyremodel" name="ftyremodel" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vehiclePage.ftyremodel}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">轮胎规格</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								钢板弹簧片数:
							</label>
						</td>
						<td class="value">
						    <input id="ffbthnum" name="ffbthnum" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${vehiclePage.ffbthnum}'/>
							<span class="Validform_checktip" style="color: #000000">片</span>
							<label class="Validform_label" style="display: none;">钢板弹簧片数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								轴距:
							</label>
						</td>
						<td class="value">
						    <input id="faxis" name="faxis" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vehiclePage.faxis}'/>
							<span class="Validform_checktip" style="color: #000000">mm</span>
							<label class="Validform_label" style="display: none;">轴距</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								轴数:
							</label>
						</td>
						<td class="value">
						    <input id="faxisnum" name="faxisnum" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vehiclePage.faxisnum}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">轴数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								高1:
							</label>
						</td>
						<td class="value">
                            <input id="flength" name="flength" placeholder="长" type="text" style="width: 50px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vehiclePage.flength}'/>
                            <input id="fwidth" name="fwidth" placeholder="宽" type="text" style="width: 50px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vehiclePage.fwidth}'/>
                            <input id="fheight" name="fheight" placeholder="高" type="text" style="width: 50px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vehiclePage.fheight}'/>
							<span class="Validform_checktip" style="color: #000000">mm</span>
							<label class="Validform_label" style="display: none;">高1</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								总重量:
							</label>
						</td>
						<td class="value">
						    <input id="fweight" name="fweight" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vehiclePage.fweight}'/>
							<span class="Validform_checktip" style="color: #000000">kg</span>
							<label class="Validform_label" style="display: none;">总重量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								实际重量:
							</label>
						</td>
						<td class="value">
						    <input id="ftrueweight" name="ftrueweight" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vehiclePage.ftrueweight}'/>
							<span class="Validform_checktip" style="color: #000000">kg</span>
							<label class="Validform_label" style="display: none;">实际重量</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								准牵引质量:
							</label>
						</td>
						<td class="value">
						    <input id="fperweight" name="fperweight" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vehiclePage.fperweight}'/>
                            <span class="Validform_checktip" style="color: #000000">kg</span>
							<label class="Validform_label" style="display: none;">准牵引质量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								使用性质:
							</label>
						</td>
						<td class="value">
						    <input id="fnature" name="fnature" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vehiclePage.fnature}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">使用性质</label>
						</td>
						<td align="right">
							<label class="Validform_label">
                                运输证号:
							</label>
						</td>
						<td class="value">
                            <span class="Validform_checktip" style="color: #000000">沪交运管</span>
						    <input id="flogzi" name="flogzi" type="text" style="width: 20px" class="inputxt"  ignore="ignore"  value='${vehiclePage.flogzi}'/>
                            <span class="Validform_checktip" style="color: #000000">字</span>
                            <input id="flognum" name="flognum" type="text" style="width: 80px" class="inputxt"  ignore="ignore"  value='${vehiclePage.flognum}'/>
                            <span class="Validform_checktip" style="color: #000000">号</span>
							<label class="Validform_label" style="display: none;">字号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								经营范围:
							</label>
						</td>
						<td class="value">
						    <input id="fjinying" name="fjinying" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vehiclePage.fjinying}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">经营范围</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								运输证发证日期:
							</label>
						</td>
						<td class="value">
									  <input id="fazhengdate" name="fazhengdate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${vehiclePage.fazhengdate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">运输证发证日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								运输证有效日期:
							</label>
						</td>
						<td class="value">
									  <input id="fyouxiaodate" name="fyouxiaodate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${vehiclePage.fyouxiaodate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">运输证有效日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								整备质量:
							</label>
						</td>
						<td class="value">
						    <input id="fzbweight" name="fzbweight" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${vehiclePage.fzbweight}'/>
							<span class="Validform_checktip" style="color: #000000">kg</span>
							<label class="Validform_label" style="display: none;">整备质量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								强制报废日期:
							</label>
						</td>
						<td class="value">
									  <input id="forcebf" name="forcebf" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${vehiclePage.forcebf}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">强制报废日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								检验有效期:
							</label>
						</td>
						<td class="value">
									  <input id="fjydate" name="fjydate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${vehiclePage.fjydate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">检验有效期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								登记证书:
							</label>
						</td>
						<td class="value">
									<table id="fdjzs_fileTable"></table>
										<table></table>
										<script type="text/javascript">
											var serverMsg="";
											$(function(){
												$('#fdjzs').uploadify({
													buttonText:'添加图片',
													auto:false,
													progressData:'speed',
													multi:true,
													height:25,
													overrideEvents:['onDialogClose'],
													fileTypeDesc:'文件格式:',
													queueID:'filediv_fdjzs',
													fileSizeLimit:'15MB',
													swf:'plug-in/uploadify/uploadify.swf',	
													uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
													onUploadStart : function(file) { 
														var cgFormId=$("input[name='id']").val();
														$('#fdjzs').uploadify("settings", "formData", {
															'cgFormId':cgFormId,
															'cgFormName':'z_vehicle',
															'cgFormField':'FDJZS'
														});
													} ,
													onQueueComplete : function(queueData) {
														 var win = frameElement.api.opener;
														 win.reloadTable();
														 win.tip(serverMsg);
														 frameElement.api.close();
													},
													onUploadSuccess : function(file, data, response) {
														var d=$.parseJSON(data);
														if(d.success){
															var win = frameElement.api.opener;
															serverMsg = d.msg;
														}
													},
													onFallback: function() {
									                    tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")
									                },
									                onSelectError: function(file, errorCode, errorMsg) {
									                    switch (errorCode) {
									                    case - 100 : tip("上传的文件数量已经超出系统限制的" + $('#file').uploadify('settings', 'queueSizeLimit') + "个文件！");
									                        break;
									                    case - 110 : tip("文件 [" + file.name + "] 大小超出系统限制的" + $('#file').uploadify('settings', 'fileSizeLimit') + "大小！");
									                        break;
									                    case - 120 : tip("文件 [" + file.name + "] 大小异常！");
									                        break;
									                    case - 130 : tip("文件 [" + file.name + "] 类型不正确！");
									                        break;
									                    }
									                },
									                onUploadProgress: function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {}
												});
											});
										</script>
										<span id="file_uploadspan"><input type="file" name="fdjzs" id="fdjzs" /></span> 
										<div class="form" id="filediv_fdjzs"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">登记证书</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								行驶证:
							</label>
						</td>
						<td class="value">
									<table id="fxsz_fileTable"></table>
										<table></table>
										<script type="text/javascript">
											var serverMsg="";
											$(function(){
												$('#fxsz').uploadify({
													buttonText:'添加图片',
													auto:false,
													progressData:'speed',
													multi:true,
													height:25,
													overrideEvents:['onDialogClose'],
													fileTypeDesc:'文件格式:',
													queueID:'filediv_fxsz',
													fileSizeLimit:'15MB',
													swf:'plug-in/uploadify/uploadify.swf',	
													uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
													onUploadStart : function(file) { 
														var cgFormId=$("input[name='id']").val();
														$('#fxsz').uploadify("settings", "formData", {
															'cgFormId':cgFormId,
															'cgFormName':'z_vehicle',
															'cgFormField':'FXSZ'
														});
													} ,
													onQueueComplete : function(queueData) {
														 var win = frameElement.api.opener;
														 win.reloadTable();
														 win.tip(serverMsg);
														 frameElement.api.close();
													},
													onUploadSuccess : function(file, data, response) {
														var d=$.parseJSON(data);
														if(d.success){
															var win = frameElement.api.opener;
															serverMsg = d.msg;
														}
													},
													onFallback: function() {
									                    tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")
									                },
									                onSelectError: function(file, errorCode, errorMsg) {
									                    switch (errorCode) {
									                    case - 100 : tip("上传的文件数量已经超出系统限制的" + $('#file').uploadify('settings', 'queueSizeLimit') + "个文件！");
									                        break;
									                    case - 110 : tip("文件 [" + file.name + "] 大小超出系统限制的" + $('#file').uploadify('settings', 'fileSizeLimit') + "大小！");
									                        break;
									                    case - 120 : tip("文件 [" + file.name + "] 大小异常！");
									                        break;
									                    case - 130 : tip("文件 [" + file.name + "] 类型不正确！");
									                        break;
									                    }
									                },
									                onUploadProgress: function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {}
												});
											});
										</script>
										<span id="file_uploadspan"><input type="file" name="fxsz" id="fxsz" /></span> 
										<div class="form" id="filediv_fxsz"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">行驶证</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								营运证:
							</label>
						</td>
						<td class="value">
									<table id="fyyz_fileTable"></table>
										<table></table>
										<script type="text/javascript">
											var serverMsg="";
											$(function(){
												$('#fyyz').uploadify({
													buttonText:'添加图片',
													auto:false,
													progressData:'speed',
													multi:true,
													height:25,
													overrideEvents:['onDialogClose'],
													fileTypeDesc:'文件格式:',
													queueID:'filediv_fyyz',
													fileSizeLimit:'15MB',
													swf:'plug-in/uploadify/uploadify.swf',	
													uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
													onUploadStart : function(file) { 
														var cgFormId=$("input[name='id']").val();
														$('#fyyz').uploadify("settings", "formData", {
															'cgFormId':cgFormId,
															'cgFormName':'z_vehicle',
															'cgFormField':'FYYZ'
														});
													} ,
													onQueueComplete : function(queueData) {
														 var win = frameElement.api.opener;
														 win.reloadTable();
														 win.tip(serverMsg);
														 frameElement.api.close();
													},
													onUploadSuccess : function(file, data, response) {
														var d=$.parseJSON(data);
														if(d.success){
															var win = frameElement.api.opener;
															serverMsg = d.msg;
														}
													},
													onFallback: function() {
									                    tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")
									                },
									                onSelectError: function(file, errorCode, errorMsg) {
									                    switch (errorCode) {
									                    case - 100 : tip("上传的文件数量已经超出系统限制的" + $('#file').uploadify('settings', 'queueSizeLimit') + "个文件！");
									                        break;
									                    case - 110 : tip("文件 [" + file.name + "] 大小超出系统限制的" + $('#file').uploadify('settings', 'fileSizeLimit') + "大小！");
									                        break;
									                    case - 120 : tip("文件 [" + file.name + "] 大小异常！");
									                        break;
									                    case - 130 : tip("文件 [" + file.name + "] 类型不正确！");
									                        break;
									                    }
									                },
									                onUploadProgress: function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {}
												});
											});
										</script>
										<span id="file_uploadspan"><input type="file" name="fyyz" id="fyyz" /></span> 
										<div class="form" id="filediv_fyyz"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">营运证</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								交强险:
							</label>
						</td>
						<td class="value">
									<table id="fjqx_fileTable"></table>
										<table></table>
										<script type="text/javascript">
											var serverMsg="";
											$(function(){
												$('#fjqx').uploadify({
													buttonText:'添加图片',
													auto:false,
													progressData:'speed',
													multi:true,
													height:25,
													overrideEvents:['onDialogClose'],
													fileTypeDesc:'文件格式:',
													queueID:'filediv_fjqx',
													fileSizeLimit:'15MB',
													swf:'plug-in/uploadify/uploadify.swf',	
													uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
													onUploadStart : function(file) { 
														var cgFormId=$("input[name='id']").val();
														$('#fjqx').uploadify("settings", "formData", {
															'cgFormId':cgFormId,
															'cgFormName':'z_vehicle',
															'cgFormField':'FJQX'
														});
													} ,
													onQueueComplete : function(queueData) {
														 var win = frameElement.api.opener;
														 win.reloadTable();
														 win.tip(serverMsg);
														 frameElement.api.close();
													},
													onUploadSuccess : function(file, data, response) {
														var d=$.parseJSON(data);
														if(d.success){
															var win = frameElement.api.opener;
															serverMsg = d.msg;
														}
													},
													onFallback: function() {
									                    tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")
									                },
									                onSelectError: function(file, errorCode, errorMsg) {
									                    switch (errorCode) {
									                    case - 100 : tip("上传的文件数量已经超出系统限制的" + $('#file').uploadify('settings', 'queueSizeLimit') + "个文件！");
									                        break;
									                    case - 110 : tip("文件 [" + file.name + "] 大小超出系统限制的" + $('#file').uploadify('settings', 'fileSizeLimit') + "大小！");
									                        break;
									                    case - 120 : tip("文件 [" + file.name + "] 大小异常！");
									                        break;
									                    case - 130 : tip("文件 [" + file.name + "] 类型不正确！");
									                        break;
									                    }
									                },
									                onUploadProgress: function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {}
												});
											});
										</script>
										<span id="file_uploadspan"><input type="file" name="fjqx" id="fjqx" /></span> 
										<div class="form" id="filediv_fjqx"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">交强险</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								商业险:
							</label>
						</td>
						<td class="value">
									<table id="fsyx_fileTable"></table>
										<table></table>
										<script type="text/javascript">
											var serverMsg="";
											$(function(){
												$('#fsyx').uploadify({
													buttonText:'添加图片',
													auto:false,
													progressData:'speed',
													multi:true,
													height:25,
													overrideEvents:['onDialogClose'],
													fileTypeDesc:'文件格式:',
													queueID:'filediv_fsyx',
													fileSizeLimit:'15MB',
													swf:'plug-in/uploadify/uploadify.swf',	
													uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
													onUploadStart : function(file) { 
														var cgFormId=$("input[name='id']").val();
														$('#fsyx').uploadify("settings", "formData", {
															'cgFormId':cgFormId,
															'cgFormName':'z_vehicle',
															'cgFormField':'FSYX'
														});
													} ,
													onQueueComplete : function(queueData) {
														 var win = frameElement.api.opener;
														 win.reloadTable();
														 win.tip(serverMsg);
														 frameElement.api.close();
													},
													onUploadSuccess : function(file, data, response) {
														var d=$.parseJSON(data);
														if(d.success){
															var win = frameElement.api.opener;
															serverMsg = d.msg;
														}
													},
													onFallback: function() {
									                    tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")
									                },
									                onSelectError: function(file, errorCode, errorMsg) {
									                    switch (errorCode) {
									                    case - 100 : tip("上传的文件数量已经超出系统限制的" + $('#file').uploadify('settings', 'queueSizeLimit') + "个文件！");
									                        break;
									                    case - 110 : tip("文件 [" + file.name + "] 大小超出系统限制的" + $('#file').uploadify('settings', 'fileSizeLimit') + "大小！");
									                        break;
									                    case - 120 : tip("文件 [" + file.name + "] 大小异常！");
									                        break;
									                    case - 130 : tip("文件 [" + file.name + "] 类型不正确！");
									                        break;
									                    }
									                },
									                onUploadProgress: function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {}
												});
											});
										</script>
										<span id="file_uploadspan"><input type="file" name="fsyx" id="fsyx" /></span> 
										<div class="form" id="filediv_fsyx"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商业险</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								货物险:
							</label>
						</td>
						<td class="value">
									<table id="fhwx_fileTable"></table>
										<table></table>
										<script type="text/javascript">
											var serverMsg="";
											$(function(){
												$('#fhwx').uploadify({
													buttonText:'添加图片',
													auto:false,
													progressData:'speed',
													multi:true,
													height:25,
													overrideEvents:['onDialogClose'],
													fileTypeDesc:'文件格式:',
													queueID:'filediv_fhwx',
													fileSizeLimit:'15MB',
													swf:'plug-in/uploadify/uploadify.swf',	
													uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
													onUploadStart : function(file) { 
														var cgFormId=$("input[name='id']").val();
														$('#fhwx').uploadify("settings", "formData", {
															'cgFormId':cgFormId,
															'cgFormName':'z_vehicle',
															'cgFormField':'FHWX'
														});
													} ,
													onQueueComplete : function(queueData) {
														 var win = frameElement.api.opener;
														 win.reloadTable();
														 win.tip(serverMsg);
														 frameElement.api.close();
													},
													onUploadSuccess : function(file, data, response) {
														var d=$.parseJSON(data);
														if(d.success){
															var win = frameElement.api.opener;
															serverMsg = d.msg;
														}
													},
													onFallback: function() {
									                    tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")
									                },
									                onSelectError: function(file, errorCode, errorMsg) {
									                    switch (errorCode) {
									                    case - 100 : tip("上传的文件数量已经超出系统限制的" + $('#file').uploadify('settings', 'queueSizeLimit') + "个文件！");
									                        break;
									                    case - 110 : tip("文件 [" + file.name + "] 大小超出系统限制的" + $('#file').uploadify('settings', 'fileSizeLimit') + "大小！");
									                        break;
									                    case - 120 : tip("文件 [" + file.name + "] 大小异常！");
									                        break;
									                    case - 130 : tip("文件 [" + file.name + "] 类型不正确！");
									                        break;
									                    }
									                },
									                onUploadProgress: function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {}
												});
											});
										</script>
										<span id="file_uploadspan"><input type="file" name="fhwx" id="fhwx" /></span> 
										<div class="form" id="filediv_fhwx"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">货物险</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value"  colspan="3" >
						  	 	<textarea id="fnote" style="width:600px;" class="inputxt" rows="6" name="fnote"  ignore="ignore" >${vehiclePage.fnote}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/vehicle/vehicle.js"></script>		
	  	<script type="text/javascript">
		  	//加载 已存在的 文件
		  	$(function(){
		  		var cgFormId=$("input[name='id']").val();
		  		$.ajax({
		  		   type: "post",
		  		   url: "vehicleController.do?getFiles&id=" +  cgFormId,
		  		   success: function(data){
		  			 var arrayFileObj = jQuery.parseJSON(data).obj;
		  			 
		  			$.each(arrayFileObj,function(n,file){
		  				var fieldName = file.field.toLowerCase();
		  				var table = $("#"+fieldName+"_fileTable");
		  				var tr = $("<tr style=\"height:34px;\"></tr>");
		  				var title = file.title;
		  				if(title.length > 15){
		  					title = title.substring(0,12) + "...";
		  				}
		  				var td_title = $("<td>" + title + "</td>");
		  		  		var td_download = $("<td><a style=\"margin-left:10px;\" href=\"commonController.do?viewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"下载\">下载</a></td>")
		  		  		var td_view = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0);\" onclick=\"openwindow('预览','commonController.do?openViewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)\">预览</a></td>");
		  		  		var td_del = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0)\" class=\"jeecgDetail\" onclick=\"del('cgUploadController.do?delFile&id=" + file.fileKey + "',this)\">删除</a></td>");
		  		  		tr.appendTo(table);
		  		  		td_title.appendTo(tr);
		  		  		td_download.appendTo(tr);
		  		  		td_view.appendTo(tr);
		  		  		td_del.appendTo(tr);
		  			 });
		  		   }
		  		});
		  	});
		  	
		  	/**
		 	 * 删除图片数据资源
		 	 */
		  	function del(url,obj){
		  		var content = "请问是否要删除该资源";
		  		var navigatorName = "Microsoft Internet Explorer"; 
		  		if( navigator.appName == navigatorName ){ 
		  			$.dialog.confirm(content, function(){
		  				submit(url,obj);
		  			}, function(){
		  			});
		  		}else{
		  			layer.open({
						title:"提示",
						content:content,
						icon:7,
						yes:function(index){
							submit(url,obj);
						},
						btn:['确定','取消'],
						btn2:function(index){
							layer.close(index);
						}
					});
		  		}
		  	}
		  	
		  	function submit(url,obj){
		  		$.ajax({
		  			async : false,
		  			cache : false,
		  			type : 'POST',
		  			url : url,// 请求的action路径
		  			error : function() {// 请求失败处理函数
		  			},
		  			success : function(data) {
		  				var d = $.parseJSON(data);
		  				if (d.success) {
		  					var msg = d.msg;
		  					tip(msg);
		  					obj.parentNode.parentNode.parentNode.deleteRow(obj.parentNode.parentNode);
		  				} else {
		  					tip(d.msg);
		  				}
		  			}
		  		});
		  	}
		  	
	  		function jeecgFormFileCallBack(data){
	  			if (data.success == true) {
					uploadFile(data);
				} else {
					if (data.responseText == '' || data.responseText == undefined) {
						$.messager.alert('错误', data.msg);
						$.Hidemsg();
					} else {
						try {
							var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
							$.messager.alert('错误', emsg);
							$.Hidemsg();
						} catch(ex) {
							$.messager.alert('错误', data.responseText + '');
						}
					}
					return false;
				}
				if (!neibuClickFlag) {
					var win = frameElement.api.opener;
					win.reloadTable();
				}
	  		}
	  		function upload() {
					$('#fdjzs').uploadify('upload', '*');	
					$('#fxsz').uploadify('upload', '*');	
					$('#fyyz').uploadify('upload', '*');	
					$('#fjqx').uploadify('upload', '*');	
					$('#fsyx').uploadify('upload', '*');	
					$('#fhwx').uploadify('upload', '*');	
			}
			
			var neibuClickFlag = false;
			function neibuClick() {
				neibuClickFlag = true; 
				$('#btn_sub').trigger('click');
			}
			function cancel() {
					$('#fdjzs').uploadify('cancel', '*');	
					$('#fxsz').uploadify('cancel', '*');	
					$('#fyyz').uploadify('cancel', '*');	
					$('#fjqx').uploadify('cancel', '*');	
					$('#fsyx').uploadify('cancel', '*');	
					$('#fhwx').uploadify('cancel', '*');	
			}
			function uploadFile(data){
				if(!$("input[name='id']").val()){
					if(data.obj!=null && data.obj!='undefined'){
						$("input[name='id']").val(data.obj.id);
					}
				}
				if($(".uploadify-queue-item").length>0){
					upload();
				}else{
					if (neibuClickFlag){
						alert(data.msg);
						neibuClickFlag = false;
					}else {
						var win = frameElement.api.opener;
						win.reloadTable();
						win.tip(data.msg);
						frameElement.api.close();
					}
				}
			}
	  	</script>
