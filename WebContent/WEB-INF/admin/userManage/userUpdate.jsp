<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户修改</title>
</head>
<body>
<div><a href="userManage">返回</a></div>
<h1>用户修改</h1>

<s:form name="userUpdateForm" id="userUpdateForm" action="updateUser" method="post">
用户名：<s:textfield name="userUpdateForm.id" value="%{#updateUser.userId}" readonly="true"/><br/>
职工号：<s:textfield name="userUpdateForm.no" value="%{#updateUser.userNo}" /><br/>
姓名：<s:textfield name="userUpdateForm.name" value="%{#updateUser.userName}"/><br/>
电话：<s:textfield name="userUpdateForm.phone" value="%{#updateUser.userPhone}"/><br/>
密码：<s:textfield name="userUpdateForm.password" value="%{#updateUser.userPassword}"/><br/>
<s:submit value="修改"/>
</s:form>
</body>
</html>