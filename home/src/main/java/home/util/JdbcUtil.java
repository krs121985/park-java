package home.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtil {
	//아무데서나 쉽게 호출이 가능하도록 실행도구(PreparedStatement) 생성 구문을 모듈화
	//- 매개변수로 SQL 구문을 받아와서 PreparedStatement를 반환하도록 설계
	public static PreparedStatement getWorker(String sql) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "the01";
		String password = "the01";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		PreparedStatement ps = conn.prepareStatement(sql);
		return ps;
	}
	
	//사용한 도구를 정리하는 메소드
	public static void close(PreparedStatement ps) throws SQLException {
		Connection conn = ps.getConnection();//연결정보를 꺼내서
		ps.close();//실행도구 먼저 정리하고
		conn.close();//연결정보를 마지막에 정리한다
	}
}





