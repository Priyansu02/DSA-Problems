class Solution {
    public int[] diStringMatch(String s) {
        int ans[]=new int[s.length()+1];

        int n=s.length();
        int i1=0;
        int j1=n;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='I'){
                ans[i]=i1;
                i1++;
            }else{
                ans[i]=j1;
                j1--;
            }
        }

        
        ans[ans.length-1]=i1;
       

        return ans;
    }
}