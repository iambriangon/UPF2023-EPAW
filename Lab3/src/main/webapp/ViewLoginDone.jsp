<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>

<script type="text/javascript">
$('#navigation').load('MenuController');
</script>


<div class="w3-row">
    <div class="w3-quarter w3-blue">
        <div class="w3-container w3-center">
            <img src="imgs/me.png" class="w3-cicle w3-padding">
            <p>${sessionScope.user}</p>
        </div>
        <div class="w3-container">
            <p>
                <button class="w3-button"> Home </button>
            </p>
            <p>
                <button class="w3-button"> Notifications </button>
            </p>
            <p>
                <button class="w3-button"> Messages </button>
            </p>
            <p>
                <button class="w3-button"> Profile </button>
            </p>
            <p>
                <button class="w3-button"> Settings </button>
            </p>
        </div>
    </div>
    <div class="w3-half w3-red">
        <p class="w3-center">TWITTER</p>
        <div class="w3-cell-row">
            <button class="w3-button w3-cell w3-half">For you </button>
            <button class="w3-button w3-cell w3-half">Following </button>
        </div>
        <input class="w3-input " placeholder="Tweet something...">
        <button class="w3-button w3-border w3-round">Tweet</button>
        <div class="w3-container w3-center">
            <p class="w3-border"> Tweet 1 </p>
            <p class="w3-border"> Tweet 2 </p>
            <p class="w3-border"> Tweet 3 </p>
            <p class="w3-border"> Tweet 4 </p>
            <p class="w3-border"> Tweet 5 </p>
        </div>
    </div>
    <div class="w3-quarter w3-green">
        <input class="w3-input w3-border" type="text" placeholder="Search your Tweet">
        <p>Trending Topics</p>
    </div>
</div>

<div class="w3-center w3-yellow">
    <p>EPAW 2023 - UPF</p>
</div>