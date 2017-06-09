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
<div style="width:750px;height:30px;position:absolute;top:10px;border-bottom:1px solid #000">
<a style="position:relative;left:700px" href="">首页</a>
</div>

<div style="position:absolute;top:35px;">

<div style="float:left;position:relative;">
<h1>公用房管理系统</h1>
</div>

<div style="float:left;position:relative;top:21px;left:15px">
<p>工作人员  ${session.id}</p>
</div>

</div>

<div style="position:relative;top:110px">

<div style="width:160px;height:400px;float:left;position:relative;border-right:1px solid #000">
<a href="rentManage">公用房分配/租赁管理</a><br/>
<a href="repairManage">公用房维修管理</a><br/>
<a href="hireCount">公用房财务管理</a><br/>
<a href="getMessageDo">公用房通知管理</a><br/>
<a href="getNoticeDo">公用房公告管理</a><br/>
<a href="updateInformationPage">个人信息</a><br/>
<a href="updatePasswordPage">修改密码</a><br/>
<a href="exit">退出</a>
</div>

<div style="float:left;position:relative;left:5px">

<div style="width:585px;height:30px;position:relative;border-bottom:1px solid #000">
<p>财务统计</p>
</div>

<div style="position:relative;top:10px">

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

<br/><br/>
<a href="hireManage">公用房租金管理</a>
</div>

</div>

</div>

</body>
<script type="text/javascript" src="js/pageScript.js"></script>
</html>
