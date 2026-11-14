class Solution {
    public int minimumSum(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=2;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        TreeSet<Integer> set = new TreeSet<>();
        set.add(nums[0]);
        for(int i=1;i<n-1;i++){
            Integer left = set.first();
            Integer right = map.firstKey();

            if(left< nums[i] && right < nums[i]){
                ans = Math.min(ans, left + right + nums[i]);
            }
            if(map.containsKey(nums[i+1])){
                map.put(nums[i+1], map.get(nums[i+1])-1);
                if(map.get(nums[i+1])==0) map.remove(nums[i+1]);
            }
            set.add(nums[i]);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}