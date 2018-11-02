<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>车辆保险理赔</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="lipeiController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${lipeiPage.id }"/>
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
							交通事故处理单号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fjiaotong" name="fjiaotong" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">交通事故处理单号</label>
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
							出险时间:
						</label>
					</td>
					<td class="value">
							   <input id="fchuxianTime" name="fchuxianTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出险时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							责任划分:
						</label>
					</td>
					<td class="value">
					     	 <input id="fzeren" name="fzeren" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任划分</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							行程:
						</label>
					</td>
					<td class="value">
					     	 <input id="fxingcheng" name="fxingcheng" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">行程</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							损失处理方式:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="fsschuli" type="list"  typeGroupCode="sunshi"  defaultVal="${lipeiPage.fsschuli}" hasLabel="false"  title="损失处理方式" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">损失处理方式</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							内部定级:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="fdingji" type="list"  typeGroupCode="dingji"  defaultVal="${lipeiPage.fdingji}" hasLabel="false"  title="内部定级" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">内部定级</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							停运天数:
						</label>
					</td>
					<td class="value">
					     	 <input id="ftyday" name="ftyday" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">停运天数</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							司机扣款:
						</label>
					</td>
					<td class="value">
					     	 <input id="fkoukuan" name="fkoukuan" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">司机扣款</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							事故总金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="famount" name="famount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">事故总金额</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							保险赔付:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbaoxian" name="fbaoxian" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">保险赔付</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							自身损失:
						</label>
					</td>
					<td class="value">
					     	 <input id="fzssunshi" name="fzssunshi" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">自身损失</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							保险结算单号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbxjiesuan" name="fbxjiesuan" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">保险结算单号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							其他损失:
						</label>
					</td>
					<td class="value">
					     	 <input id="fother" name="fother" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">其他损失</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							保险结案时间:
						</label>
					</td>
					<td class="value">
							   <input id="fjatime" name="fjatime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">保险结案时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							第三者损失:
						</label>
					</td>
					<td class="value">
					     	 <input id="fdisan" name="fdisan" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">第三者损失</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							交理赔材料时间:
						</label>
					</td>
					<td class="value">
							   <input id="fjcltime" name="fjcltime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">交理赔材料时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							公司预付:
						</label>
					</td>
					<td class="value">
					     	 <input id="fyufu" name="fyufu" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司预付</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							赔付时间:
						</label>
					</td>
					<td class="value">
							   <input id="fpeifutime" name="fpeifutime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">赔付时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							交警结案时间:
						</label>
					</td>
					<td class="value">
							   <input id="fpolice" name="fpolice" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">交警结案时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司结案时间:
						</label>
					</td>
					<td class="value">
							   <input id="fgsjatime" name="fgsjatime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司结案时间</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
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
  <script src = "webpage/com/jeecg/lipei/lipei.js"></script>		
