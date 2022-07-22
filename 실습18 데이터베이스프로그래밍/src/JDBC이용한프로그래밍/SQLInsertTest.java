package JDBC�̿������α׷���;

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
	
	public static void main(String[] args) throws SQLException{
		addBook("Artificial Intellegence","Addison Wesley","2002",35000);
	}
	
	private static void addBook(String title, String publisher, String year, int price) throws SQLException {
		Connection con = makeConnection();
		try {
			//statement��ü ����
			Statement stmt = con.createStatement();
			String s = "insert into books (title,publisher,year,price) values";
			s += "('"+title+"','"+publisher + "','"+year+"','"+price+"')";
			System.out.println(s);
			int i = stmt.executeUpdate(s); //insert������ ����
			if (i == 1)
				System.out.println("���ڵ� �߰� ����");
			else
				System.out.println("���ڵ� �߰� ����");
			} catch (SQLException e) {
			// TODO: handle exception
				System.out.println(e.getMessage());
				System.exit(0);
		}
		con.close();
	}
}
