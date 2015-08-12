package imp.com;
//这个类的作用是设置数据库操作的相应方法，并且提供输出操作
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.com.UserDao;

public class UserImp implements UserDao {
	private long id1;
	private long id2;
	public void selectById(Connection conn, long id) throws SQLException {
		String selectsql = "SELECT *FROM customer WHERE customer_id=?";
		PreparedStatement ps =conn.prepareCall(selectsql);
		ps.setLong(1, id);
		ps.execute();
		ResultSet rs = ps.getResultSet();
		while (rs.next()) {
			id1 = rs.getLong(2);
			System.out.println("用户的id为："+rs.getLong(1)+"  用户的名称为："+rs.getString(3)+"."+rs.getString(4));
		}
		
		String selectsql1 = "SELECT *FROM inventory WHERE store_id=?";
		PreparedStatement ps1 =conn.prepareCall(selectsql1);
		ps1.setLong(1, id1);
		ps1.execute();
		ResultSet rs1 = ps1.getResultSet();
		while (rs1.next()) {
			id2 = rs1.getLong(2);
		}
		
		String selectsql2 = "SELECT *FROM film WHERE film_id=?";
		PreparedStatement ps2 =conn.prepareCall(selectsql2);
		ps2.setLong(1, id2);
		ps2.execute();
		ResultSet rs2 = ps2.getResultSet();
		System.out.println("该客户租用的Film为：");
		while (rs2.next()) {
			System.out.println("Film的id为："+rs2.getString(1)+"  Film的名称为：："+rs2.getString(2)+"  Film的租用时间为："+rs2.getString(13));
		}
	}
	
	
	
	
}
