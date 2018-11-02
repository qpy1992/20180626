<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<div>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
	  <t:datagrid name="jeecgrowList" pagination="true" fitColumns="true" title="车辆排班" actionUrl="jeecgListDemoController.do?datagrid" pageSize="5" idField="id" queryMode="group">
		<t:dgCol title="id"  field="id"   hidden="true"></t:dgCol>
	    <t:dgCol title="车辆" colspan="4"></t:dgCol>
	    <t:dgCol title="头班" colspan="2"></t:dgCol>
	    <t:dgCol title="二班" colspan="2"></t:dgCol>
	    <t:dgCol title="三班" colspan="2"></t:dgCol>
	    <t:dgCol title="四班" colspan="2"></t:dgCol>
	    <t:dgCol title="五班" colspan="2" newColumn="true"></t:dgCol>
	    <t:dgCol title="车辆代码"  field="name" query="true" width="100"></t:dgCol>
	    <t:dgCol title="车号"  field="age" width="100"></t:dgCol>
	    <t:dgCol title="外部车"  field="birthday" formatter="yyyy-MM-dd" width="100"></t:dgCol>
	    <t:dgCol title="车主"  field="sex" width="100"></t:dgCol>
	    <t:dgCol title="派车单号"  field="salary" width="100"></t:dgCol>
	    <t:dgCol title="详细地址"  field="status" dictionary="sf_yn" width="100"></t:dgCol>
	    <t:dgCol title="派车单号"  field="content" width="100"></t:dgCol>
	    <t:dgCol title="详细地址"  field="status1" width="100"></t:dgCol>
	    <t:dgCol title="派车单号"  field="content1" width="100"></t:dgCol>
	    <t:dgCol title="详细地址"  field="status2" width="100"></t:dgCol>
	    <t:dgCol title="派车单号"  field="content2" width="100"></t:dgCol>
	    <t:dgCol title="详细地址"  field="status3" width="100"></t:dgCol>
	    <t:dgCol title="派车单号"  field="content3" width="100"></t:dgCol>
	    <t:dgCol title="详细地址"  field="status4" width="100"></t:dgCol>
	  </t:datagrid>
  </div>
</div>
 <script type="text/javascript">
	function deleteDialog(id){
		//提示框
		$.messager.confirm("确认", "确定要删除这条数据？", function (r) {
	        if (r) {	            
				var url = "jeecgListDemoController.do?doBatchDel&ids=" + id;
				$.ajax({
					url:url,
					type:"get",
					dataType:"json",
					success:function(data){
						top.tip(data.msg);
						if(data.success){							
							$("#jeecgrowList").datagrid('reload');
						}
					}
				})
	        }
	    });
	}

 	function fillData(rowData){ 
 		//清空表单	
 		$("#ff").form('clear');
 		//填充数据
 		for(var d in rowData){
			$("#"+d).val(rowData[d]);
		}
		//处理特殊控件
 		var birthday = rowData["birthday"];
		if(birthday != undefined){
			birthday = birthday.replace(" 00:00:00.0","");
		}else{
			birthday = "";
		}		
		$("#birthday").datebox("setValue", birthday); 
 	}

 	$(function(){
 	
 		 $("#jeecgrowList").datagrid({
			onClickRow: function(rowIndex, rowData){
				fillData(rowData);
				$("#editPanel").panel({title:"编辑数据"});	
			}
		});	

		//隐藏滚动条，固定高度，可根据表单字段数量调整
		$("body").css({"overflow": "hidden","height": "600px"});
		 
		 $("#ff").Validform({
			tiptype:1, 
			dragonfly:false,
			tipSweep:false,
			showAllError:false,
			postonce:true,
			ajaxPost:true
		}); 
 	})
	
	//保存数据
	function saveData(){
		//var demo=$(".formsub").Validform(); 
		$("#ff").Validform({
			callback:function(data){
				top.tip(data.msg);
				if(data.success){
					clearData();
					$("#jeecgrowList").datagrid('reload');
				}
			}
		}).ajaxPost(false,true);
	}
	
	function cancelEdit(){		
		var rowData = $("#jeecgrowList").datagrid("getSelected");
		if (rowData != null) {
			fillData(rowData);
			$("#editPanel").panel({title:"零单派车"});
		}else{
			clearData();			
		}
	}
	
	function clearData(){
		var rowData = {};
		fillData(rowData);	
		$("#editPanel").panel({title:"整单派车"});
		$("#jeecgrowList").datagrid('clearChecked');
	}
 
 </script>
 <style type="text/css">
 	.value{
 		padding: 10px auto 10px 10px;
 	}
 </style>
 	</div>
