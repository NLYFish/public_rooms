<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>adminIndex</title>
</head>
<body>

<h1>管理员</h1>

<div>用户名:${session.id}</div>
<div><a href="exit">退出</a></div>
<div><a href="userManage">用户管理</a></div>
<div><a href="roomManage">公用房管理</a></div>
<div><a href="">首页</a></div>
<div><a href="updatePasswordPage">修改密码</a></div>
</body>
</html>