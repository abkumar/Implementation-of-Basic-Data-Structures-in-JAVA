/**
 *
 */
package com.ds.Pocket.Math;

/**
 * Created by Abhishek Kumar
 * 5:51:52 PM Aug 14, 2012
 *
 * @Bangalore Pocket questions
 */
public class LargestPrimeFactor {

  public static int largestPrimeFactor(long number) {
    int i;
    for (i = 2; i <= number; i++) {
      if (number % i == 0) {
        number /= i;
        i--;
      }
    }
    return i;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
}
