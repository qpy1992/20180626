<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addHetong1Btn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delHetong1Btn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addHetong1Btn').bind('click', function(){   
 		 var tr =  $("#add_hetong1_table_template tr").clone();
	 	 $("#add_hetong1_table").append(tr);
	 	 resetTrNum('add_hetong1_table');
	 	 return false;
    });  
	$('#delHetong1Btn').bind('click', function(){   
      	$("#add_hetong1_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_hetong1_table'); 
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
	<a id="addHetong1Btn" href="#">添加</a> <a id="delHetong1Btn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="hetong1_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						门点代码
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						门点地址
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						提/还箱堆场区域
				  </td>
	</tr>
	<tbody id="add_hetong1_table">
	<%--<c:if test="${fn:length(hetong1List)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="hetong1List[0].id" type="hidden"/>
					<input name="hetong1List[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="hetong1List[0].fnumber" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">门点代码</label>
					</td>
				  <td align="left">
					  	<input name="hetong1List[0].faddress" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">门点地址</label>
					</td>
				  <td align="left">
					  	<input name="hetong1List[0].fyard" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">提还箱堆场区域</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(hetong1List)  > 0 }">--%>
		<c:forEach items="${hetong1List}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="hetong1List[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="hetong1List[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
					  	<input name="hetong1List[${stuts.index }].fnumber" placeholder="点击选择" onclick="popupClick(this,'fitemid,fname','fnumber,faddress','dp_select')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fnumber }"/>
					  <label class="Validform_label" style="display: none;">门点代码</label>
				   </td>
				   <td align="left">
					  	<input name="hetong1List[${stuts.index }].faddress" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.faddress }"/>
					  <label class="Validform_label" style="display: none;">门点地址</label>
				   </td>
				   <td align="left">
					  	<input name="hetong1List[${stuts.index }].fyard" placeholder="点击选择" onclick="popupClick(this,'fyard_name','fyard','yard')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fyard }"/>
					  <label class="Validform_label" style="display: none;">提还箱堆场区域</label>
				   </td>
   			</tr>
		</c:forEach>
	<%--</c:if>--%>
	</tbody>
</table>
