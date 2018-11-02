<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>交通违法排查督办</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zBreaklawController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${zBreaklawPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								日期:
							</label>
						</td>
						<td class="value">
									  <input id="time" name="time" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='${zBreaklawPage.time}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								驾驶人总数:
							</label>
						</td>
						<td class="value">
						    <input id="driverNumber" name="driverNumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zBreaklawPage.driverNumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶人总数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								违反次数:
							</label>
						</td>
						<td class="value">
						    <input id="number" name="number" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zBreaklawPage.number}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">违反次数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								违法率:
							</label>
						</td>
						<td class="value">
						    <input id="rate" name="rate" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zBreaklawPage.rate}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">违法率</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								违法分类:
							</label>
						</td>
						<td class="value">
						   <%--  <input id="ftype" name="ftype" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zBreaklawPage.ftype}'/> --%>
							<t:dictSelect field="ftype" type="list"  typeGroupCode="law" hasLabel="false" title="违法" defaultVal="${zBreaklawPage.ftype}"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">违法分类</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								累计违法次数:
							</label>
						</td>
						<td class="value">
						    <input id="allratenumber" name="allratenumber" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${zBreaklawPage.allratenumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">累计违法次数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								当月已处理次数:
							</label>
						</td>
						<td class="value">
						    <input id="dealnumber" name="dealnumber" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${zBreaklawPage.dealnumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">当月已处理次数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								累计已处理次数:
							</label>
						</td>
						<td class="value">
						    <input id="alldealnumber" name="alldealnumber" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${zBreaklawPage.alldealnumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">累计已处理次数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						    <input id="note" name="note" type="text" style="width: 450px" class="inputxt"  ignore="ignore"  value='${zBreaklawPage.note}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/zbreaklaw/zBreaklaw.js"></script>		
