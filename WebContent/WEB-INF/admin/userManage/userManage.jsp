<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>

<script type="text/javascript">
var notExist="${requestScope.notExist}"
if(notExist=="notExist"){
	alert("用户不存在！");
}
</script>

</head>
<body>
<div><a href="admin">返回</a></div>
<h1>用户管理</h1>

<s:form name="userUpdatePageForm" id="userUpdatePageForm" action="updateUserPage" mehtod="post">
用户名<s:textfield name="userUpdateId" size="10"/><s:submit value="修改"/>
<input type="button" value="添加" onclick="location.href='addUser'"/>
</s:form>

<br/>

<s:form name="userDeleteForm" id="userDeleteForm" action="deleteUser" method="post">

<table border="1 "style="border-collapse:collapse">
<caption>用户列表</caption>
<tr>
<td></td>
<td>用户名</td>
<td>职工号</td>
<td>姓名</td>
<td>电话</td>
<td>密码</td>
</tr>

<s:iterator value="%{#request.users}"> 
<tr> 
<td><input type="checkbox" name="userSelect" value="${userId}"></td>
<td><s:property value="%{userId}"/></td>  
<td><s:property value="%{userNo}"/></td>  
<td><s:property value="%{userName}"/></td>  
<td><s:property value="%{userPhone}"/></td>  
<td><s:property value="%{userPassword}"/></td>
</tr>
</s:iterator> 

</table>

<s:submit value="删除"/>

</s:form>

</body>
</html>