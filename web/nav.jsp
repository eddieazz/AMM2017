<%-- 
    Document   : nav
    Created on : 2-mag-2017, 12.38.47
    Author     : edoar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav>
    <ol>
        <li <c:if test="${page=='bacheca'}">class="active"</c:if>><a href="Bacheca">Bacheca</a></li>
        <li <c:if test="${page=='profilo'}">class="active"</c:if>><a href="Profilo">Profilo</a></li>
    </ol>
</nav>
