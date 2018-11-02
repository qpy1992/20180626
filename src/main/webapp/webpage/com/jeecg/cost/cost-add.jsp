<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>费用</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="costController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${costPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							收付:
						</label>
					</td>
					<td class="value" colspan="3">
						<t:dictSelect id="frecePay" field="frecePay" type="list"  typeGroupCode="shoufu"  defaultVal="${costPage.frecePay}" hasLabel="false"  title="收付" ></t:dictSelect>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">收付</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							费用种类:
						</label>
					</td>
					<td class="value">
						<input id="fcostType" name="fcostType" type="text" onclick="popupClick(this,'fee_code,fname,funit,fdefault_price,fdefault_currency,frate','fcostType,fcostname,funit,fprice,fbibie,fhuilv','costtype')" style="width: 150px" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">费用种类</label>
					</td>

					<td align="right">
						<label class="Validform_label">
							费用种类名称:
						</label>
					</td>
					<td class="value">
						<input id="fcostname" name="fcostname" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">费用种类</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							结算单位:
						</label>
					</td>
					<td class="value">
						<input id="fsettleUnit" name="fsettleUnit" type="text" onclick="rp()" style="width: 150px" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">结算单位</label>
					</td>

					<td align="right">
						<label class="Validform_label">
							结算单位名称:
						</label>
					</td>
					<td class="value">
						<input id="fsettlename" name="fsettlename" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">结算单位</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							单位:
						</label>
					</td>
					<td class="value">
						<input id="funit" name="funit" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">单位</label>
					</td>

					<td align="right">
						<label class="Validform_label">
							单价:
						</label>
					</td>
					<td class="value">
						<input id="fprice" name="fprice" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">单价</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							数量:
						</label>
					</td>
					<td class="value">
						<input id="fqty" name="fqty" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">数量</label>
					</td>

					<td align="right">
						<label class="Validform_label">
							收付金额:
						</label>
					</td>
					<td class="value">
						<input id="frpamount" name="frpamount" type="text" style="width: 150px" onclick="calculate()" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">收付金额</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							金额:
						</label>
					</td>
					<td class="value">
						<input id="famount" name="famount" type="text" style="width: 150px" onclick="calculate()" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">金额</label>
					</td>

					<td align="right">
						<label class="Validform_label">
							币别:
						</label>
					</td>
					<td class="value">
						<input id="fbibie" name="fbibie" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">币别</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							汇率:
						</label>
					</td>
					<td class="value">
						<input id="fhuilv" name="fhuilv" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">汇率</label>
					</td>

					<td align="right">
						<label class="Validform_label">
							本位币金额:
						</label>
					</td>
					<td class="value">
						<input id="fratedAmount" name="fratedAmount" type="text" style="width: 150px" onclick="benwei()" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">本位币金额</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							实际金额:
						</label>
					</td>
					<td class="value">
						<input id="factualAmount" name="factualAmount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">实际金额</label>
					</td>

					<td align="right">
						<label class="Validform_label">
							代垫:
						</label>
					</td>
					<td class="value">
						<t:dictSelect field="fcushion" type="list"  typeGroupCode="sf_yn"  defaultVal="${costPage.fcushion}" hasLabel="false"  title="代垫" ></t:dictSelect>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">代垫</label>
					</td>
				</tr>
				<%--<tr>
					<td align="right">
						<label class="Validform_label">
							费用属性:
						</label>
					</td>
					<td class="value">
						<input id="fcostProp" name="fcostProp" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">费用属性</label>
					</td>

					<td align="right">
						<label class="Validform_label">
							客户号:
						</label>
					</td>
					<td class="value">
						<input id="fcusNum" name="fcusNum" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">客户号</label>
					</td>
				</tr>--%>
                <tr>
                    <td class="value" hidden="hidden">
					<input id="fcheck" name="fcheck" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${fcheck}"/>
					<input id="finputPerson" name="finputPerson" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${finputPerson}"/>
					<input id="finputTime" name="finputTime" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${finputTime}"/>
					<input id="fid" name="fid" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked" value="${cid}"/>
                    </td>
                </tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/cost/cost.js"></script>
 <script type="text/javascript">

     function rp(){
         var rp = $('#frecePay').val();
		 if (rp == '') {
			 tip('请选择收付类型');
			 return;
		 }
		 if (rp == '0') {
			 popupClick(this, 'fcustom_code,fcn_name', 'fsettleUnit,fsettlename', 'weituo');
			 return;
		 }
		 if(rp=='1'){
			 popupClick(this,'fcustom_code,fcn_name','fsettleUnit,fsettlename','gys');
			 return;
		 }
     }

     //计算金额
     function calculate() {
         var price = $('#fprice').val();
         var qty = $('#fqty').val();
         var amount = price*qty;
         $('#frpamount').val(amount);
         $('#famount').val(amount);
     }

     //计算本位币金额
	 function benwei(){
         var price = $('#fprice').val();
         var qty = $('#fqty').val();
         var rate = $('#fhuilv').val();
         var amount = price*qty*rate;
         $('#fratedAmount').val(amount);
	 }
 </script>
