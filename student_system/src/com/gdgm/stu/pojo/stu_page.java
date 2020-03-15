package com.gdgm.stu.pojo;

//学生管理中的分页
public class stu_page {

	private static int page_count=1;//总页面
	private static int page_event=1;//目前页面
	private static int page_start=0;
	private static int page_end=30;

	//自定义标签时的url参数
	private static String student_year="";//年度
	private static String grade_name=""; 	//年级姓名
	private static String class_name="";   //班级姓名
	private static String student_no="";   //学生学号
	private static String student_name=""; //学生姓名
	
	
	public static String getStudent_year() {
		return student_year;
	}
	public static void setStudent_year(String student_year) {
		stu_page.student_year = student_year;
	}
	public static String getGrade_name() {
		return grade_name;
	}
	public static void setGrade_name(String grade_name) {
		stu_page.grade_name = grade_name;
	}
	public static String getClass_name() {
		return class_name;
	}
	public static void setClass_name(String class_name) {
		stu_page.class_name = class_name;
	}
	public static String getStudent_no() {
		return student_no;
	}
	public static void setStudent_no(String student_no) {
		stu_page.student_no = student_no;
	}
	public static String getStudent_name() {
		return student_name;
	}
	public static void setStudent_name(String student_name) {
		stu_page.student_name = student_name;
	}
	public static int getPage_count() {
		return page_count;
	}
	public static void setPage_count(int page_count) {
		stu_page.page_count = page_count;
	}
	public static int getPage_event() {
		return page_event;
	}
	public static void setPage_event(int page_event) {
		stu_page.page_event = page_event;
	}
	public static int getPage_start() {
		return page_start;
	}
	public static void setPage_start(int page_start) {
		stu_page.page_start = page_start;
	}
	public static int getPage_end() {
		return page_end;
	}
	public static void setPage_end(int page_end) {
		stu_page.page_end = page_end;
	}
	
}
