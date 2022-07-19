package ��Ʈ��API;

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
	/* ��Ʈ�� ������ �ܰ�
	 * 1. �����ܰ�
	 * 2. ó���ܰ�
	 * 3. �����ܰ�
	 */
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		System.out.println("�Էµ����� =" + numbers);
		List<Integer> result =
				numbers.stream()
				.filter(n -> {
					return n%2 == 0;
				})
				.map(n -> {
					return n*n;
				})
				.collect(toList());
		System.out.println("������ ="+result);
		
		
		System.out.println();
		List<String> words = Arrays.asList("Java","Sream","Library");
		System.out.println("�Էµ����� ="+words);
		List<Integer> resultWord =
				words.stream()
				.map(String::length) //����
				.collect(toList());
		System.out.println("������ ="+resultWord);
		
		
		System.out.println();
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "��Ʈ��", 100));
		list.add(new Product(2, "TV", 320));
		list.add(new Product(3, "��Ź��", 250));
		list.add(new Product(4, "����û����", 500));
		
		List<String> resultProduct =
				list.stream()
				.filter(n -> n.price>300)
				.map(n->n.name)
				.collect(toList());
		System.out.println("300�����̻��� ������ǰ = "+resultProduct);
	}
}
