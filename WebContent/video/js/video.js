$(document).ready(function () {
	//INITIALIZE
	var video = $('#myVideo');
	var videojs = document.getElementById('myVideo');
//  $('.caption').mouseenter(function(){
//     $('.caption').addClass("")
//$('.bottomContainer').css("opacity",1);

//});
//$(".caption").mouseleave(function(){
//	 $('.caption').css("opacity",0);
//$('.bottomContainer').css("opacity",0);
//});
//$('.bottomContainer').mouseenter(function(){
//	   $('.caption').css("opacity",1);
//$('.bottomContainer').css("opacity",1);

//});
//$('.bottomContainer').mouseleave(function(){
//$('.caption').css("opacity",0);
//$('.bottomContainer').css("opacity",0);
//});
//$('.bottomContainer').css("filter","opacity(100%)");
	//移除控制栏
	//video[0].removeAttribute("controls");
	//.caption淡出
	//  $('.caption').css("opacity",0);
	//  $('.bottomContainer').css("opacity",0);
		
	$('#btnNext').bind('click',function(){
		 video[0].currentTime =  video[0].currentTime +5;
	});
	$("#btnPlay").css('display','block');
	$("#btnPause").css('display','none');
	//控制
//speed text clicked
	$('#btnSpeed1').on('click', function() { fastfowrd(this, 0.5); });
	$('#btnSpeed2').on('click', function() { fastfowrd(this, 0.75); });
	$('#btnSpeed3').on('click', function() { fastfowrd(this, 1.0); });
	$('#btnSpeed4').on('click', function() { fastfowrd(this, 1.25); });
	$('#btnSpeed5').on('click', function() { fastfowrd(this, 1.5); });
	$('#btnSpeed6').on('click', function() { fastfowrd(this, 1.75); });
	$('#btnSpeed7').on('click', function() { fastfowrd(this, 2.0); });
	var fastfowrd = function(obj, spd) {
		$('.text').removeClass('selected');
		$(obj).addClass('selected');
		video[0].playbackRate = spd;

	};
	/*全屏*/
	$("#btnFullScreenIn").bind("click",function(){
		launchFullscreen(document.getElementById('videoContainer'));
		$("#btnFullScreenIn").css("display","none");
		$("#btnFullScreenOut").css("display","block");
	});
	/*全屏*/
		$("#btnFullScreenOut").bind("click",function(){
		exitFullscreen();
		$("#btnFullScreenOut").css("display","none");
		$("#btnFullScreenIn").css("display","block");
	})
	//弹幕
	var tagBu = 1;
	$("#btnpublishbtn").bind("click",function(){
		if(tagBu){
				$("#btnBulletinput").removeClass("fromRight");
			$("#btnPublish").removeClass("fromRight");
			$("#btnBulletinput").css("display","block");
		$("#btnBulletinput").addClass("fromRight");
		$("#btnPublish").css("display","block");
		$("#btnPublish").addClass("fromRight");
		$("#btnBulletinput").focus();
			tagBu=0;
			}
		else{
				$("#btnBulletinput").fadeOut(1000);
			$("#btnPublish").fadeOut(1000);
				
				tagBu = 1;
			}
	});
	//弹幕开关
	$("#promptSwitchClose").bind("click",function(){
		$("#promptSwitchClose").css("display","none");
		$("#promptSwitchOn").css("display","block");
	})
	$("#promptSwitchOn").bind("click",function(){
		$("#promptSwitchOn").css("display","none");
		$("#promptSwitchClose").css("display","block");
	})
	/*开关灯*/
	var lightTag = 1;
	$("#btnlight").bind('click',function(){
		
		
		
		//if lightoff, create an overlay
		if(lightTag) {
			$(".btnLightIn").css("display","none");
			console.log("关灯灯");
			$('body').append('<div class="overlay"></div>');
			$('.overlay').css({
				'position':'absolute',
				'width':100+'%',
				'height':$(document).height(),
				'background':'#000',
				'opacity':0.9,
				'top':0,
				'left':0,
				'z-index':999
			});
			$('#videoContainer').css({
				'z-index':1000
			});
			lightTag=0;
		}
		//if lighton, remove overlay
		else {
			console.log("开灯");
			$(".btnLightIn").css("display","block");
			lightTag =1;
			$('.overlay').remove();
		}
	});
	
	
	//音量
	var volumep = 0;
	var volumeTrue = 1;
	$("#trumpt").bind("click",function(){
			$("#trumptN").css("display","block");
		$("#trumpt").css("display","none");
		video[0].muted = true;
		$('.volumeBar').css('width', '0%');
		volumeTrue = 0;
	});
	
	$("#trumptN").bind("click",function(){
		$("#trumptN").css("display","none");
		$("#trumpt").css("display","block");
		$('.volumeBar').css('width', volumep + '%');
		$('input').removeAttr("disabled");//去除input元素的disabled属性
		volumeTrue = 1;
		video[0].muted = false;
	});
	//音量 ++
		var volumeDrag = false;
	$('.volume').on('mousedown', function(e) {
		volumeDrag = true;
		
	
		updateVolume(e.pageX);
			
	});
	$(document).on('mouseup', function(e) {
		if(volumeDrag) {
			volumeDrag = false;
			updateVolume(e.pageX);
		}
	});
	$(document).on('mousemove', function(e) {
		if(volumeDrag) {
			updateVolume(e.pageX);
		}
	});

		/*声音 */
	function updateVolume(x, vol) {
		var volume = $('#volume');
		var percentage;
		//if only volume have specificed
		//then direct update volume
		
		if (vol) {
			percentage = vol * 100;
		} else {
			var position = x - volume.offset().left;
			
			percentage = 100 * position / volume.width();
		}
		
		if (percentage > 100) {
			percentage = 100;
		}
		if (percentage < 0) {
			percentage = 0;
		}
		if(percentage<50 && percentage>0){
			$("#trumpt1").css("display","none");
			$("#trumpt2").css("display","none");
		}
		if(percentage>50 && percentage<100){
			$("#trumpt1").css("display","block");
			$("#trumpt2").css("display","block");
		}
		video[0].muted = false;
		$("#trumptN").css("display","none");
$("#trumpt").css("display","block");
$('input').removeAttr("disabled");//去除input元素的disabled属性

		//update volume bar and video volume
		$('.volumeBar').css('width', percentage + '%');
		video[0].volume = percentage / 100;
		volumep = percentage;

	};
	
	
	//before everything get started
	video.on('loadedmetadata', function() {
		//console.log("执行了");
		//start to get video buffering data 
		setTimeout(startBuffer, 150);

		//set video properties
		$('.current').text(timeFormat(0));
		/*duration返回当前视频的长度*/
		//$('.duration').text(timeFormat(video[0].duration));
		updateVolume(0, 0.7);

		//bind video events
// 		$('#myVideo')
//			.hover(function () {
//				/*	$('.control').stop().animate({
//				'bottom': 0
//				}, 500);*/
//				$('.caption').stop();
//				$('.caption').fadeIn();
//				$('.bottomContainer').stop();
//				$('.bottomContainer').fadeIn();
//				if($("#videoContainer").width()==document.body.clientWidth){
//setTimeout(disappearC,4000);
//				}

//			//	console.log("inin");
//			}, function () {
//				$('.caption').fadeOut();
//				$('.bottomContainer').fadeOut();
//			//	console.log("outout");
//		});
//		function disappearC(){
//			$('.caption').fadeOut();
//				$('.bottomContainer').fadeOut();

					
//		}
	// $('.caption')
	// 		.hover(function () {
	// 			/* Stuff to do when the mouse enters the element */
	// 					$('.caption').stop();
	// 			$('.bottomContainer').stop();
	// 		$('.bottomContainer').css("display","block");
	// 			$('.caption').css("display","block");
	// 		}, function () {
	// 			/* Stuff to do when the mouse leaves the element */
	// 		});
	// 		$('.bottomContainer')
	// 		.hover(function () {
	// 			/* Stuff to do when the mouse enters the element */
	// 									$('.caption').stop();
	// 			$('.bottomContainer').stop();
	// 			$('.bottomContainer').css("display","block");
	// 			$('.caption').css("display","block");
	// 		}, function () {
	// 			/* Stuff to do when the mouse leaves the element */
		
	// 		});
	});
	// videojs.addEventListener('mousemove',move,true);

	// function move(e){
	// //var e=event || window.event;
	// var y=e.clientY-videojs.offsetTop;
	// if(y>46.67){
//	 	console.log("best");
//	 		$('.bottomContainer').css("display","block");
//	 		$('.caption').css("display","block");
	// }else{
//	 	console.log("best	n"+y);
		
	// }
	// }
	//CONTROLS EVENTS
	//video screen and play button clicked
	video.bind('click', function () {
		playpause();
	});
	$('#btnPlay').bind('click', function () {
			play();
		});
	$("#btnPause").bind('click', function () {
			pause();
		});
	function playpause() {
		if (video[0].paused || video[0].ended) {
			video[0].play();
			$("#btnPlay").css('display','none');
			$("#btnPause").css('display','block');
		}
		else {
			//$('.btnPlay').removeClass('paused');
			video[0].pause();
			$("#btnPlay").css('display','block');
			$("#btnPause").css('display','none');
		}
	};
	function play(){
		video[0].play();
		$("#btnPlay").css('display','none');
			$("#btnPause").css('display','block');
	}
	function pause(){
		video[0].pause();
		$("#btnPlay").css('display','block');
			$("#btnPause").css('display','none');
	}
	
	//video canplaythrough event
	//solve Chrome cache issue
	var completeloaded = false;
	video.on('canplaythrough', function() {
		completeloaded = true;
	});
	
	  $("#weixin_show").click(function() {
      $("#pop").show()
    });
    $("#pop").click(function() {
      $("#pop").hide()
    });
	
	
	
	//video seeking event
	video.on('seeking', function() {
		//if video fully loaded, ignore loading screen
		if(!completeloaded) { 
			$('#loading').css("display","block");
		}	
	});
	
		
	//video seeked event
	video.on('seeked', function() { });
	
	//video waiting for more data event
	video.on('waiting', function() {
		$('#loading').css("display","block");
	});
	
	//VIDEO EVENTS
	//video canplay event
	video.on('canplay', function() {
		$('#loading').css("display","none");
	});
	
	//display current video play time
	video.bind('timeupdate', function () {
		var currentPos = video[0].currentTime;
		var maxduration = video[0].duration;
		var lastTime =maxduration - currentPos;
		var perc = 100 * currentPos / maxduration;
		//$('.toptimeBar').css('display', 'block');
		$('.toptimeBar').css('left', perc + '%');
		
		$('.timeBar').css('width', perc + '%');
		$('.current').text("-"+timeFormat(lastTime));
	});
	
	
	//鼠标移上 progress 显示鼠标指示的时间

		var progress=document.getElementById('progress');

		progress.addEventListener('mousemove',movein,false);
		progress.addEventListener('mouseout',moveout,false);
		function movein(e){
		var x=e.pageX-progress.offsetLeft;
		var progresswi = $('#progress').width();
		var maxduration = video[0].duration;
		var cul = x/progresswi;
		var cu = (x/progresswi)*maxduration;
		cu = cu.toFixed(0);
		cu = timeFormat(cu);
		$('.currentTip').stop();
		$('.currentTip').fadeIn();
		$('.currentTip').css("margin-left",x);
		//console.log(x);
		$('.currentTip').text(cu);

		}
		function moveout() {
			$('.currentTip').stop();
			$('.currentTip').fadeOut();
		}



	//VIDEO PROGRESS BAR
	//when video timebar clicked
    var timeDrag = false;	/* check for drag event */
	console.log("1");
    $('.progress').on('mousedown', function(e) {
        timeDrag = true;
        console.log("2");
        updatebar(e.pageX);
		
    });
    $(document).on('mouseup', function(e) {
        if(timeDrag) {
            timeDrag = false;
            console.log("3");
            updatebar(e.pageX);
        }
    });
    $(document).on('mousemove', function(e) {
        if(timeDrag) {
            console.log("4");
            updatebar(e.pageX);
        }
    });
    var updatebar = function(x) {
        var progress = $('.progress');

        //calculate drag position
        //and update video currenttime
        //as well as progress bar
        var maxduration = video[0].duration;
        var position = x - progress.offset().left;
        var percentage = 100 * position / progress.width();
        if(percentage > 100) {
            percentage = 100;
        }
        if(percentage < 0) {
            percentage = 0;
        }
        $('.timeBar').css('width',percentage+'%');
		console.log("video[0].currentTime     "+maxduration * percentage / 100);
        video[0].currentTime = maxduration * percentage / 100;
    };



    //display video buffering bar
	var startBuffer = function () {
		var currentBuffer = video[0].buffered.end(0);
		//console.log(currentBuffer);
		var maxduration = video[0].duration;
		var perc = 100 * currentBuffer / maxduration;
		$('.bufferBar').css('width', perc + '%');
		//
		if (currentBuffer < maxduration) {
			setTimeout(startBuffer, 500);
		}
	};



	//Time format converter - 00:00
	function timeFormat(seconds) {
		var m = Math.floor(seconds / 60) < 10 ? "0" + Math.floor(seconds / 60) : Math.floor(seconds / 60);
		var s = Math.floor(seconds - (m * 60)) < 10 ? "0" + Math.floor(seconds - (m * 60)) : Math.floor(seconds - (m * 60));
		return m + ":" + s;
	};
});