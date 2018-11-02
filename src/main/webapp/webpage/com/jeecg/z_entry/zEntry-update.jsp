<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>入库</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zEntryController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${zEntryPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">流水编码:</label>
			</td>
			<td class="value">
		     	 <input id="zLsbm" name="zLsbm" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zEntryPage.zLs}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">流水编码</label>
			</td>
			<td align="right">
				<label class="Validform_label">制单日期:</label>
			</td>
			<td class="value">
		     	 <input id="zZddate" name="zZddate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zEntryPage.zZddate}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">制单日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">制单人:</label>
			</td>
			<td class="value">
		     	 <input id="zPeople" name="zPeople" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zEntryPage.zPeople}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">制单人</label>
			</td>
			<td align="right">
				<label class="Validform_label">审核人:</label>
			</td>
			<td class="value">
		     	 <input id="zCheckpeople" name="zCheckpeople" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zEntryPage.zCheckpeople}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">审核时间:</label>
			</td>
			<td class="value">
		     	 <input id="zCheckdatetime" name="zCheckdatetime" type="text" style="width: 150px" class="inputxt"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  value='${zEntryPage.zCheckdatetime}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value">
		     	 <input id="zBz" name="zBz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zEntryPage.zBz}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="zEntryController.do?zEntrydetailList&id=${zEntryPage.id}" icon="icon-search" title="入库明细表" id="zEntrydetail"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_zEntrydetail_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="zEntrydetailList[#index#].zId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">序号</label>
				  </td>
				  <td align="left">
					  		<input name="zEntrydetailList[#index#].zWldm" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">物料代码</label>
				  </td>
				  <td align="left">
					  		<input name="zEntrydetailList[#index#].zWlmc" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">物料名称</label>
				  </td>
				  <td align="left">
					  		<input name="zEntrydetailList[#index#].zGgxh" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">规格型号</label>
				  </td>
				  <td align="left">
					  		<input name="zEntrydetailList[#index#].zDw" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单位</label>
				  </td>
				  <td align="left">
					  		<input name="zEntrydetailList[#index#].zNum" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">入库数量</label>
				  </td>
				  <td align="left">
					  		<input name="zEntrydetailList[#index#].zJprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">进价</label>
				  </td>
				  <td align="left">
					  		<input name="zEntrydetailList[#index#].zJpricetotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">进价合计</label>
				  </td>
				  <td align="left">
					  		<input name="zEntrydetailList[#index#].zSprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">销价</label>
				  </td>
				  <td align="left">
					  		<input name="zEntrydetailList[#index#].zSpricetotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">销价合计</label>
				  </td>
				  <td align="left">
					  		<input name="zEntrydetailList[#index#].zCgdate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">采购日期</label>
				  </td>
				  <td align="left">
					  		<input name="zEntrydetailList[#index#].zBz" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/z_entry/zEntry.js"></script>	
