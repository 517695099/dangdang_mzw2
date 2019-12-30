<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
		
	</head>
	<body>
		<%@include file="/front/common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="${pageContext.request.contextPath}/frontuser/fu_register" id="f"  onsubmit="return fun()" >
				<h2>
					以下均为必填项&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="user.email"  type="text" id="txtEmail" class="text_input"  onblur="f1()"  value=""/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
								<span id="emailInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.nickname"  type="text" id="txtNickName" class="text_input"  onblur="f2()" value=""/>
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.password" type="password" id="txtPassword" class="text_input"  onblur="f3()" value=""/>
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass" class="text_input" onblur="f4()" value=""/>		
							<div class="text_left" id="repeatPassValidMsg">
								<span id="password1Info"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath}/frontuser/getCode" />
							<input name="scode" type="text" id="txtVerifyCode" class="yzm_input" />
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									<a href="#" id="change" >看不清楚？换个图片</a>
									<br/>
									<span id="codeInfo"><font color="red">${message}</font></span>
								</p>
							</div>
						</td>
					</tr>
				</table>
				<div class="login_in">
					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"   />
				</div>
			</form>
		</div>
		<%@include file="/front/common/foot1.jsp"%>
	</body>
</html>
<script type="text/javascript">			
				$("#imgVcode").click(function(){
						$("#imgVcode").prop("src","${pageContext.request.contextPath}/frontuser/getCode?time="+new Date());
				});		
				var re=/^\w+@[a-z0-9]+\.[a-z]{2,4}$/;
					//邮箱验证
		         		function  f1(){
		         					var oTxt=$("#txtEmail");
		         					var span=$("#emailInfo");
		         					if(re.test(oTxt.val())) {
		           			 			 span.html("<font style='color:green'>邮箱格式正确√</font>");
		           			 			 return true;
		       						}else{
		             					 span.html("<font style='color:red'>邮箱格式书写错误×</font>");
		             					 return false;
		        		 			}  	
		        		 };	
		   				//昵称验证
		        		 function f2(){
		        		 		var nickname=$("#txtNickName");
		        		 		var username=nickname.val();
		        		 		var span=$("#nameInfo");
		        		 		if(/^[\u4E00-\u9FA5a-z0-9]{4,20}$/gi.test(username) && username.length<=20){
		        		 				span.html("<font color='green'>格式正确√</font>");
		        		 				return true;
		        		 		}else{
		        		 				span.html("<font color='red'>格式错误×</font>");
		        		 				return false;
		        		 		}
		        		 }
		        		 var rp=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
		        		 function f3(){
		        		 		var password=$("#txtPassword").val();
		        		 		var span=$("#passwordInfo");
		        		 		if(rp.test(password)){
		        		 				span.html("<font color='green'>格式正确√</font>");
		        		 				return true;
		        		 		}else{
		        		 				span.html("<font color='red'>格式错误×</font>");
		        		 				return false;
		        		 		}
		        		 }
		        		 function f4(){
		        		 		var password1=$("#txtRepeatPass").val();
		        		 		var password=$("#txtPassword").val();
		        		 		var span=$("#password1Info");
		        		 		if(password1==password){
		        		 			span.html("<font color='green'>两次密码输入一致√</font>");
		        		 			return true;
		        		 		}else{
		        		 			span.html("<font color='red'>两次密码输入不一致×</font>");
		        		 			return false;
		        		 		}
		        		 }
		        		 function fun(){ 
		        		 	if(f1()&&f2()&&f3()&&f4()){
		        		 	        return true;
		        		 	}
		        		 	return false;
		        		 };		                                                                                                                                                 ;
		</script>