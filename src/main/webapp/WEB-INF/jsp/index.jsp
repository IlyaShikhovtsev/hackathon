<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <p/>

        <form method="post" action="users">
            <spring:message code="app.login"/>: <select name="userId">
            <option value="100002" selected>User</option>
            <option value="100003">Admin</option>
        </select>
            <button type="submit"><spring:message code="common.select"/></button>
        </form>
        <ul>
            <li><a href="users"><spring:message code="user.title"/></a></li>
            <li><a href="tickets"><spring:message code="ticket.title"/></a></li>
        </ul>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>