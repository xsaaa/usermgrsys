package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.usersDTO;
import cn.edu.lingnan.until.DataAccess;
import cn.edu.lingnan.until.DataAccess2;

public class usersDAO {
	public Vector<usersDTO> FindAllusersInfo() {
		Vector<usersDTO> v = new Vector<usersDTO>();
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	try{
	  conn = DataAccess.getConnection();
	  stat = conn.createStatement();//创建SQL语句对象并执行
		String sql = "select * from users where flag = 0";
	  rs  = stat.executeQuery(sql);
		while(rs.next())//处理结果集
		{
			usersDTO u = new usersDTO();
			System.out.println(rs.getString("usersID"));
 		    System.out.println(rs.getString("usersName"));
			u.setSuperUsers(rs.getString("superUsers"));
			u.setPassword(rs.getString("password"));
			u.setUsersID(rs.getString("usersID"));
			u.setUsersName(rs.getString("usersName"));
			u.setFlag(rs.getString("flag"));	
			v.add(u);
		}
	}catch (SQLException e) {
		System.out.print("运行SQL语句时出现错误");
		e.printStackTrace();
	}finally
	{
		try {
			if(rs!=null){
			rs.close();
			rs=null;
			}
			if(stat!=null){
			stat.close();
			stat=null;
			}
			if(conn!=null){
			conn.close();
			conn=null;
			}
		} catch (SQLException e) {
			System.out.print("关闭连接、语句及结果集时出现错误");
			e.printStackTrace();
		}
		
	}
	return v;
}	
	
