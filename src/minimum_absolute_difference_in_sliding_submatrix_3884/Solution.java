package minimum_absolute_difference_in_sliding_submatrix_3884;

import java.util.*;
class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();

        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0;i+k<=n;i++){
            list.add(new ArrayList<>());
            for(int j=0;j+k<=m;j++){
                TreeSet<Integer> set = new TreeSet<>();
                for(int l=i;l<i+k;l++){
                    for(int o=j;o<j+k;o++){
                        set.add(grid[l][o]);
                    }
                }

                int ans = Integer.MAX_VALUE;
                for(int x : set){
                    Integer next = set.higher(x);
                    if(next!=null){
                        ans = Math.min(ans, next - x);
                    }
                }
                list.get(i).add(ans == Integer.MAX_VALUE ? 0 : ans);
            }
        }
        if(list.isEmpty()){
            return new int[0][0];
        }

        int ans[][] = new int[list.size()][list.get(0).size()];

        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(0).size();j++){
                ans[i][j] = list.get(i).get(j);
            }
        }
        return ans;
    }
}