package UDP이용서버클라이언트;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Reciver {
	public static void main(String[] args) throws IOException {
		byte[] b = new byte[256];
		DatagramSocket socket = new DatagramSocket(5000);
		DatagramPacket packet = new DatagramPacket(b, b.length);
		socket.receive(packet);
		System.out.println(new String(b));
	}

}
