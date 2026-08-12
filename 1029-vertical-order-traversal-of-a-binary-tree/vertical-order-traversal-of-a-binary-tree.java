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

    class Pair {
        TreeNode t;
        int hd;
        int level;

        Pair(TreeNode t, int hd, int level) {
            this.t = t;
            this.hd = hd;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> al = new ArrayList<>();

        if (root == null)
            return al;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        // HD → List of nodes having that HD
        Map<Integer, List<Pair>> hm = new TreeMap<>();

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Pair p = q.poll();

                if (!hm.containsKey(p.hd)) {
                    hm.put(p.hd, new ArrayList<>());
                }

                hm.get(p.hd).add(p);

                if (p.t.left != null) {
                    q.add(new Pair(
                        p.t.left,
                        p.hd - 1,
                        p.level + 1
                    ));
                }

                if (p.t.right != null) {
                    q.add(new Pair(
                        p.t.right,
                        p.hd + 1,
                        p.level + 1
                    ));
                }
            }
        }

        for (List<Pair> list : hm.values()) {

            Collections.sort(list, (a, b) -> {

                if (a.level == b.level)
                    return a.t.val - b.t.val;

                return a.level - b.level;
            });

            List<Integer> temp = new ArrayList<>();

            for (Pair p : list) {
                temp.add(p.t.val);
            }

            al.add(temp);
        }

        return al;
    }
}