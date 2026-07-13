class Solution {
    int perimeter = 0;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int islandPerimeter(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j);
                    return perimeter; // only one island
                }
            }
        }
        return 0;
    }

    void dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
            perimeter++; // water or boundary contributes to perimeter
            return;
        }
        if(grid[i][j] == -1) return; // already visited
        
        grid[i][j] = -1; // mark visited
        for(int[] d : dirs){
            dfs(grid, i+d[0], j+d[1]);
        }
    }
}