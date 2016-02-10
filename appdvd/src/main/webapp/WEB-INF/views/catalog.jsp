<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8"%>
<jsp:include page="header.jsp"/>
 <table>
    <thead>
        <tr>
            <th>Свободные диски:</th>
        </tr>
    </thead>
  <c:forEach var="disk" items="${disks}">
   <tr>
        <form:form action="catalog" method="post" modelAttribute="disk">
        <td>
            <c:out value="${disk.diskTitle}" />
        </td>
        <td>
            <form:input type="hidden" path="diskId" name="disk_id" value="${disk.diskId}" /> 
            <input type="submit" value="Взять" />
        </td>
        </form:form>
   </tr>
  </c:forEach>
 </table>
<c:if test="${not empty message}">
    <div id="message">${message}</div>
</c:if> 
<jsp:include page="footer.jsp"/>