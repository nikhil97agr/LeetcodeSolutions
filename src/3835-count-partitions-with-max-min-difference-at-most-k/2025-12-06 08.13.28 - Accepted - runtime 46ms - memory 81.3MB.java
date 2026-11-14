class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long dp[] = new long[n+1];
        long pre[] = new long[n+2];
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        dp[0] = 1;

        pre[0] = 0;
        pre[1] = 1;

        int start = 0;
        int end = 1;
        
        while(end <= n){
            int val = nums[end-1];

            while(!min.isEmpty() && nums[min.getLast()] >= val){
                min.removeLast();
            }

            while(!max.isEmpty() && nums[max.getLast()] <= val){
                max.removeLast();
            }

            min.addLast(end-1);
            max.addLast(end-1);

            while(nums[max.getFirst()] - nums[min.getFirst()] >k){
                start++;
                if(min.getFirst() < start) min.removeFirst();
                if(max.getFirst() < start) max.removeFirst();
            }

            dp[end] = add(0, pre[end] - pre[start] + (long)1e9+7);
            pre[end+1] = add(pre[end], dp[end]);
            end++;
        }

        return (int)dp[n];
    }

    private long add(long a, long b){
        long mod = (long)1e9+7;

        return (a%mod + b%mod)%mod;
    }
}