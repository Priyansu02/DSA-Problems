class MyCircularDeque {
    int head,tail,size,n;
    int[]a;
    public MyCircularDeque(int k) {
        a=new int[k];
        n=a.length;
        tail=1;

    }
    
    public boolean insertFront(int value) {
        if(size==n)return false;
        head++;

        head %=n;
        a[head]=value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size==n)return false;
        tail--;
        a[tail = (tail + n) % n] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
          if (size == 0) return false;
        head = (--head + n) % n;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
          if (size == 0) return false;
        tail = ++tail % n;
        size--;
        return true;
    }
    
    public int getFront() {
        return size == 0 ? -1 : a[head];
    }
    
    public int getRear() {
        return size == 0 ? -1 : a[tail];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size== a.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */