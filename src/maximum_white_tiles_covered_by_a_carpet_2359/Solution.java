package maximum_white_tiles_covered_by_a_carpet_2359;

import java.util.*;
class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a,b) ->{
            return a[0] - b[0];
        });
        int n = tiles.length;
        long pre[] = new long[n];
        pre[0] = tiles[0][1] - tiles[0][0]+1;

        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + tiles[i][1] - tiles[i][0] + 1;
        }

        long ans = 0;

        for(int i=0;i<n;i++){
            int end = tiles[i][0] + carpetLen-1;
            int ind = search(tiles, end, i);
            if(ind == -1){
                ans = Math.max(ans, carpetLen);
            }else{
                long len= pre[ind] - (i ==0 ? 0 : pre[i-1]);
                if(ind + 1 < n && tiles[ind+1][0] <= end){
                    len += end - tiles[ind+1][0]+1;
                }
                ans = Math.max(ans, len);
            }
        }


        return (int)ans;

    }

    private int search(int tiles[][], int val, int start){
        int ind = -1;
        int end = tiles.length - 1;
        while(start <= end){
            int mid = (start + end)/2;

            if(tiles[mid][1] <= val){
                ind = mid;
                start = mid +1;
            }else{
                end = mid - 1;
            }
        }

        return ind;
    }
}