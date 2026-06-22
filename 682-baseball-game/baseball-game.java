class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s= new Stack<>();
        for (String op : operations) {
            if (op.equals("C")) {
                s.pop();
            } else if (op.equals("D")) {
                s.push(s.peek() * 2);
            } else if (op.equals("+")) {
                int top = s.pop();
                int newTop = top + s.peek();
                s.push(top);       
                s.push(newTop);    
            } else {
                s.push(Integer.parseInt(op));
            }
        }

        int sum=0;
        while(!s.isEmpty()){
            sum+= s.pop();
        }

        return sum;
    }
}