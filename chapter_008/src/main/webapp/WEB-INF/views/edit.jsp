<%@ page import="ru.job4j.cruid.dao.User" %>
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
        <label>password:</label>
        <input type="text" name="pass" value="${user.password}">
        <c:choose>
            <c:when test="${(sessiaUser.role).equals('administrator')}">
                <select name="roles">
                    <c:forEach items="${roles}" var="role">
                        <c:choose>
                            <c:when test="${(user.role).equals(role.name)}">
                                <option selected value="${role.id}">${role.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${role.id}">${role.name}</option>
                            </c:otherwise>

                        </c:choose>
                    </c:forEach>
                </select>
            </c:when>
        </c:choose>
        <input type="submit" value="Update">
    </form>
</body>
</html>
