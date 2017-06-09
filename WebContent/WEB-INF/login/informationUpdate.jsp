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
<div style="width:750px;height:30px;position:absolute;top:10px;border-bottom:1px solid #000">
<a style="position:relative;left:700px" href="">首页</a>
</div>

<div style="position:absolute;top:35px;">

<div style="float:left;position:relative;">
<h1>公用房管理系统</h1>
</div>

<div style="float:left;position:relative;top:21px;left:15px">
<p>个人信息  ${session.id}</p>
</div>

</div>

<div style="position:relative;top:110px">

<div style="width:160px;height:260px;float:left;position:relative;border-right:1px solid #000">

</div>



<div style="float:left;position:relative;left:5px">

<div style="width:585px;height:30px;position:relative;border-bottom:1px solid #000">
<p>个人信息</p>
</div>

<div style="position:relative;top:10px">

<s:form name="informationUpdateForm" id="informationUpdateForm" action="updateInformation" method="post">
用户名：<s:textfield name="informationUpdateForm.id" value="%{#updateInformation.userId}" readonly="true"/><br/>
职工号：<s:textfield name="informationUpdateForm.no" value="%{#updateInformation.userNo}" /><br/>
姓名：<s:textfield name="informationUpdateForm.name" value="%{#updateInformation.userName}"/><br/>
电话：<s:textfield name="informationUpdateForm.phone" value="%{#updateInformation.userPhone}"/><br/><br/>
<s:submit value="修改"/>
<a href="login">返回</a>
</s:form>

</div>

</div>

</div>

</body>

</html>