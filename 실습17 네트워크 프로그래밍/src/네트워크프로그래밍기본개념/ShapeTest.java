package ��Ʈ��ũ���α׷��ֱ⺻����;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ShapeTest {
	public static void main(String[] args) throws IOException{
		String hostname = "www.naver.com";
		
		try {
			InetAddress address =  InetAddress.getByName(hostname);
			System.out.println("IP �ּ�: "+address.getHostAddress() );
		} catch (UnknownHostException e) {
			// TODO: handle exception
			System.out.println(hostname+ "�� IP ���Ҹ� ã�� �� �����ϴ�.");
		}
	}
}
