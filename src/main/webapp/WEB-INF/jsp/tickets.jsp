<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <h3><spring:message code="ticket.title"/></h3>

    <hr>
    <a href="tickets/create"><spring:message code="ticket.add"/></a>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th><spring:message code="ticket.dateTime"/></th>
            <th><spring:message code="ticket.description"/></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${tickets}" var="ticket">
            <jsp:useBean id="ticket" scope="page" type="ru.beginers.hackathon.model.Ticket"/>
            <tr>
                <td>
                        <%--${ticket.dateTime.toLocalDate()} ${ticket.dateTime.toLocalTime()}--%>
                        <%--<%=TimeUtil.toString(ticket.getDateTime())%>--%>
                        <%--${fn:replace(ticket.dateTime, 'T', ' ')}--%>
                        ${fn:formatDateTime(ticket.dateTime)}
                </td>
                <td>${ticket.description}</td>
                <td>${ticket.status}</td>
                <td>${ticket.site}</td>
                <td><a href="tickets/update?id=${ticket.id}"><spring:message code="common.update"/></a></td>
                <td><a href="tickets/delete?id=${ticket.id}"><spring:message code="common.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>