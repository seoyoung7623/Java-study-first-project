package 중간처리스트림;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//줄단위로 복사하기
//문자단위가 아니라 한줄 단위로 입출력해야하는 경우도 종종있다. 이럴때는 ButteredReader와 printer-Writer클래스를 사용하면 된다. 복사프로그램을 줄단위로 복사하도록 변경하여보자.
public class CopyLines {
	public static void main(String[] args) {
		try (BufferedReader in = new BufferedReader(new FileReader("test.txt"));
				PrintWriter out = new PrintWriter(new FileWriter("output.txt")))
		{
			String line;
			while ((line = in.readLine()) != null) 
			{
				out.println(line);
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
