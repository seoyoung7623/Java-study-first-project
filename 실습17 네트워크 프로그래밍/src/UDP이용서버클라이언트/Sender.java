package UDP�̿뼭��Ŭ���̾�Ʈ;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Sender {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = null;
		socket = new DatagramSocket();
		String s = "�츮�� ������ �츮 ����� �����̴�.";
		byte[] b = s.getBytes();
		
		InetAddress address = InetAddress.getByName("127.0.0.1");
		DatagramPacket packet = new DatagramPacket(b,b.length,address,5000);
		
		socket.send(packet);
		socket.close();
	}
}
