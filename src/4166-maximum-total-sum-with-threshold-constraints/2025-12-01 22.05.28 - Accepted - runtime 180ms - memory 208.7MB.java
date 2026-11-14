class Solution {
    public long maxSum(int[] nums, int[] threshold) {
        long ans = 0;
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            map.computeIfAbsent(threshold[i], x -> new ArrayList<>()).add(nums[i]);
        }
        int step = 1;

        while(true){
            if(!map.containsKey(step) && que.isEmpty()) break;
            if(map.containsKey(step)){
                for(int x : map.get(step)){
                    que.offer(x);
                }
            }

            step++;
            ans += que.poll();

        }
        return ans;
    }
}