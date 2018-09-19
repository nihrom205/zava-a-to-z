<%@ page import="ru.job4j.cruid.logic.ValidateService" %>
<%@ page import="ru.job4j.cruid.dao.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <%User user = ValidateService.getInstance().findById(Integer.valueOf(request.getParameter("id")));%>
    <form action="<%=request.getContextPath()%>/edit" method='post'>
        <label>id:</label>
        <input type="text" name="id" value="<%=user.getId()%>" size='10' readonly>
        <label>name:</label>
        <input type="text" name="name" value="<%=user.getName()%>">
        <label>email:</label>
        <input type="text" name="email" value="<%=user.getEmail()%>">
        <input type="submit" value="Update">
    </form>
</body>
</html>
