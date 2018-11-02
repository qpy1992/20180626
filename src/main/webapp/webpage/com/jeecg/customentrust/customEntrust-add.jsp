<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>客户委托</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="customEntrustController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${customEntrustPage.id }"/>
		<table cellpadding="0" cellspacing="1" class="formtable">
            <tr>
                <td align="right">
                    <label class="Validform_label">委托单位:</label>
                </td>
                <td class="value" colspan="3">
                    <input id="fentrustUnit" name="fentrustUnit" placeholder="点击选择" type="text" style="width: 500px" class="inputxt"  ignore="ignore" onclick="popupClick(this,'fcn_name,id','fentrustUnit,cid','weituo')"/>
                    <input id="cid" name="cid" type="hidden" class="inputxt"  ignore="ignore">
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">委托单位</label>
                </td>
                <td class="value" align="center" colspan="4">
                    <t:dictSelect field="fkinds" type="checkbox"   typeGroupCode="entrust"  defaultVal="${customEntrustPage.fkinds}" hasLabel="false"  title="委托类型" ></t:dictSelect>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">委托类型</label>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label class="Validform_label">联系人:</label>
                </td>
                <td class="value">
                    <input id="fcontact" name="fcontact" type="text" style="width: 100px" class="inputxt"  ignore="ignore" />
                    <t:choose hiddenName="cid" hiddenid="" url="customEntrustController.do?list1"
                              name="customContactsList" icon="icon-search" textname="fcontactsName,fphone,fmobile,fax"
                              inputTextname="fcontact,fphone,fmobile,fax" isInit="true" isclear="true"></t:choose>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">联系人</label>
                </td>
                <td align="right">
                    <label class="Validform_label">联系电话:</label>
                </td>
                <td class="value">
                    <input id="fphone" name="fphone" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">联系电话</label>
                </td>
                <td align="right">
                    <label class="Validform_label">手机号:</label>
                </td>
                <td class="value" colspan="3">
                    <input id="fmobile" name="fmobile" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">联系手机</label>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label class="Validform_label">业务员:</label>
                </td>
                <td class="value">
                    <input id="fsalesman" name="fsalesman" type="text" style="width: 100px" class="inputxt"  ignore="ignore" />
                    <t:choose hiddenName="cid" hiddenid="" url="customEntrustController.do?list2"
                              name="customSalesmanList" icon="icon-search" textname="fname"
                              inputTextname="fsalesman" isInit="true" isclear="true"></t:choose>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">业务员</label>
                </td>
                <td align="right">
                    <label class="Validform_label">委托时间:</label>
                </td>
                <td class="value">
                    <input id="foperateTime" name="foperateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" ignore="ignore"  />
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">操作时间</label>
                </td>
                <td align="right">
                    <label class="Validform_label">客户编码:</label>
                </td>
                <td class="value">
                    <input id="fcusCode" name="fcusCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">客户编码</label>
                </td>
                <td align="right">
                    <label class="Validform_label">货物属性:</label>
                </td>
                <td class="value">
                        <%--<input id="fgoodsprop" name="fgoodsprop" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />--%>
                    <t:dictSelect id="fgoodsprop" field="fgoodsprop" typeGroupCode="goods" hasLabel="false" defaultVal="1"></t:dictSelect>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">货物属性</label>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label class="Validform_label">业务类型:</label>
                </td>
                <td class="value" id="fbuss">
                    <t:dictSelect  id="fbussType"  field="fbussType" type="list"   typeGroupCode="buss"  defaultVal="${customEntrustPage.fbussType}" hasLabel="false"  title="业务类型" ></t:dictSelect>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">业务类型</label>
                </td>
                <td align="right" id="fship">
                    <label class="Validform_label">船名:</label>
                </td>
                <td class="value" id="fship1">
                    <input id="fshipname" name="fshipname" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">船名</label>
                </td>
                <td align="right" id="fvo">
                    <label class="Validform_label">航次:</label>
                </td>
                <td class="value" id="fvo1">
                    <input id="fvoyageno" name="fvoyageno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">航次</label>
                </td>
                <td align="right" id="fbl">
                    <label class="Validform_label">提单号:</label>
                </td>
                <td class="value" id="fbl1">
                    <input id="fblno" name="fblno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">提单号</label>
                </td>
            </tr>
            <tr id="fload">
                <td align="right">
                    <label class="Validform_label">装船港:</label>
                </td>
                <td class="value">
                    <input id="floadPort" name="floadPort" placeholder="点击选择" type="text" style="width: 150px" class="inputxt"  ignore="ignore" onclick="popupClick(this,'fport_name','floadPort','port')"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">装船港</label>
                </td>
                <td align="right">
                    <label class="Validform_label">中转港:</label>
                </td>
                <td class="value">
                    <input id="ftransport" name="ftransport" placeholder="点击选择" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  onclick="popupClick(this,'fport_name','ftransport','port')"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">中转港</label>
                </td>
                <td align="right">
                    <label class="Validform_label">目的港:</label>
                </td>
                <td class="value" colspan="3">
                    <input id="ftargetport" name="ftargetport" placeholder="点击选择" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  onclick="popupClick(this,'fport_name','ftargetport','port')"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">目的港</label>
                </td>
            </tr>
            <tr id="time">
                <td align="right" id="fzy1">
                    <label class="Validform_label">开港时间:</label>
                </td>
                <td class="value" id="fzy">
                    <input id="fzytime" name="fzytime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  />
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">开港时间</label>
                </td>
                <td align="right" id="farr">
                    <label class="Validform_label">到港时间:</label>
                </td>
                <td class="value" id="farr1">
                    <input id="farrivetime" name="farrivetime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  />
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">到港时间</label>
                </td>
                <td align="right" id="fcut">
                    <label class="Validform_label">截港时间:</label>
                </td>
                <td class="value" id="fcut1" colspan="3">
                    <input id="fcuttime" name="fcuttime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  />
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">截港时间</label>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label class="Validform_label">冷藏温度:</label>
                </td>
                <td class="value">
                    <input id="fcold" name="fcold" type="text" style="width:150px" class="inputxt" ignore="ignore"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display:none;">冷藏温度</label>
                </td>
                <td align="right">
                    <label class="Validform_label">加热温度:</label>
                </td>
                <td class="value" id="fho">
                    <input id="fhot" name="fhot" type="text" style="width:150px" class="inputxt" ignore="ignore"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display:none;">加热温度</label>
                </td>
                <td align="right" id="fop">
                    <label class="Validform_label">集装箱经营人:</label>
                </td>
                <td class="value" id="fop1" colspan="3">
                    <input id="foperate" name="foperate" type="text" style="width:150px" class="inputxt" ignore="ignore"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display:none;">集装箱经营人</label>
                </td>
            </tr>
            <tr id="ph" hidden>
                <td align="right">
                    <label class="Validform_label">等级:</label>
                </td>
                <td class="value">
                    <input id="fgrade" name="fgrade" type="text" style="width:150px" class="inputxt" ignore="ignore"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display:none;">等级</label>
                </td>
                <td align="right">
                    <label class="Validform_label">闪点:</label>
                </td>
                <td class="value">
                    <input id="flash" name="flash" type="text" style="width:150px" class="inputxt" ignore="ignore"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display:none;">闪点</label>
                </td>
                <td align="right">
                    <label class="Validform_label">危规页码:</label>
                </td>
                <td class="value" colspan="3">
                    <input id="fwei" name="fwei" type="text" style="width:150px" class="inputxt" ignore="ignore"/>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display:none;">危规页码</label>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label class="Validform_label">备注:</label>
                </td>
                <td class="value" colspan="7">
                    <textarea id="fnote" style="width:1000px;" class="inputxt" rows="6" name="fnote"  ignore="ignore" ></textarea>
                    <span class="Validform_checktip"></span>
                    <label class="Validform_label" style="display: none;">备注</label>
                </td>
            </tr>
        </table>
  </t:formvalid>
 </body>
 <script src = "webpage/com/jeecg/customentrust/customEntrust.js"></script>
 <script type="text/javascript">
     $(function(){
         $("#fbussType").bind('input porpertychange',function(){
             var fbussType = $("#fbussType").val();
             if(fbussType=='0'){
                 //出口
                 $("#farr").hide();
                 $("#farr1").hide();
                 $("#fcut1").attr("colspan","5");
                 $("#fzy").show();
                 $("#fzy1").show();
                 $("#fship").show();
                 $("#fship1").show();
                 $("#fvo").show();
                 $("#fvo1").show();
                 $("#fbl").show();
                 $("#fbl1").show();
                 $("#fload").show();
                 $("#fbuss").attr("colspan","");
                 $("#fcut").show();
                 $("#fcut1").show();
                 // $("#fho").attr("colspan","");
                 $("#fzy").attr("colspan","");
                 $("#time").show();
                 $("#fop").show();
                 $("#fop1").show();
                 $("#fop1").attr("colspan","3");
                 $("#fho").attr("colspan","")
             }
             if(fbussType=='1'){
                 //进口
                 $("#fzy").hide();
                 $("#fzy1").hide();
                 $("#farr").show();
                 $("#farr1").show();
                 $("#farr1").attr("colspan","7");
                 $("#fship").show();
                 $("#fship1").show();
                 $("#fvo").show();
                 $("#fvo1").show();
                 $("#fbl").show();
                 $("#fbl1").show();
                 $("#fload").hide();
                 $("#fbuss").attr("colspan","");
                 $("#fcut").hide();
                 $("#fcut1").hide();
                 $("#fzy").attr("colspan","");
                 $("#time").show();
                 $("#fop").show();
                 $("#fop1").show();
                 $("#fop1").attr("colspan","3");
                 $("#fho").attr("colspan","")
             }
             if(fbussType=='2'){
                //项目
                 $("#fbuss").attr("colspan","7");
                 $("#fship").hide();
                 $("#fship1").hide();
                 $("#fvo").hide();
                 $("#fvo1").hide();
                 $("#fbl").hide();
                 $("#fbl1").hide();
                 $("#fload").hide();
                 $("#time").hide();
                 // $("#fgr").attr("colspan","3");
                 // $("#fgr").attr("colspan","5");
                 $("#fop").hide();
                 $("#fop1").hide();
                 $("#fho").attr("colspan","5")
             }
         });

         $("#fgoodsprop").bind('input porpertychange',function(){
             var goods = $("#fgoodsprop").val();
             if(goods=='1'){
                 $("#ph").hide();
             }
             if(goods=='2'){
                 $("#ph").show();
             }
         });
     })
 </script>
