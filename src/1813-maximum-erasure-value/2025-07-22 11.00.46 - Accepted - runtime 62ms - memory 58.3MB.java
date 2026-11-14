class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int result = nums[0];
        HashMap<Integer,Integer> map = new HashMap();
        map.put(nums[0],0);
        int total = nums[0];
        int curr = 0;
        for(int i=1;i<nums.length;i++){
            total += nums[i];
            if(map.containsKey(nums[i])){
                while(curr<=map.get(nums[i])){
                    total -= nums[curr];
                    curr++;
                }
                map.put(nums[i], i);
                result = Math.max(result, total);
            }else{
                map.put(nums[i], i);
                result = Math.max(total, result);
            }
        }
        return result;
    }
}