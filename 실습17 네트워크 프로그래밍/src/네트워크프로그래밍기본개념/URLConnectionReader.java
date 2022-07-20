package 네트워크프로그래밍기본개념;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class URLConnectionReader {
	public static void main(String[] args) throws Exception {
		URL site = new URL("https://www.naver.com/");
		URLConnection url = site.openConnection();
		//URLConnection객체를 이용하여 외부 URL에 의하여 표시되는 서버에 접속할 수 있다.
		
		//파일 출력
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.getInputStream()));
		String inLine;
		
		while ((inLine = in.readLine()) != null)
			System.out.println(inLine);
		in.close();
	}
}
