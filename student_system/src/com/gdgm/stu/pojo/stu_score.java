package com.gdgm.stu.pojo;
//学生成绩表
public class stu_score {
	private String student_year;//年度
	private String term;//学期
	private String student_no;//学号
	private String student_name;//姓名
	private String course_no;//课程编号
	private String grade_name;//级别
	private String class_name;//班别
	private int score;//成绩
	private String type;//类型
	
	
	private int sum_page;//每页最多显示的行数... 用于数据库的limit 一共要多少条
	private int start_page;//用于数据库的limit 从第几条开始
	
	
	public String getStudent_no() {
		return student_no;
	}
	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}
	public String getCourse_no() {
		return course_no;
	}
	public void setCourse_no(String course_no) {
		this.course_no = course_no;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStudent_year() {
		return student_year;
	}
	public void setStudent_year(String student_year) {
		this.student_year = student_year;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public int getSum_page() {
		return sum_page;
	}
	public void setSum_page(int sum_page) {
		this.sum_page = sum_page;
	}
	public int getStart_page() {
		return start_page;
	}
	public void setStart_page(int start_page) {
		this.start_page = start_page;
	}
	
}
