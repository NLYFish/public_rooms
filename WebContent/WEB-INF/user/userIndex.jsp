<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工作人员</title>
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
<p>工作人员  ${session.id}</p>
</div>

</div>

<div style="position:relative;top:110px">

<div style="width:160px;height:160px;float:left;position:relative;border-right:1px solid #000">

<a href="rentManage">公用房分配/租赁管理</a><br/>
<a href="repairManage">公用房维修管理</a><br/>
<a href="hireCount">公用房财务管理</a><br/>
<a href="getMessageDo">公用房通知管理</a><br/>
<a href="getNoticeDo">公用房公告管理</a><br/>
<a href="updateInformationPage">个人信息</a><br/>
<a href="updatePasswordPage">修改密码</a><br/>
<a href="exit">退出</a>
</div>


</div>

</body>

</html>