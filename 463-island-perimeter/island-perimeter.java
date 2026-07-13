class Solution {
    public int islandPerimeter(int[][] grid) {
        int land=0, nei=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    land++;

                    if(i< grid.length-1 && grid[i+1][j]== 1)nei++;
                    if(j< grid[i].length-1 && grid[i][j+1]== 1)nei++;

                }
            }
        }

        return land*4 - nei*2;
    }
}