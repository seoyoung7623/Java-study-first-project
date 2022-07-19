package 스트림API;

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
			System.out.println("1: 제품검색, 2: 제품등록");
			System.out.print("번호를 선택하세요 :");
			MyNum = sc.nextInt();
			switch (MyNum) {
			case 1:
				String MyProduct;
				int MyPrice;
				System.out.println("상품을 검색하세요.");
				System.out.print("상품의 이름:");
				MyProduct = sc.next();
				System.out.print("상품의 가격상한:");
				MyPrice = sc.nextInt();
				List<Product> resultProduct =
						product.stream()
						.filter(p -> p.price<MyPrice)
						.filter(p -> p.name == MyProduct)
						.collect(toList());
				System.out.println("찾으시는 상품: "+ resultProduct);
				break;
			case 2:
				String SetProduct;
				int SetPrice;
				System.out.println("상품을 등록합니다.");
				System.out.print("상품의 이름(Enter),가격을 입력하세요.");
				SetProduct = sc.next();
				SetPrice = sc.nextInt();
				product.add(new Product(Myid, SetProduct, SetPrice));
				Myid++;
				System.out.println("제품이 등록되었습니다.");
			default:
				System.out.println("번호를 다시 입력해주세요.");
			}
		}
	}
}
