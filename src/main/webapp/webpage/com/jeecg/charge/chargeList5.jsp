<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="chargeList3" checkbox="true" pagination="true" fitColumns="true" title="费用" actionUrl="chargeController.do?datagrid4&idlist=${idlist}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"></t:dgCol>
   <t:dgCol title="提单号"  field="fblno"></t:dgCol>
   <t:dgCol title="航名"  field="fshipname"></t:dgCol>
   <t:dgCol title="航次"  field="fvoyageno"></t:dgCol>
   <t:dgCol title="作业日期"  field="operatetime" formatter="yyyy-MM-dd" query="true" queryMode="group"></t:dgCol>
   <t:dgCol title="费用种类"  field="fcost"  query="true"></t:dgCol>
   <t:dgCol title="费用种类名称"  field="fcostname"></t:dgCol>
   <t:dgCol title="单位"  field="funit"></t:dgCol>
   <t:dgCol title="数量"  field="fqty"></t:dgCol>
   <t:dgCol title="单价"  field="fprice"></t:dgCol>
   <t:dgCol title="金额"  field="famount"  queryMode="group" query="true"></t:dgCol>
   <t:dgCol title="收付金额"  field="fsfamount"></t:dgCol>
   <t:dgCol title="可开票金额"  field="fkk"></t:dgCol>
   <t:dgCol title="审核"  field="fcheck"  dictionary="check"  query="true"  extendParams="styler:fmtype"></t:dgCol>
   <t:dgCol title="委托号"  field="fweituo"  query="true"></t:dgCol>
   <t:dgCol title="委托单位"  field="entrust"></t:dgCol>
   <t:dgCol title="派车单号"  field="paiche"  query="true"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"></t:dgCol>
   <t:dgCol title="收付"  field="fshoufu"  dictionary="shoufu"></t:dgCol>
   <t:dgCol title="结算单位"  field="fsettle" query="true"></t:dgCol>
   <t:dgCol title="结算单位名称"  field="fsettlename"></t:dgCol>
   <t:dgCol title="门点代码"  field="fzhdp"></t:dgCol>
   <t:dgCol title="门点地址"  field="fzhdpdz"></t:dgCol>
   <t:dgCol title="录入人"  hidden="true" field="createName" query="true"></t:dgCol>
   <t:dgCol title="封号"  hidden="true"  field="ftitle" query="true"></t:dgCol>
   <t:dgCol title="司机"  hidden="true"  field="fdriver" query="true"></t:dgCol>
   <t:dgCol title="开票"  hidden="true"  field="fkp" dictionary="sf_yn" query="true"></t:dgCol>
   <t:dgCol title="核销"  hidden="true"  field="fhx" dictionary="sf_yn" query="true"></t:dgCol>
   <%--<t:dgCol title="对账"  hidden="true"  field="fdz" dictionary="sf_yn" query="true"></t:dgCol>--%>
   <t:dgCol title="报销"  hidden="true"  field="fbx" dictionary="sf_yn" query="true"></t:dgCol>
   <t:dgCol title="来源"  hidden="true"  field="forigin" dictionary="ly" query="true"></t:dgCol>
   <t:dgCol title="运输时间"  hidden="true"  field="ftranstime"  formatter="yyyy-MM-dd"  queryMode="group" query="true"></t:dgCol>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/charge/chargeList.js"></script>
<script type="text/javascript">
    var b="";
    $('#chargeList3').datagrid({
        onSelect: function(index,row){
            //alert(row.id);//TODO 事件响应代码；
            b=b+row.id+",";
            var strs= new Array(); //定义一数组
            strs=b.split(","); //字符分割
            var checkWlarr = strs.join(",");
            window.localStorage.setItem("ids",checkWlarr);
        }

    });
    $('#chargeList3').datagrid({
        onUnselect: function(index,row){
            //alert(row.id);//TODO 事件响应代码；
            b=b.replace(row.id+",","");
            var strs= new Array(); //定义一数组
            strs=b.split(","); //字符分割
            var checkWlarr = strs.join(",");
            window.localStorage.setItem("ids",checkWlarr);
        }

    });
    $('#chargeList3').datagrid({

        onSelectAll: function(index,row){
            //alert(row.id);//TODO 事件响应代码；
            var rows = $('#chargeList3').datagrid('getSelections');
            for(var i=0;i<rows.length;i++){
                b=b+rows[i].id+",";
            }
            var strs= new Array(); //定义一数组
            strs=b.split(","); //字符分割
            var checkWlarr = strs.join(",");
            window.localStorage.setItem("ids",checkWlarr);
        }
    });

    $('#chargeList3').datagrid({
        onUnselectAll: function(index,row){
            //alert(row.id);//TODO 事件响应代码；
            window.localStorage.setItem("ids",[]);
        }
    });
</script>