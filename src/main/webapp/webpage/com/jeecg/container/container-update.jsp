<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>集装箱</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="containerController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${containerPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								箱号:
							</label>
						</td>
						<td class="value">
						    <input id="fboxno" name="fboxno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.fboxno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								封号:
							</label>
						</td>
						<td class="value">
						    <input id="ftitle" name="ftitle" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.ftitle}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">封号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								箱型:
							</label>
						</td>
						<td class="value">
						    <input id="fboxtype" name="fboxtype" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.fboxtype}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								装船港:
							</label>
						</td>
						<td class="value">
						    <input id="floadport" name="floadport" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.floadport}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装船港</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								中转港:
							</label>
						</td>
						<td class="value">
						    <input id="ftransfer" name="ftransfer" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.ftransfer}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">中转港</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								目的港:
							</label>
						</td>
						<td class="value">
						    <input id="ftarget" name="ftarget" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.ftarget}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">目的港</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								航名:
							</label>
						</td>
						<td class="value">
						    <input id="fvoyage" name="fvoyage" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.fvoyage}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">航名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								航次:
							</label>
						</td>
						<td class="value">
						    <input id="fvoyagenum" name="fvoyagenum" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.fvoyagenum}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">航次</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								型号:
							</label>
						</td>
						<td class="value">
						    <input id="fmodel" name="fmodel" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.fmodel}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">型号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								做箱时间:
							</label>
						</td>
						<td class="value">
						    <input id="fmakeboxtime" name="fmakeboxtime" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.fmakeboxtime}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">做箱时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								等级:
							</label>
						</td>
						<td class="value">
						    <input id="fgrade" name="fgrade" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.fgrade}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">等级</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								危规页码:
							</label>
						</td>
						<td class="value">
						    <input id="fdrpagenum" name="fdrpagenum" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.fdrpagenum}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">危规页码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								联合国编号:
							</label>
						</td>
						<td class="value">
						    <input id="funnumber" name="funnumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.funnumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联合国编号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								闪点:
							</label>
						</td>
						<td class="value">
						    <input id="flashPoint" name="flashPoint" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.flashPoint}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">闪点</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								冷藏温度:
							</label>
						</td>
						<td class="value">
						    <input id="fcolddegree" name="fcolddegree" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.fcolddegree}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">冷藏温度</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								总件数:
							</label>
						</td>
						<td class="value">
						    <input id="ftotals" name="ftotals" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${containerPage.ftotals}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">总件数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								总毛重:
							</label>
						</td>
						<td class="value">
						    <input id="fgrosses" name="fgrosses" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${containerPage.fgrosses}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">总毛重</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								总体积:
							</label>
						</td>
						<td class="value">
						    <input id="fvolumes" name="fvolumes" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${containerPage.fvolumes}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">总体积</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								提箱点:
							</label>
						</td>
						<td class="value">
						    <input id="fextract" name="fextract" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.fextract}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提箱点</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								还箱点:
							</label>
						</td>
						<td class="value">
						    <input id="freturn" name="freturn" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.freturn}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">还箱点</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								集装箱经营人:
							</label>
						</td>
						<td class="value">
						    <input id="foperator" name="foperator" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerPage.foperator}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">集装箱经营人</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/container/container.js"></script>		
