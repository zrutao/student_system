<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统--登录</title>

<!-- Bootstrap Core CSS -->
<link href="CSS/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="CSS/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="CSS/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="CSS/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="CSS/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="CSS/boot-crm.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>

<!--移动设备（手机等）  -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="CSS/jquery-ui.css" rel="stylesheet">
<!-- 自定义的样式 -->
<link href="CSS/index.css" rel="stylesheet">
<script type="text/javascript">

</script>
<style type="text/css">
			body{background: url(CSS/images/login2.jpg) no-repeat;background-size:cover;font-size: 16px;}
			.form{background: rgba(255,255,255,0.3);width:350px;margin:100px auto;}
			#login_form{display: block;}
			#register_form{display: none;}
			.fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
			input[type="text"],input[type="password"]{padding-left:26px;}
			.checkbox{padding-left:21px;}
</style>
<body>
	<div class="container">
	    <div class="form row">
			<form action="verification.html" method="post" class="form-horizontal col-sm-offset-2 col-md-offset-2" id="login_form">
				<h3 class="form-title">测试环境</h3>
				<div class="col-sm-9 col-md-9">
					<div class="form-group">
						<i class="fa fa-user fa-lg"></i>
						<input class="form-control required" type="text" placeholder="用户账号" name="username" autofocus="autofocus" maxlength="20"/>
					</div>
					<div class="form-group">
							<i class="fa fa-lock fa-lg"></i>
							<input class="form-control required" type="password" placeholder="用户密码" name="password" maxlength="8"/>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-success pull-right" value="登录 "/>   
					</div>
				</div>
			</form>
		</div>
	    
	<!-- 版权 -->
		<div style="text-align: center;">
					<a href="#">关于我们</a>
					<a href="#">联系我们</a>
					<a href="#">招贤纳士</a>
					<a href="#">法律声明</a>
					<a href="#">友情链接</a>
					<a href="#">配送方式</a>
					<a href="#">服务声明</a>
					<a href="#">广告声明</a>
					
					<br />
					苏公网安备 32048102000396号 苏ICP备17016123号许可证：粤B2-20110009
					<br />
					Copyright © 欢迎来到RT第一小学 2019-2029,All Rights Reserved
					<br />
					凡本网注明"zhaorutao.xyz"的所有作品，包括文字、图片、程序等，版权均属于欢迎来到RT第一小学所有，未经同意，不得用于商业用途。
					<br />
					本站通用网址：欢迎来到RT第一小学-教务管理系统
					<br />
					全国统一服务电话：13725406876
					<br />
					制作者：赵汝涛（RT）
			</div>
	</div>
</body>
</html>