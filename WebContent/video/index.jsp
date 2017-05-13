<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="top.yeaho.service.PromptService"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>html5 视频播放器</title>
	<script src="js/jquery.js"></script>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script src="js/video.js"></script>
</head>

<body>

	<div id="ni">
		<%
		PromptService ProSer = new PromptService();
		ProSer.serviceForPrompt(request, response);
		%>
	</div>
	

	<div id="videoContainer">
		<video id="myVideo" preload="auto" height="100%" width="100%">
				<source id="videoSourceid" src="123.mp4" type="video/mp4"></source>
当前浏览器不支持 video直接播放，点击这里下载视频：				
				<a href="http://img.ksbbs.com/asset/Mon_1605/0ec8cc80112a2d6.mp4">下载视频</a>
			</video>
			
			<svg id="loading" viewBox="0 0 120 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
      <g id="circleal" class="g-circles g-circles--v1">
          <circle class="circleg" id="12" transform="translate(35, 16.698730) rotate(-30) translate(-35, -16.698730) " cx="35" cy="16.6987298" r="10"></circle>
          <circle class="circleg" id="11" transform="translate(16.698730, 35) rotate(-60) translate(-16.698730, -35) " cx="16.6987298" cy="35" r="10"></circle>
          <circle class="circleg" id="10" transform="translate(10, 60) rotate(-90) translate(-10, -60) " cx="10" cy="60" r="10"></circle>
          <circle class="circleg" id="9" transform="translate(16.698730, 85) rotate(-120) translate(-16.698730, -85) " cx="16.6987298" cy="85" r="10"></circle>
          <circle class="circleg" id="8" transform="translate(35, 103.301270) rotate(-150) translate(-35, -103.301270) " cx="35" cy="103.30127" r="10"></circle>
          <circle class="circleg" id="7" cx="60" cy="110" r="10"></circle>
          <circle class="circleg" id="6" transform="translate(85, 103.301270) rotate(-30) translate(-85, -103.301270) " cx="85" cy="103.30127" r="10"></circle>
          <circle class="circleg" id="5" transform="translate(103.301270, 85) rotate(-60) translate(-103.301270, -85) " cx="103.30127" cy="85" r="10"></circle>
          <circle class="circleg" id="4" transform="translate(110, 60) rotate(-90) translate(-110, -60) " cx="110" cy="60" r="10"></circle>
          <circle class="circleg" id="3" transform="translate(103.301270, 35) rotate(-120) translate(-103.301270, -35) " cx="103.30127" cy="35" r="10"></circle>
          <circle class="circleg" id="2" transform="translate(85, 16.698730) rotate(-150) translate(-85, -16.698730) " cx="85" cy="16.6987298" r="10"></circle>
          <circle class="circleg" id="1" cx="60" cy="10" r="10"></circle>
      </g>
  </svg>
				
			<div class="bottomContainer">
			<div class="caption">This is HTML5 video with custom controls</div>

			<div class="tip"></div>
			<div class="currentTip"></div>
			<div class="control">
				<div class="topControl">
					<div class="progress" id="progress">
						<span class="bufferBar"></span>
						<span class="toptimeBar"></span>
						<span class="timeBar"></span>
					</div>
					
				</div>
			</div>

			<div class="btmControl">
					<!--æ­æ¾æå-->
					<svg id="btnPlay"  class="btnPlay btn" version="1.1" width="32" height="32">
						<polygon points="0,0 28,16 0,32" style="fill:#E5E5E5;" />
					</svg>
					<!--æå-->
					<svg id="btnPause" class="btnPause btn" width="32" height="32">
						<rect x="5" y="2" width="8" height="28"
				style="fill:#E5E5E5;"/>
						<rect x="17" y="2" width="8" height="28"
				 style="fill:#E5E5E5;"/>
					</svg>
					<!--next-->
					<svg id="btnNext" class="btnNext btn" width="32" height="32">
						<path d="M0,0 L16,16 L0,32 L0,0 L16,16 L16,0 L32,16 L16,32 L16,16 Z" style="fill:#E5E5E5;" />
					</svg>
					<!--ä¸ä¸ä¸ª-->
					<svg id="btnGo" class="btnGo btn" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="32" height="32"
					 viewBox="0 0 51.426 51.426"  xml:space="preserve">
				<polygon style="fill:#E5E5E5;stroke:#E5E5E5;stroke-width:6;stroke-miterlimit:10;" points="38.713,25.713 9.713,45.713 
					9.713,26.077 9.713,5.713 "/>
				<line style="fill:none;stroke:#E5E5E5;stroke-width:6;stroke-miterlimit:10;" x1="41.713" y1="5.713" x2="41.713" y2="45.713"/>
				</svg>
<svg  id="trumpt" class="trumpt btn" width="32" height="32">
 	<lineargradient id="grad1" x1="0%" y1="0%" x2="100%" y2="0%">
      <stop offset="0%" style="stop-color:#E5E5E5;stop-opacity:1" />
      <stop offset="100%" style="stop-color:#E5E5E5;stop-opacity:1" />
    </lineargradient>
    
    <rect x="0" y="10" width="4.5" height="10"
