package com.boy.alg;

/**
 * Created by heyboy on 2020-08-02.
 */
public class MySqrt {
  public static void main(String[] args) {
    System.out.println(mySqrt(64));
  }

  public static int mySqrt(int x) {
    if (x <= 1) {
      return x;
    }
    int l = 1, h = x;
    while (l <= h) {
      int mid = l + (h - l) / 2;
      int sqrt = x / mid;
      if (sqrt == mid) {
        return mid;
      } else if (mid > sqrt) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return h;
  }
}