<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Taskmanager</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="script/script.js"></script>
</head>
<body>
<div align="center">
    <c:if test="${!empty msg}">
        <h2>${msg}</h2>
    </c:if>
    <c:if test="${!empty userId}">
        <h1><a href="project-list">
            <button>GO TO PROJECT-LIST</button>
        </a></h1>
    </c:if>
</div>
<c:if test="${empty userId}">
    <div class="login-page">
        <div class="form">
            <c:if test="${!empty loginMessage}">
                <h2>${loginMessage}</h2>
            </c:if>
            <form class="register-form" action="authorization" method="get">
                <input type="text" placeholder="name" name="name"/>
                <input type="password" placeholder="password" name="password"/>
                <button type="submit">create</button>
                <p class="message">Already registered? <a href="#">Sign In</a></p>
            </form>
            <form class="login-form" action="authorization" method="get">
                <input type="text" placeholder="username" name="username"/>
                <input type="password" placeholder="password" name="password"//>
                <button type="submit">login</button>
                <p class="message">Not registered? <a href="#">Create an account</a></p>
            </form>
        </div>
    </div>
</c:if>
</body>
</html>



