<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公用房修改</title>
</head>
<body>
<div><a href="roomManage">返回</a></div>
<h1>公用房修改</h1>

<s:form name="roomUpdateForm" id="roomUpdateForm" action="updateRoom" method="post">
房号：<s:textfield name="roomUpdateForm.id" value="%{#updateRoom.roomId}" readonly="true"/><br/>
房名：<s:textfield name="roomUpdateForm.name" value="%{#updateRoom.roomName}" /><br/>
建筑：<s:textfield name="roomUpdateForm.building" value="%{#updateRoom.roomBuilding}"/><br/>
楼层：<s:textfield name="roomUpdateForm.floor" value="%{#updateRoom.roomFloor}"/><br/>
面积：<s:textfield name="roomUpdateForm.area" value="%{#updateRoom.roomArea}"/><br/>
租金：<s:textfield name="roomUpdateForm.hire" value="%{#updateRoom.roomHire}"/><br/>
说明：<s:textfield name="roomUpdateForm.other" value="%{#updateRoom.roomOther}"/><br/>
<s:submit value="修改"/>
</s:form>
</body>
</html>