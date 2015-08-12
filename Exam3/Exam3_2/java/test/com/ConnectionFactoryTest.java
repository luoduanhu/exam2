package test.com;
import java.sql.Connection;
//这个类的作用是创建数据库的连接
import util.com.ConnectionFactory;
public class ConnectionFactoryTest {

	public static void main(String[] args) throws Exception{
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection conn = cf.makeConnection();
		System.out.println(conn.getAutoCommit());
	}

}
