class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;

        if(grid[0][0]==1 || grid[n-1][n-1]==1)return -1;

        if(n==1) return 1;

        int [][]dirs={
            {-1,-1}, {-1,0},{-1,1},
            {0, -1},          {0, 1},   
            {1, -1},  {1, 0}, {1, 1}
        };

        Queue<int []> q= new LinkedList<>();
        boolean [][] visited=new boolean [n][n];

        q.add(new int[]{0,0,1});
        visited[0][0]=true;

        while(!q.isEmpty()){
            int []curr=q.remove();
            int r=curr[0],c=curr[1], dist=curr[2];

            if(r==n-1 && c==n-1) return dist;

            for (int i = 0; i < dirs.length; i++) {
            int nr = r + dirs[i][0]; // New row
             int nc = c + dirs[i][1]; 

             if(nr>=0 && nc>=0 && nr <n && nc<n &&
              grid[nr][nc]==0 && !visited[nr][nc]){

                visited[nr][nc]=true;
                q.add(new int[]{nr,nc,dist+1});
             }
            }
        }
        return -1;
    }
}