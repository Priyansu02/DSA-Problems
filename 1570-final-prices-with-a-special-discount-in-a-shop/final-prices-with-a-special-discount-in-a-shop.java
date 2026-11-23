class Solution {
    public int[] finalPrices(int[] prices) {

        Stack<Integer> st = new Stack<>();

        for(int i = prices.length - 1; i >= 0; i--) {

            int curr = prices[i];

            while(!st.isEmpty() && st.peek() > curr) {
                st.pop();
            }

            if(!st.isEmpty()) {
                prices[i] = curr - st.peek();
            }

            st.push(curr);
        }

        return prices;
    }
}