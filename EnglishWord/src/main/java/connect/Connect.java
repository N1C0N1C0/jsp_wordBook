package connect;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	public Connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String uri = "jdbc:oracle:thin:@127.0.0.1:1521/XE";
			String id = "hr";
			String pwd = "hr";
			
			con = DriverManager.getConnection(uri,id,pwd);
			System.out.println("연결 완료!");
		}catch(Exception e) {
			e.printStackTrace();
	
		}
	}
	public void close() {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
			
			System.out.println("연결 해제");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
