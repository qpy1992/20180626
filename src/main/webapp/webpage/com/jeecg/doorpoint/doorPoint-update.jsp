<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>门点</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="doorPointController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${doorPointPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">门点代码:</label>
			</td>
			<td class="value">
		     	 <input id="fdpCode" name="fdpCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  readonly="readonly"  value='${doorPointPage.fdpCode}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">门点代码</label>
			</td>
			<td align="right">
				<label class="Validform_label">项目组:</label>
			</td>
			<td class="value">
					<t:dictSelect field="fprojectTeam" type="list"   typeGroupCode="team"  defaultVal="${doorPointPage.fprojectTeam}" hasLabel="false"  title="项目组"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目组</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">作废:</label>
			</td>
			<td class="value">
					<t:dictSelect field="fvoid" type="list"   typeGroupCode="sf_yn"  defaultVal="${doorPointPage.fvoid}" hasLabel="false"  title="作废"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">作废</label>
			</td>
			<td align="right">
				<label class="Validform_label">门点名称:</label>
			</td>
			<td class="value">
		     	 <input id="fdpName" name="fdpName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${doorPointPage.fdpName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">门点名称</label>
			</td>
		</tr>
		<tr>
            <td align="right">
                <label class="Validform_label">门点地址:</label>
            </td>
            <td class="value" colspan="3">
				<input type="text" id="province" style="width:80px;" value="${doorPointPage.province}"/>
				<input type="text" id="city" style="width:80px;" value="${doorPointPage.city}"/>
				<input type="text" id="area" style="width:80px;" value="${doorPointPage.area}"/>
                <input id="dizhi" name="dizhi" type="text" style="width: 500px" class="inputxt"  ignore="ignore"  value='${doorPointPage.dizhi}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">门点地址</label>
            </td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">装送货单位:</label>
			</td>
			<td class="value" colspan="3">
		     	 <input id="fdeliverUnit" name="fdeliverUnit" type="text" style="width: 800px" class="inputxt"  ignore="ignore"  value='${doorPointPage.fdeliverUnit}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">装送货单位</label>
			</td>
		</tr>
	
		<tr>
			<td align="right">
				<label class="Validform_label">附加说明:</label>
			</td>
			<td class="value" colspan="3">
				 <textarea id="finstruction" style="width:600px;" class="inputxt" rows="6" name="finstruction"  ignore="ignore" >${doorPointPage.finstruction}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">附加说明</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
                 <t:tab href="doorPointController.do?dpContactList&id=${doorPointPage.id}" icon="icon-search" title="门点联系人" id="dpContact"></t:tab>
				 <t:tab href="doorPointController.do?dpRateList&id=${doorPointPage.id}" icon="icon-search" title="门点费率" id="dpRate"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_dpRate_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="dpRateList[#index#].feeType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用种类</label>
				  </td>
				  <td align="left">
					  		<input name="dpRateList[#index#].feeTypeName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用种类名称</label>
				  </td>
				  <td align="left">
					  		<input name="dpRateList[#index#].fboxType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">箱型</label>
				  </td>
				  <td align="left">
					  		<input name="dpRateList[#index#].frate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费率</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_dpContact_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="dpContactList[#index#].fcontactName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">联系人名</label>
				  </td>
                  <td align="left">
                      <t:dictSelect field="dpContactList[#index#].fdefault" type="list"    typeGroupCode="sf_yn"  defaultVal="" hasLabel="false"></t:dictSelect>
                      <label class="Validform_label" style="display: none;">默认</label>
                  </td>
				  <td align="left">
							<t:dictSelect field="dpContactList[#index#].fgender" type="list"   typeGroupCode="sex"  defaultVal="" hasLabel="false"  title="性别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">性别</label>
				  </td>
				  <td align="left">
					  		<input name="dpContactList[#index#].fphone" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">电话</label>
				  </td>
				  <td align="left">
					  		<input name="dpContactList[#index#].fmobile" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="m" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">手机</label>
				  </td>
				  <td align="left">
					  		<input name="dpContactList[#index#].fax" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">传真</label>
				  </td>
				  <td align="left">
					  		<input name="dpContactList[#index#].femail" maxlength="32" type="text" class="inputxt"  style="width:150px;" 		datatype="e" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">邮箱</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/doorpoint/doorPoint.js"></script>
 <script src="plug-in/jquery/jquery.regionselect.js" type="text/javascript"></script>
 <script type="text/javascript">
     //省市区下拉
     $(function() {
         $("#province").regionselect({
             url: '<%=basePath%>/jeecgFormDemoController.do?regionSelect'
         });
     });
 </script>
