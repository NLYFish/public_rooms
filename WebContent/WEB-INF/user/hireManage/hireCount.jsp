<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>财务统计</title>

</head>
<body>
<div><a href="user">返回</a></div>
<div><a href="hireManage">公用房租金管理</a></div>
<h1>财务统计</h1>


<s:form name="hireCountForm" id="hireCountForm" action="hireCount" method="get">
房号<s:textfield name="hireCountForm.roomId" size="10"/>
房名<s:textfield name="hireCountForm.roomName" size="10"/>
类型<s:select name="hireCountForm.type" list="#{'0':'出租收入','1':'维修支出'}" headerKey="" headerValue="全部"/>
年<s:textfield name="hireCountForm.year" size="5"/>
月<s:textfield name="hireCountForm.month" size="5"/>
<s:submit value="查询"/>
</s:form>

<br/>

<table border="1 "style="border-collapse:collapse">
<tr>
<td>出租收入</td>
<td>维修支出</td>
<td>合计</td>
</tr>

<tr>
<td>${requestScope.income}</td>
<td>${requestScope.outcome}</td>
<td>${requestScope.sum}</td>
</tr>
</table>


<br/>

<table id="hireCountList" border="1 "style="border-collapse:collapse">
<caption>财务统计列表</caption>

<tr>
<td>房号</td>
<td>房名</td>
<td>日期</td>
<td>出租收入</td>
<td>费用支出</td>
</tr>

<tbody id="tbody">

<s:iterator value="%{#request.rentHires}"> 
<tr> 
<td><s:property value="%{roomId}"/></td>  
<td><s:property value="%{roomName}"/></td>
<td><s:date name="%{rentEndDate}" format="yyyy-MM-dd"/></td>  
<td><s:property value="%{rentHires}"/></td>
<td></td>  
</tr>
</s:iterator> 

<s:iterator value="%{#request.repairHires}"> 
<tr> 
<td><s:property value="%{roomId}"/></td>  
<td><s:property value="%{roomName}"/></td>
<td><s:date name="%{repairDate}" format="yyyy-MM-dd"/></td>  
<td></td>
<td><s:property value="%{repairHire}"/></td>  
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