<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>出库</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zExitController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${zExitPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">流水编码:</label>
			</td>
			<td class="value">
		     	 <input id="zLsbm" name="zLsbm" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">流水编码</label>
			</td>
			<td align="right">
				<label class="Validform_label">制单日期:</label>
			</td>
			<td class="value">
					  <input id="zZddate" name="zZddate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  type="text" style="width: 150px"  class="easyui-datebox datebox-f combo-f"  comboname="date"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">制单日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">制单人:</label>
			</td>
			<td class="value">
		     	 <input id="zZdpeople" name="zZdpeople" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">制单人</label>
			</td>
			<td align="right">
				<label class="Validform_label">审核人:</label>
			</td>
			<td class="value">
		     	 <input id="zCheckpeople" name="zCheckpeople" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">审核时间:</label>
			</td>
			<td class="value">
		     	 <input id="zCheckdatetime" name="zCheckdatetime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">车号:</label>
			</td>
			<td class="value">
		     	 <input id="zCh" name="zCh" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">车号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">驾驶员:</label>
			</td>
			<td class="value">
		     	 <input id="zJsy" name="zJsy" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">驾驶员</label>
			</td>
			<td align="right">
				<label class="Validform_label">出库人:</label>
			</td>
			<td class="value">
		     	 <input id="zExitpeople" name="zExitpeople" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">出库人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">出库合计:</label>
			</td>
			<td class="value">
		     	 <input id="zExittotal" name="zExittotal" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">出库合计</label>
			</td>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value">
		     	 <input id="zBz" name="zBz" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
	
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="zExitController.do?zExitdetailList&id=${zExitPage.id}" icon="icon-search" title="出库明细表" id="zExitdetail"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_zExitdetail_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="zExitdetailList[#index#].zExitId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">序号</label>
				  </td>
				  <td align="left">
					  	<input name="zExitdetailList[#index#].zWldm" maxlength="32" onclick="popupClick(this,'fWldm,fwlmc,fggxh,fdw,fjj','zWldm,zWlmc,zGgxh,zDw,zJprice','wuliao')"type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">物料代码</label>
				  </td>
				  <td align="left">
					  	<input name="zExitdetailList[#index#].zWlmc" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">物料名称</label>
				  </td>
				  <td align="left">
					  	<input name="zExitdetailList[#index#].zGgxh" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">规格型号</label>
				  </td>
				  <td align="left">
					  	<input name="zExitdetailList[#index#].zDw" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单位</label>
				  </td>
				  <td align="left">
					  	<input name="zExitdetailList[#index#].zKcsl" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">库存数量</label>
				  </td>
				  <td align="left">
					  	<input name="zExitdetailList[#index#].zExitnum" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">出库数量</label>
				  </td>
				  <td align="left">
					  	<input name="zExitdetailList[#index#].zJprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">进价</label>
				  </td>
				  <td align="left">
					  	<input name="zExitdetailList[#index#].zJpricetotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">进价合计</label>
				  </td>
				  <td align="left">
					  	<input name="zExitdetailList[#index#].zSprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">销价</label>
				  </td>
				  <td align="left">
					  	<input name="zExitdetailList[#index#].zSpricetotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">销价合计</label>
				  </td>
				  <td align="left">
					  	<input name="zExitdetailList[#index#].zProfit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">利润</label>
				  </td>
				  <td align="left">
					  	<input name="zExitdetailList[#index#].zBz" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/z_exit/zExit.js"></script>
	