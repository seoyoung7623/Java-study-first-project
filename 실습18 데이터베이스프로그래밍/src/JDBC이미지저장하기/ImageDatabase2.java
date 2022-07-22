package JDBC이미지저장하기;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//이미지 추출
public class ImageDatabase2 {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:3306/Animals_db?characterEncoding=UTF-8&serverTimezone=UTC";
		String id = "root";
		String password = "Bong0531"; 
		Connection con = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 적재 성공");
		con = DriverManager.getConnection(url, id, password);
		System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
		System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
		System.out.println("연결에 실패하였습니다.");
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
		System.out.println("이미지를 추출했습니다.");
		con.close();
	}
}
