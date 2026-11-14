class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        Arrays.sort(nums);
        int max = Arrays.stream(nums).max().getAsInt();
        int counter[] = new int[max + 1];
        for(int x : nums) counter[x]++;
        long cnt[] = new long[max  + 1];
        for(var gcd = max;gcd >=1 ;gcd--){
            long total = 0;
            for(var start = gcd;start <= max;start += gcd){
                total += counter[start];
            }

            cnt[gcd] = (total * (total-1))/2;

            for(var start = 2 * gcd;start <= max;start += gcd){
                cnt[gcd] -= cnt[start];
            } 

        }
        var q = queries.length;
        var que = new long[q][2];
        for(int i=0;i<q;i++){
            que[i] = new long[]{queries[i], i};
        }
        Arrays.sort(que, (a,b) ->Long.compare(a[0], b[0]));
        int ans[] = new int[q];
        long total =0;
        int ii = 0;
        for(var qq : que){
            long ind = qq[0];
            int i = (int)qq[1];

            while(ii <= max && total <= ind){
                total += cnt[ii];
                ii++;
            }


            ans[i] = ii-1;
        }

        return ans;
    }
}