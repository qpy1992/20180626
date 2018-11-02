<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>港口</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="portController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${portPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="center" colspan="4">
							<label class="Validform_label" style="font-weight: bold;font-size: 14px">
                                ---------------基本信息---------------
                            </label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								港口代码:
							</label>
						</td>
						<td class="value" colspan="3">
						    <input id="fportCode" name="fportCode" type="text" style="width: 150px;display: none" class="inputxt"  ignore="ignore"  value='${portPage.fportCode}'/>
                            <label class="Validform_label" style="font-size: 16px;font-weight: bold;color: #0a82eb">${portPage.fportCode}</label>
						</td>
                    </tr>
                    <tr>
						<td align="right">
							<label class="Validform_label">
								国家代码:
							</label>
						</td>
						<td class="value">
						    <input id="fcountryCode" name="fcountryCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${portPage.fcountryCode}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">国家代码</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								港口名称:
							</label>
						</td>
						<td class="value">
						    <input id="fportName" name="fportName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${portPage.fportName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">港口名称</label>
						</td>
                    </tr>
                    <tr>
						<td align="right">
							<label class="Validform_label">
								中文名:
							</label>
						</td>
						<td class="value">
						    <input id="fcnName" name="fcnName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${portPage.fcnName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">中文名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								所属港口:
							</label>
						</td>
						<td class="value">
						    <input id="fbelong" name="fbelong" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${portPage.fbelong}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属港口</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								数字码:
							</label>
						</td>
						<td class="value">
						    <input id="fnumberCode" name="fnumberCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${portPage.fnumberCode}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">数字码</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								海关码:
							</label>
						</td>
						<td class="value">
						    <input id="fcustomsCode" name="fcustomsCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${portPage.fcustomsCode}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">海关码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								AMS码:
							</label>
						</td>
						<td class="value">
						    <input id="fams" name="fams" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${portPage.fams}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">AMS码</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								EDI代码:
							</label>
						</td>
						<td class="value">
						    <input id="fedi" name="fedi" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${portPage.fedi}'/>
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
						    <input id="fedi2" name="fedi2" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${portPage.fedi2}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">EDI代码2</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								EDI代码3:
							</label>
						</td>
						<td class="value">
						    <input id="fedi3" name="fedi3" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${portPage.fedi3}'/>
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
				<td class="value"  colspan="3" >
					<textarea id="finstruction" style="width:600px;" class="inputxt" rows="6" name="finstruction"  ignore="ignore" >${portPage.finstruction}</textarea>
					<span class="Validform_checktip"></span>
					<label class="Validform_label" style="display: none;">附加说明</label>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="4">
					<label class="Validform_label" style="font-weight: bold;font-size: 14px">
                        ---------------港口类型---------------
                    </label>
				</td>
			</tr>
					<tr>
						<td align="center" class="value" colspan="4">
                            <t:dictSelect field="fportType" type="checkbox"  typeGroupCode="port"   defaultVal="${portPage.fportType}" hasLabel="false"  title="港口类型" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">港口类型</label>
						</td>
					</tr>
				

			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/port/port.js"></script>		
