<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
    <title>${requestScope.functionTitle} - 山东省教育教学改革项目</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <script type="text/javascript" src="assets/js/jquery.js"></script>

    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/loader-style.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css">

    <link rel="stylesheet" href="assets/js/button/ladda/ladda.min.css">
    
    <link href="assets/js/iCheck/flat/all.css" rel="stylesheet">
    <link href="assets/js/iCheck/line/all.css" rel="stylesheet">





    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="assets/ico/minus.png">
</head>

<body>
    <!-- Preloader -->
    <div id="preloader">
        <div id="status">&nbsp;</div>
    </div>
    <!-- TOP NAVBAR -->
    <nav role="navigation" class="navbar navbar-static-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button data-target="#bs-example-navbar-collapse-1" data-toggle="collapse" class="navbar-toggle" type="button">
                    <span class="entypo-menu"></span>
                </button>
                <button class="navbar-toggle toggle-menu-mobile toggle-left" type="button">
                    <span class="entypo-list-add"></span>
                </button>




                <div id="logo-mobile" class="visible-xs">
                   <h1>教育改革 <span>v1.0</span></h1>
                </div>

            </div>


            <!-- Collect the nav links, forms, and other content for toggling -->
            <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
                <div id="nt-title-container" class="navbar-left running-text visible-lg">
                    <ul class="date-top">
                        <li class="entypo-calendar" style="margin-right:5px"></li>
                        <li id="Date"></li>


                    </ul>

                    <ul id="digital-clock" class="digital">
                        <li class="entypo-clock" style="margin-right:5px"></li>
                        <li class="hour"></li>
                        <li>:</li>
                        <li class="min"></li>
                        <li>:</li>
                        <li class="sec"></li>
                        <li class="meridiem"></li>
                    </ul>
                    <ul id="nt-title">
                        <li>
                        	欢迎进入网站学习，暂无公告
                        </li>
                        <li>
                        	<a href="http://jwc.qfnu.edu.cn" target="_blank"><font color="white">曲阜师范大学 2017年招生公告</font></a>
                        </li>


                    </ul>
                </div>

                <ul style="margin-right:0;" class="nav navbar-nav navbar-right">
                    <li>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <img alt="" class="admin-pic img-circle" src="http://api.randomuser.me/portraits/thumb/men/10.jpg">您好, 曹燕妮同学<b class="caret"></b>
                        </a>
                        <ul style="margin-top:14px;" role="menu" class="dropdown-setting dropdown-menu">
                             <li>
                                <a href="#">
                                    <span class="entypo-user"></span>&#160;&#160;我的主页</a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="entypo-vcard"></span>&#160;&#160;账号设置</a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="entypo-lifebuoy"></span>&#160;&#160;在线帮助</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="http://themeforest.net/item/apricot-navigation-admin-dashboard-template/7664475?WT.ac=category_item&WT.z_author=themesmile">
                                    <span class="entypo-basket"></span>&#160;&#160; 购买课程</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="icon-gear"></span>&#160;&#160;风格设置</a>
                        <ul role="menu" class="dropdown-setting dropdown-menu">

                            <li class="theme-bg">
                                <div id="button-bg"></div>
                                <div id="button-bg2"></div>
                                <div id="button-bg3"></div>
                                <div id="button-bg5"></div>
                                <div id="button-bg6"></div>
                                <div id="button-bg7"></div>
                                <div id="button-bg8"></div>
                                <div id="button-bg9"></div>
                                <div id="button-bg10"></div>
                                <div id="button-bg11"></div>
                                <div id="button-bg12"></div>
                                <div id="button-bg13"></div>
                            </li>
                        </ul>
                    </li>
                    <li class="hidden-xs">
                        <a class="toggle-left" href="#">
                            <span style="font-size:20px;" class="entypo-list-add"></span>
                        </a>
                    </li>
                </ul>

            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- /END OF TOP NAVBAR -->

    <!-- SIDE MENU -->
    <div id="skin-select">
        <div id="logo">
            <h1>联合教育
                <span>v1.0</span>
            </h1>
        </div>

        <a id="toggle">
            <span class="entypo-menu"></span>
        </a>




        <div class="skin-part">
            <div id="tree-wrap">
                <div class="side-bar">
                    <ul class="topnav menu-left-nest">
                        <li>
                            <a href="#" style="border-left:0px solid!important;" class="title-menu-left">

                                <span>在线教育</span>
                                <i data-toggle="tooltip" class="entypo-cog pull-right config-wrap"></i>

                            </a>
                        </li>

                        <li>
                            <a class="tooltip-tip ajax-load" href="#" title="Blog App">
                                <i class="icon-document-edit"></i>
                                <span>开始学习</span>

                            </a>
                            <ul>
                                <li>
                                    <a class="tooltip-tip2 ajax-load" href="blog-list.html" title="Blog List"><i class="entypo-doc-text"></i><span>S2SH轻量级企业解决方案</span></a>
                                </li>
                                <li>
                                    <a class="tooltip-tip2 ajax-load" href="blog-detail.html" title="Blog Detail"><i class="entypo-newspaper"></i><span>软件工程</span></a>
                                </li>
                                <li>
                                    <a class="tooltip-tip2 ajax-load" href="blog-list.html" title="Blog List"><i class="entypo-doc-text"></i><span>算法设计与分析</span></a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a class="tooltip-tip ajax-load" href="social.html" title="Social">
                                <i class="icon-feed"></i>
                                <span>在线指导</span>

                            </a>
                        </li>
                        <li>
                            <a class="tooltip-tip ajax-load" href="media.html" title="Media">
                                <i class="icon-camera"></i>
                                <span>电子教案</span>

                            </a>
                        </li>
                    </ul>

                    <ul class="topnav menu-left-nest">
                        <li>
                            <a href="#" style="border-left:0px solid!important;" class="title-menu-left">

                                <span class="#">在线选课</span>
                                <i data-toggle="tooltip" class="entypo-cog pull-right config-wrap"></i>

                            </a>
                        </li>

                        <li>
                            <a class="tooltip-tip ajax-load" href="index.html" title="Dashboard">
                                <i class="icon-window"></i>
                                <span>课堂大厅</span>

                            </a>
                        </li>
                        <li>
                            <a class="tooltip-tip ajax-load" href="mail.html" title="Mail">
                                <i class="icon-mail"></i>
                                <span>我的学校</span>
                                <div class="noft-blue">曲阜师范大学</div>
                            </a>
                        </li>

                        <li>
                            <a class="tooltip-tip ajax-load" href="icon.html" title="Icons">
                                <i class="icon-preview"></i>
                                <span>我的企业</span>
                                <div class="noft-blue" style="display: inline-block; float: none;">HP惠普</div>
                            </a>
                        </li>

                    </ul>

                    <ul id="menu-showhide" class="topnav menu-left-nest">
                        <li>
                            <a href="#" style="border-left:0px solid!important;" class="title-menu-left">

                                <span class="#">个人管理</span>
                                <i data-toggle="tooltip" class="entypo-cog pull-right config-wrap"></i>

                            </a>
                        </li>


                        <li>
                            <a class="tooltip-tip" href="#" title="UI Element">
                                <i class="icon-monitor"></i>
                                <span>我的账户</span>
                            </a>
                            <ul>
                                <li>
                                    <a class="tooltip-tip2 ajax-load" href="element.html" title="Element"><i class="icon-attachment"></i><span>个人资料</span></a>
                                </li>
                                
                            </ul>
                        </li>
                        <li>
                            <a class="tooltip-tip" href="#" title="Form">
                                <i class="icon-document"></i>
                                <span>历史记录</span>
                            </a>

                        </li>
                        <li>
                            <a class="tooltip-tip" href="#" title="Tables">
                                <i class="icon-view-thumb"></i>
                                <span>退出登录</span>
                            </a>
                            <ul>
                                <li>
                                    <a class="tooltip-tip2 ajax-load" href="table-static.html" title="Table Static"><i class="entypo-layout"></i><span>Table Static</span></a>
                                </li>
                                <li>
                                    <a class="tooltip-tip2 ajax-load" href="table-dynamic.html" title="Table Dynamic"><i class="entypo-menu"></i><span>Table Dynamic</span></a>
                                </li>
                            </ul>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- END OF SIDE MENU -->



    <!--  PAPER WRAP -->
    <div class="wrap-fluid">
        <div class="container-fluid paper-wrap bevel tlbr">





            <!-- CONTENT -->
            <!--TITLE -->
            <div class="row">
                <div id="paper-top">
                    <div class="col-sm-3">
                        <h2 class="tittle-content-header">
                            <i class="icon-media-record"></i> 
                            <span>${requestScope.functionTitle}
                            </span>
                        </h2>

                    </div>

                    <div class="col-sm-7">
                        <div class="devider-vertical visible-lg"></div>
                        <div class="tittle-middle-header">

                            <div class="alert">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <span class="tittle-alert entypo-info-circled"></span>
                                欢迎回来，&nbsp;
                                <strong>曹燕妮！</strong>&nbsp;&nbsp;您上次登录时间为 3月1日 , 16:54 PM
                            </div>


                        </div>

                    </div>
                </div>
            </div>
            <!--/ TITLE -->

            <!-- BREADCRUMB -->
            <ul id="breadcrumb">
                <li>
                    <span class="entypo-home"></span>
                </li>
                <li><i class="fa fa-lg fa-angle-right"></i>
                </li>
                <li><a href="#" title="Sample page 1">系统首页</a>
                </li>
                <li><i class="fa fa-lg fa-angle-right"></i>
                </li>
                <li><a href="#" title="Sample page 1">${requestScope.functionTitle}</a>
                </li>
            </ul>

            <!-- END OF BREADCRUMB -->

