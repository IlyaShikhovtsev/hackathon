<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="div-header clearfix">
    <div class="login">
        <center>
            <div class="authoriz">
                <h1>Авторизация:</h1>
                <input name="who" placeholder="Логин" type="text">
                <input name="realwho" placeholder="Пароль" type="password">
                <a href="tickets">
                    <div class="div-text">
                        <label>Войти</label>
                    </div>
                </a>
                <a href="/join" class="a-padd">
                    <div class="div-text">Регистрация</div>
                </a>
            </div>
        </center>
    </div>
</div>

<%--
<header>
    <a href="${pageContext.request.contextPath}/">
        <spring:message code="app.home"/>
    </a>&nbsp;|&nbsp;
    <a href="tickets">
    <spring:message code="app.title"/>
    </a>
</header>--%>
