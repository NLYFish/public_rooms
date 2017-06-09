<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改公用房</title>

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
<p>修改公用房</p>
</div>

<div style="position:relative;top:10px">

<s:form name="roomUpdateForm" id="roomUpdateForm" onsubmit="return validateForm(this)" action="updateRoom" method="post">
房号：<s:textfield name="roomUpdateForm.id" value="%{#updateRoom.roomId}" readonly="true"/><br/>
房名：<s:textfield name="roomUpdateForm.name" value="%{#updateRoom.roomName}" /><br/>
建筑：<s:textfield name="roomUpdateForm.building" value="%{#updateRoom.roomBuilding}"/><br/>
楼层：<s:textfield name="roomUpdateForm.floor" value="%{#updateRoom.roomFloor}"/><br/>
面积：<s:textfield name="roomUpdateForm.area" value="%{#updateRoom.roomArea}"/><br/>
租金：<s:textfield name="roomUpdateForm.hire" id="hire" value="%{#updateRoom.roomHire}"/><span id="hireCheck"></span><br/>
说明：<s:textfield name="roomUpdateForm.other" value="%{#updateRoom.roomOther}"/><br/><br/>
<s:submit value="修改"/>
<a href="roomManage">返回</a>
</s:form>

</div>

</div>

</div>

</body>

</html>