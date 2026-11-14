class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int cnt[][] = new int[n][101];
        for(var i=0;i<n;i++){
            int c[] = new int[101];
            if(i-1 >=0){
                c = cnt[i-1].clone();
            }

            c[nums[i]]++;
            cnt[i] = c;
        }

        int q = queries.length;
        int ans[] = new int[q];

        for(int i=0;i<q;i++){
            ans[i] = calc(cnt, queries[i]);
        }

        return ans;

    }

    private int calc(int cnt[][], int q[]){
        int l = q[0],r=q[1];
        int c[] = new int[101];
        if(l ==0){
            c = cnt[r];
        }else{
            for(int i=0;i<=100;i++){
                c[i] = cnt[r][i] - cnt[l-1][i];
            }
        }
        int ans = Integer.MAX_VALUE;

        int start = -1;
        for(int end = 0;end <= 100;end++){
            if(c[end] !=0){
                if(start != -1){
                    ans = Math.min(ans, end - start);
                }
                start = end;
            }
        }

        return ans == Integer.MAX_VALUE ? -1: ans;
    }
}