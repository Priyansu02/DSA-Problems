class ProductOfNumbers {
     List<Integer> list;
    int prev;
    public ProductOfNumbers() {
         list = new ArrayList();
        list.add(1);
        prev = 1;
    }
    
    public void add(int num) {
         if (num > 0) {
            prev*=num;
            list.add(prev);
        }
        //if this is 0  we need to reinit the structure
        else {
            list = new ArrayList();
            list.add(1);
            prev = 1;
        }
    }
    
    public int getProduct(int k) {
        int N = list.size();
        return (k < N) ? prev / list.get(N - 1 - k) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */