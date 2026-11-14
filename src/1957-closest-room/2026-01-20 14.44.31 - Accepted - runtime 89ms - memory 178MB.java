import java.util.Arrays;
import java.util.TreeSet;

class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int n = rooms.length;
        int q = queries.length;
        int ans[] = new int[q];

        Arrays.fill(ans, -1);
        TreeSet<Integer> set = new TreeSet<>();
        int arr[][] = new int[q][3];
        for(int i=0;i<q;i++){
            arr[i] = new int[]{queries[i][0], queries[i][1], i};
        }

        Arrays.sort(arr, (a,b) -> b[1] - a[1]);
        Arrays.sort(rooms, (a,b) -> b[1] - a[1]);
        int ind = 0;

        for(int a[] : arr){
            int p = a[0];
            int s = a[1];
            int i = a[2];

            while(ind < n && rooms[ind][1] >= s){
                set.add(rooms[ind][0]);
                ind++;
            }

            Integer lower = set.floor(p);
            Integer higher = set.ceiling(p);
            int diff1 = Integer.MAX_VALUE;
            int diff2 = Integer.MAX_VALUE;
            if(higher == null && lower == null) continue;
            if(higher != null){
                diff1 = Math.abs(p - higher);
            }
            
            if(lower != null){
                diff2 = Math.abs(p - lower);
            }
            
            int ansInd = -1;
            
            if(higher == null){
                ansInd= lower;
            }else if(lower == null){
                ansInd = higher;
            }else{
                if(diff2 <= diff1){
                    ansInd = lower;
                }else{
                    ansInd = higher;
                }
            }
            
            ans[i] = ansInd;
            
            
        }
        return ans;
    }
}