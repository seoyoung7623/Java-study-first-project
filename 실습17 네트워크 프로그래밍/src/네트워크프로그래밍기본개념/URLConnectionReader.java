package ��Ʈ��ũ���α׷��ֱ⺻����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class URLConnectionReader {
	public static void main(String[] args) throws Exception {
		URL site = new URL("https://www.naver.com/");
		URLConnection url = site.openConnection();
		//URLConnection��ü�� �̿��Ͽ� �ܺ� URL�� ���Ͽ� ǥ�õǴ� ������ ������ �� �ִ�.
		
		//���� ���
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.getInputStream()));
		String inLine;
		
		while ((inLine = in.readLine()) != null)
			System.out.println(inLine);
		in.close();
	}
}
