<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>维修管理</title>

</head>
<body>
<div><a href="user">返回</a></div>
<h1>维修管理</h1>

<s:form name="repairQueryForm" id="repairQueryForm" action="repairManage" method="get">
房号<s:textfield name="repairQueryForm.roomId" size="10"/>
房名<s:textfield name="repairQueryForm.roomName" size="10"/>
负责人<s:textfield name="repairQueryForm.repairer" size="10"/>
年<s:textfield name="repairQueryForm.repairYear" size="5"/>
月<s:textfield name="repairQueryForm.repairMonth" size="5"/>
<s:submit value="查询"/><input type="button" value="添加" onclick="location.href='addRepair'"/>
</s:form>

<br/>

<s:form name="repairDeleteForm" id="repairDeleteForm" action="deleteRepair" method="post">


<table id="repairList" border="1 "style="border-collapse:collapse">
<caption>维修列表</caption>
<tr>
<td></td>
<td>房号</td>
<td>房名</td>
<td>负责人</td>
<td>电话</td>
<td>日期</td>
<td>费用</td>
<td>说明</td>
</tr>

<tbody id="tbody">
<s:iterator value="%{#request.repairs}"> 
<tr> 
<td><input type="checkbox"  name="repairSelect" value="${no}"></td>
<td><s:property value="%{roomId}"/></td>  
<td><s:property value="%{roomName}"/></td>
<td><s:property value="%{repairer}"/></td>  
<td><s:property value="%{repairerPhone}"/></td>
<td><s:date name="%{repairDate}" format="yyyy-MM-dd"/></td>  
<td><s:property value="%{repairHire}"/></td>
<td><s:property value="%{repairOther}"/></td>  
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

</s:form>



</body>
</html>
<script type="text/javascript" src="js/pageScript.js"></script>