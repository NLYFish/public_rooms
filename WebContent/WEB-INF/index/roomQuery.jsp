<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公用房查询(未使用)</title>

</head>

<body>
<div style="width:750px;height:30px;position:absolute;top:10px;border-bottom:1px solid #000">
<a style="position:relative;left:700px" href="">首页</a>
</div>

<div style="position:absolute;top:35px;">

<div style="float:left;position:relative;">
<h1>公用房管理系统</h1>
</div>

<div style="float:left;position:relative;top:21px;left:15px">
<p>公用房查询(未使用)</p>
</div>

</div>

<div style="position:relative;top:110px">

<div style="width:160px;height:340px;float:left;position:relative;border-right:1px solid #000">

</div>

<div style="float:left;position:relative;left:5px">

<div style="width:585px;height:30px;position:relative;border-bottom:1px solid #000">
<p>公用房查询(未使用)</p>
</div>

<div style="position:relative;top:10px">

<s:form name="roomQueryForm" id="roomQueryForm" action="roomQuery" method="get">
房号<s:textfield name="roomQueryForm.roomId" size="10"/>
房名<s:textfield name="roomQueryForm.roomName" size="10"/>
建筑<s:textfield name="roomQueryForm.roomBuilding" size="10"/>
楼层<s:textfield name="roomQueryForm.roomFloor" size="10"/>
<s:submit value="查询"/>
</s:form>

<br/>

<table id="roomList" border="1 "style="border-collapse:collapse">
<caption>公用房列表</caption>
<tr>
<td>房号</td>
<td>房名</td>
<td>建筑</td>
<td>楼层</td>
<td>面积</td>
<td>租金</td>
<td>说明</td>
</tr>

<tbody id="tbody">
<s:iterator value="%{#request.rooms}"> 
<tr> 
<td><s:property value="%{roomId}"/></td>  
<td><s:property value="%{roomName}"/></td>
<td><s:property value="%{roomBuilding}"/></td>  
<td><s:property value="%{roomFloor}"/></td>
<td><s:property value="%{roomArea}"/></td>  
<td><s:property value="%{roomHire}"/></td>
<td><s:property value="%{roomOther}"/></td>  
</tr>
</s:iterator> 
</tbody>
</table>

<br/>

<span id="spanFirst">第一页</span> 
<span id="spanPre">上一页</span> 
<span id="spanNext">下一页</span> 
<span id="spanLast">最后一页</span> 
第<span id="spanPageNum"></span>页/共<span id="spanTotalPage"></span>页

<br/><br/>
<a href="rentManage">返回</a>
</div>

</div>

</div>

</body>

<script type="text/javascript" src="js/pageScript.js"></script>
</html>
