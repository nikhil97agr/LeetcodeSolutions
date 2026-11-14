package insert_delete_getrandom_o1_duplicates_allowed_381;

import java.util.*;
class RandomizedCollection {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random = new Random();
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        map.merge(val, 1, Integer::sum);

        list.add(val);

        return map.get(val) == 1;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        map.merge(val, -1, Integer::sum);
        if(map.get(val) ==0) map.remove(val);

        list.remove(Integer.valueOf(val));
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */