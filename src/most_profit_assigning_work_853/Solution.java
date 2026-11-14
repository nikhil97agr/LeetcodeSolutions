package most_profit_assigning_work_853;

import java.util.*;
class Solution {
    public int maxProfitAssignment(int[] d, int[] p, int[] w) {
        int ans = 0;
        int n = d.length;
        int m = w.length;
        int job[][] = new int[n][2];
        for(int i=0;i<n;i++){
            job[i] =new int[]{d[i],p[i]};
        }

        Arrays.sort(job, (j1, j2)-> j1[0] - j2[0]);
        Arrays.sort(w);
        int j=0;
        int max = 0;
        for(int i=0;i<m;i++){
            while(j < n && job[j][0] <= w[i]){
                max = Math.max(max, job[j][1]);
                j++;
            }
            ans += max;
        }

        return ans;
    }
}