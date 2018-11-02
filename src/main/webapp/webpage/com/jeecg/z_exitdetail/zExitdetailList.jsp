<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZExitdetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZExitdetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addZExitdetailBtn').bind('click', function(){   
 		 var tr =  $("#add_zExitdetail_table_template tr").clone();
	 	 $("#add_zExitdetail_table").append(tr);u
	 	 resetTrNum('add_zExitdetail_table');
	 	 return false;
    });  
	$('#delZExitdetailBtn').bind('click', function(){   
      	$("#add_zExitdetail_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zExitdetail_table'); 
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
	<a id="addZExitdetailBtn" href="#">添加</a> <a id="delZExitdetailBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zExitdetail_table">
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
						库存数量
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						出库数量
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
						利润
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
	</tr>
	<tbody id="add_zExitdetail_table">
	<c:if test="${fn:length(zExitdetailList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="zExitdetailList[0].id" type="hidden"/>
					<input name="zExitdetailList[0].createName" type="hidden"/>
					<input name="zExitdetailList[0].createBy" type="hidden"/>
					<input name="zExitdetailList[0].createDate" type="hidden"/>
					<input name="zExitdetailList[0].updateName" type="hidden"/>
					<input name="zExitdetailList[0].updateBy" type="hidden"/>
					<input name="zExitdetailList[0].updateDate" type="hidden"/>
					<input name="zExitdetailList[0].sysOrgCode" type="hidden"/>
					<input name="zExitdetailList[0].sysCompanyCode" type="hidden"/>
					<input name="zExitdetailList[0].bpmStatus" type="hidden"/>
				  <td align="left">
					  	<input name="zExitdetailList[0].zExitId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">序号</label>
					</td>
				  <td align="left">
					  	<input name="zExitdetailList[0].zWldm"placeholder="点击选择"  onclick="popupClick(this,'fwldm,fwlmc,fggxh,fdw,fjj','zWldm,zWlmc,zGgxh,zDw,zJprice','wuliao')"  maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">物料代码</label>
					</td>
				  <td align="left">
					  	<input name="zExitdetailList[0].zWlmc" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">物料名称</label>
					</td>
				  <td align="left">
					  	<input name="zExitdetailList[0].zGgxh" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">规格型号</label>
					</td>
				  <td align="left">
					  	<input name="zExitdetailList[0].zDw" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单位</label>
					</td>
				  <td align="left">
					  	<input name="zExitdetailList[0].zKcsl" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">库存数量</label>
					</td>
				  <td align="left">
					  	<input name="zExitdetailList[0].zExitnum" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">出库数量</label>
					</td>
				  <td align="left">
					  	<input name="zExitdetailList[0].zJprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">进价</label>
					</td>
				  <td align="left">
					  	<input name="zExitdetailList[0].zJpricetotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">进价合计</label>
					</td>
				  <td align="left">
					  	<input name="zExitdetailList[0].zSprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">销价</label>
					</td>
				  <td align="left">
					  	<input name="zExitdetailList[0].zSpricetotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">销价合计</label>
					</td>
				  <td align="left">
					  	<input name="zExitdetailList[0].zProfit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">利润</label>
					</td>
				  <td align="left">
					  	<input name="zExitdetailList[0].zBz" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(zExitdetailList)  > 0 }">
		<c:forEach items="${zExitdetailList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="zExitdetailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="zExitdetailList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="zExitdetailList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="zExitdetailList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="zExitdetailList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="zExitdetailList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="zExitdetailList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="zExitdetailList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="zExitdetailList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="zExitdetailList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <td align="left">
					  	<input name="zExitdetailList[${stuts.index }].zExitId" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zExitId }"/>
					  <label class="Validform_label" style="display: none;">序号</label>
				   </td>
				   <td align="left">
					  	<input name="zExitdetailList[${stuts.index }].zWldm" onclick="popupClick(this,'fwldm,fwlmc,fggxh,fdw,fjj','zWldm,zWlmc,zGgxh,zDw,zJprice','wuliao')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zWldm }"/>
					  <label class="Validform_label" style="display: none;">物料代码</label>
				   </td>
				   <td align="left">
					  	<input name="zExitdetailList[${stuts.index }].zWlmc" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zWlmc }"/>
					  <label class="Validform_label" style="display: none;">物料名称</label>
				   </td>
				   <td align="left">
					  	<input name="zExitdetailList[${stuts.index }].zGgxh" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zGgxh }"/>
					  <label class="Validform_label" style="display: none;">规格型号</label>
				   </td>
				   <td align="left">
					  	<input name="zExitdetailList[${stuts.index }].zDw" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zDw }"/>
					  <label class="Validform_label" style="display: none;">单位</label>
				   </td>
				   <td align="left">
					  	<input name="zExitdetailList[${stuts.index }].zKcsl" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zKcsl }"/>
					  <label class="Validform_label" style="display: none;">库存数量</label>
				   </td>
				   <td align="left">
					  	<input name="zExitdetailList[${stuts.index }].zExitnum" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zExitnum }"/>
					  <label class="Validform_label" style="display: none;">出库数量</label>
				   </td>
				   <td align="left">
					  	<input name="zExitdetailList[${stuts.index }].zJprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.zJprice }"/>
					  <label class="Validform_label" style="display: none;">进价</label>
				   </td>
				   <td align="left">
					  	<input name="zExitdetailList[${stuts.index }].zJpricetotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.zJpricetotal }"/>
					  <label class="Validform_label" style="display: none;">进价合计</label>
				   </td>
				   <td align="left">
					  	<input name="zExitdetailList[${stuts.index }].zSprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.zSprice }"/>
					  <label class="Validform_label" style="display: none;">销价</label>
				   </td>
				   <td align="left">
					  	<input name="zExitdetailList[${stuts.index }].zSpricetotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.zSpricetotal }"/>
					  <label class="Validform_label" style="display: none;">销价合计</label>
				   </td>
				   <td align="left">
					  	<input name="zExitdetailList[${stuts.index }].zProfit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.zProfit }"/>
					  <label class="Validform_label" style="display: none;">利润</label>
				   </td>
				   <td align="left">
					  	<input name="zExitdetailList[${stuts.index }].zBz" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zBz }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