	//-------------------查-------------------------
	public int findusersByUsersIDandPassword(String _usersID,String _password)
	{
		int superValue = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try{
		  conn = DataAccess.getConnection();
		  prep = conn.prepareStatement
				  ("select * from users where usersID = ? and password = ?");
		  prep.setString(1, _usersID);
		  prep.setString(2, _password);
		  rs = prep.executeQuery();
		  if (rs.next()){
			  superValue = Integer.parseInt(rs.getString("superUsers"));
			  System.out.println("------1------"+superValue);
		  } 
		}catch (SQLException e) {
			System.out.print("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally
		{
			try {
				if(rs!=null){
				rs.close();
				}
				if(prep!=null){
					prep.close();
				}
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				System.out.print("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
	
		return superValue;
	}
	

	//---------------------------添加-----------------------
	
	public boolean InsertIntousers(String _usersID,String _userName,String _superUsers,String _password)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try{
		  conn = DataAccess.getConnection();
		  prep = conn.prepareStatement
				  ("insert into users values(?,?,?,?)");
		  prep.setString(1, _usersID);
		  prep.setString(2, _userName);
		  prep.setString(3, _superUsers);
		  prep.setString(4, _password);
		  prep.executeUpdate();
			 flag = true; 
		}catch (SQLException e) {
			System.out.print("运行SQL语句时出现错误");
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null){
				rs.close();
				}
				if(prep!=null){
					prep.close();
				}
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				System.out.print("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
	
		return flag;
	}
		
		//-------------------更新元素--------------------
	public boolean updateusersWithname(String _usersName,String _usersID)
	{
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		System.out.print("ashjlfhdnskl");
		try{
		  conn = DataAccess.getConnection();
		  stat = conn.createStatement();//创建SQL语句对象并执行
	      String sql = "update users set usersName = '"+_usersName+"' where usersID ='"+_usersID+"'";
		  stat.executeUpdate(sql);
		  System.out.println("更新成功");
		  flag = true;
		}catch (SQLException e) {
			System.out.print("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally
		{
			try {
				if(stat!=null){
				stat.close();
				stat=null;
				}
				if(conn!=null){
				conn.close();
				conn=null;
				}
			} catch (SQLException e) {
				System.out.print("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
		
		}
		return flag;
	}
	
	//----------删除-----------
	public boolean deleteusersByusersID(String _usersID)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		PreparedStatement prep1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try{
		  conn = DataAccess.getConnection();
		  prep = conn.prepareStatement
				  ("update users set flag = 1 where usersID = ?");
		  prep.setString(1, _usersID);
		  prep.executeUpdate();
		  
		  prep = conn.prepareStatement
				  ("update bill set flag = 1 where usersID = ?");
		  prep.setString(1, _usersID);
		  prep.executeUpdate();
		  
		  prep1 = conn.prepareStatement
				  ("select * from users where flag = 0 ");
		  rs1 = prep1.executeQuery();
		  while (rs1.next()){
			  System.out.println(rs1.getString(1));
			  System.out.println(rs1.getString(2));
		  }
			 flag = true; 
		}catch (SQLException e) {
			System.out.print("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally
		{
			try {
				if(rs!=null){
				rs.close();
				}
				if(prep!=null){
					prep.close();
				}
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				System.out.print("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
		return flag;
	}
	
	
	//-------------新版插入-----------
		public boolean InsertuserInfo(usersDTO usto) {
			boolean fl = false;
			String usersID = usto.getUsersID();
			String usersName = usto.getUsersName();
			String password = usto.getPassword();
			String superUsers = usto.getSuperUsers();
			String flag = usto.getFlag();
			String sql = "insert into users values"
					+"('"+usersID+"','"+usersName+"','"+password+"','"+superUsers+"','"+flag+"')";
			//String sql2 = "update waterticket set flag=1 where waID='"+waID+"'";
		   Connection conn = null;
		   Statement stat = null;
		try{
		  conn = DataAccess.getConnection();
		  stat = conn.createStatement();//创建SQL语句对象并执行
		  stat.executeUpdate(sql);
		  //stat.executeUpdate(sql2);
          fl = true;
		}catch (SQLException e) {
			System.out.print("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally
		{
			try {
				if(stat!=null){
				stat.close();
				stat=null;
				}
				if(conn!=null){
				conn.close();
				conn=null;
				}
			} catch (SQLException e) {
				System.out.print("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
		return fl;
	}	
		
		//--------------------新版更新------------------------
		public boolean UpdateusersInfo(usersDTO usto) {
			boolean fl = false;
			String usersID = usto.getUsersID();
			String usersName = usto.getUsersName();
			String password = usto.getPassword();
			String superUsers = usto.getSuperUsers();
			String flag = usto.getFlag();
			String sql = "update users set usersName= '"+usersName+"',"
					+ "superUsers= '"+superUsers+"',password= '"+password+"',"
					+ "flag= '"+flag+"' where usersID= '"+usersID+"'";
		   Connection conn = null;
		   Statement stat = null;
		try{
		  conn = DataAccess.getConnection();
		  stat = conn.createStatement();//创建SQL语句对象并执行
		  stat.executeUpdate(sql);
          fl = true;
		}catch (SQLException e) {
			System.out.print("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally
		{
			try {
				if(stat!=null){
				stat.close();
				stat=null;
				}
				if(conn!=null){
				conn.close();
				conn=null;
				}
			} catch (SQLException e) {
				System.out.print("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
		return fl;
	}	
	
		//-------------新版插入-----------
		public boolean InsertusersInfo(usersDTO usto) {
			boolean fl = false;
			String usersID = usto.getUsersID();
			String usersName = usto.getUsersName();
			String superUsrs = usto.getSuperUsers();
			String password = usto.getPassword();
			String flag = usto.getFlag();
			String sql = "insert into users values"
					+"('"+usersID+"','"+usersName+"','"+superUsrs+"','"+password+"','"+flag+"')";
		   Connection conn = null;
		   Statement stat = null;
		try{
		  conn = DataAccess.getConnection();
		  stat = conn.createStatement();//创建SQL语句对象并执行
		  stat.executeUpdate(sql);
          fl = true;
		}catch (SQLException e) {
			System.out.print("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally
		{
			try {
				if(stat!=null){
				stat.close();
				stat=null;
				}
				if(conn!=null){
				conn.close();
				conn=null;
				}
			} catch (SQLException e) {
				System.out.print("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
		return fl;
	}	
		
	//登录时判断用户名是否存在
	//-------------------查-------------------------
	public boolean findusersByUsersName(String _usersName)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try{
		  conn = DataAccess.getConnection();
		  prep = conn.prepareStatement
				  ("select * from users where usersName = ?");
		  prep.setString(1, _usersName);
		  rs = prep.executeQuery();
		  if (rs.first()){
			  flag = true;
		  } 
		}catch (SQLException e) {
			System.out.print("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally
		{
			try {
				if(rs!=null){
				rs.close();
				}
				if(prep!=null){
					prep.close();
				}
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				System.out.print("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
	
		return flag;
	}
	
	//---------------根据usersID查询----------------------
	public Vector<usersDTO> findusersByUsersID(String usersID)
	{
		Vector<usersDTO> v = new Vector<usersDTO>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try{
		  conn = DataAccess.getConnection();
		  prep = conn.prepareStatement
				  ("select * from users where usersID = ?");
		  prep.setString(1, usersID);
		  rs = prep.executeQuery();
		  while(rs.next())//处理结果集
			{
				usersDTO u = new usersDTO();
				u.setSuperUsers(rs.getString("superUsers"));
				u.setPassword(rs.getString("password"));
				u.setUsersID(rs.getString("usersID"));
				u.setUsersName(rs.getString("usersName"));
				u.setFlag(rs.getString("flag"));
				v.add(u);
			}
		}catch (SQLException e) {
			System.out.print("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally
		{
			try {
				if(rs!=null){
				rs.close();
				}
				if(prep!=null){
					prep.close();
				}
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				System.out.print("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
	
		return v;
	}
	
}
