<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="contianerList" fitColumns="true" title="集装箱" actionUrl="contianerController.do?datagrid"
              idField="id" fit="true" queryMode="group" onDblClick="submit">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="暂落" field="fzanluo" dictionary="sf_yn"  extendParams="styler:fmtype"></t:dgCol>
   <t:dgCol title="箱号"  field="fboxno"  queryMode="single"></t:dgCol>
   <t:dgCol title="封号"  field="ftitle"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱型"  field="fboxtype"  queryMode="single"></t:dgCol>
   <%--<t:dgCol title="装船港"  field="floadport"  queryMode="single"></t:dgCol>
   <t:dgCol title="中转港"  field="ftransfer"  queryMode="single"></t:dgCol>
   <t:dgCol title="目的港"  field="ftarget"  queryMode="single"></t:dgCol>
   <t:dgCol title="航名"  field="fvoyage"  queryMode="single"></t:dgCol>
   <t:dgCol title="航次"  field="fvoyagenum"  queryMode="single"></t:dgCol>--%>
   <t:dgCol title="型号"  field="fmodel"  queryMode="single"></t:dgCol>
   <t:dgCol title="做箱时间"  field="fmakeboxtime"  queryMode="single"></t:dgCol>
   <t:dgCol title="等级"  field="fgrade"  queryMode="single"></t:dgCol>
   <t:dgCol title="危规页码"  field="fdrpagenum"  queryMode="single"></t:dgCol>
   <t:dgCol title="联合国编号"  field="funnumber"  queryMode="single"></t:dgCol>
   <t:dgCol title="闪点"  field="flashPoint"  queryMode="single"></t:dgCol>
   <t:dgCol title="冷藏温度"  field="fcolddegree"  queryMode="single"></t:dgCol>
   <t:dgCol title="总件数"  field="ftotals"  queryMode="single"></t:dgCol>
   <t:dgCol title="总毛重"  field="fgrosses"  queryMode="single"></t:dgCol>
   <t:dgCol title="总体积"  field="fvolumes"  queryMode="single"></t:dgCol>
   <t:dgCol title="提箱点"  field="fextract"  queryMode="single"></t:dgCol>
   <t:dgCol title="还箱点"  field="freturn"  queryMode="single"></t:dgCol>
   <t:dgCol title="集装箱经营人"  field="foperator"  queryMode="single"></t:dgCol>
   <t:dgCol title="主表主键"  field="fid"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货门点"  field="fzhdp"  queryMode="single"></t:dgCol>
   <t:dgCol title="门点地址"  field="fzhdpdz"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货单位"  field="fzhunit"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系人"  field="fzhcontact"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系电话"  field="fzhmobile"  queryMode="single"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"></t:dgCol>
   <t:dgCol title="特殊业务"  field="ftsyw"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货门点"  field="fxhdp"  queryMode="single"></t:dgCol>
   <t:dgCol title="门点地址"  field="fxhdpdz"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货时间"  field="fxhtime"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货单位"  field="fxhunit"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系人"  field="fxhcontact"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系电话"  field="fxhmobile"  queryMode="single"></t:dgCol>
   <t:dgCol title="对应派车单号"  field="fbillno" hidden="true"  queryMode="single"></t:dgCol>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/contianer/contianerList.js"></script>
<script type="text/javascript">
    function submit() {
        var ids = $('#contianerList').datagrid('getSelected').id;
        var fid = $('#contianerList').datagrid('getSelected').fid;
        createwindow('预计回程时间','paibanController.do?paiban1&ids='+ids+','+fid+'&qid=${qid}',300,200);
    }

    //列表字段颜色 demo,逻辑判断函数
    function fmtype(val,row,index){
        //可添加更多CSS样式
        var s1 = 'background-color:#ff5151;color:#FFF;';
        var s2 = 'background-color:#53ff53;color:#FFF;';
        var s3 = 'background-color:#21B9BB;';
        if (val =='Y') {
            return s1
        }
        if (val =='N') {
            return s2
        }
        return s3
    }
</script>