<%-- 
    Document   : descrizione
    Created on : 2-mag-2017, 13.02.20
    Author     : edoar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <title>Descrizione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, AMM">
        <meta name="description" content="Milestone 3 del progetto 2017 di AMM">
        <meta name="author" content="Edoardo Azzaro">
    </head>
    <body>
        <div id="page">
            
            <!--header contenente in titolo della pagina-->
            <c:set var="header" value="Descrizione" scope="request"/>
            <jsp:include page="header.jsp"/>
            
            <div id="sidebar">
            <ul>
                <li><h3>Navigazione</h3></li>
                <li><a href="#titolo">Vai al Titolo</a></li>
                <li><a href="#social">Vai alla spiegazione</a></li>
                <li><a href="#login">Vai al login</a></li>
            </ul>
            </div>
            
            <div id="content">
                <a id='titolo'>
                    <h1>Nerdbook</h1>
                </a>
                <p>Il nuovo Social Network che tutti voi stavate aspettando!</p>

                <a id='whatisit'>
                    <h2>What is it?</h2>
                </a>

                <a id='social'>
                    <h3>Non il solito Social...</h3>
                </a>
                <p>Nerdbook è una nuova piattaforma Social, pensata per tutti quegli utenti stanchi di tutte le feautures superflue che si stanno espandendo nei soliti social! <br />
                    Per iscriversi basterà compilare un semplice form coi dati richiesti, e potrai da subito chattare coi tuoi amici o scrivere nei gruppi dei tuoi hobbies.<br />
                    Il servizio è totalmente gratuito, non verrà perciò mai richiesto di inserire i dati di una carta di credito ;) </p>
                <br />
                <hr />
                <nav>
                    <a id='login'>
                        <h2>LOGIN</h2>
                    </a>
                    <p>Per fare il Login premi <a href="login.html">QUI</a></p>
                </nav>
            </div>
        </div>
    </body>
</html>
