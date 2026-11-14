class Solution {
    Map<Integer, List<Integer>> map;
    Map<Integer, Integer> nextIndex;
    public Solution(int[] nums) {
        map = new HashMap<>();
        nextIndex = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.computeIfAbsent(nums[i], a-> new ArrayList<>()).add(i);
            nextIndex.put(nums[i], 0);
        }
    }
    
    public int pick(int target) {
        int ind = nextIndex.get(target);
        List<Integer> list = map.get(target);
        
        int ans = list.get(ind);
        ind++;
        ind%=list.size();
        nextIndex.put(target, ind);
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */