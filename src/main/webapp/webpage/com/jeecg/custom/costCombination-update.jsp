<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>费用组合</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" tiptype="1" layout="table" action="customController.do?doUpdate1" >
					<input id="id" name="id" type="hidden" value="${costCombinationPage.id }"/>
					<input id="fid" name="fid" type="hidden" value="${costCombinationPage.fid }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								提箱点:
							</label>
						</td>
						<td class="value">
						    <input id="ftxyard" name="ftxyard" onclick="popupClick(this,'fyard_name,id','ftxyard,ftxid','yard')" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${costCombinationPage.ftxyard}'/>
						    <input id="ftxid" name="ftxid" type="text" style="width: 150px;display: none" class="inputxt"  ignore="ignore"  value='${costCombinationPage.ftxid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提箱点</label>
						</td>

						<%--<td align="right">
							<label class="Validform_label">
								进口码头:
							</label>
						</td>
						<td class="value">
						    <input id="fimport" name="fimport" onclick="popupClick(this,'fyard_name,id','fimport,fimportid','quay')" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${costCombinationPage.fimport}'/>
						    <input id="fimportid" name="fimportid" type="text" style="width: 150px;display: none" class="inputxt"  ignore="ignore"  value='${costCombinationPage.fimportid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">进口码头</label>
						</td>
					</tr>
					<tr>--%>
						<td align="right">
							<label class="Validform_label">
								装货门点:
							</label>
						</td>
						<td class="value">
						    <input id="fload" name="fload" onclick="popupClick(this,'fname,id','fload,floadid','dp_select')" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${costCombinationPage.fload}'/>
						    <input id="floadid" name="floadid" type="text" style="width: 150px;display: none" class="inputxt"  ignore="ignore"  value='${costCombinationPage.floadid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装货门点</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								卸货门点:
							</label>
						</td>
						<td class="value">
						    <input id="fdischarge" name="fdischarge" onclick="popupClick(this,'fname,id','fdischarge,fdischargeid','dp_select')" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${costCombinationPage.fdischarge}'/>
						    <input id="fdischargeid" name="fdischargeid" type="text" style="width: 150px;display: none" class="inputxt"  ignore="ignore"  value='${costCombinationPage.fdischargeid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">卸货门点</label>
						</td>

						<%--<td align="right">
							<label class="Validform_label">
								出口码头:
							</label>
						</td>
						<td class="value">
						    <input id="fexport" name="fexport" onclick="popupClick(this,'fyard_name,id','fexport,fexportid','quay')" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${costCombinationPage.fexport}'/>
						    <input id="fexportid" name="fexportid" type="text" style="width: 150px;display: none" class="inputxt"  ignore="ignore"  value='${costCombinationPage.fexportid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出口码头</label>
						</td>--%>

                        <td align="right">
                            <label class="Validform_label">
                                还箱点:
                            </label>
                        </td>
                        <td class="value">
                            <input id="fhxyard" name="fhxyard" onclick="popupClick(this,'fyard_name,id','fhxyard,fhxid','yard')" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${costCombinationPage.fhxyard}'/>
                            <input id="fhxid" name="fhxid" type="text" style="width: 150px;display: none" class="inputxt"  ignore="ignore"  value='${costCombinationPage.fhxid}'/>
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">还箱点</label>
                        </td>
                    </tr>
                    <tr>
						<td align="right">
							<label class="Validform_label">
								费用:
							</label>
						</td>
						<td class="value">
						    <input id="fcost" name="fcost" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${costCombinationPage.fcost}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用</label>
						</td>

						<td align="right">
							<label class="Validform_label">
								含税费用:
							</label>
						</td>
						<td class="value">
						    <input id="fhscost" name="fhscost" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${costCombinationPage.fhscost}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">含税费用</label>
						</td>
                    </tr>
                    <tr>
						<td align="right">
							<label class="Validform_label">
								税率:
							</label>
						</td>
						<td class="value">
						    <input id="frate" name="frate" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${costCombinationPage.frate}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">税率</label>
						</td>

						<td align="right">
							<label class="Validform_label">
								开始时间:
							</label>
						</td>
						<td class="value">
						    <input id="fstart" name="fstart" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  value='<fmt:formatDate value='${costCombinationPage.fstart}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开始时间</label>
						</td>
                    </tr>
                    <tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value" colspan="3">
                            <textarea id="fnote" style="width:500px;height: 100px" class="inputxt" rows="6" name="fnote"  ignore="ignore" >${costCombinationPage.fnote}</textarea>
                            <span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
