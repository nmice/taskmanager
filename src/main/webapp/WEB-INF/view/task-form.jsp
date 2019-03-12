<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Task-form</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="form">
    SET TASK PROPERTIES:<br>
    <form action="task-merge" method="get">
        <c:if test="${!empty param.id}">
            <input type="hidden" name="id" value=${param.id}>
        </c:if>
        <c:if test="${!empty param.projectId}">
            <input type="hidden" name="projectId" value=${param.projectId}>
        </c:if>
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <td>Begin Date</td>
                <td><input type="text" placeholder="DD-MM-YYYY" name="dateBegin"></td>
            </tr>
            <tr>
                <td>End Date</td>
                <td><input type="text" placeholder="DD-MM-YYYY" name="dateEnd"></td>
            </tr>
        </table>
        <input type="submit" value="OK">
        <input type="button" value="Cancel"
               onClick='location.href="task-list?projectId=${param.projectId}"'>
    </form>
</div>
</body>
</html>