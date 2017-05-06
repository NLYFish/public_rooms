<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当前分配租赁查询</title>

</head>
<body>

<div><a href="">返回</a></div>
<h1>当前分配租赁查询</h1>

<s:form name="rentQueryForm" id="rentQueryForm" action="rentQuery" method="get">
房号<s:textfield name="rentQueryForm.roomId" size="10"/>
房名<s:textfield name="rentQueryForm.roomName" size="10"/>
类型<s:select name="rentQueryForm.type" list="#{'0':'分配','1':'租赁'}" headerKey="" headerValue="全部"/><br/>
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


</body>
</html>
<script type="text/javascript" src="js/pageScript.js"></script>