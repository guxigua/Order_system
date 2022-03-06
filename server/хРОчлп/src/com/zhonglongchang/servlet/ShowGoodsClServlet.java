package com.zhonglongchang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhonglongchang.entity.Goods;
import com.zhonglongchang.service.GoodsService;

/**
 * Servlet implementation class ShowGoodsClServlet
 */
public class ShowGoodsClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String goodsId=request.getParameter("Id");
		GoodsService gs=new GoodsService();
		Goods goods=gs.getGoodsById(goodsId);
		request.setAttribute("goodsInfo", goods);
		request.getRequestDispatcher("showDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
