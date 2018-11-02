<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>奖惩</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zJiangchengController.do?doAdd&pid=${pid }" >
					<input id="id" name="id" type="hidden" value="${zJiangchengPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							日期:
						</label>
					</td>
					<td class="value">
					     	 <input id="time" name="time" type="text" style="width: 150px" class="Wdate"  onClick="WdatePicker()"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">日期</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							奖惩原因:
						</label>
					</td>
					<td class="value">
					     	 <input id="reason" name="reason" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">奖惩原因</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							奖惩记录:
						</label>
					</td>
					<td class="value">
					     	 <input id="record" name="record" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">奖惩记录</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							奖惩部门:
						</label>
					</td>
					<td class="value">
					     	 <input id="department" name="department" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">奖惩部门</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/zjiangcheng/zJiangcheng.js"></script>		
