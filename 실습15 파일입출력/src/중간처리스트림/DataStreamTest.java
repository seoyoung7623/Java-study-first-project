package 중간처리스트림;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {
	public static void main(String[] args) throws IOException {
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new FileOutputStream("data.bin"));
			out.writeInt(123);
			out.writeFloat(123.456F);
			out.close();
			
			in = new DataInputStream(new FileInputStream("data.bin"));
			int aint = in.readInt();
			float afloat = in.readFloat();
			System.out.println(aint);
			System.out.println(afloat);		
		} finally {
			if(in != null) { in.close();}
			if(out != null) {out.close();}
		}
	}
}
