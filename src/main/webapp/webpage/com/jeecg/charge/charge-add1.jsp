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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" tiptype="1" layout="table" action="chargeController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${chargePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr hidden="true">
					<td align="right">
						<label class="Validform_label">
							收付:
						</label>
					</td>
					<td class="value">
						<%--<t:dictSelect id="fshoufu" field="fshoufu"  readonly="readonly" typeGroupCode="shoufu"  defaultVal="${sf}" hasLabel="false"></t:dictSelect>--%>
					    <input id="fshoufu" name="fshoufu"  type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${sf}"/>
                    </td>
                </tr>
                <tr>
					<td align="right">
						<label class="Validform_label">
							费用种类:
						</label>
					</td>
					<td class="value">
						<input id="fcost" name="fcost" placeholder="点击选择" onclick="popupClick(this,'fee_code,fname,fdefault_price','fcost,fcostname,fprice','costtype')" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${chargePage.fcost}"/>
					</td>

					<td align="right">
						<label class="Validform_label">
							费用种类名称:
						</label>
					</td>
					<td class="value">
						<input id="fcostname" name="fcostname" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  readonly="readonly" value="${chargePage.fcostname}"/>
					</td>
                </tr>
                <tr>
					<td align="right">
						<label class="Validform_label">
							结算单位:
						</label>
					</td>
					<td class="value">
						<input id="fsettle" name="fsettle" placeholder="点击选择" onclick="rp()" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
					</td>

					<td align="right">
						<label class="Validform_label">
							结算单位名称:
						</label>
					</td>
					<td class="value">
						<input id="fsettlename" name="fsettlename" type="text" style="width: 150px"	readonly="readonly" class="inputxt"  ignore="ignore" />
					</td>
                </tr>
                <tr>
					<td align="right">
						<label class="Validform_label">
							单价:
						</label>
					</td>
					<td class="value">
						<input id="fprice" name="fprice" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					</td>
					<td align="right">
						<label class="Validform_label">
							数量:
						</label>
					</td>
					<td class="value">
						<input id="fqty" name="fqty" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							金额:
						</label>
					</td>
					<td class="value">
						<input id="famount" name="famount" onclick="calculate()" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					</td>
					<td align="right">
						<label class="Validform_label">
							实际金额:
						</label>
					</td>
					<td class="value">
						<input id="fsfamount" name="fsfamount" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					</td>
                <tr>
                </tr>
					<td align="right">
						<label class="Validform_label">
							代垫:
						</label>
					</td>
					<td class="value" colspan="3">
						<t:dictSelect field="fdd" typeGroupCode="sf_yn" hasLabel="false"></t:dictSelect>
					</td>
				</tr>
				<tr hidden="hidden">
					<td class="value">
						<input id="fcheck" name="fcheck" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${fcheck}"/>
						<input id="forigin" name="forigin" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${forigin}"/>
						<input id="fbx" name="fbx" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="N"/>
						<input id="fdz" name="fdz" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="N"/>
						<input id="fhx" name="fhx" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="N"/>
						<input id="fid" name="fid" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked" value="${cid}"/>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/charge/charge.js"></script>
  <script type="text/javascript">
	  //根据收费类型，选择不同结算单位
      function rp(){
          var rp = $('#fshoufu').val();
          if (rp == '') {
              tip('请选择收付类型');
              return;
          }
          if (rp == '0') {
              popupClick(this, 'fcustom_code,fcn_name', 'fsettle,fsettlename', 'weituo');
              return;
          }
          if(rp=='1'){
              popupClick(this,'fcustom_code,fcn_name','fsettle,fsettlename','gys');
              return;
          }
      }

      //计算金额
      function calculate() {
          var price = $('#fprice').val();
          var qty = $('#fqty').val();
          var amount = price*qty;
          $('#famount').val(amount);
      }

      //计算本位币金额
      function benwei(){
          var price = $('#fprice').val();
          var qty = $('#fqty').val();
          var rate = $('#fhuilv').val();
          var amount = price*qty*rate;
          $('#fbwamount').val(amount);
      }
  </script>