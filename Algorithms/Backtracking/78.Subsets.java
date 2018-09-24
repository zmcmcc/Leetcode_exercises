/*Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

/*Method: backtracking.(still not very understand)*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    public static void helper( List<List<Integer>> res, List<Integer> temp, int[] nums, int index){
        res.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            helper(res, temp, nums, i + 1);
            temp.remove(temp.size()-1);
        }
    }
}