<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="bubble-list">
    <c:forEach var="m" items="${movies}">
        <div class="bubble-container">
            <img class="bubble" src="./imgs/content/${m}.jpg" alt="${m}">
            <p class="white-text">${m}</p>
        </div>
    </c:forEach>
</div>