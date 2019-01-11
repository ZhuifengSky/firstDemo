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
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
</head>
<body>
   <h3>订单确认</h3>
   <form action="" method="post" id="payForm">
     <table>
     	<tr>
     	   <td align="left">订单号:</td>
     	   <td>${order.orderCode}</td>
     	</tr>
     	<tr>
     	   <td align="left">商品名称:</td>
     	   <td>${order.goodsName}</td>
     	</tr>
     	<tr>
     	   <td align="left">交易金额:</td>
     	   <td>${order.amount}</td>
     	</tr>
     	<tr>
     	   <td align="left">交易时间:</td>
     	   <td>${order.tradeTime}</td>
     	</tr>
     	<tr>
     	   <td align="left">支付方式:</td>
     	   <td>支付宝<input type="radio" name="payType" value="aliPay">&nbsp;&nbsp;
     	               微信支付<input type="radio" name="payType" value="weChatPay"></td>
     	</tr>
     	<tr>
     	   <td colspan="2"><input type="button" value="确定支付" id="btnSubmit"></td>
     	</tr>
     </table>
   </form>   
</body>
<script type="text/javascript">
$(function(){
	$("#btnSubmit").click(function(){
	    var val=$('input:radio[name="payType"]:checked').val();
	    if(val==null){
	        alert("请选择支付方式!");
	        return false;
	    }
	    else{
	        if (val=="aliPay") {
	        	$("#payForm").attr("action", "aliPay/aliWapPay.do");
	        	$("#payForm").submit();
			}else if (val=="weChatPay") {
				alert("暂时不支持微信支付!");
			}
	    }
	});
});
</script>
</html>