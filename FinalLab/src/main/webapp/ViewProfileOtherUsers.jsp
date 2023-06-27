<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<link rel="stylesheet" href="styles/styles.css">
<script type="text/javascript">
    $(document).ready(function(){
        // Renderizar Tweets
        $('#otherUserTweetsTag').load('GetOtherUserTweets', {id: ${otherUserId}});
    });
</script>



<div class="banner-container">
    <div class="banner">
        <img src="./imgs/content/avatar-2.jpeg" alt="Foto de portada del usuario" class="cover-photo">
        <img class="profile-pic" src="./imgs/content/avatar-2.jpeg" alt="Foto en círculo">
        <div class="profile-info">
            <h6 class="profile-username">@${otherUserName}</h6>
        </div>
    </div>
</div>

<div class="tweets-section">
    <p class="SubTitle">Tweets</p>
    <div id="otherUserTweetsTag"></div>
</div>