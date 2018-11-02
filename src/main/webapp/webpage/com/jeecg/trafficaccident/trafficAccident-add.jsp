<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>交通事故处理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="trafficAccidentController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${trafficAccidentPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							流水编码:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbillno" name="fbillno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">流水编码</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							路段等级:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="fgrade" type="list"  typeGroupCode="grades"  defaultVal="${trafficAccidentPage.fgrade}" hasLabel="false"  title="路段等级" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">路段等级</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							车号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcarno" name="fcarno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							出险类别:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="fcxtype" type="list"  typeGroupCode="chuxian"  defaultVal="${trafficAccidentPage.fcxtype}" hasLabel="false"  title="出险类别" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出险类别</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							驾驶员:
						</label>
					</td>
					<td class="value">
					     	 <input id="fname" name="fname" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶员</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							责任划分:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="frespon" type="list"  typeGroupCode="zeren"  defaultVal="${trafficAccidentPage.frespon}" hasLabel="false"  title="责任划分" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任划分</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出险时间:
						</label>
					</td>
					<td class="value">
							   <input id="fchuxianTime" name="fchuxianTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出险时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							事故级别:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="fsggrade" type="list"  typeGroupCode="shigu"  defaultVal="${trafficAccidentPage.fsggrade}" hasLabel="false"  title="事故级别" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">事故级别</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出险地点:
						</label>
					</td>
					<td class="value" colspan="3">
					     	 <input id="faddress" name="faddress" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出险地点</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" colspan="3">
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="fnote" name="fnote"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/trafficaccident/trafficAccident.js"></script>		
