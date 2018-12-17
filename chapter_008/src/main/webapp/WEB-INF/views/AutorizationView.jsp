<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href=<jsp:include page="signin.css"/> rel="stylesheet">
    <title>Авторизация</title>
</head>
<body>
    <c:if test="${error != ''}">
        <div style="background-color: red">
            <c:out value="${error}"/>
        </div>
    </c:if>
    <div class="container">
        <form  class="form-signin" action="${pageContext.servletContext.contextPath}/signin" method="post">
            <h2 class="form-signin-heading">Please sign in</h2>
            <input type="text" class="form-control" placeholder="login:" name="login"><br/>
            <input type="password" class="form-control" placeholder="password" name="password"><br/>
            <input class="btn btn-lg btn-primary btn-block" type="submit">
        </form>
    </div>
</body>
</html>
