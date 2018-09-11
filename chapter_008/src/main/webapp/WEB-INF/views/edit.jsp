<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/edit" method='post'>
        <label>id:</label>
        <input type="text" name="id" value="${user.id}" size='10' readonly>
        <label>name:</label>
        <input type="text" name="name" value="${user.name}">
        <label>email:</label>
        <input type="text" name="email" value="${user.email}">
        <input type="submit" value="Update">
    </form>
</body>
</html>
