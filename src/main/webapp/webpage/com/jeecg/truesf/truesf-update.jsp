<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>实际收付</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="truesfController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${truesfPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								流水号:
							</label>
						</td>
						<td class="value">
						    <input id="fbillno" name="fbillno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${truesfPage.fbillno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">流水号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								结算单位代码:
							</label>
						</td>
						<td class="value">
						    <input id="fsettle" name="fsettle" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${truesfPage.fsettle}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结算单位代码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								结算单位:
							</label>
						</td>
						<td class="value">
						    <input id="fsettlename" name="fsettlename" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${truesfPage.fsettlename}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结算单位</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								金额:
							</label>
						</td>
						<td class="value">
						    <input id="famount" name="famount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${truesfPage.famount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								收付:
							</label>
						</td>
						<td class="value">
						    <input id="fshoufu" name="fshoufu" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${truesfPage.fshoufu}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收付</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								剩余金额:
							</label>
						</td>
						<td class="value">
						    <input id="fremain" name="fremain" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${truesfPage.fremain}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">剩余金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								结算方式:
							</label>
						</td>
						<td class="value">
						    <input id="fsettletype" name="fsettletype" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${truesfPage.fsettletype}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结算方式</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								银行账号:
							</label>
						</td>
						<td class="value">
						    <input id="fbank" name="fbank" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${truesfPage.fbank}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">银行账号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								凭证号:
							</label>
						</td>
						<td class="value">
						    <input id="fvoucher" name="fvoucher" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${truesfPage.fvoucher}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">凭证号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								凭证号数字:
							</label>
						</td>
						<td class="value">
						    <input id="fvoucherno" name="fvoucherno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${truesfPage.fvoucherno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">凭证号数字</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						    <input id="fnote" name="fnote" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${truesfPage.fnote}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								凭证月:
							</label>
						</td>
						<td class="value">
						    <input id="fvoumonth" name="fvoumonth" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${truesfPage.fvoumonth}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">凭证月</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								凭证月编号:
							</label>
						</td>
						<td class="value">
						    <input id="fmonthno" name="fmonthno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${truesfPage.fmonthno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">凭证月编号</label>
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
  <script src = "webpage/com/jeecg/truesf/truesf.js"></script>		
