package circular_array_loop_457;

import java.util.*;
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(check(nums, vis, i, new HashSet<>(), nums[i] > 0)){
                    return true;
                }
            }
        }

        return false;

    }

    private boolean check(int nums[], boolean vis[], int i, Set<Integer> set, boolean isForw){
        if(set.contains(i)) return true;

        if(vis[i]) return false;

        if((isForw && nums[i] < 0) || (!isForw && nums[i] > 0)) return false;

        vis[i]= true;
        set.add(i);
        int next = (i + nums[i]%nums.length + nums.length)%nums.length;
        if(next == i) return false;
        return check(nums, vis, next, set, isForw);
    }
}