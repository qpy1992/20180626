<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>车辆违章管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="weizhangController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${weizhangPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							流水编码:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbillno" name="fbillno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">流水编码</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							违章时间:
						</label>
					</td>
					<td class="value">
							   <input id="fwzTime" name="fwzTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">违章时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							车号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcarno" name="fcarno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							驾驶员:
						</label>
					</td>
					<td class="value">
					     	 <input id="fname" name="fname" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶员</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							处罚金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="famount" name="famount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">处罚金额</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							驾驶证扣分:
						</label>
					</td>
					<td class="value">
					     	 <input id="fkoufen" name="fkoufen" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶证扣分</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							通报单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="ftongbao" name="ftongbao" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">通报单位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							违章次数:
						</label>
					</td>
					<td class="value">
					     	 <input id="fwzqty" name="fwzqty" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">违章次数</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							处理违章时间:
						</label>
					</td>
					<td class="value">
							   <input id="fclwztime" name="fclwztime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">处理违章时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							年度累计违章次数:
						</label>
					</td>
					<td class="value">
					     	 <input id="fyearqty" name="fyearqty" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年度累计违章次数</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							年度违章扣6分次数:
						</label>
					</td>
					<td class="value">
					     	 <input id="fsix" name="fsix" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年度违章扣6分次数</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							超速次数:
						</label>
					</td>
					<td class="value">
					     	 <input id="fchaosu" name="fchaosu" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">超速次数</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							年度累计扣分:
						</label>
					</td>
					<td class="value">
					     	 <input id="fyearkf" name="fyearkf" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年度累计扣分</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							年度超速次数:
						</label>
					</td>
					<td class="value">
					     	 <input id="fyearcs" name="fyearcs" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年度超速次数</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							年度超速50%(高速20%)次数:
						</label>
					</td>
					<td class="value" colspan="3">
					     	 <input id="fyearfifty" name="fyearfifty" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年度超速50次数</label>
						</td>
					</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							违章地点:
						</label>
					</td>
					<td class="value"  colspan="3" >
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="fwzaddress" name="fwzaddress"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">违章地点</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							具体交通违法行为:
						</label>
					</td>
					<td class="value"  colspan="3" >
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="fbehavior" name="fbehavior"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">具体交通违法行为</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value"  colspan="3" >
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="fnote" name="fnote"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/weizhang/weizhang.js"></script>		
