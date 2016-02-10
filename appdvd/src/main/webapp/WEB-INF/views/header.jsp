<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ page session="false"%>
<html>
    <head>
        <title>Home</title>
        <!--<link rel="stylesheet" type="text/css" href="/WEB-INF/views/style.css">-->
        <style type="text/css">
            input {
                border-bottom-style: 10px;
            }
            .menu_str {
                list-style:none;                
            }
            .menu_str div {
                display: inline-block;
                width:125px;
                height:30px;
                text-align: center;
                vertical-align: middle;
            }
            .space{
                height: 30px;
            }
            .error{
                color:red;
                margin: 0 auto;
            }
            table {
                margin: 0 auto;
            }
            .add {
                margin-left: 35%;
            }
            .menu {
                margin-left: 28%;
            }
        </style>
    </head>
    <body>
        <div class="menu">
            <div class="menu_str">
                    <a href="create"><div>Добавить</div></a>
                    <a href="catalog"><div>Свободные диски</div></a>
                    <a href="taken"><div>Взятые диски</div></a>
                    <a href="given"><div>Отданые диски</div></a>
                    <a href="logout"><div>Выход</div></a>
            </div>
        </div>    
        <hr>