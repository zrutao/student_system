package com.gdgm.stu.pojo;
//学生表实体类
public class student {
	private String student_year;//学年
	private String old_stu_no;//用于修改时的原学号
	private String student_no;//学号
	private String student_password;//登录密码
	private String student_name;//姓名
	private String student_id;//身份证号码
	private String student_sex;//性别
	private String student_bir;//出生日期
	private String grade_no;//年级编号
	private String class_no;//班级编号
	private String student_phone;//联系电话
	private String student_home;//联系地址

	private int sum_page;//每页最多显示的行数... 用于数据库的limit 一共要多少条
	private int start_page;//用于数据库的limit 从第几条开始
	
	private String grade_name; 	//用于连表时显示年级姓名
	private String class_name;   //用于连表时显示班级姓名
	
	
	
	
	public String getStudent_year() {
		return student_year;
	}
	public void setStudent_year(String student_year) {
		this.student_year = student_year;
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
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public String getOld_stu_no() {
		return old_stu_no;
	}
	public void setOld_stu_no(String old_stu_no) {
		this.old_stu_no = old_stu_no;
	}
	public String getStudent_no() {
		return student_no;
	}
	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getStudent_sex() {
		return student_sex;
	}
	public void setStudent_sex(String student_sex) {
		this.student_sex = student_sex;
	}
	public String getStudent_bir() {
		return student_bir;
	}
	public void setStudent_bir(String student_bir) {
		this.student_bir = student_bir;
	}
	public String getGrade_no() {
		return grade_no;
	}
	public void setGrade_no(String grade_no) {
		this.grade_no = grade_no;
	}
	public String getClass_no() {
		return class_no;
	}
	public void setClass_no(String class_no) {
		this.class_no = class_no;
	}
	public String getStudent_phone() {
		return student_phone;
	}
	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}
	public String getStudent_home() {
		return student_home;
	}
	public void setStudent_home(String student_home) {
		this.student_home = student_home;
	}
	public String getStudent_password() {
		return student_password;
	}
	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}
	
}
