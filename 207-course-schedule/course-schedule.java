class Solution {
    public boolean canFinish(int n, int[][] pre) {
        int indegree[] = new int[n];

        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

        for(int i=0;i< n ;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<pre.length;i++){
            int a=pre[i][0];
            int b=pre[i][1];

            adj.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<n;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int count=0;
        while(!q.isEmpty()){
            int curr=q.remove();
            count++;

            for(int i=0;i<adj.get(curr).size();i++){
                indegree[adj.get(curr).get(i)]--;

                if(indegree[adj.get(curr).get(i)] == 0){
                    q.add(adj.get(curr).get(i));
                }
            }
        }

        return  count == n;
    }
}