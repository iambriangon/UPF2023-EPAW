<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<script type="text/javascript">
    $(document).ready(function(){
        $('#popular-movies').load('GetPopularMovies');
        $('#tweet-feed').load('GetTweetFeed');
    });
</script>

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
    <div id="tweet-feed">
    </div>
</div>
