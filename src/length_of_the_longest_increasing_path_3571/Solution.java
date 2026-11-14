package length_of_the_longest_increasing_path_3571;

import java.util.*;
class Solution {
    public int maxPathLength(int[][] coordinates, int k) {
        int n = coordinates.length;
        int mid[] = coordinates[k];
        Arrays.sort(coordinates, (a,b)->{
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int c[] : coordinates){
            if(c[0] < mid[0] && c[1] < mid[1]){
                l1.add(c[1]);
            }

            if(c[0] > mid[0] && c[1] > mid[1]){
                l2.add(c[1]);
            }
        }


        return lis(l1) + lis(l2) + 1;

    }

    private int lis(List<Integer> list){
        int dp[] = new int[list.size()];
        int size =0;
        for(int x : list){
            int pos = Arrays.binarySearch(dp, 0, size, x);
            if(pos < 0){
                pos = - pos - 1;
            }

            dp[pos] = x;
            if(pos == size) size++;
        }

        return size;
    }
}