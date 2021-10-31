<%--
  Created by IntelliJ IDEA.
  User: clash
  Date: 10/29/2021
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&family=Roboto&family=Yeseva+One&display=swap" rel="stylesheet">
    <link href="resources/style/login_style.css" rel="stylesheet">
</head>
<body>
<header>
    <nav>
        <div class="navSide">
            <a href="index.jsp" class="logo">SpringBet</a>
        </div>

        <div class="navSide">
        </div>
    </nav>
</header>

<section class="loginBox">
    <h1>Login</h1>
    <form action="/login" method="post">
        <input type="email" id="email" name="email" placeholder="E-mail">
        <input type="password" id="password" name="password" placeholder="Password">
        <button>Login</button>
    </form>
</section>
</body>
</html>
