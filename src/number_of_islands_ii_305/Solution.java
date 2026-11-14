package number_of_islands_ii_305;

import java.util.*;
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int par[] = new int[m * n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int v = val(i, j, m, n);
                par[v] = v;
            }

        }
        int cnt = 0;
        Set<Integer> vis = new HashSet<>();
        int diff[] = new int[]{0, 1, 0, -1, 0};
        for(var p: positions){
            int r = p[0];
            int c = p[1];

            int val = val(r, c, m, n);
            if(vis.contains(val)){
                result.add(cnt);
                continue;
            }
            Set<Integer> set = new HashSet<>();
            vis.add(val);
            for(int i=0;i<diff.length - 1;i++){
                int nr = r + diff[i];
                int nc = c + diff[i+ 1];
                if( nr < 0 || nc < 0 || nr >= m || nc >= n){
                    continue;
                }
                int v = val(nr, nc, m, n);
                if(!vis.contains(v)){
                    continue;
                }
                int pp = find(par, v);
                set.add(pp);
            }

            for(int pp : set){
                par[pp] = val;
            }


            if(set.isEmpty()){
                cnt++;
                result.add(cnt);
                continue;
            }

            cnt -= (set.size() - 1);
            
            result.add(cnt);


        }
        return result;
    }

    private int find(int par[], int p){
        if(par[p] == p) return p;

        return par[p] = find(par, par[p]);
    }

    private int val(int i, int j, int m, int n){
        return i * n + j;
    }
}