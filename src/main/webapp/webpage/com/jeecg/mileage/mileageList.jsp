<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="west" border="false" style="width: 200px">
   <table style="margin-top: 60px" cellpadding="0" cellspacing="1" class="formtable">
    <tr>
     <td align="right">
      <label class="Validform_label">
       空驶里程:
      </label>
     </td>
     <td class="value">
      <input id="fkong" name="fkong" type="text" style="width: 100px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
      <span class="Validform_checktip"></span>
      <label class="Validform_label" style="display: none;">空驶里程</label>
     </td>
    </tr>
    <tr>
     <td align="right">
      <label class="Validform_label">
       空箱里程:
      </label>
     </td>
     <td class="value">
      <input id="fkongxiang" name="fkongxiang" type="text" style="width: 100px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
      <span class="Validform_checktip"></span>
      <label class="Validform_label" style="display: none;">空箱里程</label>
     </td>
    </tr>
    <tr>
     <td align="right">
      <label class="Validform_label">
       重箱里程:
      </label>
     </td>
     <td class="value">
      <input id="fzhong" name="fzhong" type="text" style="width: 100px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
      <span class="Validform_checktip"></span>
      <label class="Validform_label" style="display: none;">重箱里程</label>
     </td>
    </tr>
    <tr>
     <td align="right">
      <label class="Validform_label">
       补贴里程:
      </label>
     </td>
     <td class="value">
      <input id="fbutie" name="fbutie" type="text" style="width: 100px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
      <span class="Validform_checktip"></span>
      <label class="Validform_label" style="display: none;">补贴里程</label>
     </td>
    </tr>
    <tr>
     <td align="right">
      <label class="Validform_label">
       总里程:
      </label>
     </td>
     <td class="value">
      <input id="ftotal" name="ftotal" type="text" style="width: 100px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
      <span class="Validform_checktip"></span>
      <label class="Validform_label" style="display: none;">总里程</label>
     </td>
    </tr>
    <tr>
     <td align="right">
      <label class="Validform_label">
       额定油耗:
      </label>
     </td>
     <td class="value">
      <input id="feding" name="feding" type="text" style="width: 100px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
      <span class="Validform_checktip"></span>
      <label class="Validform_label">升</label>
     </td>
    </tr>
   </table>
  </div>
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="mileageList" checkbox="false" pagination="true" fitColumns="true" title="里程数" actionUrl="mileageController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="区域"  field="fdparea"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="里程数"  field="fmileage"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="里程类型"  field="fmitype"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顺序"  field="forder"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="空驶里程"  field="fkong"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="空箱里程"  field="fkongxiang"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="重箱里程"  field="fzhong"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="补贴里程"  field="fbutie"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="总里程"  field="ftotal"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="额定油耗"  field="feding"  queryMode="single"  width="120"></t:dgCol>--%>
   <t:dgToolBar title="里程计算" icon="icon-sum" url="" funname=""></t:dgToolBar>
   <t:dgToolBar title="路径重置" icon="icon-reload" url="" funname=""></t:dgToolBar>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="mileageController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="mileageController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="mileageController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="mileageController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="mileageController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/mileage/mileageList.js"></script>