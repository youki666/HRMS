<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工管理页面</title>
     <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<div class="hrms_container">
    <!-- 导航条 -->
    <%@ include file="./common/head.jsp"%>

    <!-- 中间部分（包括左边栏和员工/部门表单显示部分） -->
    <div class="hrms_body" style="position:relative; top:-15px;">

        <!-- 左侧栏 -->
        <%@ include file="./common/leftsidebar.jsp"%>

        <!-- 中间员工表格信息展示内容 -->
        <div class="emp_info col-sm-10">

            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li><a href="#">员工管理</a></li>
                        <li class="active">员工信息</li>
                    </ol>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="emp_table">
                    <thead>
                    <th>员工编号</th>
                    <th>员工姓名</th>
                    <th>邮箱</th>
                    <th>性别</th>
                    <th>部门</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${employees}" var="emp">
                            <tr>
                                <td>${emp.empId}</td>
                                <td>${emp.empName}</td>
                                <td>${emp.empEmail}</td>
                                <td>${emp.gender == "F"? "女": "男"}</td>
                                <td>${emp.department.deptName}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary emp_edit_btn" data-toggle="modal" data-target=".emp-update-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-danger emp_delete_btn">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="panel-body">
                    <div class="table_items">
                        当前第<span class="badge">${curPage}</span>页，共有<span class="badge">${totalPages}</span>页，总记录数<span class="badge">${totalItems}</span>条。
                    </div>
                    <nav aria-label="Page navigation" class="pull-right">
                        <ul class="pagination">
                            <li><a href="/HRMS/emp/getEmpList?pageNo=1">首页</a></li>
                            <c:if test="${curPage==1}">
                                <li>
                                    <a href="#" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${curPage!=1}">
                                <li>
                                    <a href="#" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${totalPages<5?totalPages:5}" step="1" var="itemPage">
                                <c:if test="${curPage == itemPage}">
                                    <li class="active"><a href="/HRMS/emp/getEmpList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                                <c:if test="${curPage != itemPage}">
                                    <li><a href="/HRMS/emp/getEmpList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                            </c:forEach>

                            <c:if test="${curPage==totalPages}">
                                <li class="disabled" class="nextPage">
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${curPage!=totalPages}">
                                <li>
                                    <a href="#" aria-label="Next" class="nextPage">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <li><a href="/HRMS/emp/getEmpList?pageNo=${totalPages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div><!-- /.panel panel-success -->
        </div><!-- /.emp_info -->


        <!-- 尾部 -->
        <%@ include file="./common/footer.jsp"%>
    </div><!-- /.hrms_body -->
</div><!-- /.container -->

<%@ include file="employeeAdd.jsp"%>
<%@ include file="employeeUpdate.jsp"%>


<script>
    $(function () {
        //上一页
        var curPage = ${curPage};
        var totalPages = ${totalPages};
        $(".prePage").click(function () {
            if (curPage > 1){
                var pageNo = curPage-1;
                $(this).attr("href", "/HRMS/emp/getEmpList?pageNo="+pageNo);
            }
        });
        //下一页
        $(".nextPage").click(function () {
            if (curPage < totalPages){
                var pageNo = curPage+1;
                $(this).attr("href", "/HRMS/emp/getEmpList?pageNo="+pageNo);
            }
        });
    })
    <!-- =========================员工删除操作===================================  -->
    $(".emp_delete_btn").click(function () {
        var curPage = ${curPage};
        var delEmpId = $(this).parent().parent().find("td:eq(0)").text();
        var delEmpName = $(this).parent().parent().find("td:eq(1)").text();
        if (confirm("确认删除【" + delEmpName+ "】的信息吗？")){
            $.ajax({
                url:"/HRMS/emp/deleteEmp/"+delEmpId,
                type:"DELETE",
                success:function (result) {
                    if (result.code == 100){
                        alert("删除成功！");
                        window.location.href="/HRMS/emp/getEmpList?pageNo="+curPage;
                    }else {
                        alert(result.extendInfo.emp_del_error);
                    }
                }
            });
        }
    });
   
</script>
</body>
</html>