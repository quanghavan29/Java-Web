<%-- 
    Document   : register
    Created on : Dec 7, 2020, 3:54:29 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/authen.css" rel="stylesheet" type="text/css"/>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    </head>
    <body>
        <!-- Authen form -->
        <form action="register" method="post">
        <div class="auth-form">
            <div class="auth-form-container">
                <div class="auth-form-header">
                    <h3 class="auth-form-title">Register</h3>
                    <a href="login.jsp" class="auth-form-subtitle">Login</a>
                </div>

                <div class="auth-form-form">
                    <div class="auth-form-group">
                        <input class="auth-form-input" type="text" name="username"
                               placeholder="Username" required="required" value="${param.username}"/>
                    </div>

                    <div class="auth-form-group">
                        <input class="auth-form-input" type="text" name="phone"
                               placeholder="Phone" required="required" value="${param.phone}"/>
                    </div>

                    <div class="auth-form-group">
                        <input class="auth-form-input" type="text" name="address"
                               placeholder="Address" required="required" value="${param.address}"/>
                    </div>

                    <div class="auth-form-group">
                        <input class="auth-form-input" type="password" name="password"
                               placeholder="Password" required="required" />
                    </div>
                    <div class="auth-form-group">
                        <input class="auth-form-input" type="password" name="repassword"
                               placeholder="Re-Password" required="required" />
                    </div>
                </div>
                <p style="margin-top: -10px; color: green; margin-left: 2px;">${requestScope.messageSuccess}</p>
                <p style="margin-top: -10px; color: red; margin-left: 2px;">${requestScope.message}</p>
                <div class="auth-form-controls">
                    <a href="home" class="btn">Back</a>
                    <button type="submit" class="btn">Register</button>
                </div>
            </div>
            <div class="auth-form-social">
                <a href="#" class="btn-social-fb"><i class='fab' style="font-size: 20px;">&#xf09a;</i> Login With Facebook </a>
                <a href="#" class="btn-social-gg"><i class='fab' style='font-size:20px; color: tomato'>&#xf2b3;</i> Login With Google </a>
            </div>
        </div>
        </form>
    </body>
</html>
