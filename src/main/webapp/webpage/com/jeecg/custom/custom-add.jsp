<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>客户资料维护</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="customController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${customPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">公司类型:</label>
			</td>
			<td class="value" colspan="7">
                <t:dictSelect field="fcompanyType" type="checkbox"  datatype="*"   typeGroupCode="comtype"  defaultVal="${customPage.fcompanyType}" hasLabel="false"  title="公司类型" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">公司类型</label>
			</td>
        </tr>
        <tr>
			<%--<td align="right">
				<label class="Validform_label">客户代码:</label>
			</td>
			<td class="value">
                <input id="fcustomCode" name="fcustomCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户代码</label>
			</td>--%>

			<td align="right">
				<label class="Validform_label">简称:</label>
			</td>
			<td class="value">
                <input id="fabbr" name="fabbr" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">简称</label>
			</td>
			<td align="right">
				<label class="Validform_label">税号:</label>
			</td>
			<td class="value">
                <input id="fdutyPara" name="fdutyPara" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">税号</label>
			</td>

			<td align="right">
				<label class="Validform_label">中文名称:</label>
			</td>
			<td class="value">
                <input id="fcnName" name="fcnName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">中文名称</label>
			</td>

			<td align="right">
				<label class="Validform_label">英文名称:</label>
			</td>
			<td class="value">
                <input id="fenName" name="fenName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">英文名称</label>
			</td>
        </tr>
        <tr>
			<td align="right">
				<label class="Validform_label">财务编码:</label>
			</td>
			<td class="value">
                <input id="financeCode" name="financeCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">财务编码</label>
			</td>
			<td align="right">
				<label class="Validform_label">信用等级:</label>
			</td>
			<td class="value">
                <t:dictSelect field="fcreditRate" type="list"   typeGroupCode="grade"  defaultVal="${customPage.fcreditRate}" hasLabel="false"  title="信用等级" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">信用等级</label>
			</td>
            <td align="right">
                <label class="Validform_label">项目组:</label>
            </td>
            <td class="value">
                <t:dictSelect field="fprojectTeam" type="list"   typeGroupCode="team"  defaultVal="${customPage.fprojectTeam}" hasLabel="false"  title="项目组" ></t:dictSelect>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">项目组</label>
            </td>
            <td align="right">
                <label class="Validform_label">国家城市:</label>
            </td>
            <td class="value">
                <input type="text" id="province" style="width:80px;"/>
                <input type="text" id="city" style="width:80px;"/>
                <input type="text" id="area" style="width:80px;"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">国家城市</label>
            </td>
        </tr>
        <tr>
			<td align="right">
				<label class="Validform_label">合同期:</label>
			</td>
			<td class="value" colspan="3">
                <input id="fcontractStart" name="fcontractStart" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
                <span class="Validform_checktip">~</span>
                <input id="fcontractEnd" name="fcontractEnd" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
			</td>
			<td align="right">
				<label class="Validform_label">地址:</label>
			</td>
			<td class="value">
                <input id="faddress" name="faddress" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">地址</label>
			</td>

			<td align="right">
				<label class="Validform_label">邮编:</label>
			</td>
			<td class="value">
                <input id="fzipcode" name="fzipcode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">邮编</label>
			</td>
        </tr>
        <tr>
			<td align="right">
				<label class="Validform_label">联系电话:</label>
			</td>
			<td class="value">
                <input id="fmobile" name="fmobile" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">联系电话</label>
			</td>

			<td align="right">
				<label class="Validform_label">联系传真:</label>
			</td>
			<td class="value">
                <input id="fax" name="fax" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">联系传真</label>
			</td>

			<td align="right">
				<label class="Validform_label">关键字:</label>
			</td>
			<td class="value">
                <input id="fkeyword" name="fkeyword" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">关键字</label>
			</td>

			<td align="right">
				<label class="Validform_label">公司网址:</label>
			</td>
			<td class="value">
                <input id="fcompanyWebsite" name="fcompanyWebsite" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">公司网址</label>
			</td>
        </tr>
        <tr>
			<td align="right">
				<label class="Validform_label">电子邮件:</label>
			</td>
			<td class="value">
                <input id="femail" name="femail" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">电子邮件</label>
			</td>

			<td align="right">
				<label class="Validform_label">开票税率:</label>
			</td>
			<td class="value">
                <input id="fticketRate" name="fticketRate" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span>%</span>
				<label class="Validform_label" style="display: none;">开票税率</label>
			</td>

			<td align="right">
				<label class="Validform_label">附加说明:</label>
			</td>
			<td class="value" colspan="3">
                <textarea id="finstruction" style="width:600px;" class="inputxt" rows="6" name="finstruction"  ignore="ignore" ></textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">附加说明</label>
			</td>
		</tr>
	
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="customController.do?customContactsList&id=${customPage.id}" icon="icon-contact" title="联系人" id="customContacts"></t:tab>
				 <t:tab href="customController.do?customSalesmanList&id=${customPage.id}" icon="icon-sales" title="业务员" id="customSalesman"></t:tab>
				 <%--<t:tab href="customController.do?costCombinationList&id=${customPage.id}" icon="icon-combination" title="费用组合" id="costcombination"></t:tab>--%>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_customContacts_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
                      <input name="customContactsList[#index#].fcontactsName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">联系人名</label>
				  </td>
				  <td align="left">
                      <t:dictSelect field="customContactsList[#index#].fgender" typeGroupCode="sex" hasLabel="false"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">性别</label>
				  </td>
				  <td align="left">
                      <input name="customContactsList[#index#].fphone" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">电话</label>
				  </td>
				  <td align="left">
                      <input name="customContactsList[#index#].fmobile" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="m" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">手机</label>
				  </td>
				  <td align="left">
                      <input name="customContactsList[#index#].fax" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">传真</label>
				  </td>
				  <td align="left">
                      <input name="customContactsList[#index#].femail" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="e" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">邮箱</label>
				  </td>
				  <td align="left">
                      <t:dictSelect field="customContactsList[#index#].fposition" type="list"    typeGroupCode="position"  defaultVal="" hasLabel="false"  title="职位"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">职位</label>
                  </td>
                  <td align="left">
                      <input name="customContactsList[#index#].fnote" maxlength="255" type="text" class="inputxt"  style="width:220px;"  ignore="ignore" />
                      <label class="Validform_label" style="display: none;">备注</label>
                  </td>
			</tr>
		 </tbody>
	<tbody id="add_customSalesman_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
                      <input name="customSalesmanList[#index#].fname" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">业务员名称</label>
				  </td>
				  <td align="left">
                      <input name="customSalesmanList[#index#].fpost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">职务</label>
				  </td>
				  <td align="left">
                      <input name="customSalesmanList[#index#].fphone" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">电话</label>
				  </td>
				  <td align="left">
                      <input name="customSalesmanList[#index#].femail" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">电子邮件</label>
				  </td>
				  <td align="left">
                      <input name="customSalesmanList[#index#].ftc" maxlength="32" type="text" class="inputxt"  style="width:100px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label>%</label>
				  </td>
                  <td align="left">
                      <input name="customSalesmanList[#index#].fnote" maxlength="255" type="text" class="inputxt"  style="width:220px;"  ignore="ignore" />
                      <label class="Validform_label" style="display: none;">备注</label>
                  </td>
			</tr>
		 </tbody>
	<%--<tbody id="add_costCombination_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
                      <input name="costCombinationList[#index#].ftxyard" onclick="popupClick(this,'fyard_name,id','ftxyard,ftxid','yard')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
                      <input name="costCombinationList[#index#].ftxid" maxlength="32" type="text" class="inputxt"  style="width:120px;display: none"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">提箱点</label>
				  </td>
				  &lt;%&ndash;<td align="left">
                      <input name="costCombinationList[#index#].fimport" onclick="popupClick(this,'fyard_name,id','fimport,fimportid','quay')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
                      <input name="costCombinationList[#index#].fimportid" maxlength="32" type="text" class="inputxt"  style="width:120px;display: none"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">进口码头</label>
				  </td>&ndash;%&gt;
				  <td align="left">
                      <input name="costCombinationList[#index#].fload" onclick="popupClick(this,'fname,id','fload,floadid','dp_select')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
                      <input name="costCombinationList[#index#].floadid" maxlength="32" type="text" class="inputxt"  style="width:120px;display: none"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">装货门点</label>
				  </td>
				  <td align="left">
                      <input name="costCombinationList[#index#].fdischarge" onclick="popupClick(this,'fname,id','fdischarge,fdischargeid','dp_select')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
                      <input name="costCombinationList[#index#].fdischargeid" maxlength="32" type="text" class="inputxt"  style="width:120px;display: none"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">卸货门点</label>
				  </td>
				  &lt;%&ndash;<td align="left">
                      <input name="costCombinationList[#index#].fexport" onclick="popupClick(this,'fyard_name,id','fexport,fexportid','quay')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
                      <input name="costCombinationList[#index#].fexportid" maxlength="32" type="text" class="inputxt"  style="width:120px;display: none"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">出口码头</label>
				  </td>&ndash;%&gt;
                  <td align="left">
                      <input name="costCombinationList[#index#].fhxyard" onclick="popupClick(this,'fyard_name,id','fhxyard,fhxid','yard')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
                      <input name="costCombinationList[#index#].fhxid" maxlength="32" type="text" class="inputxt"  style="width:120px;display: none"  ignore="ignore" />
                      <label class="Validform_label" style="display: none;">还箱点</label>
                  </td>
				  <td align="left">
                      <input name="costCombinationList[#index#].fcost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用</label>
				  </td>
				  <td align="left">
                      <input name="costCombinationList[#index#].fhscost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">含税费用</label>
				  </td>
				  <td align="left">
                      <input name="costCombinationList[#index#].frate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">税率</label>
				  </td>
				  <td align="left">
                      <input name="costCombinationList[#index#].fstart" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">开始时间</label>
				  </td>
				  <td align="left">
                      <input name="costCombinationList[#index#].fnote" maxlength="255" type="text" class="inputxt"  style="width:220px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>--%>
		</table>
 </body>
 <script src = "webpage/com/jeecg/custom/custom.js"></script>
 <script src="plug-in/jquery/jquery.regionselect.js" type="text/javascript"></script>
 <script type="text/javascript">
     //省市区下拉
     $(function() {
         $("#province").regionselect({
             url: '<%=basePath%>/jeecgFormDemoController.do?regionSelect'
         });
     });
 </script>