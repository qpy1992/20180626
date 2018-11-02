<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>从业证件</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zZhengjianController.do?doUpdate&pid=${pid }" >
					<input id="id" name="id" type="hidden" value="${zZhengjianPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								从业证件名称:
							</label>
						</td>
						<td class="value">
						    <input id="fname" name="fname" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zZhengjianPage.fname}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">从业证件名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								证件号码:
							</label>
						</td>
						<td class="value">
						    <input id="zhengjianNo" name="zhengjianNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zZhengjianPage.zhengjianNo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证件号码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								发证机关:
							</label>
						</td>
						<td class="value">
						    <input id="issuingAuthority" name="issuingAuthority" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zZhengjianPage.issuingAuthority}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发证机关</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								颁发日期:
							</label>
						</td>
						<td class="value">
						    <input id="time" name="time" type="text" style="width: 150px" class="Wdate"  onClick="WdatePicker()" ignore="ignore"  value='${zZhengjianPage.time}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">颁发日期</label>
						</td>
					</tr>
					<%-- <tr>
						<td align="right">
							<label class="Validform_label">
								人员id:
							</label>
						</td>
						<td class="value">
						    <input id="pid" name="pid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zZhengjianPage.pid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">人员id</label>
						</td>
					</tr>
				 --%>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/zzhengjian/zZhengjian.js"></script>		
