<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Users</title>
    <style>
        h2 {
            color: black;
        }
        input.add {
            margin: 5px;
        }
        div {
            margin: 5px;
            float: left;
            padding: 0px;
        }
        div form {
            margin: 0px;
            padding:  0px;
        }
        th {
            background: darkgrey;
        }
    </style>
</head>
<body>
    <h2>List Users</h2>
    <form action="${pageContext.servletContext.contextPath}/create" method="post">
        Login : <input class="add" type="text" name="login"> <br/>
        Email : <input class="add" type="text" name="email"> <br/>
        <input type="submit" value="Add user">
    </form>
    <form action="" method="post">
        <input type="submit" value="Edit roles">
    </form>

    <br>
    <table border="1">
        <th>id</th>
        <th>login</th>
        <th>email</th>
        <th>password</th>
        <th>role</th>
        <th>editing</th>
        <col width="50">
        <col width="150">
        <col width="150">
        <col width="110">
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.id}"></c:out></td>
                <td><c:out value="${user.name}"></c:out></td>
                <td><c:out value="${user.email}"></c:out></td>
                <td><c:out value="${user.password}"></c:out></td>
                <td><c:out value="${user.role}"></c:out></td>
                <td>
                    <div>
                        <form action="${pageContext.servletContext.contextPath}/edit" method="get">
                            <input class="edit" type="hidden" name="id" value="${user.id}">
                            <input class="edit" type="submit" value="Edit"> <br/>
                        </form>
                    </div>
                    <div>
                        <form action="${pageContext.servletContext.contextPath}/delete" method="post">
                            <input class="edit" type="hidden" name="id" value="${user.id}">
                            <input class="edit" type="submit" value="Del">
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
