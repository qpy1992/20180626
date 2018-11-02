<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>路径规划</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="routeController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${routePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								起点:
							</label>
						</td>
						<td class="value">
						    <input id="fstart" name="fstart" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${routePage.fstart}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">起点</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								终点:
							</label>
						</td>
						<td class="value">
						    <input id="fend" name="fend" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${routePage.fend}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">终点</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/route/route.js"></script>		
