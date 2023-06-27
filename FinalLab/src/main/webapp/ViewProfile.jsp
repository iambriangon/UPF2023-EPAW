<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="true"%>

<script type="text/javascript">
    $(document).ready(function(){
        // Render Tweets
        $('#userTweetsTag').load('GetUserTweets');
    });
</script>

<div>
    <p class="SubTitle"> Profile </p>
    <h6 class="white-text">@${user.name}</h6>
    <div class="white-text">
        <p> Share your movies thoughts:</p>
        <textarea id="tweetContentTag" class="form-control" aria-label="With textarea"></textarea>
        <input id="addTweetTag" class="BlackButton" type="submit" name="sumbit" value="Publish">
    </div>
</div>

<div>
    <p class="SubTitle"> My Tweets</p>
    <div id="userTweetsTag">
    </div>
</div>
