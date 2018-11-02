<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>领用单</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zOutstorageController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${zOutstoragePage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">流水编码:</label>
			</td>
			<td class="value">
		     	 <input id="code" name="code" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zOutstoragePage.code}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">流水编码</label>
			</td>
			<td align="right">
				<label class="Validform_label">制单日期:</label>
			</td>
			<td class="value">
		     	 <input id="makeDate" name="makeDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore"  value='${zOutstoragePage.makeDate}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">制单日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">制单人:</label>
			</td>
			<td class="value">
		     	 <input id="makePeople" name="makePeople" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zOutstoragePage.makePeople}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">制单人</label>
			</td>
			<td align="right">
				<label class="Validform_label">审核人:</label>
			</td>
			<td class="value">
		     	 <input id="checkPeople" name="checkPeople" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore"  value='${zOutstoragePage.checkPeople}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">审核日期:</label>
			</td>
			<td class="value">
		     	 <input id="checkDate" name="checkDate" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zOutstoragePage.checkDate}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">车号:</label>
			</td>
			<td class="value">
		     	 <input id="carcode" name="carcode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zOutstoragePage.carcode}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">车号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">驾驶员:</label>
			</td>
			<td class="value">
		     	 <input id="driver" name="driver" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zOutstoragePage.driver}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">驾驶员</label>
			</td>
			<td align="right">
				<label class="Validform_label">领用人:</label>
			</td>
			<td class="value">
		     	 <input id="lyperson" name="lyperson" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zOutstoragePage.lyperson}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">领用人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">领用合计:</label>
			</td>
			<td class="value">
		     	 <input id="lytotal" name="lytotal" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zOutstoragePage.lytotal}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">领用合计</label>
			</td>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value">
		     	 <input id="note" name="note" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zOutstoragePage.note}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="zOutstorageController.do?zOutstoragedetailList&id=${zOutstoragePage.id}" icon="icon-search" title="领用明细" id="zOutstoragedetail"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_zOutstoragedetail_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="zOutstoragedetailList[#index#].wulioCode" onclick="popupClick(this,'fwldm,fwlmc,fggxh,fdw,fjj,fxj','wulioCode,wulioName,specifications,unit,purchasePrice,salePrice','wuliao')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">物料代码</label>
				  </td>
				  <td align="left">
					  		<input name="zOutstoragedetailList[#index#].wulioName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">物料名称</label>
				  </td>
				  <td align="left">
					  		<input name="zOutstoragedetailList[#index#].specifications" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">规格型号</label>
				  </td>
				  <td align="left">
					  		<input name="zOutstoragedetailList[#index#].unit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单位</label>
				  </td>
				  <td align="left">
					  		<input name="zOutstoragedetailList[#index#].number" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">库存数量</label>
				  </td>
				  <td align="left">
					  		<input name="zOutstoragedetailList[#index#].lyNumber" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">领用数量</label>
				  </td>
				  <td align="left">
					  		<input name="zOutstoragedetailList[#index#].purchasePrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">进价</label>
				  </td>
				  <td align="left">
					  		<input name="zOutstoragedetailList[#index#].purchaseTotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">进价合计</label>
				  </td>
				  <td align="left">
					  		<input name="zOutstoragedetailList[#index#].salePrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">销价</label>
				  </td>
				  <td align="left">
					  		<input name="zOutstoragedetailList[#index#].saleTotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">销价合计</label>
				  </td>
				  <td align="left">
					  		<input name="zOutstoragedetailList[#index#].profits" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">利润</label>
				  </td>
				  <td align="left">
					  		<input name="zOutstoragedetailList[#index#].note" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				<!--   <td align="left">
					  		<input name="zOutstoragedetailList[#index#].fid" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">父id</label>
				  </td> -->
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/zoutstorage/zOutstorage.js"></script>	
