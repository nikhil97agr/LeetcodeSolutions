package maximum_total_beauty_of_the_gardens_2330;

import java.util.*;
class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        int n = flowers.length;

        if(n==1){
            if(flowers[0] >= target) return full;
            long res = Math.min(target - 1, flowers[0] + newFlowers) * partial;
            if(flowers[0] + newFlowers >= target){
                res = Math.max(res, full);
            }
            return res;
        }

        int i=n-1;
        while( i >=0 && flowers[i] >= target) i--;

        if( i == -1){
            return 1l * n * full;
        }

        long prefix[] = new long[n];
        prefix[0] = flowers[0];
        for(int j=1;j<n;j++){
            prefix[j] = prefix[j-1] + flowers[j];
        }
        long mid = 1l * (n-1-i) * full;
        int left = i + 1;
        
        long ans = max(left - 1, newFlowers, target, prefix, flowers)*partial;

        if(newFlowers - 1l * target * left + prefix[left-1] >=0){
            ans= Math.max(ans, left * full);
        }
        long total = 0;
        while(i > 0){
            total += flowers[i];
            long val = newFlowers - 1l*target * (left - i) + total;
            if(val < 0){
                break;
            }

            ans = Math.max(ans, max(i-1, val, target, prefix, flowers) * partial + 1l*full * (left - i));
            i--;
        }

        return ans + mid;
    }

    private long max(int end, long left, long target, long pre[], int flowers[]){
        int start = 0;
        int in = -1;

        while(start <= end){
            int mid = (start + end)/2;
            long req = 1l*flowers[mid]*(mid + 1) - pre[mid];
            if(left >= req){
                in = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        if(in == -1){
            return 0;
        }
        return Math.min((left + pre[in])/(in+1), target - 1);
    }
}