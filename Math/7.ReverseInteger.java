/*Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321*/

/*Method: use '%' to get each digit of the number.
Remember to consider about the CORNER CASE: the range of int is from -2^32 to 2^32 - 1.*/

class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }
        }
    return (int)res;
    }
}