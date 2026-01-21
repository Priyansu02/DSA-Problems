class Solution {
    public int subarraysDivByK(int[] nums, int k) {
           Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); // base case

        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            int remainder = ((sum % k) + k) % k; // normalize remainder
            count += remainderCount.getOrDefault(remainder, 0);
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        return count;

       
    }
}