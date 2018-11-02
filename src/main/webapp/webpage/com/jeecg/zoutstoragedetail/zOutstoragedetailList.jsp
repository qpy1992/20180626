<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZOutstoragedetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZOutstoragedetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addZOutstoragedetailBtn').bind('click', function(){   
 		 var tr =  $("#add_zOutstoragedetail_table_template tr").clone();
	 	 $("#add_zOutstoragedetail_table").append(tr);
	 	 resetTrNum('add_zOutstoragedetail_table');
	 	 return false;
    });  
	$('#delZOutstoragedetailBtn').bind('click', function(){   
      	$("#add_zOutstoragedetail_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zOutstoragedetail_table'); 
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
	<a id="addZOutstoragedetailBtn" href="#">添加</a> <a id="delZOutstoragedetailBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zOutstoragedetail_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
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
						领用数量
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
				<!--   <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						父id
				  </td> -->
	</tr>
	<tbody id="add_zOutstoragedetail_table">
	<c:if test="${fn:length(zOutstoragedetailList)  <= 0 }">
			<tr onChange="fun_tel1(this)">
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="zOutstoragedetailList[0].id" type="hidden"/>
				  <td align="left">
					  	<input name="zOutstoragedetailList[0].wulioCode" onclick="popupClick(this,'fwldm,fwlmc,fggxh,fdw,fjj,fxj','wulioCode,wulioName,specifications,unit,purchasePrice,salePrice','wuliao')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">物料代码</label>
					</td>
				  <td align="left">
					  	<input name="zOutstoragedetailList[0].wulioName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">物料名称</label>
					</td>
				  <td align="left">
					  	<input name="zOutstoragedetailList[0].specifications" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">规格型号</label>
					</td>
				  <td align="left">
					  	<input name="zOutstoragedetailList[0].unit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单位</label>
					</td>
				  <td align="left">
					  	<input name="zOutstoragedetailList[0].number" maxlength="32" type="text" class="inputxt"  datatype="n" style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">库存数量</label>
					</td>
				  <td align="left">
					  	<input name="zOutstoragedetailList[0].lyNumber" maxlength="32" type="text" class="inputxt"   datatype="n" style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">领用数量</label>
					</td>
				  <td align="left">
					  	<input name="zOutstoragedetailList[0].purchasePrice" maxlength="32" type="text" class="inputxt" datatype="/^(-?\d+)(\.\d+)?$/"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">进价</label>
					</td>
				  <td align="left">
					  	<input name="zOutstoragedetailList[0].purchaseTotal" maxlength="32" type="text" class="inputxt" datatype="/^(-?\d+)(\.\d+)?$/"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">进价合计</label>
					</td>
				  <td align="left">
					  	<input name="zOutstoragedetailList[0].salePrice" maxlength="32" type="text" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/" style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">销价</label>
					</td>
				  <td align="left">
					  	<input name="zOutstoragedetailList[0].saleTotal" maxlength="32" type="text" class="inputxt" datatype="/^(-?\d+)(\.\d+)?$/"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">销价合计</label>
					</td>
				  <td align="left">
					  	<input name="zOutstoragedetailList[0].profits" maxlength="32" type="text" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/" style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">利润</label>
					</td>
				  <td align="left">
					  	<input name="zOutstoragedetailList[0].note" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
				 <!--  <td align="left">
					  	<input name="zOutstoragedetailList[0].fid" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">父id</label>
					</td> -->
   			</tr>
	</c:if>
	<c:if test="${fn:length(zOutstoragedetailList)  > 0 }">
		<c:forEach items="${zOutstoragedetailList}" var="poVal" varStatus="stuts">
			<tr onChange="fun_tel1(this)">
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="zOutstoragedetailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
				   <td align="left">
					  	<input name="zOutstoragedetailList[${stuts.index }].wulioCode" onclick="popupClick(this,'fwldm,fwlmc,fggxh,fdw,fjj,fxj','wulioCode,wulioName,specifications,unit,purchasePrice,salePrice','wuliao')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.wulioCode }"/>
					  <label class="Validform_label" style="display: none;">物料代码</label>
				   </td>
				   <td align="left">
					  	<input name="zOutstoragedetailList[${stuts.index }].wulioName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.wulioName }"/>
					  <label class="Validform_label" style="display: none;">物料名称</label>
				   </td>
				   <td align="left">
					  	<input name="zOutstoragedetailList[${stuts.index }].specifications" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.specifications }"/>
					  <label class="Validform_label" style="display: none;">规格型号</label>
				   </td>
				   <td align="left">
					  	<input name="zOutstoragedetailList[${stuts.index }].unit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.unit }"/>
					  <label class="Validform_label" style="display: none;">单位</label>
				   </td>
				   <td align="left">
					  	<input name="zOutstoragedetailList[${stuts.index }].number" maxlength="32" type="text" class="inputxt"  datatype="n" style="width:120px;"  ignore="ignore"  value="${poVal.number }"/>
					  <label class="Validform_label" style="display: none;">库存数量</label>
				   </td>
				   <td align="left">
					  	<input name="zOutstoragedetailList[${stuts.index }].lyNumber" maxlength="32" type="text" class="inputxt"  datatype="n" style="width:120px;"  ignore="ignore"  value="${poVal.lyNumber }"/>
					  <label class="Validform_label" style="display: none;">领用数量</label>
				   </td>
				   <td align="left">
					  	<input name="zOutstoragedetailList[${stuts.index }].purchasePrice" maxlength="32" type="text" datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.purchasePrice }"/>
					  <label class="Validform_label" style="display: none;">进价</label>
				   </td>
				   <td align="left">
					  	<input name="zOutstoragedetailList[${stuts.index }].purchaseTotal" maxlength="32" type="text" datatype="/^(-?\d+)(\.\d+)?$/" datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.purchaseTotal }"/>
					  <label class="Validform_label" style="display: none;">进价合计</label>
				   </td>
				   <td align="left">
					  	<input name="zOutstoragedetailList[${stuts.index }].salePrice" maxlength="32" type="text" datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.salePrice }"/>
					  <label class="Validform_label" style="display: none;">销价</label>
				   </td>
				   <td align="left">
					  	<input name="zOutstoragedetailList[${stuts.index }].saleTotal" maxlength="32" type="text" datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.saleTotal }"/>
					  <label class="Validform_label" style="display: none;">销价合计</label>
				   </td>
				   <td align="left">
					  	<input name="zOutstoragedetailList[${stuts.index }].profits" maxlength="32" type="text" datatype="/^(-?\d+)(\.\d+)?$/" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.profits }"/>
					  <label class="Validform_label" style="display: none;">利润</label>
				   </td>
				   <td align="left">
					  	<input name="zOutstoragedetailList[${stuts.index }].note" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.note }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
				 <%--   <td align="left">
					  	<input name="zOutstoragedetailList[${stuts.index }].fid" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fid }"/>
					  <label class="Validform_label" style="display: none;">父id</label>
				   </td> --%>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
	<!--  <script type="text/javascript">
 
 function fun_tel1(ele){
      
	 var a=ele.cells[8].childNodes[0].value;   
	 alert(324)
	 alert(a);
	 //var b=ele.cells[7].childNodes[0].value;  
	// ele.cells[8].childNodes[0].value = a * b;
	
	
} 

 </script>
 -->