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

>
