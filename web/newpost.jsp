<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<div class="newpost">
    <form action="Bacheca" method="post">
        <div>
            <label id="scrittaPubblicaPost">Pubblica Post</label>
            <div class="pronuovopost">
                <textarea name="postditesto" id="textPost" placeholder="Contenuto..."></textarea>
            </div>
            <div class="pronuovopost">
                <label id="imgfile">File d'immagine</label>
                <input name="postimmagine" type="IMAGE" id="imagePost">
            </div>
        </div>
        <button type="submit" id="pubblicaPost" name="pubblicapost" value="si">Pubblica</button>
        <c:choose>
            <c:when test="${postpubblicatoconsuccesso == true}">
                Post Pubblicato
            </c:when>
            <c:otherwise>
                ${postvuoto} 
            </c:otherwise>
        </c:choose>
    </form>     
</div>