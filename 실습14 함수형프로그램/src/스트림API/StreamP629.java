package ½ºÆ®¸²API;

import java.util.ArrayList;
import static java.util.stream.Collectors.toList;
import java.util.Comparator;
import java.util.List;

public class StreamP629 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 28, 3.7));
		list.add(new Student(3, 20, 3.1));
		list.add(new Student(6, 26, 3.9));
		list.add(new Student(7, 21, 2.9));
		list.add(new Student(10, 20, 3.3));
		
		List<Integer> result =
				list.stream()
				.filter(s -> s.getAge() <25)
				.sorted(Comparator.comparing(Student::getGpa).reversed())
				.map(Student::getId)
				.collect(toList());
		
		result.forEach(System.out::println);
	}
}
