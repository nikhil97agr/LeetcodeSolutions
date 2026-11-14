package choose_numbers_from_two_arrays_in_range_2282;

import java.util.*;
class Solution {
    Map<Integer, Map<Integer, Integer>> dp;
    public int countSubranges(int[] nums1, int[] nums2) {
        int ans = 0;
        int n = nums1.length;
        dp =new HashMap<>();
        for(int i=0;i<n;i++){
            ans = add(ans, solve(i, n, nums1, nums2, 0));
        }

        return ans;
    }

    private int solve(int i, int n, int n1[], int n2[], int sum){
        if(i== n){
            return 0;
        }

        if(dp.getOrDefault(i, new HashMap<>()).containsKey(sum)) return dp.get(i).get(sum);

        int a1 = add((sum + n1[i] == 0 ? 1 : 0) , solve(i+1, n, n1, n2, sum + n1[i]));
        int a2 = add((sum - n2[i] == 0 ? 1 : 0) , solve(i+1, n, n1, n2, sum - n2[i]));
        int ans = add(a1, a2);
        dp.computeIfAbsent(i, x-> new HashMap<>()).put(sum, ans);
        return ans;

    }

    private int add(long a, long b){
        long mod = (long )1e9 + 7;
        return (int)((a+b)%mod);
    }
}