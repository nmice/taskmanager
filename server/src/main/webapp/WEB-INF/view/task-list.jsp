<%@ page import="ru.neginskiy.tm.entity.Task" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Task-list</title>
</head>
<body>
<table>
    <tr>
        <td width="200">
            <button><h3><a href="/server">Home</a></h3></button>
        </td>
        <td width="200">
            <button><h3><a href="project-form.jsp?formtype=add">Add Project</a></h3></button>
        </td>
    </tr>
</table>
<h2>TASK LIST</h2>


<table>
    <thead>
    <tr align="left">
        <th width="300">Name</th>
        <th width="200">Description</th>
        <th width="200">Begin date</th>
        <th width="200">End date</th>
        <th width="200">Edit</th>
        <th width="200">Delete</th>
    </tr>
    </thead>

    <tr>
        <td colspan="5">
            <hr>
        </td>
    </tr>
    <%
        List<Task> taskList = (List<Task>) request.getAttribute("projects");
        if (taskList != null) {
            for (Task task : taskList) {
    %>

    <tr>
        <td><%=task.getName()%>
        </td>
        <td><%=task.getDescription()%>
        </td>
        <td><%=task.getDateBegin()%>
        </td>
        <td><%=task.getDateEnd()%>
        </td>
        <%-- editing. Add id to url for getting it in method doGet()--%>
        <td>
            <a href="project-form.jsp?id=<%=task.getId()%>&formtype=edit">
                EDIT
            </a>
        </td>
        <%-- deleting. Add id to url for getting it in method doPost()--%>
        <td>
            <form method="get">
                <a href="/server/project-delete?id=<%=task.getId()%>&del=true">
                    DELETE
                </a>
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>


</body>
</html>