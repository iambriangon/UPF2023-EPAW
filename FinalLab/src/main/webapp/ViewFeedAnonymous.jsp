<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<script type="text/javascript">
    $(document).ready(function() {
        // Change font of default selected item
        $('.Home').css('font-weight', 500);

        // Load by default Feed Home
        $('#feed-container').load('GetFeedHome');

        // Left bar navigation pages
        $(document).on("click",".left-nav",function(event) {
            $('#feed-container').load($(this).attr('id'));
            event.preventDefault();
        });
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
                    <div class="Landing nav-tag" id="MainController">Landing Page</div>
                </div>
                <div class="mt-auto p-2">
                    <div class="LegalTerms"><a>Legal Terms</a></div>
                    <div class="AboutUs"><a>About Us</a></div>
                    <div class="Privacy"><a>Privacy</a></div>
                    <div class="Copyright">© 2023 Twitflix LLC</div>
                </div>
                <br>
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