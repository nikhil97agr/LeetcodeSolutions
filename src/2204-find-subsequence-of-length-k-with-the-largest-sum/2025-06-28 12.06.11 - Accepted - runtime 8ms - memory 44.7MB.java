class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i=nums.length-1;
        int j=k;
        PriorityQueue<Integer> que= new PriorityQueue<>(Collections.reverseOrder());
        for(int x : nums){
            que.offer(x);
        }
        while(j-->0){
            map.merge(que.poll(), 1, Integer::sum);
            i--;
        }

        int ans[] = new int[k];
         j=0;
        for( i=0;i<nums.length && !map.isEmpty();i++){
            if(map.containsKey(nums[i])){
                ans[j++] = nums[i];
                if(map.get(nums[i]) == 1) map.remove(nums[i]);
                else map.merge(nums[i], -1, Integer::sum);
            }
        }

        return ans;

        
    }

}