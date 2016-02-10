<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Номер диска</th>
                    <th>Название диска</th>
                    <th>Кто взял</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="disk" items="${disks}">
                    <tr>
                        <td>${disk.diskId}</td>
                        <td>${disk.diskTitle}</td>
                        <td>${disk.userTaken.userLogin}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
