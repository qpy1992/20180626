<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>费用组合</title>
    <style>
  .ui-button {
  	  display: inline-block;
	  padding: 2px 2px;
	  margin-bottom: 0;
	  font-size: 8px;
	  font-weight: normal;
	  line-height: 1.42857143;
	  text-align: center;
	  white-space: nowrap;
	  vertical-align: middle;
	  -ms-touch-action: manipulation;
      touch-action: manipulation;
	  cursor: pointer;
	  -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
	  background-image: none;
	  border: 1px solid transparent;
	  border-radius: 4px;
  }
  </style>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="costCombinationController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${costCombinationPage.id }"/>
	  <input id="fid" name="fid" type="hidden" value="${fid }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">提箱点:</label>
			</td>
			<td class="value">
		     	 <input id="ftxyard" name="ftxyard"  placeholder="点击选择"  onclick="popupClick(this,'fyard_name,id','ftxyard,ftxid','yard')" type="text" style="width: 250px" class="inputxt"  ignore="ignore" />
		     	 <input id="ftxid" name="ftxid" type="hidden" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">提箱点</label>
			</td>
			<td align="right">
				<label class="Validform_label">装货门点:</label>
			</td>
			<td class="value">
		     	 <input id="fload" name="fload" placeholder="点击选择" onclick="popupClick(this,'fname,id','fload,fzhid','dp_select')" type="text" style="width: 250px" class="inputxt"  ignore="ignore" />
				<input id="fzhid" name="fzhid" type="hidden" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">装货门点</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">卸货门点:</label>
			</td>
			<td class="value">
		     	 <input id="fdischarge" name="fdischarge" placeholder="点击选择" onclick="popupClick(this,'fname,id','fdischarge,fxhid','dp_select')" type="text" style="width: 250px" class="inputxt"  ignore="ignore" />
				<input id="fxhid" name="fxhid" type="hidden" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">卸货门点</label>
			</td>
			<td align="right">
				<label class="Validform_label">还箱点:</label>
			</td>
			<td class="value">
		     	 <input id="fhxyard" name="fhxyard"  placeholder="点击选择"  onclick="popupClick(this,'fyard_name,id','fhxyard,fhxid','yard')" type="text" style="width: 250px" class="inputxt"  ignore="ignore" />
				<input id="fhxid" name="fhxid" type="hidden" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">还箱点</label>
			</td>
		</tr>
		<tr>
			<td align="right">
			<label class="Validform_label">预派车天数:</label>
		</td>
			<td class="value">
				<input id="fday" name="fday" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" value="0"/>
				<span class="Validform_checktip">天</span>
				<label class="Validform_label" style="display: none;">预派车天数</label>
			</td>
			<td align="right">
				<label class="Validform_label">开始时间:</label>
			</td>
			<td class="value">
		     	 <input id="fstart" name="fstart" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">开始时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value" colspan="3">
		     	 <input id="fnote" name="fnote" type="text" style="width: 800px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
	
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="costCombinationController.do?costdetailList&id=${costCombinationPage.id}" icon="icon-search" title="费用详情" id="costdetail"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_costdetail_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="costdetailList[#index#].fcostcode" placeholder="点击选择" onclick="popupClick(this,'fee_code,fname','fcostcode,fcost','fee')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用代码</label>
				  </td>
				  <td align="left">
					  	<input name="costdetailList[#index#].fcost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用名称</label>
				  </td>
				  <td align="left">
					  	<%--<input name="costdetailList[#index#].fyf" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />--%>
					<t:dictSelect field="costdetailList[#index#].fyf" hasLabel="false" typeGroupCode="shoufu"></t:dictSelect>
					<label class="Validform_label" style="display: none;">收/付</label>
				  </td>
				  <td align="left">
					  	<input name="costdetailList[#index#].fee" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/costcombination/costCombination.js"></script>
	