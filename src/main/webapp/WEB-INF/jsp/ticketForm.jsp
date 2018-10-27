<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <jsp:useBean id="ticket" type="ru.beginers.hackathon.model.Ticket" scope="request"/>
    <h3><spring:message code="${ticket.isNew() ? 'ticket.add' : 'ticket.edit'}"/></h3>
    <hr>
    <form method="post" action="tickets">
        <input type="hidden" name="id" value="${ticket.id}">
        <dl>
            <dt><spring:message code="ticket.dateTime"/>:</dt>
            <dd><input type="datetime-local" value="${ticket.dateTime}" name="dateTime" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="ticket.description"/>:</dt>
            <dd><input type="text" value="${ticket.description}" size=40 name="description" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="ticket.state"/>:</dt>
            <dd><input type="text" value="${ticket.status}" size=40 name="status" required></dd>
        </dl>
        <button type="submit"><spring:message code="common.save"/></button>
        <button onclick="window.history.back()" type="button"><spring:message code="common.cancel"/></button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
