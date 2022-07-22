package PreparedStatement����ϱ�;

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
			System.out.println("����̹� ���缺��");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
		return con;
	}
	
	//Prepares Statements ����� ����Ͽ��� ���� ���Ǵ� ���������� �̸� �����ΰ� �ʿ��Ҷ����� ����غ���
	public static void main(String[] args) throws SQLException{
		Connection con = makeConnection();
		//�ܺο��� �����Ǵ� ���� ?�� ǥ�õȴ�.
		String quary = "select books.title, books.price"+" from books"+" where publisher = ?";
		PreparedStatement stmt = con.prepareStatement(quary);
		stmt.setString(1,"Wiley"); //?�� �ش��ϴ� ���� �־��ش�.
		//ù��° �μ��� ? ������ ��ȣ, �ι�° �μ��� ������ ��
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String title = rs.getString("title");
			int price = rs.getInt("price");
			System.out.println(title+" "+ price);
		}
		con.close();
	}

}
