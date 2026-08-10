class Solution {
    public int longestStrChain(String[] words) {
        // Step 1: Sort words by length
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // each word alone is a chain

        int maxChain = 1;

        // Step 2: LIS-style DP
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxChain = Math.max(maxChain, dp[i]);
        }

        return maxChain;
    }

    // Two-pointer predecessor check
    private boolean isPredecessor(String a, String b) {
        if (b.length() != a.length() + 1) return false;

        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++; j++;
            } else {
                j++; // skip one char in b
            }
        }
        return i == a.length();
    }
}
