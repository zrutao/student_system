package com.gdgm.stu.pojo;
//课程表实体类
public class stu_course {
	private String course_no;//课程编号
	private String course_name;//课程名
	private String teacher_no;//教师编号
	public String getCourse_no() {
		return course_no;
	}
	public void setCourse_no(String course_no) {
		this.course_no = course_no;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getTeacher_no() {
		return teacher_no;
	}
	public void setTeacher_no(String teacher_no) {
		this.teacher_no = teacher_no;
	}
	
}
