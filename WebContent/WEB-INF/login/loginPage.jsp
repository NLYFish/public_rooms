<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>

<h1>登录</h1>

<s:form name="loginForm" id="loginForm" action="login" method="post">
<s:textfield name="loginForm.id" label="ID" />
<s:password name="loginForm.password" label="密码" />
<s:radio name ="loginForm.type" list="%{#{'0':'管理员','1':'用户'}}" value="1" label="用户类型" />
<s:submit value="登录"/>
</s:form>

<a href="index.jsp">首页</a>
</body>
</html>