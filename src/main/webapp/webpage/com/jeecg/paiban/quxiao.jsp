<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>预计回程时间</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="paibanController.do?doQuxiao&id=${id}" >
		<table style="width: 300px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							班次:
						</label>
					</td>
					<td class="value">
						<input type="checkbox" name="times" value ="1">头班
						<input type="checkbox" name="times" value ="2">二班
						<input type="checkbox" name="times" value ="3">三班<br>
						<input type="checkbox" name="times" value ="4">四班
						<input type="checkbox" name="times" value ="5">五班
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
