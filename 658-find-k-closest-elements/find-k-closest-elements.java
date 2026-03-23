class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> li=new ArrayList<>();
        int low=0;
        int high=arr.length-1;

        while(high - low >= k){
            int dlow=Math.abs(arr[low]-x);
            int dhigh=Math.abs(arr[high]-x);

            if(dlow <= dhigh){
                high--;
            }else{
                low++;
            }

        }
        while(low <=high){
            li.add(arr[low]);
            low++;
        }

        return li;
        
    }
}