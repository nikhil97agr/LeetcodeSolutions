package maximum_number_of_eaten_apples_1824;

import java.util.*;
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int ans = 0;
        int n = apples.length;
        for(int i=0;i<n;i++){
            if(apples[i] !=0 ){
                que.offer(new int[]{i + days[i], apples[i]});
            }

            while(!que.isEmpty() && que.peek()[0] <= i){
                que.poll();
            }

            if(!que.isEmpty()){
                int prev[] = que.poll();
                ans++;
                if(prev[1] !=1){
                    prev[1]--;
                    que.offer(prev);
                }
            }
        }
        int day = n;
        while(!que.isEmpty()){
            int next[] = que.poll();
            int d = next[0];
            int cnt = next[1];

            if(d <= day){
                continue;
            }

            int c1 = d - day;
            ans += Math.min(c1, cnt);
            day += Math.min(c1, cnt);
        }


        return ans;
    }
}