style="fill:#E5E5E5;"/>
	<path d="M6.5,10 L17,0 L17,30 L6.5,20 L6.5,10" 
		style="fill:#E5E5E5;"></path>
 	
	 <path d="M19,10 C24,10 24,20 19,20" stroke="url(#grad1)"  style="fill:none;stroke-width:2;" ></path>
	 
	 <path id="trumpt1" d="M19,4 C32,4 32,26 19,26" rx="20" ry="20" stroke="url(#grad1)"  style="fill:none;stroke-width:3;" ></path>
	
</svg>
<svg id="trumptN" class="trumptN btn" width="32" height="32">
 	<lineargradient id="grad1" x1="0%" y1="0%" x2="100%" y2="0%">
      <stop offset="0%" style="stop-color:#E5E5E5;stop-opacity:1" />
      <stop offset="100%" style="stop-color:#E5E5E5;stop-opacity:1" />
    </lineargradient>
    <rect x="0" y="10" width="4.5" height="10"
style="fill:#E5E5E5;"/>
	<path d="M6.5,10 L17,0 L17,30 L6.5,20 L6.5,10" 
		style="fill:#E5E5E5;"></path>
 	
	 <path d="M19,10 C24,10 24,20 19,20" stroke="url(#grad1)"  style="fill:none;stroke-width:2;" ></path>
	 
	 <path id="trumpt2" d="M19,4 C32,4 32,26 19,26" rx="20" ry="20" stroke="url(#grad1)"  style="fill:none;stroke-width:3;" ></path>
    
	 <rect x="2.5" y="-2.5" width="40" height="5"
transform="rotate(45)" style="fill:#E5E5E5;" />
	
</svg>
				
			<div id="volume" class="volume" title="Set volume">
				<span id="volumeBar" class="volumeBar"></span>
			</div>

					<div id="btnSpeedalldiv" class="btnSpeedalldiv" width="60" height="32">
					<svg id="btnSpeedall" class="btnSpeedall btn" width="60" height="32">
						<text x="10" y="25" fill="#E5E5E5" >倍速</text>
					</svg>
					<svg id="btnSpeed1" class="btnSpeed1 btnSpeed btn" width="60" height="32">
						<text x="0" y="15" fill="#E5E5E5">x0.5</text>
					</svg>
					<svg id="btnSpeed2" class="btnSpeed2 btnSpeed btn" width="60" height="32">
						<text x="0" y="15" fill="#E5E5E5">x0.75</text>
					</svg>
					<svg id="btnSpeed3" class="btnSpeed3 btnSpeed btn" width="60" height="32">
						<text x="0" y="15" fill="#E5E5E5">x1.0</text>
					</svg>
					<svg id="btnSpeed4" class="btnSpeed4 btnSpeed btn" width="60" height="32">
						<text x="0" y="15" fill="#E5E5E5">x1.25</text>
					</svg>
					<svg id="btnSpeed5" class="btnSpeed5 btnSpeed btn" width="60" height="32">
						<text x="0" y="15" fill="#E5E5E5">x1.5</text>
					</svg>
					<svg id="btnSpeed6" class="btnSpeed6 btnSpeed btn" width="60" height="32">
						<text x="0" y="15" fill="#E5E5E5">x1.75</text>
					</svg>
					<svg id="btnSpeed7" class="btnSpeed7 btnSpeed btn" width="60" height="32">
						<text x="0" y="15" fill="#E5E5E5">x2.0</text>
					</svg>
					</div>
					<div id="time" class="time">
						<span class="current"></span>
					</div>
					
					<input type="text" id="btnBulletinput" placeholder="è¯·è¾å¥å¼¹å¹åå®¹" autofocus class="btnBulletinput btn"/>
					<button id="btnPublish" class="btnPublish btn">来一发</button>
					<svg id="btnpublishbtn" class="btnpublishbtn btn" width="60" height="32">
						<text x="0" y="17" fill="#E5E5E5">弹幕:</text>					
					</svg>
					
						<svg version="1.1" id="promptSwitchClose" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="32" height="32"
	 viewBox="0 0 58 58" style="enable-background:new 0 0 58 58;" xml:space="preserve">
<path style="fill:#000;" d="M6,23h27.474C32.537,24.796,32,26.834,32,29s0.537,4.204,1.474,6H6c-3.314,0-6-2.686-6-6
	C0,25.686,2.686,23,6,23z"/>
<circle style="fill:#e5e5e5;" cx="45" cy="29" r="13"/>
</svg>
					<svg version="1.1" id="promptSwitchOn" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="32" height="32" x="0px" y="0px"
	 viewBox="0 0 58 58" style="enable-background:new 0 0 58 58;" xml:space="preserve">
<path style="fill:#000;" d="M52,23H24.526C25.463,24.796,26,26.834,26,29s-0.537,4.204-1.474,6H52c3.314,0,6-2.686,6-6
	S55.314,23,52,23z"/>
