class Solution {
    public int[] dailyTemperatures(int[] temps) {
     
        int[] results = new int[temps.length];
       for(int i=temps.length-1; i>=0 ;i--){
        for(int j=i-1; j>=0 && temps[j]<temps[i];j--){
            results[j]=i-j;
        }
       }

        return results;
    }
    
}