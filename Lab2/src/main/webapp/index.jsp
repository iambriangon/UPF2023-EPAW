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
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        label {
            padding-top: 12px;
        }

        button {
            margin-top: 16px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        input {
            border-radius: 4px;
            border: 1px solid lightgrey;
        }

        .check {
            flex-direction: row;
            margin-top: 8px;
        }

    </style>
</head>
<body>



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


<h1>Registration form</h1>
<form action="RegisterController" id="myform">
    <label for="username"> User name:</label>
    <input type="text" id="username" name="username" placeholder="Name" value="${model.username}" onkeyup="checkInput(this)" required>
    <label for="mail"> Mail:</label>
    <input type="email" id="mail" name="mail" placeholder="Mail" value="${model.mail}" onkeyup="checkInput(this)" required pattern="[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+">
    <span class="error"></span>
    <label for="pwd1"> Password: </label>
    <input type="password" id="pwd1" name="pwd1" placeholder="Password" onkeyup="checkInput(this)" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$">
    <label for="pwd2"> Confirm Password: </label>
    <input type="password" id="pwd2" name="pwd2" placeholder="Confirm Password" onkeyup="checkInput(this)" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$">
    <label for="birthday"> Birthday:</label>
	<input type="date" id="birthday" name="birthday" value="${model.birthday}" onchange="checkInput(this)" required>
	<label for="gender"> Gender: </label>
	<select id="gender" name="gender" value="${model.gender}" required>
    <option value="">Choose</option>
    <option value="male">Male</option>
    <option value="female">Female</option>
	</select>
	<label for="phoneNumber"> Phone Number: </label>
	<input type="tel" id="phoneNumber" name="phoneNumber" placeholder="Phone Number" value="${model.phoneNumber}" onkeyup="checkInput(this)" pattern="^[67]\d{8}$">
	<div class="check">
        <label for="terms">I agree to the Terms & Conditions:</label>
        <input type="checkbox" id="terms" onclick="setCheckbox(this)" name="terms" required>
    </div>
    <div class="check">
        <label for="newsletter">Subscribe to email newsletter:</label>
        <input type="checkbox" id="newsletter" name="newsletter" onclick="setCheckbox(this)" value="${model.newsletter}">
    </div>
    <button> Submit </button>
</form>


<script>
    const pwd1 = document.getElementById('pwd1');
    const pwd2 = document.getElementById('pwd2');
    const form = document.getElementById('myform');
    const birthday = document.getElementById("birthday");

    function setCheckbox(input) {
        input.value = input.checked;
    }

    function ageRegistrationCheck(input) {
            today = new Date();
            min_age = new Date(today.getFullYear() - 120, today.getMonth(), today.getDate());
            max_age = new Date(today.getFullYear() - 14, today.getMonth(), today.getDate());

            dateSelected = new Date(input.value);
            return max_age >= dateSelected && dateSelected >= min_age;
    }

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

    function checkPasswordEquality(p1, p2){
        return p1 === p2;
    }

    pwd2.addEventListener("input", () => {
        if (!checkPasswordEquality(pwd1.value, pwd2.value)) {
            pwd2.setCustomValidity("Passwords must match!");
        } else {
            pwd2.setCustomValidity("");
        }
    });


    birthday.addEventListener("input", () => {
        if (!ageRegistrationCheck(birthday)) {
            birthday.setCustomValidity("To use this service you must be between 14 and 120 years old!!");
        } else {
            birthday.setCustomValidity("");
        }
    });

    form.addEventListener('submit', (event) => {
        if (!this.checkValidity()) {
            this.reportValidity();
            event.preventDefault();
        }
    });


</script>
</body>
</html>

