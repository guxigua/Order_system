package com.zhonglongchang.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.zhonglongchang.entity.Goods;

public class GoodsDao {
	 private  Connection conn=null;
	 private ResultSet rs=null;
	 private PreparedStatement ps=null;
	 private int pageSize=6;
	public Goods getGoodsById(String Id){
		  conn=new DBConn().getConn();
		   Goods goods=new Goods();
		   try {
				String sql="select * from goods where goodsID=?";
			    ps=conn.prepareStatement(sql);
			    ps.setString(1, Id);
			    rs=ps.executeQuery();
				while(rs.next()){
				goods.setGoodsId(rs.getLong(1));
				goods.setGoodsName(rs.getString(2));
				goods.setGoodsIntro(rs.getString(3));
				goods.setGoodsPrice(rs.getFloat(4));
				goods.setGoodsNum(rs.getInt(5));
				goods.setPublisher(rs.getString(6));
				goods.setPhoto(rs.getString(7));
				goods.setType(rs.getString(8));
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
		   return goods;
	}
	public ArrayList getGoodsByPage(int pageNow){
		   conn=new DBConn().getConn();
			ArrayList al=new ArrayList();
			String sql="select top "+pageSize +" * from goods where goodsID not in (select top "+(pageNow-1)*6 +"goodsID from goods)";
			try{
		    ps=conn.prepareStatement(sql);
		    rs=ps.executeQuery();
			while(rs.next()){
					Goods goods=new Goods();
					goods.setGoodsId(rs.getInt(1));
				    goods.setGoodsName(rs.getString(2));
				    goods.setGoodsIntro(rs.getString(3));
				    goods.setGoodsPrice(rs.getFloat(4));
				    goods.setGoodsNum(rs.getInt(5));
				    goods.setPublisher(rs.getString(6));
				    goods.setPhoto("/static/img/"+rs.getString(7));
				    goods.setType(rs.getString(8));
					al.add(goods);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return al;
	}
	public int gettotalpage(){
		 conn=new DBConn().getConn();       
		   int count=0;
			String sql="select count(*) from goods";
			try {
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()){
					count=rs.getInt(1);
					if(count%pageSize==0)
						count=count/pageSize;
					else
						count=count/pageSize+1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
			return count;
	}
	public void close(){
		try {
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
