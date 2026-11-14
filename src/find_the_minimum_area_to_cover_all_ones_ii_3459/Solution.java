package find_the_minimum_area_to_cover_all_ones_ii_3459;

import java.util.*;
class Solution {
    public int minimumSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int a = minimumArea(grid, 0, 0, i, j);
                if(a == 0) continue;

                int b = minimumArea(grid, 0, j+1, i, m-1);
                int c = minimumArea(grid, i+1, 0, n-1, m-1);
                if(b!=0 && c!=0){
                    ans = Math.min(ans, a+b+c);
                }

                b = minimumArea(grid, 0, j+1, n-1, m-1);
                c = minimumArea(grid, i+1, 0, n-1, j);

                if(b!=0 && c!=0){
                    ans = Math.min(ans, a+b+c);
                }

            }
        }

        for(int i=0;i<n;i++){
            int a = minimumArea(grid, 0,  0, i, m-1);
            if(a==0) continue;

            for(int j=i+1;j<n;j++){
                int b = minimumArea(grid, i+1, 0, j, m-1);
                int c = minimumArea(grid, j+1, 0, n-1, m-1);
                if(b==0 || c==0) continue;
                ans = min(ans, a+b+c);
            }
            for(int j=0;j<m;j++){
                int b = minimumArea(grid, i+1, 0,n-1, j);
                int c = minimumArea(grid, i+1, j+1, n-1, m-1);
                if(b==0 || c==0) continue;
                ans = min(ans, a+b+c);
            }
        }

        for(int i=0;i<m;i++){
            int a = minimumArea(grid, 0, 0, n-1, i);
            if(a==0) continue;
            for(int j=0;j<n;j++){
                int b= minimumArea(grid, 0, i+1, j, m-1);
                int c = minimumArea(grid, j+1, i+1, n-1, m-1);
                if(b==0 || c==0){
                    continue;
                }
                ans = min(ans, a+b+c);
            }

            for(int j=i+1;j<m;j++){
                int b = minimumArea(grid,0, i+1, n-1, j);
                int c = minimumArea(grid, 0, j+1, n-1, m-1);
                if(b==0 || c==0) continue;
                ans = min(ans, a+b+c);
            }
        }


        return ans;
    }


    private int min(int a, int b){
        return Math.min(a,b);
    }

    public int minimumArea(int[][] grid, int si, int sj, int n, int m) {
        List<Integer> list = new ArrayList<>();
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i=si;i<=n;i++){
            int l =-1;
            int r = -1;
            for(int j=sj;j<=m;j++){
                if(grid[i][j] ==1){
                    if(l == -1){
                        l = j;
                    }
                    r = j;
                }
            }
            if(l !=-1){
                list.add(i);
                start = Math.min(start, l);
                end = Math.max(end, r);
            }
        }
        if(list.isEmpty() || start == Integer.MAX_VALUE || end == Integer.MIN_VALUE) return 0;

        return (end - start+1) * (list.get(list.size()-1) - list.get(0)+1);
    }
}