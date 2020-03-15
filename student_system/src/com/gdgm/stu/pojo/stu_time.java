package com.gdgm.stu.pojo;
//时间表
public class stu_time {
	private String course_no;//课程编号
	private String week;//星期
	private String start;//开始时间
	private String end;//结束时间
	private String timename;//课   第几节课
	public String getCourse_no() {
		return course_no;
	}
	public void setCourse_no(String course_no) {
		this.course_no = course_no;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getTimename() {
		return timename;
	}
	public void setTimename(String timename) {
		this.timename = timename;
	}
	
}
