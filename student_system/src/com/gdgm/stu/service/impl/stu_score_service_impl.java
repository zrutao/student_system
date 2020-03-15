package com.gdgm.stu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gdgm.stu.mapper.dao_stu_score;
import com.gdgm.stu.pojo.login_admin;
import com.gdgm.stu.pojo.stu_score;
import com.gdgm.stu.pojo.student;
import com.gdgm.stu.service.stu_score_service;


@Service
public class stu_score_service_impl implements stu_score_service {

	@Autowired
	private dao_stu_score dao_stu_s;

	@Override
	public int student_count(stu_score s) {
		// TODO Auto-generated method stub
		return dao_stu_s.student_count(s);
	}

	@Override
	public List<stu_score> score(stu_score s) {
		// TODO Auto-generated method stub
		return dao_stu_s.score(s);
	}
	
	//登录验证
	@Override
	public int login_count(login_admin log) {
		// TODO Auto-generated method stub
		return dao_stu_s.login_count(log);
	}

	@Override
	public void visit(login_admin login_visit) {
		// TODO Auto-generated method stub
		dao_stu_s.visit(login_visit);
	}

	
	
}
