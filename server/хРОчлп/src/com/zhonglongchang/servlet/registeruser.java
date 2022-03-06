package com.zhonglongchang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhonglongchang.service.UserService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class registeruser
 */
public class registeruser extends HttpServlet {
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
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String address=request.getParameter("address");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		UserService gs=new UserService();
		boolean flag=gs.checkName(name);
		if(!flag){
			boolean flag2=gs.adduser(name, pass,address);
			if(flag2){
				JSONObject json = new JSONObject();
		   		json.put("al","×¢²á³É¹¦");
		   		response.getWriter().print(json);
		}else{
			JSONObject json = new JSONObject();
	   		json.put("al","×¢²áÊ§°Ü");
	   		response.getWriter().print(json);
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
