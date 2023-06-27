<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="tweet-mosaic">
    <c:forEach var="t" items="${tweets}">
        <article>
            <div class="tweet-header">
                <div id="${t.uid}" class="tweet-user-div">
                    <img id="enterProfileTag" class="tweet-profile-pic" src="./imgs/content/profile-pic-default.jpg">
                    <p class="tweet-username">${t.uname}</p>
                </div>
                <div class="tweet-bubble-div">
                    <img class="mini-bubble" src="./imgs/content/${t.movie}.jpg" alt="${m}">
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
