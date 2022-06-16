<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="templates/head.jsp"%>
    <style>
        img{
            width: 100%;
        }
    </style>
</head>
<body>
<h1>WELCOME TO SPRING SECURITY APP - MVC</h1>


<%@include file="templates/navbar.jsp"%>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

            <h1 class="my-4">
            </h1>

            <c:forEach items="${allTweets}" var="a">
                <div class="card mb-4">
                    <div class="card-body">
                        <h2 class="card-title">${a.title}</h2>
                        <p class="card-text">
                                ${a.shortContent}
                        </p>
                        <a href="/readmore/${a.id}" class="btn btn-primary">Read More &rarr;</a>
                    </div>
                    <div class="card-footer text-muted">
                        Posted on ${a.postDate} by
                        <a href="#">${a.author.fullname}</a>
                    </div>
                </div>
            </c:forEach>


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

        <%@include file="templates/sidebar.jsp"%>

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->
<%@include file="templates/footer.jsp"%>
<!-- Bootstrap core JavaScript -->
<script src="resources/vendor/jquery/jquery.min.js"></script>
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>







</body>
</html>
