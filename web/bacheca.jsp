<%-- 
    Document   : bacheca
    Created on : 1-mag-2017, 19.10.02
    Author     : edoar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                                
                <div id="formNewPost">
                    <form action="servlet.java" method="post" >
                        <div>
                            <label for="textPost">Testo nuovo post</label>
                            <input type="text" name="postType" value="textType" id="textType">
                        </div>
                        <div>
                            <label for="urlPost">URL allegato</label>
                            <input type="text" name="postType" value="urlType"  id="urlType">
                        </div>

                        <div>
                            <label for="imgType">Post con Foto</label>
                            <input type="radio" name="postType" value="imgType" id="imgType">
                            <label for="linkType">Link</label>
                            <input type="radio" name="postType" value="linkType" id="linkType">
                        </div>
                        <br>
                        <br>
                        <input type="submit" value="Crea Post"/>
                    </form>
                </div>
               
                <br />
                <br />
                
                <!--lista dei post-->
                <div id="posts">
                    <c:forEach var="post" items="${posts}">
                        <div class="post">
                            <c:if test="${post.postType == 'TEXT'}">
                                <p>${post.content}</p>
                            </c:if>
                            <c:if test="${post.postType == 'IMAGE'}">
                                <img alt="Post con foto" src="${post.content}">
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
                
            </div>            
        </div>
    </body>
</html>
