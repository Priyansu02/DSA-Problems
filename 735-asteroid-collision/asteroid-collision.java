class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer>s=new Stack<>();
        for (int i : arr) {
            boolean alive = true;

            while(alive && !s.isEmpty() && i <0 && s.peek() > 0){
                if (s.peek() < -i) {
                    s.pop(); // right asteroid explodes
                } else if (s.peek() == -i) {
                    s.pop(); // both explode
                    alive = false;
                } else {
                    alive = false; // left asteroid explodes
                }

            }
            if(alive){
                s.push(i);
            }
        }
        int[] ans = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            ans[i] = s.pop();
        }
        return ans;

    }
}