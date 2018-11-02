<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>车辆保险</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="insuranceController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${insurancePage.id }"/>
		<table style="width: 900px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								车号:
							</label>
						</td>
						<td class="value">
						    <input id="fbillno" name="fbillno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${insurancePage.fbillno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								座位:
							</label>
						</td>
						<td class="value">
						    <input id="fseat" name="fseat" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${insurancePage.fseat}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">座位</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								车船险:
							</label>
						</td>
						<td class="value">
						    <input id="fcarInsu" name="fcarInsu" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${insurancePage.fcarInsu}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车船险</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								交强险:
							</label>
						</td>
						<td class="value">
						    <input id="fstrongInsu" name="fstrongInsu" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${insurancePage.fstrongInsu}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">交强险</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								交强险优惠:
							</label>
						</td>
						<td class="value">
						    <input id="fdiscount" name="fdiscount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${insurancePage.fdiscount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">交强险优惠</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								交强险保单号:
							</label>
						</td>
						<td class="value">
						    <input id="fstrongno" name="fstrongno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${insurancePage.fstrongno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">交强险保单号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开始日期:
							</label>
						</td>
						<td class="value">
									  <input id="fstartdate" name="fstartdate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${insurancePage.fstartdate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开始日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								结束日期:
							</label>
						</td>
						<td class="value">
									  <input id="fenddate" name="fenddate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${insurancePage.fenddate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结束日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								承运险:
							</label>
						</td>
						<td class="value">
						    <input id="ftransrisk" name="ftransrisk" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${insurancePage.ftransrisk}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">承运险</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								承运险优惠:
							</label>
						</td>
						<td class="value">
						    <input id="ftransdiscount" name="ftransdiscount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${insurancePage.ftransdiscount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">承运险优惠</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								承运险保单号:
							</label>
						</td>
						<td class="value">
						    <input id="ftransno" name="ftransno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${insurancePage.ftransno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">承运险保单号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								开始日期2:
							</label>
						</td>
						<td class="value">
									  <input id="fstart2" name="fstart2" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${insurancePage.fstart2}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开始日期2</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								结束日期2:
							</label>
						</td>
						<td class="value">
									  <input id="fend2" name="fend2" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${insurancePage.fend2}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结束日期2</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								三者险:
							</label>
						</td>
						<td class="value">
						    <input id="fsan" name="fsan" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${insurancePage.fsan}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">三者险</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								车损险:
							</label>
						</td>
						<td class="value">
						    <input id="fchesun" name="fchesun" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${insurancePage.fchesun}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车损险</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								玻璃险:
							</label>
						</td>
						<td class="value">
						    <input id="fboli" name="fboli" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${insurancePage.fboli}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">玻璃险</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								不计免赔:
							</label>
						</td>
						<td class="value">
						    <input id="fmianpei" name="fmianpei" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${insurancePage.fmianpei}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">不计免赔</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								商业险优惠:
							</label>
						</td>
						<td class="value">
						    <input id="fbussdiscount" name="fbussdiscount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${insurancePage.fbussdiscount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商业险优惠</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								商业险保单号:
							</label>
						</td>
						<td class="value">
						    <input id="fbussno" name="fbussno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${insurancePage.fbussno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商业险保单号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								开始日期3:
							</label>
						</td>
						<td class="value">
									  <input id="fstart3" name="fstart3" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${insurancePage.fstart3}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开始日期3</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								结束日期3:
							</label>
						</td>
						<td class="value">
									  <input id="fend3" name="fend3" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${insurancePage.fend3}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结束日期3</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								保费合计:
							</label>
						</td>
						<td class="value">
						    <input id="ftotal" name="ftotal" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${insurancePage.ftotal}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">保费合计</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								承保公司:
							</label>
						</td>
						<td class="value" colspan="3">
						    <input id="fchengbao" name="fchengbao" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${insurancePage.fchengbao}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">承保公司</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value"  colspan="5" >
						  	 	<textarea id="fnote" style="width:600px;" class="inputxt" rows="6" name="fnote"  ignore="ignore" >${insurancePage.fnote}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/insurance/insurance.js"></script>		
