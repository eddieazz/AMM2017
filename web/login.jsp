<%-- 
    Document   : login
    Created on : 2-mag-2017, 12.16.30
    Author     : edoar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <title>LOGIN</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="JSP, AMM">
        <meta name="description" content="Milestone 3 del progetto 2017 di AMM">
        <meta name="author" content="Edoardo Azzaro">
    </head>
    <body>
        <div id="page">
            <c:set var="header" value="Login" scope="request"/>
            <jsp:include page="header.jsp"/>

            <div id="content">
                
                <c:if test="${invalidData == true}">
                    <div id="invalidDataWarning">I dati inseriti non sono validi</div>
                </c:if>
                    
                <h2>LOGIN</h2>
                <form action="Login" method="post" >
                    <div class="riga">
                        <label for="userName">Nome utente</label>
                        <input type="text" id="userName" name="username"/>
                    </div>
                    <div class="riga">
                        <label for="userPass">Password</label>
                        <input type="password" id="userPass" name="password"/>
                    </div><br />
                    <input type="submit" value="Login"/>
                </form>
            </div>
        </div>
    </body>
</html>