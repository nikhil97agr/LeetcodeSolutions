class Solution {
    public int maximumBeauty(int[] flowers) {
        int n = flowers.length;
        int pre[] = new int[n+1];
        int negSum[] = new int[n+1];
        int sum = 0;
        int neg = 0;
        Map<Integer, Integer> index = new HashMap<>();
        for(int i=0;i<n;i++){
            sum += flowers[i];
            if(flowers[i] < 0){
                neg += flowers[i];
            }

            index.put(flowers[i], i);

            pre[i+1] = sum;
            negSum[i+1] = neg;
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int val = flowers[i];
            int ind = index.get(val);
            if(ind == i){
                continue;
            }

            int s1 = pre[ind+1] - pre[i];
            int s2 = negSum[ind] - negSum[i+1];

            ans = Math.max(ans, s1 - s2);
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}