/*Given a binary tree, return the preorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]*/





/*Recursive method*/
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res,root);
        return res;
    }
    public static void helper (List<Integer> res, TreeNode root){
        if(root == null) return;
        res.add(root.val);
        helper(res,root.left);
        helper(res,root.right);
    }
}

/*Iterative method*/
class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
	List<Integer> res = new ArrayList<Integer>();
	//base case
	if(root==null)
	return res;
	Stack<TreeNode> nodestack = new Stack<TreeNode>();
	nodestack.push(root);
	while(!nodestack.isEmpty()){
	TreeNode temp = nodestack.pop();
	//add the node's value to the list
	res.add(temp.val);

	//push the right node to the stack
	if(temp.right!=null)
		nodestack.push(temp.right);
	//push the left node to stack
	if(temp.left!=null)
		nodestack.push(temp.left);
	}
	return res;
	}
}