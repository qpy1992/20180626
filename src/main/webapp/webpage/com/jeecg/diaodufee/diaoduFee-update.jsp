<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>调度费用录入</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="diaoduFeeController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${diaoduFeePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fkind" type="list"  typeGroupCode=""   defaultVal="${diaoduFeePage.fkind}" hasLabel="false"  title="类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">类型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								费用种类:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="ftype" type="list"  typeGroupCode=""   defaultVal="${diaoduFeePage.ftype}" hasLabel="false"  title="费用种类" ></t:dictSelect>     
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
						    <input id="fname" name="fname" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${diaoduFeePage.fname}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用种类名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								结算单位:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fsettle" type="list"  typeGroupCode=""   defaultVal="${diaoduFeePage.fsettle}" hasLabel="false"  title="结算单位" ></t:dictSelect>     
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
						    <input id="fsettleName" name="fsettleName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${diaoduFeePage.fsettleName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结算单位名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								单位:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="funit" type="list"  typeGroupCode=""   defaultVal="${diaoduFeePage.funit}" hasLabel="false"  title="单位" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								单价:
							</label>
						</td>
						<td class="value">
						    <input id="funitprice" name="funitprice" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${diaoduFeePage.funitprice}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单价</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								数量:
							</label>
						</td>
						<td class="value">
						    <input id="fnumber" name="fnumber" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${diaoduFeePage.fnumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">数量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								收付金额:
							</label>
						</td>
						<td class="value">
						    <input id="famount" name="famount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${diaoduFeePage.famount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收付金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								金额:
							</label>
						</td>
						<td class="value">
						    <input id="famount1" name="famount1" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${diaoduFeePage.famount1}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								额定金额:
							</label>
						</td>
						<td class="value">
						    <input id="fratedamount" name="fratedamount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${diaoduFeePage.fratedamount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">额定金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								实际金额:
							</label>
						</td>
						<td class="value">
						    <input id="frealamount" name="frealamount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${diaoduFeePage.frealamount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								代垫:
							</label>
						</td>
						<td class="value">
						    <input id="fcushion" name="fcushion" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${diaoduFeePage.fcushion}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代垫</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								审核:
							</label>
						</td>
						<td class="value">
						    <input id="fcheck" name="fcheck" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${diaoduFeePage.fcheck}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								费用属性:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fattribute" type="list"  typeGroupCode=""   defaultVal="${diaoduFeePage.fattribute}" hasLabel="false"  title="费用属性" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用属性</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								客户号:
							</label>
						</td>
						<td class="value">
						    <input id="fcustomno" name="fcustomno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${diaoduFeePage.fcustomno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								箱号:
							</label>
						</td>
						<td class="value">
						    <input id="fboxno" name="fboxno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${diaoduFeePage.fboxno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								箱编号:
							</label>
						</td>
						<td class="value">
						    <input id="fboxnum" name="fboxnum" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${diaoduFeePage.fboxnum}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱编号</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								附加说明:
							</label>
						</td>
						<td class="value"  colspan="3" >
						  	 	<textarea id="fnote" style="width:560px;" class="inputxt" rows="6" name="fnote"  ignore="ignore" >${diaoduFeePage.fnote}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">附加说明</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/diaodufee/diaoduFee.js"></script>		
