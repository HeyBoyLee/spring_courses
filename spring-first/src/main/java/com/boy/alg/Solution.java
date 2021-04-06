package com.boy.alg;

/**
 * @Author: lihuifeng6
 * @Date: 2021/4/6 8:59
 * 正则匹配算法
 */


class Solution {
    // 状态空间
    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return match(0, 0, text, pattern);
    }

    public boolean match(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean curMatch = (i < text.length() &&
                (pattern.charAt(j) == text.charAt(i) ||
                    pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (match(i, j+2, text, pattern) ||
                    curMatch && match(i+1, j, text, pattern));
            } else {
                ans = curMatch && match(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("aab", "caa*b"));
        System.out.println(solution);
        boolean x = p(true) && p(false) || p(true);
        System.out.println("x:"+x);
        // || 或运算符前是true, 后面不会运行
        boolean y = p(true) || p(true) && p(true);
        System.out.println("y:"+y);

    }

    /**
     *
     * @param b
     * @return
     */
    public static boolean p(boolean b){
        System.out.println(b);
        return b;
    }

    public static enum Result {
        TRUE, FALSE
    }
}

