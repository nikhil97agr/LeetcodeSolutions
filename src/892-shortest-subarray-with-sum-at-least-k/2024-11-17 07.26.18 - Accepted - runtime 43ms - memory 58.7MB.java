class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = n+1;
        long prefix[] = new long[n+1];

        for(int i=1;i<=n;i++){ prefix[i] = prefix[i-1] +nums[i-1]; }

        Deque<Integer> que = new LinkedList<>();

        for(int i=0;i<=n;i++){
            while(!que.isEmpty()){
                int ind = que.peekFirst();
                if(prefix[i] - prefix[ind] < k) break;
                ans = Math.min(ans, i - ind);
                que.removeFirst();
            }

            while(!que.isEmpty()){
                int ind = que.peekLast();
                if(prefix[i] > prefix[ind]) break;
                que.removeLast();
            }

            que.offerLast(i);
        }

        return ans == n+1 ? -1 : ans;
    }
}