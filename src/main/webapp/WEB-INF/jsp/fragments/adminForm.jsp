<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="trade-block clearfix">
    <c:if test="${!empty listTicketsAdmin}">
    <table class="tg">
        <tr>
            <th width="80">Person ID</th>
            <th width="120">Person Name</th>
            <th width="120">Person Country</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listTicketsAdmin}" var="ticket">
            <tr>
                <td>${ticket.id}</td>
                <td>${ticket.date}</td>
                <td>${ticket.description}</td>
                <td><a href="<c:url value='/accept/${ticket.id}' />" >Accept</a></td>
                <td><a href="<c:url value='/decline/${ticket.id}' />" >Decline</a></td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
</div>
