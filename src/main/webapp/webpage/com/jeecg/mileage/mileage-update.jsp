<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>里程数</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="mileageController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${mileagePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								区域:
							</label>
						</td>
						<td class="value">
						    <input id="fdparea" name="fdparea" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${mileagePage.fdparea}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">区域</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								里程数:
							</label>
						</td>
						<td class="value">
						    <input id="fmileage" name="fmileage" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${mileagePage.fmileage}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">里程数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								里程类型:
							</label>
						</td>
						<td class="value">
						    <input id="fmitype" name="fmitype" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${mileagePage.fmitype}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">里程类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								顺序:
							</label>
						</td>
						<td class="value">
						    <input id="forder" name="forder" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${mileagePage.forder}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">顺序</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								空驶里程:
							</label>
						</td>
						<td class="value">
						    <input id="fkong" name="fkong" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${mileagePage.fkong}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">空驶里程</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								空箱里程:
							</label>
						</td>
						<td class="value">
						    <input id="fkongxiang" name="fkongxiang" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${mileagePage.fkongxiang}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">空箱里程</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								重箱里程:
							</label>
						</td>
						<td class="value">
						    <input id="fzhong" name="fzhong" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${mileagePage.fzhong}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">重箱里程</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								补贴里程:
							</label>
						</td>
						<td class="value">
						    <input id="fbutie" name="fbutie" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${mileagePage.fbutie}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">补贴里程</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								总里程:
							</label>
						</td>
						<td class="value">
						    <input id="ftotal" name="ftotal" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${mileagePage.ftotal}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">总里程</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								额定油耗:
							</label>
						</td>
						<td class="value">
						    <input id="feding" name="feding" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${mileagePage.feding}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">额定油耗</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/mileage/mileage.js"></script>		
