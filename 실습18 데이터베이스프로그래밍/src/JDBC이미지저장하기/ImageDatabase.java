package JDBC�̹��������ϱ�;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImageDatabase {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:3306/Animals_db?characterEncoding=UTF-8&serverTimezone=UTC";
		String id = "root";
		String password = "Bong0531"; 
		Connection con = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("����̹� ���� ����");
		con = DriverManager.getConnection(url, id, password);
		System.out.println("�����ͺ��̽� ���� ����");
		} catch (ClassNotFoundException e) {
		System.out.println("����̹��� ã�� �� �����ϴ�.");
		} catch (SQLException e) {
		System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
		return con;
	}
	
	public static void main(String[] args) throws Exception{
		Connection con = makeConnection();
		Statement stmt = con.createStatement();
		
		String createTable = "create table Animals("
				+ "Name varchar(255), "
				+ "Type varchar(50), "
				+ "Image blob)";
		stmt.execute(createTable);
		
		String query = "insert into Animals (Name, Type, Image) values (?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, "Dog");
		pstmt.setString(2, "White Dog");
		FileInputStream fin = new FileInputStream("dog1.jpg");
		pstmt.setBinaryStream(3, fin);
		pstmt.execute();
		
		pstmt.setString(1, "Cat");
		pstmt.setString(2, "Gray Cat");
		fin = new FileInputStream("cat1.jpg");
		pstmt.setBinaryStream(3, fin);
		pstmt.execute();
		
		System.out.println("�����Ͱ� �߰��Ǿ����ϴ�.");
		
		ResultSet rs = stmt.executeQuery("select * from Animals");
		while (rs.next()) {
			System.out.print("Name: "+rs.getString("Name")+", ");
			System.out.print("Type: "+rs.getString("Type")+", ");
			System.out.print("Image: "+rs.getBlob("Image"));
			System.out.println();
		}
		con.close();
	}
}
