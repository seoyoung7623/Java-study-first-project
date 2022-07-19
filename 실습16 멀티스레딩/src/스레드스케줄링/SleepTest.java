package 스레드스케줄링;

//4초간격으로 메시지 출력하기
public class SleepTest {
	public static void main(String[] args) throws InterruptedException{
		String massage[] = {"Pride will have a fall.",
				"Power is dangerous unless you have humility.",
				"Office changes manners.",
				"Empty vessels make the most sound."};
		
		for(int i=0;i<massage.length;i++) {
			Thread.sleep(1000);
			System.out.println(massage[i]);
		}
	}
}
