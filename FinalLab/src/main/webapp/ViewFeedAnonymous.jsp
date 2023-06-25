<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<script type="text/javascript">
    $(document).ready(function(){
        $('#popular-movies').load('GetPopularMovies');
    });
</script>

<div class="container-fluid h-100">
    <div class="row h-100">
        <div class="BarMenu col-3" style="flex: 0 0 18%; max-width: 18%;">
            <div class="d-flex flex-column h-100">
                <div class="p-2">
                    <img class="Logo img-fluid" src="imgs/logowhite.png" alt="Logo">
                </div>
                <div class="p-2" id="left-bar">
                    <div class="Home">Landing Page</div>
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
            <div class="p-3">
                <input class="SearchBar" type="search" placeholder="Search on Twitflix">
            </div>

            <div>
                <p class="SubTitle">Popular Movies and Shows</p>
                <div id="popular-movies">
                </div>
            </div>

            <div>
                <p class="SubTitle">Feed</p>
                <div id="Feed">
                </div>
            </div>

        </div>
    </div>
</div>