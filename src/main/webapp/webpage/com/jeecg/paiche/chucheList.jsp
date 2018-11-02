<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<div>
    <script type="text/javascript">
        //保存数据
        function saveData(){
            $("#ff").Validform({
                callback:function(data){
                    if(data.success){
                        top.tip(data.msg);
                        $("#editPanel").panel('open').panel('refresh')
                    }
                }
            }).ajaxPost(false,true);
        }
    </script>
 <style type="text/css">
  .value{
   padding: 10px auto 10px 10px;
  }
 </style>
</div>
<div title="出车标准" style="height:500px;" name="editPanel" id="editPanel" fit="true" class="easyui-panel">
 <div class="datagrid-toolbar" style="float:left;width: 100%;">
  <a href="#" class="easyui-linkbutton l-btn l-btn-plain" plain="true" icon="icon-save" id="btn_sub" onclick="saveData()">保存</a>
 </div>
 <t:formvalid formid="ff" dialog="true" layout="table" usePlugin="password" tiptype="4" action="paicheController.do?update">
  <input name="id" id="id" type="hidden" value="${paichePage.id}" />
  <table style="width: 900px;" cellpadding="0" cellspacing="1" class="formtable">
   <tbody><tr>
    <td align="right">
     <label class="Validform_label">
      打单费:
     </label>
    </td>
    <td class="value">
     <input id="fdadan" name="fdadan" type="text" style="width: 150px;" class="inputxt" value="${paichePage.fdadan}">
    </td>
    <td align="right">
     <label class="Validform_label">
      路桥费:
     </label>
    </td>
    <td class="value">
     <input id="fluqiao" name="fluqiao" type="text" style="width: 150px;" class="inputxt" value="${paichePage.fluqiao}">
    </td>
    <td align="right">
     <label class="Validform_label">
      上下车费:
     </label>
    </td>
    <td class="value">
     <input id="fshangxia" name="fshangxia" type="text" style="width: 150px;" class="inputxt" value="${paichePage.fshangxia}">
    </td>
   </tr>
   <tr>
    <td align="right">
     <label class="Validform_label">
      封子费:
     </label>
    </td>
    <td class="value">
     <input id="ffengzi" name="ffengzi" type="text" style="width: 150px;" class="inputxt" value="${paichePage.ffengzi}">
    </td>
    <td align="right">
     <label class="Validform_label">
      调箱门费:
     </label>
    </td>
    <td class="value">
     <input id="fdiaoxiang" name="fdiaoxiang" type="text" style="width: 150px;" class="inputxt" value="${paichePage.fdiaoxiang}">
    </td>
    <td align="right">
     <label class="Validform_label">
      预录费:
     </label>
    </td>
    <td class="value">
     <input id="fyulu" name="fyulu" type="text" style="width: 150px;" class="inputxt" value="${paichePage.fyulu}">
    </td>
   </tr>
   <tr>
    <td align="right">
     <label class="Validform_label">
      总油耗:
     </label>
    </td>
    <td class="value">
     <input id="fyouhao" name="fyouhao" type="text" style="width: 150px;" class="inputxt" value="${paichePage.fyouhao}">
    </td>
    <td align="right">
     <label class="Validform_label">
      油价:
     </label>
    </td>
    <td class="value">
     <input id="fyoujia" name="fyoujia" type="text" style="width: 150px;" class="inputxt" value="${paichePage.fyoujia}">
    </td>
    <td align="right">
     <label class="Validform_label">
      油耗(金):
     </label>
    </td>
    <td class="value">
     <input id="fyoufei" name="fyoufei" type="text" style="width: 150px;" class="inputxt" value="${paichePage.fyoufei}">
    </td>
   </tr>
   <tr>
    <td align="right">
     <label class="Validform_label">
      正司机提成:
     </label>
    </td>
    <td class="value">
     <input id="fdriver3" name="fdriver3" type="text" style="width: 150px;" class="inputxt" value="${paichePage.fdriver3}">
    </td>
    <td align="right">
     <label class="Validform_label">
      市内补贴:
     </label>
    </td>
    <td class="value">
     <input id="fshinei" name="fshinei" type="text" style="width: 150px;" class="inputxt" value="${paichePage.fshinei}">
    </td>
    <td align="right">
     <label class="Validform_label">
      副司机提成:
     </label>
    </td>
    <td class="value">
     <input id="fdriver4" name="fdriver4" type="text" style="width: 150px;" class="inputxt" value="${paichePage.fdriver4}">
    </td>
   </tr>
   <tr hidden="hidden">
    <td align="right">
     <label class="Validform_label">派车单号:</label>
    </td>
    <td class="value">
     <input id="fbillno" name="fbillno" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${paichePage.fbillno}"/>
    </td>
    <td align="right">
     <label class="Validform_label">车辆编号:</label>
    </td>
    <td class="value">
     <input id="fcarcode" name="fcarcode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fcarcode}"/>
    </td>
    <td align="right">
     <label class="Validform_label">车牌号:</label>
    </td>
    <td class="value">
     <input id="fcarno" name="fcarno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fcarno}"/>
    </td>
   </tr>
   <tr hidden="hidden">
    <td align="right">
     <label class="Validform_label">运输时间:</label>
    </td>
    <td class="value">
     <input id="ftranstime" name="ftranstime" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.ftranstime}"/>
    </td>
    <td align="right">
     <label class="Validform_label">类型:</label>
    </td>
    <td class="value">
     <input id="ftype" name="ftype" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.ftype}"/>
    </td>
    <td align="right">
     <label class="Validform_label">已报销:</label>
    </td>
    <td class="value">
     <input id="fbaoxiao" name="fbaoxiao" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fbaoxiao}"/>
    </td>
   </tr>
   <tr hidden="hidden">
    <td align="right">
     <label class="Validform_label">主司机:</label>
    </td>
    <td class="value">
     <input id="fdriver" name="fdriver" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fdriver}"/>
    </td>
    <td align="right">
     <label class="Validform_label">详情:</label>
    </td>
    <td class="value">
     <input id="ftype2" name="ftype2" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.ftype2}"/>
    </td>
    <td align="right">
     <label class="Validform_label">副司机:</label>
    </td>
    <td class="value">
     <input id="fdriver2" name="fdriver2" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fdriver2}"/>
    </td>
   </tr>
   <tr hidden="hidden">
    <td align="right">
     <label class="Validform_label">状态:</label>
    </td>
    <td class="value">
     <input id="fstatus" name="fstatus" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fstatus}"/>
    </td>
    <td align="right">
     <label class="Validform_label">门点:</label>
    </td>
    <td class="value">
     <input id="fdoorpoint" name="fdoorpoint" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fdoorpoint}"/>
    </td>
    <td align="right">
     <label class="Validform_label">运输方式:</label>
    </td>
    <td class="value">
     <input id="ftranstype" name="ftranstype" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.ftranstype}"/>
    </td>
   </tr>
   <tr hidden="hidden">
    <td align="right">
     <label class="Validform_label">货重:</label>
    </td>
    <td class="value">
     <input id="fweight" name="fweight" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fweight}"/>
    </td>
    <td align="right">
     <label class="Validform_label">皮重:</label>
    </td>
    <td class="value">
     <input id="fweight2" name="fweight2" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fweight2}"/>
    </td>
    <td align="right">
     <label class="Validform_label">出场路码:</label>
    </td>
    <td class="value">
     <input id="fcccode" name="fcccode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fcccode}"/>
    </td>
   </tr>
   <tr hidden="hidden">
    <td align="right">
     <label class="Validform_label">进场路码:</label>
    </td>
    <td class="value">
     <input id="fjccode" name="fjccode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fjccode}"/>
    </td>
    <td align="right">
     <label class="Validform_label">起始地:</label>
    </td>
    <td class="value">
     <input id="fstart" name="fstart" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fstart}"/>
    </td>
    <td align="right">
     <label class="Validform_label">终止地:</label>
    </td>
    <td class="value">
     <input id="fend" name="fend" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fend}"/>
    </td>
   </tr>
   <tr hidden="hidden">
    <td align="right">
     <label class="Validform_label">运输要求:</label>
    </td>
    <td class="value">
     <input id="frequire" name="frequire" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.frequire}"/>
    </td>
    <td align="right">
     <label class="Validform_label">回单时间:</label>
    </td>
    <td class="value">
     <input id="fhdtime" name="fhdtime" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fhdtime}"/>
    </td>
    <td align="right">
     <label class="Validform_label">设备交接单:</label>
    </td>
    <td class="value">
     <input id="fshebei" name="fshebei" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fshebei}"/>
    </td>
   </tr>
   <tr hidden="hidden">
    <td align="right">
     <label class="Validform_label">签收单:</label>
    </td>
    <td class="value">
     <input id="fqianshou" name="fqianshou" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fqianshou}"/>
    </td>
    <td align="right">
     <label class="Validform_label">预录单:</label>
    </td>
    <td class="value">
     <input id="fyuluno" name="fyuluno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fyuluno}"/>
    </td>
    <td align="right">
     <label class="Validform_label">装箱单:</label>
    </td>
    <td class="value">
     <input id="fzhaungxiang" name="fzhaungxiang" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fzhaungxiang}"/>
    </td>
   </tr>
   <tr hidden="hidden">
    <td align="right">
     <label class="Validform_label">白卡:</label>
    </td>
    <td class="value">
     <input id="fbaika" name="fbaika" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${paichePage.fbaika}"/>
    </td>
   </tr>
   </tbody>
  </table>
 </t:formvalid>
</div>
