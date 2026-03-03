class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }

    public void dfs(int [][]m,int i,boolean [] visited){
        for(int j=0;j< m[0].length;j++){
            if(!visited[j] && m[i][j] != 0){
                visited[j]=true;
                dfs(m,j,visited);
            }
        }
    }


    
}