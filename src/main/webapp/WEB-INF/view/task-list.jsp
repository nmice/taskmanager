<%@ page import="ru.neginskiy.tm.entity.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.Format" %>
<html>
<head>
    <title>Task-list</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<table>
    <tr>
        <td>
            <h3><a href="/task-manager">
                <button>HOME</button>
            </a></h3>
        </td>
        <td>
            <h3><a href="task-form?projectId=<%=request.getAttribute("projectId")%>">
                <button>ADD TASK</button>
            </a></h3>
        </td>
        <td>
            <h3><a href="project-list">
                <button>PROJECT LIST</button>
            </a></h3>
        </td>
    </tr>
</table>
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
        <td><%if (task.getDateEnd() != null) {%>
            <%=formatter.format(task.getDateEnd())%>
            <%}%>
        </td>
        <%-- editing. Add id to url for getting it in method doGet()--%>
        <td>
            <a href="task-form?id=<%=task.getId()%>&projectId=<%=task.getProjectId()%>">
                <button>EDIT</button>
            </a>
        </td>
        <td>
            <a href="task-delete?id=<%=task.getId()%>&projectId=<%=task.getProjectId()%>">
                <button>DELETE</button>
            </a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>