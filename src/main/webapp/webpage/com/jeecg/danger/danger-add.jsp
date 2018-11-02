<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>危险品资料</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="dangerController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${dangerPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							货物代码:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcode" name="fcode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">货物代码</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							品名:
						</label>
					</td>
					<td class="value">
					     	 <input id="fname" name="fname" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">品名</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							危险品卡号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcardno" name="fcardno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">危险品卡号</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							等级:
						</label>
					</td>
					<td class="value">
					     	 <input id="fgrade" name="fgrade" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">等级</label>
						</td>
				</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							附加说明:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="finstruction" name="finstruction"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">附加说明</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/danger/danger.js"></script>		
