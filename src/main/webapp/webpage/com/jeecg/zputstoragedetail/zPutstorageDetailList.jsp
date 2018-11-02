<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZPutstorageDetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZPutstorageDetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addZPutstorageDetailBtn').bind('click', function(){   
 		 var tr =  $("#add_zPutstorageDetail_table_template tr").clone();
	 	 $("#add_zPutstorageDetail_table").append(tr);
	 	 resetTrNum('add_zPutstorageDetail_table');
	 	 return false;
    });  
	$('#delZPutstorageDetailBtn').bind('click', function(){   
      	$("#add_zPutstorageDetail_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zPutstorageDetail_table'); 
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
	<a id="addZPutstorageDetailBtn" href="#">添加</a> <a id="delZPutstorageDetailBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zPutstorageDetail_table">
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
						入库数量
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						进价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						进价合计
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						售价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						售价合计
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						采购日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
				 <!--  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						父id
				  </td> -->
	</tr>
	<tbody id="add_zPutstorageDetail_table">
	<c:if test="${fn:length(zPutstorageDetailList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="zPutstorageDetailList[0].id" type="hidden"/>
					<td align="left">
					  	<input name="zPutstorageDetailList[0].wulioCode" onclick="popupClick(this,'fwldm,fwlmc,fggxh,fdw,fjj,fxj','wulioCode,wulioName,specifications,unit,purchasePrice,salePrice','wuliao')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">物料代码</label>
					</td>
				  <td align="left">
					  	<input name="zPutstorageDetailList[0].wulioName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">物料名称</label>
					</td>
				  <td align="left">
					  	<input name="zPutstorageDetailList[0].specifications" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">规格型号</label>
					</td>
				  <td align="left">
					  	<input name="zPutstorageDetailList[0].unit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单位</label>
					</td>
				  <td align="left">
					  	<input name="zPutstorageDetailList[0].rkNumber" id="rkNumber" maxlength="32" type="text"  onchange="test()" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">入库数量</label>
					</td>
				  <td align="left">
					  	<input name="zPutstorageDetailList[0].purchasePrice" id="purchasePrice" maxlength="32" type="text" onchange="test()" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">进价</label>
					</td>
				  <td align="left">
					  	<input name="zPutstorageDetailList[0].purchaseTotal" id="purchaseTotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">进价合计</label>
					</td>
				  <td align="left">
					  	<input name="zPutstorageDetailList[0].salePrice" id="salePrice"  onchange="test()" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">售价</label>
					</td>
				  <td align="left">
					  	<input name="zPutstorageDetailList[0].saleTotal" id="saleTotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">售价合计</label>
					</td>
				  <td align="left">
					  	<input name="zPutstorageDetailList[0].purchaseDate" maxlength="32" type="text" class="Wdate"  onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">采购日期</label>
					</td>
				  <td align="left">
					  	<input name="zPutstorageDetailList[0].note" maxlength="32" type="text" class="inputxt"  onchange="test2(saleTotal.value)" style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
				 <!--  <td align="left">
					  	<input name="zPutstorageDetailList[0].fid" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">父id</label>
					</td> -->
   			</tr>
	</c:if>
	<c:if test="${fn:length(zPutstorageDetailList)  > 0 }">
		<c:forEach items="${zPutstorageDetailList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="zPutstorageDetailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
				<td align="left">
					  	<input name="zPutstorageDetailList[${stuts.index }].wulioCode" onclick="popupClick(this,'fwldm,fwlmc,fggxh,fdw,fjj,fxj','wulioCode,wulioName,specifications,unit,purchasePrice,salePrice','wuliao')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.wulioName }"/>
					  <label class="Validform_label" style="display: none;">物料代码</label>
				   </td>
				   <td align="left">
					  	<input name="zPutstorageDetailList[${stuts.index }].wulioName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.wulioName }"/>
					  <label class="Validform_label" style="display: none;">物料名称</label>
				   </td>
				   <td align="left">
					  	<input name="zPutstorageDetailList[${stuts.index }].specifications" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.specifications }"/>
					  <label class="Validform_label" style="display: none;">规格型号</label>
				   </td>
				   <td align="left">
					  	<input name="zPutstorageDetailList[${stuts.index }].unit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.unit }"/>
					  <label class="Validform_label" style="display: none;">单位</label>
				   </td>
				   <td align="left">
					  	<input name="zPutstorageDetailList[${stuts.index }].rkNumber" id="rkNumber" maxlength="32" type="text" class="inputxt"  onchange="test()" style="width:120px;"  datatype="n"  ignore="ignore"  value="${poVal.rkNumber }"/>
					  <label class="Validform_label" style="display: none;">入库数量</label>
				   </td>
				   <td align="left">
					  	<input name="zPutstorageDetailList[${stuts.index }].purchasePrice" id="purchasePrice" maxlength="32" type="text" class="inputxt" onchange="test()" style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.purchasePrice }"/>
					  <label class="Validform_label" style="display: none;">进价</label>
				   </td>
				   <td align="left">
					  	<input name="zPutstorageDetailList[${stuts.index }].purchaseTotal" id="purchaseTotal" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.purchaseTotal }"/>
					  <label class="Validform_label" style="display: none;">进价合计</label>
				   </td>
				   <td align="left">
					  	<input name="zPutstorageDetailList[${stuts.index }].salePrice" id="salePrice" maxlength="32" onchange="test()" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.salePrice }"/>
					  <label class="Validform_label" style="display: none;">售价</label>
				   </td>
				   <td align="left">
					  	<input name="zPutstorageDetailList[${stuts.index }].saleTotal" id="saleTotal" maxlength="32" onchange="test()" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.saleTotal }"/>
					  <label class="Validform_label" style="display: none;">售价合计</label>
				   </td>
				   <td align="left">
					  	<input name="zPutstorageDetailList[${stuts.index }].purchaseDate" maxlength="32" type="text" class="Wdate"  onClick="WdatePicker()" style="width:120px;"  ignore="ignore"  value="${poVal.purchaseDate }"/>
					  <label class="Validform_label" style="display: none;">采购日期</label>
				   </td>
				   <td align="left">
					  	<input name="zPutstorageDetailList[${stuts.index }].note" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.note }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
				  <%--  <td align="left">
					  	<input name="zPutstorageDetailList[${stuts.index }].fid" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fid }"/>
					  <label class="Validform_label" style="display: none;">父id</label>
				   </td> --%>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
 <script type="text/javascript">
	function test()
	{
		
		var rkNumber=document.getElementById("rkNumber").value;
		var purchasePrice=document.getElementById("purchasePrice").value;
		var purchase=rkNumber*purchasePrice;
		document.getElementById("purchaseTotal").value=purchase;
		
		var salePrice=document.getElementById("salePrice").value;
		var sale=rkNumber*salePrice;
		document.getElementById("saleTotal").value=sale;
		
	}
	
	
	   
</script> 
