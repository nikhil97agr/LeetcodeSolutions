package maximum_students_taking_exam_1471;

import java.util.*;
class Solution {
    public int maxStudents(char[][] seats) {
        
        int m = seats.length;
        int n = seats[0].length;
        Integer dp[][] = new Integer[m][(1<<n)];
        return solve(0, 0, seats, m, n, dp);

    }


    private int solve(int i, int prevMask, char seats[][], int m, int n, Integer dp[][]){
        if(i == m) return 0;

        if(dp[i][prevMask]!=null) return dp[i][prevMask];

        List<Integer> list = generateMasks(i, prevMask, seats, n);
        int ans = 0;
        for(int mask: list){
            ans = Math.max(ans, Integer.bitCount(mask) + solve(i+1, mask, seats, m, n, dp));
        }

        return dp[i][prevMask] = ans;
    }

    private List<Integer> generateMasks(int row, int prevMask, char seats[][], int m){


        List<Integer> list = new ArrayList<>();

        for(int mask =0;mask < (1<<m);mask++){

            boolean flag= true;
            for(int j=0;j<m;j++){
                if((mask & (1<<j))!=0){
                    if(seats[row][j] == '#'){
                    flag = false;
                    break;
                }

                if(j-1 >=0 && (prevMask & (1<<(j-1)))!=0){
                    flag = false;
                    break;
                }

                if( j+1 < m && (prevMask & (1<<(j+1)))!=0 ){
                    flag = false;
                    break;
                }

                if( j - 1 >=0 && (mask & (1<<(j-1)))!=0){
                    flag = false;
                    break;
                }
                }

            }

            if(flag){
                list.add(mask);
            }
        }

        return list;
    }
}