package com.gdgm.stu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdgm.stu.pojo.login_admin;
import com.gdgm.stu.service.stu_service;
import com.gdgm.stu.service.system_service;
@Controller
public class system {
	@Autowired
	private system_service sys_service;
	
	//系统
	@RequestMapping("/system")
	public String system(Model model)
	{
		List<login_admin> ip= sys_service.getip();
		model.addAttribute("ip", ip);
		return "system";
	}
}
