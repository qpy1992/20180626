<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCusdpBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCusdpBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCusdpBtn').bind('click', function(){   
 		 var tr =  $("#add_cusdp_table_template tr").clone();
	 	 $("#add_cusdp_table").append(tr);
	 	 resetTrNum('add_cusdp_table');
	 	 return false;
    });  
	$('#delCusdpBtn').bind('click', function(){   
      	$("#add_cusdp_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_cusdp_table'); 
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
	<a id="addCusdpBtn" href="#">添加</a> <a id="delCusdpBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="cusdp_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						门点代码
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						门点名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						装货单位
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						送货单位
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						联系人
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						联系电话
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 300px;">
						运输要求
				  </td>
	</tr>
	<tbody id="add_cusdp_table">
	<%--<c:if test="${fn:length(cusdpList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="cusdpList[0].id" type="hidden"/>
					<input name="cusdpList[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="cusdpList[0].fitemid" onclick="popupClick(this,'fitemid,fname','fitemid,fname','dp_select')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">门点代码</label>
					</td>
				  <td align="left">
					  	<input name="cusdpList[0].fname" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">门点名称</label>
					</td>
				  <td align="left">
					  	<input name="cusdpList[0].floadunit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">装货单位</label>
					</td>
				  <td align="left">
					    <input name="cusdpList[0].fsendunit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">送货单位</label>
				  </td>
				  <td align="left">
					  	<input name="cusdpList[0].fcontact" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">联系人</label>
					</td>
				  <td align="left">
					  	<input name="cusdpList[0].fphone" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">联系电话</label>
					</td>
				  <td align="left">
						<input name="cusdpList[0].ftransnote" maxlength="32" type="text" class="inputxt"  style="width:200px;"  ignore="ignore" >
					   <label class="Validform_label" style="display: none;">运输要求</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(cusdpList)  > 0 }">--%>
		<c:forEach items="${cusdpList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="cusdpList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="cusdpList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
				      <input name="cusdpList[${stuts.index }].fitemid" onclick="popupClick(this,'fitemid,fname','fitemid,fname','dp_select')"
							 placeholder="点击选择门点" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fitemid }"/>
					  <label class="Validform_label" style="display: none;">门点代码</label>
				   </td>
				   <td align="left">
					  	<input name="cusdpList[${stuts.index }].fname" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fname }"/>
					  <label class="Validform_label" style="display: none;">门点名称</label>
				   </td>
				   <td align="left">
					  	<input name="cusdpList[${stuts.index }].floadunit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.floadunit }"/>
					  <label class="Validform_label" style="display: none;">装货单位</label>
				   </td>
				   <td align="left">
					  	<input name="cusdpList[${stuts.index }].fsendunit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fsendunit }"/>
					  <label class="Validform_label" style="display: none;">送货单位</label>
				   </td>
				   <td align="left">
					  	<input name="cusdpList[${stuts.index }].fcontact" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fcontact }"/>
					  <label class="Validform_label" style="display: none;">联系人</label>
				   </td>
				   <td align="left">
					  	<input name="cusdpList[${stuts.index }].fphone" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fphone }"/>
					  <label class="Validform_label" style="display: none;">联系电话</label>
				   </td>
				   <td align="left">
					  	<input name="cusdpList[${stuts.index }].ftransnote" maxlength="32" type="text" class="inputxt"  style="width:300px;"  ignore="ignore"  value="${poVal.ftransnote }"/>
					  <label class="Validform_label" style="display: none;">运输要求</label>
				   </td>
   			</tr>
		</c:forEach>
	<%--</c:if>--%>
	</tbody>
</table>
