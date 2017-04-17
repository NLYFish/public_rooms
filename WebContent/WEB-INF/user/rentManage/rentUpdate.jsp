<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分配/租赁修改</title>
</head>

<body>

<h1>修改分配/租赁</h1>

<s:form name="rentUpdateForm" id="rentUpdateForm" action="updateRent" method="post">
房号：<s:textfield name="rentUpdateForm.roomId" value="%{#updateRent.roomId}" readonly="true"/><br/>
房名：<s:textfield name="rentUpdateForm.roomName" value="%{#updateRent.roomName}" /><br/>
类型：<s:select name="rentUpdateForm.type" list="#{'0':'分配','1':'租赁'}"  headerValue="%{#updateRent.type}"/><br/>
部门：<s:textfield name="rentUpdateForm.renter" value="%{#updateRent.renter}" /><br/>
负责人：<s:textfield name="rentUpdateForm.renterName" value="%{#updateRent.renterName}"/><br/>
身份证/职工号：<s:textfield name="rentUpdateForm.renterId" value="%{#updateRent.renterId}"/><br/>
电话：<s:textfield name="rentUpdateForm.renterPhone" value="%{#updateRent.renterPhone}"/><br/>
日期：<s:textfield name="rentUpdateForm.startDate" value="%{#updateRent.startDate}"/><br/>
天数：<s:textfield name="rentUpdateForm.day" value="%{#updateRent.day}"/><br/>
说明：<s:textfield name="rentUpdateForm.other" value="%{#updateRent.other}"/><br/>
<s:submit value="修改"/>
</s:form>

</body>
</html>