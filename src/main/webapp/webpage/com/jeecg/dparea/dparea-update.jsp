<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>门点区域</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="dpareaController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${dpareaPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">区域代码:</label>
			</td>
			<td class="value">
		     	 <input id="fareaCode" name="fareaCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${dpareaPage.fareaCode}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">区域代码</label>
			</td>
			<td align="right">
				<label class="Validform_label">区域名称:</label>
			</td>
			<td class="value">
		     	 <input id="fareaName" name="fareaName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${dpareaPage.fareaName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">区域名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目组:</label>
			</td>
			<td class="value">
					<t:dictSelect field="fprojectTeam" type="list"   typeGroupCode="team"  defaultVal="${dpareaPage.fprojectTeam}" hasLabel="false"  title="项目组"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目组</label>
			</td>
		</tr>
	
		<tr>
			<td align="right">
				<label class="Validform_label">附加说明:</label>
			</td>
			<td class="value" colspan="3">
				 <textarea id="finstruction" style="width:600px;" class="inputxt" rows="6" name="finstruction"  ignore="ignore" >${dpareaPage.finstruction}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">附加说明</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="dpareaController.do?dpList&id=${dpareaPage.id}" icon="icon-search" title="门点堆场" id="dp"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_dp_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  				<input name="dpList[#index#].fitemid" name="dpList[#index#].fitemid" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"   value="${poVal.fitemid }" />
					     						
					       
					  <label class="Validform_label" style="display: none;">门点代码</label>
				  </td>
				  <td align="left">
					  		<input name="dpList[#index#].fname" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">门点名称</label>
				  </td>
				  <td align="left">
					  		<input name="dpList[#index#].fcontact" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">联系人</label>
				  </td>
				  <td align="left">
					  		<input name="dpList[#index#].fphone" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">电话</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/dparea/dparea.js"></script>	
