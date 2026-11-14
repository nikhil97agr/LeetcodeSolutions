package balanced_k_factor_decomposition_3947;

import java.util.*;
class Solution {
    int ans[];
    int diff = Integer.MAX_VALUE;
    public int[] minDifference(int n, int k) {
        dfs(n, k, 1, new ArrayList<>());

        return ans;
    }

    private void dfs(int n, int k, int start, List<Integer> res){
        if(k == 1){
            if(n >= start){
                res.add(n);
                compute(res);
                res.remove(res.size()-1);
            }
            return ;
        }

        for(int j=start ;j <= n;j++){
            if(n%j==0){
                res.add(j);
                dfs(n/j, k-1, j, res);
                res.remove(res.size() - 1);
            }
        }
    }

    private void compute(List<Integer> res){
        int min = res.stream().min(Integer::compareTo).get();
        int max = res.stream().max(Integer::compareTo).get();

        if(max - min < diff){
            diff = max- min;
            ans = new int[res.size()];
            for(int i=0;i<res.size();i++){
                ans[i] = res.get(i);
            }
        }
    }
}