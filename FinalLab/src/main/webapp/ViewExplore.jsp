<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>


<script type="text/javascript">
    $(document).ready(function(){
        // Render Users Not Followed
        $('#userNotFollowedTag').load('GetNotFollowedUsers');

        // Render Users Followed
        $('#userFollowedTag').load('GetFollowedUsers');
    });
</script>

<div>
    <p class="SubTitle"> Explore </p>
</div>

<div>
    <h6 class="white-text">Users not Followed</h6>
    <div id="userNotFollowedTag">
    </div>
</div>

<div>
    <h6 class="white-text">Users Followed</h6>
    <div id="userFollowedTag">
    </div>
</div>