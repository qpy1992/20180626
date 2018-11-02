<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>合同维护</title>
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
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="hetongController.do?doUpdate" >
	  <input id="id" name="id" type="hidden" value="${hetongPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">合同号:</label>
			</td>
			<td class="value">
				<input id="fbillno" name="fbillno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly"  value='${hetongPage.fbillno}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同号</label>
			</td>
			<td align="right">
				<label class="Validform_label">合同类型:</label>
			</td>
			<td class="value">
				<t:dictSelect field="ftype" type="list"   typeGroupCode="htype"  defaultVal="${hetongPage.ftype}" hasLabel="false"  title="合同类型"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同类型</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">收付类型:</label>
			</td>
			<td class="value">
				<t:dictSelect field="fkind" type="list"   typeGroupCode="shoufu"  defaultVal="${hetongPage.fkind}" hasLabel="false"  title="收付类型"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收付类型</label>
			</td>
			<td align="right">
				<label class="Validform_label">结算单位:</label>
			</td>
			<td class="value">
				<%--<t:dictSelect field="fsettle" type="list"   typeGroupCode=""  defaultVal="${hetongPage.fsettle}" hasLabel="false"  title="结算单位"></t:dictSelect>--%>
				<input id="fsettle" name="fsettle" placeholder="点击选择" onclick="popupClick(this, 'fcustom_code,fcn_name', 'fsettle,fsettleName', 'weituo');" type="text" style="width: 150px" class="inputxt" ignore="ignore" value="${hetongPage.fsettle}"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">结算单位</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">结算单位名称:</label>
			</td>
			<td class="value">
				<input id="fsettleName" name="fsettleName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${hetongPage.fsettleName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">结算单位名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">计费方式:</label>
			</td>
			<td class="value">
				<t:dictSelect field="fchargetype" type="list"   typeGroupCode="jifei"  defaultVal="${hetongPage.fchargetype}" hasLabel="false"  title="计费方式"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">计费方式</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">生效日期:</label>
			</td>
			<td class="value">
				<input id="fstartDate" name="fstartDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore"  value='<fmt:formatDate value='${hetongPage.fstartDate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">生效日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">失效日期:</label>
			</td>
			<td class="value">
				<input id="fenddate" name="fenddate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  value='<fmt:formatDate value='${hetongPage.fenddate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">失效日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">委托编号:</label>
			</td>
			<td class="value" colspan="3">
				<%--<t:dictSelect field="fbrno" type="list"   typeGroupCode=""  defaultVal="${hetongPage.fbrno}" hasLabel="false"  title="委托编号"></t:dictSelect>--%>
				<input id="fbrno" name="fbrno" type="text" style="width: 150px" class="inputxt" ignore="ignore" readonly="readonly" value="${hetongPage.fbrno}"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">委托编号</label>
			</td>
		</tr>
	
		<tr>
			<td align="right">
				<label class="Validform_label">附加说明:</label>
			</td>
			<td class="value" colspan="3">
				 <textarea id="fnote" style="width:600px;" class="inputxt" rows="6" name="fnote"  ignore="ignore" >${hetongPage.fnote}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">附加说明</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="hetongController.do?hetong1List&id=${hetongPage.id}" icon="icon-search" title="门点信息" id="hetong1"></t:tab>
				 <t:tab href="hetongController.do?hetong2List&id=${hetongPage.id}" icon="icon-search" title="价格要素及费率" id="hetong2"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_hetong1_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  <input name="hetong1List[#index#].fnumber" placeholder="点击选择" onclick="popupClick(this,'fitemid,fname','fnumber,faddress','dp_select')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">门点代码</label>
				  </td>
				  <td align="left">
					  <input name="hetong1List[#index#].faddress" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">门点地址</label>
				  </td>
				  <td align="left">
					  <input name="hetong1List[#index#].fyard" placeholder="点击选择" onclick="popupClick(this,'fyard_name','fyard','yard')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">提还箱堆场区域</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_hetong2_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  <%--<input name="hetong2List[#index#].ftype" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />--%>
                      <t:dictSelect field="hetong2List[#index#].ftype" hasLabel="false" typeGroupCode="buss"></t:dictSelect>
                      <label class="Validform_label" style="display: none;">业务类型</label>
				  </td>
				  <td align="left">
					  <input name="hetong2List[#index#].fnumber" placeholder="点击选择" onclick="popupClick(this,'fee_code,fname,funit,fdefault_price','fnumber,feeType,funit,fprice','costtype')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用代码</label>
				  </td>
				  <td align="left">
					  <input name="hetong2List[#index#].feeType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用种类名称</label>
				  </td>
				  <td align="left">
					  <input name="hetong2List[#index#].funit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单位</label>
				  </td>
				  <td align="left">
					  <input name="hetong2List[#index#].fprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  <input name="hetong2List[#index#].fminAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">最小金额</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/hetong/hetong.js"></script>	
