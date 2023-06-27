<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <p class="SubTitle"> Settings </p>
</div>

<div class="white-text">
    <p>Change Username</p>
        <label for="username-change" class="white-text"> Username:</label>
        <input class="form-control" type="text" id="username-change" name="username" placeholder="Username" required autocomplete="username"><br>

        <input id="updateUserTag" class="BlackButton" type="submit" name="sumbit" value="Change username">

</div>

<div class="white-text">
    <p> Change Password</p>
        <label for="pwd1-change" class="white-text"> Password: </label>
        <input class="form-control" type="password" id="pwd1-change" name="pwd" placeholder="Password" required autocomplete="new-password"><br>

        <label for="pwd2-change" class="white-text"> Confirm Password: </label>
        <input class="form-control" type="password" id="pwd2-change" placeholder="Confirm Password" required autocomplete="new-password"><br>

        <input id="updatePasswordTag" class="BlackButton" type="submit" name="sumbit" value="Change password">
</div>

<div class="white-text">
    <c:if test = "${error}">
        <li> There was an error updating the user / password </li>
    </c:if>
</div>
