package design_a_number_container_system_2434;

import java.util.*;
class NumberContainers {
    Map<Integer, TreeSet<Integer>> indexMap;
    Map<Integer, Integer> numberMap;
    public NumberContainers() {
        indexMap = new HashMap<>();
        numberMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(numberMap.containsKey(index)){
            int num = numberMap.get(index);
            indexMap.get(num).remove(index);
        }
        indexMap.computeIfAbsent(number, num -> new TreeSet<>()).add(index);
        numberMap.put(index, number);
    }
    
    public int find(int number) {
        if(indexMap.containsKey(number) && !indexMap.get(number).isEmpty()){
            return indexMap.get(number).first();
        }
        return -1;

    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */