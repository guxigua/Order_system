package com.zhonglongchang.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhonglongchang.service.GoodsService;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ShowGoodsPageServlet
 */
public class ShowGoodsPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGoodsPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		String p_pageNow=request.getParameter("pageNow");
		if(p_pageNow==null)
			p_pageNow="1";
		int pageNow=Integer.valueOf(p_pageNow);
		GoodsService gs=new GoodsService();
		ArrayList al=gs.getGoodsByPage(pageNow);
		JSONObject json = new JSONObject();
		json.put("al",al);
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
