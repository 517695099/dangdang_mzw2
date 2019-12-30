<%@page contentType="text/html;charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		&nbsp;
		<!-- 头部开始 -->
		<%@include file="/front/common/head.jsp"%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">
			<a href="#" target="_blank"><img
					src="${pageContext.request.contextPath}/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<%@include file="category.jsp" %>
			</div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--推荐图书开始-->
				<div class=second_c_border1 id="recommend">
					<%@include file="recommend.jsp" %>
				</div>

				<!--推荐图书结束-->
  					
				<!--热销图书开始-->
				<div class="book_c_border2" id="hot">
					<%@include file="hot.jsp" %>
				</div>
				<!--热销图书结束-->

				<!--最新上架图书开始-->
				<div class="book_c_border2" id="new">
					<%@include file="new.jsp" %>
				</div>

				<!--最新上架图书结束-->

				<div class="clear">
				</div>
			</div>
			<!--中栏结束-->



			<!--右栏开始-->
			<div class="book_right">
				<div class="book_r_border2" id="__XinShuReMai">
					<div class="book_r_b2_1x" id="new_bang">
						<div id="NewProduct_1_o_t" onmouseover="">
							<%@include file="hotBoard.jsp" %>	
						</div>
					</div>
				</div>
			</div>
			<!--右栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="/front/common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
				$(function(){
			  		$(".book-cover").mouseover(function(e){
			  			//alert("鼠标移入");
			  			//1.获取原图片大小
			  			var width=this.width*2;
			  			var height=this.height*2;
			  			//2.获取鼠标的位置
			  			var x=e.pageX+20;
			  			var y=e.pageY+20;
			  			//3.创建一个div
			  			var div=$("<div id='bigDiv'/>").css({
			  			                                  "position":"absolute",
			  			                                  "display":"none",
			  			                                  "width":width,
			  			                                  "height":height,
			  			                                  "left":x,
			  			                                  "top":y,
			  			                                  "border":"2px solid green"
			  			                               });
			  			//4.创建一个img
			  			var img=$("<img/>").css({
			  				"width":width,
			  				"height":height
			  			}).attr({
			  				"src":this.src
			  			});
			  			//5.将img放入div中
			  			div.append(img);
			  			//6.将div放入body中
			  			$("body").append(div);
			  			div.show(1000);
			  		}).mousemove(function(e){
			  			//alert("鼠标移动");
			  			//1.先获取鼠标的位置
			  			var x=e.pageX+20;
			  			var y=e.pageY+20;
			  			//2.将鼠标位置赋值给div
			  			$("#bigDiv").css({
			  			    "left":x,
			  			    "top":y
			  			});
			  		}).mouseout(function(e){
			  			//alert("鼠标移出");
			  			$("#bigDiv").remove();
			  		});
  	});
 </script>