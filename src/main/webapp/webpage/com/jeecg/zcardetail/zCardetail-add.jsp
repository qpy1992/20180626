<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>机动车基本信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zCardetailController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${zCardetailPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							车辆号牌:
						</label>
					</td>
					<td class="value">
					     	 <input id="carno" name="carno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车辆号牌</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							车辆类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="cartype" name="cartype" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车辆类型</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							管辖区县:
						</label>
					</td>
					<td class="value">
					     	 <input id="area" name="area" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管辖区县</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							车次登记时间:
						</label>
					</td>
					<td class="value">
							   <input id="time" name="time" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车次登记时间</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							安检有效日期:
						</label>
					</td>
					<td class="value">
							   <input id="effectiveDate" name="effectiveDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安检有效日期</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							退出日期:
						</label>
					</td>
					<td class="value">
							   <input id="exitDate" name="exitDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">退出日期</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							信息维护人员:
						</label>
					</td>
					<td class="value">
					     	 <input id="fpeople" name="fpeople" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">信息维护人员</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/zcardetail/zCardetail.js"></script>		
