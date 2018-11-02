<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>驾驶人</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zDriverController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${zDriverPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							驾驶人:
						</label>
					</td>
					<td class="value">
					     	 <input id="fname" name="fname" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶人</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							驾驶证号:
						</label>
					</td>
					<td class="value">
					     	 <input id="licenseNumber" name="licenseNumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶证号</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							准驾车型:
						</label>
					</td>
					<td class="value">
					     	 <input id="carType" name="carType" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">准驾车型</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否沪籍:
						</label>
					</td>
					<td class="value">
					     	 <input id="ishu" name="ishu" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否沪籍</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							初领日期:
						</label>
					</td>
					<td class="value">
					     	 <input id="initialDate" name="initialDate" type="text" style="width: 150px" class="Wdate"  onClick="WdatePicker()"   ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">初领日期</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							有效日期:
						</label>
					</td>
					<td class="value">
					     	 <input id="effectiveDate" name="effectiveDate" type="text" style="width: 150px" class="Wdate"  onClick="WdatePicker()"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">有效日期</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							手机号:
						</label>
					</td>
					<td class="value">
					     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手机号</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="address" name="address" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">地址</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							离职日期:
						</label>
					</td>
					<td class="value">
					     	 <input id="departureDate" name="departureDate" type="text" style="width: 150px" class="Wdate"  onClick="WdatePicker()"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">离职日期</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							信息维护员:
						</label>
					</td>
					<td class="value">
					     	 <input id="fpeople" name="fpeople" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">信息维护员</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/zdriver/zDriver.js"></script>		
