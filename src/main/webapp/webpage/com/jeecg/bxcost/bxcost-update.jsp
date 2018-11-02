<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>报销单费用</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="bxcostController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${bxcostPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								委托单号:
							</label>
						</td>
						<td class="value">
						    <input id="fweituo" name="fweituo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bxcostPage.fweituo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">委托单号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								提单号:
							</label>
						</td>
						<td class="value">
						    <input id="fbrno" name="fbrno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bxcostPage.fbrno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提单号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								费用种类:
							</label>
						</td>
						<td class="value">
						    <input id="fcost" name="fcost" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bxcostPage.fcost}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用种类</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								结算单位代码:
							</label>
						</td>
						<td class="value">
						    <input id="fsettle" name="fsettle" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bxcostPage.fsettle}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结算单位代码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								结算单位名称:
							</label>
						</td>
						<td class="value">
						    <input id="fsettlename" name="fsettlename" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bxcostPage.fsettlename}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结算单位名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								派车单号:
							</label>
						</td>
						<td class="value">
						    <input id="fpaiche" name="fpaiche" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bxcostPage.fpaiche}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">派车单号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								箱号:
							</label>
						</td>
						<td class="value">
						    <input id="fboxno" name="fboxno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bxcostPage.fboxno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								金额:
							</label>
						</td>
						<td class="value">
						    <input id="famount" name="famount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${bxcostPage.famount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								收付金额:
							</label>
						</td>
						<td class="value">
						    <input id="fsfamount" name="fsfamount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${bxcostPage.fsfamount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收付金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								代垫:
							</label>
						</td>
						<td class="value">
						    <input id="fdaidian" name="fdaidian" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bxcostPage.fdaidian}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代垫</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								附加说明:
							</label>
						</td>
						<td class="value">
						    <input id="finstruction" name="finstruction" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bxcostPage.finstruction}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">附加说明</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/bxcost/bxcost.js"></script>		
