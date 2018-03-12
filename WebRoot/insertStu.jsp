<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'insertStu.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</head>

<body>
	<form action="/insertStu.action" method="post">
		<table>
			<caption>插入用户记录</caption>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="stuname" /></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="stuage" /></td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td><input id="d121" type="text" name="stubirth"
					onclick="WdatePicker({isShowWeek:true})" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="插入记录" /></td>
				<td><a href="getStudent.action">返回</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
