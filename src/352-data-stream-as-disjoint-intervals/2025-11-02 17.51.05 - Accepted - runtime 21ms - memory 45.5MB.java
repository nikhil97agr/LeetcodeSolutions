class SummaryRanges {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public SummaryRanges() {
        
    }
    
    public void addNum(int value) {
        if(map.containsKey(value)) return;
        Integer lower = map.floorKey(value);
        int start = value;
        int end = value;
        if(lower !=null){
            int e = map.get(lower);
            if(lower <= value && value <= e) return;
            if(e+1 == value){
                start = lower;
                map.remove(lower);
            }
        }

        Integer higher = map.ceilingKey(value);
        if(higher != null){
            if(value + 1 == higher){
                end = map.get(higher);
                map.remove(higher);
            }
        }

        map.put(start, end);
    }
    
    public int[][] getIntervals() {
        int ans[][] = new int[map.size()][2];
        int i=0;
        for(int key : map.keySet()){
            ans[i] = new int[]{key, map.get(key)};
            i++;
        }

        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */