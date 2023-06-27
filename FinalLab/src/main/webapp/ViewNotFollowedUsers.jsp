<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="user-list">
    <c:forEach var="u" items="${users}">       
        <div id="${u.id}" class="user-container">
            <img id="enterProfileTag" class="bubble" src="./imgs/content/avatar-2.jpeg" alt="Avatar 2">
            <p class="white-text"> ${u.name} </p>
            <button id="followUserTag" class="follow-btn">Follow</button>
        </div>
    </c:forEach>
</div>