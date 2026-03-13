class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
         long count = nums.stream()
                .flatMapToInt(range -> IntStream.rangeClosed(range.get(0), range.get(1)))
                .distinct()
                .count();
        return (int) count;
    }
}