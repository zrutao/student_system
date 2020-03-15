package com.gdgm.stu.utils;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.gdgm.stu.pojo.stu_page;

//学生管理的页面跳转
public class MyTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = super.pageContext.getOut();
		stu_page p=new stu_page();
		try {
			
			if(p.getPage_event()>1)
				out.print("<ul id=\"ul_page\"><div class='col-md-6 col-sm-6 col-xs-12'><li><a href=" + 
			"student.html?type=上一页&grade_name="+p.getGrade_name()+
			"&class_name="+p.getClass_name()+
			"&student_name="+p.getStudent_name()+"&student_no="+p.getStudent_no() +
			"&student_year="+p.getStudent_year() +
						">上一页</a></li>");
				else
					out.print("<ul id=\"ul_page\"><div class='col-md-6 col-sm-6 col-xs-12'><li>上一页</li>");
			
			if(p.getPage_count()>p.getPage_event())
			out.print("<li><a href=" + 
		"student.html?type=下一页&grade_name="+p.getGrade_name()+
		"&class_name="+p.getClass_name()+
		"&student_name="+p.getStudent_name()+"&student_no="+p.getStudent_no() +
		"&student_year="+p.getStudent_year() +
					">下一页</a></li>");
			else
				out.print("<li>下一页</li>");
			
			out.print("<li><a href=" + 
					"student.html?type=首页&grade_name="+p.getGrade_name()+
					"&class_name="+p.getClass_name()+
					"&student_name="+p.getStudent_name()+"&student_no="+p.getStudent_no() +
					"&student_year="+p.getStudent_year() +
								">首页</a></li>");
			
			out.print("<li><a href=" + 
					"student.html?type=尾页&grade_name="+p.getGrade_name()+
					"&class_name="+p.getClass_name()+
					"&student_name="+p.getStudent_name()+"&student_no="+p.getStudent_no() +
					"&student_year="+p.getStudent_year() +
								">尾页</a></li></div>");
		
			
			out.print("<div class='col-md-6 col-sm-12 col-xs-12'><li>共"+p.getPage_count()+"页</li>");
			out.print("<li>当前第"+p.getPage_event()+"页</li>");
			out.print("<li>到"+"<input size='4' type='text' id='tz' /></li>"
					+ "<li>页<input class='btn' type='button' onclick=\"tiaozhuan('"+p.getGrade_name()
					+"','"+p.getClass_name()+"','"+p.getStudent_name()+"','"+p.getStudent_no()
					+"&student_year="+p.getStudent_year()
					+"')\" value='跳转'/></li></div></ul>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

}
