<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<link rel="stylesheet" href="styles/styles.css">
<script type="text/javascript">
    $(document).ready(function(){
        // Renderizar Tweets
        $('#userTweetsTag').load('GetUserTweets');
    });
</script>



<div class="banner-container">
    <div class="banner">
        <img src="./imgs/content/Avatar2.jpg" alt="Foto de portada del usuario" class="cover-photo">
        <img class="profile-pic" src="./imgs/content/profile-pic-default.jpg" alt="Foto en círculo">
        <div class="profile-info">
            <h6 class="profile-username">@${user.name}</h6>
        </div>
    </div>
</div>


<div class="tweet-section">
    <p class="white-text">Share your thoughts about the last movie you saw:</p>
    <textarea id="tweetContentTag" class="form-control" aria-label="With textarea"></textarea>
    <input id="addTweetTag" class="BlackButton" type="submit" name="submit" value="Publish Tweet">
</div>

<div class="tweets-section">
    <p class="SubTitle">Mis Tweets</p>
    <div id="userTweetsTag"></div>
</div>