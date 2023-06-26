<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<div class="container-fluid h-100">
    <div class="row h-100">
        <div class="BarMenu col-3" style="flex: 0 0 18%; max-width: 18%;">
            <div class="d-flex flex-column h-100">
                <div class="p-2">
                    <img class="Logo img-fluid" src="imgs/logo-white.png" alt="Logo">
                </div>
                <div class="p-2" id="left-bar">
                    <div class="Home" onclick="changeFontWeight(this)">Home</div>
                    <div class="Profile" onclick="changeFontWeight(this)">Profile</div>
                    <div class="Explore" onclick="changeFontWeight(this)">Explore</div>
                    <div class="MyMovies" onclick="changeFontWeight(this)">MyMovies</div>
                    <div class="Settings" onclick="changeFontWeight(this)">Settings</div>
                </div>
                <div class="mt-auto p-2">
                    <div class="LegalTerms"><a>Legal Terms</a></div>
                    <div class="AboutUs"><a>About Us</a></div>
                    <div class="Privacy"><a>Privacy</a></div>
                    <div class="Copyright">© 2023 Twitflix LLC</div>
                </div>
            </div>
        </div>
        <div class="BigRectangle col-9" style="flex: 0 0 80%; max-width: 80%;">

        </div>
    </div>
</div>

<script>
    function changeFontWeight(elem){
        for (const element of document.getElementById("left-bar").children){
            element.style.fontWeight = 300;
            console.log(element);
        }
        elem.style.fontWeight = 500;
    }
</script>