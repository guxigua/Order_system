package com.zhonglongchang.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.zhonglongchang.entity.Goods;

public class MyCarDao {
	 private  Connection conn=null;
	 private ResultSet rs=null;
	 private PreparedStatement ps=null;
    private static HashMap <String,String> hm=new HashMap<String,String>();
    private static float allPrice=0.0f;
public float getAllPrice() {
    	return allPrice;
    }
 public void addGoods(String goodsId,String goodsNum){
	 hm.put(goodsId, goodsNum);
 }
 public void delgoods(String goodsId){
	 hm.remove(goodsId);
 }
 public void clear(){
	 hm.clear();
 }
 public void upGoods(String goodsId,String newNum){
	 hm.put(goodsId, newNum);	
 }
 public ArrayList getAllGoodsNum() {
	 ArrayList num=new ArrayList();
	 Iterator it=hm.keySet().iterator();
	 while(it.hasNext()) {
		 String goodsId=(String)it.next();
		 String value=hm.get(goodsId);
		 num.add(value);
	 }
	 return num;
 }
 public ArrayList showMyCart(){
	 ArrayList al=new ArrayList();
	 try{
		 String sql="select * from goods where goodsID in";
		 Iterator it=hm.keySet().iterator();
		 String sub="(";
		 while(it.hasNext()){
			 String goodsId=(String)it.next();
			 if(it.hasNext()){
			 sub+=goodsId+",";
			 }else {
				 sub+=goodsId+")";
			 }
		 }
		 if(sub.equals("(")) {
			 allPrice=0.0f;
		 }else {
		 sql+=sub;
		 System.out.println(sql);
		 conn=new DBConn().getConn();
		 ps=conn.prepareStatement(sql);
		 rs=ps.executeQuery();
		 allPrice=0.0f;
		 while(rs.next()){
				Goods goods=new Goods();
				int goodsId=rs.getInt(1);
				goods.setGoodsId(rs.getInt(1));
			    goods.setGoodsName(rs.getString(2));
			    goods.setGoodsIntro(rs.getString(3));
			    float unit=rs.getFloat(4);
			    goods.setGoodsPrice(unit);
			    goods.setGoodsNum(rs.getInt(5));
			    goods.setPublisher(rs.getString(6));
			    goods.setPhoto(rs.getString(7));
			    goods.setType(rs.getString(8));
			    allPrice=allPrice+unit*Integer.parseInt(this.getGoodsNumById(goodsId+""));
				al.add(goods);
		 }
		 }
	 }catch(Exception e){
		 e.printStackTrace();
	 }finally{
		 this.close();
	 }
	 return al;
 }
 public String getGoodsNumById(String goodsId) {
	 return hm.get(goodsId);
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