<circle style="fill:#e5e5e5;" cx="13" cy="29" r="13"/>
</svg>
					
					<!--æªå±-->
					<svg id="picture" class="picturebtn btn" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" 
	  width="32" height="32" viewBox="0 0 512 512" xml:space="preserve">
<path fill="#E5E5E5" d="M0,64v416h512V64H0z M480,448H32V96h448V448z M352,176c0,26.51,21.49,48,48,48s48-21.49,48-48s-21.49-48-48-48
	S352,149.49,352,176z M448,416H64l96-256l128,160l64-48L448,416z"/>
</svg>

					
					<!--ç¯æ³¡-->
					
					<svg id="btnlight" class="btnlight btn" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
	 width="32px" height="32px" viewBox="0 0 70 70" enable-background="new 0 0 70 70" xml:space="preserve">

	<path d="M59.5,27.848c0-13.509-10.99-24.5-24.5-24.5s-24.5,10.991-24.5,24.5c0,9.392,5.314,17.562,13.091,21.672
		c0.006,0.052,0.004,0.103,0.015,0.155l2.9,14.539c0.185,0.938,1.007,1.369,1.962,1.369h3.383c0.347,1,0.984,1,1.723,1h2
		c0.738,0,1.376,0,1.723-1h3.371c0.958,0,1.782-0.463,1.964-1.404l2.772-14.174C53.725,46.085,59.5,37.639,59.5,27.848z
		 M39.017,61.583h-8.905l-2.068-10.281c2.207,0.654,4.54,1.028,6.957,1.028c2.064,0,4.069-0.285,5.986-0.768L39.017,61.583z
		 M32.117,48.032l-2.774-13.359c0.045,0.003,0.089,0.012,0.135,0.012c0.869,0,1.621-0.609,2.097-1.683
		c0.028-0.033,0.054-0.067,0.077-0.104c0.046-0.071,0.087-0.123,0.12-0.158c0.032,0.036,0.073,0.086,0.118,0.157
		c0.029,0.045,0.063,0.088,0.101,0.127c0.478,1.054,1.224,1.65,2.083,1.65c0.479,0,1.374-0.198,2.021-1.518
		c0.007-0.012,0.014-0.025,0.02-0.038c0.022-0.047,0.044-0.096,0.065-0.145c0.02-0.024,0.037-0.05,0.055-0.076
		c0.046-0.071,0.087-0.123,0.12-0.158c0.033,0.035,0.074,0.087,0.12,0.158c0.021,0.034,0.046,0.065,0.072,0.096
		c0.475,1.08,1.229,1.691,2.102,1.691c0.87,0,1.623-0.609,2.098-1.684c0.027-0.033,0.054-0.067,0.077-0.104
		c0.045-0.07,0.086-0.122,0.118-0.157c0.026,0.027,0.06,0.074,0.093,0.122l-3.15,15.17c-0.006,0.03,0.003,0.06,0,0.09
		c-0.944,0.133-1.902,0.226-2.883,0.226c-0.981,0-1.938-0.093-2.882-0.226C32.114,48.092,32.124,48.063,32.117,48.032z
		 M39.993,47.71l3.124-15.043c0.096-0.458-0.15-0.893-0.555-1.087c-0.896-1.132-2.356-1.151-3.246-0.013
		c-0.146,0.113-0.262,0.267-0.328,0.448c-0.125,0.339-0.257,0.53-0.341,0.622c-0.085-0.091-0.217-0.282-0.342-0.622
		c-0.058-0.159-0.162-0.296-0.293-0.404c-0.6-0.795-1.286-0.921-1.659-0.921c-0.369,0-1.048,0.124-1.645,0.902
		c-0.13,0.108-0.232,0.25-0.295,0.416c-0.032,0.086-0.067,0.169-0.096,0.229c-0.004,0.008-0.009,0.017-0.013,0.025
		c-0.089,0.185-0.173,0.299-0.231,0.362c-0.084-0.091-0.215-0.28-0.339-0.614c-0.062-0.166-0.176-0.309-0.318-0.417
		c-0.448-0.585-1.025-0.904-1.646-0.904c-0.365,0-1.033,0.121-1.624,0.877c-0.146,0.113-0.262,0.266-0.328,0.447
		c-0.125,0.34-0.258,0.531-0.342,0.623c-0.084-0.091-0.217-0.282-0.342-0.623c-0.145-0.393-0.57-0.655-0.989-0.655
		c-0.169,0-0.318,0.052-0.454,0.126c-0.011,0.002-0.021-0.002-0.032,0c-0.541,0.112-0.889,0.642-0.776,1.182l3.124,15.043
		C21.103,45.478,14.5,37.445,14.5,27.848c0-11.323,9.178-20.5,20.5-20.5s20.5,9.177,20.5,20.5
		C55.5,37.445,48.897,45.478,39.993,47.71z" fill="#E5E5E5"/>
	
<!-- 	<path d="M32.842,11.742c-0.39,0-0.777,0.016-1.16,0.047c-0.551,0.045-0.96,0.528-0.915,1.079c0.044,0.522,0.48,0.918,0.996,0.918
	c0.027,0,0.056-0.001,0.083-0.003c0.328-0.027,0.661-0.041,0.996-0.041c0.553,0,1-0.448,1-1S33.395,11.742,32.842,11.742z" fill="#E5E5E5"/>
	

