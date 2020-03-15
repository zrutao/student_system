package com.gdgm.stu.controller;

import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdgm.stu.pojo.login_admin;
import com.gdgm.stu.service.stu_score_service;
@Controller
public class login {
	@Autowired
	private stu_score_service s_score_service;
	
	//登录
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	
	//登录验证
	@RequestMapping("/verification")
	public String verification(Model model,HttpServletRequest request)
	{
		String admin_no=request.getParameter("username");
		String password=request.getParameter("password");
		md5 md51 = new md5(); 
		String admin_password=md51.md5s(password);//密码加密
		
		login_admin log=new login_admin();
		log.setAdmin_no(admin_no);
		log.setAdmin_password(admin_password);
		//登录比较简单，我直接写到成绩dao里面(因为顺手呀！真正开发不要这样。标志者，汝涛也)
		int sum=s_score_service.login_count(log);
		if(sum>=1)
		  {
			try{
				//获得系统时间
				Date date = new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String curdate = simpleDateFormat.format(date);
				//记录ip比较简单，我直接写到成绩dao里面(因为顺手呀！真正开发不要这样。标志者，汝涛也)
				
				login_admin login_visit=new login_admin();
				login_visit.setAdmin_no(admin_no);
				login_visit.setVisit_date(curdate);
				login_visit.setVisit_ip(request.getRemoteAddr());//获取访问ip
				s_score_service.visit(login_visit);
				}
			catch(Exception e){System.out.println("报错了。。。。。。");}
			finally
			{
				model.addAttribute("admin_no", admin_no);
				student_demo demo=new student_demo();
				
				return demo.index(model);
			}
		  }
		else
			return "login";
	}
	@RequestMapping("/exit")
	public String exit()
	{
		return "exit";
	}
	//md5加密
	public class md5 { 
		 public String str; 
		 public String md5s(String plainText) { 
		  try { 
		   MessageDigest md = MessageDigest.getInstance("MD5"); 
		   md.update(plainText.getBytes()); 
		   byte b[] = md.digest(); 
		 
		   int i; 
		 
		   StringBuffer buf = new StringBuffer(""); 
		   for (int offset = 0; offset < b.length; offset++) { 
		    i = b[offset]; 
		    if (i < 0) 
		     i += 256; 
		    if (i < 16) 
		     buf.append("0"); 
		    buf.append(Integer.toHexString(i)); 
		   } 
		   return str = buf.toString(); 
		   //System.out.println("result: " + buf.toString());// 32位的加密 
		   //System.out.println("result: " + buf.toString().substring(8, 24));// 16位的加密 
		  } catch (NoSuchAlgorithmException e) { 
		   e.printStackTrace(); 
			return plainText;
		  } 
		 } 
		}
}
