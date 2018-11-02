<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>应收应付核销</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="hexiaoController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${hexiaoPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								核销金额:
							</label>
						</td>
						<td class="value">
						    <input id="fhxamount" name="fhxamount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${hexiaoPage.fhxamount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">核销金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								本次余额:
							</label>
						</td>
						<td class="value">
						    <input id="fbcamount" name="fbcamount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${hexiaoPage.fbcamount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本次余额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								实际收付金额:
							</label>
						</td>
						<td class="value">
						    <input id="factualamount" name="factualamount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${hexiaoPage.factualamount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际收付金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								金额:
							</label>
						</td>
						<td class="value">
						    <input id="famount" name="famount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${hexiaoPage.famount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								实际金额:
							</label>
						</td>
						<td class="value">
						    <input id="ftrueamount" name="ftrueamount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${hexiaoPage.ftrueamount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								代垫:
							</label>
						</td>
						<td class="value">
						    <input id="fdaidian" name="fdaidian" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${hexiaoPage.fdaidian}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代垫</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								约号:
							</label>
						</td>
						<td class="value">
						    <input id="fyuehao" name="fyuehao" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${hexiaoPage.fyuehao}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">约号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						    <input id="fnote" name="fnote" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${hexiaoPage.fnote}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								发票号:
							</label>
						</td>
						<td class="value">
						    <input id="ffapiao" name="ffapiao" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${hexiaoPage.ffapiao}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发票号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								审核:
							</label>
						</td>
						<td class="value">
						    <input id="fcheck" name="fcheck" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${hexiaoPage.fcheck}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								额定金额:
							</label>
						</td>
						<td class="value">
						    <input id="feding" name="feding" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${hexiaoPage.feding}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">额定金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								委托号:
							</label>
						</td>
						<td class="value">
						    <input id="fweituo" name="fweituo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${hexiaoPage.fweituo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">委托号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								委托单位:
							</label>
						</td>
						<td class="value">
						    <input id="fwtunit" name="fwtunit" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${hexiaoPage.fwtunit}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">委托单位</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								派车单号:
							</label>
						</td>
						<td class="value">
						    <input id="fpaiche" name="fpaiche" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${hexiaoPage.fpaiche}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">派车单号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								提单号:
							</label>
						</td>
						<td class="value">
						    <input id="ftidan" name="ftidan" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${hexiaoPage.ftidan}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提单号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								箱号:
							</label>
						</td>
						<td class="value">
						    <input id="fboxno" name="fboxno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${hexiaoPage.fboxno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱号</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/hexiao/hexiao.js"></script>		
