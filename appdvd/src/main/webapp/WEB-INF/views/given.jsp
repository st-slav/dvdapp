<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=UTF-8"%>
<jsp:include page="header.jsp" />
<table>
    <tr>
        <th>Название</th>
        <th>Кто взял</th>
    </tr>
	<c:forEach var="disk" items="${disks}">
            <tr>
                <td>${disk.diskTitle}</td>
                <td>${disk.userTaken.userLogin}</td>
            </tr>
	</c:forEach>
</table>
<jsp:include page="footer.jsp" />