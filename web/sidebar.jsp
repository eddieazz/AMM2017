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
            <c:if test="${amiciUtente.getId() != loggedUser.getId()}">
            <div id="elencoamici">
                <p class="spaPersone"><a href="Bacheca?user=${amiciUtente.id}">${amiciUtente.nome} ${amiciUtente.cognome}</a></p>
            </div>
        </c:if>
        </c:forEach>
    </ul>
    <c:forEach var="gruppi" items="${gruppiutente}">
        <div id="elencoGruppi">
            <p class="spaGruppi">${gruppi.nomeGruppo} ${[gruppi.amministratore.nome]}</p>
        </div>
        <c:forEach var="users" items="${gruppi.membri}">
            <div class="partecipanteGruppo">
                ${users.nome}             
            </div>
        </c:forEach>
    </c:forEach>

</div>