class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] changes = new int[1001]; // since max location = 1000
        
        for (int[] trip : trips) {
            int num = trip[0], from = trip[1], to = trip[2];
            changes[from] += num;   // pick up
            changes[to] -= num;     // drop off
        }
        
        int passengers = 0;
        for (int i = 0; i <= 1000; i++) {
            passengers += changes[i];
            if (passengers > capacity) return false;
        }
        return true;
    }
}