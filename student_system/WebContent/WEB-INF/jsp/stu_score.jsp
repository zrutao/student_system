<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="myTag_score" uri="http://itheima/myTag_score/"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统--学生成绩管理</title>

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
<body>
	<div class="container">
	    <!-- logo部分 -->
		<div class="row">
		  <div class="col-md-1 col-sm-2 col-xs-2"><a href="#"><img src="CSS/images/logo.png" /></a></div>
		  <div class="col-md-10 hidden-sm hidden-xs"><img src="CSS/images/rt.png" /></div>
		  <div class="hidden-lg hidden-md col-sm-8 col-xs-7"><img src="CSS/images/logo2.png" /></div>
		  <div class="col-md-1 col-sm-2 col-xs-3" style="line-height: 60px;height: 60px;">
			  <%
		    String name=(String)request.getAttribute("admin_no");
		    if(name !=null)
		    {
		    	Cookie cookie=new Cookie("name",name);
		    	cookie.setMaxAge(60*60*24*7);
		    	response.addCookie(cookie);
		    }
		    else
		    {
		    	Cookie[] cookies=request.getCookies();
		    	if(name ==null && cookies.length>0)
		    	{
		    		for(Cookie cookie:cookies)
		    		{
		    			String cookiename=cookie.getName();
		    			if(cookiename.equals("name"))
		    			{
		    				String val=cookie.getValue();
		    				name=val;
		    			}
		    		}
		    	}
		    }
		    request.setAttribute("admin_no", name); 
		    if(name !=null)
		    {
		    	out.print(name+"  ");
		    	out.print("<a href='exit.html'>退出</a>");
		    }
		    else
		    {
		    	response.sendRedirect("login.html");
		    }
		    %>
		  </div>
		</div>
		<!-- 导航部分 -->
		<nav class="navbar navbar-inverse">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
			<a class="navbar-brand" href="index.html">首页</a>
		</div>
		
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	     		<ul class="nav navbar-nav">
		       		<li><a href="myself1.html">个人介绍</a></li>
		        	<li><a href="student.html">学生信息管理<span class="sr-only">(current)</span></a></li>
		        	<li><a href="teacher.html">教师信息管理</a></li>
		        	<li class="active"><a href="stu_score.html">学生成绩管理</a></li>
		        	<li><a href="stu_class.html">课程信息管理</a></li>
		        	<li><a href="system.html">系统管理</a></li>
	      		</ul>
	   </div>
	   </nav>
	   <!-- 选择框等 -->
	   <div class="row">
			<div class="col-lg-12">
				<h3>学生成绩管理</h3>
			</div>
	   </div>
	   <div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline" action="stu_score.html" method="get">
					
					
						<div class="form-group">
							<label for="customerName">学年：</label> 
							<select	class="form-control" name="student_year">
								<option value="请选择">请选择</option>
							    <c:forEach items="${stu_year}" var="item">
							    	<option value="${item.student_year}" <c:if test="${item.student_year == return_type.student_year}"> selected</c:if>>${item.student_year}</option>
							    </c:forEach>
							</select>
						</div>
						
						<div class="form-group">
							<label for="customerName">级别：</label> 
							<select	class="form-control" name="grade_name">
								<option value="请选择">请选择</option>
							    <c:forEach items="${grade_type}" var="item">
							    	<option value="${item.grade_name}" <c:if test="${item.grade_name == return_type.grade_name}"> selected</c:if>>${item.grade_name}</option>
							    </c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="customerFrom">班别：</label> 
							<select class="form-control" name="class_name">
							    <option value="请选择">请选择</option>
								    <c:forEach items="${class_type}" var="item">
								    	<option value="${item.class_name}" <c:if test="${item.class_name == return_type.class_name}"> selected</c:if>>${item.class_name}</option>
								    </c:forEach>
							</select> 
						</div>
						<div class="form-group">
							<label for="custIndustry">姓名：</label> 
							<input type="text" class="form-control" id="customerName" value="${return_type.student_name }" name="student_name">
						</div>
						<div class="form-group">
							<label for="custLevel">学号：</label>
							<input type="text" class="form-control" id="customerName" value="${return_type.student_no }" name="student_no">
						</div>
						<button type="submit" class="btn btn-primary">查询</button>
						<input type="button" class="btn btn-primary" value="导出">
						<input type="button" class="btn btn-primary" value="插入">
					</form>
				</div>
			</div>
			<!-- 显现表格 -->
			<div class="table-responsive">
			<table class="table table-bordered table-striped">
				<tr>
				    <td style="text-align: center">年度</td>
					<td style="text-align: center">学期</td>
					<td style="text-align: center">学号</td>
					<td style="text-align: center">姓名</td>
					<td style="text-align: center">年级</td>
					<td style="text-align: center">班级</td>
					<td style="text-align: center">课程</td>
					<td style="text-align: center">成绩</td>
					<td style="text-align: center">类型</td>
					<td style="text-align: center">操作</td>
				</tr>
				<c:forEach items="${student}" var="item">
					<tr>
						<td style="text-align: center">${item.student_year}</td>
						<td style="text-align: center">${item.term}</td>
						<td style="text-align: center">${item.student_no}</td>
						<td style="text-align: center">${item.student_name}</td>
						<td style="text-align: center">${item.grade_name}</td>
						<td style="text-align: center">${item.class_name}</td>
						<td style="text-align: center">${item.course_no}</td>
						<td style="text-align: center">${item.score}</td>
						<td style="text-align: center">${item.type}</td>
						<td style="text-align: center"><input class="btn btn-warning" type="button"
							value="修改" /> <input  class="btn btn-danger"
							 type="button" value="删除"
							onclick="stu_delete('${item.student_no}')" /></td>
					</tr>
				</c:forEach>
			</table></div>
	<div id="page">
		<myTag_score:out></myTag_score:out>
	</div>
	<div class="clear"></div>
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