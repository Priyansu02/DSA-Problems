class Solution {
    public int coinChange(int[] coins, int amount) {
         int max = amount + 1; // acts like infinity
        int[] dp = new int[amount + 1];
        
        // initialize dp with "infinity"
        for (int i = 0; i <= amount; i++) {
            dp[i] = max;
        }
        dp[0] = 0; // base case
        
        // bottom-up DP
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];

    }
}