package ��Ʈ��API;

import java.util.Arrays;
import static java.util.stream.Collectors.toList; //�߰�!
import java.util.List;

public class StreamEx {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Kim","Park","Lee","Choi","Chee");
		
		List<String> sublist = list.stream()
				.filter(s -> s.startsWith("C"))
				.sorted()
				.collect(toList());
		
		System.out.println(sublist);
	}
}
