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
	  bbxcost: 1px solid transparent;
	  bbxcost-radius: 4px;
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="baoxiaoController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${baoxiaoPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<%--<td align="right">
				<label class="Validform_label">报销单号:</label>
			</td>
			<td class="value">
		     	 <input id="fbxno" name="fbxno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">报销单号</label>
			</td>--%>
			<td align="right">
				<label class="Validform_label">申请人:</label>
			</td>
			<td class="value">
		     	 <input id="fapplyer" name="fapplyer" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">申请人</label>
			</td>

			<td align="right">
				<label class="Validform_label">申请日期:</label>
			</td>
			<td class="value">
					  <input id="fapplydate" name="fapplydate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">申请日期</label>
			</td>
			<%--<td align="right">
				<label class="Validform_label">审核:</label>
			</td>
			<td class="value">
		     	 <input id="fcheck" name="fcheck" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核</label>
			</td>--%>
		</tr>
		<%--<tr>
			<td align="right">
				<label class="Validform_label">审核人:</label>
			</td>
			<td class="value">
		     	 <input id="fchecker" name="fchecker" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核人</label>
			</td>
			<td align="right">
				<label class="Validform_label">审核日期:</label>
			</td>
			<td class="value">
					  <input id="fcheckdate" name="fcheckdate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核日期</label>
			</td>
		</tr>--%>
		<tr>
			<td align="right" hidden="hidden">
				<label class="Validform_label">金额:</label>
			</td>
			<td class="value" hidden="hidden">
		     	 <input id="famount" name="famount" type="text" style="width: 150px" onclick="sf()" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" value="0"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">金额</label>
			</td>
			<%--<td align="right">
				<label class="Validform_label">核销金额:</label>
			</td>
			<td class="value">
		     	 <input id="fhxamount" name="fhxamount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">核销金额</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">核销状态:</label>
			</td>
			<td class="value">
		     	 <input id="fhxstatus" name="fhxstatus" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">核销状态</label>
			</td>--%>
			<td align="right">
				<label class="Validform_label">报销人:</label>
			</td>
			<td class="value" colspan="3">
		     	 <input id="fbxman" name="fbxman" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">报销人</label>
			</td>
		</tr>
		<%--<tr>
			<td align="right">
				<label class="Validform_label">币种:</label>
			</td>
			<td class="value">
		     	 <input id="fcurrency" name="fcurrency" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">币种</label>
			</td>
		</tr>--%>
	
		<tr>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value" colspan="3">
				  <textarea id="fnote" style="width:600px;" class="inputxt" rows="6" name="fnote"  ignore="ignore" ></textarea>
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
                  <td align="left" hidden="hidden">
                        <input name="bxcostList[#index#].costid" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
                      <label class="Validform_label" style="display: none;">费用主键</label>
                  </td>
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
					  <%--<t:dictSelect field="bxcostList[#index#].fdaidian" hasLabel="false" typeGroupCode="sf_yn"></t:dictSelect>--%>
                      <input name="bxcostList[#index#].fdadian" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
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
 <input type="hidden" id="winOpener"/>
 <script src = "webpage/com/jeecg/baoxiao/baoxiao.js"></script>
 <script type="text/javascript">
     var ids;
     var idlist = '';
     function addfee(){
         $('input[name="costid"]').each(function(){
             idlist = idlist+$(this).val()+',';
         })
         W.$.dialog({
             content: 'url:chargeController.do?list3&idlist='+idlist,
             lock : true,
             width:'1300px',
             height: '500px',
             parent:windowapi,
             title:'费用列表',
             opacity : 0.3,
             cache:false,
             button: [
                 {
                     name: "确认",
                     callback: function(){
                         <%--var wlval = <%=request.getParameter("winOpener")%>--%>
						 // var ids = ['40288a60654552f0016545a1fdcc0008','40288a60654552f0016545a1fdcc0008','40288a60654552f00165459abed00006','40288a606541948601654196f2f20001'];
                         ids = window.localStorage.getItem("ids");
                         window.localStorage.removeItem("ids");
                         $.ajax({
                             type : "POST",
                             url : 'baoxiaoController.do?baoxiao',
                             crossDomain : true,
                             data: 'ids='+ids,
                             success : function(data) {
                                 var dataobj = eval("("+data+")");
                                 var jine = parseFloat($('#famount').val());
                                 for(var num=0;num<dataobj.length;num++){
                                     var datatr = " <tr>";
                                     datatr += "<td bgcolor='#EEEEEE'><div style='width: 25px;' name='xh'>num</div></td>";
                                     datatr += "<td bgcolor='#EEEEEE'><input class='inputxt'  ignore='ignore' type='checkbox' style='width: 55px'></td>";
                                     datatr +=  "<td bgcolor='#EEEEEE' hidden='hidden'><input maxlength='50' type='text' style='width: 120px;' id='costid' name='bxcostList["+num+"].costid' ignore='ignore' readonly='readonly'  value='"+dataobj[num].id+"'></td>";
                                     datatr +=  "<td bgcolor='#EEEEEE'><input maxlength='50' type='text' style='width: 120px;' name='bxcostList["+num+"].fweituo' ignore='ignore' readonly='readonly'  value='"+dataobj[num].fweituo+"'></td>";
                                     datatr +=  "<td bgcolor='#EEEEEE'><input maxlength='50' type='text' style='width: 120px;' name='bxcostList["+num+"].fbrno' ignore='ignore' readonly='readonly'  value='"+dataobj[num].fblno+"'></td>";
                                     datatr +=  "<td bgcolor='#EEEEEE'><input maxlength='50' type='text' style='width: 120px;' name='bxcostList["+num+"].fcost' ignore='ignore' readonly='readonly'  value='"+dataobj[num].fcost+"'></td>";
                                     datatr +=  "<td bgcolor='#EEEEEE'><input maxlength='50' type='text' style='width: 120px;' name='bxcostList["+num+"].fsettle' ignore='ignore' readonly='readonly' value='"+dataobj[num].fsettle+"'></td>";
                                     datatr +=  "<td bgcolor='#EEEEEE'><input maxlength='50' type='text' style='width: 120px;' name='bxcostList["+num+"].fsettlename' ignore='ignore' readonly='readonly' value='"+dataobj[num].fsettlename+"'></td>";
                                     datatr +=  "<td bgcolor='#EEEEEE'><input maxlength='50' type='text' style='width: 120px;' name='bxcostList["+num+"].fpaiche' ignore='ignore' readonly='readonly' value='"+dataobj[num].paiche+"'></td>";
                                     datatr +=  "<td bgcolor='#EEEEEE'><input maxlength='50' type='text' style='width: 120px;' name='bxcostList["+num+"].fboxno' ignore='ignore' readonly='readonly' value='"+dataobj[num].fboxno+"'></td>";
                                     datatr +=  "<td bgcolor='#EEEEEE'><input maxlength='50' type='text' style='width: 120px;' name='bxcostList["+num+"].famount' ignore='ignore' readonly='readonly' value='"+dataobj[num].famount+"'></td>";
                                     datatr +=  "<td bgcolor='#EEEEEE'><input maxlength='50' type='text' style='width: 120px;' name='bxcostList["+num+"].fsfamount' ignore='ignore' value='"+dataobj[num].fsfamount+"'></td>";
                                     datatr +=  "<td bgcolor='#EEEEEE'><input maxlength='50' type='text' style='width: 120px;' name='bxcostList["+num+"].fdaidian' ignore='ignore' readonly='readonly' value='"+dataobj[num].fdd+"'></td>";
                                     datatr +=  "<td bgcolor='#EEEEEE'><input maxlength='50' type='text' style='width: 120px;' name='bxcostList["+num+"].finstruction' ignore='ignore' readonly='readonly' value='"+dataobj[num].fnote+"'></td>";
                                     datatr += "<td bgcolor='#EEEEEE' style='display:none;'><input maxlength='50' type='text' style='width: 50px;' name='bxcostList["+num+"].id' ignore='ignore' readonly='readonly' value=''></td></tr>";
                                     $("#add_bxcost_table").append(datatr);
                                     resetTrNum('add_bxcost_table');
                                     jine = jine + dataobj[num].fsfamount;
                                 }
                                     $('#famount').val(jine);
                             }
                         })
                     },
                 },
                 {
                     name: "关闭",
                 }]
         }).zindex();
     }
 </script>
	