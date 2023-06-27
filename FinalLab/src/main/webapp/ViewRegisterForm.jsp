<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul class="" style="width:30%">
    <c:if test = "${user.error.name}">
        <li> Entered username has been already registered </li>
    </c:if>

    <c:if test = "${user.error.mail}">
        <li> Entered email has been already registered </li>
    </c:if>

    <c:if test = "${user.error.phoneNumber}">
        <li> Entered phone number has been already registered </li>
    </c:if>
</ul>

<div class="container-fluid h-100">
    <div class="row h-100">
        <div class="LeftSide col-2"></div>
        <div class="LandingCenter col-8 align-items-center">
            <div class="row" style="min-height: 5%; max-height: 5%;"></div>
            <form class= "align-items-center" action="RegisterController" id="regform" method="POST" style="max-width: 60%">
                <p>
                    <label for="name" class="white-text"> Username:</label>
                    <input class="form-control" type="text" id="name" name="name" placeholder="Username" value="${user.name}" required autocomplete="username"><br>

                    <label for="mail" class="white-text"> Mail: </label>
                    <input class="form-control" type="email" id="mail" name="mail" placeholder="Mail" value="${user.mail}" required pattern="[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+" autocomplete="email"><br>

                    <label for="pwd1" class="white-text"> Password: </label>
                    <input class="form-control" type="password" id="pwd1" name="pwd" placeholder="Password" value="${user.pwd}" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$" autocomplete="new-password"><br>

                    <label for="pwd2" class="white-text"> Confirm Password: </label>
                    <input class="form-control" type="password" id="pwd2" placeholder="Confirm Password" oninput="checkValidPassword(this)" required autocomplete="new-password"><br>

                    <label for="birthday" class="white-text">Birthday: </label>
                    <input class="form-control" type="date" id="birthday" name="birthday" oninput="checkValidAge(this)" required><br>

                    <label for="gender" class="white-text">Gender: </label>
                    <select class="form-select" id="gender" name="gender" required>
                        <option value="" disabled selected>Choose</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select><br>

                    <label for="phoneNumber" class="white-text">Phone number: </label>
                    <input class="form-control" placeholder="6/7XXXXXXXX" type="tel" id="phoneNumber" name="phoneNumber" pattern="^[67]\d{8}$"><br>

                    <label for="terms" class="form-check-label white-text">I agree to the Terms & Conditions: </label>
                    <input class="form-check-input" type="checkbox" id="terms" name="terms" onclick="setCheckbox(this)" required><br>

                    <label for="newsletter" class="form-check-label white-text">Subscribe to email newsletter:</label>
                    <input class="form-check-input" type="checkbox" id="newsletter" name="newsletter" onclick="setCheckbox(this)"><br>

                    <input class="BlackButton" type="submit" name="sumbit" value="Submit">
                </p>
            </form>

        </div>
        <div class="RightSide col-2"></div>
    </div>
</div>

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