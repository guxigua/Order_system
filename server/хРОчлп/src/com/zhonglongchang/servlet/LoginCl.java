package com.zhonglongchang.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhonglongchang.entity.User;
import com.zhonglongchang.service.CarService;
import com.zhonglongchang.service.UserService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class LoginCl
 */
public class LoginCl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Content-Length, Authorization, Accept, X-Requested-With , yourHeaderFeild");
		response.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
		response.setHeader("X-Powered-By", "3.2.1");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
       request.setCharacterEncoding("utf-8");
       String name=request.getParameter("name");
       String pass=request.getParameter("pass");
       System.out.println(name);
       System.out.println(pass);
       UserService us=new UserService();
       boolean flag=us.checkUser(name, pass);
       if(flag) {
    	   User user=us.getUser(name);
    	   System.out.println("user"+user);
    	   request.getSession().setAttribute("userInfo", user);
    	   JSONObject json = new JSONObject();
      		json.put("al","登录成功");
      		response.getWriter().print(json);
       }else {
    	JSONObject json = new JSONObject();
   		json.put("al","用户名或密码错误");
   		response.getWriter().print(json);
       }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
