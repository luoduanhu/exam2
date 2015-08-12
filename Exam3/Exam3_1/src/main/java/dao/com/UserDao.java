package dao.com;
//这是一个接口类，数据库操作的方法在这里添加
import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
	public  void selectById(Connection conn,long id)throws SQLException;
 
}
