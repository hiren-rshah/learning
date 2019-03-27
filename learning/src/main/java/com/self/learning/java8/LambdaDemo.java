package com.self.learning.java8;

interface A{
	public void show();
}

/*class Aimpl implements A {
	public void show() {
		System.out.println("Hello from Implementation Class");
	}
}*/
public class LambdaDemo {

	public static void main(String[] args) {
		A obj = new A() {
			public void show() {
				System.out.println("Hello from Inner Class");
			}
		};
		obj.show();
		
		A obj2 = () -> System.out.println("Hello from Lambda");
		obj2.show();
	}

}
