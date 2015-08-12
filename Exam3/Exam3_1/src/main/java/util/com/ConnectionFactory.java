package util.com;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
//这个类相当于一个给你工厂类，该工厂类的作用是读取并且根据配置的信息创建一个数据库连接
public class ConnectionFactory {
  private static String driver;
  private static String dburl;
  private static String user;
  private static String password;
  private Connection conn;
  private static final ConnectionFactory factory = new ConnectionFactory();
  
  
  static{
	    Properties pro = new Properties();
	  try {
		InputStream in = ConnectionFactory.class.getResourceAsStream("dbconfig.properties");
	    pro.load(in);
	  } catch (Exception e) {
		System.out.println("配置文件读取错误！");
		e.printStackTrace();
	}
	  
	  driver = pro.getProperty("driver");
	  dburl = pro.getProperty("dburl");
	  user = pro.getProperty("user");
	  password = pro.getProperty("password");
  }
  private ConnectionFactory(){
	  
  }
  public static ConnectionFactory getInstance(){
	  return factory;
  }
  
  public Connection makeConnection(){
	  try {
		Class.forName(driver);
		conn = DriverManager.getConnection(dburl, user, password);
	} catch (Exception e) {
	}
	  return conn;
  }
}
