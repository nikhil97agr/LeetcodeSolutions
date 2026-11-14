package minimum_space_wasted_from_packaging_2018;

import java.util.*;
class Solution {
    long mod = (long)1e9 + 7;
    public int minWastedSpace(int[] packages, int[][] boxes) {
        long ans = Long.MAX_VALUE;
        int n = packages.length;
        long pre[] = new long[n+1];
        Arrays.sort(packages);
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + packages[i];
        }

        for(int b[] : boxes){
            Arrays.sort(b);
            int prev = 0;
            long total = 0;
            for(int box : b){
                int start = prev;
                int end = n - 1;
                int ind = -1;

                while(start <= end){
                    int mid = (start + end)/2;
                    if(packages[mid] <= box){
                        ind = mid;
                        start = mid + 1;
                    }else{
                        end = mid - 1;
                    }
                }
                if(ind != -1){
                    int len = ind - prev + 1;
                    long size = 1l * box * len;
                    long used = pre[ind + 1] - pre[prev];
                    total += size -used;

                    prev = ind + 1;
                }
            }
            if(prev == n){
                ans = Math.min(ans, total);
            }
        }

        return ans == Long.MAX_VALUE ? -1 : add(ans, 0);

    }

    private int add(long a, long b){
        return (int)((a+b)%mod);
    }
}