<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br>
<p class="SubTitle"> MyMovies </p>
<h6 class="white-text">Movies and TV shows you interacted with</h6>

<c:forEach var="m" items="${movies}">
    <div class="movie-card">
        <img class="movie-card-pic" src="./imgs/content/${m}.jpg">
        <p class="movie-card-name white-text">${m}</p>
    </div>
</c:forEach>