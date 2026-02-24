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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>li = new ArrayList<>();

        rightView( root,li, 0 );
        return li;
    }

    public void rightView(TreeNode root,List<Integer>li,int level){
        if(root == null){
            return;
        }

        if(level == li.size()){
            li.add(root.val);
        }

        rightView( root.right,li, level+1 );

        rightView( root.left,li, level+1 );
    } 
}