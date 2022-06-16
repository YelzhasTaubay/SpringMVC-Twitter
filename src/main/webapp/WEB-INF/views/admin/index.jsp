<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    ADMIN PAGE OF: ${user.fullname}
</h1>
<a href="/">HOME PAGE</a>
<form action="/signout" method="post">
    <button>SIGN OUT</button>
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/views/templates/head.jsp"%>
    <style>
        img{
            width: 100%;
        }
    </style>
</head>
<body>
<h1>WELCOME TO SPRING SECURITY APP - MVC</h1>


<%@include file="/WEB-INF/views/templates/navbar.jsp"%>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

            <h1 class="my-4">
            </h1>

            <h1>
                ADMIN PAGE OF: ${user.fullname}
            </h1>
            <a href="/">HOME PAGE</a>
            <form action="/signout" method="post">
                <button>SIGN OUT</button>
            </form>


            <!-- Pagination -->
            <ul class="pagination justify-content-center mb-4">
                <li class="page-item">
                    <a class="page-link" href="#">&larr; Older</a>
                </li>
                <li class="page-item disabled">
                    <a class="page-link" href="#">Newer &rarr;</a>
                </li>
            </ul>

        </div>

        <%@include file="/WEB-INF/views/templates/sidebar.jsp"%>

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->
<%@include file="/WEB-INF/views/templates/footer.jsp"%>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>







</body>
</html>

