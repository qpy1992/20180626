<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>费用管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zFyglController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${zFyglPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							客户名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="fkhname" name="fkhname" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							双拖:
						</label>
					</td>
					<td class="value">
					     	 <input id="fst" name="fst" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">双拖</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							套箱:
						</label>
					</td>
					<td class="value">
					     	 <input id="ftx" name="ftx" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">套箱</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							暂落:
						</label>
					</td>
					<td class="value">
					     	 <input id="fzl" name="fzl" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">暂落</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							甩挂:
						</label>
					</td>
					<td class="value">
					     	 <input id="fsg" name="fsg" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">甩挂</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							驳箱:
						</label>
					</td>
					<td class="value">
					     	 <input id="fbx" name="fbx" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驳箱</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							外委:
						</label>
					</td>
					<td class="value">
					     	 <input id="fww" name="fww" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">外委</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							预提:
						</label>
					</td>
					<td class="value">
					     	 <input id="fyt" name="fyt" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预提</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							门点地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="fmddz" name="fmddz" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">门点地址</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							销售订单号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fxsddh" name="fxsddh" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">销售订单号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							箱型箱量:
						</label>
					</td>
					<td class="value">
					     	 <input id="xxxl" name="xxxl" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱型箱量</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							客户采购订单号:
						</label>
					</td>
					<td class="value">
					     	 <input id="khcgddh" name="khcgddh" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户采购订单号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							封号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fh" name="fh" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">封号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							应付锁定:
						</label>
					</td>
					<td class="value">
					     	 <input id="yfsd" name="yfsd" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">应付锁定</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							应收锁定:
						</label>
					</td>
					<td class="value">
					     	 <input id="yssd" name="yssd" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">应收锁定</label>
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
  <script src = "webpage/com/jeecg/zfygl/zFygl.js"></script>		
