package sort_even_and_odd_indices_independently_2283;

import java.util.*;
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i%2==0) even.add(nums[i]);
            else odd.add(nums[i]);
        }

        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even);
        int ans[] = new int[nums.length];

        int i=0;
        for(int x : even){
            ans[i] = x;
            i+=2;
        }
        i=1;
        for(int x : odd){
            ans[i] = x;
            i+=2;
        }
        return ans;
    }
}