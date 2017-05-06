<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知管理</title>

</head>
<body>

<div><a href="user">返回</a></div>
<h1>通知管理</h1>

<div>通知</div>
<s:form name="messageForm" id="messageForm" action="setMessageDo" method="post">
<s:textarea name="message" id="message" style="height:150px;width:500px;"></s:textarea><br/>
<s:submit value="修改"/>
</s:form>
</body>
</html>

<script type="text/javascript" src="js/messageScript.js"></script>