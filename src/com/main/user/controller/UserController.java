package com.main.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.common.bean.Page;
import com.main.common.bean.PageBean;
import com.main.user.bean.StudentBean;
import com.main.user.model.Student;
import com.main.user.service.IStudentService;

/**
 * 用户控制类
 * @author zhangwu
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IStudentService studentServiceImpl;
	
	@RequestMapping("/addUser.do")
	public String addUser(Student student){
		studentServiceImpl.saveStudent(student);		
		return "redirect:/user/listUser.do";
		
	}
	
	@RequestMapping("/listUser.do")
	public String listUser(StudentBean queryBean,PageBean pageBean,ModelMap map){
		Page<Student> page = studentServiceImpl.findStudents(queryBean,pageBean);
		map.put("page", page);
		map.put("pageBean", page.getPageBean());
		map.put("queryBean", queryBean);
		return "jsp/listStudent";
	}
	
	
	@RequestMapping("/queryUser.do")
	public String queryUser(String sid,ModelMap map){
		Student student = studentServiceImpl.queryStident(sid);
		map.put("s", student);
		return "jsp/addStudent";
	}
	
	
	@RequestMapping("/deleteUser.do")
	public String deleteUser(String sid){
		studentServiceImpl.deleteStudent(sid);
		return "redirect:/user/listUser.do";
	}
	
	@RequestMapping("/updateUser.do")
	public String updateUser(Student student){
		studentServiceImpl.updateStudent(student);
		return "redirect:/user/listUser.do";
	}
}
