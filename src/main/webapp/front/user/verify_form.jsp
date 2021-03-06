<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
				function f1(e){
						var  validatecode=$("#validatecode").val();
						if(e==validatecode){
							$("#errorMsg").html("<font color='green'>激活码输入正确</font>");
							return true;
						}else{
								$("#errorMsg").html("<font color='red'>激活码输入错误</font>");
								return false;
						}			
				}			
				function fun(e){
				console.log(f1(e));
					return f1(e);
				}
		</script>
	</head>
	<body>
		<%@include file="/front/common/head1.jsp"%>

		<div class="login_step">
			注册步骤: 1.填写信息 >
			<span class="red_bold">2.验证邮箱</span> > 3.注册成功
		</div>
		<form action="${pageContext.request.contextPath}/frontuser/fu_updateCode" method="post"  onsubmit="return fun('${num}')">
			<div class="validate_email">
				<h2>
					感谢您注册当当网！现在请按以下步骤完成您的注册!
				</h2>
				<div class="look_email">
					<h4>
						第一步：查看您的电子邮箱
					</h4>
					<div class="mess reduce_h">
						我们给您发送了验证邮件，邮件地址为：
						<span class="red"><span id="lblEmail">张三</span>
						</span>
						<span class="t1"> 
						请登录您的邮箱收信。
					</div>
					<h4>
						第二步：输入激活码<font color="red" id="num">${num}</font>
					</h4>
					<div class="mess">
						<span class="write_in">输入您收到邮件中的激活码：</span>
						<input name="scode" type="text" id="validatecode" class="yzm_text"  onblur="f1('${num}')"/>
						<input class="finsh" type="submit" value="完 成" id="Button1"   />
						<span id="errorMsg" class="no_right"></span>
					</div>
				</div>
			</div>
		</form>
		<%@include file="/front/common/foot1.jsp"%>
	</body>
</html>

