class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);

        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
        for(int v:map.values()){
            pq.add(v);
        }
        int sum=0;
        int c=0;
         int half = arr.length / 2;

        while(sum < half){
            sum +=pq.poll();
            c++;
        }
        return c;
    }
}