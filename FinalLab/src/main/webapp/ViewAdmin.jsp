<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="white-text" style="padding:20px;width:30%;">
    <h1>Administrator panel</h1>
    <div>
        <h4>Delete tweet</h4>
        <input class="form-control" type="text" id="delete-tweet-admin" name="delete-tweet" placeholder="Enter Tweet Id" required>
        <input id="deleteTweetAdminTag" style="width:40px" class="BlackButton" type="submit" name="submit" value="✓">

    </div>
    <br>
    <div>
        <h4>Delete user</h4>
        <input class="form-control" type="text" id="delete-user-admin" name="delete-user" placeholder="Enter User Id" required>
        <input id="deleteUserAdminTag" style="width:40px" class="BlackButton" type="submit" name="submit" value="✓">
    </div>
    <br>
    <div>
        <h4>Edit user</h4>
        <input class="form-control" type="text" id="user-id-admin" placeholder="Enter User Id" required>
        <input class="form-control" type="text" id="update-user-email-admin" placeholder="Change email">
        <input class="form-control" type="text" id="update-user-phone-admin"  placeholder="Change phone number">
        <input class="form-control" type="text" id="update-user-pwd-admin"  placeholder="Change password">
        <input id="updateUserAdminTag" style="width:40px" class="BlackButton" type="submit" name="submit" value="✓">
    </div>
    <button class="nav-tag" id="LogoutController" style="margin-top:20px;margin-left:5px">Logout</button>
</div>

<ul class="white-text">
    <c:if test = "${error.userid}">
        <li> ${errorMessage.userid} </li>
    </c:if>

    <c:if test = "${error.email}">
        <li> ${errorMessage.email} </li>
    </c:if>

    <c:if test = "${error.phone}">
        <li> ${errorMessage.phone} </li>
    </c:if>

    <c:if test = "${error.pwd}">
        <li> ${errorMessage.pwd} </li>
    </c:if>
</ul>