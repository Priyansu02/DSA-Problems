class Solution {
   public int search(int[] nums, int target) {
        int n= nums.length;
        int st=0;
        int end=n-1;
        
        return Binary(nums,target,st,end);
    }

    public int Binary(int []nums,int target, int start,int end){

        if (start > end) {
            return -1;
        }

        int mid = start+(end-start)/2;

        if(nums[mid]== target){
            return mid;
        }else if(nums[mid]<target){
            return Binary(nums,target,mid+1,end);
        }else{
            return Binary(nums,target,start,mid-1);
        }

        
    }
}