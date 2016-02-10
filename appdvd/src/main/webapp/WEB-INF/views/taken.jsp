<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8"%>
<jsp:include page="header.jsp"/>
	<table>
            <thead>
                <tr>
                    <th>Взятые диски:</th>
                </tr>
            </thead>
            <tbody>
		<c:forEach var="disk" items="${disks}">
			<tr>
                            <form:form action="taken" method="post" modelAttribute="disk">
                                <td>
                                    <c:out value="${disk.diskTitle}" />
                                    <form:input path="diskId" type="hidden" name="disk_id" value="${disk.diskId}" /> 
                                </td>
                                <td>
                                    <input type="submit" value="Отдать" />
                                </td>
                            </form:form>
			</tr>
		</c:forEach>
            </tbody>
	</table>
<c:if test="${not empty message}">
    <div id="message">${message}</div>
</c:if> 
<jsp:include page="footer.jsp"/>
