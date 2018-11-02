<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>安全学习考核</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="secuController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${secuPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							活动时间起:
						</label>
					</td>
					<td class="value">
							   <input id="fstart" name="fstart" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动时间起</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							活动时间止:
						</label>
					</td>
					<td class="value">
							   <input id="fend" name="fend" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动时间止</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							驾驶员:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdriver" name="fdriver" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶员</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							学习状态:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="fstudyStatus" type="list"  typeGroupCode="study"  defaultVal="${secuPage.fstudyStatus}" hasLabel="false"  title="学习状态" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学习状态</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/secu/secu.js"></script>		
