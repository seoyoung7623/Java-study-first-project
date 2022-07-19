package 바이트스트림;

import java.io.FileInputStream;
import java.io.IOException;

public class FileStreamTest2 {
	public static void main(String[] args) {
		byte list[] = new byte[6];
		try (FileInputStream out = new FileInputStream("test.bin")){
			out.read(list);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		for(byte b:list)
			System.out.print(b+" ");
		System.out.println();
	}
}
