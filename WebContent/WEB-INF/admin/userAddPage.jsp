<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
<h1>添加用户</h1>

<s:form name="userAddForm" id="userAddForm" action="addUser" method="post">
<s:textfield name="userAddForm.id" label="ID" />
<s:password name="userAddForm.password" label="密码" />
<s:submit value="添加"/>
</s:form>

</body>
</html>