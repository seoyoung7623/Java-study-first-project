package 스트림API;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

class Product{
	int id;
	String name;
	int price;
	public Product(int id,String name,int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class StreamTest {
	/* 스트림 연산의 단계
	 * 1. 생성단계
	 * 2. 처리단계
	 * 3. 종말단계
	 */
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		System.out.println("입력데이터 =" + numbers);
		List<Integer> result =
				numbers.stream()
				.filter(n -> {
					return n%2 == 0;
				})
				.map(n -> {
					return n*n;
				})
				.collect(toList());
		System.out.println("실행결과 ="+result);
		
		
		System.out.println();
		List<String> words = Arrays.asList("Java","Sream","Library");
		System.out.println("입력데이터 ="+words);
		List<Integer> resultWord =
				words.stream()
				.map(String::length) //길이
				.collect(toList());
		System.out.println("실행결과 ="+resultWord);
		
		
		System.out.println();
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "노트북", 100));
		list.add(new Product(2, "TV", 320));
		list.add(new Product(3, "세탁기", 250));
		list.add(new Product(4, "공기청정기", 500));
		
		List<String> resultProduct =
				list.stream()
				.filter(n -> n.price>300)
				.map(n->n.name)
				.collect(toList());
		System.out.println("300만원이상인 가전제품 = "+resultProduct);
	}
}