<path d="M27.03,13.007c-4.942,2.269-8.136,7.247-8.136,12.683c0,0.552,0.447,1,1,1s1-0.448,1-1c0-4.657,2.736-8.922,6.97-10.866
	c0.502-0.23,0.723-0.824,0.492-1.326C28.125,12.997,27.53,12.777,27.03,13.007z" fill="#E5E5E5"/> -->

	<rect class="btnLightIn" x="34" y="14" width="3" height="12"
style="fill:#E5E5E5;"/>
<rect class="btnLightIn" x="47" y="-9" width="3" height="12"
style="fill:#E5E5E5;" transform="rotate(30)"/>
<rect class="btnLightIn" x="12" y="27" width="3" height="12"
style="fill:#E5E5E5;" transform="rotate(-30)"/>
	<path d="M29.575,54.84c-0.068,0.548,0.32,1.048,0.868,1.116l7.292,0.912c0.042,0.005,0.084,0.008,0.125,0.008
		c0.497,0,0.928-0.37,0.991-0.876c0.068-0.548-0.32-1.048-0.868-1.116l-7.292-0.912C30.143,53.908,29.645,54.293,29.575,54.84z" fill="#E5E5E5"/>
	
	<path d="M37.463,58.817l-6.087-0.76c-0.548-0.063-1.047,0.32-1.116,0.868c-0.068,0.548,0.32,1.048,0.868,1.116l6.087,0.76
		c0.042,0.005,0.084,0.008,0.125,0.008c0.497,0,0.928-0.37,0.991-0.876C38.399,59.386,38.011,58.886,37.463,58.817z" fill="#E5E5E5"/>
</svg>

	<!--å¨å±-->
					
<svg id="btnFullScreenIn" class="btnFullScreenIn btn" width="57" height="40">
	<rect x="5" y="2" width="6" height="3"
	style="fill:#E5E5E5;border:none;"/>
	<rect x="21" y="2" width="6" height="3"
	style="fill:#E5E5E5;border:none;"/>
	<rect x="5" y="27" width="6" height="3"
	style="fill:#E5E5E5;border:none;"/>
	<rect x="21" y="27" width="6" height="3"
	style="fill:#E5E5E5;border:none;"/>

	<rect x="2" y="2" width="3" height="10"
	style="fill:#E5E5E5;border:none;"/>
	<rect x="27" y="2" width="3" height="10"
	style="fill:#E5E5E5;border:none;"/>
	<rect x="2" y="20" width="3" height="10"
	style="fill:#E5E5E5;border:none;"/>
	<rect x="27" y="20" width="3" height="10"
	style="fill:#E5E5E5;border:none;"/>

	</svg>
						<svg id="btnFullScreenOut"  class="btnFullScreenOut btn" width="57" height="40">
<rect x="2" y="9" width="8" height="3"
style="fill:#E5E5E5;border:none;"/>
<rect x="20" y="9" width="8" height="3"
style="fill:#E5E5E5;border:none;"/>
<rect x="2" y="20" width="8" height="3"
style="fill:#E5E5E5;border:none;"/>
<rect x="20" y="20" width="8" height="3"
style="fill:#E5E5E5;border:none;"/>

