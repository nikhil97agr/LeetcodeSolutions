package count_integers_appearing_in_a_single_block_4410;

import java.util.*;
class Solution {
    public int countSpecialIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean vis[]= new boolean[101];
        int n = nums.length;
        for(int x : nums){
            int cnt = 0;
            int start = -1;
            int end = -1;
            if(vis[x]) continue;
            vis[x]= true;

            for(int i=0;i<n;i++){
                if(nums[i] == x){
                    if(start == -1) start = i;
                    end = i;
                    cnt++;
                }
            }

            if(cnt == end - start + 1){
                set.add(x);
            }
        }

        return set.size();

    }
}