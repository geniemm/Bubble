package bubble_common;

import java.sql.Connection;
import java.sql.DriverManager;

public class BubbleConnect {
	private static Connection con;
	public static Connection getConnect() { 
		// getConnect를 통해서 값을 얻어온다.
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		con = DriverManager.getConnection(url,"geniemm","1234");
		//System.out.println("DB 연결 성공!");
	} catch (Exception e) {
		e.printStackTrace();
	}

	return con;
	}
}
