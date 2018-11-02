<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>汇率</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="erateController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${eratePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								源币种:
							</label>
						</td>
						<td class="value">
						    <input id="fsourceCurrency" name="fsourceCurrency" onclick="popupClick(this,'fname','fsourceCurrency','currency');" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eratePage.fsourceCurrency}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">源币种</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								目标币种:
							</label>
						</td>
						<td class="value">
						    <input id="ftargetCurrency" name="ftargetCurrency" onclick="popupClick(this,'fname','ftargetCurrency','currency');" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eratePage.ftargetCurrency}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">目标币种</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								汇率:
							</label>
						</td>
						<td class="value">
						    <input id="frate" name="frate" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${eratePage.frate}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">汇率</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								生效日期:
							</label>
						</td>
						<td class="value">
									  <input id="feffectiveDate" name="feffectiveDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${eratePage.feffectiveDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生效日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								失效日期:
							</label>
						</td>
						<td class="value">
									  <input id="fexpiryDate" name="fexpiryDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${eratePage.fexpiryDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">失效日期</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								附加说明:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="finstruction" style="width:600px;" class="inputxt" rows="6" name="finstruction"  ignore="ignore" >${eratePage.finstruction}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">附加说明</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/erate/erate.js"></script>		
