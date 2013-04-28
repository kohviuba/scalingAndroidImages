package com.example.bakatest;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public static double primeFactors() {
		long startTime = System.nanoTime( );
		int[] numbers = { 453463, 47895, 2345, 3873, 3452, 234508, 1231551, 12453151, 1253562621, 125236751, 12451511, 1241512 };
		List<Integer> factors = new ArrayList<Integer>();

		for (Integer num : numbers) {
			for (int i = 2; i <= num; i++) {
				while (num % i == 0) {
					factors.add(i);
					num /= i;
				}
			}
		}
		
		for (Integer integer : factors) {
			System.out.println(integer);
		}
		return (System.nanoTime() - startTime)*1.0e-6;
	}
}
