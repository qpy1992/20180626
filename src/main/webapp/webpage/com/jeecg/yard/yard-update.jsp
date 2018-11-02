<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>堆场</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="yardController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${yardPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
                    <tr>
                        <td align="right">
                            <label class="Validform_label">
                                类型:
                            </label>
                        </td>
                        <td class="value">
                            <t:dictSelect field="ftype" typeGroupCode="yard" hasLabel="false" defaultVal="${yardPage.ftype}"></t:dictSelect>
                        </td>
                    </tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								代码:
							</label>
						</td>
						<td class="value">
						    <input id="fyardCode" name="fyardCode" type="text" style="width: 150px;display: none" class="inputxt"  ignore="ignore"  value='${yardPage.fyardCode}'/>
                            <label class="Validform_label" style="font-size: 16px;font-weight: bold;color: #0a82eb">${yardPage.fyardCode}</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								名称:
							</label>
						</td>
						<td class="value">
						    <input id="fyardName" name="fyardName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${yardPage.fyardName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								客户名称:
							</label>
						</td>
						<td class="value">
						    <input id="fportCode" name="fportCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${yardPage.fportCode}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								附加说明:
							</label>
						</td>
						<td class="value">
							<textarea id="finstruction" style="width:300px;height:100px" class="inputxt" rows="6" name="finstruction"  ignore="ignore" >${yardPage.finstruction}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">附加说明</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/yard/yard.js"></script>		
