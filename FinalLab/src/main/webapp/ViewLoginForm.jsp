<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul class="" style="width:30%">
    <c:if test = "${error}">
        <li> Password is not valid for the username: "${user.name}" </li>
    </c:if>
</ul>

<div class="container-fluid h-100">
    <div class="row h-100">
        <div class="LeftSide col-2"></div>
        <div class="LandingCenter col-8 align-items-center">
            <div class="row" style="min-height: 5%; max-height: 5%;"></div>
            <form action="LoginController" method="POST">
                <p>
                    <label for="name" class="white-text"> Username: </label><br>
                    <input class="form-control" type="text" id="name" name="name" placeholder="Username" value="${user.name}" required autocomplete="username"><br>
                    <label for="pwd1" class="white-text"> Password: </label><br>
                    <input class="form-control" type="password" id="pwd1" name="pwd" placeholder="Password" value="${user.pwd}" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$" autocomplete="current-password"><br><br>
                    <input class="w3-btn w3-theme BlackButton" type="submit" name="sumbit" value="Submit"></p>
            </form>
        </div>
        <div class="RightSide col-2"></div>
    </div>
</div>