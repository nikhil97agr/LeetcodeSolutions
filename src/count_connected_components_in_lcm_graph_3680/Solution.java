package count_connected_components_in_lcm_graph_3680;

import java.util.*;
class Solution {
    public int countComponents(int[] nums, int threshold) {
        int n = nums.length;
        int par[] = new int[threshold + 1];
        for(int i=0;i<par.length;i++){
            par[i] = i;
        }

        for(int i=0;i<n;i++){
            if(nums[i] > threshold) continue;
            int p = find(par, nums[i]);
            for(int j=nums[i];j<=threshold;j+=nums[i]){
                int p2 = find(par, j);
                par[p2] = p;
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(nums[i] <= threshold)
                set.add(find(par, nums[i]));
            else set.add(nums[i]);
        }

        return set.size();


    }

    private int find(int par[], int p){
        if(par[p] == p) return p;

        return par[p] = find(par, par[p]);
    }

}