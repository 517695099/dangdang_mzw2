<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/btn.css" />

<style type="text/css">
td {
	padding-top: 8px;
}

#file_upload1 {
	display: none;
}

#file_upload1_label {
	display: inline-block;
	border: 1px solid #aaa;
	width: 120px;
	height: 145px;
	margin-left: 20px;
	text-align: center;
	line-height: 145px;
	cursor: pointer;
}

</style>
</head>

<body
	style="background-color: #f0f9fd;text-align: center">
	<div style="font-size:25px">添加图书</div>
	<hr />
	<div align="center">
		<form action="${pageContext.request.contextPath}/book/b_addBook" method="post" enctype="multipart/form-data" >
			<table>
				<tr>
					<td>名称：</td>
					<td><input type="text" name="book.name" class="el-input__inner" onblur="f1()"><span id="sname"></span></td>
					<td rowspan="14" style="width: 300px">
					<td>页数：</td>
					<td><input type="number" name="book.page_num" class="el-input__inner" onblur="f2()"><span id="spage"></span></td>
				</tr>
				<tr>
					<td>所属分类：</td>
					<td>
						<select name="book.category_id" class="el-select__inner inner2" onblur="f3()">
							<c:forEach items="${requestScope.listcat}" var="lc">
							<option value="${lc.id}">${lc.name}</option>
							</c:forEach>
						</select>
						<span id="scategory"></span>
					</td>
					<td>字数：</td>
					<td><input type="number" name="book.word_num" class="el-input__inner" onblur="f4()"><span id="sword"></span></td>
				</tr>
				
				<tr>
					<td>原价：</td>
					<td><input type="number" name="book.price" class="el-input__inner" onblur="f5()"><span id="sprice"></span></td>
					<td>封面：</td>
					<td rowspan="3">
						<label id="file_upload1_label" for="file_upload1">
							<span id="uploadtip">添加图书封面</span> 
							<img id="uploadimg" src="" alt="" width="118px" height="143px" />
						</label> 
						<input type="file" name="upload" class="" id="file_upload1"	onchange="upload_review()">
					</td>
				</tr>
				
				<tr>
					<td>当当价：</td>
					<td><input type=number name="book.dprice" class="el-input__inner" onblur=""><span id="sdprice"></span></td>
					<td></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="number" name="book.stock" class="el-input__inner" onblur="f7()"><span id="sstock"></span></td>
					<td>销量：</td>
					<td><input type="number" name="book.sale" class="el-input__inner" value="0" readonly="readonly"></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="book.author" class="el-input__inner" onblur="f8()"><span id="sauthor"></span></td>
					<td>编辑推荐：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.editor_recommend"></textarea></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="book.press" class="el-input__inner" onblur="f9()"><span id="spress"></span></td>
					<td></td>
				</tr>
				<tr>
					<td>出版时间：</td>
					<td><input type="date" name="book.press_date" class="el-input__inner" onblur="f10()"><span id="spress_date"></span></td>
					<td>内容简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.content_abstract"></textarea></td>
				</tr>
				<tr>
					<td>版次：</td>
					<td><input type="text" name="book.edition" class="el-input__inner"></td>
					
				</tr>
				<tr>
					<td>印刷时间：</td>
					<td><input type="date" name="book.print_date" class="el-input__inner"></td>
					<td>作者简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.author_abstract"></textarea></td>
				</tr>
				<tr>
					<td>印次：</td>
					<td><input type="text" name="book.impression" class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>ISBN：</td>
					<td><input type="text" name="book.isbn" class="el-input__inner"></td>
					<td>基本目录：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.directory"></textarea></td>
				</tr>
				<tr>
					<td>开本：</td>
					<td><input type="text" name="book.sizes" class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>纸张：</td>
					<td><input type="text" name="book.paper" class="el-input__inner"></td>
					<td>媒体评论：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.media_commentary"></textarea></td>
				</tr>
				<tr>
					<td>包装：</td>
					<td><input type="text" name="book.pack" class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>上架时间：</td>
					
					<td><input type="date" name="book.create_date" class="el-input__inner" pattern="yyyy-MM-dd HH:mm:ss"></td>
				</tr>	
			</table>
			<input type="submit" class="button btn-p" value="提交" onsubmit="return fun()"/>&emsp; 
			<input type="button" class="button btn-p" value="返回上级" onclick="history.go(-1);" />
		</form>
	</div>
	<script type="text/javascript">
		function upload_review() {
			var img = document.getElementById("uploadimg");
			var input = document.getElementById("file_upload1");
			var tip = document.getElementById("uploadtip");			

			var file = input.files.item(0);
			var freader = new FileReader();
			freader.readAsDataURL(file);
			freader.onload = function(e) {
				img.src = e.target.result;
				tip.style.display = "none";
			};
		};
		var f1=function(){
			var span=document.getElementById("sname");
			var input=document.getElementsByName("book.name").item(0);
			if(input.value.length>0){
				span.innerHTML="<font style='color:green'>√</font>";
				return true;
			}else{
				span.innerHTML="<font style='color:red'>书名不能为空×</font>";
				return false;
			}
		};
		var f2=function(){
			var span=document.getElementById("spage");
			var input=document.getElementsByName("book.page_num").item(0);
			if(input.value.length>0){
				span.innerHTML="<font style='color:green'>√</font>";
				return true;
			}else{
				span.innerHTML="<font style='color:red'>页数不能为空×</font>";
				return false;
			}
		};
		var f3=function(){
			var span=document.getElementById("scategory");
			var input=document.getElementsByName("book.category_id").item(0);
			if(input.value.length>0){
				span.innerHTML="<font style='color:green'>√</font>";
				return true;
			}else{
				span.innerHTML="<font style='color:red'>所属类别不能为空×</font>";
				return false;
			}
		};
		var f4=function(){
			var span=document.getElementById("sword");
			var input=document.getElementsByName("book.word_num").item(0);
			if(input.value.length>0){
				span.innerHTML="<font style='color:green'>√</font>";
				return true;
			}else{
				span.innerHTML="<font style='color:red'>字数不能为空×</font>";
				return false;
			}
		};
		var f5=function(){
			var span=document.getElementById("sprice");
			var input=document.getElementsByName("book.price").item(0);
			var input2=document.getElementsByName("book.dprice").item(0);
			if(input.value>0&&input.value>input2.value){
				span.innerHTML="<font style='color:green'>√</font>";
				return true;
			}else{
				span.innerHTML="<font style='color:red'>原价不能为空或小于0×</font>";
				return false;
			}
		};
		function f6(){
			 var upload=$("#file_upload1");
			 if(upload.val().length==0)return false;
			 return true;
		}
		var f7=function(){
			var span=document.getElementById("sstock");
			var input=document.getElementsByName("book.stock").item(0);
			if(input.value.length>0){
				span.innerHTML="<font style='color:green'>√</font>";
				return true;
			}else{
				span.innerHTML="<font style='color:red'>库存不能为空×</font>";
				return false;
			}
		};
		var f8=function(){
			var span=document.getElementById("sauthor");
			var input=document.getElementsByName("book.author").item(0);
			if(input.value.length>0){
				span.innerHTML="<font style='color:green'>√</font>";
				return true;
			}else{
				span.innerHTML="<font style='color:red'>作者不能为空×</font>";
				return false;
			}
		};
		var f9=function(){
			var span=document.getElementById("spress");
			var input=document.getElementsByName("book.press").item(0);
			if(input.value.length>0){
				span.innerHTML="<font style='color:green'>√</font>";
				return true;
			}else{
				span.innerHTML="<font style='color:red'>出版社不能为空×</font>";
				return false;
			}
		};
		var f10=function(){
			var span=document.getElementById("spress_date");
			var input=document.getElementsByName("book.press_date").item(0);
			if(input.value.length>0){
				span.innerHTML="<font style='color:green'>√</font>";
				return true;
			}else{
				span.innerHTML="<font style='color:red'>出版时间不能为空×</font>";
				return false;
			}
		};
		function fun(){
			if(f1()&&f2()&&f3()&&f4()&&f5()&&f7()&&f8()&&f9()&&f10()){
				return true;
			}
			return false;
		};
	</script>
</body>
</html>
