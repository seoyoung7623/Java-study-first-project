package �߰�ó����Ʈ��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//inputstreamReader�� ����Ʈ�� ���ڷ� �ٲ���. �̰������� ������ �д� ���ڵ��� �ٲܼ� �ִ�.

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
