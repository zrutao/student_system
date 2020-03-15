package com.gdgm.stu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdgm.stu.service.stu_service;
@Controller
public class stu_class {
	@Autowired
	private stu_service s_service;
	
	//课程
	@RequestMapping("/stu_class")
	public String stu_class()
	{
		return "stu_class";
	}
}
