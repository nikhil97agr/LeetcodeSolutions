class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int ans = 0;
        int cnt[] = new int[(int)1e5 + 1];
        int start =0;
        int end = 0;
        Set<Integer> discarded = new HashSet<>();
        int n = arrivals.length;
        while(end < n){
            int val = arrivals[end];
            cnt[val]++;

            if(end - start + 1 > w){
                if(!discarded.contains(start))
                    cnt[arrivals[start]]--;
                start++;
            }

            if(cnt[val] > m){
                ans++;
                cnt[val]--;
                discarded.add(end);
            }
            end++;
        }

        return ans;
    }
}