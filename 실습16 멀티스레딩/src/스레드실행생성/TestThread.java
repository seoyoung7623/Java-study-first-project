package ������������;
//2���� �����带 �����ϰ� �����ϸ� �������� ����� ���̴°� �˼� �ִ�.

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
