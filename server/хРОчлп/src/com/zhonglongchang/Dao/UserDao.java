package com.zhonglongchang.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhonglongchang.entity.User;

public class UserDao {
	 private  Connection conn=null;
	 private ResultSet rs=null;
	 private PreparedStatement ps=null;
	public User getUser(String name) {
		User user=new User();
		conn=new DBConn().getConn();
		String sql="select * from users where username=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setTruename(rs.getString(3));
				user.setPasswd(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setPostcode(rs.getString(8));
				user.setGrade(rs.getInt(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return user;
	}
	public boolean checkUser(String name,String pass){
		boolean flag=false;
		conn=new DBConn().getConn();
		try {
			String sql="select passwd from users where username=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.next()){
			if(rs.getString(1).equals(pass)){
				flag=true;
			} 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public boolean checkName(String name){
		boolean flag=false;
		conn=new DBConn().getConn();
		try {
			String sql="select passwd from users where username=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public boolean adduser(String name,String pass,String address){
		boolean flag=false;
		conn=new DBConn().getConn();
		try {
			String sql="insert into users (username,truename,passwd,email,phone,address,postcode,grade) values(?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, "asda");
			ps.setString(3, pass);
			ps.setString(4, "asda");
			ps.setString(5, "asda");
			ps.setString(6, address);
			ps.setString(7, "243");
			ps.setInt(8, 1);
			int i=ps.executeUpdate();
			if(i==1){
			 flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
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
