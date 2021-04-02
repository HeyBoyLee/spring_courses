package com.boy.alg;

import java.util.List;

/**
 * @Author: lihuifeng6
 * @Date: 2021/4/2 9:20
 *
 * a的b次方
 */
public class APowerB {
    public static void main(String[] args) {
        System.out.println(f(3, 5));
    }

    public static int f(int a, int b){
        int c = b/2;
        int m = b%2;
        int t = a;
        for(int i = 0; i<c; i++){
            t = t*t;
        }
        if(m>0){
            t = t *a;
        }
        return t;
    }
}
