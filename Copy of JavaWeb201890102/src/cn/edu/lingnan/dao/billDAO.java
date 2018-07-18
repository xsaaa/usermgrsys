package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.billDTO;
import cn.edu.lingnan.dto.usersDTO;
import cn.edu.lingnan.dto.waterticketDTO;
import cn.edu.lingnan.until.DataAccess;

public class billDAO {
	public Vector<billDTO> FindAllbillInfo() {
		Vector<billDTO> v = new Vector<billDTO>();
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	try{
	  conn = DataAccess.getConnection();
	  stat = conn.createStatement();//����SQL������ִ��
		String sql = "select * from bill where flag = 0";
	  rs  = stat.executeQuery(sql);
		while(rs.next())//��������
		{
			billDTO b = new billDTO();
			b.setUsersID(rs.getString("usersID"));
			b.setPrice(rs.getString("price"));
			b.setFlag(rs.getString("flag"));
			b.setWaID(rs.getString("waID"));
			v.add(b);
		}
	}catch (SQLException e) {
		System.out.print("����SQL���ʱ���ִ���");
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
			System.out.print("�ر����ӡ���估�����ʱ���ִ���");
			e.printStackTrace();
		}
		
	}
	return v;
}	
	
	//-------------------��-------------------------
	public boolean findbillByusersID(String _usersID)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try{
		  conn = DataAccess.getConnection();
		  prep = conn.prepareStatement
				  ("select * from bill where usersID = ? ");
		  prep.setString(1, _usersID);
		  rs = prep.executeQuery();
		  while (rs.next()){
			  System.out.println(rs.getString(1));
			  System.out.println(rs.getString(2));
			  System.out.println(rs.getString(3));
			  System.out.println(rs.getString(4));
		  }
			 flag = true; 
		}catch (SQLException e) {
			System.out.print("����SQL���ʱ���ִ���");
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
				System.out.print("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
			
		}
	
		return flag;
	}
	
	
	//---------------------------���-----------------------
	
	public boolean InsertIntobill(String _usersID,String _price,String _flag,String waID)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try{
		  conn = DataAccess.getConnection();
		  prep = conn.prepareStatement
				  ("insert into bill values(?,?,?,?)");
		  prep.setString(1, _usersID);
		  prep.setString(2, _price);
		  prep.setString(3, _flag);
		  prep.setString(4, waID);
		  prep.executeUpdate();
			 flag = true; 
		}catch (SQLException e) {
			System.out.print("����SQL���ʱ���ִ���");
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
				System.out.print("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
			
		}
	
		return flag;
	}
		
	//-------------------����Ԫ��--------------------
	public boolean updatebillWithtotalprice(String _price,String _usersID)
	{
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try{
		  conn = DataAccess.getConnection();
		  stat = conn.createStatement();//����SQL������ִ��
	      String sql = "update bill set price = '"+_price+"' where usersID ='"+_usersID+"'";
		  stat.executeUpdate(sql);
		  System.out.println("���³ɹ�");
		  flag = true;
		}catch (SQLException e) {
			System.out.print("����SQL���ʱ���ִ���");
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
				System.out.print("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
		
		}
		return flag;
	}
	
//--------------------ɾ��--------------------
	public boolean deletebillByusersIDandWaID(String _usersID,String _waID)
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
				  ("update bill set flag = 1 where usersID = ? and waID = ?");
		  prep.setString(1, _usersID);
		  prep.setString(2, _waID);
		  prep.executeUpdate();
		  prep1 = conn.prepareStatement
				  ("select * from bill where flag = 0 ");
		  rs1 = prep1.executeQuery();
		  while (rs1.next()){
			  System.out.println(rs1.getString(1));
			  System.out.println(rs1.getString(2));
			  System.out.println(rs1.getString(3));
			  System.out.println(rs1.getString(4));
		  }
			 flag = true; 
		}catch (SQLException e) {
			System.out.print("����SQL���ʱ���ִ���");
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
				System.out.print("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
			
		}
		return flag;
	}
	
//-------------------�°����--------------------------
		public boolean UpdateBillInfo(billDTO bito) {
			boolean fl = false;
			String usersID = bito.getUsersID();
			String price = bito.getPrice();
			String flag = bito.getFlag();
			String waID = bito.getWaID();
			String sql = "update bill set price= '"+price+"',flag= '"+flag+"'"
					+ " where usersID= '"+usersID+"'"+" and waID= '"+waID+"'";
		   Connection conn = null;
		   Statement stat = null;
		try{
		  conn = DataAccess.getConnection();
		  stat = conn.createStatement();//����SQL������ִ��
		  stat.executeUpdate(sql);
          fl = true;
		}catch (SQLException e) {
			System.out.print("����SQL���ʱ���ִ���");
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
				System.out.print("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
			
		}
		return fl;
	}	
			

		//-------------�°����-----------
		public boolean InsertbillInfo(billDTO bito) {
			boolean fl = false;
		    String usersID = bito.getUsersID();
		    String price = bito.getPrice();
		    String flag = bito.getFlag();
		    String waID = bito.getWaID();
			
			String sql = "insert into bill values"
					+"('"+usersID+"','"+price+"','"+flag+"','"+waID+"')";
			String sql2 = "update warehouse set amount=amount-1 where price='"+price+"'";
			String sql3 = "update waterticket set flag=1 where waID='"+waID+"'";
		   Connection conn = null;
		   Statement stat = null;
		try{
		  conn = DataAccess.getConnection();
		  stat = conn.createStatement();//����SQL������ִ��
		  stat.executeUpdate(sql);
		  stat.executeUpdate(sql2);
		  stat.executeUpdate(sql3);
          fl = true;
		}catch (SQLException e) {
			System.out.print("����SQL���ʱ���ִ���");
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
				System.out.print("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
			
		}
		return fl;
	}	

	//��¼ʱ�ж��û����Ƿ����
	//-------------------��-------------------------
	public boolean findbillByWaID(String _waID)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try{
		  conn = DataAccess.getConnection();
		  prep = conn.prepareStatement
				  ("select * from bill where waID = ?");
		  prep.setString(1, _waID);
		  rs = prep.executeQuery();
		  if (rs.first()){
			  flag = true;
		  } 
		}catch (SQLException e) {
			System.out.print("����SQL���ʱ���ִ���");
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
				System.out.print("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
			
		}
	
		return flag;
	}
	

	public Vector<billDTO> findBillByUsersID(String usersID)
	{
		Vector<billDTO> v = new Vector<billDTO>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try{
		  conn = DataAccess.getConnection();
		  prep = conn.prepareStatement
				  ("select * from bill where usersID = ?");
		  prep.setString(1, usersID);
		  rs = prep.executeQuery();
		  while(rs.next())//��������
			{
			  billDTO b = new billDTO();
				b.setUsersID(rs.getString("usersID"));
				b.setPrice(rs.getString("price"));
				b.setFlag(rs.getString("flag"));
				b.setWaID(rs.getString("waID"));
				v.add(b);
			}
		}catch (SQLException e) {
			System.out.print("����SQL���ʱ���ִ���");
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
				System.out.print("�ر����ӡ���估�����ʱ���ִ���");
				e.printStackTrace();
			}
			
		}
	
		return v;
	}
	
}
