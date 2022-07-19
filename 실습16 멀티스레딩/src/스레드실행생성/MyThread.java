package 스레드실행생성;

public class MyThread extends Thread{
	public void run() {
		for(int i=0;i<=10;i++)
			System.out.print(i+" ");
	}
}
