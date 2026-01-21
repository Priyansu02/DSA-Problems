class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                nums[i]=0;
            }else{
                nums[i]=1;
            }
        }
         Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;

            if (prefixCount.containsKey(sum - k)) {
                count += prefixCount.get(sum - k);
            }

            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        return count;

    }
}