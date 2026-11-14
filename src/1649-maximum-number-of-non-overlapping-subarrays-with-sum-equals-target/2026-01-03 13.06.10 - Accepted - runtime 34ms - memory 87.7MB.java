class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>(); 
       int ans = 0;
       int sum = 0;
       int lastEnd = -1;
       map.put(0, -1);
       for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int req =sum - target;

            if(map.containsKey(req)){
                int ind = map.get(req);
                if(ind >= lastEnd){
                    ans++;
                    lastEnd = i;
                }
            }
            map.put(sum, i);

       }

       return ans;
    }
}