<rect x="10" y="2" width="3" height="10"
style="fill:#E5E5E5;border:none;"/>
<rect x="17" y="2" width="3" height="10"
style="fill:#E5E5E5;border:none;"/>
<rect x="10" y="20" width="3" height="10"
style="fill:#E5E5E5;border:none;"/>
<rect x="18" y="20" width="3" height="10"
style="fill:#E5E5E5;border:none;"/>

	</svg>
	<svg version="1.1" id="size4" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="32" height="32"
	 viewBox="0 0 294.003 294.003" style="enable-background:new 0 0 294.003 294.003;" xml:space="preserve">
	<polygon fill="#E5E5E5" points="74.643,163.521 74.643,120.466 45.682,163.521 	"/>
	<path fill="#E5E5E5" d="M281.503,10.27H12.5C5.597,10.27,0,15.866,0,22.77v248.464c0,6.903,5.597,12.5,12.5,12.5h269.003
		c6.903,0,12.5-5.597,12.5-12.5V22.77C294.003,15.866,288.406,10.27,281.503,10.27z M103.045,184.747h-5.027v13.664
		c0,6.455-5.233,11.688-11.688,11.688s-11.688-5.233-11.688-11.688v-13.664H39.231c-8.92,0-16.151-7.231-16.151-16.151
		c0-3.251,0.981-6.426,2.815-9.11l47.889-70.101c2.474-3.621,6.575-5.786,10.96-5.786c7.331,0,13.274,5.943,13.274,13.274v66.648
		h5.027c5.862,0,10.613,4.752,10.613,10.613S108.906,184.747,103.045,184.747z M147.045,200.407c-11.046,0-20-8.954-20-20
		s8.954-20,20-20s20,8.954,20,20S158.091,200.407,147.045,200.407z M147.045,133.29c-11.046,0-20-8.954-20-20s8.954-20,20-20
		s20,8.954,20,20S158.091,133.29,147.045,133.29z M254.51,199.485c-8.078,7.793-18.133,11.688-30.164,11.688
		c-11.401,0-20.854-3.279-28.359-9.84c-3.375-2.949-6.112-6.306-8.213-10.072c-1.899-3.405-1.978-7.532-0.211-11.007
		s5.148-5.847,9.019-6.316l0.012-0.001c4.975-0.604,9.748,2.12,11.768,6.707c1.003,2.278,2.321,4.204,3.954,5.78
		c3.266,3.152,7.219,4.727,11.859,4.727c4.984,0,9.181-1.891,12.59-5.672c3.408-3.781,5.113-8.879,5.113-15.297
		c0-6.072-1.633-10.885-4.898-14.438c-3.266-3.551-7.248-5.328-11.945-5.328c-0.007,0-0.015,0-0.022,0
		c-2.725,0.002-5.316-1.174-7.111-3.224c-1.795-2.05-2.625-4.779-2.26-7.479l0.006-0.044c0.519-3.83,3.458-6.875,7.266-7.534
		c3.536-0.612,6.421-1.895,8.653-3.848c3.438-3.008,5.156-7.004,5.156-11.988c0-4.238-1.261-7.619-3.781-10.141
		c-2.521-2.52-5.873-3.781-10.055-3.781c-4.125,0-7.648,1.434-10.57,4.297c-1.257,1.233-2.302,2.709-3.135,4.429
		c-2.248,4.643-7.297,7.251-12.383,6.387l-0.051-0.009c-3.293-0.559-6.137-2.62-7.695-5.575c-1.558-2.954-1.651-6.466-0.254-9.5
		c0.886-1.923,1.864-3.666,2.936-5.229c3.122-4.555,7.477-8.135,13.063-10.742c5.586-2.605,11.845-3.91,18.777-3.91
		c11.859,0,21.369,3.781,28.531,11.344c5.9,6.188,8.852,13.178,8.852,20.969c0,11.059-6.045,19.881-18.133,26.469
		c7.219,1.547,12.99,5.014,17.316,10.398c4.325,5.387,6.488,11.889,6.488,19.508C266.627,182.271,262.588,191.694,254.51,199.485z"
		/>
</svg>
<svg version="1.1" id="size16" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="32" height="32"
	 viewBox="0 0 294.004 294.004" style="enable-background:new 0 0 294.004 294.004;" xml:space="preserve">
	<path fill="#E5E5E5" d="M241.696,113.676c-3.555,0-6.506,1.401-8.853,4.204c-2.348,2.803-3.521,7.395-3.521,13.774
		c0,6.472,1.275,11.223,3.828,14.253c2.552,3.031,5.742,4.546,9.57,4.546c3.691,0,6.802-1.458,9.331-4.375
		c2.529-2.916,3.794-7.2,3.794-12.852c0-6.197-1.425-11.006-4.272-14.424C248.726,115.385,245.433,113.676,241.696,113.676z"/>
	<path fill="#E5E5E5" d="M281.504,31.77H12.5C5.597,31.77,0,37.367,0,44.27v205.464c0,6.903,5.597,12.5,12.5,12.5h269.004
		c6.903,0,12.5-5.597,12.5-12.5V44.27C294.004,37.367,288.407,31.77,281.504,31.77z M58.767,189.657c0,5.304-4.3,9.604-9.604,9.604
		s-9.604-4.3-9.604-9.604v-62.788c-3.903,3.649-8.193,6.77-12.871,9.363c-2.49,1.38-5.524,1.341-7.978-0.103
		c-2.454-1.444-3.965-4.077-3.965-6.925c0-2.988,1.723-5.707,4.425-6.983c3.751-1.771,7.722-4.289,11.913-7.554
		c4.324-3.369,7.649-7.15,9.976-11.344c1.604-2.892,4.651-4.686,7.959-4.686c5.385,0,9.75,4.365,9.75,9.75V189.657z M136.378,190.82
		c-6.016,6.198-13.74,9.297-23.174,9.297c-10.117,0-18.435-3.931-24.951-11.792c-6.518-7.861-9.775-20.747-9.775-38.657
		c0-18.365,3.395-31.604,10.186-39.717c6.79-8.111,15.608-12.168,26.455-12.168c7.61,0,13.911,2.131,18.901,6.392
		c1.969,1.682,3.656,3.663,5.061,5.944c1.64,2.662,1.802,5.978,0.431,8.787c-1.371,2.81-4.085,4.725-7.193,5.068l-0.064,0.007
		c-3.673,0.405-7.202-1.538-8.827-4.856c-0.546-1.114-1.219-2.053-2.02-2.816c-1.914-1.822-4.398-2.734-7.451-2.734
		c-4.057,0-7.485,1.823-10.288,5.469c-2.803,3.646-4.569,11.234-5.298,22.764c4.785-5.65,10.732-8.477,17.842-8.477
		c8.021,0,14.891,3.054,20.61,9.16c5.719,6.107,8.579,13.991,8.579,23.652C145.401,176.396,142.394,184.622,136.378,190.82z
		 M180.752,187.283c-8.284,0-15-6.716-15-15c0-8.284,6.716-15,15-15c8.284,0,15,6.716,15,15
		C195.752,180.567,189.037,187.283,180.752,187.283z M180.752,140.616c-8.284,0-15-6.716-15-15c0-8.284,6.716-15,15-15
		c8.284,0,15,6.716,15,15C195.752,133.9,189.037,140.616,180.752,140.616z M267.194,187.983
		c-6.791,8.112-15.632,12.168-26.523,12.168c-7.839,0-14.174-2.085-19.004-6.255c-1.983-1.712-3.675-3.771-5.074-6.179
		c-1.563-2.688-1.661-5.983-0.26-8.759c1.401-2.775,4.11-4.649,7.201-4.99l0.055-0.006c3.706-0.409,7.273,1.532,8.946,4.864
		c0.539,1.074,1.201,1.985,1.984,2.73c1.914,1.823,4.443,2.734,7.588,2.734c3.965,0,7.337-1.822,10.117-5.469
		c2.779-3.646,4.557-11.211,5.332-22.695c-4.831,5.605-10.869,8.408-18.115,8.408c-7.885,0-14.687-3.042-20.405-9.126
		c-5.72-6.084-8.579-14.002-8.579-23.755c0-10.162,3.019-18.354,9.058-24.575c6.038-6.221,13.729-9.331,23.071-9.331
		c10.162,0,18.502,3.931,25.02,11.792c6.517,7.861,9.775,20.793,9.775,38.794C277.38,166.655,273.984,179.871,267.194,187.983z"/>
	<path fill="#E5E5E5" d="M113.204,147.48c-3.691,0-6.813,1.447-9.365,4.341c-2.553,2.895-3.828,7.167-3.828,12.817
		c0,6.244,1.436,11.063,4.307,14.458c2.871,3.396,6.152,5.093,9.844,5.093c3.555,0,6.517-1.39,8.887-4.17
		c2.369-2.779,3.555-7.337,3.555-13.672c0-6.517-1.276-11.29-3.828-14.321C120.222,148.995,117.032,147.48,113.204,147.48z"/>
