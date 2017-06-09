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

<div style="width:160px;height:315px;float:left;position:relative;border-right:1px solid #000">
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
<p>分配/租赁记录</p>
</div>

<div style="position:relative;top:10px">

<s:form name="rentLogsForm" id="rentLogsForm" action="rentLogs" method="get">
房号<s:textfield name="rentLogsForm.roomId" size="10"/>
房名<s:textfield name="rentLogsForm.roomName" size="10"/>
类型<s:select name="rentLogsForm.type" list="#{'0':'分配','1':'租赁'}" headerKey="" headerValue="全部"/><br/>
所属<s:textfield name="rentLogsForm.renter" size="10"/>
姓名<s:textfield name="rentLogsForm.renterName" size="10"/>
身份证<s:textfield name="rentLogsForm.renterId" size="10"/>
年月<s:textfield name="rentLogsForm.rentDate" size="10"/>
<s:submit value="查询"/>

</s:form>

<br/>

<s:form name="rentLogsDeleteForm" id="rentLogsDeleteForm" action="deleteRentLogs" method="post">

<table id="rentLogs" border="1 "style="border-collapse:collapse">
<caption>分配/租赁记录</caption>
<tr>
<td></td>
<td>房号</td>
<td>房名</td>
<td>类型</td>
<td>所属</td>
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
<td><input type="checkbox"  name="rentLogsSelect" value="${no}"></td>
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

<br/><br/>

<s:submit value="删除"/> 
<a href="rentManage">返回</a>

</s:form>

</div>

</div>

</div>

</body>
<script type="text/javascript" src="js/pageScript.js"></script>
</html>
