class Solution {
    public int longestConsecutive(int[] arr) {
       int curr=0,streak=0,longest=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i:arr)
            set.add(i);
        for(int i:set){
            if(!set.contains(i-1)){
                curr=i;
                streak=1;
                while(set.contains(curr+1)){
                    curr++;
                    streak++;
                }
                longest=Math.max(streak,longest);
            }
        }
        return longest; 
    }
}