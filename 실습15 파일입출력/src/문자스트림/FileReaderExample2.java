package 문자스트림;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample2 {
	public static void main(String[] args) {
		try (FileReader fr = new FileReader("./test.txt")){
			int ch;
			
			while((ch = fr.read()) != -1)
				System.out.print((char)ch);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
