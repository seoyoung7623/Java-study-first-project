package 객체저장하기;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ObjectStreamTest {
	public static void main(String[] args) throws Exception{
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		int c;
		
		out = new ObjectOutputStream(new FileOutputStream("object.dat"));
		out.writeObject(new Date());
		out.close();
		
		in = new ObjectInputStream(new FileInputStream("object.dat"));
		Date d = (Date) in.readObject();
		System.out.println(d);
		in.close();
	}
}
