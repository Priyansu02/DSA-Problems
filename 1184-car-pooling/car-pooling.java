class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int lengthOfTrip[] = new int[1001];
        
        for(int trip[] : trips){
            lengthOfTrip[trip[1]] += trip[0]; // Increment when passenger is on board
            lengthOfTrip[trip[2]] -= trip[0]; // decrement when they depart
        }
        
        for(int passenger : lengthOfTrip){
            capacity -= passenger;
            if(capacity < 0) return false;
        }
        return true;
    }
}