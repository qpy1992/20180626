<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addDetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delDetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addDetailBtn').bind('click', function(){   
 		 var tr =  $("#add_detail_table_template tr").clone();
	 	 $("#add_detail_table").append(tr);
	 	 resetTrNum('add_detail_table');
	 	 return false;
    });  
	$('#delDetailBtn').bind('click', function(){   
      	$("#add_detail_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_detail_table'); 
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
	<a id="addDetailBtn" href="#">添加</a> <a id="delDetailBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="detail_table">
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
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						体积
				  </td>
	</tr>
	<tbody id="add_detail_table">
	<c:if test="${fn:length(detailList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="detailList[0].id" type="hidden"/>
					<input name="detailList[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="detailList[0].fbillno" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" value="${fblno}">
					  <label class="Validform_label" style="display: none;">提单号</label>
					</td>
				  <td align="left">
					  	<input name="detailList[0].fname" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">货名</label>
					</td>
				  <td align="left">
					  	<input name="detailList[0].fmaitou" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">唛头</label>
					</td>
				  <td align="left">
					  	<input name="detailList[0].fpackage" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">包装</label>
					</td>
				  <td align="left">
					  	<input name="detailList[0].fqty" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" value="0">
					  <label class="Validform_label" style="display: none;">件数</label>
					</td>
				  <td align="left">
					  	<input name="detailList[0].fgross" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" value="0">
					  <label class="Validform_label" style="display: none;">毛重</label>
					</td>
				  <td align="left">
					    <input name="detailList[0].fvolume" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" value="0">
					  <label class="Validform_label" style="display: none;">体积</label>
				    </td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(detailList)  > 0 }">
		<c:forEach items="${detailList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="detailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="detailList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
					  	<input name="detailList[${stuts.index }].fbillno" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fbillno }"/>
					  <label class="Validform_label" style="display: none;">提单号</label>
				   </td>
				   <td align="left">
					  	<input name="detailList[${stuts.index }].fname" placeholder="点击选择" onclick="popupClick(this,'fname,fmark,fpack_type,bpm_status,fgross','fname,fmaitou,fpackage,fqty,fgross','goods')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fname }"/>
					  <label class="Validform_label" style="display: none;">货名</label>
				   </td>
				   <td align="left">
					  	<input name="detailList[${stuts.index }].fmaitou" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fmaitou }"/>
					  <label class="Validform_label" style="display: none;">唛头</label>
				   </td>
				   <td align="left">
					  	<input name="detailList[${stuts.index }].fpackage" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fpackage }"/>
					  <label class="Validform_label" style="display: none;">包装</label>
				   </td>
				   <td align="left">
					  	<input name="detailList[${stuts.index }].fqty" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore"  value="${poVal.fqty }"/>
					  <label class="Validform_label" style="display: none;">件数</label>
				   </td>
				   <td align="left">
					  	<input name="detailList[${stuts.index }].fgross" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fgross }"/>
					  <label class="Validform_label" style="display: none;">毛重</label>
				   </td>
				   <td align="left">
					    <input name="detailList[${stuts.index }].fvolume" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fvolume }"/>
					  <label class="Validform_label" style="display: none;">体积</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>
	</tbody>
</table>
