<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>箱货明细</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="detailController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${detailPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							提单号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbillno" name="fbillno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提单号</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							货名:
						</label>
					</td>
					<td class="value">
					     	 <input id="fname" name="fname" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">货名</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							唛头:
						</label>
					</td>
					<td class="value">
					     	 <input id="fmaitou" name="fmaitou" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">唛头</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							包装:
						</label>
					</td>
					<td class="value">
					     	 <input id="fpackage" name="fpackage" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">包装</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							件数:
						</label>
					</td>
					<td class="value">
					     	 <input id="fqty" name="fqty" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">件数</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							毛重:
						</label>
					</td>
					<td class="value">
					     	 <input id="fgross" name="fgross" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">毛重</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/detail/detail.js"></script>		
