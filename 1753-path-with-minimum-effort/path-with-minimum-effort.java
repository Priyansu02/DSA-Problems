class Solution {
    public int minimumEffortPath(int[][] height) {
        int n = height.length;
        int m = height[0].length;

        int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}};
        int[][] effort = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.add(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], dist = curr[2];

            if (r == n - 1 && c == m - 1) return dist;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int diff = Math.abs(height[nr][nc] - height[r][c]);
                    int newd = Math.max(dist, diff);

                    if (newd < effort[nr][nc]) {
                        effort[nr][nc] = newd;
                        q.add(new int[]{nr, nc, newd});
                    }
                }
            }
        }
        return -1;
    }
}
