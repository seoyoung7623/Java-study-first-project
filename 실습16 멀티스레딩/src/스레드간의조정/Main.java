package �����尣������;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer buffer = new Buffer();
		(new Thread(new Producer(buffer))).start();
		(new Thread(new Consumer(buffer))).start();
	}

}
