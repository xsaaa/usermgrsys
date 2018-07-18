package cn.edu.lingnan.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DataAccess2 {
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static Connection conn = null;
	private static String xmlPath = "database.conf.xml";
	private static String xsdPath = "database.conf.xsd";
	private static HashMap<String,String> hm = new HashMap<String,String>();
	static{
		if(XmlVaildator1.validator(xmlPath, xsdPath))
		{
			hm = xmlParser.parser(xmlPath);
			driver = hm.get("driver");
			url = hm.get("url");
			user = hm.get("user");
			password = hm.get("password");
		}
	}
	
	public static Connection getConnection() {
	try{
		Class.forName(driver);//ע����������
	  conn = DriverManager.getConnection//��ȡ���ݿ�����
					(url ,user,password);
	 
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
	System.out.println("���ݿ����ӻ�ȡ�ɹ�");
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
