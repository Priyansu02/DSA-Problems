class Solution {
    public int numEnclaves(int[][] board) {
        int total=0;
        
        int n=board.length;
       int m= board[0].length;

       //int vis[][]=new int[n][m];

       for(int i=0;i<n;i++){
        for (int j=0;j<m;j++){
          if(board[i][j] == 1)total++;
        }
       } 

        int vis[][]=new int[n][m];

       for(int i=0;i<n;i++){
        for (int j=0;j<m;j++){
          vis[i][j]=0;
        }
       } 

        int count=0;
              // top row
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 1 && vis[0][i] == 0) {
                count += dfs(board, 0, i, vis, n, m);
            }
        }
        // bottom row
        for (int i = 0; i < m; i++) {
            if (board[n - 1][i] == 1 && vis[n - 1][i] == 0) {
                count += dfs(board, n - 1, i, vis, n, m);
            }
        }
        // left column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 1 && vis[i][0] == 0) {
                count += dfs(board, i, 0, vis, n, m);
            }
        }
        // right column
        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 1 && vis[i][m - 1] == 0) {
                count += dfs(board, i, m - 1, vis, n, m);
            }
        }

        return total-count;
    }

    public static int dfs(int board[][],int row,int col,int vis[][],int n,int m){
        vis[row][col]=1;
        int cnt=1;

        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};

        for(int i=0;i<4;i++){
            int r=row+delRow[i];
            int c=col+ delCol[i];

            if(r<n &&r>=0 && c<m && c>=0){
                if(board[r][c]== 1&&vis[r][c]==0){
                    cnt += dfs(board,r,c,vis,n,m);
                }
            }
        }

        return cnt;
    }
}