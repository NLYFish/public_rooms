<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告管理</title>

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
<p>公告管理</p>
</div>

<div style="position:relative;top:10px">

<s:form action="uploadNotice" method="post" enctype="multipart/form-data">   
<input type="file" name="file"/>
<input type="submit" value="上传"/>
</s:form>

<br/>

<s:textarea name="noticeText" id="noticeText" style="height:102px;width:580px;"></s:textarea>

<br/><br/>

<s:form name="noticeDeleteForm" id="noticeDeleteForm" action="deleteNotice" method="post">

<table id="noticeList" border="1 "style="border-collapse:collapse;width:580px">
<caption>公告列表</caption>
<tr>
<td></td>
<td>公告</td>
</tr>

<tbody id="tbody">
<s:iterator value="%{#request.notices}" id="notice"> 
<tr> 
<td><input type="checkbox"  name="noticeSelect" value="${notice}"/></td>
<td><a href="javascript:void(0)" onclick='noticeText("${notice}")'>${notice}</a>
    <a href="downloadNotice.action?downloadFileName=${notice}">下载</a></td>  
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

<s:submit value="删除"/>

</s:form>


</div>

</div>

</div>

</body>
<script type="text/javascript" src="js/pageScript.js"></script>
<script type="text/javascript" src="js/noticeScript.js"></script>
</html>
