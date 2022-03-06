package com.zhonglongchang.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zhonglongchang.entity.Goods;
import com.zhonglongchang.entity.OrderInfo;
import com.zhonglongchang.service.CarService;

public class OrderDao {
	 private  Connection conn=null;
	 private ResultSet rs=null;
	 private PreparedStatement ps=null;
 public OrderInfo addOrder(CarService cs,String userid) {
	 OrderInfo oi=new OrderInfo();
	 boolean b=true;
	 try {
		 conn=new DBConn().getConn();
		 String sql="insert into orders (userId,ispayed,totalPrice) values(?,?,?)";
		 ps=conn.prepareStatement(sql);
		 ps.setString(1, userid);
		 ps.setByte(2, (byte)0);
		 ps.setFloat(3, cs.getAllPrice());
		 int a=ps.executeUpdate();
		 if(a==1) {
			 String sq="select max(ordersId) from orders";
			 ps=conn.prepareStatement(sq);
			 rs=ps.executeQuery();
			 int orderId=0;
			 if(rs.next()) {
				 orderId=rs.getInt(1);
			 }
			 ArrayList al=cs.showMyCart();
			 Statement sm=conn.createStatement();
			 for(int i=0;i<al.size();i++) {
				 Goods goods=(Goods)al.get(i);
				 sm.addBatch("insert into orderDetail values('"+orderId+"','"+goods.getGoodsID()+"','"+goods.getGoodsNum()+"')");
			 }
			 sm.executeBatch();
			 String sql1="select ordersId,truename,address,postcode,phone,totalPrice,username,email from users,orders"+
			 " where ordersId=? and users.userid = (select orders.userid from orders where ordersId=?)";
			 ps=conn.prepareStatement(sql1);
			 ps.setInt(1, orderId);
			 ps.setInt(2, orderId);
			 rs=ps.executeQuery();
			 if(rs.next()) {
				 oi.setOrdersId(rs.getInt(1));
				 oi.setTruename(rs.getString(2));
				 oi.setAddress(rs.getString(3));
				 oi.setPostcode(rs.getString(4));
				 oi.setPhone(rs.getString(5));
				 oi.setTotalPrice(rs.getFloat(6));
				 oi.setUsername(rs.getString(7));
				 oi.setEmail(rs.getString(8));
			 }
		 }
	 }catch (Exception e) {
		 b=false;
		e.printStackTrace();
	}finally {
		this.close();
	}
	 if(b) {
		 return oi;
	 }else {
		 return null;
	 }
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
