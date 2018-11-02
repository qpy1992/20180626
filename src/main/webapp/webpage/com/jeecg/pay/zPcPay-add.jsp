<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>派车单应付</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zPcPayController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${zPcPayPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
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
							费用种类:
						</label>
					</td>
					<td class="value">
					     	 <input id="feetype" name="feetype" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用种类</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							费用种类名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="feename" name="feename" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用种类名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							结算单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="fsettle" name="fsettle" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结算单位</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							结算单位名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="fsettlename" name="fsettlename" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结算单位名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							司机:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdriver" name="fdriver" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">司机</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="funit" name="funit" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							单价:
						</label>
					</td>
					<td class="value">
					     	 <input id="funitprice" name="funitprice" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单价</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="fqty" name="fqty" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">数量</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="famount" name="famount" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">金额</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							分摊:
						</label>
					</td>
					<td class="value">
					     	 <input id="fentan" name="fentan" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分摊</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							车号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcarcode" name="fcarcode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							挂车标识:
						</label>
					</td>
					<td class="value">
					     	 <input id="fguache" name="fguache" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">挂车标识</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							代垫:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdaidian" name="fdaidian" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代垫</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							报销:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbaoxiao" name="fbaoxiao" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">报销</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							箱号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fxianghao" name="fxianghao" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							委托编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fweitup" name="fweitup" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">委托编号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							客户号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcustomno" name="fcustomno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							额定金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="feding" name="feding" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">额定金额</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							审核人:
						</label>
					</td>
					<td class="value">
					     	 <input id="fchecker" name="fchecker" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核人</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							附加说明:
						</label>
					</td>
					<td class="value">
					     	 <input id="finstruction" name="finstruction" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
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
  <script src = "webpage/com/jeecg/pay/zPcPay.js"></script>		
