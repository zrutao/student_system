package com.gdgm.stu.pojo;

public class login_admin {
	
	private String admin_no;//账号
	private String admin_password;//密码
	
	//访问者ip，时间,访问者
	private String visit_ip;
	private String visit_date;
	private String visitors;
	
	public String getVisit_ip() {
		return visit_ip;
	}
	public void setVisit_ip(String visit_ip) {
		this.visit_ip = visit_ip;
	}
	public String getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}
	
	public String getVisitors() {
		return visitors;
	}
	public void setVisitors(String visitors) {
		this.visitors = visitors;
	}
	public String getAdmin_no() {
		return admin_no;
	}
	public void setAdmin_no(String admin_no) {
		this.admin_no = admin_no;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	
	

}
