<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金修改</title>
</head>
<body>
<h1>租金修改</h1>

<s:form name="hireUpdateForm" id="hireUpdateForm" action="updateHire" method="post">
房号：<s:textfield name="hireUpdateForm.roomId" value="%{#updateHire.roomId}" readonly="true"/><br/>
房名：<s:textfield name="hireUpdateForm.roomName" value="%{#updateHire.roomName}" readonly="true"/><br/>
租金：<s:textfield name="hireUpdateForm.hire" value="%{#updateHire.roomHire}"/><br/>
<s:submit value="修改"/>
</s:form>
</body>
</html>