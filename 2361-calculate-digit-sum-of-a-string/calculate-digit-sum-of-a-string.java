class Solution {
    public String digitSum(String s, int k) {
         if (s.length() <= k) {
            return s;
        }
        String ans="";
        
        for(int i=0;i<s.length();i+= k){
            int sum=0;
            for(int j=i;j<Math.min(i + k, s.length());j++){
                int n = s.charAt(j) - '0';
                sum += n;
            }
            ans+= sum;
        }

        if(ans.length() <= k){
            return ans;
        }

        return digitSum(ans,k);
    }
}