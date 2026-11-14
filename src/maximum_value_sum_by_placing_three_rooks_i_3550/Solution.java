package maximum_value_sum_by_placing_three_rooks_i_3550;

import java.util.*;
class Solution {
    public long maximumValueSum(int[][] board) {
        long ans = Long.MIN_VALUE;
        int n =board.length;
        int m = board[0].length;
        PriorityQueue<int[]> que[] = new PriorityQueue[n];
        for(int i=0;i<n;i++){
            que[i] = new PriorityQueue<>((a,b) -> a[0] - b[0]);

            for(int j=0;j<m;j++){
                que[i].offer(new int[]{board[i][j], i, j});
                if(que[i].size()> 3) que[i].poll();
            }
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int a[] : que[i]){
                        for(int b[] : que[j]){
                            if(a[2] == b[2]) continue;
                            for(int c[] : que[k]){
                                if(c[2] == b[2] || c[2] == a[2]) continue;

                                ans = Math.max(ans, 1l * a[0] + b[0] + c[0]);
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}