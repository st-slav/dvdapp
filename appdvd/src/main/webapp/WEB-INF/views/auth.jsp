<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false"%>
<html>
    <head>
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="/main/resources/style/style.css">
        <style>
            #avt
            {
                text-align: center;
                height: 133px;
                width:270px;
                margin:200px auto;
                border:1px solid black;
                padding: 21px;
            }
            .error{
                color:red;
            }
        </style>
    </head>
    <body>
        <sec:authorize access="isAnonymous()">            
            <form action="/j_spring_security_check" method="post" id="avt">
                <span id="aTitle"> Авторизация </span>
                <div class="error">${message}</div>
                <table>
                    <tr>
                        <td>Логин:</td>
                        <td><input name="j_username" type="text" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Пароль:</td>
                        <td><input name="j_password" type="password" required="required"/></td>
                    </tr>
                </table>
                <input type="submit" value ="Войти"/>
            </form>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <div>Вы уже авторизованы, необходимо <a href="logout">выйти</a></div>
        </sec:authorize>
    </body>
</html>