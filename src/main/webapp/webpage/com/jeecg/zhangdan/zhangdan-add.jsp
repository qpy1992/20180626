<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>账单费用</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zhangdanController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${zhangdanPage.id }"/>
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
							委托单号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fweituo" name="fweituo" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">委托单号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							费用种类名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcost" name="fcost" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用种类名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							应收:
						</label>
					</td>
					<td class="value">
					     	 <input id="frece" name="frece" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">应收</label>
						</td>
					</tr>
				<tr>
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
					<td align="right">
						<label class="Validform_label">
							实际付款人:
						</label>
					</td>
					<td class="value">
					     	 <input id="fpayer" name="fpayer" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际付款人</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							币种:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcurrency" name="fcurrency" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">币种</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							单价:
						</label>
					</td>
					<td class="value">
					     	 <input id="fprice" name="fprice" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
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
					     	 <input id="fqty" name="fqty" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">数量</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="fjine" name="fjine" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">金额</label>
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
							代收代付:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdai" name="fdai" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代收代付</label>
						</td>
					</tr>
				<tr>
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
					<td align="right">
						<label class="Validform_label">
							航名:
						</label>
					</td>
					<td class="value">
					     	 <input id="fshipname" name="fshipname" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">航名</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							航次:
						</label>
					</td>
					<td class="value">
					     	 <input id="fvoyageno" name="fvoyageno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">航次</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							装船港:
						</label>
					</td>
					<td class="value">
					     	 <input id="floadport" name="floadport" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装船港</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							目的港:
						</label>
					</td>
					<td class="value">
					     	 <input id="ftargetport" name="ftargetport" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">目的港</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							作业时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="foperatetime" name="foperatetime" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">作业时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							箱型:
						</label>
					</td>
					<td class="value">
					     	 <input id="fboxtype" name="fboxtype" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱型</label>
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
  <script src = "webpage/com/jeecg/zhangdan/zhangdan.js"></script>		
