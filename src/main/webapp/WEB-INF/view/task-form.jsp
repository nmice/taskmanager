<html>
<head>
    <title>Project-form</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div>
    SET TASK PROPERTIES:<br>
    <form action="task-merge" method="post">
        <%
            if (request.getParameter("id") != null) {
        %>
        <input type="hidden" name="id" value=<%=request.getParameter("id")%>>
        <%
            }
        %>
        <input type="hidden" name="projectId" value=<%=request.getParameter("projectId")%>>

        <table border="1" cellpadding="5">
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
                <td><input type="text" name="dateBegin"></td>
            </tr>

            <tr>
                <td>End Date</td>
                <td><input type="text" name="dateEnd"></td>
            </tr>
        </table>
        <input type="submit" value="OK">
        <input type="button" value="Cancel" onClick='location.href="task-list"'>
    </form>
</div>
</body>
</html>