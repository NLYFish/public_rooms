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

<div><a href="user">返回</a></div>
<h1>公告管理</h1>

<div>公告</div>

<s:textarea name="noticeText" id="noticeText" style="height:150px;width:500px;"></s:textarea>

<br/>

<s:form name="noticeDeleteForm" id="noticeDeleteForm" action="deleteNotice" method="post">

<table id="noticeList" border="1 "style="border-collapse:collapse">
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

<br/>

<s:submit value="删除"/>
<s:form action="uploadNotice" method="post" enctype="multipart/form-data">   
<input type="file" name="file"/>
<input type="submit" value="上传"/>
</s:form>
 

</s:form>


</body>
</html>
<script type="text/javascript" src="js/pageScript.js"></script>
<script type="text/javascript" src="js/noticeScript.js"></script>