package maximum_team_size_with_overlapping_intervals_4288;

import java.util.*;
class Solution {
    public int maximumTeamSize(int[] startTime, int[] endTime) {
        var n = startTime.length;
        var pair = new int[n][2];
        for(var i=0;i<n;i++){
            pair[i] = new int[]{startTime[i], endTime[i]};
        }

        Arrays.sort(pair, (a,b) ->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        PriorityQueue<Integer> que= new PriorityQueue<>();
        var ans = 0;
        for(var i=0;i<n;i++){
            var start = pair[i][0];
            var end = pair[i][1];
            while(!que.isEmpty() && que.peek() < start){
                que.poll();
            }
            var l2 = s2(pair, end, i, n-1);

            ans = Math.max(ans, que.size() + l2);
            que.offer(end);
        }

        return ans;
    }

    private int s2(int pair[][], int val, int start, int end){
        int len = 1;
        int s = start;
        while(start <= end){
            int mid = ( start + end)/2;
            if(pair[mid][0] <= val){
                len = mid - s+ 1;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return len;
    }

}