<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    PROFILE PAGE OF ${user.fullname}
</h1>
<a href="/">HOME PAGE</a>
<form action="/signout" method="post">
    <button>SIGN OUT</button>
</form>

    <form action="/profile/delete" method="post">
        <input type="email" name="email" value="${user.email}">
        <button >Delete ${user.fullname}</button>
    </form>

    <p><a href="/profile/update">Update</a></p>

    <p><a href="/profile/addtwit">Add Twit</a></p>




</body>
</html>
