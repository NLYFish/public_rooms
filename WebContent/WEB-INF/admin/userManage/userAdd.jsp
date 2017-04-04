<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<script type="text/javascript">
var exist="${requestScope.exist}"
if(exist=="exist"){
	alert("用户名已存在！");
}
</script>
</head>
<body>
<h1>添加用户</h1>

<s:form name="userAddForm" id="userAddForm" action="addUser" method="post">
用户名：<s:textfield name="userAddForm.id"/><br/>
密码：<s:textfield name="userAddForm.password"/>
<s:submit value="添加"/>
</s:form>
<div><a href="userManage">返回</a></div>
</body>
</html>