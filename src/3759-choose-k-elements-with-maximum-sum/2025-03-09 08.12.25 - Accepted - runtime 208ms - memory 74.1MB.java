class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long ans[] = new long[n];
        long sum = 0;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums1[i], (n1) -> new ArrayList<>()).add(i);
        }
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            int key = entry.getKey();
            long curr = sum;
            for(int ind : list){
                ans[ind] = curr;
                sum+= nums2[ind];
                que.offer(nums2[ind]);
                if(que.size() > k){
                    sum -= que.poll();
                }
            }

            
        }

        return ans;
    }
}