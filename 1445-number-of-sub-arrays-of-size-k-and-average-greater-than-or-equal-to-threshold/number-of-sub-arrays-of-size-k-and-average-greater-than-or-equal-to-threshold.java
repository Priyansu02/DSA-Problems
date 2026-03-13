class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0;
        double sum=0;
        int j=0;
       for(int i=0;i<arr.length ;i++){
            sum += arr[i];
            if(i-j+1 == k){
                if(sum/k >= threshold){
                count++;
                }
                sum -=arr[j];
                j++; 
            }

        }
       

       
       return count;
    }
}