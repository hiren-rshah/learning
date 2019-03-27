package com.self.learning.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ForEachDemo {
	public static void main(String args[]) {
		List<Integer> myList = Arrays.asList(5,8,9,1,4);
		
		for(Integer i : myList) {
			System.out.println("Enhenced ForLoop : " + i);
		}
		Collections.sort(myList, new compareInt());
		for(Integer i : myList) {
			System.out.println("Enhenced Sorted ForLoop : " + i);
		}
		
		myList.forEach(i -> System.out.println("forEach : "+ i));
	}
}

class compareInt implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}

}
