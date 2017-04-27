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

</head>
<body>

<h1>添加分配/租赁</h1>

<s:form name="rentAddForm" id="rentAddForm" action="addRent" method="post">
房号：<s:textfield name="rentAddForm.roomId"/><br/>
类型：<s:select name="rentAddForm.type" list="#{'0':'分配','1':'租赁'}" headerValue="分配"/><br/>
部门：<s:textfield name="rentAddForm.renter"/><br/>
负责人：<s:textfield name="rentAddForm.renterName"/><br/>
身份证/职工号：<s:textfield name="rentAddForm.renterId"/><br/>
电话：<s:textfield name="rentAddForm.renterPhone"/><br/>
日期：<s:textfield name="rentAddForm.startDate" /><br/>
天数：<s:textfield name="rentAddForm.day" /><br/>
说明：<s:textfield name="rentAddForm.other"/><br/>
<s:submit value="添加"/>
</s:form>

</body>
</html>