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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="paibanController.do?paiban&contianerId=${contianerId}&entrustId=${entrustId}&vehId=${vehId}" >
		<table style="width: 300px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							预计回程时间:
						</label>
					</td>
					<td class="value">
						<input id="fbacktime" name="fbacktime" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text" style="width: 150px"  ignore="ignore" />
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
