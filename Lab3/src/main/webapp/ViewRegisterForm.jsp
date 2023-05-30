<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<ul class="server-errors-list">
    <c:if test = "${user.error.username}">
        <li> Entered username has been already registered </li>
    </c:if>

    <c:if test = "${user.error.mail}">
        <li> Entered email has been already registered </li>
    </c:if>

    <c:if test = "${user.error.phoneNumber}">
        <li> Entered phone number has been already registered </li>
    </c:if>
</ul>


<h1 class="w3-text-black">Registration form</h1>
<form action="RegisterController" method="POST">

    <p>
        <label class="w3-text-red" for="username"> User name:</label>
        <input class="w3-input w3-border w3-light-grey" type="text" id="username" name="username" placeholder="Name" value="${user.username}"  required>
    </p>

    <p>
        <label class="w3-text-red" for="mail"> Mail:</label>
        <input class="w3-input w3-border w3-light-grey" type="email" id="mail" name="mail" placeholder="Mail" value="${user.mail}" required pattern="[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+">
    </p>

    <p>
        <label class="w3-text-red" for="pwd1"> Password: </label>
        <input class="w3-input w3-border w3-light-grey" type="password" id="pwd1" name="pwd1" placeholder="Password" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$">
    </p>

    <p>
        <label class="w3-text-red" for="pwd2"> Confirm Password: </label>
        <input class="w3-input w3-border w3-light-grey" type="password" id="pwd2" name="pwd2" placeholder="Confirm Password" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$">
    </p>

    <p>
        <label class="w3-text-red" for="birthday"> Birthday:</label>
        <input class="w3-input w3-border w3-light-grey" type="date" id="birthday" name="birthday" value="${user.birthday}" required>
    </p>

    <p>
        <label class="w3-text-red" for="gender"> Gender: </label>
        <select class="w3-select w3-border w3-light-grey" id="gender" name="gender" value="${user.gender}" required>
            <option value="">Choose</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
        </select>
    </p>

    <p>
        <label class="w3-text-red" for="phoneNumber"> Phone Number: </label>
        <input class="w3-input w3-border w3-light-grey" type="tel" id="phoneNumber" name="phoneNumber" placeholder="Phone Number" value="${user.phoneNumber}" pattern="^[67]\d{8}$">
    </p>

    <p>
        <label class="w3-text-red" for="terms">I agree to the Terms & Conditions:</label>
        <input class="w3-check"  type="checkbox" id="terms" onclick="setCheckbox(this)" name="terms" required>
    </p>

    <p>
        <label class="w3-text-red" for="newsletter">Subscribe to email newsletter:</label>
        <input class="w3-check"  type="checkbox" id="newsletter" name="newsletter" onclick="setCheckbox(this)" value="${user.newsletter}">
    </p>

    <p>
        <input class="w3-btn w3-red" type="submit" name="sumbit" value="Register">
    </p>

</form>

