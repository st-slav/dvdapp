<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8"%>
<jsp:include page="header.jsp"/>
<div class="add">
<form:form modelAttribute="disk" method="post" action="create">
    <label for="disk_title">Введите название:</label>
    <form:input path="diskTitle" type="text" required="required" id="disk_title" autocomplete="off"/>
    <input type="submit" value="Добавить"/>
</form:form>
<c:if test="${not empty message}">
    <div id="message" class="error">${message}</div>
</c:if>
</div>
<jsp:include page="footer.jsp"/>