<!--  -->
            <div class="content-wrap">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="nest" id="labelClose">
                            <div class="title-alt">
                                <h6>
                                    请填写学校详细信息</h6>
                                <div class="titleClose">
                                    <a class="gone" href="#labelClose">
                                        <span class="entypo-cancel"></span>
                                    </a>
                                </div>
                                <div class="titleToggle">
                                    <a class="nav-toggle-alt" href="#label">
                                        <span class="entypo-up-open"></span>
                                    </a>
                                </div>

                            </div>

                            <div class="body-nest" id="label">
                                <div class="row">
                                <div class="panel-body">
                                    <div class="col-sm-16"> 
                                        <div class="skin skin-flat">

										<form method="get" class="form-horizontal bucket-form">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">学校名称</label>
                                            <div class="col-sm-6">
                                                <input name="schoolName" type="text" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">高级密码</label>
                                            <div class="col-sm-6">
                                                <input name="schoolPassword" type="text" class="form-control">
                                            </div>
                                        </div>                                        
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">办学层次</label>
                                            <div class="col-sm-6">
                                                	<select name="schoolType">
														<option value="本科高校">普通高校</option>
														<option value="高职院校">高职院校</option>
													</select>
                                            </div>
                                        </div> 
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">学校省份</label>
                                            <div class="col-sm-6">
                                            <ul class="list">
                                                <li>
                                                    <input type="radio" id="square-radio-1" name="square-radio">
                                                    <label for="square-radio-1">北京</label>
                                                </li>
                                                <li>
                                                    <input type="radio" id="square-radio-2" name="square-radio">
                                                    <label for="square-radio-2">天津</label>
                                                </li>
                                            </ul>
                                            </div>
                                        </div> 
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">高级密码</label>
                                            <div class="col-sm-6">
                                                <input name="schoolPassword" type="text" class="form-control">
                                            </div>
                                        </div> 
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">高级密码</label>
                                            <div class="col-sm-6">
                                                <input name="schoolPassword" type="text" class="form-control">
                                            </div>
                                        </div> 
                                            <ul class="list">
                                                <li>
                                                    <input tabindex="13" type="checkbox" id="flat-checkbox-1">
                                                    <label for="flat-checkbox-1">Checkbox 1</label>
                                                </li>
                                                <li>
                                                    <input tabindex="14" type="checkbox" id="flat-checkbox-2" checked="">
                                                    <label for="flat-checkbox-2">Checkbox 2</label>
                                                </li>
                                                <li>
                                                    <input type="checkbox" id="flat-checkbox-disabled" disabled="">
                                                    <label for="flat-checkbox-disabled">Disabled</label>
                                                </li>
                                                <li>
                                                    <input type="checkbox" id="flat-checkbox-disabled-checked" checked="" disabled="">
                                                    <label for="flat-checkbox-disabled-checked">Disabled &amp; checked</label>
                                                </li>
                                            </ul>

                                            <div style="clear:both;"></div>
                                            </form>
                                        </div>
                                    </div> 

									</div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
