package minimum_bitwise_or_from_grid_4161;

import java.util.*;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumOR(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        Set<Integer> set[] = new HashSet[n];
        for(int i=0;i<n;i++){
            set[i] =new HashSet<>();
            for(int val: grid[i]){
                set[i].add(val);
            }
        }
        

        for(int bit=30;bit>=0;bit--){
            boolean possible = true;
            Set<Integer> removed[] = new HashSet[n];
            for(int i=0;i<n;i++){
                removed[i] = new HashSet<>();
            }
            for(int i=0; i<n;i++){
                boolean found = false;
                for(int j=0;j<m;j++){
                    int val = grid[i][j];
                    if(!set[i].contains(val)) continue;
                    if((val & (1<<bit)) == 0){
                        found = true;
                    }else{
                        removed[i].add(val);
                    }
                }
                if(!found || set[i].size() == removed[i].size()){
                    possible= false;
                    break;
                }

            }

            if(!possible){
                ans |= (1<<bit);
            }else{
                for(int i=0;i<n;i++){
                    set[i].removeAll(removed[i]);
                }
            }
        }

        return ans;
    }
}