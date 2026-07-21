class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor=image[sr][sc];

        int [][]ans=image;
        int drow[]={-1,1,0,0};
        int dcol[]={0,0,1,-1};

        dfs(sr,sc,image,ans,drow, dcol,iniColor,color);

        return ans;

    }

    public void dfs(int sr,int sc,int [][]image,int ans[][],int []drow, int []dcol,int iniColor, int newColor ){

        ans[sr][sc]=newColor;
        int n=image.length;
        int m=image[0].length;

        for(int i=0;i<4;i++){
            int nrow=sr+drow[i];
            int ncol=sc + dcol[i];

            if(nrow < n && nrow >= 0 && ncol <m && ncol >= 0 && image[nrow][ncol] == iniColor && image[nrow][ncol] != newColor){
            
                dfs(nrow,ncol,image,ans,drow, dcol,iniColor, newColor );
                
            }
        }

    }
}