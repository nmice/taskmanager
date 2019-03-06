<html>
<head>
    <title>Project-form</title>
</head>
<body>
<div>
    Set Task properties:<br>
    <form action="/server/task-merge" method="post">
        <%
            if (request.getParameter("id") != null) {
        %>
        <input type="hidden" name="id" value=<%=request.getParameter("id")%>>
        <%
            }
        %>
        <input type="hidden" name="projectId" value=<%=request.getParameter("projectId")%>>

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
                <td><input type="text" name="dateBegin"></td>
            </tr>

            <tr>
                <td>End Date</td>
                <td><input type="text" name="dateEnd"></td>
            </tr>
        </table>
        <input type="submit" value="OK">
        <input type="button" value="Cancel" onClick='location.href="/server/task-list"'>
    </form>
</div>
</body>
</html>