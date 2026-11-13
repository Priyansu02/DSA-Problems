class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
       
       int left=1;
       int right=0;

       for(int num:nums){
        right=Math.max(num,right);
       }

       int answer=0;
       while(left<=right){
          int mid=left+(right-left)/2;
          int sum=0;
          for(int i=0;i<nums.length;i++){
          sum+=Math.ceil((double)nums[i]/mid);
          }
          if(sum<=threshold){
              right=mid-1;

              answer=mid;
          }else{
            left=mid+1;
          }
       }
       return answer;

    }
}