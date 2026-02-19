class Solution {
    public int findMin(int[] nums) {

        if(nums.length== 1){
            return nums[0];
        }
        int i=0;
        int j=nums.length-1;

      //  int minn=Integer.MAX_VALUE;
        while( i < j){
            int mid= i+(j-i)/2;

            if(nums[mid] > nums[j]){
                i=mid+1;
            }else if(nums[mid] < nums[j]){
                j=mid;
            }else{
                j--;
            }
           
        }
        return nums[i];
    }
}