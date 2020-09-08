package com.boy.alg;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by heyboy on 2020-08-02.
 */

class Solution {
  public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> mapAB = new HashMap<>();
    int res = 0;

    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        int key = A[i] + B[j];
        if (mapAB.containsKey(key))
          mapAB.put(key, mapAB.get(key) + 1);
        else mapAB.put(key, 1);
      }
    }

    for (int i = 0; i < C.length; i++) {
      for (int j = 0; j < D.length; j++) {
        int key = C[i] + D[j];
        if (mapAB.containsKey(0 - key)) {
          res += mapAB.get(0 - key);
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
//    A = [ 1, 2]
//    B = [-2,-1]
//    C = [-1, 2]
//    D = [ 0, 2]
    int[] A = {1,2};
    int[] B = {-2, -1};
    int[] C = {-1, 2};
    int[] D = {0,2};

    System.out.println(fourSumCount(A, B, C, D));
  }
}
