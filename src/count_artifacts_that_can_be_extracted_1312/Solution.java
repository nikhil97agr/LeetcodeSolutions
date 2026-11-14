package count_artifacts_that_can_be_extracted_1312;

import java.util.*;
class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int d[] : dig){
            map.computeIfAbsent(d[0], x-> new HashSet<>()).add(d[1]);
        }
        int ans = 0;
        for(int a[] : artifacts){
            int r1 = a[0], c1 = a[1], r2 = a[2], c2 = a[3];
            boolean found = true;
            for(int i=r1;i<=r2;i++){
                for(int j=c1;j<=c2;j++){
                    if(!map.containsKey(i) || !map.get(i).contains(j)){
                        found = false;
                        break;
                    }
                }
            }
            if(found) ans++;
        }



return ans;
    }
}