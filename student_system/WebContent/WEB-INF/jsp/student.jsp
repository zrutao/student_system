<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="myTag" uri="http://itheima/myTag/"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统--学生管理</title>

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

<!-- 对话框 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<link href="CSS/jquery-ui.css" rel="stylesheet">
<!--移动设备（手机等）  -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="CSS/jquery-ui.css" rel="stylesheet">
<!-- 自定义的样式 -->
<link href="CSS/index.css" rel="stylesheet">
<script type="text/javascript">

<!--插入学生信息-->
function stu_insert()
{
	  $("#dialog_insert").html("<form class='form-inline'><div class='form-group'><label for='custLevel'>学年：</label><input class='form-control' id='s_year' type='text' value=''></div><p><div class='form-group'><label for='custLevel'>学号：</label><input class='form-control' id='s_no' type='text' value=''></div><p><div class='form-group'><label for='custLevel'>姓名：</lable><input class='form-control' id='s_name' type='text' value=''></div><p><div class='form-group'><label for='custLevel'>证件号：</lable><input class='form-control' id='s_id' type='text' value=''></div><p><div class='form-group'><label for='custLevel'>性别：</lable><select class='form-control' id='s_sex'><option value='男'>男</option><option value='女'>女</option></select></div><p><div class='form-group'><label for='custLevel'>出生日期：</label><input class='form-control' id='s_bir' type='text' value=''></div><p><div class='form-group'><label for='custLevel'>年级编号：</label><input class='form-control' id='s_grade' type='text' value=''></div><p><div class='form-group'><label for='custLevel'>班级编号：</label><input class='form-control' id='s_class' type='text' value=''></div><p><div class='form-group'><label for='custLevel'>电话：</label><input class='form-control' id='s_phone' type='text' value=''></div><p><div class='form-group'><label for='custLevel'>地址：</label><input class='form-control' id='s_home' type='text' value=''></div></form>");
	  $("#dialog_insert").dialog({
		  autoOpen:true,
			height:520,
			width:399,
			modal:true,
	        title:'添加学生信息',
			buttons:{
				"确定":function(){
					year=$("#s_year").val();//添加的学年
					no=$("#s_no").val();//添加的学号
					name=$("#s_name").val();//。。。学生姓名
					id=$("#s_id").val();//。。。证件号
					sex=$("#s_sex").val();//。。。性别
					bir=$("#s_bir").val();//。。。出生日期
					grade=$("#s_grade").val();//。。。级别
					classs=$("#s_class").val();//。。。班别
					phone=$("#s_phone").val();//。。。电话
					home=$("#s_home").val();//。。。地址
					$.ajax({
						type:"post",
						url:"student_insert.html",
						data:{
							"stu_year":year,
							"stu_no":no,"stu_name":name,
							"stu_id":id,"stu_sex":sex,"stu_bir":bir,"grade_no":grade,
							"class_no":classs,"stu_phone":phone,"stu_home":home
							},
					    success:function(data)
					    {
					    	switch(data)
					    	{
					    	case "-1":alert("该学号已存在，学号不能重复");break;
					    	case "-2":alert("请输入正确的身份证号码");break;
					    	case "-3":alert("请输入正确出生日期，格式为：YYYY-MM-DD");break;
					    	case "-4":alert("身份证填写的出生日期和填写出生日期不一致");break;
					    	case "2":alert("学号不能为空");break;
					    	case "3":alert("姓名不能为空");break;
					    	case "4":alert("证件号不能为空");break;
					    	case "5":alert("性别不能为空");break;
					    	case "6":alert("出生日期不能为空");break;
					    	case "7":alert("年级不能为空");break;
					    	case "8":alert("班级不能为空");break;
					    	case "9":alert("学年不能为空");break;
					    	case "1":alert("插入学生信息成功！");
					    	window.location.reload();
							$(this).dialog("close");
							callback();
							break;
					    	case "0":alert("插入学生信息失败");
					    	window.location.reload();
							$(this).dialog("close");
							callback();
					    	break;
					    	}
					    }
					});
				},
				"取消":function(){
					$(this).dialog("close");
				}
			},
			close:function(){
				$(this).dialog("close");
			} 
	  });
}

