package number_of_unique_xor_triplets_ii_3820;

import java.util.*;
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean vis[] = new boolean[3000];

        for(int x : nums){
            for(int y : nums){
                vis[x ^y] = true;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<vis.length;i++){
            if(vis[i]){
                list.add(i);
            }
        }
        Arrays.fill(vis, false);
        for(int x : list){
            for(int y : nums){
                vis[x ^y] = true;
            }
        }

        int cnt = 0;
        for(boolean x : vis){
            if(x) cnt++;
        }

        return cnt;

        
    }
}