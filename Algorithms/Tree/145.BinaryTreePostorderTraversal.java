/*Given a binary tree, return the postorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Rcursive method
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res,root);
        return res;
    }
    
    public static void helper (List<Integer> res, TreeNode root){
        if(root == null) return;
        helper(res,root.left);
        helper(res,root.right);
        res.add(root.val);
    }
}

//Iterative method
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode lastVisit = root;
        while(cur != null || !stack.isEmpty()){
        	while(cur != null){
        		stack.push(cur);
        		cur = cur.left;
        	}
        	cur = stack.peek();
        	if (cur.right == null || cur.right == lastVisit){
        		res.add(cur.val);
        		stack.pop();
        		lastVisit = cur;
        		cur = null;
        	}
        	else cur = cur.right;
        }
        return res;
    }
}
