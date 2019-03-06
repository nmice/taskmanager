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
        <td width="200">
            <h3><a href="/task-manager">
                <button>HOME</button>
            </a></h3>
        </td>
        <td width="200">
            <h3><a href="project-form">
                <button>ADD PROJECT</button>
            </a></h3>
        </td>
    </tr>
</table>

<h2>PROJECT LIST</h2>

<table border="1" width="100%" cellpadding="5">
    <thead>
    <tr align="left">
        <th width="200">Name</th>
        <th width="200">Description</th>
        <th width="200">Begin date</th>
        <th width="200">End date</th>
        <th width="200">Edit</th>
        <th width="200">Delete</th>
        <th width="200">Task list</th>
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
            <%}%>
        </td>
        <td><%if (project.getDateEnd() != null) {%>
            <%=formatter.format(project.getDateEnd())%>
            <%}%>
        </td>
        <%-- editing. Add id to url for getting it in method doGet()--%>
        <td>
            <a href="project-form?id=<%=project.getId()%>">
                <button>
                    EDIT
                </button>
            </a>
        </td>
        <%-- deleting. Add id to url for getting it in method doPost()--%>
        <td>
            <form method="get">
                <a href="project-delete?id=<%=project.getId()%>">
                    <button>
                        DELETE
                    </button>
                </a>
            </form>
        </td>
        <td>
            <a href="task-list?projectId=<%=project.getId()%>">
                <button>
                    GET TASKS
                </button>
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