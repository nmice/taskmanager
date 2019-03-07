<%@ page import="ru.neginskiy.tm.entity.Project" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.Format" %>
<html>
<head>
    <title>Project-list</title>
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
            <h3><a href="project-form">
                <button>ADD PROJECT</button>
            </a></h3>
        </td>
    </tr>
</table>

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
    <%
        final List<Project> projectList = (List<Project>) request.getAttribute("projects");
        final Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        if (projectList != null) {
            for (Project project : projectList) {
    %>
    <tr>
        <td><%=project.getName()%>
        </td>
        <td><%=project.getDescription()%>
        </td>
        <td><%if (project.getDateBegin() != null) {%>
            <%=formatter.format(project.getDateBegin())%>
            <%}%></td>
        <td><%if (project.getDateEnd() != null) {%>
            <%=formatter.format(project.getDateEnd())%>
            <%}%></td>
        <td><a href="project-form?id=<%=project.getId()%>">
            <button>EDIT</button>
        </a></td>
        <td><a href="project-delete?id=<%=project.getId()%>">
            <button>DELETE</button>
        </a>
        </td>
        <td><a href="task-list?projectId=<%=project.getId()%>">
            <button>GET TASKS</button>
        </a></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>