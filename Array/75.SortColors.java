/*Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
*/


//Method: count the number of each color, then from 0 to num.length, assign each number.

class Solution {
    public void sortColors(int[] nums) {
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++){
        	if (nums[i] == 0) num0 += 1;
        	if (nums[i] == 1) num1 += 1;
        	if (nums[i] == 2) num2 += 1;
        }
        for (int i = 0; i < num0; i++){
        	nums[i] = 0;
        }
        for (int i = num0; i < num0 + num1; i++){
        	nums[i] = 1;
        }
        for (int i = num0 + num1; i < num0 + num1 + num2; i++){
        	nums[i] = 2;
        }
    }
}