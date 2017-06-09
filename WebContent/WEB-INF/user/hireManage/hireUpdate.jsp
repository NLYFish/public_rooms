<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金修改</title>

<script type="text/javascript" src="js/isNum.js"></script>

<script type="text/javascript">

	function validateForm(thisform) {
		with (thisform) {
			if (isNum(hire, "hireCheck", "请输入数字") == false) {
				hire.focus();
				return false;
			} else {
				document.getElementById("hireCheck").innerHTML = "";
			}
		}
	}
	
</script>

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

<div style="width:160px;height:240px;float:left;position:relative;border-right:1px solid #000">
<a href="rentManage">公用房分配/租赁管理</a><br/>
<a href="repairManage">公用房维修管理</a><br/>
<a href="hireCount">公用房财务管理</a><br/>
<a href="getMessageDo">公用房通知管理</a><br/>
<a href="getNoticeDo">公用房公告管理</a><br/>
<a href="updateInformationPage">个人信息</a><br/>
<a href="updatePasswordPage">修改密码</a><br/>
<a href="exit">退出</a>
</div>

<div style="float:left;position:relative;left:5px">

<div style="width:585px;height:30px;position:relative;border-bottom:1px solid #000">
<p>租金修改</p>
</div>

<div style="position:relative;top:10px">

<s:form name="hireUpdateForm" id="hireUpdateForm" onsubmit="return validateForm(this)" action="updateHire" method="post">
房号：<s:textfield name="hireUpdateForm.roomId" value="%{#updateHire.roomId}" readonly="true"/><br/>
房名：<s:textfield name="hireUpdateForm.roomName" value="%{#updateHire.roomName}" readonly="true"/><br/>
租金：<s:textfield name="hireUpdateForm.hire" id="hire" value="%{#updateHire.roomHire}"/><span id="hireCheck"></span><br/><br/>
<s:submit value="修改"/>
</s:form>
<br/><br/>
<a href="hireManage">返回</a>
</div>

</div>

</div>

</body>
</html>