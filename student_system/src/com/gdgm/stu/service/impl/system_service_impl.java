package com.gdgm.stu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdgm.stu.service.system_service;
import com.gdgm.stu.mapper.dao_system;
import com.gdgm.stu.pojo.login_admin;

@Service
public class system_service_impl implements system_service {

	@Autowired
	private dao_system dao_sys;

	@Override
	public List<login_admin> getip() {
		// TODO Auto-generated method stub
		return dao_sys.getip();
	}
	
	
}
