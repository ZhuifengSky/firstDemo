package com.main.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.main.common.util.CookieUtil;
import com.main.common.util.PrintUtil;
import com.main.user.model.Student;
import com.main.user.service.IStudentService;
import com.util.NullJudgeUtil;


public class LoginInterceptor implements HandlerInterceptor{

	public static final String TICKET = "ticket";
	public static final String STUDENTID = "studentId";
	public static final String CURRENT_STUDENT = "user";
	
	@Autowired
	private IStudentService studentService;
	
	
	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		String ticket = CookieUtil.getCookie(request, TICKET);
		String userId = CookieUtil.getCookie(request, STUDENTID);
		if(!NullJudgeUtil.isNotNull(ticket) && NullJudgeUtil.isNotNull(userId)){
			Student student = studentService.findStudent(ticket, userId);
			if(student != null){
				request.setAttribute(CURRENT_STUDENT, student);
				return true;
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=UTF-8");
		preHandle(response, PrintUtil.printJson("-1", "Äã±»À¹½Ø ÁË"));
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	private void preHandle(HttpServletResponse response, String message){
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.write(message);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}
