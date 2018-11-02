<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>币种维护</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="currencyController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${currencyPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								币种代码:
							</label>
						</td>
						<td class="value">
						    <input id="fcurrencyid" name="fcurrencyid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${currencyPage.fcurrencyid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">币种代码</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								有效:
							</label>
						</td>
						<td class="value">
							<t:dictSelect field="fyouxiao"  typeGroupCode="sf_yn"  defaultVal="${currencyPage.fyouxiao}" hasLabel="false"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">有效</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								本位币:
							</label>
						</td>
						<td class="value" colspan="3">
							<t:dictSelect field="fbenwei"  typeGroupCode="sf_yn"  defaultVal="${currencyPage.fbenwei}" hasLabel="false"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本位币</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								币种名称:
							</label>
						</td>
						<td class="value">
						    <input id="fname" name="fname" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${currencyPage.fname}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">币种名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								符号:
							</label>
						</td>
						<td class="value">
						    <input id="fsymbol" name="fsymbol" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${currencyPage.fsymbol}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">符号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								国家代码:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fcountryCode" type="list"  typeGroupCode="country"   defaultVal="${currencyPage.fcountryCode}" hasLabel="false"  title="国家代码" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">国家代码</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								EDI代码:
							</label>
						</td>
						<td class="value">
						    <input id="fedi" name="fedi" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${currencyPage.fedi}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">EDI代码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								EDI代码2:
							</label>
						</td>
						<td class="value">
						    <input id="fedi2" name="fedi2" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${currencyPage.fedi2}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">EDI代码2</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								EDI代码3:
							</label>
						</td>
						<td class="value">
						    <input id="fedi3" name="fedi3" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${currencyPage.fedi3}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">EDI代码3</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								附加说明:
							</label>
						</td>
						<td class="value" colspan="3">
						  	 	<textarea id="finstruction" style="width:550px;height: 80px" class="inputxt" rows="6" name="finstruction"  ignore="ignore" >${currencyPage.finstruction}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">附加说明</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/currency/currency.js"></script>		
