class Solution {
    public int longestPalindromeSubseq(String s) {
        int n= s.length();
        int dp[][]= new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(s,0,n-1,dp);
    }
    public static int helper(String s, int i,int j,int dp[][]){
       
        if(i==j){
            return 1;
        }
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i)== s.charAt(j)){
            return dp[i][j]=helper(s,i+1,j-1,dp)+2;
        }else{
            int ans1=helper(s,i+1,j,dp);
            int ans2=helper(s,i,j-1,dp);
            return dp[i][j]=Math.max(ans1,ans2);
        }

    }
}