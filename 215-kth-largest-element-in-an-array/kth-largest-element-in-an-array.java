class Solution {
    public int findKthLargest(int[] A, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
    
        for(int i = 0; i<A.length; i++){
            
            pq.add(A[i]);
            
            if(pq.size() > k){
                 pq.poll();
            }
                
        }
    
      return pq.poll();
    }
}