package cn.edu.lingnan.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.lingnan.dao.billDAO;
import cn.edu.lingnan.dao.usersDAO;
import cn.edu.lingnan.dao.warehouseDAO;
import cn.edu.lingnan.until.DataAccess;
import cn.edu.lingnan.until.DataAccess2;


public class JDBCtest {

	public static void main(String[] args)  {
		usersDAO u = new usersDAO();
		billDAO b = new billDAO();
		warehouseDAO w = new warehouseDAO();
//		u.deleteusersByusersID("u01");
//		u.FindAllusersInfo();
//		u.findusersByusersID("u01");
//		u.InsertIntousers("u02", "bb", "1", "u02");
//		u.updateusersWithname("cc", "u01");
//		u.deleteusersByusersID("u01");
//		u.findusersByUsersIDandPassword("u01", "u01");
//		b.findbillByusersID("u01");
//		b.InsertIntobill("u02", "female", "2", "16","0");
//		b.updatebillWithtotalprice("16", "u02");
//		b.deletebillByusersID("u01");
//		b.InsertIntobill2("u03", "female", "3", "3*8","0");
//		w.updatewarehouseWithamount();
//			Connection conn = null;
//			Statement stat = null;
//			ResultSet rs = null;
//			try {
//				conn = DataAccess.getConnection();
//				stat = conn.createStatement();
//				rs = stat.executeQuery("select * from users,warehouse,bill");
//				while(rs.next()) {
//					System.out.println(rs.getString("usersID"));
//					System.out.println(rs.getString("usersName"));
//					System.out.println(rs.getString("type"));
//					System.out.println(rs.getString("amount"));
//					System.out.println(rs.getString("price"));
//					System.out.println(rs.getString("usersID"));
//					System.out.println(rs.getString("num"));
//					System.out.println(rs.getString("totalprice"));
//					System.out.println(rs.getString("type"));
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			finally {
//				try {
//					if(rs != null) {
//						rs.close();
//						rs = null;
//					}
//					if(stat != null) {
//						stat.close();
//						stat = null;
//					}
//					if(conn != null) {
//						conn.close();
//						conn = null;
//					}
//				}
//					catch (SQLException e) {
//						e.printStackTrace();
//					}
//				
//			}
	}

}
