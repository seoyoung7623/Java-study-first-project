package 네트워크프로그래밍기본개념;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ShapeTest {
	public static void main(String[] args) throws IOException{
		String hostname = "www.naver.com";
		
		try {
			InetAddress address =  InetAddress.getByName(hostname);
			System.out.println("IP 주소: "+address.getHostAddress() );
		} catch (UnknownHostException e) {
			// TODO: handle exception
			System.out.println(hostname+ "의 IP 조소를 찾을 수 없습니다.");
		}
	}
}
