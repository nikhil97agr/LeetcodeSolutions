package design_hashset_816;

import java.util.*;
class MyHashSet {
    Map<Integer, Boolean> set;
    public MyHashSet() {
        set = new HashMap<>();
    }
    
    public void add(int key) {
        set.put(key, true);
    }
    
    public void remove(int key) {
        set.remove(key);
    }
    
    public boolean contains(int key) {
        return set.get(key)!=null;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */