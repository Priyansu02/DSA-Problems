public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // Step 2: Put entries into max-heap (by frequency)
        PriorityQueue<Integer> pq =
               new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

        for (int num : freq.keySet()) {
            pq.offer(num);
        }


        // Step 3: Remove top k elements
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
