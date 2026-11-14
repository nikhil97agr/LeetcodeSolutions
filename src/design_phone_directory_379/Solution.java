package design_phone_directory_379;

import java.util.*;
class PhoneDirectory {
    TreeSet<Integer> set ;
    public PhoneDirectory(int maxNumbers) {
        set = new TreeSet<>();
        for(int i=0;i<maxNumbers;i++){
            set.add(i);
        }
    }
    
    public int get() {
        if(set.isEmpty()) return -1;
        return set.pollFirst();
    }
    
    public boolean check(int number) {
        return set.contains(number);
    }
    
    public void release(int number) {
        set.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */