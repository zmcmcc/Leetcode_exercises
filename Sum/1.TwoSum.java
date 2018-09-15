/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

/*Method: Use HashMap to store each number and its index. Use HashMap.containsKey() to determine if there's a match. 
And use HashMap.get() to get the indices. */


class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[] {-1,-1};
        int[] indices = new int[] {-1,-1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                indices[0] = map.get(target - nums[i]);
                indices[1] = i;
            }
        map.put(nums[i],i);
        }
    return indices;
    }
}