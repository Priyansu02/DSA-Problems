class Solution {
    public int findCircleNum(int[][] isConnected) {
       int n=isConnected.length;
       boolean vis[]=new boolean[n];
        int count=0;

        for(int i=0;i<n;i++){
            
            if(!vis[i]){
                count++;
                dfs(isConnected,i,vis);
            }
            
        }

       return count;
    }

    public void dfs(int c[][],int i,boolean vis[]){
        vis[i]=true;

        for(int j=0;j<c[0].length; j++){
            if(!vis[j] && c[i][j] != 0){
                
                dfs(c,j,vis);
            }
        }
    }


    
}