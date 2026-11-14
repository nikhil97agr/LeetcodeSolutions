package sum_of_subsequence_widths_927;

import java.util.*;
class Solution {
    long mod = (long)1e9 + 7;
    public int sumSubseqWidths(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int val= nums[i];
            int left = i;
            int right = n - i - 1;
            ans = add(ans, prod(val, add(pow(2, left), -1)));
            ans = add(ans, -prod(val, add(pow(2, right), -1)));
        }

        return ans;
    }

    private int pow(int a, int b){
        if(b==0)return 1;
        if(b==1) return prod(a,1);

        int p = pow(a, b/2);
        p = prod(p, p);
        if(b%2==1){
            p = prod(p, a);
        }

        return p;

    }

    private int prod(long a, long b){
        return (int)((a*b)%mod);
    }

    private int add(long a, long b){
        return (int)((a+b+mod)%mod);
    }
}