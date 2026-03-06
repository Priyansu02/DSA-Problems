/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        HashMap<Node, Node> vis= new HashMap<>();
        Node newNode= new Node(node.val);
        vis.put(node, newNode);
        Queue<Node> queue= new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node cur= queue.remove();

            List<Node> newNeighbors= vis.get(cur).neighbors;
            for(Node n: cur.neighbors){
                if (!vis.containsKey(n)) {
                    vis.put(n, new Node(n.val));
                    queue.offer(n);
                }
                newNeighbors.add(vis.get(n));
            }
        }

        return newNode;
    }
}