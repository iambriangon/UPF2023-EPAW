<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<script type="text/javascript">
    $(document).ready(function(){
        // Load by default Feed Home
        $('#feed-container').load('GetFeedHome');

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
                    <div class="Home nav-tag" id="MainController">Landing Page</div>
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