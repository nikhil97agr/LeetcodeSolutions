package minimum_pair_removal_to_sort_array_i_3773;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumPairRemoval(new int[]{2,2,-1,3,-2,2,1,1,1,0,-1}));
    }
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        int ans = 0;
        while(list.size() > 1){
            if(check(list)) return ans;
            int sum = 50000;
            int ind = -1;
            n = list.size()-1;
            for(int i=0;i<n;i++){
                int x = list.get(i);
                int y = list.get(i+1);
                if(x+y < sum){
                    ind = i;
                    sum = x+y;
                }
            }

            list.remove(ind);
            list.remove(ind);
            ans++;

            if (ind == list.size()) {
                list.add(sum);
            }else{
                list.add(ind, sum);
            }



        }

        return ans;
        
    }

    private boolean check(List<Integer> list){
        int n = list.size()-1;
        for(int i=0;i<n;i++){
            int x = list.get(i);
            int y = list.get(i+1);

            if(x > y) return false;

        }

        return true;
    }
}