package com.gdgm.stu.controller;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//教师管理部分
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.gdgm.stu.service.stu_service;
import com.gdgm.stu.pojo.images;

@Controller
public class teacher_demo {
	@Autowired
	private stu_service s_service;
	
	//教师
	@RequestMapping("/teacher")
	public String teacher()
	{
		return "teacher";
	}
	
	@RequestMapping("/images1")
	private String images1()
	{
		
		return "img";
	}
	
	@RequestMapping("/images")
	private String images(MultipartFile pictureFile, Model model)
	{
		// 图片新名字
		String newName = UUID.randomUUID().toString();
		// 图片原来的名字
		String oldName = pictureFile.getOriginalFilename();
		// 后缀
		String sux = oldName.substring(oldName.lastIndexOf("."));
		// 新建本地文件流
		File file = new File("/WebContent/CSS/head/" + newName + sux);
		// 写入本地磁盘
		try {
			pictureFile.transferTo(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("有错。。。。。。。。。。。。");
		}
		System.out.println(pictureFile);
		images item=new images();
		// 保存图片到数据库
		item.setId("root");
		item.setImg_url("head/" +newName + sux);

		s_service.updateItem(item);
		model.addAttribute("item", item);
		return "img";
	}
}
