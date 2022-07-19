package 스레드실행생성;

//람다식을 이용한 스레드 작성
public class LambdaTest {
	public static void main(String[] args) {
		Runnable task = () -> {
			for(int i=0;i<10;i++) {
				System.out.print(i+ " ");
			}
		};
		new Thread(task).start();
	}
}
