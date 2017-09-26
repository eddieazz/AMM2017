<%-- 
    Document   : nav
    Created on : 2-mag-2017, 12.38.47
    Author     : edoar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav>
    <c:set var="pagina" value="bacheca" scope="request"/>
    <ol>
        <li <c:if test="${page=='bacheca'}">class="active"</c:if>><a href="Bacheca">Bacheca</a></li>
        <li <c:if test="${page=='profilo'}">class="active"</c:if>><a href="Profilo">Profilo</a></li>
        </ol>
        <div id="BachecaPersonale" <c:if test="${title == 'bacheca'}">class="active"</c:if>>
            <a href="Bacheca">Bacheca</a>
        </div>
        <div id="ProfiloPersonale" <c:if test="${title == 'profilo'}">class="active"</c:if>>
            <a href="Profilo">Profilo</a>
        </div>
    </div>
    <div id="spazioLogin"> 
        <div class="loggedUser"> 
            <a href="Bacheca?user=${loggedUser.id}">${loggedUser.nome} ${loggedUser.cognome}</a> 
    </div>
    <div class="logout">
        <c:if test="${loggedUser != null}">
            <a href="Login?decisione=logout">Logout</a>
        </c:if>
    </div>
</nav>
