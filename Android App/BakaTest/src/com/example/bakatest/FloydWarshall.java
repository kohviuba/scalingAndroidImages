package com.example.bakatest;

public class FloydWarshall {

	// public static void main(String[] args) {
	public static double calculatePath() {
		long startTime = System.nanoTime();
		// Tests out algorithm with graph shown in class.
		int[][] m = { { 0, 124, 2, 125, 51, 166132, 125, 12512, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 75, 5235, 235, 2352, 325, 132, 15, 12, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 2, 12, 47 ,15, 5, 162, 25, 12, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 25, 6324, 14, 225, 231,61, 15, 324512, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 0, 12, 2, 12, 1, 166, 15, 2512, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 0, 624, 62, 1625, 561, 16662, 612, 652, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 5, 1254, 52, 1525, 551, 1532, 1255, 12512, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 0, 124, 2, 125, 51, 166132, 125, 12512, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 0, 124, 2, 125, 51, 166132, 125, 12512, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 75, 5235, 235, 2352, 325, 132, 15, 12, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 2, 12, 47 ,15, 5, 162, 25, 12, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 25, 6324, 14, 225, 231,61, 15, 324512, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 0, 12, 2, 12, 1, 166, 15, 2512, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 0, 624, 62, 1625, 561, 16662, 612, 652, 0, 124, 2, 125, 51, 166132, 125, 12512 },
					  { 5, 1254, 52, 1525, 551, 1532, 1255, 12512, 5, 1254, 52, 1525, 551, 1532, 1255, 12512 },
					  { 0, 124, 2, 125, 51, 166132, 125, 12512, 5, 1254, 52, 1525, 551, 1532, 1255, 12512 }
		};

		int[][] shortpath;
		int[][] path = new int[16][16];

		// Initialize with the previous vertex for each edge. -1 indicates
		// no such vertex.
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (m[i][j] == 100000) {
					path[i][j] = -1;
				} else {
					path[i][j] = i;
				}
			}
		}
		// This means that we don't have to go anywhere to go from i to i.
		for (int i = 0; i < 16; i++) {
			path[i][i] = i;
		}

		shortpath = shortestpath(m, path);

		// Prints out shortest distances.
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				System.out.print(shortpath[i][j] + " ");
				System.out.println();
			}
		}
		return (System.nanoTime() - startTime) * 1.0e-6;
	}

	public static int[][] shortestpath(int[][] adj, int[][] path) {

		int n = adj.length;
		int[][] ans = new int[n][n];

		// Implement algorithm on a copy matrix so that the adjacency isn't
		// destroyed.
		copy(ans, adj);

		// Compute successively better paths through vertex k.
		for (int k = 0; k < n; k++) {

			// Do so between each possible pair of points.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					if (ans[i][k] + ans[k][j] < ans[i][j]) {
						ans[i][j] = ans[i][k] + ans[k][j];
						path[i][j] = path[k][j];
					}
				}
			}
		}

		// Return the shortest path matrix.
		return ans;
	}

	// Copies the contents of array b into array a. Assumes that both a and
	// b are 2D arrays of identical dimensions.
	public static void copy(int[][] a, int[][] b) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				a[i][j] = b[i][j];
		}
	}

	// Returns the smaller of a and b.
	public static int min(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}

}
