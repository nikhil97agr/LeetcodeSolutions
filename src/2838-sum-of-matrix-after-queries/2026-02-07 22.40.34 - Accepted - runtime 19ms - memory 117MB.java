import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long ans = 0;

        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        int rN = n;
        int cN = n;
        int q= queries.length;
        for(int i=q-1;i>=0;i--){
            int type = queries[i][0];
            int ind = queries[i][1];
            int val = queries[i][2];
            
            if(type == 0){
                if(row.contains(ind)) continue;
                row.add(ind);
                ans += 1l*cN*val;
                rN--;
            }else{
                if(col.contains(ind)) continue;
                col.add(ind);
                ans += 1l * rN*val;
                cN--;
            }
        }
        
        return ans;
    }


}