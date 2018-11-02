<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>司机资料</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
	<script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="sijiController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${sijiPage.id }"/>
		<table style="width: 800px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<label class="Validform_label" style="font-size: 20px;font-weight: bold;font-style: italic;color: #70070d">${sijiPage.fcode}</label>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						    <input id="fname" name="fname" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${sijiPage.fname}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fsex" type="list"  typeGroupCode="sex"   defaultVal="${sijiPage.fsex}" hasLabel="false"  title="性别" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								民族:
							</label>
						</td>
						<td class="value">
						    <input id="fregion" name="fregion" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${sijiPage.fregion}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">民族</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								出生日期:
							</label>
						</td>
						<td class="value">
									  <input id="fbirthday" name="fbirthday" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${sijiPage.fbirthday}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出生日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								户籍住址:
							</label>
						</td>
						<td class="value"  colspan="3" >
							<textarea id="faddress" style="width:600px;" class="inputxt" rows="6" name="faddress"  ignore="ignore" >${sijiPage.faddress}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">户籍住址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								身份证号:
							</label>
						</td>
						<td class="value">
						    <input id="fidnum" name="fidnum" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${sijiPage.fidnum}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身份证号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								手机号:
							</label>
						</td>
						<td class="value">
							<input id="fmobile" name="fmobile" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${sijiPage.fmobile}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手机号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								紧急联系人:
							</label>
						</td>
						<td class="value">
							<input id="femergen" name="femergen" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${sijiPage.femergen}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">紧急联系人</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								手机号:
							</label>
						</td>
						<td class="value">
							<input id="femobile" name="femobile" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${sijiPage.femobile}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手机号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								签发机关:
							</label>
						</td>
						<td class="value">
						    <input id="fjiguan" name="fjiguan" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${sijiPage.fjiguan}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">签发机关</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								有效期限:
							</label>
						</td>
						<td class="value">
							<input id="fqixian1" name="fqixian1" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${sijiPage.fqixian1}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip">~</span>
							<input id="fqixian2" name="fqixian2" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${sijiPage.fqixian2}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">有效期限</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								从业资格号:
							</label>
						</td>
						<td class="value">
						    <input id="fcongye" name="fcongye" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${sijiPage.fcongye}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">从业资格号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								从业资格类别:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fcytype" type="checkbox"  typeGroupCode="congye"   defaultVal="${sijiPage.fcytype}" hasLabel="false"  title="从业资格类别" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">从业资格类别</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								初次发证时间:
							</label>
						</td>
						<td class="value">
									  <input id="fazhengtime" name="fazhengtime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${sijiPage.fazhengtime}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">初次发证时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								发证时间:
							</label>
						</td>
						<td class="value">
									  <input id="fazheng" name="fazheng" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${sijiPage.fazheng}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发证时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								有效期至:
							</label>
						</td>
						<td class="value">
									  <input id="fyouxiao" name="fyouxiao" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${sijiPage.fyouxiao}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">有效期至</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								驾驶证号:
							</label>
						</td>
						<td class="value">
						    <input id="fjiashi" name="fjiashi" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${sijiPage.fjiashi}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶证号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								初次领证日期:
							</label>
						</td>
						<td class="value">
									  <input id="fchuci" name="fchuci" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${sijiPage.fchuci}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">初次领证日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								准驾车型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fzhunjia" type="checkbox"  typeGroupCode="zhunjia"   defaultVal="${sijiPage.fzhunjia}" hasLabel="false"  title="准驾车型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">准驾车型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								有效起始日期:
							</label>
						</td>
						<td class="value">
									  <input id="fyouxiao1" name="fyouxiao1" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${sijiPage.fyouxiao1}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">有效起始日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								有效期限:
							</label>
						</td>
						<td class="value">
						    <input id="fyxqixian" name="fyxqixian" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${sijiPage.fyxqixian}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">有效期限</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								档案编号:
							</label>
						</td>
						<td class="value" colspan="3">
						    <input id="fdangan" name="fdangan" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${sijiPage.fdangan}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">档案编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								记录:
							</label>
						</td>
						<td class="value"  colspan="3" >
							<textarea id="frecord" style="width:600px;" class="inputxt" rows="6" name="frecord"  ignore="ignore" >${sijiPage.frecord}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">记录</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								入职时间:
							</label>
						</td>
						<td class="value">
									  <input id="fruzhi" name="fruzhi" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${sijiPage.fruzhi}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">入职时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								离职时间:
							</label>
						</td>
						<td class="value">
									  <input id="flizhi" name="flizhi" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${sijiPage.flizhi}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">离职时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								驾驶证:
							</label>
						</td>
						<td class="value">
									<table id="fjsz_fileTable"></table>
										<table></table>
										<script type="text/javascript">
											var serverMsg="";
											$(function(){
												$('#fjsz').uploadify({
													buttonText:'添加图片',
													auto:false,
													progressData:'speed',
													multi:true,
													height:25,
													overrideEvents:['onDialogClose'],
													fileTypeDesc:'文件格式:',
													queueID:'filediv_fjsz',
													fileSizeLimit:'15MB',
													swf:'plug-in/uploadify/uploadify.swf',	
													uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
													onUploadStart : function(file) { 
														var cgFormId=$("input[name='id']").val();
														$('#fjsz').uploadify("settings", "formData", {
															'cgFormId':cgFormId,
															'cgFormName':'z_siji',
															'cgFormField':'FJSZ'
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
										<span id="file_uploadspan"><input type="file" name="fjsz" id="fjsz" /></span> 
										<div class="form" id="filediv_fjsz"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶证</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								身份证:
							</label>
						</td>
						<td class="value">
									<table id="fsfz_fileTable"></table>
										<table></table>
										<script type="text/javascript">
											var serverMsg="";
											$(function(){
												$('#fsfz').uploadify({
													buttonText:'添加图片',
													auto:false,
													progressData:'speed',
													multi:true,
													height:25,
													overrideEvents:['onDialogClose'],
													fileTypeDesc:'文件格式:',
													queueID:'filediv_fsfz',
													fileSizeLimit:'15MB',
													swf:'plug-in/uploadify/uploadify.swf',	
													uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
													onUploadStart : function(file) { 
														var cgFormId=$("input[name='id']").val();
														$('#fsfz').uploadify("settings", "formData", {
															'cgFormId':cgFormId,
															'cgFormName':'z_siji',
															'cgFormField':'FSFZ'
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
										<span id="file_uploadspan"><input type="file" name="fsfz" id="fsfz" /></span> 
										<div class="form" id="filediv_fsfz"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身份证</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								上岗证:
							</label>
						</td>
						<td class="value">
									<table id="fsgz_fileTable"></table>
										<table></table>
										<script type="text/javascript">
											var serverMsg="";
											$(function(){
												$('#fsgz').uploadify({
													buttonText:'添加图片',
													auto:false,
													progressData:'speed',
													multi:true,
													height:25,
													overrideEvents:['onDialogClose'],
													fileTypeDesc:'文件格式:',
													queueID:'filediv_fsgz',
													fileSizeLimit:'15MB',
													swf:'plug-in/uploadify/uploadify.swf',	
													uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
													onUploadStart : function(file) { 
														var cgFormId=$("input[name='id']").val();
														$('#fsgz').uploadify("settings", "formData", {
															'cgFormId':cgFormId,
															'cgFormName':'z_siji',
															'cgFormField':'FSGZ'
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
										<span id="file_uploadspan"><input type="file" name="fsgz" id="fsgz" /></span> 
										<div class="form" id="filediv_fsgz"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">上岗证</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								体检报告:
							</label>
						</td>
						<td class="value">
									<table id="ftjbg_fileTable"></table>
										<table></table>
										<script type="text/javascript">
											var serverMsg="";
											$(function(){
												$('#ftjbg').uploadify({
													buttonText:'添加图片',
													auto:false,
													progressData:'speed',
													multi:true,
													height:25,
													overrideEvents:['onDialogClose'],
													fileTypeDesc:'文件格式:',
													queueID:'filediv_ftjbg',
													fileSizeLimit:'15MB',
													swf:'plug-in/uploadify/uploadify.swf',	
													uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
													onUploadStart : function(file) { 
														var cgFormId=$("input[name='id']").val();
														$('#ftjbg').uploadify("settings", "formData", {
															'cgFormId':cgFormId,
															'cgFormName':'z_siji',
															'cgFormField':'FTJBG'
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
										<span id="file_uploadspan"><input type="file" name="ftjbg" id="ftjbg" /></span> 
										<div class="form" id="filediv_ftjbg"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">体检报告</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								培训证书:
							</label>
						</td>
						<td class="value">
									<table id="fpxzs_fileTable"></table>
										<table></table>
										<script type="text/javascript">
											var serverMsg="";
											$(function(){
												$('#fpxzs').uploadify({
													buttonText:'添加图片',
													auto:false,
													progressData:'speed',
													multi:true,
													height:25,
													overrideEvents:['onDialogClose'],
													fileTypeDesc:'文件格式:',
													queueID:'filediv_fpxzs',
													fileSizeLimit:'15MB',
													swf:'plug-in/uploadify/uploadify.swf',	
													uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
													onUploadStart : function(file) { 
														var cgFormId=$("input[name='id']").val();
														$('#fpxzs').uploadify("settings", "formData", {
															'cgFormId':cgFormId,
															'cgFormName':'z_siji',
															'cgFormField':'FPXZS'
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
										<span id="file_uploadspan"><input type="file" name="fpxzs" id="fpxzs" /></span> 
										<div class="form" id="filediv_fpxzs"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">培训证书</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								意外险:
							</label>
						</td>
						<td class="value">
									<table id="fywx_fileTable"></table>
										<table></table>
										<script type="text/javascript">
											var serverMsg="";
											$(function(){
												$('#fywx').uploadify({
													buttonText:'添加图片',
													auto:false,
													progressData:'speed',
													multi:true,
													height:25,
													overrideEvents:['onDialogClose'],
													fileTypeDesc:'文件格式:',
													queueID:'filediv_fywx',
													fileSizeLimit:'15MB',
													swf:'plug-in/uploadify/uploadify.swf',	
													uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
													onUploadStart : function(file) { 
														var cgFormId=$("input[name='id']").val();
														$('#fywx').uploadify("settings", "formData", {
															'cgFormId':cgFormId,
															'cgFormName':'z_siji',
															'cgFormField':'FYWX'
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
										<span id="file_uploadspan"><input type="file" name="fywx" id="fywx" /></span> 
										<div class="form" id="filediv_fywx"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">意外险</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/siji/siji.js"></script>		
	  	<script type="text/javascript">
		  	//加载 已存在的 文件
		  	$(function(){
		  		var cgFormId=$("input[name='id']").val();
		  		$.ajax({
		  		   type: "post",
		  		   url: "sijiController.do?getFiles&id=" +  cgFormId,
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
					$('#fjsz').uploadify('upload', '*');	
					$('#fsfz').uploadify('upload', '*');	
					$('#fsgz').uploadify('upload', '*');	
					$('#ftjbg').uploadify('upload', '*');	
					$('#fpxzs').uploadify('upload', '*');	
					$('#fywx').uploadify('upload', '*');	
			}
			
			var neibuClickFlag = false;
			function neibuClick() {
				neibuClickFlag = true; 
				$('#btn_sub').trigger('click');
			}
			function cancel() {
					$('#fjsz').uploadify('cancel', '*');	
					$('#fsfz').uploadify('cancel', '*');	
					$('#fsgz').uploadify('cancel', '*');	
					$('#ftjbg').uploadify('cancel', '*');	
					$('#fpxzs').uploadify('cancel', '*');	
					$('#fywx').uploadify('cancel', '*');	
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
