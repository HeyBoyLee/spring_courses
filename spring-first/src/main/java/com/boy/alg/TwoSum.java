package com.boy.alg;

import java.util.*;

/**
 * @Author: lihuifeng6
 * @Date: 2021/4/2 8:54
 *
 * 两数之和 ， 思路： 和去重的逻辑是一样的。
 * Collections.sort
 * Arrays.sort
 * Arrays.asList
 * Lists.newArrayList jdk9
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        int target = 7;
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target -nums[i])){
                List l = Arrays.asList(i, map.get(target- nums[i]));
                Collections.sort(l);
                //Arrays.sort(l);
                result.add(l);
            }else{
                map.put(nums[i], i);
            }
        }
        for(List e: result){
            System.out.println(e);
        }
    }
}
