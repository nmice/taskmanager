<%@ page import="ru.neginskiy.tm.entity.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.Format" %>
<html>
<head>
    <title>Task-list</title>
</head>
<body>
<table>
    <tr>
        <td width="200">
            <button><h3><a href="/task-manager">HOME</a></h3></button>
        </td>
        <td width="200">
            <button><h3><a href="task-form?projectId=<%=request.getAttribute("projectId")%>">
                ADD TASK
            </a></h3></button>
        </td>
        <td width="200">
            <button><h3><a href="project-list">
                GO TO PROJECT LIST
            </a></h3></button>
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
        List<Task> taskList = (List<Task>) request.getAttribute("tasks");
        final Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        if (taskList != null) {
            for (Task task : taskList) {
    %>
    <tr>
        <td><%=task.getName()%>
        </td>
        <td><%=task.getDescription()%>
        <td><%if (task.getDateBegin() != null) {%>
            <%=formatter.format(task.getDateBegin())%>
            <%}%>
        </td>
        <td><%if (task.getDateBegin() != null) {%>
            <%=formatter.format(task.getDateEnd())%>
            <%}%>
        </td>
        <%-- editing. Add id to url for getting it in method doGet()--%>
        <td>
            <a href="task-form?id=<%=task.getId()%>&projectId=<%=request.getAttribute("projectId")%>">
                EDIT
            </a>
        </td>
        <%-- deleting. Add id to url for getting it in method doPost()--%>
        <td>
            <form method="get">
                <a href="task-delete?id=<%=task.getId()%>&projectId=<%=request.getAttribute("projectId")%>">
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