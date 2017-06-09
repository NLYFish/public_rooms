<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公用房分配/租赁查询</title>

</head>

<body>
<div style="width:750px;height:30px;position:absolute;top:10px;border-bottom:1px solid #000">
<a style="position:relative;left:700px" href="login">登录</a>
</div>

<div style="position:absolute;top:35px;">

<div style="float:left;position:relative;">
<h1>公用房管理系统</h1>
</div>

<div style="float:left;position:relative;top:21px;left:15px">
<p>首页</p>
</div>

</div>

<div style="position:relative;top:110px">

<div style="width:160px;height:280px;float:left;position:relative;border-right:1px solid #000">
<a href="">通知/公告</a><br>
<a href="roomQuery">公用房查询(未使用)</a><br>
<a href="rentQuery">公用房分配/租赁查询</a><br>
</div>

<div style="float:left;position:relative;left:5px">

<div style="width:585px;height:30px;position:relative;border-bottom:1px solid #000">
<p>公用房分配/租赁查询</p>
</div>

<div style="position:relative;top:10px">

<s:form name="rentQueryForm" id="rentQueryForm" action="rentQuery" method="get">
房号<s:textfield name="rentQueryForm.roomId" size="10"/>
房名<s:textfield name="rentQueryForm.roomName" size="10"/>
类型<s:select name="rentQueryForm.type" list="#{'0':'分配','1':'租赁'}" headerKey="" headerValue="全部"/>
<s:submit value="查询"/>
</s:form>

<br/>

<table id="rentList" border="1 "style="border-collapse:collapse">
<caption>分配/租赁列表</caption>
<tr>
<td></td>
<td>房号</td>
<td>房名</td>
<td>类型</td>
<td>开始日期</td>
<td>结束日期</td>
</tr>

<tbody id="tbody">
<s:iterator value="%{#request.rents}"> 
<tr> 
<td><input type="checkbox"  name="rentSelect" value="${roomId}"/></td>
<td><s:property value="%{roomId}"/></td>  
<td><s:property value="%{roomName}"/></td>
<td><s:property value="%{type}"/></td>  
<td><s:date name="%{rentStartDate}" format="yyyy-MM-dd"/></td>
<td><s:date name="%{rentEndDate}" format="yyyy-MM-dd"/></td>
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

</div>

</div>

</div>

</body>
<script type="text/javascript" src="js/pageScript.js"></script>

</html>
