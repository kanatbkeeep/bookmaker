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
    <link href="resources/style/register_style.css" rel="stylesheet">
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
    <h1>Register</h1>
    <form>
        <input type="email" id="email" name="email" placeholder="E-mail">
        <input type="text" id="firstName" name="firstName" placeholder="First Name">
        <input type="text" id="secondName" name="secondName" placeholder="Second Name">
        <input type="text" id="age" name="age" placeholder="Age">
        <input type="text" id="uin" name="uin" placeholder="UIN">
        <input type="password" id="password" name="password" placeholder="Password">
        <button>Register</button>
    </form>
</section>
</body>
</html>
