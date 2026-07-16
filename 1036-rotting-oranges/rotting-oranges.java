class Solution {
    class pair{
        int row,col,time;

        pair(int r, int c, int t){
            row=r;
            col=c;
            time=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Queue<pair> q= new LinkedList<>();

        int freshcnt=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                }
                if(grid[i][j]==1){
                    freshcnt++;
                }
            }
        }

        int drow[]={-1,1,0,0};
        int dcol[]={0,0,-1,1};

        int rc=0;
        int maxT=0;

        while(!q.isEmpty()){
            pair curr=q.remove();
            int row=curr.row;
            int col=curr.col;
            int time=curr.time;

            maxT=Math.max(maxT,time);

            for(int i=0;i<4;i++){
                int newr=row+drow[i];
                int newc=col+dcol[i];

                if(newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc]==1){
                    grid[newr][newc]=2;
                    q.add(new pair(newr,newc,time+1));
                    rc++;
                }
            }
        }
        return rc==freshcnt ?maxT:-1;
    }
}