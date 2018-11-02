<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>集装箱</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="containerController.do?save">
			<input id="id" name="id" type="hidden" value="${containerPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							箱号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fboxno" name="fboxno" ignore="ignore"  value="${containerPage.fboxno}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							封号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ftitle" name="ftitle" ignore="ignore"  value="${containerPage.ftitle}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							箱型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fboxtype" name="fboxtype" ignore="ignore"  value="${containerPage.fboxtype}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							装船港:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="floadport" name="floadport" ignore="ignore"  value="${containerPage.floadport}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							中转港:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ftransfer" name="ftransfer" ignore="ignore"  value="${containerPage.ftransfer}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							目的港:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ftarget" name="ftarget" ignore="ignore"  value="${containerPage.ftarget}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							航名:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fvoyage" name="fvoyage" ignore="ignore"  value="${containerPage.fvoyage}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							航次:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fvoyagenum" name="fvoyagenum" ignore="ignore"  value="${containerPage.fvoyagenum}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							型号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fmodel" name="fmodel" ignore="ignore"  value="${containerPage.fmodel}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							做箱时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="fmakeboxtime" name="fmakeboxtime" ignore="ignore"    value="<fmt:formatDate value='${containerPage.fmakeboxtime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							等级:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fgrade" name="fgrade" ignore="ignore"  value="${containerPage.fgrade}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							危规页码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fdrpagenum" name="fdrpagenum" ignore="ignore"  value="${containerPage.fdrpagenum}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							联合国编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="funnumber" name="funnumber" ignore="ignore"  value="${containerPage.funnumber}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							闪点:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flashPoint" name="flashPoint" ignore="ignore"  value="${containerPage.flashPoint}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							冷藏温度:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fcolddegree" name="fcolddegree" ignore="ignore"  value="${containerPage.fcolddegree}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							总件数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ftotals" name="ftotals" ignore="ignore"  value="${containerPage.ftotals}" datatype="n" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							总毛重:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fgrosses" name="fgrosses" ignore="ignore"  value="${containerPage.fgrosses}" datatype="n" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							总体积:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fvolumes" name="fvolumes" ignore="ignore"  value="${containerPage.fvolumes}" datatype="n" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							提箱点:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fextract" name="fextract" ignore="ignore"  value="${containerPage.fextract}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							还箱点:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="freturn" name="freturn" ignore="ignore"  value="${containerPage.freturn}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							集装箱经营人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="foperator" name="foperator" ignore="ignore"  value="${containerPage.foperator}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							主表主键:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fid" name="fid" ignore="ignore"  value="${containerPage.fid}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							装货门点:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fzhdp" name="fzhdp" ignore="ignore"  value="${containerPage.fzhdp}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							门点地址:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fzhdpdz" name="fzhdpdz" ignore="ignore"  value="${containerPage.fzhdpdz}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							装货单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fzhunit" name="fzhunit" ignore="ignore"  value="${containerPage.fzhunit}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							联系人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fzhcontact" name="fzhcontact" ignore="ignore"  value="${containerPage.fzhcontact}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							联系电话:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fzhmobile" name="fzhmobile" ignore="ignore"  value="${containerPage.fzhmobile}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fnote" name="fnote" ignore="ignore"  value="${containerPage.fnote}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							特殊业务:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ftsyw" name="ftsyw" ignore="ignore"  value="${containerPage.ftsyw}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							卸货门点:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fxhdp" name="fxhdp" ignore="ignore"  value="${containerPage.fxhdp}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							门点地址:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fxhdpdz" name="fxhdpdz" ignore="ignore"  value="${containerPage.fxhdpdz}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							卸货时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="fxhtime" name="fxhtime" ignore="ignore"    value="<fmt:formatDate value='${containerPage.fxhtime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							卸货单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fxhunit" name="fxhunit" ignore="ignore"  value="${containerPage.fxhunit}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							联系人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fxhcontact" name="fxhcontact" ignore="ignore"  value="${containerPage.fxhcontact}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							联系电话:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fxhmobile" name="fxhmobile" ignore="ignore"  value="${containerPage.fxhmobile}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							对应派车单号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fbillno" name="fbillno" ignore="ignore"  value="${containerPage.fbillno}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							暂落:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fzanluo" name="fzanluo" ignore="ignore"  value="${containerPage.fzanluo}" datatype="n" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>