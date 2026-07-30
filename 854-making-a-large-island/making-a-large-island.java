class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};

    HashMap<Integer,Integer> size=new HashMap<>();

    public void dfs(int row,int col,int [][]grid,int change){

        if(row<0 || col<0 || row>=m || col>=n || grid[row][col]!=1)
            return;

        // Assign current island ID
        grid[row][col]=change;

        // Increase current island size
        size.put(change,size.getOrDefault(change,0)+1);

        // Explore all four directions
        for(int i=0;i<4;i++){
            dfs(row+dx[i],col+dy[i],grid,change);
        }
    }

    public int largestIsland(int[][] grid) {

        m=grid.length;
        n=grid[0].length;

        int change=2;

        // Label every island with a unique ID
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(i,j,grid,change);
                    change++;
                }
            }
        }

        int ans=0;

        // Handles the all-land case
        for(int islandSize:size.values()){
            ans=Math.max(ans,islandSize);
        }

        // Try flipping every zero
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]==0){

                    HashSet<Integer> set=new HashSet<>();

                    // Collect unique neighbouring island IDs
                    for(int k=0;k<4;k++){

                        int nr=i+dx[k];
                        int nc=j+dy[k];

                        if(nr<0 || nc<0 || nr>=m || nc>=n)
                            continue;

                        if(grid[nr][nc]>1)
                            set.add(grid[nr][nc]);
                    }

                    // Count the flipped cell itself
                    int current=1;

                    // Merge neighbouring islands
                    for(int id:set){
                        current+=size.get(id);
                    }

                    ans=Math.max(ans,current);
                }
            }
        }

        return ans;
    }
}