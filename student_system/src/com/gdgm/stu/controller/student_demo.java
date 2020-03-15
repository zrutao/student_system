 package com.gdgm.stu.controller;

 import java.util.ArrayList;
//学生管理部分
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdgm.stu.pojo.stu_page;
import com.gdgm.stu.pojo.stu_class;
import com.gdgm.stu.pojo.stu_grade;
import com.gdgm.stu.pojo.student;
import com.gdgm.stu.service.stu_service;
import com.gdgm.stu.student_public.verification;
@Controller
public class student_demo {
	@Autowired
	private stu_service s_service;
	
	//大首页
	@RequestMapping("/index")
	public String index(Model model)
	{
		List<String> class_name=new ArrayList();
		class_name.add("1");class_name.add("2");
		class_name.add("3");class_name.add("4");
		class_name.add("5");class_name.add("6");
		class_name.add("7");class_name.add("8"); 
		class_name.add("9");class_name.add("10");
		//List<stu_class> class_type=s_service.stu_class_type();;//班别下拉框显示全部班别类型
		//System.out.println(class_type.size()+"咳咳");
		/*for(int a=0;a<class_type.size();a++)
		{
			class_name.add(class_type.get(a).getClass_name());
		}*/
		model.addAttribute("class_name",class_name);
		return "index";
	}
	
	//个人介绍1
	@RequestMapping("/myself1")
	public String myself1()
	{
		return "myself1";
	}
	//个人介绍2
	@RequestMapping("/myself2")
	public String myself2()
	{
		return "myself2";
	}
	//个人介绍3
	@RequestMapping("/myself3")
	public String myself3()
	{
		return "myself3";
	}
	//个人介绍4
	@RequestMapping("/myself4")
	public String myself4()
	{
		return "myself4";
	}
	//个人介绍5
	@RequestMapping("/myself5")
	public String myself5()
	{
		return "myself5";
	}
	
    //显示分页，30行作为一页
	private int count_page=1;//总共页面 ...
	private int sum_page=30;//每页最多显示的行数      用于数据库的limit 一共要多少条...
	private int start_page=0;//用于数据库的limit 从第几条开始...
	private String p;
	//学生管理--首页
	@RequestMapping("/student")
	public String student(Model model,HttpServletRequest request)
	{
		//显示学生列表
		String student_year=request.getParameter("student_year");//学号
		String student_no=request.getParameter("student_no");//学号
		String grade_name=request.getParameter("grade_name");//年级
		String class_name=request.getParameter("class_name");//班级
		String student_name=request.getParameter("student_name");//姓名
		
		/**
		 * 代表从jsp页面搜索键传回 学号，年级，班级，姓名。我们跳转页面的时候要保留之前搜索的痕迹
		 * 例如，我在搜索时按班别查询了选择了一班，跳转页面后班别也要选择一班，而不是请选择，我们用s1记录搜索历史
		 */
		student s1=new student();
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
		
		
		
		student s=new student();
		s.setStudent_year(student_year);
		s.setStudent_no(student_no);
		s.setGrade_name(grade_name);
		s.setClass_name(class_name);
		s.setStudent_name(student_name);
		
		int count_page=s_service.student_count(s);//获得数目符合条件的学生总行数count_page
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
		
		List<student> stu = s_service.student(s);//jsp页面显示列表数据
		
		model.addAttribute("stu_year",stu_year);
		model.addAttribute("student",stu);
		model.addAttribute("grade_type",grade_type);
		model.addAttribute("class_type",class_type);
		
		return "student";
	}
	
