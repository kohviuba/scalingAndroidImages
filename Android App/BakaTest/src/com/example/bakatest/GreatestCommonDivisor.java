package com.example.bakatest;

/**
 * Calculates the greatest common divisor for two numbers.
 * <p>
 * Based on the fact that the gcd from p and q is the same as the gcd from p and
 * p % q in case p is larger then q
 * 
 * @author Lars Vogel
 * 
 */

public class GreatestCommonDivisor {
  public static int gcd(int p, int q) {
    if (q == 0) {
      return p;
    }
    return gcd(q, p % q);
  }

  // Test enable assert check via -ea as a VM argument

//  public static void main(String[] args) {
  public static double calculateGCD() {
	  long startTime = System.nanoTime();
	  gcd(1345262, 21532461);
	  gcd(21412,1245);
	  gcd(135125,125616);
	  gcd(215135,125666);
//	  System.out.print("Time " + (System.nanoTime()-startTime)*1.0e-6);
	  return (System.nanoTime()-startTime)*1.0e-6;
  }
} 