</svg>

		<!--<div class="btnStop btn" title="Stop video"></div>
				<div class="spdText btn">Speed: </div>
				<div class="btnx1 btn text selected" title="Normal speed">x1</div>
				<div class="btnx3 btn text" title="Fast forward x3">x3</div>
				<div class="btnFS btn" title="Switch to full screen"></div>
				<div class="btnLight lighton btn" title="Turn on/off light"></div>
				<div class="volume" title="Set volume">
					<span class="volumeBar"></span>
				</div>
				<div class="sound sound2 btn" title="Mute/Unmute sound"></div>
					<div class="loading"></div>
		</div>-->
	

 
		<!--container-->
	</div>
	</div>
	</div>

	<button id="btnFS1" onclick="launchFullscreen(document.getElementById('videoContainer'));">btnFS</button>
	
	<button class="cut">点击截屏</button>
<div id="pop" class="wrap">
	<canvas id="cutPic"></canvas>
	<div class="currentdiv">当前时间: <span id="current"></span></div>
	<div class="tipRight">右键点击图片进行下载</div>
  </div>


	<script type="text/javascript">
		$("#btnGo").bind("click",function(){
			document.getElementById("myVideo").src="001.mp4";
		});

		var video = $("#myVideo");
		var $canvas = $('#cutPic');
		var progress = $('.progress');
		var iduration = 0;
		var video1 = document.getElementById("myVideo");
		$canvas.attr({	width: video.width(),height: video.height(),
		});
		
		$("#picture").click(function() {
      $("#pop").show()
    });
    $("#pop").click(function() {
      $("#pop").hide()
    });
		
		var ctx = $canvas[0].getContext('2d');
		$('#picture').bind('click', function () {
			var w = video[0].videoWidth;//è§é¢åæå°ºå¯¸
			var h = video[0].videoHeight;//è§é¢åæå°ºå¯¸
			$canvas.attr({
				width: w,
				height: h,
			});
			$("#current").html(video[0].currentTime);
			ctx.drawImage(video[0], 0, 0, w, h);
			var base64 = $canvas[0].toDataURL('images/png');
			/*console.log(base64); */
		});
		
		String.prototype.Right = function (i) { //ä¸ºStringå¯¹è±¡å¢å ä¸ä¸ªRightæ¹æ³
			return this.slice(0, this.length - i); //è¿åå¼ä¸º ä»¥âè¯¥å­ç¬¦ä¸²é¿åº¦åiâä¸ºèµ·å§ å° è¯¥å­ç¬¦ä¸²æ«å°¾ çæªåå­ç¬¦ä¸²
		};
		
		var pData = $("#promptValue").html(); 

		pData = pData.Right(1);
		pData = pData.split("|");
		console.log(pData); 
		/*		console.log(pTime);
				console.log(pData);*/

		var allduration = setInterval(function () {
			if (video1.readyState > 0) {
				// var minutes = parseInt(video1.duration / 60, 10);
				// var seconds = video1.duration % 60;
				var maxduration = video[0].duration;
				drawPrompt(pData,maxduration);
				// console.log("the mi"+minutes);
				// console.log(seconds);
				// (Put the minutes and seconds in the display)

				clearInterval(allduration);
			}
		}, 200);

		//æµ®ç¹æ°ç¸ä¹
		function accMul(arg1, arg2) {
			if (isNaN(arg1)) {
				arg1 = 0;
			}
			if (isNaN(arg2)) {
				arg2 = 0;
			}
			arg1 = Number(arg1);
			arg2 = Number(arg2);

			var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
			try {
				m += s1.split(".")[1].length;
			}
			catch (e) {
			}
			try {
				m += s2.split(".")[1].length;
			}
			catch (e) {
			}
			return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
		}

		
			//display current video play time
