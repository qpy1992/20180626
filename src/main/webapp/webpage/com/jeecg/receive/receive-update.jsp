<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>应收账单</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="receiveController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${receivePage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">对账单号:</label>
			</td>
			<td class="value">
		     	 <input id="fbillno" name="fbillno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${receivePage.fbillno}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">对账单号</label>
			</td>
			<td align="right">
				<label class="Validform_label">对账单位代码:</label>
			</td>
			<td class="value">
		     	 <input id="funitcode" name="funitcode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${receivePage.funitcode}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">对账单位代码</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">对账单位名称:</label>
			</td>
			<td class="value">
		     	 <input id="funit" name="funit" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${receivePage.funit}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">对账单位名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">币别:</label>
			</td>
			<td class="value">
		     	 <input id="fbibie" name="fbibie" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${receivePage.fbibie}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">币别</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">金额:</label>
			</td>
			<td class="value">
		     	 <input id="famount" name="famount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${receivePage.famount}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">金额</label>
			</td>
			<td align="right">
				<label class="Validform_label">对账日期起:</label>
			</td>
			<td class="value">
					  <input id="fstartdate" name="fstartdate" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${receivePage.fstartdate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">对账日期起</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">对账日期止:</label>
			</td>
			<td class="value">
					  <input id="fenddate" name="fenddate" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${receivePage.fenddate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">对账日期止</label>
			</td>
			<td align="right">
				<label class="Validform_label">对账范围:</label>
			</td>
			<td class="value">
		     	 <input id="frange" name="frange" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${receivePage.frange}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">对账范围</label>
			</td>
		</tr>
	
		<tr>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value" colspan="3">
				 <textarea id="fnote" style="width:600px;" class="inputxt" rows="6" name="fnote"  ignore="ignore" >${receivePage.fnote}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="receiveController.do?zhangdan1List&id=${receivePage.id}" icon="icon-search" title="应收账单明细" id="zhangdan1"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_zhangdan1_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].fcheck" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">审核</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].fweituo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">委托单号</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].fcost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用种类名称</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].frece" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">应收</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].fsettle" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">结算单位</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].fcurrency" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">币种</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].fprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].fqty" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].fjine" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">金额</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].funit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单位</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].ftidan" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">提单号</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].fshipname" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">航名</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].fvoyageno" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">航次</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].foperatetime" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">作业时间</label>
				  </td>
				  <td align="left">
					  		<input name="zhangdan1List[#index#].fboxtype" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">箱型</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/receive/receive.js"></script>	
