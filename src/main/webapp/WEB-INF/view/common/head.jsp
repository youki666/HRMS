<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Head Page</title>
</head>
<body>
    <!-- 导航条 -->
<div class="hrms_brand_nav">
    <nav class="navbar navbar-inverse navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#hrms-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#" id="company_logo">XXX公司LOGO</a>
            </div>

            <div class="collapse navbar-collapse" id="hrms-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="#">公司介绍 <span class="sr-only">(current)</span>  </a>
                    </li>
                    <li><a href="#">人力资源部</a></li>
                    <li><a href="#">请假申请</a></li>
                    <li><a href="#">报销申请</a></li>
                    <li><a href="#">出勤记录</a></li>
                </ul>

                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="站内搜索">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>

                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">账号管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu nav nav-pills nav-stacked">
                            <li class="active"><a href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 修改信息</a></li>
                            <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 头像更换</a></li>
                            <li class="hrms_logout"><a href="#"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> 账号退出</a></li>
                        </ul>
                    </li>
                </ul><!-- /.nav navbar-nav navbar-right -->
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div><!-- /.hrms_brand_nav -->
<script>
//主页面
    $("#company_logo").click(function(){
    	$(this).attr("href","/HRMS/main")
    })
    
    //账号退出
    $(".hrms_logout").click(function () {
        window.location.href = "/HRMS/logout";
    });
</script>
</body>
</html>