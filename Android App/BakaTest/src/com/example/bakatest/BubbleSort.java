package com.example.bakatest;

import java.util.Random;

public class BubbleSort {

	public static double sort() {
		long startTime = System.nanoTime();
		int[] num = new int[9999];
		Random r = new Random();
		for (int i = 0; i < num.length; i++) {
			num[i] = r.nextInt(1000000);
		}
		int j;
		boolean flag = true; // set flag to true to begin first pass
		int temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			for (j = 0; j < num.length - 1; j++) {
				if (num[j] < num[j + 1]) // change to > for ascending sort
				{
					temp = num[j]; // swap elements
					num[j] = num[j + 1];
					num[j + 1] = temp;
					flag = true; // shows a swap occurred
				}
			}
		}
		System.out.println((System.nanoTime( ) - startTime)*1.0e-6);
		return (System.nanoTime( ) - startTime)*1.0e-6;
	}
}
