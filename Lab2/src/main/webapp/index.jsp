<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Form </title>
    <style>
        input:focus{
            outline: none;
        }

        body {
            font-family: sans-serif;
            background: azure;
            alignment: center;
        }

    </style>
</head>
<body>

<h1>Registration form...</h1>

<ul class="server-errors-list">
    <c:if test = "${model.error.username}">
        <li> Entered username has been already registered </li>
    </c:if>

    <c:if test = "${model.error.mail}">
        <li> Entered email has been already registered </li>
    </c:if>

    <c:if test = "${model.error.phoneNumber}">
        <li> Entered phone number has been already registered </li>
    </c:if>
</ul>

<form action="RegisterController" id="myform">
    <label for="username"> User name:</label><br>
    <input type="text" id="username" name="username" placeholder="Name" value="${model.username}" onkeyup="checkInput(this)" required><br>
    <label for="mail"> Mail:</label><br>
    <input type="email" id="mail" name="mail" placeholder="Mail" value="${model.mail}" onkeyup="checkInput(this)" required pattern="[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+"><br><br>
    <span class="error"></span>
    <label for="pwd1"> Password: </label><br>
    <input type="password" id="pwd1" name="pwd1" placeholder="Password" onkeyup="checkInput(this)" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$"><br>
    <label for="pwd2"> Confirm Password: </label><br>
    <input type="password" id="pwd2" name="pwd2" placeholder="Confirm Password" onkeyup="checkInput(this)" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$"><br><br>
    <label for="birthday"> Birthday:</label><br>
	<input type="date" id="birthday" name="birthday" value="${model.birthday}" required><br>
	<label for="gender"> Gender: </label><br>
	<select id="gender" name="gender" value="${model.gender}" required>
    <option value="">Choose</option>
    <option value="male">Male</option>
    <option value="female">Female</option>
	</select><br><br>
	<label for="phoneNumber"> Phone Number: </label><br>
	<input type="tel" id="phoneNumber" name="phoneNumber" placeholder="Phone Number" value="${model.phoneNumber}" onkeyup="checkInput(this)" pattern="^(\+34)?[67]\d{8}$"><br>
	<label for="terms">I agree to the Terms & Conditions:</label><br>
	<input type="checkbox" id="terms" name="terms" required><br><br>
	<label for="newsletter">Subscribe to email newsletter:</label><br>
	<input type="checkbox" id="newsletter" name="newsletter" value="${model.newsletter}"><br><br>
	
    <button> Submit </button>
</form>
<script>
    const pwd1 = document.getElementById('pwd1');
    const pwd2 = document.getElementById('pwd2');
    const form = document.getElementById('myform');

    function checkInput(input) {
        if (input.value === ""){
            input.style = ""
        }
        else {
            if (input.validity.typeMismatch || input.validity.patternMismatch){
                input.style = "border: 1px solid red"
            }
            else {
                input.style = "border: 1px solid cornflowerblue"
            }
        }
    }

    pwd2.addEventListener("input", () => {
        if (!checkPasswordEquality(pwd1.value, pwd2.value)) {
            pwd2.setCustomValidity("Passwords must match!");
        } else {
            pwd2.setCustomValidity("");
        }
    });

    form.addEventListener('submit', (event) => {
        if (!this.checkValidity()) {
            this.reportValidity();
            event.preventDefault();
        }
    });

    function checkPasswordEquality(p1, p2){
        return p1 === p2;
    }

</script>
</body>
</html>

