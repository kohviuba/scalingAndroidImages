package com.example.bakatest;

public class MultiplyMatrices {
	
	public static double multiply(){
		//16x16
		int[][] matrix1 = {
				  {3, 67, 3, 4, 3, 0, 3, 0, 9, 3, 124, 1252, 567, 342, 125, 1251},
				  {0, 3, 0, 3, 10, 3, 0, 3, 21, 1, 124, 124, 124, 124, 124,124,},
				  {3, 0, 3, 0, 3, 450, 3, 0, 124, 12, 12, 1232,124,124,523,6346},
				  {0, 3, 0, 3, 0, 3, 0, 3, 123, 12, 512, 124, 12421, 124, 1246, 3424, 3},
				  {3, 0, 3, 20, 3, 0, 3, 0, 4, 2, 4, 6, 7, 3, 2, 5},
				  {3, 3, 60, 3, 0, 3, 0, 3, 4, 2, 4, 6, 7, 3, 2, 5},
				  {3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0},
				  {3, 3, 0, 3, 900, 3, 0, 3, 3, 0, 3, 0, 3, 0, 3, 0},
				  {3, 67, 3, 4, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0},
				  {0, 3, 0, 3, 10, 3, 0, 3, 3, 0, 3, 0, 3, 0, 3, 0},
				  {3, 0, 3, 0, 3, 450, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0},
				  {0, 3, 0, 3, 0, 3, 0, 3, 3, 0, 3, 0, 3, 0, 3, 0},
				  {3, 0, 3, 20, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0},
				  {3, 3, 60, 3, 0, 3, 0, 3, 3, 0, 3, 0, 3, 0, 3, 0},
				  {3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0},
				  {3, 3, 0, 3, 900, 3, 0, 3, 3, 0, 3, 0, 3, 0, 3, 0}
				};
		//16x16
		int[][] matrix2 = {
				  {1, 0, 0, 0, 56, 0, 0, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {0, 1, 0, 234, 0, 0, 0, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {1, 0, 1, 0, 643, 0, 0, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {1, 0, 0, 0, 1, 2341, 0, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {1, 0, 0, 0, 0, 1241, 1, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 56, 0, 0, 0},
				  {1, 0, 0, 0, 56, 0, 0, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {0, 1, 0, 234, 0, 0, 0, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {1, 0, 1, 0, 643, 0, 0, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {1, 0, 0, 0, 1, 2341, 0, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {1, 0, 0, 0, 0, 1241, 1, 0, 1, 0, 0, 0, 56, 0, 0, 0},
				  {0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 56, 0, 0, 0}
		};
		
		
		int m1rows = matrix1.length;
		int m1cols = matrix1[0].length;
		int m2rows = matrix2.length;
		int m2cols = matrix2[0].length;
		if (m1cols != m2rows)
			throw new IllegalArgumentException("matrices don't match: " + m1cols + " != " + m2rows);
		int[][] result = new int[m1rows][m2cols];
		
		long startTimeNano = System.nanoTime( );
				
		// multiply
		for (int i=0; i<m1rows; i++)
			for (int j=0; j<m2cols; j++)
				for (int k=0; k<m1cols; k++)
				result[i][j] += matrix1[i][k] * matrix2[k][j];

		
		//in seconds. However, more reasonable to talk in milliseconds. Thus, changed to -6
		//double taskTimeNano = (System.nanoTime() - startTimeNano) * 1.0e-9;
		double taskTimeNano = (System.nanoTime() - startTimeNano) * 1.0e-6;
		
		//Show final matrix
		for (int i=0; i<m1rows; i++) {
			System.out.print("{");
			for (int j=0; j<m2cols; j++)
				System.out.print(" " + result[i][j] + ",");
			System.out.println("},");
		}
		return taskTimeNano;
	}

}