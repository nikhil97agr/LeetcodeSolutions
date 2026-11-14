package numbers_with_same_consecutive_differences_1007;

import java.util.*;
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> result = new HashSet<>();

        for(int i=1;i<=9;i++){
            solve(i, n, k, 1, result);
        }
        int ans[] =new int[result.size()];
        int ind = 0;
        for(int x : result){
            ans[ind++] = x;
        }
        return ans;
    }

    private void solve(int num, int n, int k, int ind, Set<Integer> result){
        if(ind == n){
            result.add(num);
            return;
        }
        int dig = num%10;
        int left = dig - k;
        int right = dig + k;

        if(left >= 0){
            solve(num*10 + left, n, k, ind+1, result);
        }
        if(right < 10){
            solve(num*10 + right, n, k, ind+1, result);
        }

    }
}