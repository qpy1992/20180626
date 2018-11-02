<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>门点联系人</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" tiptype="1" layout="table" action="doorPointController.do?doUpdate1" >
					<input id="id" name="id" type="hidden" value="${dpContactPage.id }"/>
					<input id="fid" name="fid" type="hidden" value="${dpContactPage.fid }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								联系人名:
							</label>
						</td>
						<td class="value">
						    <input id="fcontactName" name="fcontactName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${dpContactPage.fcontactName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系人名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fgender" type="list"  typeGroupCode="sex"   defaultVal="${dpContactPage.fgender}" hasLabel="false"  title="性别" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								电话:
							</label>
						</td>
						<td class="value">
						    <input id="fphone" name="fphone" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${dpContactPage.fphone}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">电话</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								手机:
							</label>
						</td>
						<td class="value">
						    <input id="fmobile" name="fmobile" type="text" style="width: 150px" class="inputxt" 		datatype="m" ignore="ignore"  value='${dpContactPage.fmobile}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手机</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								传真:
							</label>
						</td>
						<td class="value">
						    <input id="fax" name="fax" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${dpContactPage.fax}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">传真</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								邮箱:
							</label>
						</td>
						<td class="value">
						    <input id="femail" name="femail" type="text" style="width: 150px" class="inputxt" 		datatype="e" ignore="ignore"  value='${dpContactPage.femail}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">邮箱</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/dpcontact/dpContact.js"></script>		
