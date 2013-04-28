package com.example.bakatest;


/**
 * Towers of Hanoi
 * Pole are labeled 1, 2,3
 * Each disk is also labeled
 * @author Lars Vogel
 *
 */

public class TowersOfHanoi {
  public static double move(int n, int startPole, int endPole) {
	  long startTime = System.nanoTime();
    if (n== 0){
      return (System.nanoTime()-startTime)*1.0e-6; 
    }
    int intermediatePole = 6 - startPole - endPole;
    move(n-1, startPole, intermediatePole);
    System.out.println("Move " +n + " from " + startPole + " to " +endPole);
    move(n-1, intermediatePole, endPole);
    return (System.nanoTime()-startTime)*1.0e-6;
  }
  
  public static void main(String[] args) {
    move(100, 1, 6);
  }

  
} 
