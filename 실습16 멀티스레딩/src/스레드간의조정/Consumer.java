package 스레드간의조정;

public class Consumer implements Runnable{
	private Buffer buffer;
	
	public Consumer(Buffer drop) {
		this.buffer = drop;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i<10;i++) {
			int data = buffer.get(); //버퍼에 케이크를 가져온다.
			System.out.println("소비자: "+data+"번 케이크를 소비하였습지다.");
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

}
