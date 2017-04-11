<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租赁添加</title>

<script type="text/javascript">
var exist="${requestScope.exist}"
if(exist=="exist"){
	alert("公用房已租赁！");
}
</script>

</head>
<body>

<h1>添加租赁</h1>

<s:form name="rentAddForm" id="rentAddForm" action="addRent" method="post">
房号：<s:textfield name="rentAddForm.roomId"/><br/>
房名：<s:textfield name="rentAddForm.roomName"/><br/>
姓名：<s:textfield name="rentAddForm.renterName"/><br/>
身份证：<s:textfield name="rentAddForm.renterId"/><br/>
电话：<s:textfield name="rentAddForm.renterPhone"/><br/>
开始日期：<s:textfield name="rentAddForm.startDate" /><br/>
结束日期：<s:textfield name="rentAddForm.endDate" /><br/>
租金：<s:textfield name="rentAddForm.hire"/><br/>
说明：<s:textfield name="rentAddForm.other"/><br/>
<s:submit value="添加"/>
</s:form>

</body>
</html>