class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
         Set<Integer> seen = new HashSet<>();
        int cnt = 0;
        for(int num : nums) {
            seen.add(num);
            if(seen.contains(num - diff) && seen.contains(num - 2*diff))
                cnt++;
        }
        return cnt;

    }
}