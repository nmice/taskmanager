<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Task-list</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div align="center">
    <h3>
        <a href="project-list">
            <button>PROJECT LIST</button>
        </a>
        <a href="task-form?projectId=${param.projectId}">
            <button>ADD TASK</button>
        </a>
        <a href="logout">
            <button>LOGOUT</button>
        </a>
    </h3>
    <h2>TASK LIST</h2>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Begin date</th>
            <th>End date</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <c:if test="${!empty tasks}">
            <c:forEach var="task" items="${tasks}">
                <tr>
                    <td>${task.getName()}</td>
                    <td>${task.getDescription()}</td>
                    <td>
                    <c:if test="${!empty task.getDateBegin()}">
                        <fmt:formatDate value="${task.getDateBegin()}" pattern="dd-MM-yyyy"/>
                    </c:if>
                    </td>
                    <td>
                    <c:if test="${!empty task.getDateEnd()}">
                        <fmt:formatDate value="${task.getDateEnd()}" pattern="dd-MM-yyyy"/>
                    </c:if>
                    </td>
                    <td><a href="task-form?id=${task.getId()}&projectId=${task.getProjectId()}">
                        <button>EDIT</button>
                    </a></td>
                    <td><a href="task-delete?id=${task.getId()}&projectId=${task.getProjectId()}">
                        <button>DELETE</button>
                    </a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
</body>
</html>