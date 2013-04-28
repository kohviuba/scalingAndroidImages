package com.example.bakatest;

public class BubbleSort {

	public static double sort() {
		int[] num = { 1, 2, 68, 96, 35, 78, 90, 235, 893, 35, 63, 468, 342, 64,
				11, 1567, 12314, 15137, 8906, 125, 123, 523, 16341, 642, 15137,
				8906, 125, 123, 523, 16341, 642 };
		long startTime = System.nanoTime( );
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
		
		return (System.nanoTime( ) - startTime)*1.0e-6;
	}
}
