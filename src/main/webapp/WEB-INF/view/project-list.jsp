<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Project-list</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div align="center">
    <h3><a href="/task-manager">
        <button>HOME</button>
    </a>
        <a href="project-form">
            <button>ADD PROJECT</button>
        </a>
        <a href="logout">
            <button>LOGOUT</button>
        </a>
    </h3>
</div>
<div align="center">
    <h2>PROJECT LIST</h2>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Begin date</th>
            <th>End date</th>
            <th>Edit</th>
            <th>Delete</th>
            <th>Task list</th>
        </tr>
        </thead>

        <c:if test="${!empty projects}">
            <c:forEach var="project" items="${projects}">
                <tr>
                    <td>${project.getName()}</td>
                    <td>${project.getDescription()}</td>


                    <td><c:if test="${!empty project.getDateBegin()}">
                        <fmt:formatDate value="${project.getDateBegin()}" pattern="dd-MM-yyyy"/>
                    </c:if></td>
                    <td><c:if test="${!empty project.getDateEnd()}">
                        <fmt:formatDate value="${project.getDateEnd()}" pattern="dd-MM-yyyy"/>
                    </c:if></td>


                    <td><a href="project-form?id=${project.getId()}">
                        <button>EDIT</button>
                    </a></td>
                    <td><a href="project-delete?id=${project.getId()}">
                        <button>DELETE</button>
                    </a></td>
                    <td><a href="task-list?projectId=${project.getId()}">
                        <button>GET TASKS</button>
                    </a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <h3>USER_ID=${sessionScope.userId}</h3>
</div>
</body>
</html>