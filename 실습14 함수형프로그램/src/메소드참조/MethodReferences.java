package 메소드참조;

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
		//람다식 메소드 호출
//		List list = new List();
		ArrayList<String> lst = new ArrayList<>();
		lst.add("Java");
		lst.add("python");
		lst.add("c");
		
		lst.forEach(s-> System.out.println(s));
		//람다식이 하는일은 println()을 호출하는 일
		//호출되는 메소드만 보낼수는 없을까? -> 메소드 참조
		//System.out안에 있는 메소드 println()을 참조함.
		lst.forEach(System.out::println);
		
		//메소드 참조의 종류
		//1. 정적메소드 참조
//		lst.forEach(s -> String.capitalize(s));
		
		//만약 메소드 참조에 변수를 저장해야한다면 <함수형인터페이스>를 사용해야한다.
		//<함수형인터페이스>란, 1개의 추상메소드를 갖는 인터페이스(default, static메소드는 상관없음)
		//람다식 외부의 메소드를 호출
		
		BiFunction<Integer, Integer, Integer> obj = Calculator::add; //메소드 참조
		int result = obj.apply(10,20); //메서드
		
		System.out.println("주어진 수의 덧셈: "+ result);
		
		//2. 특정객체의 인스턴스 메소드 참조
		//람다식에서 제공되는 매개변수의 메소드를 호출 (obj, args) -> obj.instanceMethod(args)
		
		//3. 특정유형의 인스턴스 메소드 참조
		String[] Array = {"kim","park","lee","ana"};
		Arrays.sort(Array, String::compareToIgnoreCase);
		for(String a:Array) {
			System.out.println(a);
		}
		
	}
	
}
