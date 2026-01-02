class Solution {
    public int repeatedNTimes(int[] nums) {
       HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return num; // Found the repeated element
            }
        }
        return -1;
    }
}