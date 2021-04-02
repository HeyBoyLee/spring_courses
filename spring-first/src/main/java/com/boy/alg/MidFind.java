package com.boy.alg;

/**
 * @Author: lihuifeng6
 * @Date: 2020/12/22 9:13
 */

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给定两个大小为m和n的有序数组nums1和nums2.
 * 请找出这个两个有序数组的中位数. 要求算法复杂度为O(log(m+n))
 */
public class MidFind {
    private void findMedianSortArrays(int num1[], int num2[]){

    }
    public static void main(String[] args) {
        System.out.println(String.format("%d%d%d", 1,-1,0));
        Set<Integer> s1 = new TreeSet<>();
        Set<Integer> s2 = new TreeSet<>();
        s1.add(0); s1.add(1); s1.add(-1);
        s2.add(-1); s2.add(0); s2.add(1);
        System.out.println(true ^ true);
        System.out.println((4&1)!=0);
        System.out.println(s1.equals(s2));
    }
}
