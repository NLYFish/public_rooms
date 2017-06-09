<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改工作人员</title>
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
<p>管理员  ${session.id}</p>
</div>

</div>

<div style="position:relative;top:110px">

<div style="width:160px;height:260px;float:left;position:relative;border-right:1px solid #000">
<a href="userManage">工作人员管理</a><br/>
<a href="roomManage">公用房管理</a><br/>
<a href="updatePasswordPage">修改密码</a><br/>
<a href="exit">退出</a>
</div>



<div style="float:left;position:relative;left:5px">

<div style="width:585px;height:30px;position:relative;border-bottom:1px solid #000">
<p>修改工作人员</p>
</div>

<div style="position:relative;top:10px">

<s:form name="userUpdateForm" id="userUpdateForm" action="updateUser" method="post">
账号：&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield name="userUpdateForm.id" value="%{#updateUser.userId}" readonly="true"/><br/>
职工号：<s:textfield name="userUpdateForm.no" value="%{#updateUser.userNo}" /><br/>
姓名：&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield name="userUpdateForm.name" value="%{#updateUser.userName}"/><br/>
电话：&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield name="userUpdateForm.phone" value="%{#updateUser.userPhone}"/><br/>
密码：&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield name="userUpdateForm.password" value="%{#updateUser.userPassword}"/><br/><br/>
<s:submit value="修改"/>
<a href="userManage">返回</a>
</s:form>

</div>

</div>

</div>

</body>




<body>
<div><a href="userManage">返回</a></div>
<h1>用户修改</h1>


</body>
</html>