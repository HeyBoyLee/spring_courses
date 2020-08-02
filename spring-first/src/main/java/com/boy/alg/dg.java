package com.boy.alg;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class dg {
    private static ArrayList<Stack<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Integer[] nums={100, 50, 20, 10, 5, 2, 1};
        Integer[] nums1={1, 2, 5, 10, 20, 50, 100};
        Stack<Integer> s = new Stack<>();
        f(s, nums1, 20);
    }

    public static void f(Stack<Integer>s , Integer[] nums, int target){
        if(getSum(s) == target){
            //Collections.sort(s);
            //printStack(s);
            Stack<Integer> t = cloneStack(s);
            Collections.sort(t);
            if(list.isEmpty()){
                list.add(t);
                printStack(t);
            }else{
                if(!list.contains(t)){
                    list.add(t);
                    printStack(t);
                }
            }
            return;
        }
        if(getSum(s) > target){
            return;
        }
        for(int i = 0; i< nums.length; i++){
            s.add(nums[i]);
            f(s, nums, target);
            s.pop();
        }
    }

    public static int getSum(Stack<Integer> s){
        int r = 0;
        for(int x : s){
            r += x;
        }
        return r;
    }

    public static void printStack(Stack<Integer> s){
        for(int x: s){
            System.out.print(x+",");
        }
        System.out.println();
    }

    public static Stack<Integer> cloneStack(Stack<Integer> s){
        Stack<Integer> x = new Stack<>();
        x.addAll(s);
        return x;
    }
}
