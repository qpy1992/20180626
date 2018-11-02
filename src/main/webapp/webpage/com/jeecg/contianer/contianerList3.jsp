<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="contianerList3" fitColumns="true" title="集装箱" actionUrl="contianerController.do?datagrid1"
              idField="id" fit="true" queryMode="group" onDblClick="submit">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱编号"  field="fbillno1"  queryMode="single"></t:dgCol>
   <t:dgCol title="委托单位"  field="fentrust"  queryMode="single"></t:dgCol>
   <t:dgCol title="暂落"  field="fzanluo" hidden="true"  dictionary="sf_yn"  extendParams="styler:fmtype"  queryMode="single"></t:dgCol>
   <t:dgCol title="提单号"  field="fblno"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱号"  field="fboxno"  queryMode="single"></t:dgCol>
   <t:dgCol title="提箱点"  field="fextract"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货时间"  field="fzhtime" formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货门点"  field="fzhdp"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货地址"  field="fzhdpdz"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货时间"  field="fxhtime" formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货门点"  field="fxhdp"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货地址"  field="fxhdpdz"  queryMode="single"></t:dgCol>
   <t:dgCol title="还箱点"  field="freturn"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱型"  field="fboxtype"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱类"  field="fmodel"  queryMode="single"></t:dgCol>
   <t:dgCol title="加热温度"  field="fhot"  queryMode="single"></t:dgCol>
   <t:dgCol title="冷藏温度"  field="fcolddegree"  queryMode="single"></t:dgCol>
   <t:dgCol title="等级"  field="fgrade"  queryMode="single"></t:dgCol>
   <t:dgCol title="业务时间"  field="fmakeboxtime" query="true" formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="主表主键"  field="fid"  hidden="true"  queryMode="single"></t:dgCol>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/contianer/contianerList.js"></script>
<script type="text/javascript">
    function detailwindow(title, addurl,width,height) {
        width = width?width:1000;
        height = height?height:500;
        if(width=="100%" || height=="100%"){
            width = window.top.document.body.offsetWidth;
            height =window.top.document.body.offsetHeight-100;
        }
        if(typeof(windowapi) == 'undefined'){
            $.dialog({
                content: 'url:'+addurl,
                zIndex: getzIndex(),
                lock : true,
                width:width,
                height: height,
                title:title,
                opacity : 0.3,
                cache:false,
                cancelVal: '关闭',
                cancel: function () {
                    reloadTable()
                } /*为true等价于function(){}*/
            });
        }
    }


    function submit() {
        var contianerId = $('#contianerList3').datagrid('getSelected').id;
        var entrustId = $('#contianerList3').datagrid('getSelected').fid;
        detailwindow('车辆列表','paibanController.do?vehicle&contianerId='+contianerId+'&entrustId='+entrustId,800,500)
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