/* 修改 学生信息 */
function stu_update(student_no,student_name,student_id,student_sex,student_bir,grade_no,class_no,student_phone,student_home)
{
	  old_student_no=student_no;//记录原来的学号（未修改时学号）
	  $("#dialog_update").html(
			  "<form class='form-inline'><div class='form-group'><label for='custLevel'>学号：</label><input class='form-control' id='s_no' type='text' value="+student_no+"></div><p><div class='form-group'><label for='custLevel'>姓名：</lable><input class='form-control' id='s_name' type='text' value="+student_name+"></div><p><div class='form-group'><label for='custLevel'>证件号：</lable><input class='form-control' id='s_id' type='text' value="+student_id+"></div><p><div class='form-group'><label for='custLevel'>性别：</lable><select class='form-control' id='ss'><option value='男'>男</option><option value='女'>女</option></select></div><p><div class='form-group'><label for='custLevel'>出生日期：</label><input class='form-control' id='s_bir' type='text' value="+student_bir+"></div><p><div class='form-group'><label for='custLevel'>年级编号：</label><input class='form-control' id='s_grade' type='text' value="+grade_no+"></div><p><div class='form-group'><label for='custLevel'>班级编号：</label><input class='form-control' id='s_class' type='text' value="+class_no+"></div><p><div class='form-group'><label for='custLevel'>电话：</label><input class='form-control' id='s_phone' type='text' value="+student_phone+"></div><p><div class='form-group'><label for='custLevel'>地址：</label><input class='form-control' id='s_home' type='text' value="+student_home+"></div></form>"
		  );
	    var  ss = document.getElementById('ss');
		if(ss[0].value==student_sex)
			ss[0].selected = true;//选中
		else
			ss[1].selected = true;//选中
	  $("#dialog_update").dialog({
		  autoOpen:true,
			height:520,
			width:399,
			modal:true,
	        title:'修改学生信息',
			buttons:{
				"修改":function(){
					no=$("#s_no").val();//修改后学号
					name=$("#s_name").val();//。。。学生姓名
					id=$("#s_id").val();//。。。证件号
					sex=$("#ss").val();//。。。性别
					bir=$("#s_bir").val();//。。。出生日期
					grade=$("#s_grade").val();//。。。级别
					classs=$("#s_class").val();//。。。班别
					phone=$("#s_phone").val();//。。。电话
					home=$("#s_home").val();//。。。地址
					$.ajax({
						type:"get",
						url:"student_update.html",
						data:{"old_stu_no":old_student_no,"stu_no":no,"stu_name":name,
							"stu_id":id,"stu_sex":sex,"stu_bir":bir,"grade_no":grade,
							"class_no":classs,"stu_phone":phone,"stu_home":home
							},
					    success:function(data)
					    {
					    	switch(data)
					    	{
					    	case "-1":alert("该学号已存在，学号不能重复");break;
					    	case "-2":alert("请输入正确的身份证号码");break;
					    	case "-3":alert("请输入正确出生日期，格式为：YYYY-MM-DD");break;
					    	case "-4":alert("身份证填写的出生日期和填写出生日期不一致");break;
					    	case "2":alert("学号不能为空");break;
					    	case "3":alert("姓名不能为空");break;
					    	case "4":alert("证件号不能为空");break;
					    	case "5":alert("性别不能为空");break;
					    	case "6":alert("出生日期不能为空");break;
					    	case "7":alert("年级不能为空");break;
					    	case "8":alert("班级不能为空");break;
					    	case "1":alert("修改成功！");
					    	window.location.reload();
							$(this).dialog("close");
							callback();
							break;
					    	case "0":alert("修改失败");
					    	window.location.reload();
							$(this).dialog("close");
							callback();
					    	break;
					    	}
					    }
					});
				},
				"取消":function(){
					$(this).dialog("close");
				}
			},
			close:function(){
				$(this).dialog("close");
			}
	        });
}

