<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit roles</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
    <h2>List Role</h2>
    <form action="${pageContext.servletContext.contextPath}/createRole" method="post">
        Role name: <input type="text" name="name" value=""> <br>
        Role description: <input type="text" name="desc" value=""> <br>
        <input type="submit" value="Add role">
    </form>
    <table border="1">
        <th>id</th>
        <th>role name</th>
        <th>description</th>
        <col width="50">
        <col width="50">
        <col width="150">
        <c:forEach items="${roles}" var="r">
            <tr>
                <td><c:out value="${r.id}"></c:out></td>
                <td><c:out value="${r.name}"></c:out></td>
                <td><c:out value="${r.description}"></c:out></td>
                <td>
                    <div>
                        <%--<form action="" method="post">--%>
                            <%--<select name="selectRoles" id="">--%>
                            <%--<option></option>--%>
                        <%--</select>--%>
                        <%--</form>--%>
                    </div>
                    <div>
                        <form action="${pageContext.servletContext.contextPath}/deleteRole" method="post">
                            <input type="hidden" name="id" value="${r.id}">
                            <input type="submit" value="Del">
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
