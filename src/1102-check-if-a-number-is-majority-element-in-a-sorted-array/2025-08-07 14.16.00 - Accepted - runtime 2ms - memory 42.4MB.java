class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int x : nums) map.merge(x, 1, Integer::sum);
        int n = nums.length;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > n /2){
                return entry.getKey() == target;
            }
        }

        return false;
    }
}