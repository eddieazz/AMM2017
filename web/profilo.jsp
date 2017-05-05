<%-- 
    Document   : profilo
    Created on : 2-mag-2017, 12.56.12
    Author     : edoar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <title>Profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, AMM">
        <meta name="description" content="Milestone 3 del progetto 2017 di AMM">
        <meta name="author" content="Edoardo Azzaro">
    </head>
    <body>
        <div id="page">
            
            <!--header contenente in titolo della pagina-->
            <c:set var="header" value="Profilo" scope="request"/>
            <jsp:include page="header.jsp"/>
            
            <!--Barra di navigazione tra le pagine del sito-->
            <c:set var="page" value="Profilo" scope="request"/>
            <jsp:include page="nav.jsp"/>
            
            <!--Sidebar contenente utenti e gruppi-->
            <c:set var="sidebar" value="Sidebar" scope="request"/>
            <jsp:include page="sidebar.jsp"/>

            <div id="content">

                <div class="input-form">

                    <form method="post" action="profilo.html">

                        <div>
                        <label for="nome">Nome</label>
                        <input name="nome" id="nome" type="text"/>
                        </div>
                        <label for="nome">Cognome</label>
                        <input name="cognome" id="cognome" type="text"/>
                        <div>
                        <label for="url">URL foto</label>
                        <input name="url" id="url" type="text"/>
                        </div>
                        <label for="data">Data di Nascita</label>
                        <input name="data" id="data" type="date"/>
                        <div>
                        <label for="presentazione">Frase di presentazione</label>
                        <textarea rows=4 cols=20 name="presentazione" id="presentazione"></textarea>
                        </div>
                        <label for="password">Password</label>
                        <input name="password" id="password" type="text"/>
                        <div>
                        <label for="password2">Conferma Password</label>
                        <input name="password2" id="password2" type="text"/>
                        </div>
                        <input type="submit" value="Iscriviti"/>
                    </form>
                </div>
            </div>    
        </div>
    </body>
</html>
