<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加公用房</title>
<script type="text/javascript">
var exist="${requestScope.exist}"
if(exist=="exist"){
	alert("公用房已存在！");
}
</script>
</head>
<body>

<h1>添加用户</h1>

<s:form name="roomAddForm" id="roomAddForm" action="addRoom" method="post">
房号：<s:textfield name="roomAddForm.id"/><br/>
房名：<s:textfield name="roomAddForm.name"/><br/>
建筑：<s:textfield name="roomAddForm.building"/><br/>
楼层：<s:textfield name="roomAddForm.floor"/><br/>
面积：<s:textfield name="roomAddForm.area"/><br/>
地址：<s:textfield name="roomAddForm.address"/><br/>
说明：<s:textfield name="roomAddForm.other"/><br/>
租金：<s:textfield name="roomAddForm.hire"/><br/>
<s:submit value="添加"/>
</s:form>
<div><a href="roomManage">返回</a></div>

</body>
</html>