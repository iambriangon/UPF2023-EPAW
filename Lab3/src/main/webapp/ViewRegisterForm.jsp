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

<h1 class="w3-bottombar w3-text-black">
    Registration Form
</h1>
<form action="RegisterController" method="POST">
	<p>      
        <label class="w3-text-red"><b> Username </b></label>
        <input class="w3-input w3-border w3-light-grey" placeholder="myusername" type="text" name="username" value="${user.username}" required>
    </p>
    <p>      
        <label class="w3-text-red"><b> Mail address </b></label>
        <input class="w3-input w3-border w3-light-grey" placeholder="example@domain.com" type="email" name="mail" value="${user.mail}" required pattern="[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+">
    </p>
    <p>
        <label class="w3-text-red"><b> Password </b></label>
        <input class="w3-input w3-border w3-light-grey" id="pwd1" type="password" name="pwd1" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$">
    </p>
    <p>
        <label class="w3-text-red"><b> Repeat password </b></label>
        <input class="w3-input w3-border w3-light-grey" type="password" name="pwd2" oninput="checkValidPassword(this)" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$">
    </p>
    <p>
        <label class="w3-text-red"><b> Birthday </b></label>
        <input class="w3-input w3-border w3-light-grey" type="date" name="birthday" oninput="checkValidAge(this)" required>
    </p>
    <p>
        <label class="w3-text-red"><b> Gender </b></label>
        <select class="w3-select w3-border w3-light-grey" name="gender" required>
            <option value="" disabled selected>Choose</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
        </select>
    </p>
    <p>
        <label class="w3-text-red"><b> Phone number </b></label>
        <input class="w3-input w3-border w3-light-grey" placeholder="6/7XXXXXXXX" type="tel" name="phoneNumber" required pattern="^[67]\d{8}$">
    </p>
    <p>
        <label class="w3-text-red">I agree to the Terms & Conditions:</label>
        <input class="w3-check" type="checkbox" name="terms" onclick="setCheckbox(this)" required>
    </p>

    <p>
        <label class="w3-text-red">Subscribe to email newsletter:</label>
        <input class="w3-check" type="checkbox" name="newsletter" onclick="setCheckbox(this)">
    </p>
    <p>
        <input class="w3-btn w3-red" type="submit" name="sumbit" value="Submit">
    </p>
</form>

<script>

    function setCheckbox(input) {
        input.value = input.checked;
    }

    function checkValidPassword(pwd2) {
        var pwd1 = document.getElementById('pwd1');
        if (!isEqualPassword(pwd1.value, pwd2.value)) {
            pwd2.setCustomValidity("Passwords must match!!");
        } else {
            pwd2.setCustomValidity("");
        }
    }

    function isEqualPassword(pwd1, pwd2) {
        return pwd1 === pwd2;
    }

    function checkValidAge(birthday) {
        if (!ageRegistrationCheck(birthday)) {
            birthday.setCustomValidity("To use this service you must be between 14 and 120 years old!!");
        } else {
            birthday.setCustomValidity("");
        }
    }

    function ageRegistrationCheck(input) {
        var today = new Date();
        var min_age = new Date(today.getFullYear() - 120, today.getMonth(), today.getDate());
        var max_age = new Date(today.getFullYear() - 14, today.getMonth(), today.getDate());
        var dateSelected = new Date(input.value);
        return max_age >= dateSelected && dateSelected >= min_age;
    }

</script>