class MyHashSet {
    public ArrayList<Integer> a;
    public MyHashSet() {
        this.a = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!a.contains(key)) a.add(key);
    }
    
    public void remove(int key) {
        for(int i=0;i<a.size();i++){
            if(a.get(i) == key) a.remove(i);
        }
    }
    
    public boolean contains(int key) {
        return a.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */