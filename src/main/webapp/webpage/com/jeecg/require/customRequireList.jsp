<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCustomRequireBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCustomRequireBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCustomRequireBtn').bind('click', function(){   
 		 var tr =  $("#add_customRequire_table_template tr").clone();
	 	 $("#add_customRequire_table").append(tr);
	 	 resetTrNum('add_customRequire_table');
	 	 return false;
    });  
	$('#delCustomRequireBtn').bind('click', function(){   
      	$("#add_customRequire_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_customRequire_table'); 
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
	<a id="addCustomRequireBtn" href="#">添加</a> <a id="delCustomRequireBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="customRequire_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						资质要求
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						适用货物
				  </td>
	</tr>
	<tbody id="add_customRequire_table">
	<%--<c:if test="${fn:length(customRequireList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="customRequireList[0].id" type="hidden"/>
					<input name="customRequireList[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="customRequireList[0].frequire" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">资质要求</label>
					</td>
				  <td align="left">
					  	<input name="customRequireList[0].fgoods" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">适用货物</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(customRequireList)  > 0 }">--%>
		<c:forEach items="${customRequireList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="customRequireList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="customRequireList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
					  	<input name="customRequireList[${stuts.index }].frequire" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.frequire }"/>
					  <label class="Validform_label" style="display: none;">资质要求</label>
				   </td>
				   <td align="left">
					  	<input name="customRequireList[${stuts.index }].fgoods" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fgoods }"/>
					  <label class="Validform_label" style="display: none;">适用货物</label>
				   </td>
   			</tr>
		</c:forEach>
	<%--</c:if>--%>
	</tbody>
</table>
