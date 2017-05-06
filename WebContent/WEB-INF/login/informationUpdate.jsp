<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
</head>
<body>
<div><a href="userManage">返回</a></div>
<h1>个人信息</h1>

<s:form name="informationUpdateForm" id="informationUpdateForm" action="updateInformation" method="post">
用户名：<s:textfield name="informationUpdateForm.id" value="%{#updateInformation.userId}" readonly="true"/><br/>
职工号：<s:textfield name="informationUpdateForm.no" value="%{#updateInformation.userNo}" /><br/>
姓名：<s:textfield name="informationUpdateForm.name" value="%{#updateInformation.userName}"/><br/>
电话：<s:textfield name="informationUpdateForm.phone" value="%{#updateInformation.userPhone}"/><br/>
<s:submit value="修改"/>
</s:form>
</body>
</html>