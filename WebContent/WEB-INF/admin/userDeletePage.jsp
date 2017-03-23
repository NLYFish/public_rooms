<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除用户</title>
</head>
<body>

<h1>删除用户</h1>

<s:form name="userDeleteForm" id="userDeleteForm" action="deleteUser" method="post">
<s:textfield name="userDeleteForm.id" label="ID" />
<s:submit value="删除"/>
</s:form>
<div><a href="userManage">返回</a></div>

</body>
</html>