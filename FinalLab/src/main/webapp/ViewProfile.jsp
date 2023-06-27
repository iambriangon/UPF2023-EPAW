<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<link rel="stylesheet" href="styles/styles.css">
<script type="text/javascript">
    $(document).ready(function(){
        // Renderizar Tweets
        $('#userTweetsTag').load('GetUserTweets');
    });
</script>

<div class="search-container">
    <input class="SearchBar" type="search" placeholder="Busca en Twitflix">
</div>

<div class="banner">
    <img src="imgs/logorojo.png" alt="Foto de portada del usuario" class="cover-photo">
    <div class="profile-pic">
        <img src="imgs/upf.jpg" alt="Foto en círculo" class="profpic">
    </div>
</div>

<div class="tweet-section">
    <div class="profile-info">
        <h6 class="white-text">@${user.name}</h6>
        <div class="white-text">
            <p>Comparte tus pensamientos sobre películas:</p>
            <textarea id="tweetContentTag" class="form-control" aria-label="With textarea"></textarea>
            <input id="addTweetTag" class="BlackButton" type="submit" name="submit" value="Publicar">
        </div>
    </div>

    <div class="tweets-section">
        <p class="SubTitle">Mis Tweets</p>
        <div id="userTweetsTag"></div>
    </div>
</div>
