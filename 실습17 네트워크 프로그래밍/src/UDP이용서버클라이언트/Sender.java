package UDP이용서버클라이언트;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Sender {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = null;
		socket = new DatagramSocket();
		String s = "우리는 여전히 우리 운명의 주인이다.";
		byte[] b = s.getBytes();
		
		InetAddress address = InetAddress.getByName("127.0.0.1");
		DatagramPacket packet = new DatagramPacket(b,b.length,address,5000);
		
		socket.send(packet);
		socket.close();
	}
}
