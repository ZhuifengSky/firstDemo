<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>下单页</h3>
   <form action="order/buyOrder.do" method="post">
     <table>
     	<tr>
     	   <td>用户ID</td>
     	   <td><input type="text" name="userId"></td>
     	</tr>
     	<tr>
     	   <td>商品ID</td>
     	   <td><input type="text" name="goodsId"></td>
     	</tr>
     	<tr>
     	   <td>付款金额</td>
     	   <td><input type="text" name="amount"></td>
     	</tr>
     	<tr>
     	   <td colspan="2"><input type="submit" value="提交"></td>
     	</tr>
     </table>
   </form>   
</body>
</html>