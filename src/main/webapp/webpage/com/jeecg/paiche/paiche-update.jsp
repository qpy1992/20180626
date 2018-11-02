<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>统一派车单管理</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="paicheController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${paichePage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<label class="Validform_label" style="font-size: 20px;font-weight: bold;font-style: italic;color: #0a82eb">${paichePage.fcarno}(${paichePage.fbanci})</label>
			<label class="Validform_label" style="font-size: 20px;font-weight: bold;font-style: italic;color: #70070d">${paichePage.fcarcode}</label>
			<label class="Validform_label" style="font-size: 20px;font-weight: bold;color: #ff0000;margin-left: 500px">${paichePage.fstatus}</label>
			<label class="Validform_label" style="font-size: 20px;font-weight: bold;color: #ff0000;">${paichePage.ftype}</label>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">派车单号:</label>
			</td>
			<td class="value">
				<label class="Validform_label" style="font-weight: bold;color: #0a82eb">${paichePage.fbillno}</label>
			</td>
            <td align="right">
                <label class="Validform_label">门点区域:</label>
            </td>
            <td class="value">
                <input id="fdoorpoint" name="fdoorpoint" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paichePage.fdoorpoint}'/>
            </td>
            <td align="right">
                <label class="Validform_label">外委:</label>
            </td>
            <td class="value">
                <t:dictSelect field="fwaiwei" typeGroupCode="sf_yn" type="radio" hasLabel="false" defaultVal="${paichePage.fwaiwei}"></t:dictSelect>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">双拖:</label>
            </td>
            <td class="value">
                <t:dictSelect field="ftype2" typeGroupCode="sf_yn" type="radio" hasLabel="false" defaultVal="${paichePage.ftype2}"></t:dictSelect>
            </td>

            <td align="right">
                <label class="Validform_label">套箱:</label>
            </td>
            <td class="value">
                <t:dictSelect field="ftaoxiang" typeGroupCode="sf_yn" type="radio" hasLabel="false" defaultVal="${paichePage.ftaoxiang}"></t:dictSelect>
            </td>

            <td align="right">
                <label class="Validform_label">直装:</label>
            </td>
            <td class="value">
                <t:dictSelect field="fzhizhuang" typeGroupCode="sf_yn" type="radio" hasLabel="false" defaultVal="${paichePage.fzhizhuang}"></t:dictSelect>
            </td>
		</tr>
		<tr>
            <td align="right">
                <label class="Validform_label">继续业务:</label>
            </td>
            <td class="value">
                <t:dictSelect field="ftype3" typeGroupCode="sf_yn" type="radio" hasLabel="false" defaultVal="${paichePage.ftype3}"></t:dictSelect>
            </td>
            <td align="right">
                <label class="Validform_label">抢修:</label>
            </td>
            <td class="value">
                <t:dictSelect field="ftype4" typeGroupCode="sf_yn" type="radio" hasLabel="false" defaultVal="${paichePage.ftype4}"></t:dictSelect>
            </td>
            <td align="right">
                <label class="Validform_label">回程配载:</label>
            </td>
            <td class="value">
                <t:dictSelect field="ftype5" typeGroupCode="sf_yn" type="radio" hasLabel="false" defaultVal="${paichePage.ftype5}"></t:dictSelect>
            </td>
		</tr>
		<tr>
            <td align="right">
                <label class="Validform_label">运输方式:</label>
            </td>
            <td class="value">
                <t:dictSelect field="ftranstype" typeGroupCode="ftranstype" hasLabel="false" defaultVal="${paichePage.ftranstype}"></t:dictSelect>
            </td>
            <td align="right">
                <label class="Validform_label">主司机:</label>
            </td>
            <td class="value">
                <input id="fdriver" name="fdriver" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paichePage.fdriver}'/>
            </td>
			<td align="right">
				<label class="Validform_label">副司机:</label>
			</td>
			<td class="value">
		     	 <input id="fdriver2" name="fdriver2" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paichePage.fdriver2}'/>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">货重:</label>
			</td>
			<td class="value">
		     	 <input id="fweight" name="fweight" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paichePage.fweight}'/>
			</td>
			<td align="right">
				<label class="Validform_label">皮重:</label>
			</td>
			<td class="value">
		     	 <input id="fweight2" name="fweight2" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paichePage.fweight2}'/>
			</td>
            <td align="right">
                <label class="Validform_label">挂车编号:</label>
            </td>
            <td class="value">
                <input id="fgcbillno" name="fgcbillno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paichePage.fgcbillno}'/>
            </td>
		</tr>
		<tr>
            <td align="right">
                <label class="Validform_label">出场路码:</label>
            </td>
            <td class="value">
                <input id="fcccode" name="fcccode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paichePage.fcccode}'/>
            </td>
            <td align="right">
                <label class="Validform_label">进场路码:</label>
            </td>
            <td class="value">
                <input id="fjccode" name="fjccode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paichePage.fjccode}'/>
            </td>
			<td align="right">
				<label class="Validform_label">起始地:</label>
			</td>
			<td class="value">
		     	 <input id="fstart" name="fstart" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paichePage.fstart}'/>
			</td>
        </tr>
        <tr>
			<td align="right">
				<label class="Validform_label">终止地:</label>
			</td>
			<td class="value">
		     	 <input id="fend" name="fend" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${paichePage.fend}'/>
			</td>
			<td align="right">
				<label class="Validform_label">运输要求:</label>
			</td>
			<td class="value" colspan="3">
                <textarea id="frequire" style="width:600px;" class="inputxt" rows="6" name="frequire"  ignore="ignore" >${paichePage.frequire}</textarea>
			</td>
            <input id="createDate" name="createDate" type="text" class="inputxt" style="width: 150px;display: none" value="${paichePage.createDate}"/>
		</tr>
	</table>
  </t:formvalid>
 </body>
 <script src = "webpage/com/jeecg/paiche/paiche.js"></script>	
