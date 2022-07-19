package ½ºÆ®¸²API;

public class Student {
	private int id,age;
	private double gpa;
	
	public Student(int id,int age,double d) {
		// TODO Auto-generated constructor stub
		this.age = age;
		this.id = id;
		this.gpa = d;
	}
	
	public int getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public double getGpa() {
		return gpa;
	}
}