<!--  -->
            <div class="content-wrap">
                <div class="row">


                    <div class="col-sm-12">
                        <!-- BLANK PAGE-->

                        <div class="nest" id="Blank_PageClose">
                            <div class="title-alt">
                                <h6>
                                    学校详细信息</h6>
                                <div class="titleClose">
                                    <a class="gone" href="#Blank_PageClose">
                                        <span class="entypo-cancel"></span>
                                    </a>
                                </div>
                                <div class="titleToggle">
                                    <a class="nav-toggle-alt" href="#Blank_Page_Content">
                                        <span class="entypo-up-open"></span>
                                    </a>
                                </div>

                            </div>

                            <div class="body-nest" id="Blank_Page_Content">

                              
<form name="regSchool" action="checkRegSchool.action" method="post">
	学校名称：<input name="schoolName" type="text" /><br/>
	学校高级密码：<input name="schoolPassword" type="text" /><br/>
	办学层次：<select name="schoolType">
		<option value="本科高校">普通高校</option>
		<option value="高职院校">高职院校</option>
	</select><br/>
	学校所在省份：
	<label><input name="location" type="radio" value="北京" />北京 </label> 
	<label><input name="location" type="radio" value="天津" />天津</label> 
	<label><input name="location" type="radio" value="上海" />上海 </label> 
	<label><input name="location" type="radio" value="山东" />山东</label> 
	<label><input name="location" type="radio" value="江苏" />江苏 </label> 
	<label><input name="location" type="radio" value="河北" />河北</label> 
	<label><input name="location" type="radio" value="山西" />山西</label> 
	<label><input name="location" type="radio" value="内蒙古" />内蒙古</label> 
	<label><input name="location" type="radio" value="辽宁" />辽宁</label> 
	<label><input name="location" type="radio" value="吉林" />吉林</label> 
	<label><input name="location" type="radio" value="黑龙江" />黑龙江</label> 
	<label><input name="location" type="radio" value="浙江" />浙江</label> 
	<label><input name="location" type="radio" value="安徽" />安徽</label> 
	<label><input name="location" type="radio" value="福建" />福建</label>
	<label><input name="location" type="radio" value="江西" />江西</label> 
	<label><input name="location" type="radio" value="河南" />河南</label> 
	<label><input name="location" type="radio" value="湖南" />湖南</label> 
	<label><input name="location" type="radio" value="湖北" />湖北</label> 
	<label><input name="location" type="radio" value="广东" />广东</label> 
	<label><input name="location" type="radio" value="广西" />广西</label> 
	<label><input name="location" type="radio" value="海南" />海南</label> 
	<label><input name="location" type="radio" value="重庆" />重庆</label> 
	<label><input name="location" type="radio" value="四川" />四川</label> 
	<label><input name="location" type="radio" value="贵州" />贵州</label> 
	<label><input name="location" type="radio" value="云南" />云南</label> 
	<label><input name="location" type="radio" value="西藏" />西藏</label> 
	<label><input name="location" type="radio" value="陕西" />陕西</label> 
	<label><input name="location" type="radio" value="甘肃" />甘肃</label> 
	<label><input name="location" type="radio" value="青海" />青海</label> 
	<label><input name="location" type="radio" value="宁夏" />宁夏</label> 
	<label><input name="location" type="radio" value="新疆" />新疆</label> <br/>
	院校分类：
	<label><input name="type" type="radio" value="综合类" />综合类</label>
	<label><input name="type" type="radio" value="理工类" />理工类</label>
	<label><input name="type" type="radio" value="财经类" />财经类</label>
	<label><input name="type" type="radio" value="师范类" />师范类</label>
	<label><input name="type" type="radio" value="语言类" />语言类</label>
	<label><input name="type" type="radio" value="政法类" />政法类</label>
	<label><input name="type" type="radio" value="民族类" />民族类</label>
	<label><input name="type" type="radio" value="农林类" />农林类</label>
	<label><input name="type" type="radio" value="医药类" />医药类</label>
	<label><input name="type" type="radio" value="艺术类" />艺术类</label>
	<label><input name="type" type="radio" value="体育类" />体育类</label>
	<label><input name="type" type="radio" value="军事类" />军事类</label><br/>
	办学特色：
	<label><input name="label" type="checkbox" value="985高校" />985高校 </label> 
	<label><input name="label" type="checkbox" value="211高校" />211高校 </label> 
	<label><input name="label" type="checkbox" value="研究生院" class="iradio_flat-red" />研究生院 </label> <br/>
	备注信息：<textarea name="schoolInformation" ></textarea>
	<input type="submit" value="注册学校">
