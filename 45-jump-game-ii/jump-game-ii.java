class Solution {
    public int jump(int[] A) {
      int jump=0,longg=0,end=0;
        for(int i=0;i<A.length-1;i++){
            longg=Math.max(longg,i+A[i]);
            if(i== end){
                jump++;
                end=longg;
            }
        }
        return jump;
    }
}