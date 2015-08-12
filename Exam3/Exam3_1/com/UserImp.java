package imp.com;
//这个类的作用是设置数据库操作的相应方法，并且提供输出操作
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.com.UserDao;
import entity.com.UserTable;

public class UserImp implements UserDao {

	@Override
	public void save(Connection conn, UserTable user) throws SQLException {
		  String savesql = "INSERT INTO user_table(name,password,email) VALUES(?,?,?)";
          PreparedStatement ps =conn.prepareCall(savesql);
          ps.setString(1, user.getName());
          ps.setString(2, user.getPassword());
          ps.setString(3, user.getEmail());
          ps.execute();
	}

	@Override
	public void update(Connection conn, Long id, UserTable user) throws SQLException {
		String updatesql = "UPDATE user_table SET name=?,password=?,email=? WHERE id=?";
		PreparedStatement ps =conn.prepareCall(updatesql);	
		ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setLong(4, id);
        ps.execute();
    	System.out.println("添加id为"+id+"的成员成功！");
	}

	@Override
	public void delete(Connection conn, UserTable user) throws SQLException {
		String deletesql = "DELETE FROM user_table WHERE id=?";
        PreparedStatement ps =conn.prepareCall(deletesql);
        ps.setLong(1, user.getId());
        if(ps.execute()){
        	System.out.println("删除id为"+user+"的成员成功！");
        }
	}

	@Override
	public void selectAll(Connection conn ,String userTable) throws SQLException {
		String selectsql = "SELECT *FROM "+userTable;
		PreparedStatement ps =conn.prepareCall(selectsql);
		ps.execute();
		ResultSet rs = ps.getResultSet();
		while (rs.next()) {
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
		}
	}

	@Override
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
