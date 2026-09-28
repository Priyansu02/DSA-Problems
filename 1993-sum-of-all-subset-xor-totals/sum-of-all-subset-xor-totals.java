class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsets);

        int totalSum = 0;
        for (List<Integer> subset : subsets) {
            int xor = 0;
            for (int num : subset) {
                xor ^= num;   // XOR accumulation
            }
            totalSum += xor;
        }
        return totalSum;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Exclude nums[index]
        generateSubsets(nums, index + 1, current, subsets);

        // Choice 2: Include nums[index]
        current.add(nums[index]);
        generateSubsets(nums, index + 1, current, subsets);
        current.remove(current.size() - 1); // backtrack
    }
}