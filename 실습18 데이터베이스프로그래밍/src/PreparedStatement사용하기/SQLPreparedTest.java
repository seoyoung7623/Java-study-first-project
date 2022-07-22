package PreparedStatement사용하기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class SQLPreparedTest {
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
	
	//Prepares Statements 기능을 사용하여서 많이 사용되는 쿼지문장을 미리 만들어두고 필요할때마다 사용해보자
	public static void main(String[] args) throws SQLException{
		Connection con = makeConnection();
		//외부에서 제공되는 값은 ?로 표시된다.
		String quary = "select books.title, books.price"+" from books"+" where publisher = ?";
		PreparedStatement stmt = con.prepareStatement(quary);
		stmt.setString(1,"Wiley"); //?에 해당하는 값을 주어준다.
		//첫번째 인수는 ? 변수의 번호, 두번째 인수는 변수의 값
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String title = rs.getString("title");
			int price = rs.getInt("price");
			System.out.println(title+" "+ price);
		}
		con.close();
	}

}
