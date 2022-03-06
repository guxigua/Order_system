package com.zhonglongchang.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhonglongchang.Dao.MyCarDao;
import com.zhonglongchang.service.CarService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ShoppingClServlet
 */
public class ShoppingClServlet extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");
		String goodsId=request.getParameter("goodsId");
		String type=request.getParameter("type");
		CarService cs=(CarService)request.getSession().getAttribute("mycart");
		if(cs==null) {
			cs=new CarService();
			request.getSession().setAttribute("mycart", cs);
		}
		if(goodsId!=null&&type==null) {
		cs.addGoods(goodsId, "1");
		}else if(type.equals("delGoods")) {
			cs.delgoods(goodsId);
		}else if(type.equals("clear")) {
			cs.clear();
		}else if(type.equals("show")) {
			
		}else if(type.equals("updateGoods")) {
			String goodsid[]=request.getParameterValues("goodsIds");
			String newNums[]=request.getParameterValues("newNums");
		    for(int i=0;i<goodsid.length;i++) {
		    	cs.upGoods(goodsid[i], newNums[i]);
		    }
		}
		ArrayList num=cs.getAllGoodsNum();
		ArrayList al=cs.showMyCart();
		float allPrice=cs.getAllPrice();
		JSONObject json = new JSONObject();
		json.put("al",al);
		json.put("num", num);
		json.put("allPrice",allPrice);
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
