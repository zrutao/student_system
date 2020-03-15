package com.gdgm.stu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdgm.stu.pojo.stu_class;
import com.gdgm.stu.pojo.stu_grade;
import com.gdgm.stu.pojo.stu_page;
import com.gdgm.stu.pojo.stu_score;
import com.gdgm.stu.pojo.student;
import com.gdgm.stu.service.stu_score_service;
import com.gdgm.stu.service.stu_service;
@Controller
public class stu_score_demo {
	@Autowired
	private stu_score_service s_score_service;
	@Autowired
	private stu_service s_service;
	
	//显示分页，30行作为一页
	private int count_page=1;//总共页面 ...
	private int sum_page=30;//每页最多显示的行数      用于数据库的limit 一共要多少条...
	private int start_page=0;//用于数据库的limit 从第几条开始...
	private String p;
	//学生成绩
	@RequestMapping("/stu_score")
	public String stu_score(Model model,HttpServletRequest request)
	{
		//显示成绩列表
		String student_year=request.getParameter("student_year");//学号
		String student_no=request.getParameter("student_no");//学号
		String grade_name=request.getParameter("grade_name");//年级
		String class_name=request.getParameter("class_name");//班级
		String student_name=request.getParameter("student_name");//姓名
		
		/**
		 * 代表从jsp页面搜索键传回 学号，年级，班级，姓名。我们跳转页面的时候要保留之前搜索的痕迹
		 * 例如，我在搜索时按班别查询了选择了一班，跳转页面后班别也要选择一班，而不是请选择，我们用s1记录搜索历史
		 */
		stu_score s1=new stu_score();
		s1.setStudent_year(student_year);
		s1.setStudent_no(student_no);
		s1.setGrade_name(grade_name);
		s1.setClass_name(class_name);
		s1.setStudent_name(student_name);
		model.addAttribute("return_type",s1);
		
		//在按级别和班别查询时，下拉框显示全部级别类型和班别类型
		List<student> stu_year=s_service.student_year_type();//年度
		List<stu_grade> grade_type=s_service.stu_grade_type();//级别下拉框显示全部级别类型
		List<stu_class> class_type=s_service.stu_class_type();;//班别下拉框显示全部班别类型
		
		
		
		stu_score s=new stu_score();
		s.setStudent_year(student_year);
		s.setStudent_no(student_no);
		s.setGrade_name(grade_name);
		s.setClass_name(class_name);
		s.setStudent_name(student_name);
		
		int count_page=s_score_service.student_count(s);//获得数目符合条件的学生总行数count_page
		/***
		 * 分页
		 */
		stu_page p=new stu_page();
		int start=p.getPage_start();
		int end=p.getPage_end();
		p.setPage_count(count_page%end==0? count_page/end:count_page/end+1 );//问号表达式
		if(class_name==null&&grade_name==null&&student_name==null&&student_no==null)
		{
			p.setStudent_year("请选择");
			p.setClass_name("请选择");
			p.setGrade_name("请选择");
			p.setStudent_name("");
			p.setStudent_no("");
		}
		else
		{
			p.setStudent_year(student_year);
			p.setClass_name(class_name);
			p.setGrade_name(grade_name);
			p.setStudent_name(student_name);
			p.setStudent_no(student_no);
		}
		String type=request.getParameter("type");//姓名
		if(type==null)
		{
			p.setPage_start(0);
			p.setPage_end(30);
			p.setPage_event(1);
			start=0;
			end=30;
		}
		else
		{
			//上一页
			if(type.equals("下一页"))
			{
				start=start+end;
				p.setPage_start(start);
				p.setPage_event((start+30)/30);
			}
			//下一页
			else if(type.equals("上一页"))
			{
				start=start-end;
				p.setPage_start(start);
				p.setPage_event((start+30)/30);
			}
			//首页
			else if(type.equals("首页"))
			{
				start=0;
				p.setPage_start(start);
				p.setPage_event(1);
			}
			//尾页
			else if(type.equals("尾页"))
			{
				start=count_page%end==0? count_page/end*end-end:(count_page/end+1)*end-end;
				p.setPage_start(start);
				p.setPage_event((start+30)/30);
			}
			else if(type.equals("跳转"))
			{
				String tiazhuan_page=request.getParameter("type1");
				int tz_page=Integer.parseInt(tiazhuan_page);
				if(tz_page>=p.getPage_count())//跳到尾页呗
				{
					start=count_page%end==0? count_page/end*end-end:(count_page/end+1)*end-end;
					p.setPage_start(start);
					p.setPage_event((start+30)/30);
				}
				else
				{
					start=tz_page*30-30;
					p.setPage_start(start);
					p.setPage_event(tz_page);
				}
			}
		}
			
		s.setStart_page(start);//
		s.setSum_page(end);//
		//stu_score s=new stu_score();
		List<stu_score> stu = s_score_service.score(s);//jsp页面显示列表数据
		model.addAttribute("stu_year",stu_year);
		model.addAttribute("student",stu);
		model.addAttribute("grade_type",grade_type);
		model.addAttribute("class_type",class_type);
		return "stu_score";
	}
}
