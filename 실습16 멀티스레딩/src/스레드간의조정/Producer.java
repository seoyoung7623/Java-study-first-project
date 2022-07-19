package 스레드간의조정;

public class Producer implements Runnable{
	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			buffer.put(i); //버퍼에 케이크를 가져다놓는다.
			System.out.println("생산자: "+i+"번 케이크를 생산하였습니다.");
			try {
				Thread.sleep((int)(Math.random() * 100));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

}
