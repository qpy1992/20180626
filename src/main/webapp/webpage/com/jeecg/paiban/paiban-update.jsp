<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>计划排班</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="paibanController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${paibanPage.id }"/>
		<table style="width: 700px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								车辆代码:
							</label>
						</td>
						<td class="value">
						    <input id="fcarcode" name="fcarcode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.fcarcode}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车辆代码</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								车号:
							</label>
						</td>
						<td class="value">
						    <input id="fcarno" name="fcarno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.fcarno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								外部车:
							</label>
						</td>
						<td class="value">
						    <input id="foutercar" name="foutercar" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.foutercar}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">外部车</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								车主:
							</label>
						</td>
						<td class="value">
						    <input id="fdriver" name="fdriver" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.fdriver}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车主</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								派车单号:
							</label>
						</td>
						<td class="value">
						    <input id="fbillno1" name="fbillno1" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.fbillno1}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">派车单号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								详细地址:
							</label>
						</td>
						<td class="value">
						    <input id="faddress1" name="faddress1" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.faddress1}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">详细地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								预计返回时间:
							</label>
						</td>
						<td class="value">
						    <input id="fbackTime1" name="fbackTime1" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.fbackTime1}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预计返回时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								派车单号:
							</label>
						</td>
						<td class="value">
						    <input id="fbillno2" name="fbillno2" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.fbillno2}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">派车单号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								详细地址:
							</label>
						</td>
						<td class="value">
						    <input id="faddress2" name="faddress2" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.faddress2}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">详细地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								预计返回时间:
							</label>
						</td>
						<td class="value">
									   <input id="fbackTime2" name="fbackTime2" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${paibanPage.fbackTime2}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预计返回时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								派车单号:
							</label>
						</td>
						<td class="value">
						    <input id="fbillno3" name="fbillno3" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.fbillno3}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">派车单号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								详细地址:
							</label>
						</td>
						<td class="value">
						    <input id="faddress3" name="faddress3" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.faddress3}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">详细地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								预计返回时间:
							</label>
						</td>
						<td class="value">
									   <input id="fbackTime3" name="fbackTime3" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${paibanPage.fbackTime3}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预计返回时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								派车单号:
							</label>
						</td>
						<td class="value">
						    <input id="fbillno4" name="fbillno4" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.fbillno4}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">派车单号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								详细地址:
							</label>
						</td>
						<td class="value">
						    <input id="faddress4" name="faddress4" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.faddress4}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">详细地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								预计返回时间:
							</label>
						</td>
						<td class="value">
									   <input id="fbackTime4" name="fbackTime4" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${paibanPage.fbackTime4}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预计返回时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								派车单号:
							</label>
						</td>
						<td class="value">
						    <input id="fbillno5" name="fbillno5" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.fbillno5}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">派车单号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								详细地址:
							</label>
						</td>
						<td class="value">
						    <input id="faddress5" name="faddress5" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paibanPage.faddress5}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">详细地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								预计返回时间:
							</label>
						</td>
						<td class="value">
									   <input id="fbackTime5" name="fbackTime5" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${paibanPage.fbackTime5}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预计返回时间</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/paiban/paiban.js"></script>		
