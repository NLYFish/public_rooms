<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

<script type="text/javascript">
var loginFailure="${requestScope.loginFailure}"
if(loginFailure=="loginFailure"){
	alert("登录失败！");
}
</script>

<script type="text/javascript" src="js/checkNull.js"></script>

<script type="text/javascript">


	function validateForm(thisform) {
		with (thisform) {
			if (checkNull(id, "idCheck", "请输入用户名") == false) {
				document.getElementById("passwordCheck").innerHTML = "";
				id.focus();
				return false;
			} else {
				document.getElementById("idCheck").innerHTML = "";
			}

			if (checkNull(password, "passwordCheck", "请输入密码") == false) {
				document.getElementById("idCheck").innerHTML = "";
				password.focus();
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
<p>登录</p>
</div>

</div>

<div style="position:relative;top:110px">

<div style="width:160px;height:220px;float:left;position:relative;border-right:1px solid #000">

</div>

<div style="float:left;position:relative;left:5px">

<div style="width:585px;height:30px;position:relative;border-bottom:1px solid #000">
<p>登录</p>
</div>

<div style="position:relative;top:10px">

<s:form name="loginForm" id="loginForm" onsubmit="return validateForm(this)" action="login" method="post">
用户名：<s:textfield name="loginForm.id" id="id"/><span id="idCheck"></span><br/><br/>
密码：&nbsp;&nbsp;&nbsp; <s:password id="password" name="loginForm.password"/><span id="passwordCheck"></span><br/><br/>
用户类型：<s:radio name ="loginForm.type" list="%{#{'0':'管理员','1':'用户'}}" value="1"/><br/><br/>
<s:submit value="登录"/>
</s:form>

</div>

</div>

</div>

</body>

</html>