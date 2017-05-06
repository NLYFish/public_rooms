<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userIndex</title>
</head>
<body>

<h1>用户</h1>

<div>ID:${session.id}</div>
<div><a href="exit">退出</a></div>
<div><a href="rentManage">公用房分配/租赁管理</a></div>
<div><a href="repairManage">公用房维修管理</a></div>
<div><a href="hireCount">公用房财务管理</a></div>
<div><a href="getMessageDo">公用房通知管理</a></div>
<div><a href="getNoticeDo">公用房公告管理</a></div>
<div><a href="">首页</a></div>
<div><a href="updatePasswordPage">修改密码</a></div>
<div><a href="updateInformationPage">个人信息</a></div>
</body>
</html>