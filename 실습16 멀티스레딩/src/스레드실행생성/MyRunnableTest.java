package ������������;

class MyRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<=10;i++)
			System.out.print(i+" ");
	}
	
}

public class MyRunnableTest {
	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnable());//Runnable��ü�� Thread�������� �Ű������� �ѱ��.
		t.start();
	}
}
