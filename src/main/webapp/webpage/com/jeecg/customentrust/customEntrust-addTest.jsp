<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>客户委托</title>
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
 <%-- <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>--%>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="customEntrustController.do?doAddContianer" >
					<input id="id" name="id" type="hidden" value="${id}"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="center" colspan="8">
				<label class="Validform_label" style="font-weight: bold;font-size: 14px">
					------------------基本--------------------
				</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">箱号:</label>
			</td>
			<td class="value">
				<input id="fboxno" name="fboxno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"/>
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">封号:</label>
			</td>
			<td class="value">
				<input id="ftitle" name="ftitle" type="text" style="width: 150px"  class="inputxt"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">箱型:</label>
			</td>
			<td class="value">
				<input id="fboxtype" name="fboxtype" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">型号:</label>
			</td>
			<td class="value">
				<input id="fmodel" name="fmodel" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">做箱时间:</label>
			</td>
			<td class="value">
		     	 <input id="fmakeboxtime" name="fmakeboxtime" type="text" style="width: 150px" class="Wdate"  ignore="ignore" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">等级:</label>
			</td>
			<td class="value">
				<input id="fgrade" name="fgrade" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">危规页码:</label>
			</td>
			<td class="value" colspan="3">
				<input id="fdrpagenum" name="fdrpagenum" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">联合国编号:</label>
			</td>
			<td class="value">
				<input id="funnumber" name="funnumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">闪点:</label>
			</td>
			<td class="value">
				<input id="flashPoint" name="flashPoint" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">冷藏温度:</label>
			</td>
			<td class="value">
				<input id="fcolddegree" name="fcolddegree" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">总件数:</label>
			</td>
			<td class="value">
				<input id="ftotals" name="ftotals" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">总毛重:</label>
			</td>
			<td class="value">
				<input id="fgrosses" name="fgrosses" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
、				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">总体积:</label>
			</td>
			<td class="value">
		     	 <input id="fvolumes" name="fvolumes" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">提箱点:</label>
			</td>
			<td class="value">
				<input id="fextract" name="fextract" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  onclick="popupClick(this,'fname','fextract','dp_select')"/>
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">还箱点:</label>
			</td>
			<td class="value">
		     	 <input id="freturn" name="freturn" type="text" style="width: 150px" class="inputxt"  ignore="ignore" onclick="popupClick(this,'fname','freturn','dp_select')"/>
				<span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">集装箱经营人:</label>
			</td>
			<td class="value">
		     	 <input id="foperator" name="foperator" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">装货门点:</label>
			</td>
			<td class="value">
		     	 <input id="fzhdp" name="fzhdp" type="text" style="width: 150px" class="inputxt"  ignore="ignore" onclick="popupClick(this,'fitemid,fname,farea,fcontact,fmobile','fzhdp,fzhdpdz,fzhunit,fzhcontact,fzhmobile','dp_select')" />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">门点地址:</label>
			</td>
			<td class="value" colspan="3">
				<input id="fzhdpdz" name="fzhdpdz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"/>
				<span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">装货单位:</label>
			</td>
			<td class="value" colspan="5">
				<input id="fzhunit" name="fzhunit" type="text" style="width: 150px" class="inputxt"  ignore="ignore"/>
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label" hidden="true">联系人:</label>
			</td>
			<td class="value" align="center">
			    <input id="fzhcontact" name="fzhcontact" type="text" style="width: 150px" class="inputxt"  ignore="ignore"/>
				<span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">联系电话:</label>
			</td>
			<td class="value">
		     	 <input id="fzhmobile" name="fzhmobile" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value">
		     	 <input id="fnote" name="fnote" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">特殊业务:</label>
			</td>
			<td class="value">
				<input id="ftsyw" name="ftsyw" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">卸货门点:</label>
			</td>
			<td class="value">
				<input id="fxhdp" name="fxhdp" type="text" style="width: 150px" class="inputxt"  ignore="ignore" onclick="popupClick(this,'fitemid,fname,farea,fcontact,fmobile','fxhdp,fxhdpdz,fxhunit,fxhcontact,fxhmobile','dp_select')"/>
				<span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">门点地址:</label>
			</td>
			<td class="value">
				<input id="fxhdpdz" name="fxhdpdz" type="text" style="width: 150px"  class="inputxt" ignore="ignore"  />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">卸货时间:</label>
			</td>
			<td class="value">
		     	 <input id="fxhtime" name="fxhtime" type="text" style="width: 150px" class="Wdate"  ignore="ignore" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">卸货单位:</label>
			</td>
			<td class="value">
		     	 <input id="fxhunit" name="fxhunit" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">联系人:</label>
			</td>
			<td class="value">
		     	 <input id="fxhcontact" name="fxhcontact" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">联系人电话:</label>
			</td>
			<td class="value">
		     	 <input id="fxhmobile" name="fxhmobile" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
			</td>
			
		</tr>
	</table>
			<div style="width: 3840px;height: 200px;">
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <%--<t:tab href="customEntrustController.do?detailList&id=${customEntrustPage.id}" icon="icon-server" title="门点信息" id="cusdp"></t:tab>--%>
				 <t:tab href="detailController.do?detailList&id=${customEntrustPage.id}" icon="icon-box" title="集装箱明细" id="contianer"></t:tab>
       <%--           <t:tab href="customEntrustController.do?costList&id=${customEntrustPage.id}" icon="icon-money" title="费用" id="cost"></t:tab> --%>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
<table style="display:none">
	<tbody id="add_contianer_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  <input name="detailList[#index#].fbillno"  maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					   <label class="Validform_label" style="display: none;">提单号</label>
				  </td>
				  <td align="left">
					  <input name="detailList[#index#].fname" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">货名</label>
				  </td>
				  <td align="left">
					  <input name="detailList[#index#].fmaitou" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">唛头</label>
				  </td>
				 
				  <td align="left">
					  <input name="detailList[#index#].fpackage" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">包装</label>
				  </td>

				  <td align="left">
					  <input name="detailList[#index#].fqty" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">件数</label>
				  </td>
				  <td align="left">
					  <input name="detailList[#index#].fgross" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">毛重</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/customentrust/customEntrust.js"></script>
	