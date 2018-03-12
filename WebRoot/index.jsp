<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="../js/jquery-2.1.0.js"></script>
<style type="text/css">
.tab tr th,td {
	padding: 10px;
	border-collapse: collapse;
	border-spacing: 0px;
	margin: 0px;
	border: 1px solid red;
}
</style>
</head>

<body>
	<table class="tab">
		<caption>学生信息管理</caption>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>出生日期</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.stuList }" var="stu">
			<tr>
				<td>${stu.stuid }</td>
				<td>${stu.stuname }</td>
				<td>${stu.stuage }</td>
				<td><fmt:formatDate value="${stu.stubirth }"
						pattern="yyyy-MM-dd" /></td>
				<td><a href="deleteStu.action?stuid=${stu.stuid }">删除</a>||<a
					href="updateStu.action?stuid=${stu.stuid }">修改</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="insertStu.jsp">插入记录</a>
	<!-- <button onclick="javascript:insertStu()">插入</button> -->
	<!-- <script type="text/javascript">
		function insertStu(){
			alert("开始执行插入");
			$.post("insertStu.action",{},function(obj){
				
			},"text");
		}
	</script> -->
</body>
</html>
