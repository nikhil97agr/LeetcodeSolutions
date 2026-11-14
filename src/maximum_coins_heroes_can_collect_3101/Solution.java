package maximum_coins_heroes_can_collect_3101;

import java.util.*;
class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        int n = heroes.length;
        int m = coins.length;
        long ans[] = new long[n];
        long pre[]= new long[m];
        int monst[][] = new int[m][2];
        for(int i=0;i<m;i++){
            monst[i] = new int[]{monsters[i], coins[i]};
        }

        Arrays.sort(monst, (a,b) -> a[0] - b[0]);
        pre[0] = monst[0][1];
        for(int i=1;i<m;i++){
            pre[i] = pre[i-1] + monst[i][1];
        }
        for(int i=0;i<n;i++){
            int ind = bs(monst, heroes[i]);
            System.out.println(ind);
            if(ind != -1){
                ans[i] = pre[ind];
            }
        }

        return ans;
    }

    private int bs(int m[][], int val){
        int ind = -1;
        int start = 0;
        int end = m.length-1;
        while(start <= end){
            int mid = (start + end)/2;
            if(m[mid][0] <= val){
                ind = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ind;
    }
}