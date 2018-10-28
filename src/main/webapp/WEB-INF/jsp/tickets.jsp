<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/datatablesUtil.js" defer></script>
<script type="text/javascript" src="resources/js/ticketDatatables.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <h3><spring:message code="ticket.title"/></h3>
        <%--<a class="btn btn-primary" onclick="check()">
            <span class="glyphicon glyphicon-alert" aria-hidden="true"></span>
            <spring:message code="common.check"/>
        </a>--%>
        <form class="form-horizontal" id="checkForm">
            <div class="form-group">
                <label for="siteName" class="control-label col-xs-2">
                    <button class="btn btn-primary" type="button" onclick="check()">
                        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                    </button>
                </label>

                <div class="col-xs-9">
                    <input type="text" class="form-control" id="checkSiteName" name="siteName"
                           placeholder="<spring:message code="site.title"/>">

                </div>
            </div>
        </form>
        <table class="table table-striped display" id="datatable">
            <thead>
            <tr>
                <th><spring:message code="ticket.dateTime"/></th>
                <th><spring:message code="ticket.description"/></th>
                <th><spring:message code="site.title"/></th>
            </tr>
            </thead>
            <c:forEach items="${tickets}" var="ticket">
                <jsp:useBean id="ticket" scope="page" type="ru.beginers.hackathon.model.Ticket"/>
                <tr>
                    <td>${fn:formatDateTime(ticket.dateTime)}</td>
                    <td>${ticket.description}</td>
                    <td>${ticket.site.name}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<div class="modal fade" id="addRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title" id="modalTitle"></h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="detailsForm">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="description" class="control-label col-xs-3"><spring:message
                                code="ticket.description"/></label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="description" name="description"
                                   placeholder="<spring:message code="ticket.description"/>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="siteName" class="control-label col-xs-3"><spring:message
                                code="site.title"/></label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="siteName" name="siteName"
                                   placeholder="<spring:message code="site.title"/>">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button class="btn btn-primary" type="button" onclick="save()">
                                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
<jsp:include page="fragments/i18n.jsp"/>
<script type="text/javascript">
    i18n["addTitle"] = '<spring:message code="ticket.add"/>';
    i18n["editTitle"] = '<spring:message code="ticket.edit"/>';
</script>
</html>