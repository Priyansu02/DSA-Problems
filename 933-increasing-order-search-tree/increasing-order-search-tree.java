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
    public TreeNode increasingBST(TreeNode root) {
        List <Integer> list= new ArrayList <>();
        dfs(root,list);
        TreeNode ans=new TreeNode();
         Build(list,0,ans);
        return ans.right;
    }

    public void dfs(TreeNode root, List<Integer> list){
        if(root== null){
            return;
        }
        
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
     public TreeNode Build(List<Integer> li,int i,TreeNode ans){
        if(i==li.size()){
            return ans;
        }
        TreeNode newnode=new TreeNode(li.get(i));
        ans.right=newnode;
        Build(li,i+1,ans.right);
        return ans;
    }
}