package com.self.learning.java8;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {
	public static void main(String args[]) {
		List<Integer> myList = Arrays.asList(3, 5, 10, 13, 35, 234, 500);
		int result = 0;
		for (int i : myList) {
			if (i % 5 == 0) {
				result += i;
			}
		}
		System.out.println(result);

		System.out.println(myList.stream().filter(i -> i % 5 == 0).reduce(0, (c, e) -> c + e));
	}
}
