<%-- 
    Document   : bacheca
    Created on : 1-mag-2017, 19.10.02
    Author     : edoar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:set var="title" value="Bacheca" scope="request"/>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <title>Bacheca</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, AMM">
        <meta name="description" content="Milestone 3 del progetto 2017 di AMM">
        <meta name="author" content="Edoardo Azzaro">
    </head>
    <body>
        <div id="page">

            <!--header contenente in titolo della pagina-->
            <c:set var="header" value="Bacheca Personale" scope="request"/>
            <jsp:include page="header.jsp"/>
            
            <!--Barra di navigazione tra le pagine del sito-->
            <c:set var="page" value="Bacheca" scope="request"/>
            <jsp:include page="nav.jsp"/>

            <!--Sidebar contenente utenti e gruppi-->
            <c:set var="sidebar" value="Sidebar" scope="request"/>
            <jsp:include page="sidebar.jsp"/>
            
            <div id="content">
                <jsp:include page="nuovopost.jsp"/>
                <!--lista dei post-->
                <div id="posts">
                    <c:forEach var="post" items="${posts}">
                        <div class="post">
                            <p class="autorepost">${post.getUser().nome} ${post.getUser().cognome}</p>
                            <form action="Bacheca" method="post">
                                <div class="formcancellapost">
                                    <c:if test="${loggedUser.getNomeCognome() == post.getUser().getNomeCognome()}">
                                        <button type="submit" id="cancellapost" name="cancellapost" value="${post.getId()}">X</button>
                                    </c:if>
                                </div>
                            </form>
                            <p>${post.contenutoPost}</p>
                            <c:if test="${post.postType == 'IMAGE'}">
                                <img id="immagini" src="${post.imagePost}"  alt="Post con foto">
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
                
            </div>            
        </div>
    </body>
</html>
