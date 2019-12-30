<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
					$(function(){
						    $("#address").change(function(){  
				    		var p1=$(this).children("option:selected").val();
				    		window.location.href="DangDang_mzw2/cart/ca_oldAddress?address.id="+p1;
   						 }) ; 
   						 function f1(){
   						 		var name=$("#receiveName").val();
   						 		var span=$("#namespan");
   						 		console.log(name);
   						 		console.log(span);
   						 		if(name.length==0){
   						 			span.html("<font color='red'>收件人姓名不能为空!</font>");
   						 			return false;
   						 		}else{
   						 			span.html("<font color='green'>格式正确√</font>");
   						 			return true;
   						 		}
   						 }
   						  function f2(){
   						 		var address=$("#fullAddress").val();
   						 		var span=$("#addressspan");
   						 		if(name.length==0){
   						 			span.html("<font color='red'>地址不能为空!</font>");
   						 			return false;
   						 		}else{
   						 			span.html("<font color='green'>格式正确√</font>");
   						 			return true;
   						 		}
   						 }
   						  function f3(){
   						 		var name=$("#postalCode").val();
   						 		var span=$("#postspan");
   						 		if(name.length==6){
   						 			span.html("<font color='green'>格式正确√</font>");
   						 			return true;
   						 		}else{
   						 			span.html("<font color='red'>格式错误×</font>");
   						 			return false;
   						 		}
   						 }
   						  function f4(){
   						 		var name=$("#phone").val();
   						 		var span=$("#phonespan");
   						 		if(name.length==11){
   						 			span.html("<font color='green'>格式正确√</font>");
   						 			return true;
   						 		}else{
   						 			span.html("<font color='red'>格式错误×</font>");
   						 			return false;
   						 		}
   						 }
   						 function fun(){
   						 	return f1()&&f2()&&f3()&&f4();
   						 }
   						 
					});		
		</script>
	</head>
	<body>
		<%@include file="/front/common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select id="address"  name="address.id" >
						<option value="">请填写地址</option>
					<c:forEach items="${addresses}" var="a">
					<c:if test="${address.name==a.name}">
							<option value="${a.id}" selected="selected">
							${a.local}
						</option>
					</c:if>
					<c:if test="${address.name!=a.name }">
							<option value="${a.id}">
							${a.local}
						</option>
					</c:if>
						
					</c:forEach>
				</select>
			</p>
			<form name="ctl00" method="post" action="${pageContext.request.contextPath}/cart/ca_placeOrder" id="f"  onsubmit="return fun()">
				<input type="hidden" name="address.id" id="addressId"  value="${address.id}"/>
				<input type="hidden" name="address.user_id" id="addressId"  value="${address.user_id}"/>
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="address.name" id="receiveName"  value="${address.name}" onblur="f1()"/><span id="namespan"></span>
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="address.local" class="text_input" id="fullAddress"  value="${address.local}" onblur="f2()"/><span id="addressspan"></span>
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码  
						</td>
						<td>
							<input type="text" class="text_input" name="address.zip_code" id="postalCode" value="${address.zip_code }"  onblur="f3()"/><span id="postspan"></span>
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" class="text_input" name="address.phone" id="phone"  value="${address.phone}" onblur="f4()"/><span id="phonespan"></span>
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
							</div>
						</td>
					</tr>		
				</table>

				<div class="login_in">
					<a href="${pageContext.request.contextPath}/front/order/order_info.jsp">
						<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="取消"  onclick="history.go(-1)"/>
					</a>			
				<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="/front/common/foot1.jsp"%>
	</body>
</html>

