package com.zhonglongchang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhonglongchang.entity.OrderInfo;
import com.zhonglongchang.entity.User;
import com.zhonglongchang.service.CarService;
import com.zhonglongchang.service.OrderService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class OrderClServlet
 */
public class OrderClServlet extends HttpServlet {
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
		OrderService os=new OrderService();
		CarService cs=(CarService)request.getSession().getAttribute("mycart");
		System.out.println("mycart"+cs); 
		User user=(User)request.getSession().getAttribute("userInfo");
		System.out.println("userinfo"+user);
		long userid=user.getUserid();
		OrderInfo oi=os.addOrder(cs, userid+"");
		if(oi!=null) {
			JSONObject json = new JSONObject();
	   		json.put("al",oi);
	   		response.getWriter().print(json);
		}else {
			JSONObject json = new JSONObject();
	   		json.put("al","Ê§°Ü");
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
