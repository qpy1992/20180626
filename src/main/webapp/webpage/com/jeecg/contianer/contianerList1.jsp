<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addContianerBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delContianerBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	});
    $('#detContianerBtn').linkbutton({
        iconCls: 'icon-detail'
    });
	$('#addContianerBtn').bind('click', function(){   
 		 var tr =  $("#add_contianer_table_template tr").clone();
	 	 $("#add_contianer_table").append(tr);
	 	 resetTrNum('add_contianer_table');
	 	 return false;
    });  
	$('#delContianerBtn').bind('click', function(){   
      	$("#add_contianer_table").find("input:checked").parent().parent().remove();
        resetTrNum('add_contianer_table'); 
        return false;
    });
    $('#detContianerBtn').bind('click', function(){
        // var tr = $("#add_contianer_table").find("input:checked").parent().parent();
        <%--var ss=$(tr).find("input[name='contianerList[${stuts.index }].id']").val();--%>
        // alert(ss)
        alert(${poVal.id});
        createwindow('明细','detailController.do?list&id=${poVal.id}',600,400);
        resetTrNum('add_contianer_table');
        return false;
    });
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });
</script>
<!-- <div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addContianerBtn" href="#">添加</a> <a id="delContianerBtn" href="#">删除</a>
	<a id="detContianerBtn" href="#">明细</a>
</div> -->

  <t:datagrid name="containerList" checkbox="true" pagination="true" fitColumns="true" title="集装箱"
              actionUrl="containerController.do?datagrid&fid=${fid}" idField="id" fit="true" queryMode="group"
             >
   <t:dgCol title="主键"  field="id"  hidden="true"></t:dgCol>
   <t:dgCol title="箱号"  field="fboxno"></t:dgCol>
   <t:dgCol title="封号"  field="ftitle"></t:dgCol>
   <t:dgCol title="箱型"  field="fboxtype"></t:dgCol>
   <t:dgCol title="装船港"  field="floadport"></t:dgCol>
   <t:dgCol title="中转港"  field="ftransfer"></t:dgCol>
   <t:dgCol title="目的港"  field="ftarget"></t:dgCol>
   <t:dgCol title="航名"  field="fvoyage"></t:dgCol>
   <t:dgCol title="航次"  field="fvoyagenum"></t:dgCol>
   <t:dgCol title="型号"  field="fmodel"></t:dgCol>
   <t:dgCol title="做箱时间"  field="fmakeboxtime"></t:dgCol>
   <t:dgCol title="等级"  field="fgrade"></t:dgCol>
   <t:dgCol title="危规页码"  field="fdrpagenum"></t:dgCol>
   <t:dgCol title="联合国编号"  field="funnumber"></t:dgCol>
   <t:dgCol title="闪点"  field="flashPoint"></t:dgCol>
   <t:dgCol title="冷藏温度"  field="fcolddegree"></t:dgCol>
   <t:dgCol title="总件数"  field="ftotals"></t:dgCol>
   <t:dgCol title="总毛重"  field="fgrosses"></t:dgCol>
   <t:dgCol title="总体积"  field="fvolumes"></t:dgCol>
   <t:dgCol title="提箱点"  field="fextract"></t:dgCol>
   <t:dgCol title="还箱点"  field="freturn"></t:dgCol>
   <t:dgCol title="集装箱经营人"  field="foperator"></t:dgCol>
   <t:dgCol title="对应派车单号"  field="fbillno" hidden="true"></t:dgCol>
   <%--<t:dgCol title="主表主键"  field="fid"  hidden="true"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="containerController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="containerController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="containerController.do?goUpdate" funname="update"></t:dgToolBar>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="containerController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="containerController.do?goUpdate" funname="detail"></t:dgToolBar>--%>
  </t:datagrid>
