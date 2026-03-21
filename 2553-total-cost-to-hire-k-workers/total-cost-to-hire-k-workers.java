class Solution {
    public long totalCost(int[] cost, int k, int candidate) {
        int i=0;
        int j=cost.length-1;
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>();

        long ans=0;

        while(k-- > 0){
            while(pq1.size()<candidate && i<=j){
            pq1.add(cost[i]);
            i++;
            }

            while(pq2.size()<candidate && i<=j){
            pq2.add(cost[j]);
            j--;
            }

            int t1=pq1.size() > 0?pq1.peek():Integer.MAX_VALUE;
             int t2=pq2.size() > 0?pq2.peek():Integer.MAX_VALUE;

            if(t1 <= t2){
                ans += t1;
                pq1.remove();
            }else{
                ans += t2;
                pq2.remove();
            }
        }

        return ans;
    }
}