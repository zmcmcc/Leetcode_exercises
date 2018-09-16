/*Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
Input: [1,2,3]
Output: [1,2,4]

Example 2:
Input: [4,3,2,9]
Output: [4,3,3,0]

Example 3:
Input: [9,9,9,9]
Output: [1,0,0,0,0]
*/






class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            if (digits[i] < 9){
                digits[i] += 1;
                return digits;
            }
            else{
                digits[i] = 0;
            }
        }
        //If all of the digits are 9
        int newRes[] = new int[digits.length + 1];
        newRes[0] = 1;
        return newRes;
    }
}