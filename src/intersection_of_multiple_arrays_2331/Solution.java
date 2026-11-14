package intersection_of_multiple_arrays_2331;

import java.util.*;
class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        Set<Integer> set[] = new HashSet[n];
        for(int i=0;i<n;i++){
            set[i] = new HashSet<>();
            for(int x : nums[i]){
                set[i].add(x);
            }
        }
        for(int i=1;i<=1000;i++){
            boolean flag = true;
            for(int j=0;j<n;j++){
                if(!set[j].contains(i)){
                    flag =false;
                    break;
                }
            }
            if(flag) list.add(i);   
        }

        return list;
    }
}