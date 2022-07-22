package JDBC이용한프로그래밍;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInsertTest {
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
		addBook("Artificial Intellegence","Addison Wesley","2002",35000);
	}
	
	private static void addBook(String title, String publisher, String year, int price) throws SQLException {
		Connection con = makeConnection();
		try {
			//statement객체 생성
			Statement stmt = con.createStatement();
			String s = "insert into books (title,publisher,year,price) values";
			s += "('"+title+"','"+publisher + "','"+year+"','"+price+"')";
			System.out.println(s);
			int i = stmt.executeUpdate(s); //insert문장을 실행
			if (i == 1)
				System.out.println("레코드 추가 성공");
			else
				System.out.println("레코드 추가 실패");
			} catch (SQLException e) {
			// TODO: handle exception
				System.out.println(e.getMessage());
				System.exit(0);
		}
		con.close();
	}
}
