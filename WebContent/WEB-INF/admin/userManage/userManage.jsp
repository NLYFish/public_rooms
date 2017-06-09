<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工作人员管理</title>

<script type="text/javascript">
var notExist="${requestScope.notExist}"
if(notExist=="notExist"){
	alert("账号不存在！");
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

<div style="width:160px;height:350px;float:left;position:relative;border-right:1px solid #000">
<a href="userManage">工作人员管理</a><br/>
<a href="roomManage">公用房管理</a><br/>
<a href="updatePasswordPage">修改密码</a><br/>
<a href="exit">退出</a>
</div>



<div style="float:left;position:relative;left:5px">

<div style="width:585px;height:30px;position:relative;border-bottom:1px solid #000">
<p>工作人员管理</p>
</div>

<div style="position:relative;top:10px">

<s:form name="userUpdatePageForm" id="userUpdatePageForm" action="updateUserPage" mehtod="post">
账号<s:textfield name="userUpdateId" size="10"/><s:submit value="修改"/>
<a href="addUser">添加</a>
</s:form>

<br/>

<s:form name="userDeleteForm" id="userDeleteForm" action="deleteUser" method="post">

<table border="1 "style="border-collapse:collapse">
<caption>工作人员列表</caption>
<tr>
<td></td>
<td>账号</td>
<td>职工号</td>
<td>姓名</td>
<td>电话</td>
<td>密码</td>
</tr>

<tbody id="tbody">
<s:iterator value="%{#request.users}"> 
<tr> 
<td><input type="checkbox" name="userSelect" value="${userId}"></td>
<td><s:property value="%{userId}"/></td>  
<td><s:property value="%{userNo}"/></td>  
<td><s:property value="%{userName}"/></td>  
<td><s:property value="%{userPhone}"/></td>  
<td><s:property value="%{userPassword}"/></td>
</tr>
</s:iterator> 
</tbody>

</table>

<br/>

<span id="spanFirst">第一页</span> 
<span id="spanPre">上一页</span> 
<span id="spanNext">下一页</span> 
<span id="spanLast">最后一页</span> 
第<span id="spanPageNum"></span>页/共<span id="spanTotalPage"></span>页

<br/><br/>
<s:submit value="删除"/>

</s:form>

</div>

</div>

</div>

</body>
<script type="text/javascript" src="js/pageScript.js"></script>
</html>