/*	video.bind('timeupdate', function () {
		var currentPos = video[0].currentTime - iduration;
		var maxduration = video[0].duration;
		var perc = 100 * currentPos / maxduration;
			   $('.toptimeBar').css('display', 'block');
		   $('.toptimeBar').css('left', perc + '%');
		

		$('.timeBar').css('width', perc + '%');
		$('.current').text(timeFormat(currentPos));
	});*/

		function drawPrompt(pData,maxduration) {

			//calculate drag position
			//and update video currenttime
			//as well as progress bar
			//è·åå¼¹å¹æ°ç»
			$.each(pData, function (index1, value1) {
				/*æªåå¼¹å¹å­ç¬¦ä¸² value[0]ä¸ºç§æ°,value[1]ä¸ºå¼¹å¹åå®¹*/
				value1 = value1.split(",");
				//console.log(value1);
				$("#progress").prepend("<span class='prompt' id=prompt" + value1[0] + " valuen=" + value1[1] + "></span>");
				//å¼¹å¹æ¶é´ç¾åæ¯
				var valueTrue = parseInt(value1[0]);
		

				var percentPrompt = valueTrue/ maxduration;
				//var pwi = accMul(percentPrompt, progressw);
				//pwi = pwi.toFixed(0); //å»é¶
				var perc = 100 * percentPrompt;
				//console.log("the pwi2"+pwi);
				$("#prompt" + value1[0]).css("left", perc + "%");
			});
			/*	$.each(pData,function(index,value){
					$("#progress").append("<span class='prompt' id="+value+"></span>");
				  //	console.log(index + ":" + value);
				});*/


			$('.prompt').hover(function () {
				/*this çåå®¹*/
				/*<span class="prompt" id="prompt40" valuen="ç¬¬4æ¡" style="left: 19.3686%;"></span>*/
				var leftp = $(this).css('left');
				var valuen = $(this).attr('valuen');

				leftp = parseInt(leftp);
				
				$(".tip").css('left', leftp);
				$(".tip").html(valuen);
				$('.tip').stop();
				$('.tip').fadeIn();
				//console.log("bestid"+promptId);
			}, function () {
				/* Stuff to do when the mouse leaves the element */
				$('.tip').stop();
				$('.tip').fadeOut();
			});
			//$('#'+promptId).css('margin-left',x+"px");
		}

		//æ¾ç¤ºæç¤º


		/*window.innerWidth è¿éçå®½åº¦åé«åº¦ä¸åæ¬èåæ ãå·¥å·æ ä»¥åæ»å¨æ¡ç­çé«åº¦*/

		//video1.muted = true;
		/*video.networkState è¡¨ç¤ºé³é¢/è§é¢åç´ çå½åç½ç»ç¶æ
				0 = NETWORK_EMPTY - é³é¢/è§é¢å°æªåå§å
			1 = NETWORK_IDLE - é³é¢/è§é¢æ¯æ´»å¨çä¸å·²éåèµæºï¼ä½å¹¶æªä½¿ç¨ç½ç»
			2 = NETWORK_LOADING - æµè§å¨æ­£å¨ä¸è½½æ°æ®
			3 = NETWORK_NO_SOURCE - æªæ¾å°é³é¢/è§é¢æ¥æº
	 * */
		//	console.log("the networkState is: " + video1.networkState);

		/*	var rotate3 = (Math.acos(480/640)*180/Math.PI).toFixed(2); // æ°å®½åº¦ / æ§å®½åº¦
			document.write('<div>å®½é«æ¯åå°æ¶ï¼ä»¥é«åº¦ä¸ºåºåï¼è°æ´rotateY='+rotate3+' uideg</div>');
				document.getElementById('myVideo').style.transform = 'rotateY('+rotate3+'deg)';*/

/*			var rotate2 = (Math.acos(280/360)*180/Math.PI).toFixed(2); // æ°é«åº¦ / æ§é«åº¦
			document.write('<div>å®½é«æ¯å¢å æ¶ï¼ä»¥å®½åº¦ä¸ºåºåï¼è°æ´rotateX='+rotate2+'deg</div>');
			document.getElementById('myVideo').style.transform = 'rotateX('+rotate2+'deg)';*/
