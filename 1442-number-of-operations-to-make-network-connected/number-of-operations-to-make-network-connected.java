class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1)return -1;

        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();

        for(int i=0;i<n ;i++)adj.add(new ArrayList<>());

        for (int[] c : connections) {
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(c[0]);
        }

        int component=0;
        boolean vis[]= new boolean[n];

        for(int i=0;i< n;i++){
            if(!vis[i]){
                component++;
                dfs(i,adj,vis);
            }
        }

        return component-1;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (!visited[nei]) dfs(nei, adj, visited);
        }
    }
}