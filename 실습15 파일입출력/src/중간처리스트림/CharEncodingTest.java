package 중간처리스트림;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//inputstreamReader는 바이트를 문자로 바꿔줌. 이과정에서 파일을 읽는 엔코딩을 바꿀수 있다.

public class CharEncodingTest {
	public static void main(String[] args) throws IOException {
		File f = new File("input.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"));
		
		String str;
		while((str = in.readLine()) !=null) {
			System.out.print(str);
		}
		in.close();
	}
}
