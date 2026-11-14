package two_out_of_three_2159;

import java.util.*;
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set[] = new HashSet[101];
        for(int i=0;i<=100;i++){
            set[i] = new HashSet<>();
        }

        for(int x : nums1){
            set[x].add(1);
        }

        for(int x : nums2){
            set[x].add(2);
        }

        for(int x : nums3){
            set[x].add(3);
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<=100;i++){
            if(set[i].size()>1){
                list.add(i);
            }
        }
        return list;

    }
}