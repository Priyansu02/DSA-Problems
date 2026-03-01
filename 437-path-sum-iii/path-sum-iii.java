/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return pathSumFromRoot(root, targetSum) 
       + pathSum(root.left, targetSum) 
       + pathSum(root.right, targetSum);

    }

    private static int pathSumFromRoot(TreeNode root, long sum){
    if(root == null) return 0;
    
    int res = 0;
    if(root.val == sum) {
        res += 1;
    }
    
    res += pathSumFromRoot(root.left, sum - root.val);
    res += pathSumFromRoot(root.right, sum - root.val);
    
    return res;
}

    
}