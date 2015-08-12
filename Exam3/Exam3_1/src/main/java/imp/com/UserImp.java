package imp.com;
//这个类的作用是设置数据库操作的相应方法，并且提供输出操作
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.com.UserDao;

public class UserImp implements UserDao {
	public void selectById(Connection conn, long id) throws SQLException {
		String selectsql = "SELECT *FROM country WHERE country_id=?";
		PreparedStatement ps =conn.prepareCall(selectsql);
		ps.setLong(1, id);
		ps.execute();
		ResultSet rs = ps.getResultSet();
		while (rs.next()) {
			System.out.println("国家的id为："+rs.getString(1)+"  国家的名称为："+rs.getString(2)+"  最后更新时间："+rs.getString(3));
		}
		String selectsql1 = "SELECT *FROM city WHERE country_id=?";
		PreparedStatement ps1 =conn.prepareCall(selectsql1);
		ps1.setLong(1, id);
		ps1.execute();
		ResultSet rs1 = ps1.getResultSet();
		System.out.println("该国家包含了以下城市：");
		while (rs1.next()) {
			System.out.println("城市的id为："+rs1.getString(1)+"  城市的名称为：："+rs1.getString(2)+"  所属国家的id为："+rs1.getString(3)+"  最后更新时间为："+rs1.getString(4));
		}
	}
	
	
	
	
}