<!--删除学生信息-->
function stu_delete(student_no)
{
	  if(confirm("你确定删除学号"+student_no+"信息吗？"))
		 /* $.ajax({
			  type:"post",
			  url:"student_delete.action",
			  data:{"student_no":student_no},
			  success:function(data)
			  {
				  if(data==1)
					  alert("删除用户成功");
				  else
					  alert("删除用户失败");
				  window.local.reload();
			  }
		  });*/     
		  <!--用ajax请求有问题,导致无法刷新,我也不知道为啥-->
		  $.post("student_delete.html",{"student_no":student_no},function(data)
					 {
				       if(data==1)
				    	   alert("用户删除成功！");
				       else
				    	   alert("用户删除失败！");
				       window.location.reload();
					 }
			 );
}

<!--学生管理页面跳转-->
function tiaozhuan(grade_name,class_name,student_name,student_no,student_year)
{
	  var a=$("#tz").val()
	  var re = /^[0-9]*$/;   //判断字符串是否为数字
	  if (a==""||!re.test(a))
	  {
		  alert("请输入数字");
		  return;
		   }
	  else if (a=="0")
	  {
		  alert("不能跳到0页");
		  return;
		   }
	  else
	  {
		  window.location.href="student.html?type=跳转&type1="+a+"&grade_name="+grade_name+
			"&class_name="+class_name+
			"&student_name="+student_name+"&student_no="+student_no+"&student_year="+student_year;
	  }
}
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
		        	<li class="active"><a href="student.html">学生信息管理<span class="sr-only">(current)</span></a></li>
		        	<li><a href="teacher.html">教师信息管理</a></li>
		        	<li><a href="stu_score.html">学生成绩管理</a></li>
		        	<li><a href="stu_class.html">课程信息管理</a></li>
		        	<li><a href="system.html">系统管理</a></li>
	      		</ul>
	   </div>
	   </nav>
	   <!-- 选择框等 -->
	   <div class="row">
			<div class="col-lg-12">
				<h3>学生信息管理</h3>
			</div>
	   </div>
	   <div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline" action="student.html" method="get">
					
					
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
						<input type="button" onclick="stu_insert()" class="btn btn-primary" value="插入">
					</form>
				</div>
			</div>
			<div id="dialog_update"></div>
			<div id="dialog_insert"></div>
			<!-- 显现表格 -->
			<div class="table-responsive">
			<table class="table table-bordered table-striped">
				<tr>
				    <td style="text-align: center">学年</td>
					<td style="text-align: center">学号</td>
					<td style="text-align: center">姓名</td>
					<td style="text-align: center">证件号</td>
					<td style="text-align: center">性别</td>
					<td style="text-align: center">出生日期</td>
					<td style="text-align: center">年级</td>
					<td style="text-align: center">班级</td>
					<td style="text-align: center">联系电话</td>
					<td style="text-align: center">地址</td>
					<td style="text-align: center">操作</td>
				</tr>
				<c:forEach items="${student}" var="item">
					<tr>
					    <td style="text-align: center">${item.student_year}</td>
						<td style="text-align: center">${item.student_no}</td>
						<td style="text-align: center">${item.student_name}</td>
						<td style="text-align: center">${item.student_id}</td>
						<td style="text-align: center">${item.student_sex}</td>
						<td style="text-align: center">${item.student_bir}</td>
						<td style="text-align: center">${item.grade_name}</td>
						<td style="text-align: center">${item.class_name}</td>
						<td style="text-align: center">${item.student_phone}</td>
						<td style="text-align: center">${item.student_home}</td>
						<td style="text-align: center"><input class="btn btn-warning" type="button"
							onclick="stu_update(
          '${item.student_no}','${item.student_name}','${item.student_id}','${item.student_sex}',
          '${item.student_bir}','${item.grade_no}','${item.class_no}','${item.student_phone}',
          '${item.student_home}'
          )"
							value="修改" /> <input class="btn btn-danger" type="button" value="删除"
							onclick="stu_delete('${item.student_no}')" /></td>
					</tr>
				</c:forEach>
			</table></div>
	<div id="page">
		<myTag:out></myTag:out>
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