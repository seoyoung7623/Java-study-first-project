package �޼ҵ�����;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

class Calculator {
	public static int add(int a, int b) {
		return a+b;
	}
}

public class MethodReferences {
	public static void main(String[] args) {
		//���ٽ� �޼ҵ� ȣ��
//		List list = new List();
		ArrayList<String> lst = new ArrayList<>();
		lst.add("Java");
		lst.add("python");
		lst.add("c");
		
		lst.forEach(s-> System.out.println(s));
		//���ٽ��� �ϴ����� println()�� ȣ���ϴ� ��
		//ȣ��Ǵ� �޼ҵ常 �������� ������? -> �޼ҵ� ����
		//System.out�ȿ� �ִ� �޼ҵ� println()�� ������.
		lst.forEach(System.out::println);
		
		//�޼ҵ� ������ ����
		//1. �����޼ҵ� ����
//		lst.forEach(s -> String.capitalize(s));
		
		//���� �޼ҵ� ������ ������ �����ؾ��Ѵٸ� <�Լ����������̽�>�� ����ؾ��Ѵ�.
		//<�Լ����������̽�>��, 1���� �߻�޼ҵ带 ���� �������̽�(default, static�޼ҵ�� �������)
		//���ٽ� �ܺ��� �޼ҵ带 ȣ��
		
		BiFunction<Integer, Integer, Integer> obj = Calculator::add; //�޼ҵ� ����
		int result = obj.apply(10,20); //�޼���
		
		System.out.println("�־��� ���� ����: "+ result);
		
		//2. Ư����ü�� �ν��Ͻ� �޼ҵ� ����
		//���ٽĿ��� �����Ǵ� �Ű������� �޼ҵ带 ȣ�� (obj, args) -> obj.instanceMethod(args)
		
		//3. Ư�������� �ν��Ͻ� �޼ҵ� ����
		String[] Array = {"kim","park","lee","ana"};
		Arrays.sort(Array, String::compareToIgnoreCase);
		for(String a:Array) {
			System.out.println(a);
		}
		
	}
	
}
