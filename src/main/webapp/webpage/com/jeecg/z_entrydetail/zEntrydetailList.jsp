<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZEntrydetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZEntrydetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addZEntrydetailBtn').bind('click', function(){   
 		 var tr =  $("#add_zEntrydetail_table_template tr").clone();
	 	 $("#add_zEntrydetail_table").append(tr);
	 	 resetTrNum('add_zEntrydetail_table');
	 	 return false;
    });  
	$('#delZEntrydetailBtn').bind('click', function(){   
      	$("#add_zEntrydetail_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zEntrydetail_table'); 
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
	<a id="addZEntrydetailBtn" href="#">添加</a> <a id="delZEntrydetailBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zEntrydetail_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						序号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						物料代码
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						物料名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						规格型号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单位
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						入库数量
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						进价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						进价合计
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						销价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						销价合计
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						采购日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
	</tr>
	<tbody id="add_zEntrydetail_table">
	<c:if test="${fn:length(zEntrydetailList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="zEntrydetailList[0].id" type="hidden"/>
					<input name="zEntrydetailList[0].createName" type="hidden"/>
					<input name="zEntrydetailList[0].createBy" type="hidden"/>
					<input name="zEntrydetailList[0].createDate" type="hidden"/>
					<input name="zEntrydetailList[0].updateName" type="hidden"/>
					<input name="zEntrydetailList[0].updateBy" type="hidden"/>
					<input name="zEntrydetailList[0].updateDate" type="hidden"/>
					<input name="zEntrydetailList[0].sysOrgCode" type="hidden"/>
					<input name="zEntrydetailList[0].sysCompanyCode" type="hidden"/>
					<input name="zEntrydetailList[0].bpmStatus" type="hidden"/>
				  <td align="left">
					  	<input name="zEntrydetailList[0].zId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">序号</label>
					</td>
				  <td align="left">
					  	<input name="zEntrydetailList[0].zWldm"	placeholder="点击选择"  onclick="popupClick(this,'fwldm,fwlmc,fggxh,fdw,fjj','zWldm,zWlmc,zGgxh,zDw,zJprice','wuliao')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">物料代码</label>
					</td>
				  <td align="left">
					  	<input name="zEntrydetailList[0].zWlmc" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">物料名称</label>
					</td>
				  <td align="left">
					  	<input name="zEntrydetailList[0].zGgxh" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">规格型号</label>
					</td>
				  <td align="left">
					  	<input name="zEntrydetailList[0].zDw" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单位</label>
					</td>
				  <td align="left">
					  	<input name="zEntrydetailList[0].zNum" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">入库数量</label>
					</td>
				  <td align="left">
					  	<input name="zEntrydetailList[0].zJprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">进价</label>
					</td>
				  <td align="left">
					  	<input name="zEntrydetailList[0].zJpricetotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">进价合计</label>
					</td>
				  <td align="left">
					  	<input name="zEntrydetailList[0].zSprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">销价</label>
					</td>
				  <td align="left">
					  	<input name="zEntrydetailList[0].zSpricetotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">销价合计</label>
					</td>
				  <td align="left">
					  	<input name="zEntrydetailList[0].zCgdate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">采购日期</label>
					</td>
				  <td align="left">
					  	<input name="zEntrydetailList[0].zBz" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(zEntrydetailList)  > 0 }">
		<c:forEach items="${zEntrydetailList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="zEntrydetailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="zEntrydetailList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="zEntrydetailList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="zEntrydetailList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="zEntrydetailList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="zEntrydetailList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="zEntrydetailList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="zEntrydetailList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="zEntrydetailList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="zEntrydetailList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
					  	<input name="zEntrydetailList[${stuts.index }].zId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zId }"/>
					  <label class="Validform_label" style="display: none;">序号</label>
				   </td>
				   <td align="left">
					  	<input name="zEntrydetailList[${stuts.index }].zWldm"  onclick="popupClick(this,'fwldm,fwlmc,fggxh,fdw,fjj','zWldm,zWlmc,zGgxh,zDw,zJprice','wuliao')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zWldm }"/>
					  <label class="Validform_label" style="display: none;">物料代码</label>
				   </td>
				   <td align="left">
					  	<input name="zEntrydetailList[${stuts.index }].zWlmc" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zWlmc }"/>
					  <label class="Validform_label" style="display: none;">物料名称</label>
				   </td>
				   <td align="left">
					  	<input name="zEntrydetailList[${stuts.index }].zGgxh" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zGgxh }"/>
					  <label class="Validform_label" style="display: none;">规格型号</label>
				   </td>
				   <td align="left">
					  	<input name="zEntrydetailList[${stuts.index }].zDw" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zDw }"/>
					  <label class="Validform_label" style="display: none;">单位</label>
				   </td>
				   <td align="left">
					  	<input name="zEntrydetailList[${stuts.index }].zNum" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zNum }"/>
					  <label class="Validform_label" style="display: none;">入库数量</label>
				   </td>
				   <td align="left">
					  	<input name="zEntrydetailList[${stuts.index }].zJprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.zJprice }"/>
					  <label class="Validform_label" style="display: none;">进价</label>
				   </td>
				   <td align="left">
					  	<input name="zEntrydetailList[${stuts.index }].zJpricetotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.zJpricetotal }"/>
					  <label class="Validform_label" style="display: none;">进价合计</label>
				   </td>
				   <td align="left">
					  	<input name="zEntrydetailList[${stuts.index }].zSprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.zSprice }"/>
					  <label class="Validform_label" style="display: none;">销价</label>
				   </td>
				   <td align="left">
					  	<input name="zEntrydetailList[${stuts.index }].zSpricetotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.zSpricetotal }"/>
					  <label class="Validform_label" style="display: none;">销价合计</label>
				   </td>
				   <td align="left">
					  	<input name="zEntrydetailList[${stuts.index }].zCgdate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zCgdate }"/>
					  <label class="Validform_label" style="display: none;">采购日期</label>
				   </td>
				   <td align="left">
					  	<input name="zEntrydetailList[${stuts.index }].zBz" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zBz }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
