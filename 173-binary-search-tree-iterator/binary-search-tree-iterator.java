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
class BSTIterator {
    List<Integer> list;
    int idx=-1;
    public BSTIterator(TreeNode root) {
        list=new ArrayList<>();
        inordertraversal(root);
    }
    public void inordertraversal(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inordertraversal(root.left);
        list.add(root.val);
        inordertraversal(root.right);
    }
    
    public int next() {
        idx=idx+1;
        return list.get(idx);
    }
    
    public boolean hasNext() {
        return idx < list.size()-1;

    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */