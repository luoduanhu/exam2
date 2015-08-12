package test.com;
//这个类的作用是设置数据库信息并调用相应方法进行数据库操作
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import dao.com.UserDao;
import imp.com.UserImp;
import util.com.ConnectionFactory;

public class Start {
	public static void main(String args[]){
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			UserDao userDao = new UserImp();
			
            System.out.println("请输入Customer ID:");
	    	Scanner in = new Scanner(System.in);
			long id = in.nextLong();
			userDao.selectById(conn, id);
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
