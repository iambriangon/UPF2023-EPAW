<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<script type="text/javascript">
    $(document).ready(function(){

        // Change font of default selected item
        $('.Home').css('font-weight', 500);

        // Load by default Feed Home
        $('#feed-container').load('GetFeedHome');

        // Left bar navvigation pages
        $(document).on("click",".left-nav",function(event) {
            $('#feed-container').load($(this).attr('id'));
            event.preventDefault();
        });

        // Update User
        $(document).on("click", '#updateUserTag', function (event){
            $("#feed-container").load("UpdateUsername",  { content: $('#username-change').val()});
            event.preventDefault();
        });


        // Update Password
        $(document).on("click", '#updatePasswordTag', function (event){
                var pwd1 = $('#pwd1-change')
                var pwd2 = $('#pwd2-change')


                if(!pwd1[0].checkValidity()){
                    pwd1[0].setCustomValidity("Enter the correct password format!");
                    pwd1[0].reportValidity();

                }
                else {
                    if (pwd1.val() !== pwd2.val()){
                        pwd2[0].setCustomValidity("Passwords must match!!");
                        pwd2[0].reportValidity();
                    }
                    else {
                        $("#feed-container").load("UpdatePassword",  { content: pwd1.val()});
                    }
                }
                event.preventDefault();
            }
        );
    });
</script>

<div class="container-fluid h-100">
    <div class="row h-100">
        <div class="BarMenu col-3" style="flex: 0 0 18%; max-width: 18%;">
            <div class="d-flex flex-column h-100">
                <div class="p-2">
                    <img class="Logo img-fluid" src="imgs/logo-white.png" alt="Logo">
                </div>
                <div class="p-2" id="left-bar">
                    <div class="Home left-nav" id="GetFeedHome" onclick="changeFontWeight(this)">Home</div>
                    <div class="Profile left-nav" id="GetProfile" onclick="changeFontWeight(this)">Profile</div>
                    <div class="Explore left-nav" id="GetExplore" onclick="changeFontWeight(this)">Explore</div>
                    <div class="MyMovies" onclick="changeFontWeight(this)">MyMovies</div>
                    <div class="Settings left-nav" id="GetSettings" onclick="changeFontWeight(this)">Settings</div>
                    <div class="LogOut nav-tag" id="LogoutController" onclick="changeFontWeight(this)">Log Out</div>
                </div>
                <div class="mt-auto p-2">
                    <div class="LegalTerms"><a>Legal Terms</a></div>
                    <div class="AboutUs"><a>About Us</a></div>
                    <div class="Privacy"><a>Privacy</a></div>
                    <div class="Copyright">© 2023 Twitflix LLC</div>
                </div>
            </div>
        </div>
        <div class="BigRectangle col-9" id="feed-container" style="flex: 0 0 80%; max-width: 80%;">

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