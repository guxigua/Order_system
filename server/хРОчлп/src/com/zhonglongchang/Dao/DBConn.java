package com.zhonglongchang.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	 private  Connection conn=null;
	   private static String strConn="jdbc:sqlserver://ZLC:1433;DatabaseName=restaurant";
	   private static String user="sa";
	   private static String passwd="zlc5201314";
		public Connection  getConn(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
			conn=DriverManager.getConnection(strConn, user, passwd);
			System.out.println("数据库连接成功！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return conn;
		}
		public static void main(String[] args) {
			new DBConn().getConn();
		}
}
