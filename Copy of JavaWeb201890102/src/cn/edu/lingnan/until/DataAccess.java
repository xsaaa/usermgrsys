package cn.edu.lingnan.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/water";
	private static String username = "root";
	private static String password = "123456";
	private static Connection conn = null;
	
	
	public static Connection getConnection() {
	try{
		Class.forName(driver);//ע����������
	  conn = DriverManager.getConnection//��ȡ���ݿ�����
					(url ,username,password);
	 
	}catch(ClassNotFoundException e)
	{
		System.out.println("����jar���Ƿ���سɹ�");
		e.printStackTrace();
	}catch (SQLException e) {
		System.out.print("��ȡ���ݿ�����ʱ���ִ���");
		e.printStackTrace();
	}
//	finally
//	{
//		try {
//			if(conn!=null){
//			conn.close();
//			conn=null;
//			}
//		} catch (SQLException e) {
//			System.out.print("�ر�����ʱ���ִ���");
//			e.printStackTrace();
//		}
//		
//	}
	
	return conn;
	}
	public static void closeconn(Connection conn,Statement stat,PreparedStatement prep,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
				rs = null;
				}
			if(stat!=null){
				stat.close();
				stat = null;
				}
			if(prep!=null){
				prep.close();
				prep = null;
				}
			if(conn!=null){
				conn.close();
				conn = null;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
