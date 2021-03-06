<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>集装箱</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="contianerController.do?doUpdate" beforeSubmit="GetCntr()">
					<input id="id" name="id" type="hidden" value="${contianerPage.id }"/>
      <input id="fid" name="fid" type="hidden" style="width: 150px" class="inputxt"  ignore="ignore" value="${cid}"/>
      <input id="cid1" name="cid1" type="hidden" style="width: 150px" class="inputxt"  ignore="ignore" value="${contianerPage.cid1}"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
        <tr>
            <label class="Validform_label" style="font-size: 20px;font-weight: bold;color: #D53F40">项目</label>
        </tr>
		<tr>
			<td align="right">
				<label class="Validform_label">箱号:</label>
			</td>
			<td class="value">
		     	 <input id="fboxno" name="fboxno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fboxno}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">箱号</label>
			</td>
            <td align="right">
                <label class="Validform_label">箱类:</label>
            </td>
            <td class="value">
                <t:dictSelect id="fmodel" field="fmodel" hasLabel="false" typeGroupCode="model"  defaultVal="${contianerPage.fmodel}"></t:dictSelect>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">箱类</label>
            </td>
			<td align="right">
				<label class="Validform_label">箱型:</label>
			</td>
			<td class="value">
				<t:dictSelect field="fboxtype" hasLabel="false" typeGroupCode="boxtype"  defaultVal="${contianerPage.fboxtype}"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">箱型</label>
			</td>
            <%--<td align="right">
                <label class="Validform_label">做箱时间:</label>
            </td>
            <td class="value">
                <input id="fmakeboxtime" name="fmakeboxtime" type="text" style="width: 150px" class="Wdate"  datatype="*"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"    value='<fmt:formatDate value='${contianerPage.fmakeboxtime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">做箱时间</label>
            </td>--%>
		</tr>
        <tr>
            <td align="right">
                <label class="Validform_label">冷藏温度:</label>
            </td>
            <td class="value">
                <input id="fcolddegree" name="fcolddegree" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fcolddegree}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">冷藏温度</label>
            </td>
            <td align="right">
                <label class="Validform_label">加热温度:</label>
            </td>
            <td class="value">
                <input id="fhot" name="fhot" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${contianerPage.fhot}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">加热温度</label>
            </td>
            <td align="right">
                <label class="Validform_label">货物名称:</label>
            </td>
            <td class="value">
                <input id="funnumber" name="funnumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.funnumber}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">货物名称</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">装货时间:</label>
            </td>
            <td class="value">
                <input id="fzhtime" name="fzhtime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" value='<fmt:formatDate value='${contianerPage.fzhtime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">装货时间</label>
            </td>
            <td align="right">
                <label class="Validform_label">装货门点:</label>
            </td>
            <td class="value">
                <input id="fzhdp" name="fzhdp" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fzhdp}'/>
                <input id="cid1" name="cid1" type="text" style="width: 150px;display: none" class="inputxt"  ignore="ignore" value="${contianerPage.cid1}"/>
                <input id="cid" name="cid" type="hidden" class="inputxt" ignore="ignore" value="${entrustPage.cid}"/>
                <t:choose hiddenName="cid" hiddenid="" url="contianerController.do?list1" name="costCombinationList" icon="icon-search" textname="id,ftxyard,fload,fzhdpdz,fzhunit,fzhcontact,fzhmobile,fdischarge,fxhdpdz,fxhunit,fxhcontact,fxhmobile,fhxyard"
                          inputTextname="cid1,fextract,fzhdp,fzhdpdz,fzhunit,fzhcontact,fzhmobile,fxhdp,fxhdpdz,fxhunit,fxhcontact,fxhmobile,freturn" isInit="true" isclear="true" width="800" height="300"></t:choose>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">装货门点</label>
            </td>
            <td align="right">
                <label class="Validform_label">装货地址:</label>
            </td>
            <td class="value">
                <input id="fzhdpdz" name="fzhdpdz" type="text" style="width: 300px" class="inputxt"  ignore="ignore"  value='${contianerPage.fzhdpdz}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">装货地址</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">联系人:</label>
            </td>
            <td class="value">
                <input id="fzhcontact" name="fzhcontact" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fzhcontact}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">联系人</label>
            </td>
            <td align="right">
                <label class="Validform_label">联系电话:</label>
            </td>
            <td class="value">
                <input id="fzhmobile" name="fzhmobile" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fzhmobile}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">联系电话</label>
            </td>
            <td align="right">
                <label class="Validform_label">装货封号:</label>
            </td>
            <td class="value">
                <c:if test="${contianerPage.fmodel =='TK'}">
                    <input id="ftitle" name="ftitle" type="text" style="width: 80px"  placeholder="底阀" class="inputxt"  ignore="ignore"  value='${contianerPage.ftitle}'/>
                    <input id="fmanhole" name="fmanhole" type="text" style="width: 80px" placeholder="人孔" class="inputxt"  ignore="ignore"  value='${contianerPage.fmanhole}'/>
                    <input id="fvalve" name="fvalve" type="text" style="width: 80px" placeholder="气阀" class="inputxt"  ignore="ignore"  value='${contianerPage.fvalve}'/>
                </c:if>
                <c:if test="${contianerPage.fmodel !='TK'}">
                    <input id="ftitle" name="ftitle" type="text" style="width: 150px" placeholder="底阀" class="inputxt"  ignore="ignore"  value='${contianerPage.ftitle}'/>
                </c:if>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">装货封号</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">委托装货重量:</label>
            </td>
            <td class="value">
                <input id="fwtzhweight" name="fwtzhweight" type="text" style="width: 150px"  datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  ignore="ignore" value="${contianerPage.fwtzhweight}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">委托装货重量</label>
            </td>
            <td align="right">
                <label class="Validform_label">实际装货重量:</label>
            </td>
            <td class="value">
                <input id="fzhweight" name="fzhweight" type="text" style="width: 150px"  datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  ignore="ignore" value="${contianerPage.fzhweight}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">实际装货重量</label>
            </td>
            <td align="right">
                <label class="Validform_label">第三方过磅:</label>
            </td>
            <td class="value">
                <input id="fother" name="fother" type="text" style="width: 150px"  datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  ignore="ignore" value="${contianerPage.fother}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">第三方过磅</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">卸货时间:</label>
            </td>
            <td class="value">
                <input id="fxhtime" name="fxhtime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${contianerPage.fxhtime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">卸货时间</label>
            </td>
            <td align="right">
                <label class="Validform_label">卸货门点:</label>
            </td>
            <td class="value">
                <input id="fxhdp" name="fxhdp" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${contianerPage.fxhdp}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">卸货门点</label>
            </td>
            <td align="right">
                <label class="Validform_label">卸货地址:</label>
            </td>
            <td class="value">
                <input id="fxhdpdz" name="fxhdpdz" type="text" style="width: 300px" class="inputxt"  ignore="ignore"  value="${contianerPage.fxhdpdz}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">卸货地址</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">联系人:</label>
            </td>
            <td class="value">
                <input id="fxhcontact" name="fxhcontact" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${contianerPage.fxhcontact}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">联系人</label>
            </td>
            <td align="right">
                <label class="Validform_label">联系电话:</label>
            </td>
            <td class="value">
                <input id="fxhmobile" name="fxhmobile" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${contianerPage.fxhmobile}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">联系电话</label>
            </td>
            <td align="right">
                <label class="Validform_label">卸货封号:</label>
            </td>
            <td class="value">
                <c:if test="${contianerPage.fmodel =='TK'}">
                    <input id="ftitle1" name="ftitle1" type="text" datatype="*" placeholder="底阀" style="width: 80px" class="inputxt"  ignore="ignore"  value="${contianerPage.ftitle1}"/>
                    <input id="fmanhole1" name="fmanhole1" type="text" datatype="*" placeholder="人孔" style="width: 80px" class="inputxt"  ignore="ignore"  value="${contianerPage.fmanhole1}"/>
                    <input id="fvalve1" name="fvalve1" type="text" datatype="*" placeholder="气阀" style="width: 80px" class="inputxt"  ignore="ignore"  value="${contianerPage.fvalve1}"/>
                </c:if>
                <c:if test="${contianerPage.fmodel !='TK'}">
                    <input id="ftitle1" name="ftitle1" type="text" datatype="*" placeholder="底阀" style="width: 150px" class="inputxt"  ignore="ignore"  value="${contianerPage.ftitle1}"/>
                </c:if>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">卸货封号</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">委托卸货重量:</label>
            </td>
            <td class="value">
                <input id="fwtxhweight" name="fwtxhweight" type="text" style="width: 150px"  datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  ignore="ignore"  value="${contianerPage.fwtxhweight}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">委托卸货重量</label>
            </td>
            <td align="right">
                <label class="Validform_label">实际卸货重量:</label>
            </td>
            <td class="value">
                <input id="fxhweight" name="fxhweight" type="text" style="width: 150px"  datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  ignore="ignore"  value="${contianerPage.fxhweight}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">实际卸货重量</label>
            </td>
            <td align="right">
                <label class="Validform_label">第三方过磅:</label>
            </td>
            <td class="value">
                <input id="fother1" name="fother1" type="text" style="width: 150px"  datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  ignore="ignore"  value="${contianerPage.fother1}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">第三方过磅</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">提箱点:</label>
            </td>
            <td class="value">
                <input id="fextract" name="fextract" type="text" style="width: 300px" class="inputxt"  ignore="ignore"  value='${contianerPage.fextract}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">提箱点</label>
            </td>
            <td align="right">
                <label class="Validform_label">还箱点:</label>
            </td>
            <td class="value">
                <input id="freturn" name="freturn" type="text" style="width: 300px" class="inputxt"  ignore="ignore"  value='${contianerPage.freturn}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">还箱点</label>
            </td>
            <td align="right">
                <label class="Validform_label">磅差:</label>
            </td>
            <td class="value">
                <input id="fbang" name="fbang" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${contianerPage.fbang}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">磅差</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">箱重:</label>
            </td>
            <td class="value">
                <input id="fboxweight" name="fboxweight" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${contianerPage.fboxweight}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">箱重</label>
            </td>
            <td align="right">
                <label class="Validform_label">到场时间:</label>
            </td>
            <td class="value">
                <input id="fdao" name="fdao" type="text" style="width: 150px" class="Wdate"  ignore="ignore" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  value='<fmt:formatDate value='${contianerPage.fdao}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">到场时间</label>
            </td>
            <td align="right">
                <label class="Validform_label">离场时间:</label>
            </td>
            <td class="value" colspan="3">
                <input id="fli" name="fli" type="text" style="width: 150px" class="Wdate"  ignore="ignore" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  value='<fmt:formatDate value='${contianerPage.fli}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">离场时间</label>
            </td>
        </tr>








		<%--<c:if test="${contianerPage.fmodel =='TK'}">
		<tr>

            <td align="right">
                <label class="Validform_label">封号:</label>
            </td>
            <td class="value" id="ft">
                <input id="ftitle" name="ftitle" type="text" style="width: 80px" class="inputxt"  ignore="ignore"  value='${contianerPage.ftitle}'/>
                <input id="fmanhole" name="fmanhole" type="text" style="width: 80px" class="inputxt"  ignore="ignore"  value='${contianerPage.fmanhole}'/>
                <input id="fvalve" name="fvalve" type="text" style="width: 80px" class="inputxt"  ignore="ignore"  value='${contianerPage.fvalve}'/>
            <span class="Validform_checktip"></span>
            <label class="Validform_label" style="display: none;">封号</label>
			<td align="right" id="fti">
				<label class="Validform_label">卸货封号:</label>
			</td>
			<td class="value" id="fti1">
				<input id="ftitle1" name="ftitle1" type="text" style="width: 80px" class="inputxt"  ignore="ignore"  value='${contianerPage.ftitle1}'/>
				<input id="fmanhole1" name="fmanhole1" type="text" style="width: 80px" class="inputxt"  ignore="ignore"  value='${contianerPage.fmanhole1}'/>
				<input id="fvalve1" name="fvalve1" type="text" style="width: 80px" class="inputxt"  ignore="ignore"  value='${contianerPage.fvalve1}'/>
            <span class="Validform_checktip"></span>
            <label class="Validform_label" style="display: none;">卸货封号</label>
		</tr>
		</c:if>
        <c:if test="${contianerPage.fmodel !='TK'}">
            <tr>
                <td align="right">
                    <label class="Validform_label">箱类:</label>
                </td>
                <td class="value">
                    <t:dictSelect id="fmodel" field="fmodel" hasLabel="false" typeGroupCode="model"  defaultVal="${contianerPage.fmodel}"></t:dictSelect>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">箱类</label>
                </td>

                <td align="right" id="fti" hidden>
                    <label class="Validform_label">卸货封号:</label>
                </td>
                <td class="value" id="fti1" colspan="3" hidden>
                    <input id="ftitle1" name="ftitle1" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.ftitle1}'/>
                    <input id="fmanhole1" name="fmanhole1" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fmanhole1}'/>
                    <input id="fvalve1" name="fvalve1" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fvalve1}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">卸货封号</label>
            </tr>
        </c:if>

        <c:if test="${entrustPage.fgoodsprop == '2'}">
        <tr>
            <td align="right">
                <label class="Validform_label">闪点:</label>
            </td>
            <td class="value">
                <input id="flashPoint" name="flashPoint" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.flashPoint}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">闪点</label>
            </td>
            <td align="right">
                <label class="Validform_label">等级:</label>
            </td>
            <td class="value">
                <input id="fgrade" name="fgrade" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fgrade}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">等级</label>
            </td>
            <td align="right">
                <label class="Validform_label">危规页码:</label>
            </td>
            <td class="value">
                <input id="fdrpagenum" name="fdrpagenum" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fdrpagenum}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">危规页码</label>
            </td>
        </tr>
        </c:if>
        <c:if test="${entrustPage.fbussType == '0'}">
            <tr>
                <td align="right">
                    <label class="Validform_label">装船港:</label>
                </td>
                <td class="value">
                    <input id="floadport" name="floadport" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.floadport}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">装船港</label>
                </td>
                <td align="right">
                    <label class="Validform_label">中转港:</label>
                </td>
                <td class="value">
                    <input id="ftransfer" name="ftransfer" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.ftransfer}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">中转港</label>
                </td>
                <td align="right">
                    <label class="Validform_label">目的港:</label>
                </td>
                <td class="value">
                    <input id="ftarget" name="ftarget" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.ftarget}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">目的港</label>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label class="Validform_label">船名:</label>
                </td>
                <td class="value">
                    <input id="fvoyage" name="fvoyage" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fvoyage}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">船名</label>
                </td>
                <td align="right">
                    <label class="Validform_label">航次:</label>
                </td>
                <td class="value">
                    <input id="fvoyagenum" name="fvoyagenum" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fvoyagenum}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">航次</label>
                </td>

            </tr>
            <tr>
                <td align="right">
                    <label class="Validform_label">集装箱经营人:</label>
                </td>
                <td class="value">
                    <input id="foperator" name="foperator" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.foperator}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">集装箱经营人</label>
                </td>

            </tr>
            <tr>

                <td align="right">
                    <label class="Validform_label">装货重量:</label>
                </td>
                <td class="value">
                    <input id="fzhweight" name="fzhweight" type="text" style="width: 150px"  datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  ignore="ignore" value="${contianerPage.fzhweight}"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">装货重量</label>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label class="Validform_label">还箱点:</label>
                </td>
                <td class="value" colspan="5">
                    <input id="freturn" name="freturn" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.freturn}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">还箱点</label>
                </td>
            </tr>
        </c:if>
        <c:if test="${entrustPage.fbussType == '1'}">
            <tr>
                <td align="right">
                    <label class="Validform_label">船名:</label>
                </td>
                <td class="value">
                    <input id="fvoyage" name="fvoyage" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fvoyage}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">船名</label>
                </td>
                <td align="right">
                    <label class="Validform_label">航次:</label>
                </td>
                <td class="value">
                    <input id="fvoyagenum" name="fvoyagenum" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fvoyagenum}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">航次</label>
                </td>
                <td align="right">
                    <label class="Validform_label">联合国编号:</label>
                </td>
                <td class="value">
                    <input id="funnumber" name="funnumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.funnumber}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">联合国编号</label>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label class="Validform_label">集装箱经营人:</label>
                </td>
                <td class="value">
                    <input id="foperator" name="foperator" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.foperator}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">集装箱经营人</label>
                </td>
                <td align="right">
                    <label class="Validform_label">卸货门点:</label>
                </td>
                <td class="value">
                    <input id="fxhdp" name="fxhdp" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fxhdp}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">卸货门点</label>
                </td>
                <td align="right">
                    <label class="Validform_label">门点地址:</label>
                </td>
                <td class="value">
                    <input id="fxhdpdz" name="fxhdpdz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fxhdpdz}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">门点地址</label>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label class="Validform_label">卸货时间:</label>
                </td>
                <td class="value">
                    <input id="fxhtime" name="fxhtime" type="text" style="width: 150px" class="Wdate"  ignore="ignore" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  value='<fmt:formatDate value='${contianerPage.fxhtime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">卸货时间</label>
                </td>
                <td align="right">
                    <label class="Validform_label">联系人:</label>
                </td>
                <td class="value">
                    <input id="fxhcontact" name="fxhcontact" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fxhcontact}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">联系人</label>
                </td>
                <td align="right">
                    <label class="Validform_label">联系电话:</label>
                </td>
                <td class="value">
                    <input id="fxhmobile" name="fxhmobile" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fxhmobile}'/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">联系电话</label>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label class="Validform_label">卸货重量:</label>
                </td>
                <td class="value">
                    <input id="fxhweight" name="fxhweight" type="text" style="width: 150px"  datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  ignore="ignore" value="${contianerPage.fxhweight}"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">卸货重量</label>
                </td>
                <td align="right">
                    <label class="Validform_label">卸货件数:</label>
                </td>
                <td class="value">
                    <input id="fxhnum" name="fxhnum" type="text" style="width: 150px"  datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  ignore="ignore" value="${contianerPage.fxhweight}"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">卸货件数</label>
                </td>

            </tr>
        </c:if>
        <c:if test="${entrustPage.fbussType == '2'}">
        <tr>
            <td align="right">
                <label class="Validform_label">装货门点:</label>
            </td>
            <td class="value">
                <input id="fzhdp" name="fzhdp" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fzhdp}'/>
                <input id="fprice" name="fprice" type="text" style="width: 150px;display: none" class="inputxt"  ignore="ignore"   value='${contianerPage.fprice}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">装货门点</label>
            </td>

            <td align="right">
                <label class="Validform_label">门点地址:</label>
            </td>
            <td class="value">
                <input id="fzhdpdz" name="fzhdpdz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fzhdpdz}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">门点地址</label>
            </td>
            <td align="right">
                <label class="Validform_label">联系人:</label>
            </td>
            <td class="value">
                <input id="fzhcontact" name="fzhcontact" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fzhcontact}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">联系人</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">联系电话:</label>
            </td>
            <td class="value">
                <input id="fzhmobile" name="fzhmobile" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fzhmobile}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">联系电话</label>
            </td>
			<td align="right">
				<label class="Validform_label">装货重量:</label>
			</td>
			<td class="value">
				<input id="fzhweight" name="fzhweight" type="text" style="width: 150px"  datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  ignore="ignore" value="${contianerPage.fzhweight}"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">装货重量</label>
			</td>
            <td align="right">
                <label class="Validform_label">卸货门点:</label>
            </td>
            <td class="value">
                <input id="fxhdp" name="fxhdp" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fxhdp}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">卸货门点</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">门点地址:</label>
            </td>
            <td class="value">
                <input id="fxhdpdz" name="fxhdpdz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fxhdpdz}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">门点地址</label>
            </td>
            <td align="right">
                <label class="Validform_label">卸货时间:</label>
            </td>
            <td class="value">
                <input id="fxhtime" name="fxhtime" type="text" style="width: 150px" class="Wdate"  ignore="ignore" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  value='<fmt:formatDate value='${contianerPage.fxhtime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">卸货时间</label>
            </td>
            <td align="right">
                <label class="Validform_label">联系人:</label>
            </td>
            <td class="value">
                <input id="fxhcontact" name="fxhcontact" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fxhcontact}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">联系人</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">联系电话:</label>
            </td>
            <td class="value">
                <input id="fxhmobile" name="fxhmobile" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fxhmobile}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">联系电话</label>
            </td>
            <td align="right">
                <label class="Validform_label">卸货重量:</label>
            </td>
            <td class="value">
                <input id="fxhweight" name="fxhweight" type="text" style="width: 150px"  datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  ignore="ignore" value="${contianerPage.fxhweight}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">卸货重量</label>
            </td>
            <td align="right">
                <label class="Validform_label">卸货件数:</label>
            </td>
            <td class="value">
                <input id="fxhnum" name="fxhnum" type="text" style="width: 150px"  datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  ignore="ignore" value="${contianerPage.fxhweight}"/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">卸货件数</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">还箱点:</label>
            </td>
            <td class="value" colspan="5">
                <input id="freturn" name="freturn" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.freturn}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">还箱点</label>
            </td>
        </tr>
        </c:if>
        <tr>

			<td align="right">
				<label class="Validform_label">特殊业务:</label>
			</td>
			<td class="value">
		     	 <input id="ftsyw" name="ftsyw" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.ftsyw}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">特殊业务</label>
			</td>
        </tr>
        <tr>
			<td align="right">
				<label class="Validform_label">甩挂:</label>
			</td>
			<td class="value">
				<t:dictSelect field="fshuaigua" hasLabel="false" typeGroupCode="sf_yn" type="radio" defaultVal="${contianerPage.fshuaigua}"></t:dictSelect>
			</td>
			<td align="right">
				<label class="Validform_label">驳箱:</label>
			</td>
			<td class="value">
				<t:dictSelect field="fboxiang" hasLabel="fasle" typeGroupCode="sf_yn" type="radio" defaultVal="${contianerPage.fboxiang}"></t:dictSelect>
			</td>
			&lt;%&ndash;<td align="right">
				<label class="Validform_label">对应派车单号:</label>
			</td>
			<td class="value">
		     	 <input id="fbillno" name="fbillno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fbillno}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">对应派车单号</label>
			</td>
			<td align="right">
				<label class="Validform_label">暂落:</label>
			</td>
			<td class="value">
		     	 <input id="fzanluo" name="fzanluo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fzanluo}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">暂落</label>
			</td>&ndash;%&gt;
			<td align="right">
				<label class="Validform_label">预提:</label>
			</td>
			<td class="value">
				<t:dictSelect field="fyuti" hasLabel="fasle" typeGroupCode="sf_yn" type="radio" defaultVal="${contianerPage.fyuti}"></t:dictSelect>
			</td>
		</tr>--%>
		<tr>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value" colspan="5">
				<%--<input id="fnote" name="fnote" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${contianerPage.fnote}'/>--%>
				<textarea id="fnote" style="width:1000px;" class="inputxt" rows="6" name="fnote"  ignore="ignore" >${contianerPage.fnote}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
			</table>
			<%--<div style="width: auto;height: 200px;">
				&lt;%&ndash; 增加一个div，用于调节页面大小，否则默认太小 &ndash;%&gt;
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="contianerController.do?detailList&id=${contianerPage.id}" icon="icon-search" title="箱货明细" id="detail"></t:tab>
				</t:tabs>
			</div>--%>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_detail_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="detailList[#index#].fbillno" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">提单号</label>
				  </td>
				  <td align="left">
					  		<input name="detailList[#index#].fname" placeholder="点击选择" onclick="popupClick(this,'fname,fmark,fpack_type,bpm_status,fgross','fname,fmaitou,fpackage,fqty,fgross','goods')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
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
					  		<input name="detailList[#index#].fqty" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">件数</label>
				  </td>
				  <td align="left">
					  		<input name="detailList[#index#].fgross" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">毛重</label>
				  </td>
				  <td align="left">
					   		<input name="detailList[#index#].fvolume" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">体积</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/contianer/contianer.js"></script>
 <script type="text/javascript">
     function changechar(str)
     {

         if ((str=="a")||(str=="A"))
             return 10;
         else if ((str=="b")||(str=="B"))
             return 12;
         else if ((str=="c")||(str=="C"))
             return 13;
         else if ((str=="d")||(str=="D"))
             return 14;
         else if ((str=="e")||(str=="E"))
             return 15;
         else if ((str=="f")||(str=="F"))
             return 16;
         else if ((str=="g")||(str=="G"))
             return 17;
         else if ((str=="h")||(str=="H"))
             return 18;
         else if ((str=="i")||(str=="I"))
             return 19;
         else if ((str=="j")||(str=="J"))
             return 20;
         else if ((str=="k")||(str=="K"))
             return 21;
         else if ((str=="l")||(str=="L"))
             return 23;
         else if ((str=="m")||(str=="M"))
             return 24;
         else if ((str=="n")||(str=="N"))
             return 25;
         else if ((str=="o")||(str=="O"))
             return 26;
         else if ((str=="p")||(str=="P"))
             return 27;
         else if ((str=="q")||(str=="Q"))
             return 28;
         else if ((str=="r")||(str=="R"))
             return 29;
         else if ((str=="s")||(str=="S"))
             return 30;
         else if ((str=="t")||(str=="T"))
             return 31;
         else if ((str=="u")||(str=="U"))
             return 32;
         else if ((str=="v")||(str=="V"))
             return 34;
         else if ((str=="w")||(str=="W"))
             return 35;
         else if ((str=="x")||(str=="X"))
             return 36;
         else if ((str=="y")||(str=="Y"))
             return 37;
         else if ((str=="z")||(str=="Z"))
             return 38;
         else
             return -1000;
//if ((str=="a")||(str=="A"))
//return 10;
//else if (str=="b")
//return 1;
//else
//return 7;
     }
     function GetCntr() {
         var strcntr = $("#fboxno").val();
         var num = new Array(10)
         for (i=0;i<11;i++)
         {
             num[i]=0;
         }
         test=strcntr;//prompt("请输入需校验的集装箱编码","◎◎◎◎×××××××")
         len=test.length;
         if (len != 11)
         {
             alert("请重新输入11位的集装箱编码！");
             return false;
             //location.reload();
         }
         else
         {
             exp=/^[A-Za-z]{4}[0-9]{7}$/g;
             if (!exp.test(test))
             {
                 alert("集装箱编码格式不正确，前四位应为字母，后七位为数字，请重新输入！");
                 return false;
                 //location.reload();
             }

             left=test.substr(0,4);
             right=test.substr(4,7);
             testnum=test.substr(10,1);

             char1=test.substr(0,1);
             char2=test.substr(1,1);
             char3=test.substr(2,1);
             char4=test.substr(3,1);
             //箱号字头
             num[0]=changechar(char1);
             num[1]=changechar(char2);
             num[2]=changechar(char3);
             num[3]=changechar(char4);

             //序列号
             num[4]=test.substr(4,1);
             num[5]=test.substr(5,1);
             num[6]=test.substr(6,1);
             num[7]=test.substr(7,1);
             num[8]=test.substr(8,1);
             num[9]=test.substr(9,1);
             //校验数字
             num[10]=test.substr(10,1);
             /*
             for (i=0;i<11;i++){
             document.write(num[i]);
             document.write("<br>");
             }
             */
             sum=num[0]+num[1]*2+num[2]*4+num[3]*8+num[4]*16+num[5]*32+num[6]*64+num[7]*128+num[8]*256+num[9]*512;
             result=sum%11;
//document.write("集装箱编码为：" + test + "<br><br>")
             if (result!= num[10])
             {
                 //document.write("<font color=blue>校验码错误！");
                 //document.write("正确的校验码为：</font><font color=red>" + result + "</font>");
                 alert("校验码错误！正确的校验码为:" + result);
                 return false;
             }
             else
             {
                 // alert("校验通过！")
                 return true;
             }

         }
     }

     $(function(){
         $("#fmodel").bind('input porpertychange',function(){
             var fmodel = $("#fmodel").val();
             if(fmodel=='TK'){
                 $("#ftitle").attr("placeholder","底阀");
                 $("#ft").attr("colspan","");
                 $("#ftitle").width(80);
                 $("#fmanhole").show();
                 $("#fvalve").show();
                 $("#ftitle1").attr("placeholder","底阀");
                 $("#ft1").attr("colspan","");
                 $("#ftitle1").width(80);
                 $("#fmanhole1").show();
                 $("#fvalve1").show();
             }else{
                 $("#ftitle").attr("placeholder","");
                 $("#ft").attr("colspan","3");
                 $("#ftitle").width(150);
                 $("#fmanhole").hide();
                 $("#fvalve").hide();
                 $("#ftitle1").attr("placeholder","");
                 $("#ft1").attr("colspan","3");
                 $("#ftitle1").width(150);
                 $("#fmanhole1").hide();
                 $("#fvalve1").hide();
             }
         });
     })
 </script>