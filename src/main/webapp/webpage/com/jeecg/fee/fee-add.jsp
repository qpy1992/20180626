<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>费用种类</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="feeController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${feePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							费用代码:
						</label>
					</td>
					<td class="value">
					     	 <input id="feeCode" name="feeCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用代码</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							作废:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="fvoid" type="radio"  datatype="*"  typeGroupCode="sf_yn"  defaultVal="${feePage.fvoid}" hasLabel="false"  title="作废" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">作废</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							费用组:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="feeTeam" type="list"  typeGroupCode="fyz"  defaultVal="${feePage.feeTeam}" hasLabel="false"  title="费用组" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用组</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							中文名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcnName" name="fcnName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">中文名称</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							对应单位:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="funit" type="list"  typeGroupCode="unit"  defaultVal="${feePage.funit}" hasLabel="false"  title="对应单位" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">对应单位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							费用名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="fname" name="fname" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用名称</label>
						</td>
					</tr>
				<tr>
					<%--<td align="right">
						<label class="Validform_label">
							默认币种:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdefaultCurrency" name="fdefaultCurrency" placeholder="点击选择" onclick="popupClick(this,'fname','fdefaultCurrency','currency');" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">默认币种</label>
						</td>--%>
					<td align="right">
						<label class="Validform_label">
							类型:
						</label>
					</td>
					<td class="value" colspan="3">
					    <t:dictSelect field="fdc1" type="checkbox"  typeGroupCode="fdc"  defaultVal="${feePage.fdc1}" hasLabel="false"  title="选项1" ></t:dictSelect>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">选项1</label>
					</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							默认价格:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdefaultPrice" name="fdefaultPrice" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">默认价格</label>
						</td>
					<td class="value" colspan="2">
							  <t:dictSelect field="fdp1" type="checkbox"  typeGroupCode="fdp"  defaultVal="${feePage.fdp1}" hasLabel="false"  title="选项2" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">选项2</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							约价:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcontractPrice" name="fcontractPrice" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">约价</label>
						</td>
					<td class="value" colspan="2">
							  <t:dictSelect field="fcp1" type="checkbox"  typeGroupCode="fcp"  defaultVal="${feePage.fcp1}" hasLabel="false"  title="选项3" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">选项3</label>
						</td>
					</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							附加说明:
						</label>
					</td>
					<td class="value"  colspan="3" >
						  	 <textarea style="width:550px;height: 80px" class="inputxt" rows="6" id="finstruction" name="finstruction"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">附加说明</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/fee/fee.js"></script>		
