<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租赁修改</title>
</head>

<body>

<h1>修改租赁</h1>

<s:form name="rentUpdateForm" id="rentUpdateForm" action="updateRent" method="post">
房号：<s:textfield name="rentUpdateForm.roomId" value="%{#updateRent.roomId}" readonly="true"/><br/>
房名：<s:textfield name="rentUpdateForm.roomName" value="%{#updateRent.roomName}" /><br/>
姓名：<s:textfield name="rentUpdateForm.renterName" value="%{#updateRent.renterName}"/><br/>
身份证：<s:textfield name="rentUpdateForm.renterId" value="%{#updateRent.renterId}"/><br/>
电话：<s:textfield name="rentUpdateForm.renterPhone" value="%{#updateRent.renterPhone}"/><br/>
开始日期：<s:textfield name="rentUpdateForm.startDate" value="%{#updateRent.startDate}"/><br/>
结束日期：<s:textfield name="rentUpdateForm.endDate" value="%{#updateRent.endDate}"/><br/>
租金：<s:textfield name="rentUpdateForm.hire" value="%{#updateRent.hire}"/><br/>
说明：<s:textfield name="rentUpdateForm.other" value="%{#updateRent.hire}"/><br/>
<s:submit value="修改"/>
</s:form>

</body>
</html>