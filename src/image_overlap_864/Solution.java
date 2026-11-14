package image_overlap_864;

import java.util.*;
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<Integer> img1Index = new ArrayList<Integer>();
        List<Integer> img2Index = new ArrayList<Integer>();
        for(int i=0;i<n*n;i++){
            if(img1[i/n][i%n]==1){
                img1Index.add(i/n*100+i%n);
            }
        }
        for(int i=0;i<n*n;i++){
            if(img2[i/n][i%n]==1){
                img2Index.add(i/n*100+i%n);
            }
        }
        HashMap<Integer, Integer> map = new HashMap();
        for(int i  : img1Index){
            for(int j : img2Index){
                map.put(i-j, map.getOrDefault(i-j, 0)+1);
            }
        }
        
        int res = 0;
        for(int x : map.values()){
            res = Math.max(x, res);
        }
        return res;
        
        
    }
}