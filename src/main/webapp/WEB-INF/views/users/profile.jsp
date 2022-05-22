<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile of Other User</title>
</head>
<body>

<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Email</th>
        <th scope="col">Full Name</th>
        <th scope="col">Gender</th>
        <th scope="col">City</th>
        <th scope="col">Country</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${user.email}</td>
            <td>${user.fullname}</td>
            <td>${user.gender}</td>
            <td>${user.city}</td>
            <td>${user.country}</td>
        </tr>
    </tbody>
</table>


   <p>Мои Подписки</p>

<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Email</th>
        <th scope="col">Full Name</th>
        <th scope="col">Gender</th>
        <th scope="col">City</th>
        <th scope="col">Country</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allUsers}" var="a">
    <tr>
        <td>${a.email}</td>
        <td>${a.fullname}</td>
        <td>${a.gender}</td>
        <td>${a.city}</td>
        <td>${a.country}</td>
        <c:forEach items="${idOfFollows}" var="i">
        <td><a href="/users/delete/${i}">Unfollow</a></td>
        </c:forEach>
    </tr>
    </c:forEach>
    </tbody>
</table>


    <p>Мои Подписчики</p>

<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Email</th>
        <th scope="col">Full Name</th>
        <th scope="col">Gender</th>
        <th scope="col">City</th>
        <th scope="col">Country</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allUsersFrom}" var="f">
        <tr>
            <td>${f.email}</td>
            <td>${f.fullname}</td>
            <td>${f.gender}</td>
            <td>${f.city}</td>
            <td>${f.country}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>









</body>
</html>
