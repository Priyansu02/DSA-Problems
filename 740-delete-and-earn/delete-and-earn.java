class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            maxNum = Math.max(maxNum, num);
        }
        
        int[] points = new int[maxNum + 1];
        for (int num : countMap.keySet()) {
            points[num] = num * countMap.get(num);
        }
        
        // Step 2: Tabulation DP
        int[] dp = new int[maxNum + 1];
        dp[0] = 0;
        dp[1] = points[1];
        
        for (int i = 2; i <= maxNum; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points[i]);
        }
        
        return dp[maxNum];

    }
}