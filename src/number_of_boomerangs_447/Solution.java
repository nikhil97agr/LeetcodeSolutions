package number_of_boomerangs_447;

import java.util.*;
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        int n = points.length;
        for(int i=0;i<n;i++){
            Map<Double, Integer> map = new HashMap<>();
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=0;j<n;j++){
                
                if(i!=j){
                    int x2 = points[j][0];
                    int y2 =points[j][1];
                    double dist = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
                    map.put(dist, map.getOrDefault(dist, 0)+1);
                }
            }
            for(Map.Entry<Double, Integer> entry : map.entrySet()){
                ans += (entry.getValue()*(entry.getValue()-1));
            }
        }
        return ans;
    }
}