<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
</head>
<body>
<h1>用户管理</h1>
<div>用户列表</div>

<table border="1 "style="border-collapse:collapse">
<tr>
<td>ID</td>
<td>密码</td>
</tr>

<s:iterator value="#session.users"> 
<tr> 
<td><s:property value="userId"/></td>  
<td><s:property value="userPassword"/></td>  
</tr>
</s:iterator> 

</table>

<br/>

<input type="button" value="添加用户" onclick="location.href='addUser'"/>
<input type="button" value="删除用户" onclick="location.href='deleteUser'"/>
<div><a href="admin">返回</a></div>
</body>
</html>