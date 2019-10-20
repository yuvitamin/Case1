
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>欢迎注册</title>
    <link rel="stylesheet" href="css/style.css" />

<body>

<div class="register-container" >
    <h1>Create an account</h1>

    <div class="connect">
        <p>Link the world. Share to world.</p>
    </div>

    <form action="regeditServlet" method="post" id="registerForm">
        <div>
            <input type="text" name="u_username" class="username" placeholder="您的用户名" autocomplete="off"/>
        </div>
        <div>
            <input type="password" name="u_password" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" maxlength="20" minlength="6"/>
        </div>
        <div>
            <input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" maxlength="20" minlength="6" />
        </div>
        <div>
            <input type="text" name="u_sex"   placeholder="请输入性别" >
        </div>

        <div>
            <input type="text" name="u_hobbies"  placeholder="有什么兴趣爱好" >
        </div>

        <div>
            <input type="text" name="u_phone" class="phone_number" placeholder="输入手机号码" autocomplete="off" id="number"/>
        </div>
        <div>
            <input type="email" name="u_email" class="email" placeholder="输入邮箱地址" oncontextmenu="return false" onpaste="return false" />
        </div>
        <div>
            <input type="text" name="u_address"  required="required" placeholder="输入地址" oncontextmenu="return false" onpaste="return false" />
        </div>

        <button id="submit" type="submit">注 册</button>
    </form>
    <a href="login.jsp">
        <button type="button" class="register-tis">已经有账号？</button>
    </a>

</div>


<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js?var1.14.0"></script>

</body>
</html>

