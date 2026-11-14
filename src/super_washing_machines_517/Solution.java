package super_washing_machines_517;

import java.util.*;
class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int total = Arrays.stream(machines).sum();
        if(total%n!=0) return -1;
        int each = total / n;
        int pre[] = new int[n];
        int suff[] = new int[n];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + machines[i-1];
        }
        for(int i=n-2;i>=0;i--){
            suff[i] = suff[i+1] + machines[i+1] ;
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            int left = i * each;
            int right = (n - i - 1) * each;

            int leftExtra = 0;
            int rightExtra = 0;
            if(left > pre[i]){
                leftExtra = left - pre[i];
            }

            if(right > suff[i]){
                rightExtra = right - suff[i];
            }

            ans = Math.max(ans, leftExtra + rightExtra);
        }

        return ans;


    }
}