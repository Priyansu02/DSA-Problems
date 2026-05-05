class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       int total = 0;
        for (int num : nums) total += num;

        // If impossible, return 0
        if ((total + target) % 2 != 0 || total < Math.abs(target))  return 0;

        int S1 = (total + target) / 2;
        return helper(nums, S1);
    }

    private int helper(int[] nums, int sum) {
       int n=nums.length;
       int dp[][]= new int[n+1][sum+1];

       dp[0][0]=1;

        for(int i=1;i<= n; i++){
            for(int j=0; j<= sum; j++){
                dp[i][j]= dp[i-1][j];

                if(nums[i-1]<= j){
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
       }

       return dp[n][sum];
    }
}