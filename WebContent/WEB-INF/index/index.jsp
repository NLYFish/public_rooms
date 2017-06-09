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

<div style="width:160px;height:380px;float:left;position:relative;border-right:1px solid #000">
<a href="">通知/公告</a><br>
<a href="roomQuery">公用房查询(未使用)</a><br>
<a href="rentQuery">公用房分配/租赁查询</a><br>
</div>

<div style="float:left;position:relative;left:5px">

<div style="width:585px;height:30px;position:relative;border-bottom:1px solid #000">
<p>通知</p>
</div>

<div style="position:relative;top:10px">
<textarea name="message" id="message" style="height:102px;width:580px;" readonly="true"></textarea>
</div>

<div style="width:585px;height:30px;position:relative;top:10px;border-bottom:1px solid #000">
<p>公告</p>
</div>


<div style="position:relative;top:20px">

<div style="float:left;position:relative">
<table id="noticeList" border="1 "style="border-collapse:collapse;width:150px">

<tbody id="tbody">
<s:iterator value="%{#request.notices}" id="notice"> 
<tr> 
<td><a href="javascript:void(0)" onclick='noticeText("${notice}")'>${notice}</a></td>  
</tr>
</s:iterator> 
</tbody>
</table>
</div>

<div style="position:relative;left:5px">
<s:textarea name="noticeText" id="noticeText" style="height:102px;width:425px;" readonly="true"></s:textarea>
</div>

<div style="position:relative;top:10px">
<span id="spanFirst">第一页</span> 
<span id="spanPre">上一页</span> 
<span id="spanNext">下一页</span> 
<span id="spanLast">最后一页</span> 
第<span id="spanPageNum"></span>页/共<span id="spanTotalPage"></span>页
</div>

</div>

</div>

</div>


</body>
<script type="text/javascript" src="js/messageScript.js"></script>
<script type="text/javascript" src="js/pageScript.js"></script>
<script type="text/javascript" src="js/noticeScript.js"></script>
</html>

