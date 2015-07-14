package com.main.user.dao;

import java.util.List;

import com.main.common.bean.Page;
import com.main.common.bean.PageBean;
import com.main.user.bean.StudentBean;
import com.main.user.model.Student;

public interface IStudentDao {

	/**
	 * ѧ������
	 * 
	 * @param student
	 * @return
	 */
	public Student addStudent(Student student);

	/**
	 * ѧ��������ѯ
	 * 
	 * @param queryBean
	 * @return
	 */
	public Page<Student> findStudents(StudentBean queryBean,PageBean pageBean);

	/**
	 * ѧ������鿴
	 * 
	 * @param sid
	 * @return
	 */
	public Student queryStident(String sid);
	
	
	/**
	 * ɾ��ѧ��
	 * @param sid
	 */
	public void deleteStudent(String sid);
	
	/**
	 * ѧ������
	 * @param student
	 */
	public void updateStudent(Student student);
}
