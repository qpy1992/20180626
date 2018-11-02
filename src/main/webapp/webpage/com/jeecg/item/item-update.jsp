<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>货物信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" tiptype="1" layout="table" action="itemController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${itemPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								货物名称:
							</label>
						</td>
						<td class="value">
						    <input id="fname" name="fname" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${itemPage.fname}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">货物名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								分拆:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="fsplit" type="radio"  typeGroupCode="sf_yn"   defaultVal="${itemPage.fsplit}" hasLabel="false"  title="分拆" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分拆</label>
						</td>
					</tr>
					<tr>
                        <td align="right">
                            <label class="Validform_label">
                                唛头:
                            </label>
                        </td>
                        <td class="value">
                            <input id="fmark" name="fmark" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">唛头</label>
                        </td>
						<td align="right">
							<label class="Validform_label">
								商品简称:
							</label>
						</td>
						<td class="value">
						    <input id="fabbr" name="fabbr" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${itemPage.fabbr}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品简称</label>
						</td>
					</tr>
					<tr>
                        <td align="right">
                            <label class="Validform_label">
                                商品编号:
                            </label>
                        </td>
                        <td class="value">
                            <input id="fnumber" name="fnumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${itemPage.fnumber}'/>
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">商品编号</label>
                        </td>
						<td align="right">
							<label class="Validform_label">
								客户分类:
							</label>
						</td>
						<td class="value">
						    <input id="fcusClass" name="fcusClass" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${itemPage.fcusClass}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户分类</label>
						</td>
					</tr>
					<tr>
                        <td align="right">
                            <label class="Validform_label">
                                厂商编号:
                            </label>
                        </td>
                        <td class="value">
                            <input id="fmanuNumber" name="fmanuNumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${itemPage.fmanuNumber}'/>
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">厂商编号</label>
                        </td>
						<td align="right">
							<label class="Validform_label">
								运输条件:
							</label>
						</td>
						<td class="value">
						    <input id="ftransCondition" name="ftransCondition" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${itemPage.ftransCondition}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">运输条件</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								运输备注:
							</label>
						</td>
						<td class="value" colspan="3">
						    <%--<input id="ftransNote" name="ftransNote" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${itemPage.ftransNote}'/>--%>
                            <textarea id="ftransNote" style="width:500px;" class="inputxt" rows="3" name="ftransNote"  ignore="ignore" >${itemPage.ftransNote}</textarea>
                            <span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">运输备注</label>
						</td>
                    </tr>
                    <tr>
                        <td align="right">
                            <label class="Validform_label">
                                保存条件:
                            </label>
                        </td>
                        <td class="value">
                            <input id="fpreseCondition" name="fpreseCondition" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${itemPage.fpreseCondition}'/>
                            <span class="Validform_checktip"></span>
                            <label class="Validform_label" style="display: none;">保存条件</label>
                        </td>
						<td align="right">
							<label class="Validform_label">
								毛重:
							</label>
						</td>
						<td class="value">
						    <input id="fgross" name="fgross" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${itemPage.fgross}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">毛重</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								净重:
							</label>
						</td>
						<td class="value">
						    <input id="fnet" name="fnet" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${itemPage.fnet}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">净重</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								单价:
							</label>
						</td>
						<td class="value">
						    <input id="fprice" name="fprice" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${itemPage.fprice}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单价</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								包装类型:
							</label>
						</td>
						<td class="value">
                            <t:dictSelect field="fpackType" type="list"  typeGroupCode="bag"   defaultVal="${itemPage.fpackType}" hasLabel="false"  title="包装类型" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">包装类型</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								卸货时间:
							</label>
						</td>
						<td class="value">
						    <input id="funloadTime" name="funloadTime" type="text" style="width: 120px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${itemPage.funloadTime}'/>
							<span class="Validform_checktip">分钟</span>
							<label class="Validform_label" style="display: none;">卸货时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								长度:
							</label>
						</td>
						<td class="value">
						    <input id="flength" name="flength" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${itemPage.flength}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">长度</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								宽度:
							</label>
						</td>
						<td class="value">
						    <input id="fwidth" name="fwidth" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${itemPage.fwidth}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">宽度</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								高度:
							</label>
						</td>
						<td class="value">
						    <input id="fheight" name="fheight" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${itemPage.fheight}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">高度</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								体积:
							</label>
						</td>
						<td class="value">
						    <input id="fvolume" name="fvolume" onclick="volume()" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${itemPage.fvolume}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">体积</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								下级数量:
							</label>
						</td>
						<td class="value">
						    <input id="flowerNumber" name="flowerNumber" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${itemPage.flowerNumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">下级数量</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								下级单位:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="flowerUnit" type="list"  typeGroupCode="unit"   defaultVal="${itemPage.flowerUnit}" hasLabel="false"  title="下级单位" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">下级单位</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value"  colspan="3" >
                            <textarea id="fnote" style="width:500px;" class="inputxt" rows="3" name="fnote"  ignore="ignore" >${itemPage.fnote}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/item/item.js"></script>
 <script type="text/javascript">
     function volume(){
         var length = $('#flength').val();
         var width = $('#fwidth').val();
         var height = $('#fheight').val();
         var volume = length*width*height;
         $('#fvolume').val(volume);
     }
 </script>