<div>
    <div title="运输任务" style="height:370px;" name="editPanel" id="editPanel" fit="true" class="easyui-panel">
		<div class="easyui-layout" fit="true">
		<div region="north" border="false" style="height:50px;">
			<div class="datagrid-toolbar" style="float:left;">
				<a href="#" class="easyui-linkbutton l-btn l-btn-plain" plain="true" icon="icon-zhengdan" onclick="clearData()">
					整单派车
				</a>
				<a href="#" class="easyui-linkbutton l-btn l-btn-plain" plain="true" icon="icon-lingdan" onclick="cancelEdit()">
					零单派车
				</a>
			</div>
		</div>
		<div region="west" border="false" style="width:250px">
			<ul id="tt1" class="easyui-tree">
				<li state="closed">
					<span>按照区域</span>
					<ul>
						<li><span>File 11</span></li>
						<li><span>File 12</span></li>
						<li><span>File 13</span></li>
					</ul>
				</li>
				<li><span>按照车型要求</span></li>
				<li state="closed"><span>货物属性</span>
					<ul>
						<li><span>普通货</span></li>
						<li><span>冷箱</span></li>
						<li><span>危险品</span></li>
						<li><span>贵重品</span></li>
					</ul>
				</li>
				<li state="closed"><span>特殊业务</span>
					<ul>
						<li><span>甩挂</span></li>
						<li><span>驳箱</span></li>
						<li><span>预提</span></li>
					</ul>
				</li>
			</ul>
		</div>
		<div region="center" border="false">
			<%--<table class="easyui-datagrid" style="width:auto;height:300px"
				   data-options="singleSelect:true,idField:'id',url:'portController.do?datagrid',method:'get'">
				<thead>
				<tr>
					<th data-options="field:'id'">箱号</th>
					<th data-options="field:'fportCode'">派车单号</th>
					<th data-options="field:'fcountryCode',align:'right'">进出口类型</th>
					<th data-options="field:'fportName',align:'right'">带货</th>
					<th data-options="field:'fcnName'">暂落</th>
					<th data-options="field:'fbelong',align:'center'">托单号</th>
					<th data-options="field:'fareaCode',align:'center'">箱型</th>
					<th data-options="field:'fnumberCode',align:'center'">门点地址</th>
					<th data-options="field:'fcustomsCode',align:'center'">门点区域</th>
					<th data-options="field:'fams',align:'center'">详细地址</th>
					<th data-options="field:'fedi',align:'center'">甩挂</th>
					<th data-options="field:'fedi2',align:'center'">驳箱</th>
					<th data-options="field:'fedi3',align:'center'">预提</th>
					<th data-options="field:'finstruction',align:'center'">货重</th>
					<th data-options="field:'fportType',align:'center'">运输要求</th>
					<th data-options="field:'status0',align:'center'">箱重</th>
					<th data-options="field:'status11',align:'center'">结关日期</th>
					<th data-options="field:'status12',align:'center'">外部委托</th>
					<th data-options="field:'status13',align:'center'">客户代码</th>
					<th data-options="field:'status14',align:'center'">重车</th>
					<th data-options="field:'status15',align:'center'">套箱</th>
					<th data-options="field:'status16',align:'center'">双拖</th>
					<th data-options="field:'status17',align:'center'">备注</th>
					<th data-options="field:'status18',align:'center'">装货门点</th>
					<th data-options="field:'status19',align:'center'">排班后增加</th>
					<th data-options="field:'status20',align:'center'">客户名称</th>
				</tr>
				</thead>
			</table>--%>
				<t:datagrid name="aList" pagination="true" title="" fitColumns="false" actionUrl="jeecgListDemoController.do?datagrid" pageSize="5" idField="id" queryMode="group">
					<t:dgCol title="id"  field="id"   hidden="true"></t:dgCol>
					<t:dgCol title="箱号"  field="name"></t:dgCol>
					<t:dgCol title="派车单号"  field="age"></t:dgCol>
					<t:dgCol title="进出口类型"  field="birthday" formatter="yyyy-MM-dd"></t:dgCol>
					<t:dgCol title="带货"  field="sex" dictionary="sex"></t:dgCol>
					<t:dgCol title="暂落"  field="salary"  queryMode="group"></t:dgCol>
					<t:dgCol title="托单号"  field="status" dictionary="sf_yn"></t:dgCol>
					<t:dgCol title="箱型"  field="content"></t:dgCol>
					<t:dgCol title="门点地址"  field="content1"></t:dgCol>
					<t:dgCol title="详细地址"  field="content2"></t:dgCol>
					<t:dgCol title="甩挂"  field="content3"></t:dgCol>
					<t:dgCol title="驳箱"  field="content4"></t:dgCol>
					<t:dgCol title="预提"  field="content5"></t:dgCol>
					<t:dgCol title="货重"  field="content6"></t:dgCol>
					<t:dgCol title="运输要求"  field="content7"></t:dgCol>
					<t:dgCol title="箱重"  field="content8"></t:dgCol>
					<t:dgCol title="结关日期"  field="content9"></t:dgCol>
					<t:dgCol title="外部委托"  field="content0"></t:dgCol>
					<t:dgCol title="客户代码"  field="content11"></t:dgCol>
					<t:dgCol title="重车"  field="content12"></t:dgCol>
					<t:dgCol title="套箱"  field="content13"></t:dgCol>
					<t:dgCol title="双拖"  field="content14"></t:dgCol>
					<t:dgCol title="装货门点"  field="content15"></t:dgCol>
					<t:dgCol title="排班后增加"  field="content16"></t:dgCol>
					<t:dgCol title="客户名称"  field="content17"></t:dgCol>
				</t:datagrid>
		</div>
		</div>
    </div>
	</div>