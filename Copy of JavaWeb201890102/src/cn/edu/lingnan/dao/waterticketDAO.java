package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.billDTO;
import cn.edu.lingnan.dto.warehouseDTO;
import cn.edu.lingnan.dto.waterticketDTO;
import cn.edu.lingnan.until.DataAccess;

public class waterticketDAO {
	public Vector<waterticketDTO> FindAllwaterticketInfo() {
		Vector<waterticketDTO> v = new Vector<waterticketDTO>();
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	try{
	  conn = DataAccess.getConnection();
	  stat = conn.createStatement();//创建SQL语句对象并执行
		String sql = "select * from waterticket where flag = 0";
	  rs  = stat.executeQuery(sql);
		while(rs.next())//处理结果集
		{
			waterticketDTO wt = new waterticketDTO();
			wt.setWaID(rs.getString("waID"));
			wt.setType(rs.getString("type"));
			wt.setPrice(rs.getString("price"));
			wt.setFlag(rs.getString("flag"));
			v.add(wt);
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
	
//--------------------删除--------------------
		public boolean deleteticketBywaID(String _waID)
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
					  ("update waterticket set flag = 1 where waID = ? ");
			  prep.setString(1, _waID);
			  prep.executeUpdate();
			  prep1 = conn.prepareStatement
					  ("select * from waterticket where flag = 0 ");
			  rs1 = prep1.executeQuery();
			  while (rs1.next()){
				  System.out.println(rs1.getString(1));
				  System.out.println(rs1.getString(2));
				  System.out.println(rs1.getString(3));
				  System.out.println(rs1.getString(4));
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
		
	//-----------------------新版更新---------------------------
			public boolean UpdateWaterticketInfo(waterticketDTO wtto) {
				boolean fl = false;
				String waID = wtto.getWaID();
				String type = wtto.getType();
				String price = wtto.getPrice();
				String flag = wtto.getFlag();
				String sql = "update waterticket set type= '"+type+"',"
						+ "price= '"+price+"',"
						+ "flag= '"+flag+"' where waID='"+waID+"'";
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
		public boolean InsertwaterticketInfo(waterticketDTO wtto) {
			boolean fl = false;
			String type = wtto.getType();
			String price = wtto.getPrice();
			String flag = wtto.getFlag();
			String waID = wtto.getWaID();
			String sql = "insert into waterticket values"
					+"('"+waID+"','"+type+"','"+price+"','"+flag+"')";
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


}
