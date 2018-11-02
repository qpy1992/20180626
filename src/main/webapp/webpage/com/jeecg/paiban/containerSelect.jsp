<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
        <div region="west" split="true" style="width:200px;">
            <ul id="tt1" class="easyui-tree">
                <li state="closed">
                    <span>按照区域</span>
                    <ul>
                        <li><span>File 11</span></li>
                        <li><span>File 12</span></li>
                        <li><span>File 13</span></li>
                    </ul>
                </li>
                <li><span>按照车型要求</span></li>
                <li state="closed"><span>货物属性</span>
                    <ul id="s1">
                        <li class="a"><span>普通货</span></li>
                        <li class="a"><span>冷箱</span></li>
                        <li class="a"><span>危险品</span></li>
                        <li class="a"><span>贵重品</span></li>
                    </ul>
                </li>
                <li state="closed"><span>特殊业务</span>
                    <ul id="s2">
                        <li class="s2"><span>甩挂</span></li>
                        <li class="s2"><span>驳箱</span></li>
                        <li class="s2"><span>预提</span></li>
                    </ul>
                </li>
            </ul>
    </div>
    <div region="center" style="width:800px;">
        <div tools="#tt" class="easyui-panel" style="padding: 10px;" fit="true" border="false" id="container-panel"></div>
    </div>
    <div id="tt"></div>
</div>
<script type="text/javascript">
    function containerList(type) {
        $("#container-panel").panel(
            {
                title :'集装箱信息',
                href:"containerController.do?container&type=" + type
            }
        );
    }
    $("#s1").on("click","li",function(){

        alert($(this).text());

    });
    $(".a").click(function(){
        alert( $(this).text());
    });
</script>