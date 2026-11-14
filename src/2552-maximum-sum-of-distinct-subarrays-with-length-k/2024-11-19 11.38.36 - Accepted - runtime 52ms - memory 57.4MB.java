class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        int n=nums.length;
        int start = 0;
        HashMap<Integer, Integer>map = new HashMap<Integer, Integer>();
        long sum = 0;
        for(int i=0;i<k;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            sum +=(long) nums[i];
        }
        if(map.size()==k){
            max = sum;
        }
        for(int i=k;i<n;i++){
            if(map.get(nums[start])==1){
                map.remove(nums[start]);
            }
            else{
                map.put(nums[start], map.get(nums[start])-1);
            }
            sum -=(long) nums[start++];
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            sum += (long)nums[i];
            if(map.size()==k){
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}