</form>
                               
                               
                               
                               
                               
                               
                               
                               
                            </div>
                        </div>
                    </div>
                    <!-- END OF BLANK PAGE -->


                </div>



                <!-- /END OF CONTENT -->



                <!-- FOOTER -->
                <div class="footer-space"></div>
                <div id="footer">
                    <div class="devider-footer-left"></div>
                    <div class="time">
                        <p id="spanDate">
                        <p id="clock">
                    </div>
                    <div class="copyright">曲阜师范大学
                         All Rights Reserved</div>
                    <div class="devider-footer"></div>

                </div>
                <!-- / END OF FOOTER -->


            </div>
        </div>
        <!--  END OF PAPER WRAP -->

       


        <!-- MAIN EFFECT -->
        <script type="text/javascript" src="assets/js/iCheck/jquery.icheck.js"></script>
        <script type="text/javascript" src="assets/js/preloader.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.js"></script>
        <script type="text/javascript" src="assets/js/app.js"></script>
        <script type="text/javascript" src="assets/js/load.js"></script>
        <script type="text/javascript" src="assets/js/main.js"></script>


</div>
<script>
    $(document).ready(function() {
        //CHECKBOX PRETTYFY
        $('.skin-flat input').iCheck({
            checkboxClass: 'icheckbox_flat-red',
            radioClass: 'iradio_flat-red'
        });
        $('.skin-line input').each(function() {
            var self = $(this),
                label = self.next(),
                label_text = label.text();

            label.remove();
            self.iCheck({
                checkboxClass: 'icheckbox_line-blue',
                radioClass: 'iradio_line-blue',
                insert: '<div class="icheck_line-icon"></div>' + label_text
            });
        });
        //Switch Button

    });
    </script>

</body>

</html>
