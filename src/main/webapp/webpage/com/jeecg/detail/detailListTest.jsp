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
        //alert(${poVal.id});
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
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addContianerBtn" href="#">添加</a> <a id="delContianerBtn" href="#">删除</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="contianer_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						提单号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						货名
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						唛头
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						包装
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						件数
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						毛重
				  </td>

	</tr>
	<tbody id="add_contianer_table">
	
		<c:forEach items="${contianerList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="contianerList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="contianerList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].fboxno" onclick="return GetCntr(this.value)" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fboxno }"/>
					  <label class="Validform_label" style="display: none;">箱号</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].ftitle" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.ftitle }"/>
					  <label class="Validform_label" style="display: none;">封号</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].fboxtype" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fboxtype }"/>
					  <label class="Validform_label" style="display: none;">箱型</label>
				   </td>
				   <%--<td align="left">
					  	<input name="contianerList[${stuts.index }].floadport" onclick="popupClick(this,'fport_name','floadport','port')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.floadport }"/>
					  <label class="Validform_label" style="display: none;">装船港</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].ftransfer" onclick="popupClick(this,'fport_name','ftransfer','port')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.ftransfer }"/>
					  <label class="Validform_label" style="display: none;">中转港</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].ftarget" onclick="popupClick(this,'fport_name','ftarget','port')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.ftarget }"/>
					  <label class="Validform_label" style="display: none;">目的港</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].fvoyage" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fvoyage }"/>
					  <label class="Validform_label" style="display: none;">航名</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].fvoyagenum" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fvoyagenum }"/>
					  <label class="Validform_label" style="display: none;">航次</label>
				   </td>--%>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].fmodel" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fmodel }"/>
					  <label class="Validform_label" style="display: none;">型号</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].fmakeboxtime" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" maxlength="32" type="text" class="Wdate"  style="width:120px;"  ignore="ignore"  value="${poVal.fmakeboxtime }"/>
					  <label class="Validform_label" style="display: none;">做箱时间</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].fgrade" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fgrade }"/>
					  <label class="Validform_label" style="display: none;">等级</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].fdrpagenum" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fdrpagenum }"/>
					  <label class="Validform_label" style="display: none;">危规页码</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].funnumber" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.funnumber }"/>
					  <label class="Validform_label" style="display: none;">联合国编号</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].flashPoint" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.flashPoint }"/>
					  <label class="Validform_label" style="display: none;">闪点</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].fcolddegree" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fcolddegree }"/>
					  <label class="Validform_label" style="display: none;">冷藏温度</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].ftotals" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore"  value="${poVal.ftotals }"/>
					  <label class="Validform_label" style="display: none;">总件数</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].fgrosses" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore"  value="${poVal.fgrosses }"/>
					  <label class="Validform_label" style="display: none;">总毛重</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].fvolumes" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore"  value="${poVal.fvolumes }"/>
					  <label class="Validform_label" style="display: none;">总体积</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].fextract" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fextract }"/>
					  <label class="Validform_label" style="display: none;">提箱点</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].freturn" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.freturn }"/>
					  <label class="Validform_label" style="display: none;">还箱点</label>
				   </td>
				   <td align="left">
					  	<input name="contianerList[${stuts.index }].foperator" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.foperator }"/>
					  <label class="Validform_label" style="display: none;">集装箱经营人</label>
				   </td>
					<td align="left">
						<input name="contianerList[${stuts.index }].fzhdp" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fzhdp }"/>
						<label class="Validform_label" style="display: none;">装货门点</label>
					</td>
					<td align="left">
						<input name="contianerList[${stuts.index }].fzhdpdz" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fzhdpdz }"/>
						<label class="Validform_label" style="display: none;">门点地址</label>
					</td>
					<td align="left">
						<input name="contianerList[${stuts.index }].fzhunit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fzhunit }"/>
						<label class="Validform_label" style="display: none;">装货单位</label>
					</td>
					<td align="left">
						<input name="contianerList[${stuts.index }].fzhcontact" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fzhcontact }"/>
						<label class="Validform_label" style="display: none;">联系人</label>
					</td>
					<td align="left">
						<input name="contianerList[${stuts.index }].fzhmobile" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fzhmobile }"/>
						<label class="Validform_label" style="display: none;">联系电话</label>
					</td>
					<td align="left">
						<input name="contianerList[${stuts.index }].fnote" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fnote }"/>
						<label class="Validform_label" style="display: none;">备注</label>
					</td>
					<td align="left">
						<input name="contianerList[${stuts.index }].ftsyw" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.ftsyw }"/>
						<label class="Validform_label" style="display: none;">特殊业务</label>
					</td>
					<td align="left">
						<input name="contianerList[${stuts.index }].fxhdp" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fxhdp }"/>
						<label class="Validform_label" style="display: none;">卸货门点</label>
					</td>
					<td align="left">
						<input name="contianerList[${stuts.index }].fxhdpdz" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fxhdpdz }"/>
						<label class="Validform_label" style="display: none;">门点地址</label>
					</td>
					<td align="left">
						<input name="contianerList[${stuts.index }].fxhtime" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" maxlength="32" type="text" class="Wdate"  style="width:120px;"  ignore="ignore"  value="${poVal.fxhtime }"/>
						<label class="Validform_label" style="display: none;">卸货时间</label>
					</td>
					<td align="left">
						<input name="contianerList[${stuts.index }].fxhunit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fxhunit }"/>
						<label class="Validform_label" style="display: none;">卸货单位</label>
					</td>
					<td align="left">
						<input name="contianerList[${stuts.index }].fxhcontact" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fxhcontact }"/>
						<label class="Validform_label" style="display: none;">联系人</label>
					</td>
					<td align="left">
						<input name="contianerList[${stuts.index }].fxhmobile" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fxhmobile }"/>
						<label class="Validform_label" style="display: none;">联系人</label>
					</td>
   			</tr>
		</c:forEach>
	<%--</c:if>--%>
	</tbody>
</table>
