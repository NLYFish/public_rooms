<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>
<div><a href="userManage">返回</a></div>
<h1>修改密码</h1>

<s:form name="passwordUpdateForm" id="passwordUpdateForm" action="updatePassword" method="post">
旧密码：<s:textfield name="passwordUpdateForm.oldPassword"/><br/>
新密码：<s:textfield name="passwordUpdateForm.newPassword"/><br/>
确认密码：<s:textfield name="passwordUpdateForm.surePassword"/><br/>
<s:submit value="修改"/>
</s:form>
</body>
</html>