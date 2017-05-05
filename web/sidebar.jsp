<%-- 
    Document   : sidebar
    Created on : 5-mag-2017, 9.39.41
    Author     : edoar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="sidebar">
    <ul>
        <li><h3>Persone</h3></li>
        <c:forEach var="user" items="${users}">
            <p>${user.nome}</p>
        </c:forEach>
    </ul>

    <ul>
        <li><h3>Gruppi</h3></li>
        <li><a href="profilo.html">Castlemaniaci</a></li>
        <li><a href="profilo.html">Calistenici</a></li>
    </ul>

</div>