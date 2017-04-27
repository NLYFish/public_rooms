<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>维修添加</title>

<script type="text/javascript">
var noExist="${requestScope.noExist}"
if(noExist=="noExist"){
	alert("公用房不存在！");
}
</script>

</head>
<body>

<h1>添加维修</h1>

<s:form name="repairAddForm" id="repairAddForm" action="addRepair" method="post">
房号：<s:textfield name="repairAddForm.roomId"/><br/>
负责人：<s:textfield name="repairAddForm.repairer"/><br/>
电话：<s:textfield name="repairAddForm.repairerPhone"/><br/>
费用：<s:textfield name="repairAddForm.repairHire"/><br/>
日期：<s:textfield name="repairAddForm.repairDate" /><br/>
说明：<s:textfield name="repairAddForm.repairother"/><br/>
<s:submit value="添加"/>
</s:form>

</body>
</html>