<%@ page import="kz.bitlab.project.entities.Roles" %>
<%@ page import="java.util.Set" %>
<%@ page import="kz.bitlab.project.entities.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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


    <form action="/profile/updating" method="post">
        Email: <input type="email" name="user_email" value="${user.email}">
        Password: <input type="password" name="user_password" value="${user.password}">
        Full Name: <input type="text" name="full_name" value="${user.fullname}">
        Gender: <input type="text" name="gender" value="${user.gender}">
        Country: <input type="text" name="country" value="${user.country}">
        City: <input type="text" name="city" value="${user.city}">
        Role: <select multiple name="role">
            <c:forEach items="${allRoles}" var="r">
                <option>${r.role}</option>
            </c:forEach>
    </select>
        <button type="submit">Update User</button>
    </form>



    <%@include file="/WEB-INF/views/templates/navbar.jsp"%>

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
