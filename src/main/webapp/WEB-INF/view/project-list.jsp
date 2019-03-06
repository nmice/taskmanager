<%@ page import="ru.neginskiy.tm.entity.Project" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.Format" %>
<html>
<head>
    <title>Project-list</title>
</head>
<body>
<table>
    <tr>
        <td width="200">
            <button><h3><a href="/task-manager">HOME</a></h3></button>
        </td>
        <td width="200">
            <button><h3><a href="project-form">ADD PROJECT</a></h3></button>
        </td>
    </tr>
</table>

<h2>PROJECT LIST</h2>

<table>
    <thead>
    <tr align="left">
        <th width="300">Name</th>
        <th width="200">Description</th>
        <th width="200">Begin date</th>
        <th width="200">End date</th>
        <th width="200">Edit</th>
        <th width="200">Delete</th>
        <th width="200">Task list</th>
    </tr>
    </thead>
    <tr>
        <td colspan="5">
            <hr>
        </td>
    </tr>
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
            <%}%>
        </td>
        <td><%if (project.getDateBegin() != null) {%>
            <%=formatter.format(project.getDateEnd())%>
            <%}%>
        </td>
        <%-- editing. Add id to url for getting it in method doGet()--%>
        <td>
            <a href="project-form?id=<%=project.getId()%>">
                EDIT
            </a>
        </td>
        <%-- deleting. Add id to url for getting it in method doPost()--%>
        <td>
            <form method="get">
                <a href="project-delete?id=<%=project.getId()%>">
                    DELETE
                </a>
            </form>
        </td>
        <td>
            <a href="task-list?projectId=<%=project.getId()%>">
                GET TASKS
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