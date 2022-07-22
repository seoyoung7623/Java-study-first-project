package JDBC이용한프로그래밍;

import java.sql.*;

public class ConnectDatabase {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:3306/book_db?characterEncoding=UTF-8 &serverTimezone=UTC";
		String id = "root";
		String password = "Bong0531";
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 적재성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
		return con;
	}
	
	public static void main(String[] args) throws SQLException{
		Connection con = makeConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from books");
		while (rs.next()) {
			int id = rs.getInt("book_id");
			String title = rs.getString("title");
			System.out.println(id + " "+ title);
		}
		con.close();
	}

}
