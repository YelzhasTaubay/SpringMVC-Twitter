<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>

    <form action="/users/searching" method="post">
        <input type="text" name="name" placeholder="Full Name of User">
        <button type="submit">Search</button>
    </form>

    <p>Мои данные</p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Full Name</th>
            <th scope="col">Gender</th>
            <th scope="col">City</th>
            <th scope="col">Country</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td><a href="/users/profile/${user.id}">${user.id}</a> </td>
                <td>${user.fullname}</td>
                <td>${user.gender}</td>
                <td>${user.city}</td>
                <td>${user.country}</td>
            </tr>
        </tbody>
    </table>


    <p>Все Пользователи</p>

    <p>Already Followed Users</p>

    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Full Name</th>
            <th scope="col">Gender</th>
            <th scope="col">City</th>
            <th scope="col">Country</th>
            <th scope="col">Already Followed</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${alreadyFollowed}" var="a">
        <tr>
            <td><a href="/users/profile/${a.id}">${a.id}</a> </td>
            <td>${a.fullname}</td>
            <td>${a.gender}</td>
            <td>${a.city}</td>
            <td>${a.country}</td>
            <td>Already Followed</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

    <p>Not Followed Users</p>

    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Full Name</th>
            <th scope="col">Gender</th>
            <th scope="col">City</th>
            <th scope="col">Country</th>
            <th scope="col">Follow</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${notFollowed}" var="a">
            <tr>
                <td><a href="/users/profile/${a.id}">${a.id}</a> </td>
                <td>${a.fullname}</td>
                <td>${a.gender}</td>
                <td>${a.city}</td>
                <td>${a.country}</td>
                <td><a href="/users/follow/${a.id}">Follow</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>







</body>
</html>
