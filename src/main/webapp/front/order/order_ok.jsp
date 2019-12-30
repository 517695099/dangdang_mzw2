<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
				onload = function() {
					setInterval(go, 1000);
				};
				var x = 5; //利用了全局变量来执行  
				function go() {
					x--;
					if (x > 0) {
						document.getElementById("sp").innerHTML = x; //每次设置的x的值都不一样了。  
					} else {
						location.href = '${pageContext.request.contextPath}/frontbook/fb_main';
					}
				}
</script>
	</head>
	<body>
		<%@include file="/front/common/head1.jsp"%>
		<div class="login_step">
			生成订单步骤: 1.确认订单 > 2.填写送货地址 >
			<span class="red_bold">3.订单成功</span>
		</div>


		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<img src="${pageContext.request.contextPath}/front/images/order_success.jpg" />
				</div>
				<h5>
					订单已经生成
				</h5>
				<h6>
					您刚刚生成的订单号是：<font color="red"><strong>${sessionScope.order_no}</strong></font>，
					金额总计<font color="red"><strong>${sessionScope.totalPrice}</strong></font>
				</h6>

				<ul>
					<li class="nobj"  >
						您现在可以：还有<font color="red"><strong id="sp">5</strong></font>秒,回到首页！！！
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/frontbook/fb_main>继续浏览并选购商品</a>
					</li>
				</ul>
			</div>
		</div>

		<%@include file="/front/common/foot1.jsp"%>
	</body>
</html>

