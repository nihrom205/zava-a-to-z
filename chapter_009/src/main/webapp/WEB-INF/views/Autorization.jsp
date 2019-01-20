<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 11.01.19
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <%--<link href=<jsp:include page="signin.css"/> rel="stylesheet">--%>
    <link href="https://getbootstrap.com/docs/3.3/examples/signin/signin.css" rel="stylesheet">

    <title>Авторизация</title>
</head>
<body class="text-center">
    <div class="container">
        <div class="row">
            <div class="col">
            </div>
            <c:if test="${error != ''}">
                <div style="background-color: red">
                    <c:out value="${error}"/>
                </div>
            </c:if>
            <div class="col">
                <form class="form-signin" action="${pageContext.servletContext.contextPath}/signin" method="post">
                    <h1 class="h3 mb-3 font-weight-normal">Войти в систему</h1>
                    <label for="inputLogin" class="sr-only"><login></login></label>
                    <input name="login" type="login" id="inputLogin" class="form-control" placeholder="логин" required="" autofocus="">
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input name="passwd"type="password" id="inputPassword" class="form-control" placeholder="пароль" required="">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
                </form>

            </div>
            <div class="col">

            </div>
        </div>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>
