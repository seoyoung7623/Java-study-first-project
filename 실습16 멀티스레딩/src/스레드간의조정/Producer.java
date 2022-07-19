package �����尣������;

public class Producer implements Runnable{
	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			buffer.put(i); //���ۿ� ����ũ�� �����ٳ��´�.
			System.out.println("������: "+i+"�� ����ũ�� �����Ͽ����ϴ�.");
			try {
				Thread.sleep((int)(Math.random() * 100));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

}
