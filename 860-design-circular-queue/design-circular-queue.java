class MyCircularQueue {
    int []q;
    int front,rear,max,size;
    public MyCircularQueue(int k) {
        q=new int[k];
        front=0;
        rear=-1;
        size=0;
        max=k;
    }
    
    public boolean enQueue(int value) {
        if(size < max){
            rear= ++rear % max;
            q[rear]=value;
            size++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(size > 0){
            front= ++front % max;
            size--;
            return true;
        }
        return  false;
    }
    
    public int Front() {
        return size>0 ? q[front]:-1;
    }
    
    public int Rear() {
        return size>0 ? q[rear]:-1;
    }
    
    public boolean isEmpty() {
      return size==0;  
    }
    
    public boolean isFull() {
        return size==max;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */