class Solution{
    public int lastStoneWeightII(int[] stones){
        int total = 0;
        for (int stone : stones) {
            total += stone;
        }
        
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        
        // Subset sum DP
        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }
        
        // Find the closest sum to total/2
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                return total - 2 * i;
            }
        }
        
        return 0;
    }
}