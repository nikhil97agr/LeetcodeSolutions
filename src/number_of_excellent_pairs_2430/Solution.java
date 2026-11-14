package number_of_excellent_pairs_2430;

import java.util.*;
class Solution {
    public long countExcellentPairs(int[] nums, int k) {
                Set<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }
        int n = set.size();
        int bits[] = new int[n];
        int i=0;
        for(int x : set){
            bits[i] = Integer.bitCount(x);
            i++;
        }
        long ans = 0;
        Arrays.sort(bits);
        for( i=0;i<n;i++){
            if(bits[i] >= k){
                ans += n;
                continue;
            }
            int req = k - bits[i];
            int start = 0;
            int end = n-1;
            long cnt = 0;
            while(start <= end){
                int mid = (start + end)/2;
                if(bits[mid] >= req){
                    cnt = n - mid;
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            ans += cnt;
        }

        return ans;
    }
}