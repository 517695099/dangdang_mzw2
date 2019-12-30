<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>index.html</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/btn.css" />
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">

    
  </head>
  
  <body style="background-color: #f0f9fd;text-align: center">
  	<div style="text-align: center;font-size: 18px">添加商品类别</div><hr/>
  	<form action="${pageContext.request.contextPath}/category/query_addFirst" method="post">
  				<span style="color:red;font-size: 21px;margin-left: 45px;">${requestScope.message}</span>
  		类别名:<input class="el-input__inner" type="text" name="category.name" id="fname" onblur="f1()"/><span id="fnameMsg"></span><br/><br/>
  		<input class="button btn-p" type="submit" value="提交" onsubmit="return fun()"/>&emsp;
		<div class="button btn-p"  onclick="history.go(-1);">返回上级</div>
  	</form>
    	
  </body>
</html>
<script type="text/javascript">
    	function f1(){
			var span=document.getElementById("fnameMsg");
			var input=document.getElementById("fname");
			if(input.value.length>0){
				span.innerHTML="<font style='color:green'>√</font>";
				return true;
			}else{
				span.innerHTML="<font style='color:red'>类别名不能为空×</font>";
				return false;
			}
		};
		function fun(){
			if(f1())return true;
			return false;
		};
    </script>