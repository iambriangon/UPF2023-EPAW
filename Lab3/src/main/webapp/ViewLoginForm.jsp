<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="LoginController" method="POST">
	<p>      
        <label class="w3-text-red">User name:</label>
        <input class="w3-input w3-border w3-light-grey" type="text" name="user" value="${login.user}">
    </p>
    <p>
        <label class="w3-text-red">Password:</label>
        <input class="w3-input w3-border w3-light-grey" type="text" name="password" value="${login.password}">
    </p>
    <p>
        <input class="w3-btn w3-red" type="submit" name="sumbit" value="Login">
    </p>
</form>