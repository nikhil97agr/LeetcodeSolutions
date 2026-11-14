import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
                int ans[][] = new int[rows*cols][2];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int d = Math.abs(i - rCenter) + Math.abs(j-cCenter);
                map.computeIfAbsent(d, d1 -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        int ind = 0;
        for(List<int[]> list : map.values()){
            for(int next[] : list){
                ans[ind++]=  next;
            }
        }
        return ans;
    }
}