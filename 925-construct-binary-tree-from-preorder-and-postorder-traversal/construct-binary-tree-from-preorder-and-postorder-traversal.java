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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> hm= new HashMap<>();

        for(int i=0;  i < postorder.length; i++) {
            hm.put(postorder[i], i);
        }


        return build(preorder, 0, preorder.length - 1, 
                     postorder, 0, postorder.length - 1, 
                     hm);
}

    

    public TreeNode build(int[] preorder,int ps,int pe, int[] postorder,int pos,int poe,    HashMap<Integer,Integer>hm ){

        if(ps > pe || pos > poe)return null;
        
        TreeNode root= new TreeNode(preorder[ps]);

        if(ps == pe)return root;

        int leftrootval=preorder[ps+1];

        int leftidx= hm.get(leftrootval);
        int lsize=leftidx - pos + 1;

        root.left=build(preorder,ps+1,ps+lsize,postorder,pos,leftidx,hm);
        root.right=build(preorder,ps+lsize+1,pe,postorder,leftidx+1,poe-1,hm);

        return root;
    }
}