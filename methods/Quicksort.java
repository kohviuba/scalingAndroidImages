package com.example.bakatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quicksort {
	private static int[] numbers;
	private static int number;
	private static long startTime;

	 public static void main(String[] args)  {
		startTime = System.nanoTime();
		int[] values = new int[999999];
		Random r = new Random();
		for (int i = 0; i < values.length; i++) {
			values[i] = r.nextInt(100000000);
		}
						
		// Check for empty or null array
		if (values == null || values.length == 0) {
		 return (System.nanoTime( ) - startTime)*1.0e-6;
		}
		numbers = values;
		number = values.length;
		quicksort(0, number - 1);
		System.out.println("Time "+ (System.nanoTime( ) - startTime)*1.0e-6);
	}

	private static void quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high - low) / 2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
		
	}

	private static void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
