<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>

<script type="text/javascript">
var error="${requestScope.error}"
if(error=="error"){
	alert("原密码错误！");
}
</script>

<script type="text/javascript">

function validateForm(thisform) {
	with (thisform) {
		var n=newPassword.value;
		var s=surePassword.value;
		if (n!=s) {
			surePassword.focus();
			document.getElementById("passwordCheck").innerHTML = "两次输入不同";
			return false;
		} else {
			document.getElementById("passwordCheck").innerHTML = "";

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
<p>修改密码  ${session.id}</p>
</div>

</div>

<div style="position:relative;top:110px">

<div style="width:160px;height:260px;float:left;position:relative;border-right:1px solid #000">

</div>



<div style="float:left;position:relative;left:5px">

<div style="width:585px;height:30px;position:relative;border-bottom:1px solid #000">
<p>修改密码</p>
</div>

<div style="position:relative;top:10px">

<s:form name="passwordUpdateForm" id="passwordUpdateForm" onsubmit="return validateForm(this)" action="updatePassword" method="post">
原密码：&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield name="passwordUpdateForm.oldPassword"/><br/>
新密码：&nbsp;&nbsp;&nbsp;&nbsp;<s:password name="passwordUpdateForm.newPassword" id="newPassword"/><br/>
确认密码：<s:password name="passwordUpdateForm.surePassword" id="surePassword"/><span id="passwordCheck"></span><br/><br/>
<s:submit value="修改"/>
<a href="login">返回</a>
</s:form>

</div>

</div>

</div>

</body>

</html>