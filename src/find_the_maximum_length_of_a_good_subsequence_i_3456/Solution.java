package find_the_maximum_length_of_a_good_subsequence_i_3456;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    
    class Node{
        int i;
        int j;
        int k;
        
        public Node(int i, int j, int k){
            this.i = i;
            this.j = j;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return i == node.i && j == node.j && k == node.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, k);
        }
    }
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        Integer dp[][] = new Integer[n][k+1];
        int ans = -1;
        
        for(int i=0;i<n;i++){
            ans = Math.max(ans, solve(i, -1, k, nums, n, dp));
            // System.out.println(i+":"+ans);
        }
        return ans;
    }

    private int solve(int i, int j, int k, int nums[], int n, Integer[][] dp){
        if(i==n){
            return 0;
        }
        if(k < 0){
            return 0;
        }
        if(i==n-1) return 1;
        Node node = new Node(i, j, k);
        
        if(dp[i][k]!= null){
             return dp[i][k];
        }
        
        int ans = -1;
        
        for(int l=i+1;l<n;l++){
            if(nums[i] != nums[l]){
                ans = Math.max(ans, 1 + solve(l, i, k-1, nums, n, dp));
            }else{
                ans = Math.max(ans, 1 + solve(l, i, k, nums, n, dp));
            }
        }
        
        return dp[i][k] = ans;
    }
}