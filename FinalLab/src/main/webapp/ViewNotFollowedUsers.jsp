<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="user-list">
    <c:forEach var="u" items="${users}">       
        <div id="${u.id}" class="user-container">
            <img id="enterProfileTag" class="bubble" src="./imgs/content/profile-pic-default.jpg" alt="${u.name}">
            <p class="white-text"> ${u.name} </p>
            <button id="followUserTag" class="follow-btn">Follow</button>
        </div>
    </c:forEach>
</div>