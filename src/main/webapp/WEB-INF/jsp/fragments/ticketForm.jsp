<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="menu clearfix">
    <tr>
        <td>
            <label>Site: </label>
        </td>
        <td>
            <input name="siteInput" placeholder="Ссылка на сайт" type="text">
        </td>
    </tr>
    <tr>
        <td>
            <label>Description: </label>
        </td>
        <td>
            <input name="descriptionInput" placeholder="Описание для заявки" type="text">
        </td>
    </tr>
</div>