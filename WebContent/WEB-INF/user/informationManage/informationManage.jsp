<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

</head>
<body>

<div><a href="user">返回</a></div>
<h1>通知/公告管理</h1>

<br/>

<div>通知/公告</div>
<s:form name="informationForm" id="informationForm" action="setInformation" method="post">
<s:textarea name="information" id="information" style="height:250px;width:250px;"></s:textarea>
<s:submit value="更改"/>
</s:form>
</body>
</html>

<script type="text/javascript" src="js/informationScript.js"></script>