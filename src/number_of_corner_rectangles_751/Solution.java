package number_of_corner_rectangles_751;

import java.util.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public int countCornerRectangles(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        Set<Integer> set[] = new HashSet[n];
        for(int i=0;i<n;i++) set[i] = new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    set[i].add(j);
                }
            }
        }

        for(int i=0;i<n;i++){

            for(int j=i+1;j<n;j++){
                Set<Integer> s = new HashSet<>(set[i]);
                Iterator<Integer> iterator = s.iterator();
                while(iterator.hasNext()){
                    int next = iterator.next();
                    if(!set[j].contains(next)){
                        iterator.remove();
                    }
                }

                ans += (s.size()*(s.size()-1))/2;
            }
        }

        return ans;
    }
}