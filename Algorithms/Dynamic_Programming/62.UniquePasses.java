/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

S * * * * * *
* * * * * * *
* * * * * * F

Note: m and n will be at most 100.

Example 1:
Input: m = 3, n = 2
Output: 3

Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:
Input: m = 7, n = 3
Output: 28
*/

/*Method1: the core is to apply the Combination Equation: C(m,n) = m!/[(m-n)!*n] = m * (m-1) * (m-2) * ... (m-n+1)/n!
There's Math.min(m, n) - 1 time of multiplication; where the factorial range from 1 to Math.min(m, n) - 1; the Numerator
range from m + n - 2 - (Math.min(m, n) - 1) + 1 to m + n - 2
*/


class Solution {
    public int uniquePaths(int m, int n) {
        int multiTimes = Math.min(m, n) - 1;
        long res = 1;
        int startNumerator = m + n - 2 - (Math.min(m, n) - 1) + 1;
        int factorial = 1;
        for (int i = 1; i <= multiTimes; i++, factorial++, startNumerator++){
            res = res * startMultiplier / factorial;
        }
        return (int) res;
    }
}

/*Method2: 1-d Matrix(not quite understand)*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[] res = new int[n];
        res[0] = 1;
        for (int i =0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (j > 0){
                    res[j] += res[j-1];
                }
            }
        }
        return res[n-1];
    }
}