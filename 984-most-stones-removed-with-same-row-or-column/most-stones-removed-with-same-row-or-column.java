class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0]){
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
                if(stones[i][1]==stones[j][1]){
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
        int c=0;
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,map,vis);
                c++;
            }
        }  
        return n-c;
    }
    public static void dfs(int i,HashMap<Integer,ArrayList<Integer>>map,boolean []vis){
        vis[i]=true;
        for(int x:map.get(i)){
            if(!vis[x]){
                dfs(x,map,vis);
            }
        }
    }
}