	//学生管理--修改学生信息
	@RequestMapping("/student_update")
	@ResponseBody
	public String student_update(String old_stu_no,String stu_no,
			String stu_name,String stu_id,String stu_sex,String stu_bir,
			String grade_no,String class_no,String stu_phone,String stu_home)
	{
		if(stu_no=="") //学号不能为空
			return "2";
		else if(stu_name=="")//姓名不能为空
			return "3";
		else if(stu_id=="")//证件号不能为空
			return "4";
		else if(stu_sex=="")//性别不能为空
			return "5";
		else if(stu_bir=="")//出生日期不能为空
			return "6";
		else if(grade_no=="")//年级不能为空
			return "7";
		else if(class_no=="")//班级不能为空
			return "8";
		else
		{
			student s=new student();
			s.setOld_stu_no(old_stu_no);
			s.setStudent_no(stu_no);
			s.setStudent_name(stu_name);
			if(stu_no!="")//当学号不为空时判断学号是否已经存在
			{
				if(!stu_no.equals(old_stu_no))//修改过学号才执行，验证更改后的学号是否已经存在
				{
					int a=s_service.student_alike(s);//查询语句，用count，等于1代表重复，0时代表不重复
					if(a==1)
						return "-1";
				}
			}
			if(stu_id!="")//用正则表达式验证身份证格式
			{
				verification v=new verification();
				boolean bool=v.verification_id(stu_id);
				if(!bool)
					return "-2";
			}
			if(stu_bir!="")//用正则表达式验证身份证格式
			{
				verification v=new verification();
				boolean bool=v.verification_date(stu_bir);
				if(!bool)
					return "-3";
			}
			if(stu_bir!="")//用正则表达式验证身份证的出生日期和自填的出生日期
			{
				verification v=new verification();
				boolean bool=v.verification_id_date(stu_id,stu_bir);
				if(!bool)
					return "-4";
			}
			s.setStudent_id(stu_id);
			s.setStudent_sex(stu_sex);
			s.setStudent_bir(stu_bir);
			s.setGrade_no(grade_no);
			s.setClass_no(class_no);
			s.setStudent_phone(stu_phone);
			s.setStudent_home(stu_home);
			//修改成功返回1，修改失败返回0
			try
			{
				s_service.student_update(s);
				return "1";
			}
			catch(Exception e)
			{
				return "0";
			}
		}
		
	}
	//学生管理--删除学生信息
	@RequestMapping("/student_delete")
	@ResponseBody
	public String student_delete(String student_no)
	{
		try
		{
			s_service.student_delete(student_no);
			return "1";
		}
		catch(Exception e)
		{
			return "0";
		}
	}
	
	//学生管理--添加学生信息
	@RequestMapping("/student_insert")
	@ResponseBody
	public String student_insert(String stu_year,String stu_no,
			String stu_name,String stu_id,String stu_sex,String stu_bir,
			String grade_no,String class_no,String stu_phone,String stu_home)
	{
		if(stu_no=="") //学号不能为空
			return "2";
		else if(stu_name=="")//姓名不能为空
			return "3";
		else if(stu_id=="")//证件号不能为空
			return "4";
		else if(stu_sex=="")//性别不能为空
			return "5";
		else if(stu_bir=="")//出生日期不能为空
			return "6";
		else if(grade_no=="")//年级不能为空
			return "7";
		else if(class_no=="")//班级不能为空
			return "8";
		else if(stu_year=="")//学年不能为空
			return "9";
		else
		{
			student s=new student();
			s.setStudent_no(stu_no);
			if(stu_no!="")//当学号不为空时判断学号是否已经存在
			{
				int a=s_service.student_alike(s);//查询语句，用count，等于1代表重复，0时代表不重复
				if(a==1)
					return "-1";
			}
			if(stu_id!="")//用正则表达式验证身份证格式
			{
				verification v=new verification();
				boolean bool=v.verification_id(stu_id);
				if(!bool)
					return "-2";
			}
			if(stu_bir!="")//用正则表达式验证身份证格式
			{
				verification v=new verification();
				boolean bool=v.verification_date(stu_bir);
				if(!bool)
					return "-3";
			}
			if(stu_bir!="")//用正则表达式验证身份证的出生日期和自填的出生日期
			{
				verification v=new verification();
				boolean bool=v.verification_id_date(stu_id,stu_bir);
				if(!bool)
					return "-4";
			}
			System.out.println("学年"+stu_sex);
			s.setStudent_year(stu_year);
			s.setStudent_password(stu_no);//添加学生信息时，默认值，学号和密码一致
			s.setStudent_name(stu_name);
			s.setStudent_id(stu_id);
			s.setStudent_sex(stu_sex);
			s.setStudent_bir(stu_bir);
			s.setGrade_no(grade_no);
			s.setClass_no(class_no);
			s.setStudent_phone(stu_phone);
			s.setStudent_home(stu_home);
			//插入成功返回1，修改失败返回0
			try
			{
				s_service.student_insert(s);
				return "1";
			}
			catch(Exception e)
			{
				return "0";
			}
		}
	}
}
