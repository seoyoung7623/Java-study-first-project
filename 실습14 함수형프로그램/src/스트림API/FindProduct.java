package ��Ʈ��API;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;

public class FindProduct {
	public static void main(String[] args) {
		int MyNum;
		int Myid=0;
		List<Product> product = new ArrayList<Product>();		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1: ��ǰ�˻�, 2: ��ǰ���");
			System.out.print("��ȣ�� �����ϼ��� :");
			MyNum = sc.nextInt();
			switch (MyNum) {
			case 1:
				String MyProduct;
				int MyPrice;
				System.out.println("��ǰ�� �˻��ϼ���.");
				System.out.print("��ǰ�� �̸�:");
				MyProduct = sc.next();
				System.out.print("��ǰ�� ���ݻ���:");
				MyPrice = sc.nextInt();
				List<Product> resultProduct =
						product.stream()
						.filter(p -> p.price<MyPrice)
						.filter(p -> p.name == MyProduct)
						.collect(toList());
				System.out.println("ã���ô� ��ǰ: "+ resultProduct);
				break;
			case 2:
				String SetProduct;
				int SetPrice;
				System.out.println("��ǰ�� ����մϴ�.");
				System.out.print("��ǰ�� �̸�(Enter),������ �Է��ϼ���.");
				SetProduct = sc.next();
				SetPrice = sc.nextInt();
				product.add(new Product(Myid, SetProduct, SetPrice));
				Myid++;
				System.out.println("��ǰ�� ��ϵǾ����ϴ�.");
			default:
				System.out.println("��ȣ�� �ٽ� �Է����ּ���.");
			}
		}
	}
}
