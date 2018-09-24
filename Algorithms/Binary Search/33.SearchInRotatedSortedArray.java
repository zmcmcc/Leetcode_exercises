/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

//Your algorithm's runtime complexity must be in the order of O(log n).

class Solution {
    public int search(int[] nums, int target) {
        /*
        如果target比A[mid]值要小
              如果A[mid]右边有序（A[mid]<A[high])
                    那么target肯定不在右边（target比右边的都得小），在左边找
              如果A[mid]左边有序
                    那么比较target和A[low]，如果target比A[low]还要小，证明target不在这一区，去右边找；反之，左边找。
        如果target比A[mid]值要大
             如果A[mid]左边有序（A[mid]>A[low]）
                   那么target肯定不在左边（target比左边的都得大），在右边找 
             如果A[mid]右边有序
                   那么比较target和A[high]，如果target比A[high]还要大，证明target不在这一区，去左边找；反之，右边找。
        */
        /*
        如果左边有序 left < mid:
            if left < target <= mid: 肯定在左边
            else 右边
        else右边有序：
            if mid < target <= right: 肯定在右边
            else 左边
        */
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1, mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] < nums[mid]) { // 左侧有序
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // 右侧有序
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}