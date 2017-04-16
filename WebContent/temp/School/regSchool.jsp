<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册学校</title>
</head>
<body>
注册学校
<form name="regSchool" action="checkRegSchool" method="post">
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
	<label><input name="label" type="checkbox" value="研究生院" />研究生院 </label> <br/>
	备注信息：<textarea name="schoolInformation" ></textarea>
</form>
</body>
</html>