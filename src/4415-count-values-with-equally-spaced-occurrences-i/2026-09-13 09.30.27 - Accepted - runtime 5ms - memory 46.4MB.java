class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        for(var l : map.values()){
            if(l.size() == 3){
                if(l.get(1) - l.get(0) == l.get(2) - l.get(1)){
                    ans++;
                }
            }
        }

        return ans;
    }
}