<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金管理</title>

<script type="text/javascript">
var notExist="${requestScope.notExist}"
if(notExist=="notExist"){
	alert("公用房不存在！");
}
</script>

</head>
<body>
<div><a href="user">返回</a></div>
<h1>租金管理</h1>

<s:form name="hireQueryForm" id="hireQueryForm" action="hireManage" method="get">
房号<s:textfield name="hireQueryForm.roomId" size="10"/>
房名<s:textfield name="hireQueryForm.roomName" size="10"/>
<s:submit value="查询"/>
</s:form>

<br/>

<s:form name="hireUpdatePageForm" id="hireUpdatePageForm" action="updateHirePage" mehtod="post">
房号<s:textfield name="hireUpdateId" size="10"/><s:submit value="修改"/>
</s:form>

<br/>

<table id="hireList" border="1 "style="border-collapse:collapse">
<caption>租金列表</caption>
<tr>
<td>房号</td>
<td>房名</td>
<td>租金</td>
</tr>

<tbody id="tbody">
<s:iterator value="%{#request.hires}"> 
<tr> 
<td><s:property value="%{roomId}"/></td>  
<td><s:property value="%{roomName}"/></td>
<td><s:property value="%{roomHire}"/></td>  
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


</body>
</html>
<script type="text/javascript" src="js/pageScript.js"></script>