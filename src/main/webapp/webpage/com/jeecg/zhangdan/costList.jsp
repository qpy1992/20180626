<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="costList2" checkbox="false" pagination="true" fitColumns="true" title="费用列表"
              actionUrl="bxcostController.do?datagridcost" idField="id" fit="true" queryMode="group" onDblClick="addcost">
   <t:dgCol title="主键"  field="id"  hidden="true"></t:dgCol>
   <t:dgCol title="审核"  field="fcheck"  dictionary="check"  extendParams="styler:fmtype"></t:dgCol>
   <t:dgCol title="费用种类"  field="fcost"></t:dgCol>
   <t:dgCol title="费用种类名称"  field="fcostname"></t:dgCol>
   <t:dgCol title="结算单位"  field="fsettle"></t:dgCol>
   <t:dgCol title="结算单位名称"  field="fsettlename"></t:dgCol>
   <t:dgCol title="单位"  field="funit"></t:dgCol>
   <t:dgCol title="单价"  field="fprice"></t:dgCol>
   <t:dgCol title="数量"  field="fqty"></t:dgCol>
   <t:dgCol title="金额"  field="famount"></t:dgCol>
   <t:dgCol title="本位币金额"  field="frated"></t:dgCol>
   <t:dgCol title="实际金额"  field="factual"></t:dgCol>
   <t:dgCol title="装船港"  field="fload"></t:dgCol>
   <t:dgCol title="目的港"  field="ftargetport"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"></t:dgCol>
   <t:dgCol title="提单号"  field="fblno"></t:dgCol>
   <t:dgCol title="航名"  field="fshipname"></t:dgCol>
   <t:dgCol title="航次"  field="fvoyageno"></t:dgCol>
   <t:dgCol title="操作时间"  field="fzytime"   formatter="yyyy-MM-dd HH:mm:ss"></t:dgCol>
   <t:dgCol title="委托号"  field="fweituo"></t:dgCol>
   <t:dgCol title="派车单号"  field="fpaiche"></t:dgCol>
   <t:dgCol title="委托单位"  field="fentrust"></t:dgCol>
   <t:dgCol title="门点代码"  field="fzhdp"></t:dgCol>
   <t:dgCol title="门点地址"  field="fzhdpdz"></t:dgCol>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/cost/costList.js"></script>
 <script type="text/javascript">
    function addcost() {
        var row = $('#costList2').datagrid('getSelected');
        $.ajax({
            url : 'zhangdanController.do?addcost&fid=${fid}',
            type : 'post',
            data : {
                cid : row.id,
            },
            cache : false,
            success : function(data) {
                var d = $.parseJSON(data);
                if (d.success) {
                    var msg = d.msg;
                    tip(msg);
                    reloadTable();
                    cid='';
                }
            }
        });
    }
 </script>