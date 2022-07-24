package 네트워크프로그래밍기본개념;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
	public static void main(String[] args) throws IOException {
		try (Socket s = new Socket("time-c.nist.gov", 13)) {
			InputStream inStream = s.getInputStream();
			Scanner in = new Scanner(inStream);
			//Scanner 클래스는 기본 데이터차입/문자열을 구문분석할 수 있음.
			//-> 다양한 타입의 입력값들을 읽어들이기 위한 편리한 방법을 제공하는 클래스.

			
			while (in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println(line);
			}
		}
	}
}
