package longest_strictly_increasing_subsequence_with_non_zero_bitwise_and_4032;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int longestSubsequence(int[] nums) {
        int cnt = 0;
        int n = nums.length;

        for(int x : nums){
            if(x ==0) cnt++;
        }
        if(cnt == n) return 0;

        int ans = 0;
        for(int i=31;i>=0;i--){
            ans = Math.max(ans, longestSubseq(nums, i, n));
        }

        return ans;
    }

    private int longestSubseq(int nums[], int bit, int n){
        List<Integer> list = new ArrayList<>();
        for(int x : nums){
            if((x & (1<<bit)) !=0) list.add(x);
        }
        List<Integer> result = new ArrayList<>();
        for(int x : list){
            int ind = bs(result, x);
            if(ind == -1){
                result.add(x);
            }else{
                result.set(ind, x);
            }

        }
        
        return result.size();
    }
    
    private int bs(List<Integer> list, int val){
        int ind = -1 ;
        
        int start =0;
        int end = list.size() -1;
        while(start <= end){
            int mid = (start + end)/2;
            
            if(list.get(mid) >= val){
                ind = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return ind;
    }
}

