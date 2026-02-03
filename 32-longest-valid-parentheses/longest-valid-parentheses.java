class Solution {
    public int longestValidParentheses(String s) {
         if(s==null){
            return 0;
        }
        Stack<Integer> stk = new Stack();
        int result = 0;
        int lastI = -1;  
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                stk.push(i);
            } else {
                if(!stk.isEmpty()) { 
                    stk.pop(); 
                    
                    if(!stk.isEmpty()) { 
                        result = Math.max(result, i-stk.peek()); 
                    } else {
                        result = Math.max(result, i-lastI); 
                   
                    }
                } else {
                    lastI = i;
                }
            }
        }
        return result;
    }
}