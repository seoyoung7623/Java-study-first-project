package �߰�ó����Ʈ��;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//�ٴ����� �����ϱ�
//���ڴ����� �ƴ϶� ���� ������ ������ؾ��ϴ� ��쵵 �����ִ�. �̷����� ButteredReader�� printer-WriterŬ������ ����ϸ� �ȴ�. �������α׷��� �ٴ����� �����ϵ��� �����Ͽ�����.
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
