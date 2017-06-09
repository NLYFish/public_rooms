<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分配/租赁添加</title>

<script type="text/javascript">
var exist="${requestScope.exist}"
if(exist=="exist"){
	alert("公用房不存在或已分配/租赁！");
}
</script>

<script type="text/javascript" src="js/isNum.js"></script>
<script type="text/javascript" src="js/isDate.js"></script>

<script type="text/javascript">

	function validateForm(thisform) {
		with (thisform) {
			
			if (isDate(startDate, "startDateCheck", "请输入日期") == false) {
				document.getElementById("dayCheck").innerHTML = "";
				startDate.focus();
				return false;
			} else {
				document.getElementById("startDateCheck").innerHTML = "";
			}
			
			if (isNum(day, "dayCheck", "请输入数字") == false) {
				document.getElementById("startDateCheck").innerHTML = "";
				day.focus();
				return false;
			} else {
				document.getElementById("dayCheck").innerHTML = "";
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

<div style="width:160px;height:300px;float:left;position:relative;border-right:1px solid #000">
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
<p>添加分配/租赁</p>
</div>

<div style="position:relative;top:10px">

<s:form name="rentAddForm" id="rentAddForm" onsubmit="return validateForm(this)" action="addRent" method="post">
房号：<s:textfield name="rentAddForm.roomId"/><br/>
类型：<s:select name="rentAddForm.type" list="#{'0':'分配','1':'租赁'}" headerValue="分配"/><br/>
所属：<s:textfield name="rentAddForm.renter"/><br/>
负责人：<s:textfield name="rentAddForm.renterName"/><br/>
身份证/职工号：<s:textfield name="rentAddForm.renterId"/><br/>
电话：<s:textfield name="rentAddForm.renterPhone"/><br/>
日期：<s:textfield name="rentAddForm.startDate" id="startDate"/><span id="startDateCheck"></span><br/>
天数：<s:textfield name="rentAddForm.day" id="day"/><span id="dayCheck"></span><br/>
说明：<s:textfield name="rentAddForm.other"/><br/><br/>
<s:submit value="添加"/>
<a href="rentManage">返回</a>
</s:form>

</div>

</div>

</div>

</body>

</html>