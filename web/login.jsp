
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies!=null&&cookies.length>0){
        for (Cookie cookie:cookies){
            String u_username = cookie.getName();
            if (u_username.equals("u_username")){
                response.sendRedirect("goodsServlet?method=list");
            }
        }
    }
%>
<html>
<<head>

    <meta charset="utf-8">
    <title>欢迎登录</title>

    <!-- CSS -->
    <link rel="stylesheet" href="assets/css/reset.css">
    <link rel="stylesheet" href="assets/css/supersized.css">
    <link rel="stylesheet" href="assets/css/style.css">


</head>
<body>
<form action="loginServlet" method="post">
    <div style="color: red" class="login">${login_error}</div>
    <div class="page-container">
    <h1>Login</h1>
    <form action="#" method="post">
        <input type="text" name="u_username" class="username" placeholder="Username">
        <input type="password" name="u_password" class="password" placeholder="Password">
        <button type="submit">Sign me in</button>
        <button type="submit" onclick="window.open('regedit.jsp')">Click to register</button>
<%--        <div class="error"><span>+</span></div>--%>
    </form>
</div>

<!-- Javascript -->
<script src="assets/js/jquery-1.8.2.min.js"></script>
<script src="assets/js/supersized.3.2.7.min.js"></script>
<script src="assets/js/supersized-init.js"></script>
<script src="assets/js/scripts.js"></script>

</form>
</body>

</html>
