class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        Deque<Integer> que = new LinkedList<>();
        Arrays.fill(ans, -1);
        int ind = 0;
        for(int i=0;i<n;i++){
            if(que.isEmpty()){
                que.offer(nums[i]);
            }else if(que.peekLast() + 1 == nums[i]){
                que.offer(nums[i]);
            }else{
                que.clear();
                que.offer(nums[i]);
            }


            if(i+1 >= k){
                if(que.size() == k){
                    ans[ind++] = que.peekLast();
                    que.pollFirst();
                }else{
                    ans[ind++] = -1;
                }
            }
        }
        return ans;
    }
}