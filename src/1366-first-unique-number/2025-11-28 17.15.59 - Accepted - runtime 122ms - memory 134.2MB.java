class FirstUnique {
    LinkedHashMap<Integer, Integer> map;
    
    Set<Integer> removed = new HashSet<>();
    public FirstUnique(int[] nums) {
        map = new LinkedHashMap<>();
        for(int x : nums){
            map.merge(x, 1, Integer::sum);
            if(map.get(x) > 1){
                removed.add(x);
            }
        }

        for(int x : removed){
            map.remove(x);
        }

        
    }
    
    public int showFirstUnique() {
        if(map.isEmpty()) return -1;
        return map.firstEntry().getKey();
    }
    
    public void add(int value) {
        if(removed.contains(value)) return;

        map.merge(value, 1, Integer::sum);

        if(map.get(value)> 1){
            removed.add(value);
            map.remove(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */