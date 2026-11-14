package course_schedule_iii_630;

import java.util.*;
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b)->{
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        PriorityQueue<int[]> que= new PriorityQueue<>((a,b)->{
            return b[0] - a[0];
        });
        int ans = 0;
        int nextStart = 1;
        for(int c[] : courses){
            int lastDay = nextStart + c[0] - 1;
            if(lastDay <= c[1]){
                ans++;
                nextStart = lastDay + 1;
                que.offer(c);
            }else{
                if(!que.isEmpty()){
                    if(que.peek()[0] > c[0]){
                        int prev = que.peek()[0];
                        que.poll();
                        nextStart = lastDay + 1;
                        nextStart -= prev;
                        que.offer(c);
                    }
                }
            }

        }

        return ans;

    }
}