$("#size4").bind("click",function(){
		var rotate2 = (Math.acos(480/640)*180/Math.PI).toFixed(2);// æ°é«åº¦ / æ§é«åº¦
			document.getElementById('myVideo').style.transform = 'rotateX('+rotate2+'deg)';
	$("#size4").css("display","none");
	$("#size16").css("display","block");

})
$("#size16").bind("click",function(){
	var rotate2 = 0; // æ°é«åº¦ / æ§é«åº¦
	document.getElementById('myVideo').style.transform = 'rotateX('+rotate2+'deg)';
	$("#size16").css("display","none");
	$("#size4").css("display","block");
	
})
		//fullscreen button clicked
		var fullScreenFlag = false;
		$('#btnFS').on('click', function () {
			var video = $('#videoContainer');
			$("#myVideo").attr("height", "100%");
			$("#myVideo").attr("width", "100%");
			if (fullScreenFlag) {
				videoContainer.webkitCancelFullScreen();
			} else {
				videoContainer.webkitRequestFullscreen();
			}
		});

		/*fullnum 0:é»è®¤width:600px,height:350px
										  1:å¨å±100%
							 * */
		var fullnum = 0;
		$(window).bind("resize", function () {
			if (fullnum == 1) {
				$("#videoContainer").css({
					width: "100%",
					height: "100%"
				});
				fullnum = 0;
			} else {
				$("#videoContainer").css({
					width: "880px",
					height: "530px"
				});
			}
		});
	
		/*è¿å¥å¨å±*/
		function launchFullscreen(element) {
			fullnum = 1;
							
			if (element.requestFullscreen) {
				element.requestFullscreen();
			} else if (element.mozRequestFullScreen) {
				element.mozRequestFullScreen();
			} else if (element.webkitRequestFullscreen) {
				element.webkitRequestFullscreen();
			} else if (element.msRequestFullscreen) {
				element.msRequestFullscreen();
			}
		}
		/*var main=document.getElementById('videoContainer');
function init(){
main.addEventListener('mousemove',move,false)
}
init();
function move(e){
	console.log(fullnum);
//var e=event || window.event;
var y=e.clientY-main.offsetTop;
	console.log(y);
/*
if(y > 62){
		$('.caption').stop();
			$('.bottomContainer').stop();
		$('.caption').fadeOut();
			$('.bottomContainer').fadeOut();
}
	if(y < 62){
		$('.caption').stop();
			$('.bottomContainer').stop();
		$('.caption').fadeIn();
			$('.bottomContainer').fadeIn();
}
*/

//}*/
		/*éåºå¨å±*/
		function exitFullscreen() {
			$("#videoContainer").css({
				width: "600px",
				height: "350px"
			});
			if (document.exitFullscreen) {
				document.exitFullscreen();
			} else if (document.mozCancelFullScreen) {
				document.mozCancelFullScreen();
			} else if (document.webkitExitFullscreen) {
				document.webkitExitFullscreen();
			}
		}
		

		// è·å è§é¢çå®½é«,ä½æ¯è·åä¸å°,ä½æ¯å¯ä»¥ç¨è¾åºvideo[0],å¯ä»¥çå°è¿åçè§é¢å®½é«

		var videoH = video[0].videoHeight;
		var videoW = video[0].videoWidth;
		
		 // è·åè¦èµ°çå¼¹å¹åç´ 
        var videoContainerW = parseInt($("#videoContainer").width());
        var videoContainerH = parseInt($("#videoContainer").height());
        var videoContainer = $("#videoContainer");
        var btnPublish = $("#btnPublish");
        var Top, Right;
        var width;
        width = videoContainerW;
   //     var colorArr = ["#cfaf12", "#12af01", "#981234", "#adefsa", "#db6be4", "#f5264c", "#d34a74"];
        //ç¹å»åå°å¼¹å¹
        btnPublish.bind("click", sendBarrager);
        //çå¬Enteräºä»¶
        document.onkeydown = function (e) {
            if (e.keyCode == 13) {
                sendBarrager();
            }
        }
        //åéå¼¹å¹å½æ°
        function sendBarrager() {
            var creSpan = $("<span class='stringSend'></span>");
            //inputè¾å¥æ¡éé¢çåå®¹
            var text = $("#btnBulletinput").val();
            //æ·»å åç´ éé¢çåå®¹
            creSpan.text(text);
            $("#btnBulletinput").val("");
            
            var Yrandom = Math.random();
            do{
                Yrandom = Math.random();
            }while(Yrandom <= 0.5)
                
           
            //console.log(Math.random());

            Top = parseInt(videoContainerH * (Math.random()));
           
            if (Top > videoContainerH - 150) {
                //è·ç¦»é¡¶é¨çä½ç½®
                Top = videoContainerH - 150;
            }

            creSpan.css({ "top": Top, "right": -300, "color": "#a23" });
            videoContainer.append(creSpan);
            var spanDom = $("#videoContainer>span:last-child");
            spanDom.stop().animate({ "right": videoContainerW + 300 }, 10000, "linear", function () {
                $(this).remove();
            });
        }
	</script>
</body>

</html>