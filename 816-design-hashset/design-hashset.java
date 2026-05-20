class MyHashSet {
    ArrayList<Integer>al;
    public MyHashSet() {
        al=new ArrayList<>();
    }
    
    public void add(int key) {
        if(!al.contains(key)){
            al.add(key);
        }
    }
    
    public void remove(int key) {
         int idx = al.indexOf(key); // find index of value
    if (idx != -1) {
        al.remove(idx); // remove at that index
    }
    }
    
    public boolean contains(int key) {
        
        return al.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */