<%@page pageEncoding="UTF-8" contentType="text/html; utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="carousel" data-ride="carousel" data-interval="2000" id="cal">
                <!--控制按钮-->
                <ol class="carousel-indicators">
                    <li data-target="#cal" data-slide-to="0"></li>
                    <li data-target="#cal" data-slide-to="1" class="active"></li>
                    <li data-target="#cal" data-slide-to="2"></li>
                    <li data-target="#cal" data-slide-to="3"></li>
                </ol>

                <div class="carousel-inner">
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/img/car05.jpg" alt="" width="100%">
                        <div class="carousel-caption">
                            宝马
                        </div>
                    </div>
                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/img/car03.jpg" alt="" width="100%">
                        <div class="carousel-caption">
                            奔驰
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/img/car20.jpg" alt="" width="100%">
                        <div class="carousel-caption">
                            兰博基尼
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/img/car06.jpg" alt="" width="100%">
                        <div class="carousel-caption">
                            宾利
                        </div>
                    </div>
                </div>
                <!--左右控制按钮-->
                <a href="#cal" class="carousel-control left" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a href="#cal" class="carousel-control right" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="modal" id="md" style="background-repeat: no-repeat;background-size: cover;">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content" style="background-color: lightgreen;box-shadow: 10px 15px 15px silver;height: 20%;margin-top: 60%">
                            <div class="modal-header" style="font-size: 20px;text-align: center">
                                请登录
                            </div>
                            <div class="modal-body">
                                <form action="">
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-success" type="button" id="btn_login" style="width: 100%;margin-bottom:20px ">登录  <span class="glyphicon glyphicon-ok"></span></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>
    $(function () {
        var flag=true;
        // 初始化模态框
        $('#md').modal({
            backdrop:'static'
        })
        $("#btn_login").click(function () {
            var username=$("#username").val();
            var password=$("#password").val();
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/user/login.do",
                data:"username="+username+"&password="+password,
                success:function (res) {
                    if(res.length>6){
                        alert(res);
                        flag=false;
                    }else{
                        alert(res);
                        flag=true;
                        location.href="${pageContext.request.contextPath}/dept.jsp";
                    }
                }
            })
        })
    })
</script>
</body>
</html>