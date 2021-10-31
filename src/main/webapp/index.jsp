<%--
  Created by IntelliJ IDEA.
  User: clash
  Date: 10/29/2021
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SpringBet</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&family=Roboto&family=Yeseva+One&display=swap" rel="stylesheet">
    <link href="resources/style/style.css" rel="stylesheet">
</head>
<body>
<header>
    <nav>
        <div class="navSide">
            <a href="index.jsp" class="logo">SpringBet</a>
        </div>

        <div class="navSide">
            <a href="login.jsp" class="singIn">Login</a>
            <a href="register.jsp" class="singIn">Register</a>
        </div>
    </nav>
</header>

<section class="banner">
    <img class="bannerImage" src="resources/png/banner.png">
</section>

<section class="matches">
    <h1>Matches</h1>

    <div class="matchesList">
        <div class="matchEntity">
            <div class="matchSide">
                <p class="teamName">Spirit</p>
                <p class="teamCoefficient">1.5</p>
            </div>

            <div class="matchSide">
                <p class="teamCoefficient">1.5</p>
                <p class="teamName">Spirit</p>
            </div>
        </div>
    </div>

    <div class="matchesList">
        <div class="matchEntity">
            <div class="matchSide">
                <p class="teamName">Spirit</p>
                <p class="teamCoefficient">1.5</p>
            </div>

            <div class="matchSide">
                <p class="teamCoefficient">1.5</p>
                <p class="teamName">Spirit</p>
            </div>
        </div>
    </div>

    <div class="matchesList">
        <div class="matchEntity">
            <div class="matchSide">
                <p class="teamName">Spirit</p>
                <p class="teamCoefficient">1.5</p>
            </div>

            <div class="matchSide">
                <p class="teamCoefficient">1.5</p>
                <p class="teamName">Spirit</p>
            </div>
        </div>
    </div>

    <div class="matchesList">
        <div class="matchEntity">
            <div class="matchSide">
                <p class="teamName">Spirit</p>
                <p class="teamCoefficient">1.5</p>
            </div>

            <div class="matchSide">
                <p class="teamCoefficient">1.5</p>
                <p class="teamName">Spirit</p>
            </div>
        </div>
    </div>
</section>
</body>
</html>
