package JDBC�̹��������ϱ�;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//�̹��� ����
public class ImageDatabase2 {
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
		PreparedStatement ps = con.prepareStatement("select * from Animals");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Blob b = rs.getBlob(3);
			byte barr[] = b.getBytes(1, (int) b.length());
			
			FileOutputStream fout = new FileOutputStream("dog1.jpg");
			fout.write(barr);
			
			fout.close();
		}
		System.out.println("�̹����� �����߽��ϴ�.");
		con.close();
	}
}
