<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addRequireBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delRequireBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addRequireBtn').bind('click', function(){   
 		 var tr =  $("#add_require_table_template tr").clone();
	 	 $("#add_require_table").append(tr);
	 	 resetTrNum('add_require_table');
	 	 return false;
    });  
	$('#delRequireBtn').bind('click', function(){   
      	$("#add_require_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_require_table'); 
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
	<a id="addRequireBtn" href="#">添加</a> <a id="delRequireBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="require_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						资质类型
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						资质
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 300px;">
						说明
				  </td>
	</tr>
	<tbody id="add_require_table">
	<%--<c:if test="${fn:length(requireList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="requireList[0].id" type="hidden"/>
					<input name="requireList[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="requireList[0].frequireType" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">资质类型</label>
					</td>
				  <td align="left">
					  	<input name="requireList[0].fqual" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">资质</label>
					</td>
				  <td align="left">
					  	<input name="requireList[0].finstruction" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">说明</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(requireList)  > 0 }">--%>
		<c:forEach items="${requireList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="requireList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="requireList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
					  	<input name="requireList[${stuts.index }].frequireType" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.frequireType }"/>
					  <label class="Validform_label" style="display: none;">资质类型</label>
				   </td>
				   <td align="left">
					  	<input name="requireList[${stuts.index }].fqual" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fqual }"/>
					  <label class="Validform_label" style="display: none;">资质</label>
				   </td>
				   <td align="left">
					  	<input name="requireList[${stuts.index }].finstruction" maxlength="255" type="text" class="inputxt"  style="width:300px;"  ignore="ignore"  value="${poVal.finstruction }"/>
					  <label class="Validform_label" style="display: none;">说明</label>
				   </td>
   			</tr>
		</c:forEach>
	<%--</c:if>--%>
	</tbody>
</table>
