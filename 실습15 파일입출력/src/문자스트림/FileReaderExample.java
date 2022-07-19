package 문자스트림;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("./test.txt");
			int ch;
			while((ch = fr.read()) != -1)
				System.out.print((char) ch + " ");
			fr.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
}
