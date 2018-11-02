<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>应付账单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="paysController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${paysPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<%--<tr>
					<td align="right">
						<label class="Validform_label">
							对账单号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbillno" name="fbillno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">对账单号</label>
						</td>
				</tr>--%>
				<tr>
					<td align="right">
						<label class="Validform_label">
							对账单位代码:
						</label>
					</td>
					<td class="value">
						<input id="funitcode" name="funitcode" onclick="popupClick(this,'fcustom_code,fcn_name','funitcode,funit','gys');" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">对账单位代码</label>
					</td>
					<td align="right">
						<label class="Validform_label">
							对账单位名称:
						</label>
					</td>
					<td class="value">
						<input id="funit" name="funit" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">对账单位名称</label>
					</td>
				</tr>
				<tr hidden="hidden">
					<td align="right">
						<label class="Validform_label">
							币别:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbibie" name="fbibie" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">币别</label>
						</td>
				</tr>
				<tr hidden="hidden">
					<td align="right">
						<label class="Validform_label">
							金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="famount" name="famount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">金额</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							对账日期:
						</label>
					</td>
					<td class="value">
						<input id="fstartdate" name="fstartdate" type="text" style="width: 100px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
						<span class="Validform_checktip">~</span>
						<input id="fenddate" name="fenddate" type="text" style="width: 100px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
					</td>

					<td align="right">
						<label class="Validform_label">
							对账范围:
						</label>
					</td>
					<td class="value">
						<input id="frange" name="frange" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">对账范围</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" colspan="3">
						  	 <textarea style="width:560px;height: 80px" class="inputxt" rows="6" id="fnote" name="fnote"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/pays/pays.js"></script>		
