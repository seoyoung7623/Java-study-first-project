package ��Ʈ��ũ���α׷��ֱ⺻����;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
	public static void main(String[] args) throws IOException {
		try (Socket s = new Socket("time-c.nist.gov", 13)) {
			InputStream inStream = s.getInputStream();
			Scanner in = new Scanner(inStream);
			//Scanner Ŭ������ �⺻ ����������/���ڿ��� �����м��� �� ����.
			//-> �پ��� Ÿ���� �Է°����� �о���̱� ���� ���� ����� �����ϴ� Ŭ����.

			
			while (in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println(line);
			}
		}
	}
}
