<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="templates/head.jsp"%>
</head>
<body>

    <%@include file="templates/navbar.jsp"%>
    <!-- Page Content -->
    <div class="container" style="min-height: 700px;">
        <div class="row">
            <!-- Blog Entries Column -->
            <div class="col-md-6 offset-3">

                <h1 class="my-4">
                </h1>
                <div class="alert alert-danger" style="display:none;" role="alert" id = "message">
                </div>

                <form action="/signin" method="post" >
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Email</label>
                        <div class="col-sm-8">
                            <input type="email" class="form-control" placeholder="Email" name="user_email">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Password</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" placeholder="Password" name="user_password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <button type="submit" class="btn btn-success float-right" >LOGIN</button>
                        </div>
                    </div>
                </form>

            </div>

        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
    <%@include file="templates/footer.jsp"%>
    <!-- Bootstrap core JavaScript -->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {

            $("#login").click(function () {

                var ok = true;

                if($("#email").val()==""){
                    ok = false;
                    $("#message").html("Complete email!");
                }

                if($("#password").val()==""){
                    ok = false;
                    $("#message").html("Complete password!");
                }

                if(ok){

                    validate();

                }else{

                    $("#message").fadeIn();

                }

            });

            function validate(){

                $.get("/ajax", {

                    act: "auth",
                    email: $("#email").val(),
                    password: $("#password").val()

                }, function (data) {

                    var json = JSON.parse(data);

                    if(json.result=="error"){

                        $("#message").html("Incorrect email or password");
                        $("#message").fadeIn();
                    }else{
                        $("#login_form").submit();
                    }

                });

            }

        });
    </script>



</form>
</body>
</html>
