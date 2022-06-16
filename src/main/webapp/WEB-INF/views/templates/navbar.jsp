<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-info fixed-top">
    <div class="container">
        <a class="navbar-brand" href="https://twitter.com/home?lang=en">Twitter</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <c:choose>
            <c:when test="${userOnline}">
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="?page=home">${userProfile.fullName}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="?page=addblog">Add Blog</a>
                        </li>
                        <li class="nav-item">
                            <a href="JavaScript:void(0)" class="nav-link" onclick="logout()">Logout</a>
                        </li>
                    </ul>
                    <form action="" method="post" id = "logout_form">
                        <input type="hidden" value="logout" name="act">
                    </form>
                    <script type="text/javascript">
                        function logout(){
                            document.getElementById("logout_form").submit();
                        }
                    </script>
                </div>
            </c:when>
            <c:otherwise>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="/">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/profile/index">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/registration">Register</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/profile/index">Profile</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/index">Admin</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/users/search">Search User</a>
                        </li>

                    </ul>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
</nav>