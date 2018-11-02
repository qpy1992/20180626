<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>统一派车单管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="paicheController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${paichePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							派车单号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbillno" name="fbillno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">派车单号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							车辆编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcarcode" name="fcarcode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车辆编号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							车牌号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcarno" name="fcarno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车牌号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							运输时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="ftranstime" name="ftranstime" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">运输时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="ftype" name="ftype" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">类型</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							已报销:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbaoxiao" name="fbaoxiao" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">已报销</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							主司机:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdriver" name="fdriver" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">主司机</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							详情:
						</label>
					</td>
					<td class="value">
					     	 <input id="ftype2" name="ftype2" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">详情</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							副司机:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdriver2" name="fdriver2" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">副司机</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="fstatus" name="fstatus" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							门点:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdoorpoint" name="fdoorpoint" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">门点</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							运输方式:
						</label>
					</td>
					<td class="value">
					     	 <input id="ftranstype" name="ftranstype" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">运输方式</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							货重:
						</label>
					</td>
					<td class="value">
					     	 <input id="fweight" name="fweight" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">货重</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							皮重:
						</label>
					</td>
					<td class="value">
					     	 <input id="fweight2" name="fweight2" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">皮重</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出场路码:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcccode" name="fcccode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出场路码</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							进场路码:
						</label>
					</td>
					<td class="value">
					     	 <input id="fjccode" name="fjccode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">进场路码</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							起始地:
						</label>
					</td>
					<td class="value">
					     	 <input id="fstart" name="fstart" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">起始地</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							终止地:
						</label>
					</td>
					<td class="value">
					     	 <input id="fend" name="fend" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">终止地</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							运输要求:
						</label>
					</td>
					<td class="value">
					     	 <input id="frequire" name="frequire" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">运输要求</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							路桥费:
						</label>
					</td>
					<td class="value">
					     	 <input id="fluqiao" name="fluqiao" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">路桥费</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							打单费:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdadan" name="fdadan" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">打单费</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							上下车费:
						</label>
					</td>
					<td class="value">
					     	 <input id="fshangxia" name="fshangxia" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">上下车费</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							封子费:
						</label>
					</td>
					<td class="value">
					     	 <input id="ffengzi" name="ffengzi" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">封子费</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							调箱门费:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdiaoxiang" name="fdiaoxiang" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">调箱门费</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							预录费:
						</label>
					</td>
					<td class="value">
					     	 <input id="fyulu" name="fyulu" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预录费</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							总油耗:
						</label>
					</td>
					<td class="value">
					     	 <input id="fyouhao" name="fyouhao" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">总油耗</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							油价:
						</label>
					</td>
					<td class="value">
					     	 <input id="fyoujia" name="fyoujia" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">油价</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							油耗:
						</label>
					</td>
					<td class="value">
					     	 <input id="fyoufei" name="fyoufei" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">油耗</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							正司机提成:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdriver3" name="fdriver3" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">正司机提成</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							市内补贴:
						</label>
					</td>
					<td class="value">
					     	 <input id="fshinei" name="fshinei" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">市内补贴</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							副司机提成:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdriver4" name="fdriver4" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">副司机提成</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							回单时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="fhdtime" name="fhdtime" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">回单时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							设备交接单:
						</label>
					</td>
					<td class="value">
					     	 <input id="fshebei" name="fshebei" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">设备交接单</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							签收单:
						</label>
					</td>
					<td class="value">
					     	 <input id="fqianshou" name="fqianshou" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">签收单</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							预录单:
						</label>
					</td>
					<td class="value">
					     	 <input id="fyuluno" name="fyuluno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预录单</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							装箱单:
						</label>
					</td>
					<td class="value">
					     	 <input id="fzhaungxiang" name="fzhaungxiang" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装箱单</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							白卡:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbaika" name="fbaika" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">白卡</label>
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
  <script src = "webpage/com/jeecg/paiche/paiche.js"></script>		
