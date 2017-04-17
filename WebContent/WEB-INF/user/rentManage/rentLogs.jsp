<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分配/租赁记录</title>
</head>
<body>

<div><a href="rentManage">返回</a></div>
<h1>分配/租赁记录</h1>

<s:form name="rentLogsForm" id="rentLogsForm" action="rentLogs" method="get">
房号<s:textfield name="rentLogsForm.roomId" size="10"/>
房名<s:textfield name="rentLogsForm.roomName" size="10"/>
类型<s:select name="rentLogsForm.type" list="#{'0':'分配','1':'租赁'}" headerKey="" headerValue="全部"/><br/>
部门<s:textfield name="rentLogsForm.renter" size="10"/>
姓名<s:textfield name="rentLogsForm.renterName" size="10"/>
身份证<s:textfield name="rentLogsForm.renterId" size="10"/>
时间<s:textfield name="rentLogsForm.rentDate" size="10"/>
<s:submit value="查询"/>
</s:form>


<table id="rentLogs" border="1 "style="border-collapse:collapse">
<caption>分配/租赁记录</caption>
<tr>
<td>房号</td>
<td>房名</td>
<td>类型</td>
<td>部门</td>
<td>负责人</td>
<td>身份证/职工号</td>
<td>电话</td>
<td>开始日期</td>
<td>结束日期</td>
<td>天数</td>
<td>租金</td>
<td>租金/天</td>
<td>说明</td>
</tr>

<tbody id="tbody">
<s:iterator value="%{#request.rentLs}"> 
<tr> 
<td><s:property value="%{roomId}"/></td>  
<td><s:property value="%{roomName}"/></td>
<td><s:property value="%{type}"/></td>  
<td><s:property value="%{renter}"/></td>  
<td><s:property value="%{renterName}"/></td>  
<td><s:property value="%{renterId}"/></td>
<td><s:property value="%{renterPhone}"/></td>  
<td><s:date name="%{rentStartDate}" format="yyyy-MM-dd"/></td>
<td><s:date name="%{rentEndDate}" format="yyyy-MM-dd"/></td>
<td><s:property value="%{rentDay}"/></td>  
<td><s:property value="%{rentHires}"/></td>  
<td><s:property value="%{rentHire}"/></td>  
<td><s:property value="%{rentOther}"/></td>   
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