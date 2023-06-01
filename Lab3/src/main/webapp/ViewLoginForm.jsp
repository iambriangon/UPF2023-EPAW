<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul class="w3-ul w3-red w3-round server-errors-list" style="width:30%">
    <c:if test = "${login.error.user}">
        <li> Entered user is not registered </li>
    </c:if>

    <c:if test = "${login.error.password}">
        <li> Entered password is not valid </li>
    </c:if>
</ul>

<h1 class="w3-bottombar w3-text-black">
    Login
</h1>
<form action="LoginController" method="POST">
	<p>      
        <label class="w3-text-red"><b> Username </b></label>
        <input class="w3-input w3-border w3-light-grey" type="text" name="user" value="${login.user}" required>
    </p>
    <p>
        <label class="w3-text-red"><b> Password</b></label>
        <input class="w3-input w3-border w3-light-grey" type="password" name="password"  required>
    </p>
    <p>
    <input class="w3-btn w3-red" type="submit" name="sumbit" value="Submit"></p>
</form>
