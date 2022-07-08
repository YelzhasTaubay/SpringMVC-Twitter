<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%@include file="/WEB-INF/views/templates/head.jsp"%>
    <style>
        img{
            width: 100%;
        }
    </style>
</head>

<body>

<%@include file="/WEB-INF/views/templates/navbar.jsp"%>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

            <h1 class="my-4">
                ${tweet.title}
            </h1>
            <p>
                ${tweet.shortContent}
            </p>
            <p>
                ${tweet.content}
            </p>
            <b>
                Posted on ${tweet.postDate}
            </b>
            <br>
        </div>

        <div class="col-md-8">

            <c:forEach items="${thisComments}" var="com">
            <h1 class="my-4">
                ${com.comment}
            </h1>
            <p>
                ${com.postDate}
            </p>
            <p>
                ${com.author.fullname}
            </p>
            <br>
        </div
        </c:forEach>

    </div>


        <form action="/profile/comment" method="post">
            <textarea rows="3" name="area"></textarea>
            <input type="hidden" name="tweet_id" value="${tweet.id}">
            <button type="submit">Add Comment</button>
        </form>





</div>
<!-- /.container -->
<%@include file="/WEB-INF/views/templates/footer.jsp"%>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">

    function loadComments(){
        $.get("ajax", {

            act: "load_comments",
            blog_id : ${param.id}

        }, function(data){

            var comments = JSON.parse(data);
            var comList = "";

            for(var i = 0;i<comments.length;i++){
                comList+="<div class=\"alert alert-secondary\" role=\"alert\">"+comments[i].comment+" by <a href = \"#\">"+comments[i].author.fullName+"</a> at " +comments[i].postDate+"</div>";
            }

            $("#comments_list").html(comList);

        });
    }

    $(document).ready(function(){

        loadComments();

        <c:choose>
        <c:when test="${userOnline}">
        $("#comment").click(function(){
            $("#comment").attr("rows", 4);
        });

        $("#add_comment_button").click(function(){
            if($("#comment").val()!=""){
                $.post("ajax", {

                    blog_id: ${param.id},
                    comment: $("#comment").val(),
                    act: "add_comment"

                }, function(data){
                    $("#comment").val("");
                    $("#comment").attr("rows", "2");
                    loadComments();
                });
            }
        });
        </c:when>
        </c:choose>
    });
</script>



<form action="/profile/comment" method="post">
    <textarea rows="2" class="form-control" name="area"></textarea>
    <input type="hidden" name="tweet_id" value="${tweet.id}">
    <button type="submit">Add Comment</button>
</form>





</body>

</html>

