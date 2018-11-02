<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>调度日记</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="schdailyController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${schdailyPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							托运单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="ftuoyun" name="ftuoyun" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">托运单位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							派车单号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fpaicheno" name="fpaicheno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">派车单号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							提箱点:
						</label>
					</td>
					<td class="value">
					     	 <input id="ftxyard" name="ftxyard" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提箱点</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							装货时间:
						</label>
					</td>
					<td class="value">
							   <input id="fzhtime" name="fzhtime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装货时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							装货门点:
						</label>
					</td>
					<td class="value">
					     	 <input id="fzhaddress" name="fzhaddress" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装货门点</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							卸货时间:
						</label>
					</td>
					<td class="value">
							   <input id="fxhtime" name="fxhtime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">卸货时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							卸货门点:
						</label>
					</td>
					<td class="value">
					     	 <input id="fxhaddress" name="fxhaddress" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">卸货门点</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							换箱点:
						</label>
					</td>
					<td class="value">
					     	 <input id="fhxyard" name="fhxyard" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">换箱点</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							箱量:
						</label>
					</td>
					<td class="value">
					     	 <input id="fboxamount" name="fboxamount" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱量</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							箱号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fboxno" name="fboxno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱号</label>
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
							挂车号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fguano" name="fguano" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">挂车号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							司机:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdriver" name="fdriver" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">司机</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							额外费用:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbudget" name="fbudget" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">额外费用</label>
						</td>
					</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value"  colspan="3" >
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="fnote" name="fnote"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/schdaily/schdaily.js"></script>		
