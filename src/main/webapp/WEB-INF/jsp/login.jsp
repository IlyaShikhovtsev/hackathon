<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header navbar-brand"><spring:message code="app.title"/></div>
        <div class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" id="login-form" role="form" action="spring_security_check" method="post">
                <div class="form-group">
                    <input type="text" id="username" placeholder="Login" class="form-control" name="username">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Password" class="form-control" name="password">
                </div>
                <button type="submit" class="btn btn-success">
                    <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                </button>
            </form>
        </div>
    </div>
</div>

<div class="jumbotron">
    <div class="container">
        <c:if test="${param.error}">
            <div class="error">
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>
        <c:if test="${not empty param.message}">
            <div class="message">
                <spring:message code="${param.message}"/>
            </div>
        </c:if>
        <br/>
        <p>
            <button type="submit" class="btn btn-lg btn-primary" onclick="setCredentials('User1', 'password')">
                <spring:message code="app.enter"/> User1
            </button>
            <button type="submit" class="btn btn-lg btn-primary" onclick="setCredentials('User2', 'password')">
                <spring:message code="app.enter"/> User2
            </button>
            <button type="submit" class="btn btn-lg btn-primary" onclick="setCredentials('Admin', 'admin')">
                <spring:message code="app.enter"/> Admin
            </button>
        </p>
        <br/>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
<script type="text/javascript">
    function setCredentials(username, password) {
        $('input[name="username"]').val(username);
        $('input[name="password"]').val(password);
        var ajaxUrl = "ajax/profile/ticket/";
        $.ajax({
            type: "GET",
            url: ajaxUrl + "userId/" + $('#username').val(),
        });
    }
</script>
</body>
</html>