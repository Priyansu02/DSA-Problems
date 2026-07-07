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
    long min2=Long.MAX_VALUE;
    int min;
    public int findSecondMinimumValue(TreeNode root) {
       min=root.val;
        dfs(root);

        return min2==Long.MAX_VALUE? -1 :(int)min2;
    }

    public void dfs(TreeNode root){
        if(root == null)return;

        if(root.val > min){
            min2=Math.min(min2,root.val);
        }else if(root.val == min){
            dfs(root.left);
            dfs(root.right);
        }

    }
}