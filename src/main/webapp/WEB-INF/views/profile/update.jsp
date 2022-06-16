<%@ page import="kz.bitlab.project.entities.Roles" %>
<%@ page import="java.util.Set" %>
<%@ page import="kz.bitlab.project.entities.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Update</title>--%>
<%--    <%@include file="/WEB-INF/views/templates/head.jsp"%>--%>
<%--    <style>--%>
<%--        img{--%>
<%--            width: 100%;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>


<%--    <form action="/profile/updating" method="post">--%>
<%--        Email: <input type="email" name="user_email" value="${user.email}">--%>
<%--        Password: <input type="password" name="user_password" value="${user.password}">--%>
<%--        Full Name: <input type="text" name="full_name" value="${user.fullname}">--%>
<%--        Gender: <input type="text" name="gender" value="${user.gender}">--%>
<%--        Country: <input type="text" name="country" value="${user.country}">--%>
<%--        City: <input type="text" name="city" value="${user.city}">--%>
<%--        Role: <select multiple name="role">--%>
<%--            <c:forEach items="${allRoles}" var="r">--%>
<%--                <option>${r.role}</option>--%>
<%--            </c:forEach>--%>
<%--    </select>--%>
<%--        <button type="submit">Update User</button>--%>
<%--    </form>--%>

<%--    <%@include file="/WEB-INF/views/templates/navbar.jsp"%>--%>

<%--    <!-- Page Content -->--%>
<%--    <div class="container">--%>

<%--        <div class="row">--%>

<%--            <!-- Blog Entries Column -->--%>
<%--            <div class="col-md-8">--%>

<%--                <h1 class="my-4">--%>
<%--                </h1>--%>


<%--                <!-- Pagination -->--%>
<%--                <ul class="pagination justify-content-center mb-4">--%>
<%--                    <li class="page-item">--%>
<%--                        <a class="page-link" href="#">&larr; Older</a>--%>
<%--                    </li>--%>
<%--                    <li class="page-item disabled">--%>
<%--                        <a class="page-link" href="#">Newer &rarr;</a>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--            </div>--%>

<%--            <%@include file="/WEB-INF/views/templates/sidebar.jsp"%>--%>

<%--        </div>--%>
<%--        <!-- /.row -->--%>

<%--    </div>--%>
<%--    <!-- /.container -->--%>
<%--    <%@include file="/WEB-INF/views/templates/footer.jsp"%>--%>
<%--    <!-- Bootstrap core JavaScript -->--%>
<%--    <script src="vendor/jquery/jquery.min.js"></script>--%>
<%--    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>--%>

<%--</body>--%>
<%--</html>--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--    <%@include file="/WEB-INF/views/templates/head.jsp"%>--%>
<%--</head>--%>
<%--<body>--%>



<html>
<head>
    <title>Update</title>
    <%@include file="/WEB-INF/views/templates/head.jsp"%>
    <style>
        img{
            width: 100%;
        }
    </style>
</head>

<body>
<!-- Page Content -->
<div class="container" style="min-height: 700px;">
    <div class="row">
        <!-- Blog Entries Column -->
        <div class="col-md-6 offset-3">
            <h1 class="my-4">
            </h1>
            <div class="alert alert-danger" style="display:none;" role="alert" id = "message">
            </div>

            <form action="/profile/updating" method="post">
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Email</label>
                    <div class="col-sm-8">
                        <input type="email" class="form-control" value="${user.email}" name="user_email">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Password</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" value="${user.password}" name="user_password" >
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Full Name</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" value="${user.fullname}" name="full_name" >
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Gender</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" value="${user.gender}" name="gender" >
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Country</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" value="${user.country}" name="country" >
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">City</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" value="${user.city}" name="city" >
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Role</label>
                        <select multiple name="role">
                        <c:forEach items="${allRoles}" var="r">
                            <div class="col-sm-8">
                        <input type="text" class="form-control" placeholder="Role" name="role" >
                            <option class="form-control">${r.role}</option>
                            </div>
                        </c:forEach>
                        </select>
                </div>
                <div class="form-group row">
                    <div class="col-sm-12">
                        <button type="submit" class="btn btn-success float-right">UPDATE</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
    <!-- /.row -->
</div>
<!-- /.container -->
<%@include file="/WEB-INF/views/templates/footer.jsp"%>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {

        $("#register").click(function () {

            var ok = true;

            if($("#email").val()==""){
                ok = false;
                $("#message").html("Complete email!");
            }

            if($("#password").val()!=$("#re_password").val()){
                ok = false;
                $("#message").html("Passwords are not equal!");
            }

            if($("#password").val()==""){
                ok = false;
                $("#message").html("Complete password!");
            }
            if($("#re_password").val()==""){
                ok = false;
                $("#message").html("Complete re-password!");
            }

            if($("#full_name").val()==""){
                ok = false;
                $("#message").html("Complete full name!");
            }

            if(ok){

                validate();

            }else{

                $("#message").fadeIn();

            }

        });

        function validate(){

            $.get("/ajax", {

                act: "validate",
                email: $("#email").val()

            }, function (data) {

                var json = JSON.parse(data);

                if(json.result=="error"){
                    $("#message").html("User already exists");
                    $("#message").fadeIn();
                }else{
                    $("#register_form").submit();
                }



            });

        }

    });
</script>

</body>
</html>

