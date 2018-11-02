<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>报销单管理</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="baoxiaoController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${baoxiaoPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">报销单号:</label>
			</td>
			<td class="value">
		     	 <input id="fbxno" name="fbxno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly"  value='${baoxiaoPage.fbxno}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">报销单号</label>
			</td>
			<td align="right">
				<label class="Validform_label">申请人:</label>
			</td>
			<td class="value">
		     	 <input id="fapplyer" name="fapplyer" type="text" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly"  value='${baoxiaoPage.fapplyer}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">申请人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">申请日期:</label>
			</td>
			<td class="value">
					  <input id="fapplydate" name="fapplydate" type="text" style="width: 150px" readonly="readonly"   ignore="ignore"  value='<fmt:formatDate value='${baoxiaoPage.fapplydate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">申请日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">审核:</label>
			</td>
			<td class="value">
				<t:dictSelect field="fcheck" hasLabel="false" typeGroupCode="check" readonly="readonly" defaultVal="${baoxiaoPage.fcheck}"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">审核人:</label>
			</td>
			<td class="value">
		     	 <input id="fchecker" name="fchecker" type="text" style="width: 150px" class="inputxt" readonly="readonly"  ignore="ignore"  value='${baoxiaoPage.fchecker}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核人</label>
			</td>
			<td align="right">
				<label class="Validform_label">审核日期:</label>
			</td>
			<td class="value">
					  <input id="fcheckdate" name="fcheckdate" type="text" style="width: 150px"   ignore="ignore" readonly="readonly"  value='<fmt:formatDate value='${baoxiaoPage.fcheckdate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">金额:</label>
			</td>
			<td class="value">
		     	 <input id="famount" name="famount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" readonly="readonly"  value='${baoxiaoPage.famount}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">金额</label>
			</td>
			<%--<td align="right">
				<label class="Validform_label">核销金额:</label>
			</td>
			<td class="value">
		     	 <input id="fhxamount" name="fhxamount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" readonly="readonly"  value='${baoxiaoPage.fhxamount}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">核销金额</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">核销状态:</label>
			</td>
			<td class="value">
				<t:dictSelect field="fhxstatus" hasLabel="false" typeGroupCode="hx" readonly="readonly" defaultVal="${baoxiaoPage.fhxstatus}"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">核销状态</label>
			</td>--%>
			<td align="right">
				<label class="Validform_label">报销人:</label>
			</td>
			<td class="value">
		     	 <input id="fbxman" name="fbxman" type="text" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly"  value='${baoxiaoPage.fbxman}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">报销人</label>
			</td>
		</tr>
		<%--<tr>
			<td align="right">
				<label class="Validform_label">币种:</label>
			</td>
			<td class="value">
		     	 <input id="fcurrency" name="fcurrency" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baoxiaoPage.fcurrency}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">币种</label>
			</td>
		</tr>--%>
	
		<tr>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value" colspan="3">
				 <textarea id="fnote" style="width:600px;" class="inputxt" rows="6" readonly="readonly" name="fnote"  ignore="ignore" >${baoxiaoPage.fnote}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="baoxiaoController.do?bxcostList&id=${baoxiaoPage.id}" icon="icon-search" title="报销费用明细" id="bxcost"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_bxcost_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="bxcostList[#index#].fweituo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">委托单号</label>
				  </td>
				  <td align="left">
					  		<input name="bxcostList[#index#].fbrno" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">提单号</label>
				  </td>
				  <td align="left">
					  		<input name="bxcostList[#index#].fcost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用种类</label>
				  </td>
				  <td align="left">
					  		<input name="bxcostList[#index#].fsettle" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">结算单位代码</label>
				  </td>
				  <td align="left">
					  		<input name="bxcostList[#index#].fsettlename" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">结算单位名称</label>
				  </td>
				  <td align="left">
					  		<input name="bxcostList[#index#].fpaiche" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">派车单号</label>
				  </td>
				  <td align="left">
					  		<input name="bxcostList[#index#].fboxno" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">箱号</label>
				  </td>
				  <td align="left">
					  		<input name="bxcostList[#index#].famount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">金额</label>
				  </td>
				  <td align="left">
					  		<input name="bxcostList[#index#].fsfamount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收付金额</label>
				  </td>
				  <td align="left">
					  		<input name="bxcostList[#index#].fdaidian" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">代垫</label>
				  </td>
				  <td align="left">
					  		<input name="bxcostList[#index#].finstruction" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">附加说明</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/baoxiao/baoxiao.js"></script>	
