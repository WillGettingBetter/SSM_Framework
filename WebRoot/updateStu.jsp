<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'updateStu.jsp' starting page</title>

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
	<h1>修改学生</h1>
	<form action="doUpdateStu.action" method="post">
		<input type="hidden" name="stuid"
			value="${requestScope.stuInfo.stuid }" /> 
		姓名：<input type="text" name="stuname" value="${requestScope.stuInfo.stuname }" /> <br />
		年龄：<input type="text" name="stuage" value="${requestScope.stuInfo.stuage }" /> <br /> 
		生日：<input id="d121" type="text" name="stubirth"
			value="<fmt:formatDate value='${requestScope.stuInfo.stubirth }'
						pattern='yyyy-MM-dd' />"
			onclick="WdatePicker({isShowWeek:true})" /> <br /> 
	 	<input type="submit" value="修改学生" />
	</form>
	<a href="getStudent.action">返回</a>
</body>
</html>
