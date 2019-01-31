<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Список пользователей</title>
    <meta charset="UTF-8">
</head>
<body>
    <h2>Список пользователей</h2>
    <form action="${pageContext.servletContext.contextPath}/users.do" method="post">
        name: <input type="text" name="name"><br/>
        <input type="submit"><br/>
    </form>
    <table border="1">
        <tr>
            <td>Имя</td>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr valign="top">
                <td>${user.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
