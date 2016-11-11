<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta property="qc:admins" content="0070127047763456375730216756345347230747716153526230" />
    <title>My JSP 'login1-User.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function regester(){
			window.location.href = "jsp/index.jsp"
		}
	</script>
  </head>
  
  <body>
  	<s:if test="#request.userName != null">
  	<h2><s:property value="#request.userName"/>注册成功！</h2>
  	</s:if>
  	
  	<form action="user/login.do" method="post">
  	<table>
  		<tr>
  			<td>用户名:</td>
  			<td><input type="text" name="userName"></td>
  		</tr>
  		<tr>
  			<td>密码:</td>
  			<td><input type="password" name="password"></td>
  		</tr>
  		<tr>
  			<td><input type="submit" value="登陆" ></td>
  			<td><input type="button" value="注册" onclick="regester()" ></td>
  		</tr>
  		<tr>
  		    <td colspan="2">使用第三方登录</td>
  		</tr>
  		<tr>
  		    <td><a href="login.do"><img alt="QQ登录" src="image/bt_white_76X24.png"></a></td>
  			<td><a href="https://open.weixin.qq.com/connect/qrconnect?appid=wx0f85bfa3ae1184d9&redirect_uri=http://www.socrazy.com/sso/thirdLogin/weChat/callback&response_type=code&scope=snsapi_base#wechat_redirect">微信登录</a></td>
  		</tr>
  	</table>
  	</form>
  	<script src="http://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js"></script>
  </body>
</html>
