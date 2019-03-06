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
        <td width="200">
            <h3><a href="/task-manager">
                <button>HOME</button>
            </a></h3>
        </td>
        <td width="200">
            <h3><a href="task-form?projectId=<%=request.getAttribute("projectId")%>">
                <button>ADD TASK</button>
            </a></h3>
        </td>
        <td width="200">
            <h3><a href="project-list">
                <button>PROJECT LIST</button>
            </a></h3>
        </td>
    </tr>
</table>
<h2>TASK LIST</h2>

<table border="1" width="100%" cellpadding="5">
    <thead>
    <tr align="left">
        <th width="200">Name</th>
        <th width="200">Description</th>
        <th width="200">Begin date</th>
        <th width="200">End date</th>
        <th width="200">Edit</th>
        <th width="200">Delete</th>
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
            <a href="task-form?id=<%=task.getId()%>&projectId=<%=request.getAttribute("projectId")%>">
                <button>
                    EDIT
                </button>
            </a>
        </td>
        <%-- deleting. Add id to url for getting it in method doPost()--%>
        <td>
            <form method="get">
                <a href="task-delete?id=<%=task.getId()%>&projectId=<%=request.getAttribute("projectId")%>">
                    <button>
                        DELETE
                    </button>
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