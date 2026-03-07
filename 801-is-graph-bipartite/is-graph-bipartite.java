class Solution {
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        int []color= new int[n];

        for(int node=0; node< n;node++){
            if(color[node] != 0){
                continue;
            }

            Queue<Integer> q= new LinkedList<>();
            q.add(node);
            color[node]= 1;

            while(!q.isEmpty()){
                int curr=q.remove();

                for(int ne: graph[curr]){
                    if(color[ne]==0){
                        color[ne] =-color[curr];
                        q.add(ne);
                    }else if(color[ne] ==color[curr]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}