package �����尣������;

public class Consumer implements Runnable{
	private Buffer buffer;
	
	public Consumer(Buffer drop) {
		this.buffer = drop;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i<10;i++) {
			int data = buffer.get(); //���ۿ� ����ũ�� �����´�.
			System.out.println("�Һ���: "+data+"�� ����ũ�� �Һ��Ͽ�������.");
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

}
