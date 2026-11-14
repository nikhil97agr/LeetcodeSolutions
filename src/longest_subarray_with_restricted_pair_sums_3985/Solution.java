package longest_subarray_with_restricted_pair_sums_3985;

import java.util.*;
class Solution {
    public int maxSubarray(int[] nums) {
        int ans = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int cnt[] = new int[max + 1];

        int i=0;
        int j=0;

        do{
            cnt[nums[i]]++;

            while(!valid(cnt, nums[i])){
                cnt[nums[j]]--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
            i++;
        }while(i < nums.length);

        return ans;


    }

    private boolean valid(int cnt[], int val){
        for(int i=0;i<cnt.length;i++){
            if(cnt[i] ==0 || (val == i && cnt[i] == 1)){
                continue;
            }

            int next = i + val;
            if(next < cnt.length && cnt[next] > 0){
                return false;
            }

            int prev = Math.abs(val - i);
            if(((prev == i || prev == val) && cnt[prev] > 1) || (prev != i && prev!=val && cnt[prev] > 0)){
                return false;
            }
        }

        return true;
    }
}