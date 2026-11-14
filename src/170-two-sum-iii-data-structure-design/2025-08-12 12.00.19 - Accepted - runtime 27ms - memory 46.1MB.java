class TwoSum {
    List<Integer> list;
    public TwoSum() {
        list =new ArrayList<>();
    }
    
    public void add(int number) {
        int ind = Collections.binarySearch(list, number);
        if(ind < 0){
            list.add(-ind - 1, number);
        }else{
            list.add(ind, number);
        }

    }
    
    public boolean find(int value) {
        int start = 0;
        int end = list.size() -1;
        while(start < end){
            int sum = list.get(start) + list.get(end);
            if(sum == value) return true;
            if(sum > value){
                end--;
            }else{
                start++;
            }
        }

        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */