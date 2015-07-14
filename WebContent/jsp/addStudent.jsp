<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'login1-User.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	function regester(ope) {
		if (ope == 'add') {
			$("#form").attr("action", "user/addUser.do");
			$("#form").submit();
		} else {
			$("#form").attr("action", "user/updateUser.do");
			$("#form").submit();
		}
	}
</script>
</head>

<body>
	<c:if test="${s.id ne null}">
		<h2>学生编辑</h2>
	</c:if>
	<c:if test="${s.id eq null}">
		<h2>学生新增</h2>
	</c:if>
	<form method="post" id="form">
		<table>
			<tr>
				<td>学生姓名:</td>
				<td><input type="text" name="studentName"
					value="${s.studentName}"> <c:if test="${s.id ne null}">
						<input type="hidden" value="${s.id}" name="id">
					</c:if></td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td>
				<input type="text" name="age" value="${s.age}">
				</td>
			</tr>
			<tr>
				<c:if test="${s.id ne null}">
					<td><input type="button" value="修改" onclick="regester('edit')"></td>
				</c:if>

				<c:if test="${s.id eq null}">
					<td><input type="button" value="新增" onclick="regester('add')"></td>
				</c:if>
					
			</tr>
		</table>
	</form>
</body>
</html>
