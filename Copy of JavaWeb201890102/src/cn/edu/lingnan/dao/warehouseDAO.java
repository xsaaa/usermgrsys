package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.billDTO;
import cn.edu.lingnan.dto.warehouseDTO;
import cn.edu.lingnan.until.DataAccess;

public class warehouseDAO {
	public Vector<warehouseDTO> FindAllwarehouseInfo() {
		Vector<warehouseDTO> v = new Vector<warehouseDTO>();
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	try{
	  conn = DataAccess.getConnection();
	  stat = conn.createStatement();//����SQL������ִ��
		String sql = "select * from warehouse";
	  rs  = stat.executeQuery(sql);
		while(rs.next())//��������
		{
			warehouseDTO w = new warehouseDTO();
			w.setType(rs.getString("type"));
			w.setAmount(rs.getString("amount"));
			w.setPrice(rs.getString("price"));
			w.setFlag(rs.getString("flag"));
			v.add(w);
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
	public boolean findwarehouseBytype(String _type)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try{
		  conn = DataAccess.getConnection();
		  prep = conn.prepareStatement
				  ("select * from warehouse where type = ? ");
		  prep.setString(1, _type);
		  rs = prep.executeQuery();
		  while (rs.next()){
			  System.out.println(rs.getString(1));
			  System.out.println(rs.getString(2));
			  System.out.println(rs.getString(3));
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
	
	
	//-------------------����-------------------------
		public boolean updatewarehouseWithamount()
		{
			boolean flag = false;
			Connection conn = null;
			PreparedStatement prep = null;
			Statement stat = null;
			ResultSet rs = null;
			try{
			  conn = DataAccess.getConnection();
			  prep = conn.prepareStatement
					  ("select * from warehouse,bill where warehouse.flag=bill.flag ");
			  rs = prep.executeQuery();
			 
			  while (rs.next()){
				int  sum1 = Integer.parseInt(rs.getString((2)));
				int  sum2 = Integer.parseInt(rs.getString((7)));
				int  sum = sum1 - sum2;
//				  System.out.println(rs.getString(2));
//				  System.out.println(rs.getString(3));
//				  System.out.println(rs.getString(5));
//				  System.out.println(rs.getString(6));
//				  System.out.println(rs.getString(7));
//				  System.out.println(sum);
				  String sql = "update warehouse set amount = '"+sum;
				  stat.executeUpdate(sql);
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
	
	public boolean InsertIntowarehouse(String _type,String _amount,String _price)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try{
		  conn = DataAccess.getConnection();
		  prep = conn.prepareStatement
				  ("insert into warehouse values(?,?,?)");
		  prep.setString(1, _type);
		  prep.setString(2, _amount);
		  prep.setString(3, _price);
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
	public boolean updatewarehouseWithprice(String _price,String _type)
	{
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try{
		  conn = DataAccess.getConnection();
		  stat = conn.createStatement();//����SQL������ִ��
	      String sql = "update warehouse set price = '"+_price+"' where type ='"+_type+"'";
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
	public boolean deletewarehouseByuserstype(String _type)
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
				  ("update warehouse set flag = 1 where type = ? ");
		  prep.setString(1, _type);
		  prep.executeUpdate();
		  prep1 = conn.prepareStatement
				  ("select * from warehouse where flag = 0 ");
		  rs1 = prep1.executeQuery();
		  while (rs1.next()){
			  System.out.println(rs1.getString(1));
			  System.out.println(rs1.getString(2));
			  System.out.println(rs1.getString(3));
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
				
	public boolean updatewarehouseWithbill(String _price,String _type)
	{
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try{
		  conn = DataAccess.getConnection();
		  stat = conn.createStatement();//����SQL������ִ��
	      String sql = "update warehouse set price = '"+_price+"' where type ='"+_type+"'";
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
		public boolean deletebillBytype(String _type)
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
					  ("update warehouse set flag = 1 where type = ? ");
			  prep.setString(1, _type);
			  prep.executeUpdate();
			  prep1 = conn.prepareStatement
					  ("select * from warehouse where flag = 0 ");
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
		
	//�°����
			public boolean UpdateWarehouseInfo(warehouseDTO wato) {
				boolean fl = false;
				String type = wato.getType();
				String amount = wato.getAmount();
				String price = wato.getPrice();
				String flag = wato.getFlag();
				String sql = "update warehouse set amount= '"+amount+"',"
						+ "price= '"+price+"',flag= '"+flag+"' where type='"+type+"'";
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
		public boolean InsertwarehouseInfo(warehouseDTO wato) {
			boolean fl = false;
		    String type = wato.getType();
		    String amount = wato.getAmount();
		    String price = wato.getPrice();
		    String flag = wato.getFlag();
			
			String sql = "insert into warehouse values"
					+"('"+type+"','"+amount+"','"+price+"','"+flag+"')";
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
		
		



}
