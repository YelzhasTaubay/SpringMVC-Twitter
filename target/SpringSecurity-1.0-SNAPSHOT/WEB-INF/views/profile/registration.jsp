<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/views/templates/head.jsp"%>
</head>
<body>





<%@include file="/WEB-INF/views/templates/navbar.jsp"%>
<!-- Page Content -->
<div class="container" style="min-height: 700px;">
    <div class="row">
        <!-- Blog Entries Column -->
        <div class="col-md-6 offset-3">
            <h1 class="my-4">
            </h1>
            <div class="alert alert-danger" style="display:none;" role="alert" id = "message">
            </div>

<%--            <form action="/profile/registration1" method="post">--%>
<%--                EMAIL : <input type="email" name="user_email">--%>
<%--                PASSWORD : <input type="password" name="user_password">--%>
<%--                Full Name : <input type="text" name="full_name">--%>
<%--                Gender :    <input type="text" name="gender">--%>
<%--                Country : <input type="text" name="country">--%>
<%--                City : <input type="text" name="city">--%>
<%--                Role : <input type="text" name="role">--%>
<%--                <button>SIGN IN</button>--%>
<%--            </form>--%>

            <form action="/profile/registration1" method="post">
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Email</label>
                    <div class="col-sm-8">
                        <input type="email" class="form-control" placeholder="Email" name="user_email">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Password</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" placeholder="Password" name="user_password" >
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Full Name</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" placeholder="Full Name" name="full_name" >
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Gender</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" placeholder="Gender" name="gender" >
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Country</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" placeholder="Country" name="country" >
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">City</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" placeholder="City" name="city" >
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Role</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" placeholder="Role" name="role" >
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-12">
                        <button type="submit" class="btn btn-success float-right">REGISTER</button>
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
