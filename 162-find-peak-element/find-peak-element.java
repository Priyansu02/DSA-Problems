class Solution {
    public int findPeakElement(int[] nums) {
       int i=0;
       int j=nums.length-1;

       if(i==j)return i;

       if(i+1==j){
        if(nums[i]> nums[j]){
            return i;
        }else{
            return j;
        }
       }

        while(i<=j){
            int mid=i+(j-i)/2;

            boolean leftCheck = (mid == 0) || (nums[mid] > nums[mid - 1]);
            boolean rightCheck = (mid == nums.length - 1) || (nums[mid] > nums[mid + 1]);

            if (leftCheck && rightCheck) {
                return mid; // Peak found
            } else if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                i = mid + 1; // Move right
            } else {
                j = mid - 1; // Move left
            }


        }
        return -1;
    }
}