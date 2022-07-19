package 스레드실행생성;
//2개의 스레드를 생성하고 실행하면 스레드의 출력이 섞이는걸 알수 있다.

class MyRun implements Runnable{
	String name;
	public MyRun(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i=0;i<=11;i++)
			System.out.print(name+ i+" ");
	}
	
}

public class TestThread {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRun("A"));
		Thread t2 = new Thread(new MyRun("B"));
		t1.start();
		t2.start();
	}
}
