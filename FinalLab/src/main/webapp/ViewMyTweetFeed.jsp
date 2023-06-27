<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="tweet-mosaic">
    <c:forEach var="t" items="${tweets}">
        <article>
            <div class="tweet-header">
                <div class="tweet-user-div">
                    <img class="tweet-profile-pic" src="./imgs/content/avatar-2.jpeg">
                    <p class="tweet-username">${t.uname}</p>
                </div>
                <div id="${t.id}" class="tweet-bubble-div">
                    <btn id="deleteTweetTag" class="delete-tweet">Delete</btn>
                    <img class="mini-bubble" src="./imgs/content/avatar-2.jpeg" alt="Avatar 2">
                </div>
            </div>
            <div class="tweet-body">
                <p class="tweet-content">${t.content}</p>
                <div class="tweet-date-div">
                    <p class="tweet-date">${t.postDateTime}</p>
                </div>
            </div>
        </article>
    </c:forEach>
</div>
