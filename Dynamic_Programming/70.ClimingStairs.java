/*You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.

Example 1:
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step*/


//Method: Like a Fibonacci sequence 1 2 3 5 8 ....


class Solution {
    
//Recursive method
    public int climbStairs1(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    
//Iterative method    
    public int climbStairs2(int n) {
        if (n <= 1) return 1;
        int add1 = 1;
        int add2 = 1;
        int res = 0;
        for (int i = 1; i < n; i++){
            res = add1 + add2;
            add1 = add2;
            add2 = res;
        }
    return res;
    }  
}