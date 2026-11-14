package sort_array_by_parity_ii_958;

import java.util.*;
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        Stack<Integer> even =new Stack<>();
        Stack<Integer> odd =new Stack<>();
        for(int x : nums){
            if(x%2==0) even.push(x);
            else odd.push(x);
        }
        int res[] = new int[nums.length];
        int n = nums.length;

        for(int i=0;i<n;i+=2){
            res[i] = even.pop();
        }

        for(int i=1;i<n;i+=2){
            res[i] = odd.pop();
        }

        return res;
    }

}