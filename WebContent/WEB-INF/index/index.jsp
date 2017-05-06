<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

</head>
<body>

<a href="login">登录</a>
<a href="roomQuery">未使用公用房查询</a>
<a href="rentQuery">公用房当前分配租赁查询</a>
<h1>首页</h1>

<div>通知</div>
<textarea name="message" id="message" style="height:150px;width:500px;" readonly="true"></textarea>
<div>公告</div>
<s:textarea name="noticeText" id="noticeText" style="height:150px;width:500px;" readonly="true"></s:textarea>

<br/><br/>
<table id="noticeList" border="1 "style="border-collapse:collapse">
<tr>
<td>公告(点击查看)</td>
</tr>

<tbody id="tbody">
<s:iterator value="%{#request.notices}" id="notice"> 
<tr> 
<td><a href="javascript:void(0)" onclick='noticeText("${notice}")'>${notice}</a></td>  
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

<br/>



</body>
</html>
<script type="text/javascript" src="js/messageScript.js"></script>
<script type="text/javascript" src="js/pageScript.js"></script>
<script type="text/javascript" src="js/noticeScript.js"></script>