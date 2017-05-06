<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>未保用公用房查询</title>

<script type="text/javascript">
var notExist="${requestScope.notExist}"
if(notExist=="notExist"){
	alert("公用房不存在！");
}
</script>

</head>
<body>
<div><a href="rentManage">返回</a></div>
<h1>未使用公用房查询</h1>

<s:form name="roomQueryForm" id="roomQueryForm" action="roomQuery" method="get">
房号<s:textfield name="roomQueryForm.roomId" size="10"/>
房名<s:textfield name="roomQueryForm.roomName" size="10"/>
建筑<s:textfield name="roomQueryForm.roomBuilding" size="10"/>
楼层<s:textfield name="roomQueryForm.roomFloor" size="10"/>
<s:submit value="查询"/>
</s:form>

<br/>

<table id="roomList" border="1 "style="border-collapse:collapse">
<caption>公用房列表</caption>
<tr>
<td></td>
<td>房号</td>
<td>房名</td>
<td>建筑</td>
<td>楼层</td>
<td>面积</td>
<td>租金</td>
<td>说明</td>
</tr>

<tbody id="tbody">
<s:iterator value="%{#request.rooms}"> 
<tr> 
<td><input type="checkbox"  name="roomSelect" value="${roomId}"></td>
<td><s:property value="%{roomId}"/></td>  
<td><s:property value="%{roomName}"/></td>
<td><s:property value="%{roomBuilding}"/></td>  
<td><s:property value="%{roomFloor}"/></td>
<td><s:property value="%{roomArea}"/></td>  
<td><s:property value="%{roomHire}"/></td>
<td><s:property value="%{roomOther}"/></td>  
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