<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>运输发票</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="fapiaoController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${fapiaoPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							发票号码:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbillno" name="fbillno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发票号码</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							结算单位代码:
						</label>
					</td>
					<td class="value">
					     	 <input id="fsettle" name="fsettle" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结算单位代码</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发票抬头:
						</label>
					</td>
					<td class="value">
					     	 <input id="ftaitou" name="ftaitou" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发票抬头</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							签发日期:
						</label>
					</td>
					<td class="value">
					     	 <input id="fqfdate" name="fqfdate" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">签发日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							税号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fshuihao" name="fshuihao" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">税号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							作废:
						</label>
					</td>
					<td class="value">
					     	 <input id="fvoid" name="fvoid" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">作废</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							作废人:
						</label>
					</td>
					<td class="value">
					     	 <input id="fvoidman" name="fvoidman" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">作废人</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							作废时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="fvoidtime" name="fvoidtime" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">作废时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							锁定:
						</label>
					</td>
					<td class="value">
					     	 <input id="flock" name="flock" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">锁定</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							信用日期:
						</label>
					</td>
					<td class="value">
					     	 <input id="fxydate" name="fxydate" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">信用日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							币种:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbibie" name="fbibie" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">币种</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							委托编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fweituo" name="fweituo" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">委托编号</label>
						</td>
					</tr>
				<tr>
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
					<td align="right">
						<label class="Validform_label">
							实际金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="factualamount" name="factualamount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际金额</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							输出:
						</label>
					</td>
					<td class="value">
					     	 <input id="fputout" name="fputout" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">输出</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							锁定人:
						</label>
					</td>
					<td class="value">
					     	 <input id="flockman" name="flockman" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">锁定人</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							锁定时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="flocktime" name="flocktime" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">锁定时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							领用日期:
						</label>
					</td>
					<td class="value">
					     	 <input id="flydate" name="flydate" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">领用日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							参考号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcankao" name="fcankao" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">参考号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							委托单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="fwtunit" name="fwtunit" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">委托单位</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcheck" name="fcheck" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							提单号:
						</label>
					</td>
					<td class="value">
					     	 <input id="ftidan" name="ftidan" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提单号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							红冲:
						</label>
					</td>
					<td class="value">
					     	 <input id="fred" name="fred" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">红冲</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							红冲说明:
						</label>
					</td>
					<td class="value">
					     	 <input id="frednote" name="frednote" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">红冲说明</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							附加说明:
						</label>
					</td>
					<td class="value">
					     	 <input id="ffujia" name="ffujia" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
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
  <script src = "webpage/com/jeecg/fapiao/fapiao.js"></script>		
